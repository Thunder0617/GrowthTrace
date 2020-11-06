package com.jxd.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.mybatisPlus.mapper.IQualityMapper;
import com.jxd.mybatisPlus.model.Quality;
import com.jxd.mybatisPlus.service.IQualityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: QualityServiceImpl
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/11/6
 * @Version: V1.0
 **/
@Service
public class QualityServiceImpl extends ServiceImpl<IQualityMapper, Quality> implements IQualityService {
    @Resource
    IQualityMapper iQualityMapper;
    @Override
    public List<Map<String, Object>> getAllQualityByPage(Integer startIndex, Integer pageSize, String qname) {
        return iQualityMapper.getAllQualityByPage(startIndex,pageSize,qname);
    }

    @Override
    public List<Map<String, Object>> getAllQualityByLike(String qname) {
        return iQualityMapper.getAllQualityByLike(qname);
    }

    @Override
    public int deleteQualityById(Integer id) {
        return iQualityMapper.deleteQualityById(id);
    }
}
