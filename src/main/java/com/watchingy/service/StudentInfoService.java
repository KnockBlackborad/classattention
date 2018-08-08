package com.watchingy.service;

import com.watchingy.dao.StudentInfoDao;
import com.watchingy.model.StudentInfo;

public class StudentInfoService {

    StudentInfoDao studentInfoDao;

    public void add(StudentInfo studentInfo){
        studentInfoDao.add(studentInfo);
    }


    public String getStudentInfoJsonByClassId(int classId){
        //System.out.println(studentInfoDao.getByClassId(classId).get(0).getAppInfoList().toString());
        return studentInfoDao.getJsonByClassId(classId);
    }

    public String getStudentInfoBySid(int sid){
        return studentInfoDao.getBySid(sid);
    }

}
