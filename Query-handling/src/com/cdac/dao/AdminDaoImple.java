package com.cdac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cdac.model.Faculty;
import com.cdac.model.Login;
import com.cdac.model.NonTechQuery;

@Repository
public class AdminDaoImple implements AdminDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	

	@Override
	public ArrayList<NonTechQuery> getQueries() {
		System.out.println("In admin Dao for get Queries");
		String sql="select * from nontech_queries";
		return (ArrayList<NonTechQuery>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(NonTechQuery.class));
	}

	
	
	
	
	@Override
	public boolean updateStatus(int id) {
		System.out.println("In admin Dao for update Queries");
		String sql="update nontech_queries set status='Yes' where id=?";
		int status = jdbcTemplate.update(sql, id);
		if(status>0)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public ArrayList<NonTechQuery> getQueries2() {
		System.out.println("In admin Dao for get Queries2");
		String sql="select * from nontech_queries";
		return (ArrayList<NonTechQuery>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(NonTechQuery.class));
		
	}

	@Override
	public ArrayList<Faculty> getFaculty() {
		System.out.println("In admin Dao for get Queries");
		String sql="select * from Faculty";
		return (ArrayList<Faculty>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Faculty.class));
	}
	

	@Override
	public boolean removeFaculty(int faculty_id) {
		String sql = "delete from faculty where faculty_id=?";
		int status = jdbcTemplate.update(sql, faculty_id);
		
		String sql1 = "delete from users where user_id=?";
		int status1 = jdbcTemplate.update(sql1, faculty_id);
		if(status>0 && status1>0)
		{
			return true;
		}
		
		return false;
	}





	@Override
	public boolean registerFaculty(Login log, Faculty fc) {
		
		String sql="insert into users(userName,password,contact,email,userRole) values(?,?,?,?,?)";
		
		int i=jdbcTemplate.update(sql,new Object[] {log.getUserName(),log.getPassWord(),log.getContactNo(),log.getEmailId(),log.getUserRole()});
		
		
		String sql2="select user_id from users where userName=? and password=?";
		
		Login log1 = jdbcTemplate.queryForObject(sql2, new Object[] {log.getUserName(),  log.getPassWord()} ,new RowMapper<Login>() {
			
		@Override
		public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
			//System.out.println(user.getUserRole().toString());
				
			Login log = new Login();
			log.setUserId(rs.getInt("user_id"));
			System.out.println(log.toString());
			
			return log;
		
			
		}
		
	});

	
	
	String sql1="insert into faculty(faculty_id,userName,first_name,last_name) values(?,?,?,?)";
	
	int j=jdbcTemplate.update(sql1,new Object[] {log1.getUserId(),log.getUserName(),fc.getFirstName(),fc.getLastName()});

	if(i==1 && j==1) {
		return true;
	}else {
		return false;

	 }
	}


}
