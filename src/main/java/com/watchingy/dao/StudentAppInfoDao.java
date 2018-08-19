package com.watchingy.dao;

import com.watchingy.model.StudentAppInfo;
import com.watchingy.vo.StudentAppInfoVo;

import java.util.List;

public interface StudentAppInfoDao {

    void add(StudentAppInfo studentAppInfo);

    List<StudentAppInfoVo> getByClassId(int classId);

    String getBySid(int sid);

    List<StudentAppInfoVo> getByUidAndClassId(int uid,int classId);
}
