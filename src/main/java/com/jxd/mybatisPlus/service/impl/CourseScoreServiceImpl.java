package com.jxd.mybatisPlus.service.impl;/**
 * @Author:liqiaoli
 * @Description:TODO
 * @Date:Created in 17:10 2020/10/31
 * @Modified by:
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.mybatisPlus.mapper.ICourseScoreMapper;
import com.jxd.mybatisPlus.model.CourseScore;
import com.jxd.mybatisPlus.service.ICourseScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *@Description TODO
 *@author liqiaoli
 *@Date 2020/10/31 17:10
 */
@Service
public class CourseScoreServiceImpl extends ServiceImpl<ICourseScoreMapper, CourseScore> implements ICourseScoreService {
    @Resource
    ICourseScoreMapper iCourseScoreMapper;

    @Override
    public Integer addScores(List<CourseScore> list) {
        return iCourseScoreMapper.addScores(list);
    }

    @Override
    public Integer addScore(Integer studentId, Integer courseId, Integer score) {
        return iCourseScoreMapper.addScore(studentId,courseId,score);
    }

    @Override
    public List<Map<String, Object>> getStudentScore(Integer classNo, String name,Integer satrtIndex,
                                                     Integer pageSize, List<Integer> courseNo) {
        return iCourseScoreMapper.getStudentScore(classNo,name,satrtIndex,pageSize,courseNo);
    }
       //获取单个学生信息
    public  List<Map<String,Object>> getStudentBysId(Integer sId,Integer classNo,List<Integer> courseNo){
        return iCourseScoreMapper.getStudentBysId(sId,classNo,courseNo);
    }

}
