package com.jxd.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.mybatisPlus.mapper.IUserLoginMapper;
import com.jxd.mybatisPlus.model.UserLogin;
import com.jxd.mybatisPlus.service.IUserLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @date: 2020/10/30
 * @author: Yan XiaoZhi
 */
@Service
public class UserLoginServiceImpl extends ServiceImpl<IUserLoginMapper, UserLogin> implements IUserLoginService {

    @Resource
    IUserLoginMapper iUserLoginMapper;

    public UserLogin getLogin(UserLogin userLogin){
        return iUserLoginMapper.getLogin(userLogin);
    }
    public List<Map<String,Object>> getUserByRole(Integer counts, Integer pageSize, String name, int role){
        return iUserLoginMapper.getUserByRole(counts, pageSize, name, role);
    }
    public List<Map<String,Object>> getAllUserByLike(String name, int role){
        return iUserLoginMapper.getAllUserByLike(name,role);
    }

}
