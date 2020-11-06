package com.jxd.mybatisPlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.mybatisPlus.model.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IManagerMapper
 * @Description: TODO
 * @Author: 谌勇峰
 * @Date: 2020/11/3
 * @Version: V1.0
 **/
public interface IManagerMapper extends BaseMapper<Manager> {
    List<Map<String,Object>> getAllManagerByPage(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize, @Param("mname") String mname, @Param("deptNo") Integer deptNo);
    List<Map<String,Object>> getAllManagerByLike(@Param("mname") String mname, @Param("deptNo") Integer deptNo);
    int updateManagerById(Manager manager);
    int deleteManagerById(Integer id);
    Manager getTheLastManager();
}
