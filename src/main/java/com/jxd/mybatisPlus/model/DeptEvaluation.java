package com.jxd.mybatisPlus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName: DeptEvaluation
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/10/30
 * @Version: V1.0
 **/
//创建部门评价类
@TableName(value = "evaluation_of_dept")
public class DeptEvaluation {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer Id;//序号
    @TableField(value = "student_id")
    private Integer studentId;//学员id
    @TableField(value = "dept_name")
    private String deptName;//部门名称
    @TableField(value = "job")
    private String job;//员工职务
    @TableField(value = "manager_name")
    private String managerName;//主管姓名
    @TableField(value = "overall_score")
    private Integer overallScore;//整体评价分数
    @TableField(value = "evaluation_form_dept")
    private String deptEvaluation;//部门对员工的评价
     @TableField(value = "period_no")
    private Integer year;//工作几年了

    public DeptEvaluation() {
    }

    public DeptEvaluation(Integer id, Integer studentId, String deptName, String job, String managerName, Integer overallScore, String deptEvaluation, Integer year) {
        Id = id;
        this.studentId = studentId;
        this.deptName = deptName;
        this.job = job;
        this.managerName = managerName;
        this.overallScore = overallScore;
        this.deptEvaluation = deptEvaluation;
        this.year = year;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setOverallScore(Integer overallScore) {
        this.overallScore = overallScore;
    }

    public void setDeptEvaluation(String deptEvaluation) {
        this.deptEvaluation = deptEvaluation;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getId() {
        return Id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getJob() {
        return job;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Integer getOverallScore() {
        return overallScore;
    }

    public String getDeptEvaluation() {
        return deptEvaluation;
    }

    public Integer getYear() {
        return year;
    }
}
