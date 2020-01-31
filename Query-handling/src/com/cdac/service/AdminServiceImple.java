package com.cdac.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.AdminDao;
import com.cdac.model.Faculty;
import com.cdac.model.Login;
import com.cdac.model.NonTechQuery;
import com.cdac.model.TechQuery;

@Service
public class AdminServiceImple implements AdminService{

	@Autowired
	AdminDao adminDao;
	
	
	@Override
	public ArrayList<NonTechQuery> getQueries() {
		// TODO Auto-generated method stub
		return adminDao.getQueries();
	}

	
	@Override
	public boolean updateStatus(int id) {
		// TODO Auto-generated method stub
		return adminDao.updateStatus(id);
	}


	@Override
	public ArrayList<NonTechQuery> getQueries2() {
		// TODO Auto-generated method stub
		return adminDao.getQueries2();
	}


	@Override
	public ArrayList<Faculty> getFaculty() {
		// TODO Auto-generated method stub
		return adminDao.getFaculty();
	}


	@Override
	public boolean removeFaculty(int faculty_id) {
		// TODO Auto-generated method stub
		return adminDao.removeFaculty(faculty_id);
	}


	@Override
	public boolean registerFaculty(Login log, Faculty fc,TechQuery sub) {
		// TODO Auto-generated method stub
		return adminDao.registerFaculty(log, fc,sub);
	}

	
}
