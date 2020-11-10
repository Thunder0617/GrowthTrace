package com.jxd.mybatisPlus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.mybatisPlus.model.CourseScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author:liqiaoli
 * @Description:TODO
 * @Date:Created in 17:09 2020/10/31
 * @Modified by:
 */
public interface ICourseScoreService extends IService<CourseScore> {
    //    批量添加学生成绩信息
    Integer addScores(List<CourseScore> list);
//    单插
    Integer addScore(Integer studentId, Integer courseId, Integer score);
    //获取学生整张成绩信息
    List<Map<String,Object>> getStudentScore(Integer classNo, String name, Integer satrtIndex,
                                             Integer pageSize, List<Integer> courseNo);
    //获取单个学生信息
    List<Map<String,Object>> getStudentBysId(Integer sId, Integer classNo, List<Integer> courseNo);


}
