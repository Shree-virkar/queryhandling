package com.cdac.dao;

import java.util.List;

import com.cdac.model.Query;

public interface QueryDao {
	
	boolean insert(Query query);
	
	public List<Query> selectAll(Query query);
	
	public List<Query> selectAns(Query query);

	public List<Query> selectPrev(Query query);
 
	public List<Query> selectSubAns(Query query);

	

}
