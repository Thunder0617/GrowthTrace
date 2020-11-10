package com.jxd.mybatisPlus.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/10/26 16:43
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
@TableName(value = "emplogin")
public class Emp {
    @TableId(value = "name")//@TablefField注解的value对应数据库表的字段
//    name 是属性名, tableid 声明表的主键
    private String name;
    private String password;

    public Emp() {
    }

    public Emp(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
