package com.cdac.dao;

import java.util.ArrayList;

import com.cdac.model.Faculty;
import com.cdac.model.Login;
import com.cdac.model.NonTechQuery;
import com.cdac.model.Student;
import com.cdac.model.TechQuery;

public interface AdminDao {

	
	boolean registerFaculty(Login log, Faculty fc,TechQuery sub );
	
	ArrayList<NonTechQuery> getQueries();
	
	
	
	boolean updateStatus(int id);
	
	ArrayList<NonTechQuery> getQueries2();

	ArrayList<Faculty> getFaculty();
	
	boolean removeFaculty(int faculty_id);
	
}
