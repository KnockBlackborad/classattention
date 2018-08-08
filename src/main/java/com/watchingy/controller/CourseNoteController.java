package com.watchingy.controller;

import com.alibaba.fastjson.JSON;
import com.watchingy.exception.UserException;
import com.watchingy.model.CourseNote;
import com.watchingy.service.CourseNoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping(value = "/CourseNote")
public class CourseNoteController {
    private CourseNoteService courseNoteService = new CourseNoteService();

    @RequestMapping(value = "/create")
    @ResponseBody
    public String createCourseNote(@RequestBody String requestJson) throws UserException, IOException {
        if (requestJson == null) {
            return "error";
        }
        System.out.println(requestJson);
        CourseNote courseNote = JSON.parseObject(requestJson, CourseNote.class);
        courseNoteService.createCourseNote(courseNote);
        return "successful";
    }

    @RequestMapping(value = "/get")
    @ResponseBody
    public String getCourseNote(@RequestBody String requestJson){
        int courseId = Integer.parseInt(requestJson);
        return JSON.toJSONString(courseNoteService.getCourseNote(courseId));
    }
}
