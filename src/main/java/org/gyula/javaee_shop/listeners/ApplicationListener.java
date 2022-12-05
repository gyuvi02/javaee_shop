package org.gyula.javaee_shop.listeners;

import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import jakarta.servlet.annotation.WebListener;
import org.gyula.javaee_shop.dao.DBConnection;

public class ApplicationListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("in contextDestroyed method");
		Connection connection = (Connection)arg0.getServletContext().getAttribute("dbconnection");
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("in contextinitialized method");
		Connection connection = DBConnection.getConnectionToDatabase();
		arg0.getServletContext().setAttribute("dbconnection", connection);
	}

}
