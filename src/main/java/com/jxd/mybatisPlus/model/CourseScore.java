package com.jxd.mybatisPlus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName: CourseScore
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/10/30
 * @Version: V1.0
 **/
//创建课程得分类
@TableName("course_score")
public class CourseScore {
    @TableId(value = "score_id",type = IdType.AUTO)
    private Integer id;//序号
    @TableField(value = "student_id")
    private Integer studentId;//学员序号i
    @TableField(value = "course_id")
    private Integer courseId;//课程序号
     @TableField(value = "score")
    private Integer score;//得分

    public CourseScore() {
    }

    public CourseScore(Integer id, Integer studentId, Integer courseId, Integer score) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public void setScore(Integer score) {
        this.score = score;
    }



    public Integer getStudentId() {
        return studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public Integer getScore() {
        return score;
    }
}
