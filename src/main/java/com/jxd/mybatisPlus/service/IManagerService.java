package com.jxd.mybatisPlus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.mybatisPlus.model.Manager;


import java.util.List;
import java.util.Map;

/**
 * @ClassName: IManagerService
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/11/3
 * @Version: V1.0
 **/
public interface IManagerService extends IService<Manager> {
    List<Map<String,Object>> getAllManagerByPage(Integer startIndex, Integer pageSize, String mname, Integer deptNo);
    List<Map<String,Object>> getAllManagerByLike(String mname, Integer deptNo);
    int updateManagerById(Manager manager);
    int deleteManagerById(Integer id);
    Manager getTheLastManager();
}
