package com.watchingy.controller;

import com.alibaba.fastjson.JSON;
import com.watchingy.exception.UserException;
import com.watchingy.model.User;
import com.watchingy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping(value = "/User")
public class UserController {
    UserService userService;

    @RequestMapping(value = "/verifyEmail")
    @ResponseBody
    public String verifyEmail(@RequestBody String email){
        try {
            userService = new UserService();
            if(userService.verifyEmail(email)){
                userService.closeSession();
                return "ok";
            }else{
                userService.closeSession();
                return "error";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        } finally {
            userService.closeSession();
        }

    }

    @RequestMapping(value = "/verifyPhone")
    @ResponseBody
    public String verifyPhone(@RequestBody String phone){
        try {
            userService = new UserService();
            if(userService.verifyPhone(phone)){
                userService.closeSession();
                return "ok";
            }else{
                userService.closeSession();
                return "error";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        } finally {
            userService.closeSession();
        }

    }

    @RequestMapping(value = "/verifyUsername")
    @ResponseBody
    public String verifyUsername(@RequestBody String username){
        try {
            userService = new UserService();
            if(userService.verifyUsername(username)){
                return "ok";
            }else{
                return "error";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }finally {
            userService.closeSession();
        }
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public String register(@RequestBody String json){
        try {
            userService = new UserService();
            User user = JSON.parseObject(json, User.class);
            userService.register(user);
            return "successful";
        } catch (IOException | UserException e) {
            e.printStackTrace();
            return "error";
        } finally {
            userService.closeSession();
        }
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(@RequestBody String json){
        try {
            userService = new UserService();
            User request = JSON.parseObject(json, User.class);
            User user = userService.login(request.getUsername(), request.getPassword());
            if(user == null){
                return "error";
            }else{
                return JSON.toJSONString(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }finally {
            userService.closeSession();
        }
    }
}
