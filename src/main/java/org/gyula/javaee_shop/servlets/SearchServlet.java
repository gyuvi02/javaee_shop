package org.gyula.javaee_shop.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//collect search string from the form
		String searchString = req.getParameter("search");
		
		
		//call DAO layer and get all products for search criteria
		
		
		//write the products data back to the client browser
		
		
		
	}
	
	/**
	 * this methods reads the HTML template as a String, replaces placeholders
	 * with the values and returns the entire page as a String
	 * @param filePath
	 * @param products
	 * @return
	 * @throws IOException
	 */
	
	
}
