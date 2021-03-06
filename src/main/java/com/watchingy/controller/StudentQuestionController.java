package com.watchingy.controller;

import com.alibaba.fastjson.JSON;
import com.watchingy.model.StudentQuestion;
import com.watchingy.service.StudentQuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/StudentQuestion")
public class StudentQuestionController {
    private StudentQuestionService studentQuestionService = new StudentQuestionService();
    @ResponseBody
    @RequestMapping(value = "/create")
    public String createStudentQuestion(@RequestBody String requestJson){
        if (requestJson == null) {
            return "error";
        }
        System.out.println(requestJson);
        StudentQuestion studentQuestion= JSON.parseObject(requestJson, StudentQuestion.class);
        studentQuestionService.createStudentQuestion(studentQuestion);
        return "successful";
    }

    @ResponseBody
    @RequestMapping(value = "/get")
    public String getStudentQuestion(@RequestBody String requestJson){
        int classId = Integer.parseInt(requestJson);
        return JSON.toJSONString(studentQuestionService.getStudentQuestion(classId));
    }
}
