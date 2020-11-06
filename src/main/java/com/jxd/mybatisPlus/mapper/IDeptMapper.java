package com.jxd.mybatisPlus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.mybatisPlus.model.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IDeptMapper
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/10/31
 * @Version: V1.0
 **/
public interface IDeptMapper  extends BaseMapper<Dept> {
    List<Map<String,Object>> getAllDeptByPage(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize, @Param("dname") String dname);
    List<Map<String,Object>> getAllDeptByLike(@Param("dname") String dname);
    int updateDeptById(Dept dept);
    int deleteDeptById(Integer id);
    List<String> getAllDepts();
}
