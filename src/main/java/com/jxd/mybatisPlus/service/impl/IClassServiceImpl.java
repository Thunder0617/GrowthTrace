package com.jxd.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.mybatisPlus.mapper.IClassMapper;
import com.jxd.mybatisPlus.model.Class;
import com.jxd.mybatisPlus.service.IClassService;
import com.jxd.mybatisPlus.service.ICourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/10/31 16:08
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
@Service
public class IClassServiceImpl extends ServiceImpl<IClassMapper, Class> implements IClassService {
    @Resource
    IClassMapper iClassMapper;
    //   根据教师id获取教授班级
    public List<Map<String, Object>> getTeachClass(Integer startIndex, Integer pageSize, Integer tId) {
        return iClassMapper.getTeachClass(startIndex,pageSize,tId);
    }

    @Override
    public Integer getCountTeachClass(Integer tId) {
        return iClassMapper.getCountTeachClass(tId);
    }

}
