package com.jxd.mybatisPlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.mybatisPlus.model.Class;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/10/31 16:07
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
@Repository
public interface IClassMapper extends BaseMapper<Class> {
    //    获取教授的班期
    List<Map<String,Object>> getTeachClass(@Param("startIndex") Integer startIndex,
                                           @Param("pageSize") Integer pageSize,
                                           @Param("teacherId") Integer Id);
    Integer getCountTeachClass(@Param("teacherId") Integer Id);
}
