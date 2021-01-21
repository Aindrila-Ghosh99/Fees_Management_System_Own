package com.fee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fee.bean.AccountantBean;
import com.fee.dao.AccountantDao;

@WebServlet("/AddAccountant")
public class AddAccountant extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Accountant Added</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		AccountantBean bean = new AccountantBean(id, name, email, password);
		int status = AccountantDao.save(bean);

		request.getRequestDispatcher("AddAccountantForm.html").include(request, response);
		out.println("<p>Accountant is added successfully!</p>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

}
