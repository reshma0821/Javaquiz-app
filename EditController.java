package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.web.EmployeeDAO;
import com.web.Employees;

@WebServlet("/edit")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
  
        EmployeeDAO edao=new EmployeeDAO();
      Employees ee  =edao.Update(id);
      if(ee !=null) {
    	  request.setAttribute("e", ee);
          RequestDispatcher rd=request.getRequestDispatcher("editing.jsp");
          rd.forward(request, response);
      }else {
    	  request.setAttribute("e", ee);
          RequestDispatcher rd=request.getRequestDispatcher("list.jsp");
          rd.forward(request, response);
      }
       
	}
	}


