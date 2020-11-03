package com.jxd.mybatisPlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.mybatisPlus.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/10/31 15:15
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
@Repository
public interface ICourseMapper extends BaseMapper<Course> {
    public List<Map<String,Object>> getCourseByClass(int classNo);
    public List<Integer> getSelectedCourseByClassNo(int classNo);
}
