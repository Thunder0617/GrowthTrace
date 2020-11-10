package com.jxd.mybatisPlus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.mybatisPlus.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/11/1 13:31
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
public interface IStudentService extends IService<Student> {
    List<Map<String,Object>> getCourseByClass(int classNo,String name,Integer startIndex,Integer pageSize);

    int deleteStudentById(Integer id);

    //    根据班级id、课程id获取学生列表
    List<Map<String,Object>> getTeachStudent( String sName,  Integer classId, Integer courseId);

    Integer getCountTeachStudent(String sName,Integer classId, Integer courseId);
    Integer getStudentCount(Integer classId,String studentName);
    //根据id获取学生基本信息，渲染到评价表
    Map<String,Object> getStudentInfo(Integer sId,Integer periodNo,Integer count);
    //    获取学生被评价次数，用来规避获取信息的periodNo条件超出已评价次数时的情况
    Integer getEvaluationCount(Integer studentId);
    List<Map<String,Object>> getDeptStudentList( Integer deptNo,  Integer startIndex, Integer pageSize,String sName);
    Integer getDeptStudentCount(Integer deptNo,String sName);
    List<Map<String,Object>> getAllEmployeeByPageDeptNo(String eName,Integer startInedx,Integer pageSize,Integer deptNo);
    int getAllEmployeeNumByLike(String eName,Integer deptNo);

    int setStudentDeptNoNull(Integer eid);
}
