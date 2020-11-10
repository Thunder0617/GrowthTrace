package com.jxd.mybatisPlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.mybatisPlus.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/11/1 13:30
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
@Repository
public interface IStudentMapper extends BaseMapper<Student> {
    List<Map<String,Object>> getStudentInfoListByClassNo(@Param("classNo") int classNo);

    List<Map<String,Object>> getStudentInfoListByClassNo2(@Param("classNo") int classNo,@Param("list")List<Integer> list,@Param("list1")List<Integer> list1,@Param("name")String name,@Param("startIndex")Integer startInedx ,@Param("pageSize")Integer pageSize);

    int deleteStudentById(Integer id);
    //    教师授课学生列表及模糊查询
    List<Map<String,Object>> getTeachStudent(@Param("sName") String sName,@Param("classId") Integer classId,
                                             @Param("courseId") Integer courseId);

    Integer getCountTeachStudent( @Param("sName") String sName,@Param("classId") Integer classId,
                                  @Param("courseId") Integer courseId);
    Integer getStudentCount(@Param("classId") Integer classId,@Param("sName") String studentName);

    Map<String,Object> getStudentInfo(@Param("studentId") Integer sId,@Param("periodNo") Integer periodNo,@Param("count") Integer count);

    Integer getEvaluationCount(@Param("studentId") Integer studentId);

    //    部门学生名单及模糊查询
    List<Map<String,Object>> getDeptStudentList(@Param("deptNo") Integer deptNo,@Param("startIndex") Integer startIndex,
                                                @Param("pageSize") Integer pageSize,@Param("sName")String sName);

    Integer getDeptStudentCount(@Param("deptNo") Integer deptNo,@Param("sName") String sName);
    List<Map<String,Object>> getAllEmployeeByPageDeptNo(@Param("eName") String eName, @Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize,@Param("deptNo")Integer deptNo);



    int getAllEmployeeNumByLike(@Param("eName") String eName,@Param("deptNo")Integer deptNo);

    /**
     * @MethodName: setStudentDeptNoNull
     * @Description: 将学生从部门移除
     * @Param[eid]: 学员id
     * @Return: int
     * @Author:谌勇峰
     * @Time:2020/11/9
     **/
    int setStudentDeptNoNull(Integer eid);

}
