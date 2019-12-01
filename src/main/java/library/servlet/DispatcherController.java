package library.servlet;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import config.ControllerConfig;
import library.controller.UserController;
import library.model.User;

@Controller
@RequestMapping("/Max")
public class DispatcherController {

	private ApplicationContext context;
	private ApplicationContext dbContext;
	
	
	@GetMapping(value = "/Login")
	public String loginGetWithParam(ModelMap mp)
	{
		mp.addAttribute("session",getSession());
		return "login-page";
	}
	
	@GetMapping("/Register")
	public String registerGet(ModelMap mp) 
	{
		mp.addAttribute("session",getSession());
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
		
		
		return "register-page";
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
		{
			String errorLogin = "Wrong data";
			mp.addAttribute("errorLogin",errorLogin);
		}
		return page;
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
		context = new ClassPathXmlApplicationContext("connection-config.xml");
		UserController uc = (UserController) context.getBean("controllerUser");
		uc.invalidateUser(getSession());
		return "redirect:/Max/MainPage.php";
	}
	
	
	
	public static HttpSession getSession() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession();
	}
}
