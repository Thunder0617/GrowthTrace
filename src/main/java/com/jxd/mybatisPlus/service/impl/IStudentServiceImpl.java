package com.jxd.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.mybatisPlus.mapper.ICourseMapper;
import com.jxd.mybatisPlus.mapper.ICourseScoreMapper;
import com.jxd.mybatisPlus.mapper.IEvaluationDeptMapper;
import com.jxd.mybatisPlus.mapper.IStudentMapper;
import com.jxd.mybatisPlus.model.Student;
import com.jxd.mybatisPlus.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/11/1 13:31
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */

@Service
public class IStudentServiceImpl extends ServiceImpl<IStudentMapper, Student> implements IStudentService {

    @Autowired
    IStudentMapper iStudentMapper;

    @Autowired
    ICourseMapper iCourseMapper;
    @Autowired
    ICourseScoreMapper iCourseScoreMapper;
    @Autowired
    IEvaluationDeptMapper iEvaluationDeptMapper;


    public List<Map<String,Object>> getStudentInfoListByClassNo(){
        List<Map<String,Object>> list = null;
        return list;
    }

    @Override
    public List<Map<String, Object>> getCourseByClass(int classNo,String name,Integer curPage,Integer pageSize) {
        List<Integer> selectedCoruse = iCourseMapper.getSelectedCourseByClassNo(classNo);
        Integer startIndex = (curPage-1)*pageSize;
        List<Map<String, Object>> list =iStudentMapper.getStudentInfoListByClassNo2(classNo,selectedCoruse,Arrays.asList(0,1,2,3),name,startIndex,pageSize);
        return list;
    }

    public int deleteStudentById(Integer id){
        return iStudentMapper.deleteStudentById(id);
    }
    //    根据班级id、课程id获取学生列表
    @Override
    public List<Map<String, Object>> getTeachStudent(String sName, Integer classId, Integer courseId) {
        return iStudentMapper.getTeachStudent(sName,classId,courseId);
    }

    @Override
    public Integer getCountTeachStudent(String sName, Integer classId, Integer courseId) {
        return iStudentMapper.getCountTeachStudent(sName,classId,courseId);
    }

    @Override
    public Integer getStudentCount(Integer classId, String studentName) {
        return iStudentMapper.getStudentCount(classId,studentName);
    }
    //获取学生信息
    @Override
    public Map<String, Object> getStudentInfo(Integer sId,Integer period,Integer count) {
        return iStudentMapper.getStudentInfo(sId,period,count);
    }

    @Override
    public Integer getEvaluationCount(Integer studentId) {
        return iStudentMapper.getEvaluationCount(studentId);
    }

    @Override
    public List<Map<String, Object>> getDeptStudentList(Integer deptNo, Integer startIndex, Integer pageSize, String sName) {
        return iStudentMapper.getDeptStudentList(deptNo,startIndex,pageSize,sName);
    }

    @Override
    public Integer getDeptStudentCount(Integer deptNo, String sName) {
        return iStudentMapper.getDeptStudentCount(deptNo,sName);
    }
    @Override
    public List<Map<String,Object>> getAllEmployeeByPageDeptNo(String eName, Integer startIndex, Integer pageSize, Integer deptNo) {
        return iStudentMapper.getAllEmployeeByPageDeptNo(eName,startIndex,pageSize,deptNo);
    }

    @Override
    public int getAllEmployeeNumByLike(String eName, Integer deptNo) {
        return iStudentMapper.getAllEmployeeNumByLike(eName,deptNo);
    }

    @Override
    public int setStudentDeptNoNull(Integer eid) {
        return iStudentMapper.setStudentDeptNoNull(eid);
    }
}
