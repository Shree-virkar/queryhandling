package com.cdac.dao;

import java.util.List;

import com.cdac.model.TechQuery;

public interface FacultyDao {
	
	
	List<TechQuery> selectAns(TechQuery techQuery);
	
	List<TechQuery> selectQues(TechQuery techQuery,int userId);
	
	boolean insertTechResponse(TechQuery techQuery,int userId);

}
