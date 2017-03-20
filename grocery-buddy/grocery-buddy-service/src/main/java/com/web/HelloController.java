package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.business.UserBusiness;

@Controller
public class HelloController {
	private UserBusiness userBusinessFacade;

	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC and RESTful Framework!");
		model.addAttribute("users", userBusinessFacade.getAllUsers());

		return "hello";
	}

	public UserBusiness getUserBusinessFacade() {
		return userBusinessFacade;
	}

	@Autowired
	public void setUserStoryBusinessFacade(UserBusiness userBusinessFacade) {
		this.userBusinessFacade = userBusinessFacade;
	}
}
