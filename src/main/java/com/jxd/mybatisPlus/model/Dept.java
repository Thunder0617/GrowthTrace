package com.jxd.mybatisPlus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName: Dept
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/10/30
 * @Version: V1.0
 **/
//创建部门表
@TableName(value = "dept")
public class Dept {
    @TableId(value = "dept_no",type = IdType.AUTO)
    private Integer id;//部门序号
    @TableField(value = "dept_name")
    private String dName;//部门名称

    public Dept() {
    }

    public Dept(Integer id, String dName) {
        this.id = id;
        this.dName = dName;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
}