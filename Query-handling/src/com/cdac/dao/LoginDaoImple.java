package com.cdac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cdac.model.Login;

@Repository
public class LoginDaoImple implements LoginDao{

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Login userLogin(Login user) {
		
		
		String sql = "select * from users where userName = ? and aes_decrypt(password,'mypassword') = ?";
		
		try {
		Login log1 = jdbcTemplate.queryForObject(sql, new Object[] {user.getUserName(),  user.getPassWord()} ,new RowMapper<Login>() {
			
			@Override
			public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
				//System.out.println(user.getUserRole().toString());
				
				Login log = new Login();
				log.setUserName(rs.getString("userName"));
				log.setPassWord(rs.getString("password"));
				//log.setUserRole(userRole);(UserRole.valueOf(rs.getString("user_role")));
				log.setUserRole(rs.getString("userRole"));
				System.out.println(log.toString());
				
				return log;
			
			
			}
			
		});
		
		return log1;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
			
		
	
	}

	@Override
	public Login getUserId(String userName, String password) {
		
		String sql="select user_id from users where userName=? and aes_decrypt(password,'mypassword')=?";
		
		
			Login log1 = jdbcTemplate.queryForObject(sql, new Object[] {userName,password} ,new RowMapper<Login>() {
				
				@Override
				public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					Login log = new Login();
					log.setUserId(rs.getInt("user_id"));					
					return log;
				
				
				}
				
			});
			
			return log1;
		
		
	}
		

}
