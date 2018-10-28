package com.mycompany.mywebprj.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.mycompany.mywebprj.dao.BDao;

public class BSignupCommand implements BCommand {

	

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		// TODO Auto-generated method stub
		HttpServletRequest request = 
				(HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		BDao dao = new BDao();
		dao.signup(id, pw);
	}

}
