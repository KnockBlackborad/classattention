package com.watchingy.controller;

import com.watchingy.service.ClassService;
import com.watchingy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartClassController {
    private static final String ip = "10.242.0.115";
    @RequestMapping(value = "/CreateClassServlet")
    public String CreateClass(@RequestBody String uid){
        ClassService classService = new ClassService();

        return null;
    }
}
