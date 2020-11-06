package com.jxd.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.mybatisPlus.mapper.IManagerMapper;
import com.jxd.mybatisPlus.model.Manager;
import com.jxd.mybatisPlus.service.IManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ManagerServiceImpl
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/11/3
 * @Version: V1.0
 **/
@Service
public class ManagerServiceImpl extends ServiceImpl<IManagerMapper, Manager> implements IManagerService {
   @Resource
    IManagerMapper iManagerMapper;
    @Override
    public List<Map<String, Object>> getAllManagerByPage(Integer startIndex, Integer pageSize, String mname,Integer deptNo) {
        return iManagerMapper.getAllManagerByPage(startIndex,pageSize,mname,deptNo);
    }

    @Override
    public List<Map<String, Object>> getAllManagerByLike(String mname,Integer deptNo) {
        return iManagerMapper.getAllManagerByLike(mname,deptNo);
    }

    @Override
    public int updateManagerById(Manager manager) {
        return iManagerMapper.updateManagerById(manager);
    }

    @Override
    public int deleteManagerById(Integer id) {
        return iManagerMapper.deleteManagerById(id);
    }
    public Manager getTheLastManager(){
        return iManagerMapper.getTheLastManager();
    }
}
