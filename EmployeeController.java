package com.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class EmployeeController extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");
		System.out.println(username);
		System.out.println(email);
		System.out.println(password);
		
		Employees c=new Employees();
		c.setUsername(username);
		c.setEmail(email);
		c.setPassword(password);
		System.out.println(c);
		
		EmployeeDAO cd=new EmployeeDAO();
		String status =cd.insertEmployee(c);
		System.out.println(status);
		
		if(status.equals("SUCCESS")) {
			RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}else {
			
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			
		}
	}



}