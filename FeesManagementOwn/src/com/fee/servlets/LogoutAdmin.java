package com.fee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutAdmin")
public class LogoutAdmin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Admin Logout</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");

		out.println("<h1>Admin Logout Success</h1>");
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("AdminLoginForm.html").include(request, response);

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

}
