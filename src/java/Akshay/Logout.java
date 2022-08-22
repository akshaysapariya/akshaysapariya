/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Akshay;

// Java Program to Illustrate Logout in Servlets

// Importing required classes
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Annotation
@WebServlet("/GFGLogoutServlet")

// Class
// Extending HttpServlet class
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
		throws ServletException, IOException
	{

		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html")
			.include(request,
					response); // This statement includes
								// link.html in this servlet

		// cookie with blank value is used to delete
		// a cookie to sign out the user
		Cookie c = new Cookie("username", "");
	
		// setMaxAge will set the expiration of cookie.
		// This cookie will expire in 0seconds
		c.setMaxAge(0);
	
		// Attach cookie to response
		response.addCookie(c);

		out.println("<h1>You have logged out!</h1>");
	}

	protected void doPost(HttpServletRequest request,
						HttpServletResponse response)
		throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

