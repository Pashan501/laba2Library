package library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import library.controller.BookController;
import library.fabric.MySQLConnector;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookController bk = new BookController(new MySQLConnector());
   
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = "";
		try {
			json = new Gson().toJson(bk.getAllBooks());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(json);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
