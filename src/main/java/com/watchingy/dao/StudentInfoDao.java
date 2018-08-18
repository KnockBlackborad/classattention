package com.watchingy.dao;

import com.watchingy.model.StudentAppInfo;

public interface StudentInfoDao {

    void add(StudentAppInfo studentAppInfo);

    String getJsonByClassId(int classId);

    String getBySid(int sid);
}
