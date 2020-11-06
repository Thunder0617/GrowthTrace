package com.jxd.mybatisPlus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxd.mybatisPlus.model.Teacher;
import com.jxd.mybatisPlus.model.UserLogin;
import com.jxd.mybatisPlus.service.ITeacherService;
import com.jxd.mybatisPlus.service.IUserLoginService;
import com.jxd.mybatisPlus.service.impl.ITeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
//@CrossOrigin
@Controller
public class TeacherController {
//    @Autowired
//    ITeacherServiceImpl iTeacherService;
    @Autowired
    ITeacherService iTeacherService;
    @Autowired
    IUserLoginService iUserLoginService;
//    //获取教师列表
//    @RequestMapping("/teacherList/{curPage}/{pageSize}")
//    @ResponseBody
//    public List<Map<String,Object>> getAllTeacher(@PathVariable Integer curPage,@PathVariable Integer pageSize){
//        List<Teacher> list ;
//        list=iTeacherService.getTeacherListForPage(curPage,pageSize);
//        List<Map<String,Object>> list1 =new ArrayList<>();
//        for (Teacher teacher:list) {
//            Map<String,Object> map = new HashMap<>();
//            map.put("id",teacher.getId());
//            map.put("name",teacher.gettName());
//            list1.add(map);
//        }
//        return list1;
//    }
//    //获取教师数量（给列表做分页使用）
//    @RequestMapping("/teacherCount")
//    @ResponseBody
//    public int getTeacherCount(){
//        List<Teacher> list ;
//        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("flag_deleted",0);
//        list=iTeacherService.list(queryWrapper);
//        int count = list.size();
//        return count;
//    }
//
//    //教师信息修改(改名字）
//    @RequestMapping("/updateTeacher/{id}/{tName}")
//    @ResponseBody
//    public int updateTeacher(Teacher teacher){
//        int flag = 0;
//        if(iTeacherService.updateById(teacher)){
//            flag = 1;
//        }
//        return flag;
//    }
//
//    //删除教师
//    @RequestMapping("/deleteTeacher/{id}/{isDeleted}")
//    @ResponseBody
//    public int deleteTeacher(Teacher teacher){
//        int flag = 0;
//        if(iTeacherService.updateById(teacher)){
//            flag = 1;
//        }
//        return flag;
//    }
//    //添加教师
//
//    @RequestMapping("/addTeacher/{tName}/{isDeleted}")
//    @ResponseBody
//    public int addTeacher(Teacher teacher){
//        int flag = 0;
//        if(iTeacherService.save(teacher)){
//            flag = 1;
//        }
//        return flag;
//    }


//    方法2
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
}


