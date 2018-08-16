package com.watchingy.controller;

import com.alibaba.fastjson.JSON;
import com.watchingy.dao.TestDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @ResponseBody
    @RequestMapping(value = "/test")
    String test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-db.xml");
        TestDaoImpl testDao = (TestDaoImpl) context.getBean("testDao");
        return JSON.toJSONString(testDao.testSelect("123"));
    }
}
