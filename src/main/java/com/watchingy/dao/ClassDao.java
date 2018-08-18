package com.watchingy.dao;

import com.watchingy.model.Class;

import java.sql.Timestamp;
import java.util.List;

public interface ClassDao {
    String getUid(String username);
    Class getByUidAndTime(String uid, Timestamp timestamp);
    List<Class> getByUid(String id);
    void add(Class aClass);
    int createClassOrder(String uid);
}
