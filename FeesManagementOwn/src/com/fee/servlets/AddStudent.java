
package com.fee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fee.bean.StudentBean;
import com.fee.dao.StudentDao;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int roll = Integer.parseInt(request.getParameter("roll"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String course = request.getParameter("course");
		int fee = Integer.parseInt(request.getParameter("fee"));

		StudentBean bean = new StudentBean(roll, name, email, sex, course, fee);
		int status = StudentDao.save(bean);
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Student</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");

		request.getRequestDispatcher("AddStudentForm.html").include(request, response);
		out.println("Student is added successfully!");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

}
