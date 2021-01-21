package com.fee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fee.bean.AccountantBean;
import com.fee.dao.AccountantDao;

@WebServlet("/ViewAccountant")
public class ViewAccountant extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Accountant</title>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("AdminHome2.html").include(request, response);
		out.println("<div class='container'>");
		out.print("<h1>View Accountant</h1>");

		List<AccountantBean> list = AccountantDao.getAllRecords();
		out.println("<table border=\"1\" cellpadding=\"8\" class='table table-bordered table-striped'>");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Delete</th></tr>");
		for (AccountantBean bean : list) {
			out.print("<tr><td>" + bean.getId() + "</td><td>" + bean.getName() + "</td><td>" + bean.getEmail()
					+ "</td><td>" + bean.getPassword() + "</td>" + "<td><a href='DeleteAccountant?id=" + bean.getId()
					+ "'>Delete</a></td></tr>");
		}
		out.println("</table>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}
}
