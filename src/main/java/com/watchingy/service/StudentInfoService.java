package com.watchingy.service;

import com.watchingy.dao.StudentInfoDao;
import com.watchingy.model.StudentAppInfo;

public class StudentInfoService {

    StudentInfoDao studentInfoDao;

    public void add(StudentAppInfo studentAppInfo){
        studentInfoDao.add(studentAppInfo);
    }


    public String getStudentInfoJsonByClassId(int classId){
        //System.out.println(studentInfoDao.getByClassId(classId).get(0).getAppInfoList().toString());
        return studentInfoDao.getJsonByClassId(classId);
    }

    public String getStudentInfoBySid(int sid){
        return studentInfoDao.getBySid(sid);
    }

}
