package com.jxd.mybatisPlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.mybatisPlus.model.Quality;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IQuality
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/11/6
 * @Version: V1.0
 **/
public interface IQualityMapper extends BaseMapper<Quality> {
    List<Map<String,Object>> getAllQualityByPage(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize, @Param("qname") String qname);
    List<Map<String,Object>> getAllQualityByLike(@Param("qname") String qname);
    int deleteQualityById(Integer id);
    List<Map<String,Object>> getQuality();

    List<Map<String,Object>> getQualityData(@Param("list") List<Map<String,Object>> quality,@Param("studentId") Integer studentId,@Param("periodNo") Integer periodNo);
}
