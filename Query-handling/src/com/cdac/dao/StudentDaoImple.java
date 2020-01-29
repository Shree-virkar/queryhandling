package com.cdac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cdac.model.Login;
import com.cdac.model.NonTechQuery;
import com.cdac.model.TechQuery;
import com.cdac.model.Student;


@Repository
public class StudentDaoImple implements StudentDao{

	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insert(TechQuery techQuery ,int userId) { 
		
		
		
		String sql1="select subject_id from subject where subject_nm=?";
		
		TechQuery tq=jdbcTemplate.queryForObject(sql1,new Object[] {techQuery.getSubject()}, new RowMapper<TechQuery>() {
			
			@Override
			public TechQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				TechQuery que = new TechQuery();
				
				
				que.setSubject_id(rs.getInt("subject_id"));
				
				//System.out.println(que.getQuery().toString()+"+++++++++++");
				return que;
				
			}
			
			
		});	
		
         String sql2="select topic_id from topic where topic_nm=?";
		
	    TechQuery tq1=jdbcTemplate.queryForObject(sql2,new Object[] {techQuery.getTopic()}, new RowMapper<TechQuery>() {

			@Override
			public TechQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				TechQuery que = new TechQuery();
				
				
				que.setTopic_id(rs.getInt("topic_id"));
				
			//	System.out.println(que.getQuery().toString()+"+++++++++++");
				return que;
				
			}

			
		});	
	    
	    	    
		
		String sql = "insert into tech_queries(tech_ques,subject_id,posted_on,posted_by,topic_id) values(?,?,?,?,?)"; 

		LocalDateTime dateT=java.time.LocalDateTime.now();
		int i = jdbcTemplate.update(sql, new Object[] {
			
			techQuery.getQuery(),	
			tq.getSubject_id(),
			dateT,
			userId,
			tq1.getTopic_id()
		});
		
		
		String sql4 ="select tech_id from tech_queries where tech_ques=?";
		
		TechQuery tq3=jdbcTemplate.queryForObject(sql4,new Object[] {techQuery.getQuery()}, new RowMapper<TechQuery>() {

			@Override
			public TechQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				TechQuery que = new TechQuery();
				
				
				que.setQ_id(rs.getInt("tech_id"));
				
			//	System.out.println(que.getQuery().toString()+"+++++++++++");
				return que;
				
			}

			
		});	
		
		
		String sql5="insert into tech_answers(tech_id) values(?); ";

		int k = jdbcTemplate.update(sql5, new Object[] {
				
					
				tq3.getQ_id()
				
			
			});
		
		if(i==1 && k==1) {
			return true;
		}else {
			return false;
		
		}
	}

	
	@Override
	public List<TechQuery> selectAll(TechQuery techQuery) {

		
		
		String sql = "select tech_id,tech_ques from tech_queries where subject_id= (select subject_id from subject where subject_nm=?) and topic_id=(select topic_id from topic where topic_nm LIKE ?)";
		String topic1 ="%"+techQuery.getTopic()+"%";
		
		List<TechQuery> qlist = jdbcTemplate.query(sql,new Object[] {techQuery.getSubject(),topic1}, new RowMapper<TechQuery>() {

			@Override
			public TechQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				TechQuery que = new TechQuery();
				
				//que.setSubject(rs.getString("subject"));
				//que.setTopic(rs.getString("topic"))
				que.setQuery(rs.getString("tech_ques"));
				que.setQ_id(rs.getInt("tech_id"));
				//System.out.println(que.getQuery().toString()+"+++++++++++");
				return que;
				
			}

			
		});
		return qlist;
	}


	@Override
	public List<TechQuery> selectAns(TechQuery techQuery) {
		//String sql = "select question.question, que_ans.answer from question inner join que_ans on question.q_id = que_ans.q_id";
		
		String sql1="select * from que_ans where q_id=?";
		
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
	public List<TechQuery> selectPrev(TechQuery techQuery) {
		
		  String sql="select subject_id from subject where subject_nm=?";
			
			TechQuery tq=jdbcTemplate.queryForObject(sql,new Object[] {techQuery.getSubject()}, new RowMapper<TechQuery>() {

				@Override
				public TechQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					TechQuery que = new TechQuery();
					
					
					que.setSubject_id(rs.getInt("subject_id"));
					
					//System.out.println(que.getQuery().toString()+"+++++++++++");
					return que;
					
				}

				
			});	
			
		String sql1="select * from tech_queries where subject_id=?";
		
		List<TechQuery> qlist = jdbcTemplate.query(sql1,new Object[] {tq.getSubject_id()},new RowMapper<TechQuery>() {

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
	public List<TechQuery> selectSubAns(TechQuery techQuery) {
		String sql1="select * from que_ans where q_id=?";
		
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
	public boolean registerStudent(Login log, Student std) {
		
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

		
		
		String sql1="insert into student(stud_id,userName,first_name,last_name) values(?,?,?,?)";
		
		int j=jdbcTemplate.update(sql1,new Object[] {log1.getUserId(),log.getUserName(),std.getFirstName(),std.getLastName()});

		if(i==1 && j==1) {
			return true;
		}else {
			return false;

		}
		
	}


	@Override
	public boolean insertNonTech(NonTechQuery nonTechQuery,int userId) {
		
		String sql="insert into nontech_queries(nontech_ques,status,posted_by,posted_on) values(?,?,?,?)";
		
		LocalDateTime dateT=java.time.LocalDateTime.now();

		int i=jdbcTemplate.update(sql,new Object[] {
				
				nonTechQuery.getNontech_ques(),
				nonTechQuery.getStatus(),
				userId,
				dateT
				
		});
		
		return false;
		
	}

	@Override
	public List<NonTechQuery> selectPrevNonTech(NonTechQuery nonTechQuery) {
		
		String sql="select * from nontech_queries where posted_by=?";
		List<NonTechQuery> qlist = jdbcTemplate.query(sql,new Object[] {nonTechQuery.getId()}, new RowMapper<NonTechQuery>() {

			@Override
			public NonTechQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				NonTechQuery que = new NonTechQuery();
				
				que.setId(rs.getInt("id"));
				que.setNontech_ques(rs.getString("nontech_ques"));
				que.setStatus(rs.getString("status"));
				
				que.setPosted_by(rs.getInt("posted_by"));
				que.setPosted_on(rs.getDate("posted_on"));
				//que.setAns(rs.getString("answer"));
				return que;
				
			}

			
		});
		
		return qlist;

		
		
	
	}

}

	


	/*@Override
	public List<Query> selectAns(Query query) {
		String sql = "select question.question, que_ans.answer from question inner join que_ans on question.q_id = que_ans.q_id;";
		
		List<Query> qlist = jdbcTemplate.query(sql,new Object[] {query.getQ_id()}, new RowMapper<Query>() {

			@Override
			public Query mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Query que = new Query();
				
				que.setQuery(rs.getString("question"));
				que.setQ_id(rs.getInt("q_id"));
				return que;
				
			}

			
		});
		return qlist;
	} */

	

	

	
/*	@Override
	public boolean insert(Query query) {
		
		String sql = "insert into tech_queries(subject,tech_quest) values(?,?)";
		
		int i = jdbcTemplate.update(sql, new Object[] {
			
			query.getSubject(),
			query.getQuery()
		});
		
		if(i==1) {
			return true;
		}else {
			return false;

		}
	} */



	



	


