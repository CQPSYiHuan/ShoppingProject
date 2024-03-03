package com.example.studentmanagementsystem.serviceImpl;

import com.example.studentmanagementsystem.bean.StudentInfo;
import com.example.studentmanagementsystem.dao.StuInfoDao;
import com.example.studentmanagementsystem.service.StuInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.thymeleaf.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StuInfoServiceImpl implements StuInfoService {

    @Autowired
    private StuInfoDao stuInfoDao;

    @Override
    public List<StudentInfo> GetStuInfoByStuNO(@RequestBody StudentInfo stuInfo) {
        if(stuInfo == null){
            throw new RuntimeException("请求体为空。");
        }
        List<StudentInfo> stuInfos = stuInfoDao.selectByStuInfo(stuInfo);
        return stuInfos;
    }

    @Override
    public int InsertStuInfo(StudentInfo stuInfo) {
        if(stuInfo.getSchoolId() == null
        || StringUtils.isEmpty(stuInfo.getGender())
        || stuInfo.getStuClass() == null
        || StringUtils.isEmpty(stuInfo.getName())){
            throw new RuntimeException("学生学院id、性别、班级以及姓名必输，请检查");
        }
        String stuNo = GetStuNo(stuInfo);
        stuInfo.setStuNo(stuNo);
        int resNum = stuInfoDao.insert(stuInfo);
        return resNum;
    }

    @Override
    public int ModifyStuInfo(StudentInfo stuInfo) {
        if(stuInfo == null || StringUtils.isEmpty(stuInfo.getStuNo())){
            throw new RuntimeException("学生学号必输，请检查。");
        }
        int resNum = stuInfoDao.modifyByStuInfo(stuInfo);
        return resNum;
    }

    @Override
    public int DeleteStuInfo(StudentInfo stuInfo) {
        if(stuInfo == null){
            throw new RuntimeException("请求体为空，请检查");
        }
        int resNum = stuInfoDao.deleteByStuInfo(stuInfo);
        return resNum;
    }

    private String GetStuNo(StudentInfo studentInfo) {
        StringBuilder stuNo = new StringBuilder(10);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String yaer = sdf.format(new Date());
        stuNo.append(yaer); // 年
        if (studentInfo.getSchoolId() < 10){
            stuNo.append(0);
        }
        stuNo.append(studentInfo.getSchoolId()); // 学院Id
        if (studentInfo.getStuClass() < 10){
            stuNo.append(0);
        }
        stuNo.append(studentInfo.getStuClass()); // 班级Id

        List<StudentInfo> stuList = stuInfoDao.selectByStuInfo(studentInfo);
        if(stuList.size()<10){
            stuNo.append(0);
        }
        stuNo.append(stuList.size()+1); // 班级的排序序号
        return stuNo.toString();
    }
}
