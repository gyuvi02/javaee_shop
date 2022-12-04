package org.gyula.javaee_shop.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.gyula.javaee_shop.beans.Product;
import org.gyula.javaee_shop.dao.ApplicationDao;

@WebServlet("/addProducts")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//get the HTTPSession object
		HttpSession session = request.getSession();
		
		//create a cart as arraylist for the user
		List<String> cart = (ArrayList<String>)session.getAttribute("cart");
		
		if(cart==null){
			cart = new ArrayList<>();
		}

		//add the selected product to the cart
		if(request.getParameter("product")!=null){
			cart.add(request.getParameter("product"));
		}
		
		session.setAttribute("cart", cart);


		//get search criteria from search servlet
		
		String search = (String)session.getAttribute("search");
		
		
		//get the search results from dao
		ApplicationDao dao = new ApplicationDao();
		List<Product> products = dao.searchProducts(search);
		
		//set the search results in request scope
		request.setAttribute("products", products);
		
		//forward to searchResults.jsp
		request.getRequestDispatcher("/html/searchResults.jsp").forward(request, response);


	}


	
}