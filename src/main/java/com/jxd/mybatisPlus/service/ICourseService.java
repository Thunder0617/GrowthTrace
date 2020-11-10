package com.jxd.mybatisPlus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.mybatisPlus.model.Course;

import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/10/31 15:16
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
public interface ICourseService extends IService<Course> {
    List<Map<String,Object>> getCourseByClass(int classNo);
    List<String> getCourseNameByClassNo(int classNo);
    List<Map<String,Object>> getAllCourseByPage(Integer startIndex, Integer pageSize, String cname);
    List<Map<String,Object>> getAllCourseByLike(String cname);
    int updateCourseById(Course course);
    int deleteCourseById(Integer id);
    //    分页获取教授的课程及模糊查询
    List<Map<String,Object>> getTeachCourse(Integer startIndex, Integer pageSize,Integer classId,String cName);
    Integer getCountTeachCourse(Integer classId,String cName);
    List<Map<String,Object>> getLearnCourses(Integer classId);
    List<Integer> getCourses(Integer classNo);

}
