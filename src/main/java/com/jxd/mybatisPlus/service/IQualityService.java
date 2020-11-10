package com.jxd.mybatisPlus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.mybatisPlus.model.Quality;


import java.util.List;
import java.util.Map;

/**
 * @ClassName: IQualityService
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/11/6
 * @Version: V1.0
 **/
public interface IQualityService extends IService<Quality> {
    List<Map<String,Object>> getAllQualityByPage(Integer startIndex, Integer pageSize, String qname);
    List<Map<String,Object>> getAllQualityByLike(String qname);
    int deleteQualityById(Integer id);
    List<Map<String,Object>> getQuality();
    List<Map<String,Object>> getQualityData(List<Map<String,Object>> quality,Integer studentId,Integer period);
}
