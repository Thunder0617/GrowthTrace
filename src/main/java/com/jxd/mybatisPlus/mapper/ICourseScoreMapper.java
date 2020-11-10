package com.jxd.mybatisPlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.mybatisPlus.model.CourseScore;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/11/2 8:51
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */

@Repository
public interface ICourseScoreMapper extends BaseMapper<CourseScore> {

    List<Map<String,Object>> getCourseScore(List<Integer> list);
    //    批量添加学生成绩信息
    Integer addScores(List<CourseScore> list);
    //添加 成绩信息
    Integer addScore(@Param("studentId") Integer studentId,@Param("courseId") Integer courseId,
                     @Param("score") Integer score);
    //获取教授学生信息
    List<Map<String,Object>> getStudentScore(@Param("classNo") Integer classNo, @Param("name") String name,@Param("startIndex")Integer satrtIndex,
                                             @Param("pageSize") Integer pageSize, @Param("list") List<Integer> courseNo);

    //获取单个学生信息
    List<Map<String,Object>> getStudentBysId(@Param("studentId") Integer sId,@Param("classNo") Integer classNo,@Param("list") List<Integer> courseNo);
}
