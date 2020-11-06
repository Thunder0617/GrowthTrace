package com.jxd.mybatisPlus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.mybatisPlus.model.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IDeptService
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/10/31
 * @Version: V1.0
 **/
public interface IDeptService extends IService<Dept> {
    List<Map<String,Object>> getAllDeptByPage(Integer startIndex, Integer pageSize, String dname);
    List<Map<String,Object>> getAllDeptByLike(String dname);
    int updateDeptById(Dept dept);
    int deleteDeptById(Integer id);
    List<String> getAllDepts();
}
