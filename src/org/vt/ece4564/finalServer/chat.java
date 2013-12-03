package org.vt.ece4564.finalServer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class chat extends HttpServlet {

	ArrayList<String> messages = new ArrayList<String>();
	ArrayList<String> serverMessages = new ArrayList<String>();
	int index = 0;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		
		if(req.getQueryString().equals("app")){			
			
			if(serverMessages.size() > 0){
				
				while(index<serverMessages.size()){
					
					out.write(serverMessages.get(index)+"\n");
				
				}
			}
		}
		else{
			for(int i = 0; i < messages.size()-1;i++)
			{
				out.write(messages.get(i) + "\n");
			}
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		resp.setContentType("text/plain");
		String msg = req.getParameter("newMessage");
		String sender = req.getParameter("sender");
		if(!sender.equals("client"))
			serverMessages.add(msg);
		messages.add(msg);

	}
}
