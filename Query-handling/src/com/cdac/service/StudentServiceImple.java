package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.StudentDao;
import com.cdac.model.Login;
import com.cdac.model.NonTechQuery;
import com.cdac.model.TechQuery;
import com.cdac.model.Student;

@Service
public class StudentServiceImple implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	
	

	
	
	@Override
	public boolean insert(TechQuery techQuery,int userId) {
		
		return studentDao.insert(techQuery,userId);
	}

	@Override
	public List<TechQuery> selectAll(TechQuery techQuery) {
		
		return studentDao.selectAll(techQuery);
	}

	@Override
	public List<TechQuery> selectAns(TechQuery techQuery) {
		// TODO Auto-generated method stub
		return studentDao.selectAns(techQuery);
	}

	@Override
	public List<TechQuery> selectPrev(TechQuery techQuery) {
		// TODO Auto-generated method stub
		return studentDao.selectPrev(techQuery);
	}

	@Override
	public List<TechQuery> selectSubAns(TechQuery techQuery) {
		// TODO Auto-generated method stub
		return studentDao.selectSubAns(techQuery);
	}

	@Override
	public boolean registerStudent(Login log, Student std) {
		
		return studentDao.registerStudent(log, std);
	}

	@Override
	public boolean insertNonTech(NonTechQuery nonTechQuery,int userId) {
		// TODO Auto-generated method stub
		return studentDao.insertNonTech(nonTechQuery, userId);
	}

	@Override
	public List<NonTechQuery> selectPrevNonTech(NonTechQuery nonTechQuery) {
		
		return studentDao.selectPrevNonTech(nonTechQuery);
	}


	

	
	
	
	
	
}
