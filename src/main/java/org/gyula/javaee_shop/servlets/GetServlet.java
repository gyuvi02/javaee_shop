package org.gyula.javaee_shop.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetServlet", value = "/GetServlet")
public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String htmlResponse = "<html><h3>Welcome to the SHOPEE</h3></html>";
        PrintWriter writer = response.getWriter();
        writer.write(htmlResponse);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
