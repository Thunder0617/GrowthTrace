package com.jxd.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.mybatisPlus.mapper.IDeptMapper;
import com.jxd.mybatisPlus.model.Dept;
import com.jxd.mybatisPlus.service.IDeptService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DeptServiceImpl
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/10/31
 * @Version: V1.0
 **/
@Service
public class DeptServiceImpl  extends ServiceImpl<IDeptMapper, Dept> implements IDeptService {
    @Resource
    IDeptMapper iDeptMapper;
    @Override
    public List<Map<String, Object>> getAllDeptByPage(Integer startIndex, Integer pageSize, String dname) {
        return iDeptMapper.getAllDeptByPage(startIndex,pageSize,dname);
    }

    @Override
    public List<Map<String, Object>> getAllDeptByLike(String dname) {
        return iDeptMapper.getAllDeptByLike(dname);
    }

    @Override
    public int updateDeptById(Dept dept) {
        return iDeptMapper.updateDeptById(dept);
    }

    @Override
    public int deleteDeptById(Integer id) {
        return iDeptMapper.deleteDeptById(id);
    }

    @Override
    public List<String> getAllDepts() {
        return iDeptMapper.getAllDepts();
    }


}
