package com.watchingy.service;

import com.alibaba.fastjson.JSON;
import com.watchingy.dao.StudentAppInfoDao;
import com.watchingy.model.StudentAppInfo;

public class StudentInfoService {

    StudentAppInfoDao studentAppInfoDao;

    public void add(StudentAppInfo studentAppInfo){
        studentAppInfoDao.add(studentAppInfo);
    }


    public String getStudentInfoJsonByClassId(int classId){
        //System.out.println(studentAppInfoDao.getByClassId(classId).get(0).getAppInfoList().toString());
        return JSON.toJSONString(studentAppInfoDao.getByClassId(classId));
    }

    public String getStudentInfoBySid(int sid){
        return JSON.toJSONString(studentAppInfoDao.getBySid(sid));
    }

}
