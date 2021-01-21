package com.fee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fee.bean.StudentBean;
import com.fee.dao.StudentDao;

@WebServlet("/ViewStudent")
public class ViewStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Student</title>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("AccountantHome2.html").include(request, response);
		out.println("<div class='container'>");

		out.print("<h1>View Students</h1>");

		List<StudentBean> list = StudentDao.getAllRecords();
		out.println("<table border=\"1\" cellpadding=\"10\" class='table table-bordered table-striped'>");
		out.print(
				"<tr><th>Rollno</th><th>Name</th><th>Email</th><th>Sex</th><th>Course</th><th>Fee</th><th>Delete</th></tr>");
		for (StudentBean bean : list) {
			out.print("<tr><td>" + bean.getRollno() + "</td><td>" + bean.getName() + "</td><td>" + bean.getEmail()
					+ "</td><td>" + bean.getSex() + "</td><td>" + bean.getCourse() + "</td><td>" + bean.getFee()
					+ "</td>" + "<td><a href='DeleteStudent?rollno=" + bean.getRollno() + "'>Delete</a></td></tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

}
