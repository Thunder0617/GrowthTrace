package com.jxd.mybatisPlus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxd.mybatisPlus.model.Class;
import com.jxd.mybatisPlus.model.Course;
import com.jxd.mybatisPlus.model.SelectedCourse;
import com.jxd.mybatisPlus.model.Teacher;
import com.jxd.mybatisPlus.service.ICourseService;
import com.jxd.mybatisPlus.service.ISelectedCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/10/31 15:18
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */

@Controller
public class CourseController {
    @Autowired
    ICourseService iCourseService;


    //获取课程名列表list
    @RequestMapping("/getCourseForStudentTable")
    @ResponseBody
    public List<String> getCourseForStudentTable(){
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("flag_deleted",0);
        List<Course> list = iCourseService.list(queryWrapper);
//        int flag = 1;
//        List<Map<String,Object>> mapList = new ArrayList<>();
//        for ( Course course: list) {
//            Map<String,Object> map = new HashMap<>();
//            map.put("label",course.getcName());
//            map.put("prop","score"+(++flag));
//            mapList.add(map);
//        }
        List<String> courses = new ArrayList<>();
        for (Course c :list) {
            courses.add(c.getcName());
        }
        return courses;
    }

    //获取表头label + prop
    @RequestMapping("/getCourseByClass/{classNum}")
    @ResponseBody
    public List<Map<String,Object>> getCourseForStudentTable(@PathVariable int classNum){
        //获取label数据
        List<Map<String,Object>> list = iCourseService.getCourseByClass(classNum);
        //创建空list存放待发送数据
        List<Map<String,Object>> mapList = new ArrayList<>();
        //设置名称标志位
        int flag = 0;
        //遍历获取的label 数据
        //创建map对象，并将label与prop添加到map对象
        //label对应数据库里的课程名称
        //prop对应数据为 score(数字) 例:score1、score2
        for ( Map<String,Object> course: list) {
            Map<String,Object> map = new HashMap<>();
            map.put("label",course.get("courseName"));
            map.put("prop","score"+flag++);
            mapList.add(map);
        }
        return mapList;
    }

    /**
     *@Author: zhaowentao
     *@Description:获取班级所选课程
     *@Date: 16:09 2020/11/5
     **/
    @RequestMapping("/getSelectCourseByClassNo/{classNo}")
    @ResponseBody
    public List<String> getSelectCourseListByClassNo(@PathVariable int classNo){
        List<String> list= iCourseService.getCourseNameByClassNo(classNo);
        return list;
    }
    @RequestMapping("/getAllCourseByPage/{curPage}/{pageSize}/{cname}")
    @ResponseBody
    public List<Map<String,Object>> getAllCourseByPage(@PathVariable("curPage") String curPage, @PathVariable("pageSize") String pageSize, @PathVariable("cname") String cname){
        Integer startIndex = (Integer.parseInt(curPage)-1) * Integer.parseInt(pageSize);
        List<Map<String,Object>> resultValue = iCourseService.getAllCourseByPage(startIndex,Integer.parseInt(pageSize),cname);
        return resultValue;
    }
    @RequestMapping("/getAllCourseByLike/{cname}")
    @ResponseBody
    public List<Map<String,Object>> getAllCourseByLike(@PathVariable("cname")String cname){
        List<Map<String,Object>> courses = iCourseService.getAllCourseByLike(cname);
        return courses;
    }
    @RequestMapping("/updateCourseById")
    @ResponseBody
    public String updateCourseById(@RequestBody Course course){
        String msg = "修改课程失败！";
        int num= iCourseService.updateCourseById(course);
        if(num!=0){
            msg = "修改课程成功！";
        }
        return msg;
    }
    @RequestMapping("/addCourse")
    @ResponseBody
    public String addCourse(@RequestBody Course course){
        String msg = "添加课程失败！";
        if(iCourseService.save(course)){
            msg = "添加课程成功！";
        }
        return msg;
    }
    @RequestMapping("/deleteCourseById/{id}")
    @ResponseBody
    public String deleteCourseById(@PathVariable("id") String id){
        String msg = "删除课程失败！";
        int num=iCourseService.deleteCourseById(Integer.parseInt(id));
        if(num!=0){
            msg = "删除课程成功！";
        }
        return msg;
    }
}