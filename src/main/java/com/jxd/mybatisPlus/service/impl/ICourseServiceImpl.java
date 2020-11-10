package com.jxd.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.mybatisPlus.mapper.ICourseMapper;
import com.jxd.mybatisPlus.model.Course;
import com.jxd.mybatisPlus.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/10/31 15:16
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
@Service
public class ICourseServiceImpl extends ServiceImpl<ICourseMapper, Course> implements ICourseService {

    @Autowired
    ICourseMapper iCourseMapper;

    @Override
    public List<Map<String,Object>> getCourseByClass(int classNo) {
        return iCourseMapper.getCourseByClass(classNo);
    }
    @Override
    public List<String> getCourseNameByClassNo(int classNo) {
        return iCourseMapper.getCourseNameByClassNo(classNo);
    }
    public List<Map<String, Object>> getAllCourseByPage(Integer startIndex, Integer pageSize, String cname) {
        return iCourseMapper.getAllCourseByPage(startIndex,pageSize,cname);
    }

    @Override
    public List<Map<String, Object>> getAllCourseByLike(String cname) {
        return iCourseMapper.getAllCourseByLike(cname);
    }

    @Override
    public int updateCourseById(Course course) {
        return iCourseMapper.updateCourseById(course);
    }

    @Override
    public int deleteCourseById(Integer id) {
        return iCourseMapper.deleteCourseById(id);
    }
    //    根据班级获取所授课程
    public List<Map<String, Object>> getTeachCourse(Integer startIndex,Integer pageSize,Integer classId,String cName) {
        return iCourseMapper.getTeachCourse(startIndex,pageSize,classId,cName);
    }
    //获取总数
    @Override
    public Integer getCountTeachCourse(Integer classId, String cName) {
        return iCourseMapper.getCountTeachCourse(classId,cName);
    }

    @Override
    public List<Map<String, Object>> getLearnCourses(Integer classId) {
        return iCourseMapper.getLearnCourses(classId);
    }

    @Override
    public List<Integer> getCourses(Integer classNo) {
        return iCourseMapper.getCourses(classNo);
    }

}
