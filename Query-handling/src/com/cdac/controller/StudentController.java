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

import com.cdac.model.Login;
import com.cdac.model.NonTechQuery;
import com.cdac.model.TechQuery;
import com.cdac.model.Student;
import com.cdac.service.StudentService;


@Controller
//@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	
	
	public StudentService getQueryService() {
		return studentService;
	}

	public void setQueryService(StudentService queryService) {
		this.studentService = queryService;
	}

	@RequestMapping(value="/registerStudent", method = RequestMethod.POST)
	public String registerStudentC(@RequestParam("username") String username, @RequestParam("password") String password,  @RequestParam("email") String email,@RequestParam("contactno") int contactno,@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname)
	{
	
		Login log=new Login();
		log.setUserName(username);
		log.setPassWord(password);
		log.setEmailId(email);
		log.setContactNo(contactno);
		log.setUserRole("student");
		
		
		System.out.println(log.toString());
		
		
		Student std=new Student();
		std.setFirstName(firstname);
		std.setLastName(lastname);
	
		System.out.println(std.toString());
		
		System.out.println("In Admin Controller");
		if(studentService.registerStudent(log, std))
		{
			return "/login";
		}
		
		return "/error";
	} 
	
	
	
	


	@RequestMapping (value = "/submitquery1", method = RequestMethod.POST)
	public String save(@RequestParam("query") String query, @RequestParam("subject") String subject,@RequestParam("topic") String topic, HttpSession session)
	{
		TechQuery que=new TechQuery();
		que.setSubject(subject);
		que.setQuery(query);
		que.setTopic(topic);
		
		int userId=(int) session.getAttribute("userId");
		
		System.out.println(que.toString()+"++++++++++++");
		
		if(studentService.insert(que,userId))
		{
			return "submitquery";
		}
		else
		{
			return "home";
		}	
	}
	
	@RequestMapping (value = "/nontech", method = RequestMethod.POST)
	public String saveNonTech(@RequestParam("fname") String Nquery, HttpSession session)
	{
		NonTechQuery que=new NonTechQuery();
		que.setNontech_ques(Nquery);
		que.setStatus("NO");
		System.out.println(que.toString()+"++++++++++++");
		
		int userId=(int) session.getAttribute("userId");
		
		
		if(studentService.insertNonTech(que,userId))
		{
			return "non-techquery";
		}
		else
		{
			return "home";
		}	
	}
	
	
	
	@RequestMapping (value = "/searchquery1", method = RequestMethod.POST)
	public ModelAndView listQuery(ModelAndView model, @RequestParam("subject") String subject, @RequestParam("topic") String topic) throws IOException
	{
		TechQuery techQuery=new TechQuery();
		techQuery.setSubject(subject);
		techQuery.setTopic(topic);
		
		List<TechQuery> listQuery = studentService.selectAll(techQuery);
		model.addObject("listQuery", listQuery);
		
		model.setViewName("searchquery");
		
		return model;
		
	} 
	
	
	
	@RequestMapping (value = "/answers", method = RequestMethod.POST)
	public ModelAndView listAns(ModelAndView model, @RequestParam("q_id") int q_id, @RequestParam("question") String question) throws IOException
	{
		TechQuery techQuery=new TechQuery();
		techQuery.setQ_id(q_id);
		techQuery.setQuery(question);
		
		System.out.println(techQuery.getQ_id()+"++++++++++++++++++++");
		List<TechQuery> listQuery = studentService.selectAns(techQuery);
		model.addObject("listQuery", listQuery);
		model.addObject(techQuery);
		
		model.setViewName("answer");
		
		return model;
		
	} 
	
	@RequestMapping (value = "/prevtech", method = RequestMethod.POST)

	public ModelAndView listAns(ModelAndView model, @RequestParam("subject") String subject) throws IOException{
		
		TechQuery techQuery=new TechQuery();
		techQuery.setSubject(subject);
		
		List<TechQuery> listQuery = studentService.selectPrev(techQuery);
		model.addObject("listQuery", listQuery);
		
		model.setViewName("searchsub");
		
		return model;
		
		
	
		
		
	}
	
	
	@RequestMapping (value = "/prevnontech", method = RequestMethod.GET)

	public ModelAndView listNonTech(ModelAndView model,HttpSession session) throws IOException{
		
		NonTechQuery nt=new NonTechQuery();
		int userId=(int) session.getAttribute("userId");
		nt.setId(userId);
		List<NonTechQuery> listQuery = studentService.selectPrevNonTech(nt);
		model.addObject("listQuery", listQuery);
		
		model.setViewName("prevNonTech");
		
		return model;	
	}
	
	
	@RequestMapping (value = "/answers2", method = RequestMethod.POST)
	public ModelAndView listAns1(ModelAndView model, @RequestParam("q_id") int q_id, @RequestParam("question") String question) throws IOException
	{
		TechQuery techQuery=new TechQuery();
		techQuery.setQ_id(q_id);
		techQuery.setQuery(question);
		
		System.out.println(techQuery.getQ_id()+"++++++++++++++++++++");
		List<TechQuery> listQuery = studentService.selectSubAns(techQuery);
		model.addObject("listQuery", listQuery);
		model.addObject(techQuery);
		
		model.setViewName("answer");
		
		return model;
		
	} 
	
	
	
}
