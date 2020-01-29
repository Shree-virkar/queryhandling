package com.cdac.service;

import java.util.List;

import com.cdac.model.TechQuery;

public interface FacultyService {

	
	List<TechQuery> selectQues(TechQuery techQuery,int userId);
	
	boolean insertTechResponse(TechQuery techQuery,int userId);

}
