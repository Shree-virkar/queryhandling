package com.cdac.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.model.NonTechQuery;
import com.cdac.model.TechQuery;
import com.cdac.service.FacultyService;

@Controller
//@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	public FacultyService getFacultyService() {
		return facultyService;
	}

    public void setFacultyService(FacultyService facultyService) {
		this.facultyService = facultyService;
	}
	
	@RequestMapping (value = "/anstech", method = RequestMethod.POST)

	public ModelAndView listAns(ModelAndView model, @RequestParam("subject") String subject, HttpSession session) throws IOException{
		
		TechQuery techQuery=new TechQuery();
		techQuery.setSubject(subject);
		
		System.out.println(techQuery.getSubject()+"Faculty controller");
		
		int userId=(int) session.getAttribute("userId");
		
		List<TechQuery> listQuery = facultyService.selectQues(techQuery,userId);
		
		System.out.println(listQuery.toString()+"COO");
			
		model.addObject("listQuery", listQuery);
		
		model.setViewName("fquestionlist");
		
		return model;
			
	}
	
	@RequestMapping (value = "/techanswer", method = RequestMethod.POST)
	public ModelAndView listAns(ModelAndView model, @RequestParam("q_id") int q_id, @RequestParam("question") String question) throws IOException
	{
		TechQuery techQuery=new TechQuery();
		techQuery.setQ_id(q_id);
		techQuery.setQuery(question);
		
		System.out.println(techQuery.getQ_id()+"++++++++++++++++++++");
	//	List<TechQuery> listQuery = facultyService.selectAns(techQuery);
		
		
		model.addObject("listQuery", techQuery);
		model.addObject(techQuery);
		
		model.setViewName("techanslist");
		
		return model;
		
	} 
	
	@RequestMapping (value = "/anstechquery", method = RequestMethod.POST)
	public String saveNonTech(@RequestParam("q_id") int q_id,@RequestParam("tresponse") String response, HttpSession session)
	{
		TechQuery techQuery=new TechQuery();
		techQuery.setQ_id(q_id);
		techQuery.setTechResponse(response);
		
		int userId=(int) session.getAttribute("userId");
		
		
		if(facultyService.insertTechResponse(techQuery,userId))
		{
			return "techans";
		}
		else
		{
			return "techans";
		}
		
	}
	
	
	
	
	
	
	
}
