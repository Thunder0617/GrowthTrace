package com.jxd.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.mybatisPlus.mapper.ITeacherMapper;
import com.jxd.mybatisPlus.model.Teacher;
import com.jxd.mybatisPlus.service.ITeacherService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/10/30 10:44
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
@Service
public class ITeacherServiceImpl extends ServiceImpl<ITeacherMapper, Teacher> implements ITeacherService {
    @Autowired
    ITeacherMapper iTeacherMapper;

//    public List<Teacher> getTeacherListForPage(int curPage,int pageSize){
//        List<Teacher> list = new ArrayList<>();
//        IPage<Teacher> page = new Page<>(curPage,pageSize);
//        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("flag_deleted",0);
//        page = iTeacherMapper.selectPage(page,queryWrapper);
//        list = page.getRecords();
//        return list;
//    }
//方法2
    @Override
    public List<Map<String, Object>> getAllTeacherByPage(Integer startIndex, Integer pageSize, String tname) {
        return iTeacherMapper.getAllTeacherByPage(startIndex,pageSize,tname);
    }

    @Override
    public List<Map<String, Object>> getAllTeacherByLike(String tname) {
        return iTeacherMapper.getAllTeacherByLike(tname);
    }

    @Override
    public int updateTeacherById(Teacher teacher) {
        return iTeacherMapper.updateTeacherById(teacher);
    }

    @Override
    public int deleteTeacherById(Integer id) {
        return iTeacherMapper.deleteTeacherById(id);
    }

    @Override
    public Teacher getTheLastTeacher() {
        return iTeacherMapper.getTheLastTeacher();
    }

}
