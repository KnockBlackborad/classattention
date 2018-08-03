package com.watchingy.dao;

import com.watchingy.model.ClassInfo;

import java.sql.Timestamp;
import java.util.List;

public interface ClassDao {
    String getUid(String username);
    ClassInfo getByUidAndTime(String uid, Timestamp timestamp);
    List<ClassInfo> getByUid(String id);
    void add(ClassInfo classInfo);
    int createClassOrfer(String uid);
}
