package org.gyula.javaee_shop.servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.gyula.javaee_shop.beans.Order;
import org.gyula.javaee_shop.dao.ApplicationDao;

@WebServlet("/orderHistory")
public class OrderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get username from session
		String username = (String) request.getSession().getAttribute("username");

		// call dao and get order history
		ApplicationDao dao = new ApplicationDao();
		List<Order> orders = dao.getOrders(username);

		// set order data in request
		request.setAttribute("orders", orders);

		// forward to home jsp
		request.getRequestDispatcher("/html/home.jsp").forward(request, response);

	}

}
