package com.watchingy.service;

import com.watchingy.dao.UserDao;
import com.watchingy.exception.UserException;
import com.watchingy.model.User;
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
    private UserDao userDao;
    SqlSession session;
    private User user;

    public UserService() throws IOException {
        inputStream = Resources.getResourceAsStream("classpath:mybatis-config.xml");
        sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        userDao = session.getMapper(UserDao.class);
    }


    private String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
    public boolean verifyEmail(String email){
        user = userDao.findByEmail(email);
        session.close();
        if(user != null){
            return false;
        }else{
            return true;
        }
    }

    public boolean verifyUsername(String username){
        user = userDao.findByUsername(username);
        if(user != null){
            return false;
        }else{
            return true;
        }
    }

    public boolean verifyPhone(String phone){
        user = userDao.findByPhone(phone);
        if(user != null){
            return false;
        }else{
            return true;
        }
    }


    public void register(User form) throws UserException {
        if(!(verifyEmail(form.getEmail()) && verifyPhone(form.getPhone()) && verifyUsername(form.getUsername()))){
            throw new UserException("Error");
        }
        if (form.getUid() == null || form.getUid().isEmpty()) {
            form.setUid(uuid());
        }
        form.setHavingClass(-1);
        form.setTrueName("NULL");
        form.setSchoolId("NULL");
        userDao.add(form);
    }

    public void activate(String code) throws UserException {
        User user = userDao.findByCode(code);
        if (user == null) throw new UserException("激活失败");
        if (user.isState()) throw new UserException("???激活了哟");

        userDao.updateState(user.getUid(), true);
    }

    public User login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return null;
        }
        if (userDao.checkPassword(username, password) != null)
            return user;
        return null;
    }

    public void havingClass(String uid, int classId) {
        userDao.updateHavingClass(uid, classId);
    }

    public User getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public User getUserByUid(String uid) {
        return userDao.findByUid(uid);
    }

    public void closeSession(){
        session.close();
    }
}
