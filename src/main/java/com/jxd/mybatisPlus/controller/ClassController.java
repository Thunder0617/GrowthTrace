package com.jxd.mybatisPlus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxd.mybatisPlus.model.Class;
import com.jxd.mybatisPlus.model.Course;
import com.jxd.mybatisPlus.model.SelectedCourse;
import com.jxd.mybatisPlus.service.IClassService;
import com.jxd.mybatisPlus.service.ICourseService;
import com.jxd.mybatisPlus.service.ISelectedCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/10/31 16:07
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */


@Controller
public class ClassController {

    @Autowired
    IClassService iClassService;
    @Autowired
    ISelectedCourseService iSelectedCourseService;
    @Autowired
    ICourseService iCourseService;

    //获取班级列表1231321321321321321322
    @RequestMapping("getClassList")
    @ResponseBody
    public List<Integer> getClassList(){
        List<Integer> list=new ArrayList<>();
        QueryWrapper<Class> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("class_no");
        List<Class> list1 = iClassService.list(queryWrapper);
        for (Class c :list1) {
            list.add(c.getId());
        }
        return  list;
    }

    //获取课程course List+选课
    @RequestMapping("/addClass/{id}/{teacherId}/{course}")
    @ResponseBody
    public int AddClassAndSelectCourse(Class c
            ,@PathVariable(value = "course") String[] course){
        int flag = 0;
        List<Integer> courseId = new ArrayList<>();
        //获取课程列表
        List<Course> list = iCourseService.list();
        for (String course2:course) {
            for (Course course1:list) {
                if(course1.getcName().equals(course2)){
                    courseId.add(course1.getId());
                    break;
                }
            }
        }
        //添加选课
        if(iClassService.save(c)){
            for (Integer cId:courseId) {
                SelectedCourse selectedCourse = new SelectedCourse(cId,c.getId());
                iSelectedCourseService.save(selectedCourse);
            }
            flag = 1;
        }
        return flag;
    }

    /**
     *@Author: zhaowentao
     *@Description:通过班级号获取教师id
     *@Date: 15:59 2020/11/5
     **/
    @RequestMapping("/getTeacherIdByClassNo/{classNo}")
    @ResponseBody
    public int getTeacherIdByClassNo(@PathVariable int classNo){
        Class c =  iClassService.getById(classNo);
        return c.getTeacherId();
    }

    /**
     *@Author: zhaowentao
     *@Description:班级修改
     *@Date: 16:34 2020/11/5
     **/
    @RequestMapping("updateClass/{id}/{teacherId}/{course}")
    @ResponseBody
    public int UpdateClassAndSelectCourse(Class c
            ,@PathVariable(value = "course") String[] course){
        int flag = 0;
        List<Integer> courseId = new ArrayList<>();
        //获取课程列表
        List<Course> list = iCourseService.list();
        for (String course2:course) {
            for (Course course1:list) {
                if(course1.getcName().equals(course2)){
                    courseId.add(course1.getId());
                    break;
                }
            }
        }
        //添加选课
        if(iClassService.updateById(c)){
            QueryWrapper<SelectedCourse> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("class_no",c.getId());
            iSelectedCourseService.remove(queryWrapper);
            for (Integer cId:courseId) {
                SelectedCourse selectedCourse = new SelectedCourse(cId,c.getId());
                iSelectedCourseService.save(selectedCourse);
            }
            flag = 1;
        }
        return flag;
    }
}