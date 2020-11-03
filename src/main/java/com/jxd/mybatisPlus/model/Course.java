package com.jxd.mybatisPlus.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @ClassName: Course
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/10/30
 * @Version: V1.0
 **/
//创建课程类
public class Course {
    @TableId(value = "course_id")
    private Integer Id;//课程序号
    @TableField(value = "course_name")
    private String cName;//课程名
    @TableField(value = "flag_deleted")
    private Integer isDeleted;//是否已被删除：是1/否0

    public Course() {
    }

    public Course(Integer id, String cName, Integer isDeleted) {
        Id = id;
        this.cName = cName;
        this.isDeleted = isDeleted;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return Id;
    }

    public String getcName() {
        return cName;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }
}
