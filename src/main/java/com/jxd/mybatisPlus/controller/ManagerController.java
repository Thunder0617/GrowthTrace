package com.jxd.mybatisPlus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxd.mybatisPlus.model.Manager;
import com.jxd.mybatisPlus.model.UserLogin;
import com.jxd.mybatisPlus.service.IDeptService;
import com.jxd.mybatisPlus.service.IManagerService;
import com.jxd.mybatisPlus.service.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
    @RequestMapping("/updateManagerById")
    @ResponseBody
    public String updateManagerById(@RequestBody Manager manager){
        String str="修改主管信息失败!";
        int num=iManagerService.updateManagerById(manager);
        if(num!=0){
            //修改主管信息同时在用户表中修改对应信息
            UserLogin userLogin=new UserLogin(manager.getId(),manager.getmName(),2);
            iUserLoginService.updateById(userLogin);
            str="修改主管信息成功!";
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

}