package com.jxd.mybatisPlus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName: Teacher
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/10/30
 * @Version: V1.0
 **/

//创建教师类
@TableName(value = "teacher")
public class Teacher {
    @TableId(value = "teacher_id",type = IdType.AUTO)
    private Integer id;//教师序号
    @TableField(value = "teacher_name")
    private String tName;//教师姓名
    @TableField(value = "flag_deleted")
    private Integer isDeleted;//是否已被删除：是1/否0
    public Teacher() {
    }
    public Teacher(Integer id, String tName) {
        this.id = id;
        this.tName = tName;
    }

    public Teacher(Integer id, String tName, Integer isDeleted) {
        this.id = id;
        this.tName = tName;
        this.isDeleted = isDeleted;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public String gettName() {
        return tName;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }
}