package com.mycompany.mywebprj;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.mywebprj.command.BCommand;
import com.mycompany.mywebprj.command.BSignupCommand;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	BCommand command = null;
	@RequestMapping("/main_view")
	public String main_view(Model model) {
		return "main_view";
	}
	
	@RequestMapping("/signup_view")
	public String signup_view(Model model) {
		
		return "signup_view";
	}
	@RequestMapping("/signup")
	public String signup(Model model) {
		command = new BSignupCommand();
		return "redirect:main_view";
	}
	
	@RequestMapping("/login_view")
	public String login_view(Model model) {
		return "login_view";
	}
	
	
}
