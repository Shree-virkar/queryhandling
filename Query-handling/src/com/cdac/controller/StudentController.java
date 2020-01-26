package com.cdac.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.model.Query;
import com.cdac.service.QueryService;

@Controller
public class StudentController {
	
	@Autowired
	private QueryService queryService;

	
	
	public QueryService getQueryService() {
		return queryService;
	}



	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}



	@RequestMapping (value = "/submitquery", method = RequestMethod.POST)
	public String save(@RequestParam("query") String query, @RequestParam("subject") String subject,@RequestParam("topic") String topic, HttpSession session)
	{
		Query que=new Query();
		que.setSubject(subject);
		que.setQuery(query);
		que.setTopic(topic);
		
		if(queryService.insert(que))
		{
			return "submitquery";
		}
		else
		{
			return "home";
		}	
	}
	
	
	@RequestMapping (value = "/searchquery", method = RequestMethod.POST)
	public ModelAndView listQuery(ModelAndView model, @RequestParam("subject") String subject, @RequestParam("topic") String topic) throws IOException
	{
		Query query=new Query();
		query.setSubject(subject);
		query.setTopic(topic);
		
		List<Query> listQuery = queryService.selectAll(query);
		model.addObject("listQuery", listQuery);
		
		model.setViewName("searchquery");
		
		return model;
		
	} 
	
	
	
	@RequestMapping (value = "/answers", method = RequestMethod.POST)
	public ModelAndView listAns(ModelAndView model, @RequestParam("q_id") int q_id, @RequestParam("question") String question) throws IOException
	{
		Query query=new Query();
		query.setQ_id(q_id);
		query.setQuery(question);;
		
		System.out.println(query.getQ_id()+"++++++++++++++++++++");
		List<Query> listQuery = queryService.selectAns(query);
		model.addObject("listQuery", listQuery);
		model.addObject(query);
		
		model.setViewName("answer");
		
		return model;
		
	} 
	
	/*@RequestMapping (value = "/answers", method = RequestMethod.POST)

	public ModelAndView listAns(ModelAndView model, @RequestParam("subject") int q_id) throws IOException{
		
		
		
		
		return model;
		
		
	}*/
	
	
	
}
