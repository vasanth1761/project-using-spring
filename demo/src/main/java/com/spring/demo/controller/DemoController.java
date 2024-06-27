package com.spring.demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.demo.dao.UserDAO;
import com.spring.demo.dao.UserImpl;
import com.spring.demo.model.UserDetails;


@Controller
public class DemoController {

	 @Autowired
	    UserDAO userImpl;
	   
		@RequestMapping("/")
		public String welcome(){

			return "welcome.jsp";
			
		}
		@RequestMapping("/login")
		public String login()
		{
			return"login.jsp";
		}
		@RequestMapping("/loginDetails")
		public String Student(@RequestParam("name")String name,@RequestParam("email") String email,Model model,@RequestParam("password") String password)
		{   
		UserDetails userDetails=new UserDetails();
			
			userDetails.setUserName(name);
			userDetails.setEmail(email);
			userDetails.setPassword(password);
			try {
				userImpl.insert(userDetails);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			try {
				List<UserDetails>user=userImpl.get();
				model.addAttribute("details", user);
				return "output.jsp";
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			return "login.jsp";
		    
			
		}
		@PostMapping("/delete")
		
		public String Student(@RequestParam("delete")int id,Model model)
		{

			userImpl.delete(id);
			try {
				List<UserDetails>user=userImpl.get();
				model.addAttribute("details", user);
	
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return "output.jsp";
			
		}
		@PostMapping("/update")
		public String Student(@RequestParam("name") String name,@RequestParam("email")String email,@RequestParam("password")String password,Model model,@RequestParam("updateid")int id)
		{   
			
			UserDetails update=new UserDetails();
			
			update.setId(id);
			update.setUserName(name);
			update.setEmail(email);
			update.setPassword(password);
			userImpl.update(update);
			List<UserDetails> user;
			try {
				user = userImpl.get();
				model.addAttribute("details", user);
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}

			return "output.jsp";	
		}
		
		  @PostMapping("/search") 
		  public String Student(@RequestParam("searchname")String name,Model model) 
		  { 
		 
		 List<UserDetails>user=userImpl.search(name);
     	 model.addAttribute("details", user);
		 return "output.jsp"; 
		 } 
		  
		 
		 
		}
		
	






