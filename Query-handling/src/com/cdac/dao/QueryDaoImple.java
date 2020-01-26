package com.cdac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cdac.model.Query;

@Repository
public class QueryDaoImple implements QueryDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insert(Query query) {
		String sql = "insert into question values(?,?,?,?)";
		int id=100;
		
		int i = jdbcTemplate.update(sql, new Object[] {
			id,
			query.getQuery(),	
			query.getSubject(),
			query.getTopic()
		});
		
		if(i==1) {
			return true;
		}else {
			return false;
		
		}
	}

	
	@Override
	public List<Query> selectAll(Query query) {
		
		String sql = "select * from question where subject= ? and topic LIKE ?";
		String topic ="%"+query.getTopic()+"%";
		
		List<Query> qlist = jdbcTemplate.query(sql,new Object[] {query.getSubject(),topic}, new RowMapper<Query>() {

			@Override
			public Query mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Query que = new Query();
				
				//que.setSubject(rs.getString("subject"));
				//que.setTopic(rs.getString("topic"))
				que.setQuery(rs.getString("question"));
				que.setQ_id(rs.getInt("q_id"));
				System.out.println(que.getQuery().toString()+"+++++++++++");
				return que;
				
			}

			
		});
		return qlist;
	}


	@Override
	public List<Query> selectAns(Query query) {
		//String sql = "select question.question, que_ans.answer from question inner join que_ans on question.q_id = que_ans.q_id";
		
		String sql1="select * from que_ans where q_id=?";
		
		List<Query> qlist = jdbcTemplate.query(sql1,new Object[] {query.getQ_id()}, new RowMapper<Query>() {

			@Override
			public Query mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Query que = new Query();
				
			//	que.setQuery(rs.getString("question"));
				que.setQ_id(rs.getInt("q_id"));
				que.setAns(rs.getString("answer"));
				return que;
				
			}

			
		});
		return qlist;
	}


	@Override
	public List<Query> selectPrev(Query query) {
		// TODO Auto-generated method stub
		return null;
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



	



	


