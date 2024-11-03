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


@WebServlet("/deleteperson")

public class TestDeletePerson extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		int id=Integer.parseInt(req.getParameter("id"));
		PersonService pS=new PersonService();
		Person person=pS.deletePersonService(id);
		if(person!=null) {
			RequestDispatcher rD=req.getRequestDispatcher("home.jsp");
			rD.forward(req, resp);
		}
		else {
			RequestDispatcher rD=req.getRequestDispatcher("DeletePerson.jsp");
			rD.include(req, resp);
		}
	}

}
