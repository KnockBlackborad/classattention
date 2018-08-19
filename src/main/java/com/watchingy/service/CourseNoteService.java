package com.watchingy.service;

import com.watchingy.dao.CourseNoteDao;
import com.watchingy.model.CourseNote;

public class CourseNoteService {
    CourseNoteDao courseNoteDao;


    public void createCourseNote(CourseNote courseNote) {
        //使用uid以及deteid创建数据库
        courseNoteDao.add(courseNote);
    }

    public CourseNote getCourseNote(int courseId) {
        return courseNoteDao.getByCourseId(courseId);
    }
}
