package org.gyula.javaee_shop.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.gyula.javaee_shop.dao.ApplicationDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//dispatch the request to login.jsp resource

		String html = "<html><h3>Please login</h3></html>";
		resp.getWriter().write(html + " ");

		RequestDispatcher dispatcher = req.getRequestDispatcher("/html/login.jsp");
		dispatcher.include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get the username from the login form
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//call DAO for validation logic
		ApplicationDao dao = new ApplicationDao();
		boolean isValidUser = dao.validateUser(username, password);
		//check if user is invalid and set up an error message
		if (isValidUser) {
			//set up the HTTP session
			HttpSession session = req.getSession();
			//set the username as an attribute
			session.setAttribute("username", username);
			//forward to home jsp
			req.getRequestDispatcher("/html/home.jsp").forward(req, resp);
		} else {
			String errorMessage = "Invalid Credentials, please login again!";
			req.setAttribute("error", errorMessage);
			req.getRequestDispatcher("/html/login.jsp").forward(req, resp);
		}
	}
}
