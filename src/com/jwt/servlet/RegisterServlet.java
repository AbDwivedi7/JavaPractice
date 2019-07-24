package com.jwt.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


public class RegisterServlet extends HttpServlet{

	static final long serialVersionUID = 1L;
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n = request.getParameter("userName");
		String p = request.getParameter("password");
		String e = request.getParameter("email");
		String l = request.getParameter("language");
		System.out.println("hello1 "+l);
		Part part = request.getPart("pic");
		System.out.println("hello2 "+part);
		InputStream is = part.getInputStream();
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DemoProject", "root", "@123abhi");
			PreparedStatement ps = con.prepareStatement("insert into userdetails values (?,?,?,?,?)");
			
			ps.setString(1, n);
			ps.setString(2, p);
			ps.setString(3, e);
			ps.setString(4, l);
			ps.setBlob(5, is);
			
			int i = ps.executeUpdate();
			if(i>0) {
				out.println("you are successfully registered");
			}
		}
		catch(Exception e2) {
			System.out.println(e2);
		}
	}
}
