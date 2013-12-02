package org.vt.ece4564.finalServer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class chat extends HttpServlet{
	
	ArrayList<String> messages = new ArrayList<String>();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		if(messages.size() > 0)
		{
			out.write(messages.get(messages.size()-1));
		}
		else
			out.write("No messages, how did you get here?");
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
			resp.setContentType("text/plain");
			String msg = req.getParameter("newMessage");
			messages.add(msg);
			
		}
}
