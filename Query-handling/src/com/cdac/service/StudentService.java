package com.cdac.service;

import java.util.List;

import com.cdac.model.Login;
import com.cdac.model.NonTechQuery;
import com.cdac.model.TechQuery;
import com.cdac.model.Student;

public interface StudentService {
	
	boolean registerStudent(Login log, Student std );

	boolean insert(TechQuery techQuery,int userId);
	
	boolean insertNonTech(NonTechQuery nonTechQuery,int userId);

	
	public List<TechQuery> selectAll(TechQuery techQuery);
	
	public List<TechQuery> selectAns(TechQuery techQuery);

	public List<TechQuery> selectPrev(TechQuery techQuery);
	
	public List<NonTechQuery> selectPrevNonTech(NonTechQuery nonTechQuery);

	public List<TechQuery> selectSubAns(TechQuery techQuery);
	
	public boolean isUsername(String username);

}
