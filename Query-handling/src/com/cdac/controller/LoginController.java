package com.cdac.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.model.Login;
import com.cdac.service.LoginService;

@Controller
public class LoginController{
	
	@Autowired
	private LoginService loginService;

	
	public LoginService getLoginService() {
		return loginService;
	}


	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	
	
	

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord, HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		Login log = new Login();
		log.setUserName(userName);
		log.setPassWord(passWord);
		//log.setUserRole(userRole);
		
		String student="student";
		String admin="admin";
		String faculty="faculty";


		
		Login log1= loginService.userLogin(log);	
		
		try {
			
			Login log2=new Login();
			log2=loginService.getUserId(userName, passWord);
			int userId=log2.getUserId();
			System.out.println(userId+"SESSION");
			
			  
		if(log1.getUserRole().equalsIgnoreCase("student"))
		{
			
			mv.setViewName("home");
			session.setAttribute("userId", userId);
			session.setAttribute("username", userName);
			session.setAttribute("userRole", student);
			
			//addUserInSession(log1, session);
		}
		
		else if(log1.getUserRole().equalsIgnoreCase("admin"))
		{
			
			mv.setViewName("admin");
			session.setAttribute("userId", userId);
			session.setAttribute("username", userName);
			session.setAttribute("userRole", admin);
			//addUserInSession(log1, session);
			
		}else if(log1.getUserRole().equalsIgnoreCase("faculty"))
		
		{	
			mv.setViewName("faculty");
			session.setAttribute("userId", userId);
			session.setAttribute("username", userName);
			session.setAttribute("userRole", faculty);
			//addUserInSession(log1, session);
			System.out.println(session);
			
			
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
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		session.removeAttribute("userRole");
		session.invalidate();
		return "login";
	}

}
