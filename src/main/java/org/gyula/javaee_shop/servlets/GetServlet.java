package org.gyula.javaee_shop.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns="/getServlet",
        initParams= @WebInitParam(name="URL",value="http:www.weatherservice.com"))
public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletConfig config = getServletConfig();
        System.out.println(config.getInitParameter("URL"));
        ServletContext context = getServletContext();
        System.out.println(context.getInitParameter("dbURL"));


        String htmlResponse = "<html><h3>Welcome to the SHOPEE</h3></html>";
        PrintWriter writer = response.getWriter();
        writer.write(htmlResponse);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
