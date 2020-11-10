package com.jxd.mybatisPlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.mybatisPlus.model.Course;
import org.apache.ibatis.annotations.Param;
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
    List<Map<String,Object>> getCourseByClass(int classNo);
    List<Integer> getSelectedCourseByClassNo(int classNo);
    List<String> getCourseNameByClassNo(int classNo);
    List<Map<String,Object>> getAllCourseByPage(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize, @Param("cname") String cname);
    List<Map<String,Object>> getAllCourseByLike(@Param("cname") String cname);
    int updateCourseById(Course course);
    int deleteCourseById(Integer id);
    //    获取教师所带班级教授的课程
    List<Map<String,Object>> getTeachCourse(@Param("startIndex") Integer startIndex,
                                            @Param("pageSize") Integer pageSize,
                                            @Param("classId") Integer classId,@Param("cName") String cName);
    Integer getCountTeachCourse(@Param("classId") Integer classId,@Param("cName") String cName);
    List<Map<String,Object>> getLearnCourses(@Param("classId") Integer classId);
    List<Integer> getCourses(@Param("classNo") Integer classNo);
}
