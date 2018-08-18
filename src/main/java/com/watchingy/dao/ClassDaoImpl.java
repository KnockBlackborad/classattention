package com.watchingy.dao;

import com.watchingy.model.Class;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.util.List;

public class ClassDaoImpl implements ClassDao {
    private SqlSession sqlSession;

    @Override
    public Class getByUidAndTime(String uid, Timestamp timestamp) {
        //return (ClassInfo) sqlSession.selectOne("com.watchingy.mapper.ClassMapper.getByUidAndTime", uid, timestamp);
        return null;
    }

    @Override
    public List<Class> getByUid(String id) {
        return null;
    }

    @Override
    public void add(Class aClass) {

    }

    @Override
    public int getClassOrder(String uid) {
        return 0;
    }
}
