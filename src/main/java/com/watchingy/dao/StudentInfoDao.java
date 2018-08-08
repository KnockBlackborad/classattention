package com.watchingy.dao;

import com.watchingy.model.StudentInfo;

public interface StudentInfoDao {

    void add(StudentInfo studentInfo);

    String getJsonByClassId(int classId);

    String getBySid(int sid);
}
