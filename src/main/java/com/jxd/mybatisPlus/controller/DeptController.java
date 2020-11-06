package com.jxd.mybatisPlus.controller;

import com.jxd.mybatisPlus.model.Dept;
import com.jxd.mybatisPlus.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: DeptController
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/10/31
 * @Version: V1.0
 **/
@Controller
public class DeptController {
    @Autowired
    IDeptService iDeptService;

    @RequestMapping("/getAllDeptByPage/{curPage}/{pageSize}/{dname}")
    @ResponseBody
    public List<Map<String,Object>> getAllDeptByPage(@PathVariable("curPage") String curPage, @PathVariable("pageSize") String pageSize, @PathVariable("dname") String dname){
        Integer startIndex = (Integer.parseInt(curPage)-1) * Integer.parseInt(pageSize);
        List<Map<String,Object>> resultValue = iDeptService.getAllDeptByPage(startIndex,Integer.parseInt(pageSize),dname);
        return resultValue;
    }
    @RequestMapping("/getAllDeptByLike/{dname}")
    @ResponseBody
    public List<Map<String,Object>> getAllDeptByLike(@PathVariable("dname")String dname){
        List<Map<String,Object>> depts = iDeptService.getAllDeptByLike(dname);
        return depts;
    }
    @RequestMapping("/updateDeptById")
    @ResponseBody
    public String updateDeptById(@RequestBody Dept dept){
        String msg = "修改部门失败！";
       int num= iDeptService.updateDeptById(dept);
        if(num!=0){
            msg = "修改部门成功！";
        }
        return msg;
    }
    @RequestMapping("/addDept")
    @ResponseBody
    public String addDept(@RequestBody Dept dept){
        String msg = "添加部门失败！";
        if(iDeptService.save(dept)){
            msg = "添加部门成功！";
        }
        return msg;
    }
    @RequestMapping("/deleteDeptById/{id}")
    @ResponseBody
    public String deleteDeptById(@PathVariable("id") String id){
        String msg = "删除部门失败！";
        int num=iDeptService.deleteDeptById(Integer.parseInt(id));
        if(num!=0){
            msg = "删除部门成功！";
        }
        return msg;
    }
    /*@RequestMapping("/test01")
    @ResponseBody
    public List<Dept> getDept(){
        List<Dept> depts=iDeptService.list();
       return depts;
    }*/
    @RequestMapping("/getAllDepts")
    @ResponseBody
    public List<Dept> getAllDepts()
    {
        List<Dept> depts = iDeptService.list();//给部门主管添加部门选择的下拉框
        return  depts;
    }
}
