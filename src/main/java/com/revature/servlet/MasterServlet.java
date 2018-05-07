package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name="MasterServlet", urlPatterns= {"/*.do"})
public class MasterServlet  extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    public MasterServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		public void init(ServletConfig config) throws ServletException {
			System.out.println("init method - MasterServlet");
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doGet - MasterServlet");
			
			PrintWriter pw = response.getWriter();
			pw.append("Hello world - get method");
			pw.println();
			response.setContentType("text/html");
			String s1 = request.getParameter("param1");
			String s2 = request.getParameter("param2");
			pw.println("<html><body><div> "
					+ s1 + " : " + s2 + ", are the values entered </div></body></html>");
			pw.close();
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doPost");

			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.append("Hello world - Post method");
			String s1 = request.getParameter("param1");
			String s2 = request.getParameter("param2");
			pw.println("<html><body><div> "
					+ s1 + " : " + s2 + ", are the values entered </div></body></html>");
			pw.close();
		}
	

}
