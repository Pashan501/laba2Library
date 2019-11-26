package library.servlet;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
@RequestMapping("/Max")
public class DispatcherController {

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String get(ModelMap mp) 
	{
		mp.addAttribute("session",getSession());
		return "login-page";
	}
	
	public static HttpSession getSession() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession();
	}
}
