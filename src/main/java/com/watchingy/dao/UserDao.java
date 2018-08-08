package com.watchingy.dao;

import com.watchingy.model.User;

public interface UserDao {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByPhone(String phone);
    User findByUid(String uid);
    User findByCode(String code);
    void updateState(String uid, boolean state);
    void updateTrueName(String uid, String trueName);
    void updateHavingClass(String uid, int classId);
    void updateSchoolNumber(String uid, String schoolNumber);
    void add(User user);
    User checkPassword(String username, String password);
    String getUid(String username);
}
