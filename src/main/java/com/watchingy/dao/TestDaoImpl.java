package com.watchingy.dao;

import com.watchingy.model.User;
import org.apache.ibatis.session.SqlSession;

public class TestDaoImpl implements TestDao {
    private SqlSession sqlSession;
    @Override
    public User testSelect(String username) {
        return (User) sqlSession.selectOne("com.watchingy.dao.TestDao.testSelect", username);
    }

    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
}
