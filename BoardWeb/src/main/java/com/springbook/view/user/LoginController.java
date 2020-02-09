package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	@Autowired
	UserService userService;

	@RequestMapping(value="/login.do",method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		//jsp 파일에서 쓰려고 set해준다. 
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) {
		System.out.println("로그인 처리");
		UserVO user = userService.getUser(vo);
		
	    if(userService.getUser(vo) != null) {
	    	session.setAttribute("userName",user.getName());
	    	return "getBoardList.do";
	    }
	    else
	    	return "login.jsp";
	}
}
