package library.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import config.ControllerConfig;
import library.controller.BookController;
import library.controller.UserController;
import library.model.Book;
import library.model.User;
import library.parser.JsonParser;

@Controller
@RequestMapping("/Max")
public class DispatcherController {

	private ApplicationContext context;
	private ApplicationContext dbContext;
	
	
	@GetMapping(value = "/Login")
	public String loginGet(ModelMap mp)
	{
		mp.addAttribute("session",getSession());
		mp.addAttribute("errorLogin",false);
		return "login-page";
	}
	
	@PostMapping(value = "/Login",params = {"email","password"})
	public String loginPost(ModelMap mp,@RequestParam("email")String email,@RequestParam("password")String password,HttpServletRequest request) throws SQLException 
	{
		dbContext = new ClassPathXmlApplicationContext("connection-config.xml");
		String page = "login-page";
		User user = ((UserController) dbContext.getBean("controllerUser")).validateUser(email, password);
		if(user != null) 
		{
			HttpSession session = getSession();
			session.setAttribute("user", user);
			page = "redirect:/Max/MainPage.php";
		}else 
			mp.addAttribute("errorLogin",true);
		return page;
	}
	
	@GetMapping("/Register")
	public String registerGet(ModelMap mp) 
	{
		mp.addAttribute("session",getSession());
		mp.addAttribute("form",true);
		return "register-page";
	}
	
	@PostMapping(value="/Register",params= {"email","name","surName","password","rePassword","country","city","street"})
	public String registerPost(ModelMap mp, @RequestParam(name="email",required=false) String email,
			@RequestParam(name="name",required=false) String name, @RequestParam(name="surName",required=false) String surName,
			@RequestParam(name="password",required=false) String password,
			@RequestParam(name="rePassword",required=false)String rePassword,
			@RequestParam(name="country",required=false) String country,
			@RequestParam(name="city",required=false) String city,
			@RequestParam(name="street",required=false) String street) 
	{
		
		boolean error = false;
		boolean form = true;
		if(email != null) 
		{
			if(email.length() == 0) 
			{
				error = true;
			}
			
			if(name.length() == 0) 
			{
				error = true;
			}
			if(surName.length() == 0) 
			{
				error = true;
			}
			
			if(password.length() == 0) 
			{
				error = true;
			}
			if(rePassword.length() == 0) 
			{
				error = true;
			}
			
			if(country.length() == 0) 
			{
				error = true;
			}
			
			if(city.length() == 0) 
			{
				error = true;
			}
			if(street.length() == 0) 
			{
				error = true;
			}
		}
		
		if(error) 
		{
			mp.addAttribute("email",email);
			mp.addAttribute("name",name);
			mp.addAttribute("surName",surName);
			mp.addAttribute("country",country);
			mp.addAttribute("city",city);
			mp.addAttribute("street",street);
			mp.addAttribute("error",error);
		}else 
		{
			if(dbContext == null)
				dbContext = new ClassPathXmlApplicationContext("connection-config.xml");
			UserController uc = (UserController) dbContext.getBean("controllerUser");
			uc.insertUser(name,surName, email, country, city, street, password);
			form = false;
			mp.addAttribute("form",form);
		}
		
		mp.addAttribute("error",error);
		return "register-page";
	}
	
	
	@GetMapping("/MainPage")
	public String mainPageGet(ModelMap mp) 
	{
		mp.addAttribute("session",getSession());
		return "main-page";
	}
	
	@GetMapping("/ErrorPage")
	public String error403Forbidden() 
	{
		return "error-403";
	}
	
	@GetMapping(value = "/Logout", params = {"logout"})
	public String userLogout(@RequestParam(name = "logout",required = false) String logout) 
	{
		UserController.invalidateUser(getSession());
		return "redirect:/Max/MainPage.php";
	}
	
	@GetMapping("/BookAjax")
	@ResponseBody
	public List<Book> bookAjaxGet() throws SQLException
	{
		if(dbContext == null)
			dbContext = new ClassPathXmlApplicationContext("connection-config.xml");
		BookController bc = (BookController) dbContext.getBean("controllerBook");
		
		return bc.getAllBooks();
	}
	
	
	@PostMapping(value = "/BookAjax",consumes = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public  void bookAjaxPost(@RequestBody Book book) throws IOException 
	{
		
		System.out.println("Proverka 1 ID: " + book.getId());
		BookController bc = (BookController) dbContext.getBean("controllerBook");
		System.out.println("Proverka 2  ID: " + book.getId());
		try {
			bc.deleteBookById(book.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
	
	@GetMapping(value = "/SingleBookPage", params= {"bookId"})
	public String singleBookPageGet(ModelMap mp, @RequestParam String bookId) 
	{
		
		return "single-page";
	}
	public static HttpSession getSession() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession();
	}
}
