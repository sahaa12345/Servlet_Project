package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Person;
import com.jsp.service.PersonService;


@WebServlet("/updateperson")

public class TestUpdatePerson extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
	Person p=new Person();
	p.setId(Integer.parseInt(req.getParameter("id")));
	p.setName(req.getParameter("name"));
	p.setAge(Integer.parseInt(req.getParameter("age")));
	p.setEmail(req.getParameter("email"));
	p.setPassword(req.getParameter("password"));
	PersonService pS=new PersonService();
	Person p2=pS.updatePersonService(p);
	if(p2!=null) {
		RequestDispatcher rD=req.getRequestDispatcher("home.jsp");
		rD.forward(req, resp);
	}
	else {
		RequestDispatcher rD=req.getRequestDispatcher("EditStudent.jsp");
		rD.include(req, resp);
	}
  }
}
	


