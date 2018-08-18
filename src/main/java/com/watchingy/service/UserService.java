package com.watchingy.service;

import com.watchingy.dao.UserInfoDao;
import com.watchingy.exception.UserException;
import com.watchingy.model.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class UserService {
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private UserInfoDao userInfoDao;
    SqlSession session;
    private UserInfo userInfo;

    public UserService() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("classpath:mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        UserInfoDao userInfoDao = session.getMapper(UserInfoDao.class);
    }


    private String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
    public boolean verifyEmail(String email){
        userInfo = userInfoDao.findByEmail(email);
        session.close();
        if(userInfo != null){
            return false;
        }else{
            return true;
        }
    }

    public boolean verifyUsername(String username){
        userInfo = userInfoDao.findByUsername(username);
        if(userInfo != null){
            return false;
        }else{
            return true;
        }
    }

    public boolean verifyPhone(String phone){
        userInfo = userInfoDao.findByPhone(phone);
        if(userInfo != null){
            return false;
        }else{
            return true;
        }
    }


    public void register(UserInfo form) throws UserException {
        if(!(verifyEmail(form.getEmail()) && verifyPhone(form.getPhone()) && verifyUsername(form.getUsername()))){
            throw new UserException("Error");
        }
        if (form.getUid() == null || form.getUid().isEmpty()) {
            form.setUid(uuid());
        }
        form.setHavingClass(-1);
        form.setTrueName("NULL");
        form.setSchoolId("NULL");
        userInfoDao.add(form);
    }

    public void activate(String code) throws UserException {
        UserInfo userInfo = userInfoDao.findByCode(code);
        if (userInfo == null) throw new UserException("激活失败");
        if (userInfo.isState()) throw new UserException("???激活了哟");

        userInfoDao.updateState(userInfo.getUid(), true);
    }

    public UserInfo login(String username, String password) {
        UserInfo userInfo = userInfoDao.findByUsername(username);
        if (userInfo == null) {
            return null;
        }
        if (userInfoDao.checkPassword(username, password) != null)
            return userInfo;
        return null;
    }

    public void havingClass(String uid, int classId) {
        userInfoDao.updateHavingClass(uid, classId);
    }

    public UserInfo getUserByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }

    public UserInfo getUserByUid(String uid) {
        return userInfoDao.findByUid(uid);
    }

    public void closeSession(){
        session.close();
    }
}
