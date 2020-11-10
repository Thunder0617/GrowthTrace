package com.jxd.mybatisPlus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.jxd.mybatisPlus.model.CourseScore;
import com.jxd.mybatisPlus.model.SchoolEvaluation;
import com.jxd.mybatisPlus.model.SelectedCourse;
import com.jxd.mybatisPlus.service.ICourseScoreService;
import com.jxd.mybatisPlus.service.ISchoolEvaluationService;
import com.jxd.mybatisPlus.service.ISelectedCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @date: 2020/11/4
 * @author: Yan XiaoZhi
 */
@Controller
public class SchoolEvaluationController {
    @Autowired
    ISchoolEvaluationService iSchoolEvaluationService;
    @Autowired
    ICourseScoreService iCourseScoreService;
    @Autowired
    ISelectedCourseService iSelectedCourseService;

    @RequestMapping("/getHeaderById/{studentId}")
    @ResponseBody
    /**
     * @Descriptnio:根据学生id获取学校评价表的动态表头
     * @Author: Yan XiaoZhi
     * @Date: 2020/11/4 9:49
     * @param studentId:
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    public List<Map<String, Object>> getHeaderById(@PathVariable("studentId") Integer studentId){
        List<Map<String, Object>> scores = iSchoolEvaluationService.getScoreById(studentId);
        List<Map<String,Object>> myHeader = new ArrayList<>();
        int count = 1;
        for ( Map<String,Object> course: scores) {
            Map<String,Object> map = new HashMap<>();
            map.put("label",course.get("courseName"));
            map.put("prop","score"+count++);
            myHeader.add(map);
        }
        return myHeader;
    }

    @RequestMapping("/getScoreById/{studentId}")
    @ResponseBody
    /**
     * @Descriptnio:根据学生id获取学校评价表动态表头下的分数
     * @Author: Yan XiaoZhi
     * @Date: 2020/11/4 9:50
     * @param studentId:
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    public List<Map<String, Object>> getScoreById(@PathVariable("studentId") Integer studentId){
        List<Map<String, Object>> scores = iSchoolEvaluationService.getScoreById(studentId);
        List<Map<String,Object>> myScore = new ArrayList<>();
        int count = 1;
        Map<String,Object> map = new HashMap<>();
        for ( Map<String,Object> course: scores) {
            map.put("score"+count++,course.get("score"));
        }
        myScore.add(map);
        return myScore;
    }

    @RequestMapping("/getSchoolEvaluationId/{studentId}")
    @ResponseBody
    /**
     * @Descriptnio:根据学生id获取学校评价内容
     * @Author: Yan XiaoZhi
     * @Date: 2020/11/4 9:50
     * @param studentId:
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     **/
    public Map<String, Object> getSchoolEvaluationId(@PathVariable("studentId") Integer studentId){
        QueryWrapper<SchoolEvaluation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id",studentId);
        return iSchoolEvaluationService.getMap(queryWrapper);
    }
    /**
     *@Author: zhaowentao
     *@Description:确认能否写学校评价
     *@Date: 16:36 2020/11/8
     **/
    @RequestMapping("/affirmEva/{stuId}/{classNo}")
    @ResponseBody
    public int AffirmEva(@PathVariable int stuId,@PathVariable int classNo){
        int flag = 0;
        QueryWrapper<SelectedCourse> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("class_no",classNo);
        int classCount = iSelectedCourseService.count(queryWrapper1);
        QueryWrapper<CourseScore> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("student_id",stuId);
        int stuCount = iCourseScoreService.count(queryWrapper2);
        if(classCount==stuCount){
            flag = 1;
        }
        return flag;
    }


    /**
     *@Author: zhaowentao
     *@Description:计算学校总评价
     *@Date: 16:09 2020/11/8
     **/
    @RequestMapping("/getAvgEvaByStuIdInSchool/{studentId}/{schoolEvaluation}/{classNo}/{teacherName}")
    @ResponseBody
    public float getAvgEva(@PathVariable Integer studentId,@PathVariable String schoolEvaluation,
                           @PathVariable Integer classNo,@PathVariable String teacherName){
        QueryWrapper<CourseScore> queryWrapper1 =new QueryWrapper<>();
        queryWrapper1.eq("student_id",studentId);
        List<CourseScore> courseScores= iCourseScoreService.list(queryWrapper1);
        int sum = 0;
        for (CourseScore c : courseScores) {
            sum += c.getScore();
        }
        Integer avg = sum/courseScores.size();
        SchoolEvaluation schoolEvaluation1 = new SchoolEvaluation(studentId,classNo,teacherName,avg,schoolEvaluation);
        int flag = 0;
        if(iSchoolEvaluationService.save(schoolEvaluation1)){
            flag = 1;
        }
        return flag;
    }
}
