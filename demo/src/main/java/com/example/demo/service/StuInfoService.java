package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.bean.StudentInfo;

import java.util.List;

public interface StuInfoService {

    /**
     * @description 获取学生信息
     * @param stuNo
     * @return
     */
    public List<StudentInfo> GetStuInfoByStuNO(StudentInfo stuNo);

    public int InsertStuInfo(StudentInfo stuNo);

    public int ModifyStuInfo(StudentInfo stuNo);

    public int DeleteStuInfo(StudentInfo stuNo);
}
