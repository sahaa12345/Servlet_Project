package com.jsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Person;
import com.jsp.service.PersonService;


@WebServlet("/displayperson")

public class TestDisplayPerson extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PersonService pS=new PersonService();
		List<Person> list=pS.getAllPersonService();
		if(list.size()>0) {
			req.setAttribute("list", list);
			RequestDispatcher rD=req.getRequestDispatcher("DisplayPerson.jsp");
			rD.forward(req, resp);
		}
		else {
			RequestDispatcher rD=req.getRequestDispatcher("home.jsp");
			rD.include(req, resp);
		}
	}

}
