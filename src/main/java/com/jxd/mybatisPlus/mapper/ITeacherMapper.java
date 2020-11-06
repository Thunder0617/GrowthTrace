package com.jxd.mybatisPlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.mybatisPlus.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/10/30 10:43
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
@Repository
public interface ITeacherMapper extends BaseMapper<Teacher> {
//    List<Map<String,Object>> getAllTeacher2(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);
//    方法2
    List<Map<String,Object>> getAllTeacherByPage(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize, @Param("tname") String tname);
    List<Map<String,Object>> getAllTeacherByLike(@Param("tname") String tname);
    int updateTeacherById(Teacher teacher);
    int deleteTeacherById(Integer id);
    Teacher getTheLastTeacher();//获取教师表中最新增加的教师
}
