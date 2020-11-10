package com.jxd.mybatisPlus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName: QualityScore
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/10/30
 * @Version: V1.0
 **/
@TableName("quality_score")
public class QualityScore {
    @TableId(value = "score_id",type = IdType.AUTO)
    private Integer id;//序号
    @TableField(value = "quality_id")
    private Integer qualityId;//品质序号
    @TableField(value = "student_id")
    private Integer studentId;//学生序号
    @TableField(value = "score")
    private Integer score;//得分
    @TableField(value = "period_no")
    private Integer year;//工作几年了

    public QualityScore() {
    }

    public QualityScore(Integer id, Integer qualityId, Integer studentId, Integer score, Integer year) {
        this.id = id;
        this.qualityId = qualityId;
        this.studentId = studentId;
        this.score = score;
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQualityId(Integer qualityId) {
        this.qualityId = qualityId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public Integer getQualityId() {
        return qualityId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Integer getScore() {
        return score;
    }
}
