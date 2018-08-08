package com.watchingy.service;


import com.watchingy.dao.ClassDao;
import com.watchingy.model.ClassInfo;

import java.sql.Timestamp;
import java.util.List;

public class ClassService {
    ClassDao classDao;
    UserService userService = new UserService();

    public void startClass(ClassInfo classForm) {
        //使用uid以及deteid创建数据库
        classForm.setClassOrder(classDao.createClassOrder(classForm.getUid()));
        classDao.add(classForm);
        ClassInfo classInfo = classDao.getByUidAndTime(classForm.getUid(), classForm.getStartClassTime());
        userService.havingClass(classInfo.getUid(), classInfo.getClassId());
    }

    public List<ClassInfo> getByUid(String uid) {
        return classDao.getByUid(uid);
    }

    public ClassInfo getClassInfo(String uid, Timestamp timestamp) {
        ClassInfo classInfo = classDao.getByUidAndTime(uid, timestamp);
        return classInfo;
    }

}
