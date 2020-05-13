package library.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	private final ApplicationContext dbContext = new ClassPathXmlApplicationContext("connection-config.xml");
	
	
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
	public List<Book> bookAjaxGet(@RequestParam(value = "search", required=false) String search) throws SQLException
	{
		List<Book> list = null;
		BookController bc = (BookController) dbContext.getBean("controllerBook");	
		if(search != null )
			list = bc.getBooksMySearch(search);
		else
			list = bc.getAllBooks();
		
		return list;
	}
	
	
	@PostMapping(value = "/BookAjax",consumes = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public  void bookAjaxPost(@RequestBody Book book) throws IOException 
	{
		
		BookController bc = (BookController) dbContext.getBean("controllerBook");
		try {
			bc.deleteBookById(book.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
	
	@GetMapping(value = "/SingleBookPage", params= {"bookId"})
	public String singleBookPageGet(ModelMap mp, @RequestParam String bookId) throws BeansException, NumberFormatException, SQLException 
	{
		Book book = ((BookController) dbContext.getBean("controllerBook")).getBookById(Integer.parseInt(bookId));
		mp.addAttribute("name",book.getName());
		mp.addAttribute("genre",book.getGenre());
		mp.addAttribute("authorName",book.getAuthorName());
		mp.addAttribute("description",book.getDescription());
		mp.addAttribute("year",book.getYear());
		mp.addAttribute("imageSource",book.getImgSource());
		mp.addAttribute("session",getSession());
		return "book_info";
	}
	
	@PostMapping(value = "/EditBook",params = {"bookId","name","description","genre","authorName","year"})
	public String upload(@RequestParam(required=false) CommonsMultipartFile  file,
			@RequestParam("name") String name, @RequestParam("description") String description,
			@RequestParam("genre") String genre, @RequestParam("authorName") String authorName,
			@RequestParam("year") String year, @RequestParam("bookId") String bookId,
			@RequestParam(value = "check", required=false) String check) throws BeansException, NumberFormatException, SQLException, IOException 
	{
		System.out.println(bookId);
		BookController bc = (BookController) dbContext.getBean("controllerBook");
		String path=getSession().getServletContext().getRealPath("/");  
		Book book = bc.getBookById(Integer.parseInt(bookId));
		book.setName(name);
		book.setDescription(description);
		book.setGenre(genre);
		book.setAuthorName(authorName);
		book.setYear(Integer.parseInt(year));
		if(check == null && file.getOriginalFilename().length() > 1) 
		{
			if(file.getOriginalFilename().endsWith(".jpg") || file.getOriginalFilename().endsWith(".png")) 
			{
				File fileWrite = new File(path + "img-books/"+file.getOriginalFilename());
				if(fileWrite.exists()) // проверяю на существования файла в папки, чтобы его заново не переписывать
					book.setImgSource("../img-books/"+file.getOriginalFilename());
				else 
				{
					byte bytes[] = file.getBytes();
					FileOutputStream fos = new FileOutputStream(fileWrite);
					fos.write(bytes);
					fos.flush();
					fos.close();
					book.setImgSource("../img-books/"+file.getOriginalFilename());
				}
			}
		}else
			if(check != null) 
			{
				book.setImgSource(" ");
			}
	bc.updateBook(book);
	
		return "redirect:/Max/MainPage.php";
	}
	
	@GetMapping("/basketcase")
	public String getBaksetPage()
	{
		return "basket-page";
	}
	
	
	public static HttpSession getSession() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession();
	}
}
