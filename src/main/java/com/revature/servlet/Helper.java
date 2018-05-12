package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Helper
{
	public static String processRequest(HttpServletRequest request, HttpServletResponse response)
	{
		switch(request.getRequestURI())
		{
			case "/RevatureP2/postTest.do":
				return("/postTest.html");
			case "/RevatureP2/getTest.do":
				return("/getTest.html");
			default:
				return("/index.jsp");
		}
	}
}
