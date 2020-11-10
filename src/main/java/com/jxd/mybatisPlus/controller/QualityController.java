package com.jxd.mybatisPlus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxd.mybatisPlus.model.Quality;
import com.jxd.mybatisPlus.service.IQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/11/6 14:10
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */

@Controller
public class QualityController  {
    @Autowired
    IQualityService iQualityService;


    /**
     *@Author: zhaowentao
     *@Description:获取品质列表id+名称
     *@Date: 14:12 2020/11/6
     **/
    @RequestMapping("/getQualityList")
    @ResponseBody
    public List<Quality> getQualityList() {
        QueryWrapper<Quality> qualityQueryWrapper = new QueryWrapper<>();
        qualityQueryWrapper.eq("isdeleted",0);
        return iQualityService.list(qualityQueryWrapper);
    }

    /**
     *@Author: zhaowentao
     *@Description:删除品质（假删）
     *@Date: 14:22 2020/11/6
     **/
    @RequestMapping("/deleteQuality/{id}")
    @ResponseBody
    public int deleteQuality(@PathVariable int id){
        int flag = 0;
        Quality quality = new Quality();
        quality.setId(id);
        quality.setIsDeleted(1);
        if(iQualityService.updateById(quality)){
            flag = 1;
        }
        return flag;
    }

    /**
     *@Author: zhaowentao
     *@Description:添加品质
     *@Date: 14:36 2020/11/6
     **/
    @RequestMapping("/addQuality/{qName}")
    @ResponseBody
    public int addQuality(@PathVariable String qName){
        Quality quality = new Quality();
        quality.setqName(qName);
        quality.setIsDeleted(0);
        int flag =0;
        if(iQualityService.save(quality)){
            flag= 1;
        }
        return flag;
    }
}
