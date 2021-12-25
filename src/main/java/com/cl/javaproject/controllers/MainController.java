package com.cl.javaproject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cl.javaproject.models.BodyType;
import com.cl.javaproject.models.Car;
import com.cl.javaproject.models.CarMake;
import com.cl.javaproject.models.CarYear;
import com.cl.javaproject.models.State;
import com.cl.javaproject.services.CarService;

@Controller
public class MainController {
	
	private CarService carServ;
	
	public MainController(CarService carServ) {
		this.carServ = carServ;
	}
	
	///// Edit
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, HttpSession session, RedirectAttributes flash, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId== null) {
			flash.addFlashAttribute("login", "Please login or register before entering!");
			return "redirect:/";
		}
		Car car = carServ.findCar(id);
		if(car.getUser().getId().equals(userId)) {
			List<CarMake> make = carServ.make();
			List<CarYear> year = carServ.year();
			List<BodyType> type = carServ.type();
			List<State> state = carServ.state();
			model.addAttribute("make", make);
			model.addAttribute("year", year);
			model.addAttribute("type", type);
			model.addAttribute("state", state);
			model.addAttribute("car", car);
			return "edit.jsp";
		}
		else {
			flash.addFlashAttribute("dash", "Must be the owner to edit listing!");
			return "redirect:/dash";
		}
	}
	
	@PutMapping("/update/{id}")
	public String update(@Valid @ModelAttribute("car") Car car, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			carServ.editCar(car);
			return "redirect:/dash";
		}
	}
	
	///// View
	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") Long id, Model model, HttpSession session, RedirectAttributes flash) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId== null) {
			flash.addFlashAttribute("login", "Please login or register before entering!");
			return "redirect:/";
		}
		else {
			Car car = carServ.findCar(id);
			model.addAttribute("car", car);
			return "view.jsp";
		}
	}
	
	///// Create
	@RequestMapping("/sell")
	public String sell(Model model, HttpSession session, RedirectAttributes flash) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId == null) {
			flash.addFlashAttribute("login", "Please login or register before entering!");
			return "redirect:/";
		}
		else {
			List<CarMake> make = carServ.make();
			List<CarYear> year = carServ.year();
			List<BodyType> type = carServ.type();
			List<State> state = carServ.state();
			model.addAttribute("make", make);
			model.addAttribute("year", year);
			model.addAttribute("type", type);
			model.addAttribute("state", state);
			model.addAttribute("userId", userId);
			model.addAttribute("car", new Car());
			return "sell.jsp";
		}
	}
	
	@PostMapping("/add")
	public String createListing(@Valid @ModelAttribute("car") Car car, BindingResult result) {
		if(result.hasErrors()) {
			return "sell.jsp";
		}
		else {
			carServ.addCar(car);
			return "redirect:/dash";
		}
	}
	
	///// Delete route
	@DeleteMapping("/delete/{id}")
		public String delete(@PathVariable("id") Long id, HttpSession session, RedirectAttributes flash) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId== null) {
			flash.addFlashAttribute("login", "Please login or register before entering!");
			return "redirect:/";
		}
		Car car = carServ.findCar(id);
		if(car.getUser().getId().equals(userId)) {
			carServ.delete(id);
			return "redirect:/dash";
		}
		else {
			flash.addFlashAttribute("dash", "Must be the owner to delete listing!");
			return "redirect:/dash";
		}
	}
	
	///// Logout
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
