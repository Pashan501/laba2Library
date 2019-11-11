package library.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.controller.UserController;
import library.fabric.MySQLConnector;
import library.model.User;

/**
 * Servlet implementation class Login_Servlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserController us = new UserController(new MySQLConnector());

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("session", request.getSession());
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/login-page.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd =  request.getRequestDispatcher("/WEB-INF/pages/login-page.jsp");
		String login = request.getParameter("email");
		String password = request.getParameter("password");
		User user = null;
		try {
			user = us.validateUser(login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(user != null) 
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath());
			System.out.println(user);
			return;
		}
		
		request.setAttribute("errorLogin", true);
		rd.forward(request, response);
		
		
	}

}
