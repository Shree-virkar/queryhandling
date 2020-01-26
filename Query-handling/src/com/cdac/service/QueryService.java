package com.cdac.service;

import java.util.List;

import com.cdac.model.Query;

public interface QueryService {
	
	boolean insert(Query query);
	
	public List<Query> selectAll(Query query);
	
	public List<Query> selectAns(Query query);

	public List<Query> selectPrev(Query query);



}
