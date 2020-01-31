package com.cdac.service;

import java.util.ArrayList;

import com.cdac.model.Faculty;
import com.cdac.model.Login;
import com.cdac.model.NonTechQuery;
import com.cdac.model.TechQuery;

public interface AdminService {

	
	
	
	ArrayList<NonTechQuery> getQueries();
	
	boolean updateStatus(int id);
	
	boolean registerFaculty(Login log, Faculty fc,TechQuery sub );


	ArrayList<NonTechQuery> getQueries2();

	ArrayList<Faculty> getFaculty();
	
	boolean removeFaculty(int faculty_id);
}
