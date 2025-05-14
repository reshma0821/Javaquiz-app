package com.controller;

import java.io.IOException;

import com.web.EmployeeDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class saveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Username=request.getParameter("name");
		int Id=Integer.parseInt(request.getParameter("id"));
		String Email=request.getParameter("email");
		String Password=request.getParameter("password");
		EmployeeDAO edao=new EmployeeDAO();
		System.out.println("");
		edao.save( Username,  Email, Password,Id);
		response.sendRedirect("list");
	}
  
}
