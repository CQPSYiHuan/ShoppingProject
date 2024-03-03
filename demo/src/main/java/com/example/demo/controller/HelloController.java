package com.example.studentmanagementsystem.controller;


import com.example.studentmanagementsystem.bean.StudentInfo;
import com.example.studentmanagementsystem.service.StuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    StuInfoService stuInfoService;

    @RequestMapping(value = "/GetStuInfo",method = RequestMethod.POST)
    @ResponseBody
    public List<StudentInfo> GetStuInfo(@RequestBody StudentInfo studentInfo){
        List<StudentInfo> stuInfos = stuInfoService.GetStuInfoByStuNO(studentInfo);
        System.out.println(stuInfos.get(0).getName());
        return stuInfos;
    }

    @RequestMapping(value = "/InsertStuInfo",method = RequestMethod.POST)
    @ResponseBody
    public int InsertStuInfo(@RequestBody StudentInfo studentInfo){
        int resNum = stuInfoService.InsertStuInfo(studentInfo);
        return resNum;
    }

    @RequestMapping(value = "/DeleteByStuInfo",method = RequestMethod.POST)
    @ResponseBody
    public int DeleteByStuInfo(@RequestBody StudentInfo studentInfo){
        int resNum = stuInfoService.DeleteStuInfo(studentInfo);
        return resNum;
    }

    @RequestMapping(value = "/ModifyStuInfo",method = RequestMethod.POST)
    @ResponseBody
    public int ModifyStuInfo(@RequestBody StudentInfo studentInfo){
        int resNum = stuInfoService.ModifyStuInfo(studentInfo);
        return resNum;
    }
}
