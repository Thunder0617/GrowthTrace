package com.jxd.mybatisPlus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.mybatisPlus.model.Class;

import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/10/31 16:07
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
public interface IClassService extends IService<Class> {
    //   根据教师id获取教授班级
    List<Map<String, Object>> getTeachClass(Integer startIndex, Integer pageSize, Integer tId);
    //获取总数
    Integer getCountTeachClass(Integer tId);
}
