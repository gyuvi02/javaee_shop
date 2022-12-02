package org.gyula.javaee_shop.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.gyula.javaee_shop.beans.User;
import org.gyula.javaee_shop.dao.ApplicationDao;

@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// collect all form data
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		String activity = req.getParameter("activity");
		int age = Integer.parseInt(req.getParameter("age"));
		

		// fill it up in a User bean
		User user = new User(username, password, firstName, lastName, age, activity);



		// call DAO layer and save the user object to DB
		ApplicationDao dao = new ApplicationDao();
		int rows = dao.registerUser(user);


		// prepare an information message for user about the success or failure of the operation
		String infoMessage = null;
		if(rows==0){
			infoMessage="Sorry, an error occurred!";
		}
		else{
			infoMessage="User registered successfully!";
		}

		// write the message back to the page in client browser\
		String page = getHTMLString(req.getServletContext().getRealPath("/html/register.html"), infoMessage);
		resp.getWriter().write(page);
	}

	public String getHTMLString(String filePath, String message) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line="";
		StringBuffer buffer = new StringBuffer();
		while((line=reader.readLine())!=null){
			buffer.append(line);
		}

		reader.close();
		String page = buffer.toString();

		page = MessageFormat.format(page, message);

		return page;


	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*String page = getHTMLString(req.getServletContext().getRealPath("/html/register.html"), "");
		resp.getWriter().write(page);*/
	}
}
