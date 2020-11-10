package com.jxd.mybatisPlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.mybatisPlus.model.DeptEvaluation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @date: 2020/11/4
 * @author: Yan XiaoZhi
 */
public interface IDeptEvaluationMapper extends BaseMapper<DeptEvaluation> {
    //    根据学生id和工作时间查询平分项和分数
    List<Map<String,Object>> getDeptScoreById(@Param("studentId") Integer studentId, @Param("year") Integer year);
    //    获取学生已被评价次数
    Integer getEvaluationCount(@Param("studentId") Integer sId);
}
