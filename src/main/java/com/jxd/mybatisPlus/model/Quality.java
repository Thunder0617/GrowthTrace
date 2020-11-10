package com.jxd.mybatisPlus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName: Quality
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/10/30
 * @Version: V1.0
 **/
//创建部门评价指标/品质类
@TableName(value = "quality")
public class Quality {
    @TableId(value = "quality_id",type = IdType.AUTO)
    private Integer id;//序号
    @TableField(value = "quality_name")
    private String qName;//品质名称
    @TableField(value = "isdeleted")
    private int isDeleted;

    public Quality() {
    }

    public Quality(Integer id, String qName) {
        this.id = id;
        this.qName = qName;
    }

    public Quality(Integer id, String qName, int isDeleted) {
        this.id = id;
        this.qName = qName;
        this.isDeleted = isDeleted;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setqName(String qName) {
        this.qName = qName;
    }

    public Integer getId() {
        return id;
    }

    public String getqName() {
        return qName;
    }
}