package com.jxd.mybatisPlus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.mybatisPlus.model.UserLogin;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @date: 2020/10/30
 * @author: Yan XiaoZhi
 */
public interface IUserLoginService extends IService<UserLogin> {
//    登录
    UserLogin getLogin(UserLogin userLogin);
//    分页查询
    List<Map<String,Object>> getUserByRole(Integer counts, Integer pageSize, String name, int role);
    List<Map<String,Object>> getAllUserByLike(String name, int role);

}
