package com.cl.javaproject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cl.javaproject.models.Car;
import com.cl.javaproject.models.LoginUser;
import com.cl.javaproject.models.User;
import com.cl.javaproject.services.CarService;
import com.cl.javaproject.services.UserService;

@Controller
public class LoginRegController {
	
	private UserService userServ;
	private CarService carServ;
	
	public LoginRegController(UserService userServ, CarService carServ) {
		this.userServ = userServ;
		this.carServ = carServ; 
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}
	
	///// Register
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		userServ.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dash";
	}
	
	///// Login
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userServ.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		session.setAttribute("user_id", user.getId());
		return "redirect:/dash";
	}
	
	///// Dash Route
	@RequestMapping("/dash")
	public String dash(Model model, HttpSession session, RedirectAttributes flash) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId == null) {
			flash.addFlashAttribute("login", "Please login or register before entering!");
			return "redirect:/";
		}
		else {
			User user = userServ.getUser(userId);
			List<Car> cars = carServ.all();
			model.addAttribute("cars", cars);
			model.addAttribute("loggedUser", user);
			return "dash.jsp";
		}
	}
}
