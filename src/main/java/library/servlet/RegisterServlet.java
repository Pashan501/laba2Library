package library.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("session", request.getSession());

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/register-page.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean showForm = true;
		boolean isError = false;

		String name = request.getParameter("name");
		String surname = request.getParameter("surName");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String rePsw = request.getParameter("re-password");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String errorText = "<ul>";
		if (showForm) {
			if (email != null && email.length() == 0) {
				isError = true;
				errorText += "<li> Email is empty </li>";
			}
			if (name != null && name.length() == 0) {
				isError = true;
				errorText += "<li> Name is empty </li>";
			}
			if (surname != null && surname.length() == 0) {
				isError = true;
				errorText += "<li> Surname is empty </li>";
			}
			if ((pass != null || rePsw != null) && (pass.length() == 0 || rePsw.length() == 0)) {
				isError = true;
				errorText += "<li> Password or re-password are empty </li>";
			}
			if ((pass != null || rePsw != null) && (!pass.equals(rePsw))) {
				isError = true;
				errorText += "<li> Password and re-password aren`t equals </li>";
			}
			if (country != null && country.length() == 0) {
				isError = true;
				errorText += "<li> Country is empty </li>";
			}
			if (city != null && city.length() == 0) {
				isError = true;
				errorText += "<li> City is empty </li>";
			}
			if (street != null && street.length() == 0) {
				isError = true;
				errorText += "<li> Street is empty </li>";
			}
		}
		if (isError) {
			showForm = true;
			errorText += "</ul>";
		}if(!showForm){
		System.out.println("Email: " + email + "</br>");
		System.out.println("Name: " + name + "</br>");
		System.out.println("Surname: " + surname + "</br>");
		System.out.println("Password: " + pass + "</br>");
		System.out.println("Re-pass: " + rePsw + "</br>");
		System.out.println("Country: " + country + "</br>");
		System.out.println("City: " + city + "</br>");
		System.out.println("Street: " + street + "</br>");

	}

}}
