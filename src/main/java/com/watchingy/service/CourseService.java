package com.watchingy.service;

import com.watchingy.dao.CourseDao;
import com.watchingy.model.Course;

import java.util.List;

public class CourseService {
    CourseDao courseDao;

    public void createCourse(Course course) {
        //使用uid以及dateid创建数据库
        courseDao.add(course);
    }

    public List<Course> getCourseInfo(String uid) {
        List<Course> courseList = courseDao.getByUid(uid);
        return courseList;
    }
}
