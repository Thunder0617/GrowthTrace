package com.jxd.mybatisPlus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Description:登录
 * @date: 2020/10/30
 * @author: Yan XiaoZhi
 */
@TableName(value = "userlogin")
public class UserLogin {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    @TableField(value = "name")
    private String name;//用户名
    @TableField(value = "password")
    private String pwd;//密码
    @TableField(value = "role")
    private int role;//登录权限，0为管理员，1为老师，2为项目经理

    public UserLogin() {
    }

    public UserLogin(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public UserLogin(int id, String name, int role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public UserLogin(int id, String name, String pwd, int role) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.role = role;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public int getRole() {
        return role;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
