package com.jxd.mybatisPlus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName: Manager
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/10/30
 * @Version: V1.0
 **/
//创建主管类
@TableName(value = "manager")
public class Manager {
    @TableId(value = "manager_id",type = IdType.AUTO)
    private Integer id;//序号
    @TableField(value = "manager_name")
    private String mName;//主管姓名
    @TableField(value = "dept_no")
    private Integer deptId;//部门序号
    @TableField(value = "flag_deleted")
    private Integer isDeleted;//删除状态：是/1、否/0
    public Manager() {
    }

    public Manager(Integer id, String mName, Integer deptId) {
        this.id = id;
        this.mName = mName;
        this.deptId = deptId;
    }

    public Manager(Integer id, String mName, Integer deptId, Integer isDeleted) {
        this.id = id;
        this.mName = mName;
        this.deptId = deptId;
        this.isDeleted = isDeleted;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public String getmName() {
        return mName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }
}