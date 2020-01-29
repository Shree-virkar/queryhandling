package com.cdac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cdac.model.TechQuery;


@Repository
public class FacultyDaoImple implements FacultyDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Override
	public List<TechQuery> selectQues(TechQuery techQuery, int userId) {
		
		
			
			
				
			String sql1="select * from tech_queries where subject_id=(select subject_id from subject where subject_nm=?)";
			
			List<TechQuery> qlist = jdbcTemplate.query(sql1,new Object[] {techQuery.getSubject()},new RowMapper<TechQuery>() {

				@Override
				public TechQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					TechQuery que = new TechQuery();
					
				//	que.setQuery(rs.getString("question"));
					que.setQ_id(rs.getInt("tech_id"));
					que.setQuery(rs.getString("tech_ques"));
					return que;
					
				}

				
			});
			return qlist;
		}


	@Override
	public List<TechQuery> selectAns(TechQuery techQuery) {
		
		
		String sql1="select * from tech_answers where tech_id=?";
		
		List<TechQuery> qlist = jdbcTemplate.query(sql1,new Object[] {techQuery.getQ_id()}, new RowMapper<TechQuery>() {

			@Override
			public TechQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				TechQuery que = new TechQuery();
				
			//	que.setQuery(rs.getString("question"));
				que.setQ_id(rs.getInt("q_id"));
				que.setAns(rs.getString("answer"));
				return que;
				
			}
	
		});
		return qlist;
		
	}


	@Override
	public boolean insertTechResponse(TechQuery techQuery, int userId) {
		
		String sql="insert into tech_answers(tech_id,response,added_by,added_on) values(?,?,?,?)";
		
		LocalDateTime dateT=java.time.LocalDateTime.now();
		
		int i=jdbcTemplate.update(sql,new Object[] {
				
				techQuery.getQ_id(),
				techQuery.getTechResponse(),
				userId,
				dateT
				
		});
		
		if(i==1) {
			
			return true;		
			}
		
		else {
			return false;
		}
		
	}
		
}	
		
		
	


