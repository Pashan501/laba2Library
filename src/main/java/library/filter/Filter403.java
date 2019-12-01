package library.filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import library.controller.UserController;


public class Filter403 implements Filter {

    private String param1;

    public Filter403() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		HttpSession session = httpRequest.getSession();
		
		if(session.getAttribute("user") != null) 
		{
			RequestDispatcher rd = httpRequest.getRequestDispatcher("/Max/ErrorPage.php");
			rd.forward(request, response);
		}
		
		String str = "";
		if(new File("log.txt").exists()) 
		{
			BufferedReader reader = new BufferedReader(new FileReader(new File("log.txt")));
			int c = 0;
			while((c = reader.read()) != -1) 
			{
				str += (char) c;
			}
			reader.close();
		}
		PrintWriter out = new PrintWriter(new File("log.txt"));
		out.write(str + "\n param1" + param1 + " user IP:" + request.getRemoteAddr() + " Date: " + new Date().toString());
		out.close();
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		param1 = fConfig.getInitParameter("param1");
	}

}
