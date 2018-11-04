package com.mycompany.mywebprj;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.mywebprj.command.BCommand;
import com.mycompany.mywebprj.command.BSignupCommand;
import com.mycompany.mywebprj.dao.BDao;
import com.mycompany.mywebprj.dao.IDao;
import com.mycompany.mywebprj.dto.BDto;
import com.mycompany.mywebprj.dto.IdDto;
import com.mycompany.mywebprj.util.Constant;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	/*BDao dao;*/
	@Autowired
	private SqlSession sqlSession;
	
	/*@Autowired
	public void setDao(BDao dao) {
		this.dao = dao;
	}*/
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/*BCommand command = null;
	public JdbcTemplate template;*/
	
	/*@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}*/
	
	
	@RequestMapping("/main_view")
	public String main_view(Model model) {
		return "main_view";
	}
	
	@RequestMapping("/signup_view")
	public String signup_view(Model model) {
		
		return "signup_view";
	}
	@RequestMapping("/signup")
	public String signup(HttpServletRequest request, Model model) {
		System.out.println("signup()11");
		System.out.println("signu2");
		/*command = new BSignupCommand();*/
		
		IDao dao = sqlSession.getMapper(IDao.class);
		System.out.println("signup()22");
		
		dao.signup(request.getParameter("id"),request.getParameter("pw"));
		System.out.println("signup()33");
		/*model.addAttribute("request", request);*/
		/*command.execute(model);*/
		return "redirect:main_view";
	}
	
	@RequestMapping("/login_view")
	public String login_view(Model model) {
		return "login_view";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		System.out.println("0");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		IDao dao = sqlSession.getMapper(IDao.class); //IDaoÇü dao
		
		IdDto iddto = null;
		model.addAttribute("gid", dao.getid());
		ArrayList<IdDto> iddtoAdress = dao.getid(); 
		int a = 0;
		for (int i = 0; i < iddtoAdress.size(); i++) {
			iddto = iddtoAdress.get(i);
			System.out.println(iddto.getId());
			String gid = iddto.getId();
			if (gid.equals(id)) {
				a++;
			}
		}
		System.out.println(a);
		if (a==0) {
			return "login_view";
		}
		
		model.addAttribute("login", dao.login(id, pw));
		ArrayList<BDto> dtoAdress = dao.login(id, pw); 
		
		
		
		System.out.println("2");
		BDto dto = null;
		System.out.println("3");
		
		
		for (int i = 0; i < dtoAdress.size(); i++) {
			System.out.println(dtoAdress.get(i)); 
			dto = dtoAdress.get(i);
			System.out.println("4");
		}
		System.out.println(dto.getId());
		System.out.println("5");
		String dtoPw = dto.getPw();
		System.out.println("6");
		if (pw.equals(dtoPw)) {
			return "main_view";
		}else{
			return "login_view";
		}
	}
}
