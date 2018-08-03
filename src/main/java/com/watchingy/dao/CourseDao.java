package com.watchingy.dao;

import com.watchingy.model.Course;

import java.util.List;

public interface CourseDao {
    void add(Course course);
    List<Course> getCourseInfoByUid(String uid);
}
