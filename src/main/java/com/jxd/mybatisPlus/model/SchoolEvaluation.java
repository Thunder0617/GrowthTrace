package com.jxd.mybatisPlus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName: SchoolEvaluation
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/10/30
 * @Version: V1.0
 **/
@TableName(value = "evaluation_of_school")
//创建学校评价类
public class SchoolEvaluation {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;//序号
    @TableField(value = "student_id")
    private Integer studentId;//学员id
    @TableField(value = "class_no")
    private Integer classid;//班级期数
    @TableField(value = "teacher_name")
    private String teacherName;//教师姓名
    @TableField(value = "overall_score")
    private Integer overallScore;//整体评价分数
    @TableField(value = "schoolEvaluation")
    private String schoolEvaluation;//学校对学员的评价

    public SchoolEvaluation() {
    }

    public SchoolEvaluation(Integer studentId, Integer classid, String teacherName, Integer overallScore, String schoolEvaluation) {
        this.studentId = studentId;
        this.classid = classid;
        this.teacherName = teacherName;
        this.overallScore = overallScore;
        this.schoolEvaluation = schoolEvaluation;
    }

    public SchoolEvaluation(Integer id, Integer studentId, Integer classid, String teacherName, Integer overallScore, String schoolEvaluation) {
        this.id = id;
        this.studentId = studentId;
        this.classid = classid;
        this.teacherName = teacherName;
        this.overallScore = overallScore;
        this.schoolEvaluation = schoolEvaluation;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setOverallScore(Integer overallScore) {
        this.overallScore = overallScore;
    }

    public void setSchoolEvaluation(String schoolEvaluation) {
        this.schoolEvaluation = schoolEvaluation;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Integer getClassid() {
        return classid;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Integer getOverallScore() {
        return overallScore;
    }

    public String getSchoolEvaluation() {
        return schoolEvaluation;
    }
}
