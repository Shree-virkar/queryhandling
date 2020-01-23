package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.model.Login;
import com.cdac.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	

	
	public LoginService getLoginService() {
		return loginService;
	}




	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}




	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord, @RequestParam("userRole") String userRole)
	{
		ModelAndView mv = new ModelAndView();
		Login log = new Login();
		log.setUserName(userName);
		log.setPassWord(passWord);
		log.setUserRole(userRole);
		//String str=userRole;
		
		
		//UserRole check=log.getUserRole();
		//String str=check.toString();
		
		Login log1= loginService.userLogin(log);
		
		//str.equals("admin");
		
		try {
		if(log1.getUserRole().equals("student"))
		{
			mv.setViewName("home");
		}
		
		else if(log1.getUserRole().equals("admin"))
		{
			mv.setViewName("admin");
			
		}else  if(log1.getUserRole().equals("faculty"))
		
		{	
			mv.setViewName("faculty");
		}else
		{
			mv.addObject("msg", "Inavlid user Id");
			mv.setViewName("login");
		}
		}catch (Exception e) {
			return mv;
		}
		return mv;
	}
	
	

}
