package com.watchingy.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinClass {
    @RequestMapping(value = "/AndroidJoinServlet")
    public String JoinServlet(@RequestBody String json){
        return null;
    }
}
