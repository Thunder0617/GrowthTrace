package com.jxd.mybatisPlus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxd.mybatisPlus.model.Student;
import com.jxd.mybatisPlus.service.IStudentService;
import com.jxd.mybatisPlus.service.impl.IStudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/11/1 13:32
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
//@CrossOrigin
@Controller
public class StudentController {
    @Autowired
    IStudentService iStudentService;

    //获取学生信息列表 带模糊查询
    @RequestMapping("getStudentInfoByClass/{classNo}/{name}/{curPage}/{pageSize}")
    @ResponseBody
    public List<Map<String, Object>> getStudentInfoForAllTable(@PathVariable Integer classNo, @PathVariable String name, @PathVariable Integer curPage, @PathVariable Integer pageSize) {
        return iStudentService.getCourseByClass(classNo, name, curPage, pageSize);
    }

    //获取学生信息列表
    @RequestMapping("getStudentInfoByClass/{classNo}/{curPage}/{pageSize}")
    @ResponseBody
    public List<Map<String, Object>> getStudentInfoForAllTabl2e(@PathVariable Integer classNo, @PathVariable Integer curPage, @PathVariable Integer pageSize) {
        return iStudentService.getCourseByClass(classNo, "", curPage, pageSize);
    }

    //获取学生数量
    @RequestMapping("getStudentCountByClass/{classNo}")
    @ResponseBody
    public int getStuCountByClass(@PathVariable Integer classNo) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isdeleted", 0);
        queryWrapper.eq("class_no", classNo);
        return iStudentService.count(queryWrapper);
    }

    //删除学生
    @RequestMapping("deleteStudentById/{id}")
    @ResponseBody
    public int deleteStudentById(@PathVariable Integer id) {
        return iStudentService.deleteStudentById(id);
    }

    //添加学生
    @RequestMapping("addStudent")
    @ResponseBody
    public boolean addStudent(Student student) {
        return iStudentService.save(student);
    }
    @RequestMapping("/getStudentById/{studentId}")
    @ResponseBody
    /**
     * @Descriptnio:根据学生id获取详细信息
     * @Author: Yan XiaoZhi
     * @Date: 2020/11/5 10:23
     * @param studentId:
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     **/
    public Map<String, Object> getStudentById(@PathVariable("studentId") Integer studentId){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id",studentId);
        Map<String, Object> map = iStudentService.getMap(queryWrapper);
        return map;
    }
    /*获取学生信息集合，实现分页*/
    @RequestMapping("/getAllEmployeeByPageDeptNo/{curPage}/{pageSize}/{eName}/{deptNo}")
    @ResponseBody
    public List<Map<String,Object>> getAllEmployeeByPageDeptNo(@PathVariable("curPage")Integer curPage,@PathVariable("pageSize")Integer pageSize,@PathVariable("eName")String eName,@PathVariable("deptNo")Integer deptNo){
        Integer startIndex = (curPage-1)*pageSize;
        List<Map<String,Object>> employeeList=iStudentService.getAllEmployeeByPageDeptNo(eName,startIndex,pageSize,deptNo);
        return employeeList;
    }
    /*获取所有学生信息集合，不分页*/
    @RequestMapping("/getAllEmployeeNumByLike/{eName}/{deptNo}")
    @ResponseBody
    public Integer getAllEmployeeNumByLike(@PathVariable("eName")String eName,@PathVariable("deptNo")Integer deptNo){
        int num=iStudentService.getAllEmployeeNumByLike(eName,deptNo);
        return num;
    }

    /*给学生入职并分配部门*/
    @RequestMapping("/setStudentDeptNoById")
    @ResponseBody
    public String setStudentDeptNoById(@RequestBody Student student){
        String str="分配部门失败！";
        if (iStudentService.updateById(student)){
            str="成功给该学员分配了部门！";
        }
        return str;
    }
    /*修改学生信息*/
    @RequestMapping("/updateStudentById")
    @ResponseBody
    public String updateStudentById( Student student){
        String str="修改失败！";
        if (iStudentService.updateById(student)){
            str="修改成功！";
        }
        return str;
    }
    /*给学生更换部门*/
    @RequestMapping("/changeStudentDeptNoById/{eid}/{ename}/{deptId}")
    @ResponseBody
    public String changeStudentDeptNoById(@PathVariable("eid")Integer eid,
                                          @PathVariable("ename")String ename,
                                          @PathVariable("deptId")Integer deptId){
        Student student=new Student();
        student.setId(eid);
        student.setsName(ename);
        student.setDeptNo(deptId);
        String str="修改失败！";
        if (iStudentService.updateById(student)){
            str="修改成功！";
        }
        return str;
    }
    /*将学员从部门移除*/
    @RequestMapping("/setStudentDeptNoNull/{eid}")
    @ResponseBody
    public String setStudentDeptNoNull(@PathVariable("eid")Integer eid){
        String str="删除失败！";
        int num=iStudentService.setStudentDeptNoNull(eid);
        if (num!=0){
            str="删除成功！";
        }
        return str;
    }
}
