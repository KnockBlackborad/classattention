package com.watchingy.dao;

import com.watchingy.model.CourseNote;

public interface CourseNoteDao {
    void add(CourseNote courseNote);
    CourseNote getCourseNoteByCourseId(int courseId);
}
