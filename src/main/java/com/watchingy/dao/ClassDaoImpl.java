package com.watchingy.dao;

import com.watchingy.model.ClassInfo;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.util.List;

public class ClassDaoImpl implements ClassDao {
    private SqlSession sqlSession;

    @Override
    public String getUid(String username) {
        return (String) sqlSession.selectOne("com.watchingy.mapper.ClassMapper.getUid", username);
    }

    @Override
    public ClassInfo getByUidAndTime(String uid, Timestamp timestamp) {
        //return (ClassInfo) sqlSession.selectOne("com.watchingy.mapper.ClassMapper.getByUidAndTime", uid, timestamp);
        return null;
    }

    @Override
    public List<ClassInfo> getByUid(String id) {
        return null;
    }

    @Override
    public void add(ClassInfo classInfo) {

    }

    @Override
    public int createClassOrder(String uid) {
        return 0;
    }
}