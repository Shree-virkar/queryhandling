package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.FacultyDao;
import com.cdac.model.TechQuery;

@Service
public class FacultyServiceImple implements FacultyService {

	@Autowired
	FacultyDao facultyDao;
	
	@Override
	public List<TechQuery> selectQues(TechQuery techQuery, int userId) {
		// TODO Auto-generated method stub
		return facultyDao.selectQues(techQuery,userId);
		 
	}

	@Override
	public boolean insertTechResponse(TechQuery techQuery, int userId) {
		// TODO Auto-generated method stub
		return facultyDao.insertTechResponse(techQuery, userId);
	}

}
