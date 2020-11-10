package com.jxd.mybatisPlus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxd.mybatisPlus.model.Manager;
import com.jxd.mybatisPlus.model.UserLogin;
import com.jxd.mybatisPlus.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ManagerController
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/11/3
 * @Version: V1.0
 **/
@Controller
public class ManagerController {
    @Autowired
    @Qualifier("managerServiceImpl")
    IManagerService iManagerService;
    @Autowired
    @Qualifier("userLoginServiceImpl")
    IUserLoginService iUserLoginService;
    @Resource
    IDeptService iDeptService;
    @RequestMapping("/getAllManagerByPage/{curPage}/{pageSize}/{mname}/{deptNo}")
    @ResponseBody
    public List<Map<String,Object>> getAllManagerByPage(@PathVariable("curPage") String curPage, @PathVariable("pageSize")String pageSize, @PathVariable("mname") String mname,@PathVariable("deptNo") String deptNo){
        Integer startIndex = (Integer.parseInt(curPage)-1) * Integer.parseInt(pageSize);
        List<Map<String,Object>> resultValue = iManagerService.getAllManagerByPage(startIndex,Integer.parseInt(pageSize),mname,Integer.parseInt(deptNo));
        return resultValue;
    }
    @RequestMapping("/getAllManagerByLike/{mname}/{deptNo}")
    @ResponseBody
    public List<Map<String,Object>> getAllManagerByLike(@PathVariable("mname")String mname,@PathVariable("deptNo") String deptNo){
        List<Map<String,Object>> managers = iManagerService.getAllManagerByLike(mname,Integer.parseInt(deptNo));
        return managers;
    }
    @RequestMapping("/updateManagerById/{eid}/{ename}")
    @ResponseBody
    public String updateManagerById(@PathVariable("eid")Integer eid,
                                    @PathVariable("ename")String ename){
        Manager manager=new Manager();
        manager.setId(eid);manager.setmName(ename);
        String str="修改失败！";
        if(iManagerService.updateById(manager)){
            //修改主管信息同时在用户表中修改对应信息
            UserLogin userLogin=new UserLogin(manager.getId(),manager.getmName(),2);
            iUserLoginService.updateById(userLogin);
            str="修改成功！";
        }
        return str;
    }
    @RequestMapping("/deleteManagerById/{id}")
    @ResponseBody
    public String deleteManagerById(@PathVariable("id") Integer id){
        String str="删除主管信息失败!";
        int num=iManagerService.deleteManagerById(id);
        if(num!=0){
            //删除主管的同时将该主管从用户表里删除
            iUserLoginService.removeById(id);
            str="删除主管信息成功!";
        }
        return str;
    }

    @RequestMapping("/addManager")
    @ResponseBody
    public String addManager(@RequestBody Manager manager){
        String msg = "添加主管信息失败!";
        if(iManagerService.save(manager)){
            Manager manager1=iManagerService.getTheLastManager();
            UserLogin userLogin=new UserLogin(manager.getId(),manager1.getmName(),"123",2);
            iUserLoginService.save(userLogin);
            msg = "添加主管信息成功!";
        }
        return msg;
    }

    @Resource
    IQualityService iQualityService;
    @Resource
    IStudentService iStudentService;
    //    获取当前部门下的学生列表
    @RequestMapping("/getDeptStudentList/{deptNo}/{curPage}/{pageSize}/{sName}")
    @ResponseBody
    public List<Map<String,Object>> getStudentList(@PathVariable("deptNo") String deptNo,
                                                   @PathVariable("curPage") String curPage,
                                                   @PathVariable("pageSize") String pageSize,
                                                   @PathVariable("sName") String sName){

        Integer dept = Integer.parseInt(deptNo);
        Integer startIndex = (Integer.parseInt(curPage)-1)*Integer.parseInt(pageSize);
        List<Map<String,Object>> list = iStudentService.getDeptStudentList(dept,startIndex,Integer.parseInt(pageSize),sName);
        return list;
    }
    //    获取部门下的学生人数
    @RequestMapping("/getDeptStudentCount/{deptNo}/{sName}")
    @ResponseBody
    public Integer getStudentCount(@PathVariable("deptNo") String deptNo,@PathVariable("sName") String sName){
        Integer dept = Integer.parseInt(deptNo);
        return iStudentService.getDeptStudentCount(dept,sName);
    }



    //获取需要评价的品质列表
    @RequestMapping("/getQuality")
    @ResponseBody
    public List<Map<String,Object>> getQualitys(){
        List<Map<String,Object>> list = iQualityService.getQuality();
        List<Map<String,Object>> list1 = new ArrayList<>();
        int flag =1;
        for(Map<String,Object> quality:list){
            Map<String,Object> map = new HashMap<>();
            map.put("label",quality.get("qualityName"));
            map.put("prop","quality"+(flag++));
            list1.add(map);
        }
        return list1;
    }
    //    获取评价
    @RequestMapping("/getQualityData/{studentId}/{periodNo}")
    @ResponseBody
    public List<Map<String,Object>> getQualityId(@PathVariable("studentId") String studentId,@PathVariable("periodNo") String periodNo){
        List<Map<String,Object>> list = iQualityService.getQuality();;
        List<Map<String,Object>> list1 = iQualityService.getQualityData(list,Integer.parseInt(studentId),Integer.parseInt(periodNo));
        return list1;
    }

    //    获取学生信息
    @RequestMapping("/getStudentInfo/{studentId}/{periodNo}")
    @ResponseBody
    public Map<String,Object> getStudentInfo(@PathVariable("studentId") int studentId,@PathVariable("periodNo") int periodNo){
        Integer sId = studentId;
        Integer periodId = periodNo;
        Integer count = iStudentService.getEvaluationCount(studentId);
        Integer num=1;
//        根据已评价次数确定sql
        if (count <= periodId){
            num = 0;
        }
        Map<String,Object> map = iStudentService.getStudentInfo(sId,periodId,num);
        if (count <= periodId){
            map.put("overallScore","");
            map.put("deptEvaluation","");
        }
        return map;
    }

    //    获取学生已被评价次数
    @RequestMapping("/getEvaluationCount/{studentId}")
    @ResponseBody
    public Integer getEvaluationCount(String sId){
        Integer studentId = Integer.parseInt(sId);
        return studentId;
    }

    //    根据主管获取部门id
    @RequestMapping("/getDeptNoByManager/{uId}")
    @ResponseBody
    public Manager getDeptNoByManager(@PathVariable("uId") Integer uId){
        Manager manager = iManagerService.getById(uId);
        return manager;
    }
}