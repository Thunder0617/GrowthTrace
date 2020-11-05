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
}
