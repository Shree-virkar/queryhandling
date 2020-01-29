package com.cdac.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.model.Faculty;
import com.cdac.model.Login;
import com.cdac.model.NonTechQuery;
import com.cdac.model.Student;
import com.cdac.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	public AdminService getAdminService() {
		return service;
	}


	public void AdminService(AdminService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/registerFaculty1", method = RequestMethod.POST)
	public String registerFaculty(@RequestParam("username") String username, @RequestParam("password") String password,  @RequestParam("email") String email,@RequestParam("contactno") int contactno,@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname)
	{
	
		
		
		Login log=new Login();
		log.setUserName(username);
		log.setPassWord(password);
		log.setEmailId(email);
		log.setContactNo(contactno);
		log.setUserRole("faculty");
		
		
		System.out.println(log.toString());
		
		
		Faculty fc=new Faculty();
		fc.setFirstName(firstname);
		fc.setLastName(lastname);
	
		System.out.println(fc.toString());
		
		System.out.println("In Admin Controller");
		if(service.registerFaculty(log, fc))
		{
			return "admin";
		}
		
		return "/errorPage";
	} 

	
	
	
	@RequestMapping(value="/getQueries")
	public String getQueries(Model map)
	{
		ArrayList<NonTechQuery> list = service.getQueries();
		
		System.out.println("List" + list);
		
		map.addAttribute("nonTechnicalQuery",list);
		return "non-techquery1";
	}
	
	  @RequestMapping(value="resolveNonTechQuerry") 
	 public String resolveNontechQuery(@RequestParam int id,Model map) 
	  {
		  boolean result = service.updateStatus(id);
		  if(result == false)
		  {
			  return "error";
		  }
		  ArrayList<NonTechQuery> list = service.getQueries();
			
			System.out.println("List" + list);
			
			map.addAttribute("nonTechnicalQuery",list);
	  
	  return "non-techquery1"; 
	  }
	
	  @RequestMapping(value="/getQueries2")
			public String getQueries2(Model map)
			{
				ArrayList<NonTechQuery> list = service.getQueries2();
				
				System.out.println("List" + list);
				
				map.addAttribute("nonTechnicalQueries",list);
				return "listnontech";
			}
		
		  @RequestMapping(value="listNonTechQuerry") 
			 public String listNontechQuery(@RequestParam int id,Model map) 
			  {
				  boolean result = service.updateStatus(id);
				  if(result == false)
				  {
					  return "error";
				  }
				  ArrayList<NonTechQuery> list = service.getQueries2();
					
					System.out.println("List" + list);
					
					map.addAttribute("nonTechnicalQueries",list);
			  
			  return "listnontech"; 
			  }
		  
		  @RequestMapping(value="/deleteFaculty")
		  public String getAllFaculty(Model map)
		  {
			  ArrayList<Faculty> list = service.getFaculty();
				
				System.out.println("List" + list);
				
				map.addAttribute("facultyList",list);
				
			    return "facultyList";
		  }
		  
		  @RequestMapping(value="/removeFaculty")
		  public String removeFaculty(int faculty_id)
		  {
			  boolean result= service.removeFaculty(faculty_id);
			  return "admin";
		  }
	}
	

