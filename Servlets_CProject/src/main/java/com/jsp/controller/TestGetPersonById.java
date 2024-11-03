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


@WebServlet("/editperson")

public class TestGetPersonById extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		int id=Integer.parseInt(req.getParameter("id"));
		PersonService pS=new PersonService();
		Person p=pS.getPersonByIdService(id);
		if(p!=null) {
			req.setAttribute("per", p);
			RequestDispatcher rD=req.getRequestDispatcher("UpdatePerson.jsp");
			rD.forward(req, resp);
		}
		else {
			RequestDispatcher rD=req.getRequestDispatcher("EditPerson.jsp");
			rD.include(req, resp);
		}
	}

}
