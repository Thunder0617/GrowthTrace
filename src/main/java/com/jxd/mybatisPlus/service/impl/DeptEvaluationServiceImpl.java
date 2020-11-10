package com.jxd.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.mybatisPlus.mapper.IDeptEvaluationMapper;
import com.jxd.mybatisPlus.model.DeptEvaluation;
import com.jxd.mybatisPlus.service.IDeptEvaluationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @date: 2020/11/3
 * @author: Yan XiaoZhi
 */
@Service
public class DeptEvaluationServiceImpl extends ServiceImpl<IDeptEvaluationMapper, DeptEvaluation> implements IDeptEvaluationService {
    @Resource
    IDeptEvaluationMapper iDeptEvaluationMapper;


    public List<Map<String,Object>> getDeptScoreById(Integer studentId,Integer year){
        return iDeptEvaluationMapper.getDeptScoreById(studentId, year);

    }

    @Override
    public Integer getEvaluationCount(Integer sId) {
        return iDeptEvaluationMapper.getEvaluationCount(sId);
    }

}
