package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.web.EmployeeDAO;
import com.web.Employees;

@WebServlet("/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAO ed=new EmployeeDAO();
		List<Employees> li = ed.getAll();
		request.setAttribute("list", li);
		RequestDispatcher rd=request.getRequestDispatcher("list.jsp");
		rd.forward(request, response);
	}

}
