package com.jxd.mybatisPlus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.mybatisPlus.model.Teacher;

import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/10/30 10:43
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
public interface ITeacherService extends IService<Teacher> {
    List<Map<String,Object>> getAllTeacherByPage(Integer startIndex, Integer pageSize, String tname);
    List<Map<String,Object>> getAllTeacherByLike(String tname);
    int updateTeacherById(Teacher teacher);
    int deleteTeacherById(Integer id);
    Teacher getTheLastTeacher();//获取教师表中最新增加的教师
}
