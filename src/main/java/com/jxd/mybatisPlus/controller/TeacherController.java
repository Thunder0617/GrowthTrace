package com.jxd.mybatisPlus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxd.mybatisPlus.model.CourseScore;
import com.jxd.mybatisPlus.model.Teacher;
import com.jxd.mybatisPlus.model.UserLogin;
import com.jxd.mybatisPlus.service.*;
import com.jxd.mybatisPlus.service.impl.ITeacherServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/10/30 10:40
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
@CrossOrigin
@Controller
public class TeacherController {

    @Autowired
    ITeacherService iTeacherService;
    @Autowired
    IUserLoginService iUserLoginService;
    @Resource
    IClassService iClassService;
    @Resource
    ICourseScoreService iCourseScoreService;
    @Resource
    ICourseService iCourseService;

@RequestMapping("/getAllTeacherByPage/{curPage}/{pageSize}/{tname}")
@ResponseBody
public List<Map<String,Object>> getAllTeacherByPage(@PathVariable("curPage") String curPage, @PathVariable("pageSize") String pageSize, @PathVariable("tname") String tname){
    Integer startIndex = (Integer.parseInt(curPage)-1) * Integer.parseInt(pageSize);
    List<Map<String,Object>> resultValue = iTeacherService.getAllTeacherByPage(startIndex,Integer.parseInt(pageSize),tname);
    return resultValue;
}
    @RequestMapping("/getAllTeacherByLike/{tname}")
    @ResponseBody
    public List<Map<String,Object>> getAllTeacherByLike(@PathVariable("tname")String tname){
        List<Map<String,Object>> teachers = iTeacherService.getAllTeacherByLike(tname);
        return teachers;
    }
    @RequestMapping("/updateTeacherById")
    @ResponseBody
    public String updateTeacherById(@RequestBody Teacher teacher){
        String msg = "修改失败!";
        int num= iTeacherService.updateTeacherById(teacher);
        if(num!=0){
            //修改教师信息同时在用户表中修改对应信息
            UserLogin userLogin=new UserLogin(teacher.getId(),teacher.gettName(),1);
            iUserLoginService.updateById(userLogin);
            msg = "修改成功!";
        }
        return msg;
    }
    @RequestMapping("/addTeacher")
    @ResponseBody
    public String addTeacher(@RequestBody Teacher teacher){
        String msg = "添加失败!";
        boolean flag=iTeacherService.save(teacher);
        if(flag){
            //新增教师的同时将该教师添加到用户表
            msg = "添加成功!";
            Teacher teacher1=iTeacherService.getTheLastTeacher();
            UserLogin userLogin=new UserLogin(teacher1.getId(),teacher1.gettName(),"123",1);
            iUserLoginService.save(userLogin);
        }
        return msg;
    }
    @RequestMapping("/deleteTeacherById/{id}")
    @ResponseBody
    public String deleteTeacherById(@PathVariable("id") String id){
        String msg = "删除失败!";
        int num=iTeacherService.deleteTeacherById(Integer.parseInt(id));
        if(num!=0){
            //删除教师的同时将该教师从用户表里删除
            iUserLoginService.removeById(id);
            msg = "删除成功!";
        }
        return msg;
    }

    //    获取教师教授的班级
    @RequestMapping("/teachClassList/{curPage}/{pageSize}/{tId}")
    @ResponseBody
    public List<Map<String,Object>>  teachClass(@PathVariable("tId") String tId,
                                                @PathVariable("curPage") String curPage,
                                                @PathVariable("pageSize") String pageSize){

        Integer teacherId = Integer.parseInt(tId);
        Integer startIndex = (Integer.parseInt(curPage)-1)*(Integer.parseInt(pageSize));
        Integer limit = Integer.parseInt(pageSize);
        List<Map<String,Object>> list = iClassService.getTeachClass(startIndex,limit,teacherId);
        return list;
    }

    //    获取授课的班级总数
    @RequestMapping("/getClassTotalCount/{tId}")
    @ResponseBody
    public Integer getClassTotalCount(@PathVariable("tId") String tId){
        Integer teacherId = Integer.parseInt(tId);
        Integer count = iClassService.getCountTeachClass(teacherId);
        return count;
    }


    //    获取班级教授的课程以及模糊查询
    @RequestMapping("/teachCourseList/{curPage}/{pageSize}/{classId}/{cName}")
    @ResponseBody
    public List<Map<String,Object>>  teachCourse(@PathVariable("curPage") String curPage,
                                                 @PathVariable("pageSize") String pageSize,
                                                 @PathVariable("classId") String cId,
                                                 @PathVariable("cName") String cName) {
        Integer classId = Integer.parseInt(cId);
        Integer startIndex = (Integer.parseInt(curPage)-1)*(Integer.parseInt(pageSize));
        Integer limit = Integer.parseInt(pageSize);
        return iCourseService.getTeachCourse(startIndex,limit,classId,cName);
    }
    //    获取授课总数
    @RequestMapping("/getCourseTotalCount/{classId}/{cName}")
    @ResponseBody
    public Integer getCourseTotalCount(@PathVariable("classId") String cId,
                                       @PathVariable("cName") String cName){
        Integer classId = Integer.parseInt(cId);
        Integer count =iCourseService.getCountTeachCourse(classId,cName);
        return count;
    }
    @Resource
    IStudentService iStudentService;
    //    分页获取班期学员及模糊查询
    @RequestMapping("/teachStudentList/{classId}/{sName}/{courseId}")
    @ResponseBody
    public List<Map<String,Object>> getTeachStudent(@PathVariable("classId") String clId,
                                                    @PathVariable("sName") String sName,
                                                    @PathVariable("courseId") String coId){
        Integer courseId = Integer.parseInt(coId);

        Integer classId = Integer.parseInt(clId);
        List<Map<String,Object>> list = iStudentService.getTeachStudent(sName,classId,courseId);
        /*for (Map<String,Object> map:list) {
            map.put("score",null);
        }*/
        return list;
    }
    //获取班级总人数
    @RequestMapping("/getStudentTotalCount/{classId}/{sName}/{courseId}")
    @ResponseBody
    public Integer getStudentTotalCount(@PathVariable("classId") String clId,
                                        @PathVariable("sName") String sName,
                                        @PathVariable("courseId") String coId){
        Integer classId = Integer.parseInt(clId);
        Integer courseId = Integer.parseInt(coId);
        Integer count = iStudentService.getCountTeachStudent(sName,classId,courseId);
        return count;
    }


    //  单个打分
    @RequestMapping("/giveScore/{score}/{courseId}/{studentId}")
    @ResponseBody
    public String giveScore(@PathVariable("score") String Score,
                            @PathVariable("courseId") String CourseId,
                            @PathVariable("studentId") String sId){
        String str = "fail";
        Integer score = Integer.parseInt(Score) ;
        Integer courseId = Integer.parseInt(CourseId);
        Integer studentId = Integer.parseInt(sId);

        if(iCourseScoreService.addScore(studentId,courseId,score)>0){
            str = "success";
        }
        return str;
    }
    //  批量打分
    @RequestMapping("/giveScores")
    @ResponseBody
    public Integer giveScores(@RequestBody  String scores) {
        List<CourseScore> list =  com.alibaba.fastjson.JSONObject.parseArray(scores,CourseScore.class);
        Integer str = 0;
        System.out.println(list);
        Integer num =iCourseScoreService.addScores(list);
        if(num>0){
            str = num ;
        }
        return str;
    }
    //    获取学习课程表头
    @RequestMapping("/learnCourses/{classId}")
    @ResponseBody
    public List<Map<String,Object>> getLearnCourses(@PathVariable("classId")String cId){
        Integer classId = Integer.parseInt(cId);
        List<Map<String,Object>> list = iCourseService.getLearnCourses(classId);
        List<Map<String,Object>> list1 = new ArrayList<>();
        int flag = 1;
        for ( Map<String,Object> course: list) {
            Map<String,Object> map = new HashMap<>();
            map.put("label",course.get("courseName"));
            map.put("prop","score"+flag++);
            list1.add(map);
        }
        return list1;
    }
    //获取学生成绩信息
    @RequestMapping("/getStudentsInfo/{classId}/{sName}/{pageSize}/{curPage}")
    @ResponseBody
    public List<Map<String,Object>> getStudentsInfoFirst(@Param("classId") String cId,
                                                         @Param("pageSize") String pageSize,@Param("curPage") String curPage,
                                                         @PathVariable("sName")String sName){
        Integer startIndex = (Integer.parseInt(curPage)-1)*(Integer.parseInt(pageSize));
        Integer limit = Integer.parseInt(pageSize);
        Integer classId = Integer.parseInt(cId);
        List<Integer> courses = iCourseService.getCourses(classId);
        List<Map<String,Object>> list = iCourseScoreService.getStudentScore(classId,sName,startIndex,limit,courses);
        return list;
    }
    //成绩表获取学生人数
    @RequestMapping("/getStudentsInfo/{classId}/{sName}")
    @ResponseBody
    public Integer getStudentCount(@Param("classId") String cId, @Param("sName") String sName){
        Integer classId = Integer.parseInt(cId);
        return iStudentService.getStudentCount(classId,sName);
    }

    //获取学生单人成绩信息
    @RequestMapping("/getStudentBysId/{studentId}/{classId}")
    @ResponseBody
    public List<Map<String,Object>> getStudentBysId(@Param("studentId") String sId,@Param("classId") String cId){
        Integer studentId = Integer.parseInt(sId);
        Integer classId = Integer.parseInt(cId);
        List<Integer> courses = iCourseService.getCourses(classId);
        List<Map<String,Object>> list = iCourseScoreService.getStudentBysId(studentId,classId,courses);
        return list;
    }
}


