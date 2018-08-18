package com.watchingy.service;


import com.watchingy.dao.ClassDao;
import com.watchingy.model.Class;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public class ClassService {
    ClassDao classDao;
    UserService userService = new UserService();

    public ClassService() throws IOException {
    }

    public void startClass(Class classForm) {
        //使用uid以及deteid创建数据库
        classForm.setClassOrder(classDao.createClassOrder(classForm.getUid()));
        classDao.add(classForm);
        Class aClass = classDao.getByUidAndTime(classForm.getUid(), classForm.getStartClassTime());
        userService.havingClass(aClass.getUid(), aClass.getClassId());
    }

    public List<Class> getByUid(String uid) {
        return classDao.getByUid(uid);
    }

    public Class getClassInfo(String uid, Timestamp timestamp) {
        Class aClass = classDao.getByUidAndTime(uid, timestamp);
        return aClass;
    }

}
