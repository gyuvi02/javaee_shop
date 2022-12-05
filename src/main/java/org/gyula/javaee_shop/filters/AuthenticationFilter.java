package org.gyula.javaee_shop.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//pre-processing
		HttpServletRequest request = (HttpServletRequest)arg0;
		if(request.getRequestURI().startsWith("/HPlusSample/orderHistory")||
				request.getRequestURI().startsWith("/HPlusSample/getProfileDetails")){
			HttpSession session = request.getSession();
			if(session.getAttribute("username")==null){
				request.getRequestDispatcher("/html/login.jsp").forward(request, arg1);
			}
		}
		arg2.doFilter(request, arg1);
		//post-processing
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
