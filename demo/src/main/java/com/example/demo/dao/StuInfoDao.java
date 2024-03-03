package com.example.studentmanagementsystem.dao;

import com.example.studentmanagementsystem.bean.StudentInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuInfoDao {
    /**
     * @decription 根据学号查询学生详细信息
     * @param stuInfo
     * @return
     */
    List<StudentInfo> selectByStuInfo(StudentInfo stuInfo);

    int deleteByStuInfo(StudentInfo stuInfo);

    int insert(StudentInfo studentInfo);

    int modifyByStuInfo(StudentInfo studentInfo);

    int insertBatch(List<StudentInfo> studentInfos);

}
