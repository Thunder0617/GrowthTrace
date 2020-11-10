package com.jxd.mybatisPlus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @ClassName: Student
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/10/30
 * @Version: V1.0
 **/
//创建学员类
@TableName(value = "student")
public class Student {
    @TableId(value = "student_id",type = IdType.AUTO)
    private Integer id;//学员序号
    @TableField(value = "student_name")
    private String sName;//学员姓名
    @TableField(value = "sex")
    private String sex;//学员性别:男或女
    @TableField(value = "folk")
    private String folk;//民族
    @TableField(value = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthday;//出生日期：yyyy-MM-dd
    @TableField(value = "native_place")
    private String address;//籍贯：省份+城市
    @TableField(value = "marital_status")
    private String marry;//婚姻状态：是或否
    @TableField(value = "phone")
    private String phone;//手机号
    @TableField(value = "id_number")
    private String cardid;//身份证号码
    @TableField(value = "graduate_school")
    private String school;//毕业学校
    @TableField(value = "major")
    private String major;//专业
    @TableField(value = "img_path")
    private String imgPath;//头像途径
    @TableField(value = "remark")
    private String notes;//备注
    @TableField(value = "class_no")
    private Integer classNo;//班期
    @TableField(value = "dept_no")
    private Integer deptNo ;//所属部门号
    @TableField(value = "isdeleted")
    private Integer isDeleted ;//删除状态：是1/否0、
//无参构造方法
    public Student() {
    }

    public Student(Integer id, String sName, String sex, String folk, String birthday, String address, String marry, String cardid, String school, String major,Integer classNo) {
        this.id = id;
        this.sName = sName;
        this.sex = sex;
        this.folk = folk;
        this.birthday = birthday;
        this.address = address;
        this.marry = marry;
        this.cardid = cardid;
        this.school = school;
        this.major = major;
        this.classNo = classNo;
    }

    public Student(Integer id, String sName, String sex, String folk, String birthday, String address, String marry, String phone, String cardid, String school, String major, String imgPath, String notes, Integer classNo, Integer deptNo, Integer isDeleted) {
        this.id = id;
        this.sName = sName;
        this.sex = sex;
        this.folk = folk;
        this.birthday = birthday;
        this.address = address;
        this.marry = marry;
        this.phone = phone;
        this.cardid = cardid;
        this.school = school;
        this.major = major;
        this.imgPath = imgPath;
        this.notes = notes;
        this.classNo = classNo;
        this.deptNo = deptNo;
        this.isDeleted = isDeleted;
    }

    //列表展示学员信息
    public Student(Integer id, String sName, String sex, String address, String school) {
        this.id = id;
        this.sName = sName;
        this.sex = sex;
        this.address = address;
        this.school = school;
    }
//查看学生详细信息或新增学生时
    public Student(String sName, String sex, String folk, String birthday, String address, String marry, String phone, String cardid, String school, String major,String imgPath, String notes) {
        this.sName = sName;
        this.sex = sex;
        this.folk = folk;
        this.birthday = birthday;
        this.address = address;
        this.marry = marry;
        this.phone = phone;
        this.cardid = cardid;
        this.school = school;
        this.major = major;
       this.imgPath=imgPath;
        this.notes = notes;
    }
//添加getter/setter方法

    public void setId(Integer id) {
        this.id = id;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setFolk(String folk) {
        this.folk = folk;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMarry(String marry) {
        this.marry = marry;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public String getsName() {
        return sName;
    }

    public String getSex() {
        return sex;
    }

    public String getFolk() {
        return folk;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getMarry() {
        return marry;
    }

    public String getPhone() {
        return phone;
    }

    public String getCardid() {
        return cardid;
    }

    public String getSchool() {
        return school;
    }

    public String getMajor() {
        return major;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getNotes() {
        return notes;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }
}
