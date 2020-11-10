package com.jxd.mybatisPlus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.mybatisPlus.model.DeptEvaluation;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @date: 2020/11/3
 * @author: Yan XiaoZhi
 */
public interface IDeptEvaluationService extends IService<DeptEvaluation> {
    List<Map<String,Object>> getDeptScoreById(Integer studentId, Integer year);
//    DeptEvaluation getDeptEvaluation(Integer studentId, Integer year);
//    获取学生已被评价次数
Integer getEvaluationCount(Integer sId);
}
