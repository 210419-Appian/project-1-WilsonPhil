package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.models.User;
import com.revature.services.UserService;

public class UserController {
	private UserService us=new UserService();
	private ObjectMapper om=new ObjectMapper();
	
	public void getAllAccounts(HttpServletResponse resp)
	throws IOException, ServletException{
		List<User> list=us.findAll();
		
		String json=om.writeValueAsString(list);
		System.out.println(json);
		PrintWriter pw=resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
		
	}
	
	public void findById(HttpServletResponse resp, int id)
	throws IOException{
		User u=us.findById(id);
		String json=om.writeValueAsString(u);
		System.out.println(json);
		
		PrintWriter pw=resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}
	
	public void putUser(HttpServletRequest req,HttpServletResponse resp)
	throws IOException, ServletException{
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		User u = om.readValue(body, User.class);

		if(us.updateUser(u)) {
			resp.setStatus(200);
		}else {
			resp.setStatus(400);
		}
		
	}
	

}
