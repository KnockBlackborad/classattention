package com.watchingy.dao;

import com.watchingy.model.Research;
import com.watchingy.model.StudentInfo;

public interface ResearchDao {
    Research getByUidAndClassId(String uid, int classId);
    void add(Research research);
    void deleteByResearchId(int researchId);
}
