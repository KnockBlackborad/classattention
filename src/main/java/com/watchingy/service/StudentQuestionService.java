package com.watchingy.service;

import com.watchingy.dao.StudentQuestionDao;
import com.watchingy.model.StudentQuestion;

import java.util.List;

public class StudentQuestionService {
    StudentQuestionDao studentQuestionDao;

    public void createStudentQuestion(StudentQuestion studentQuestion) {
        //使用uid以及deteid创建数据库
        studentQuestionDao.add(studentQuestion);
    }

    public List<StudentQuestion> getStudentQuestion(int classId) {
        return studentQuestionDao.getCourseInfoByUid(classId);
    }
}
