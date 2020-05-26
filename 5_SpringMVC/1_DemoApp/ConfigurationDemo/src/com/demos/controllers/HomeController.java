package com.demos.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String landing() {
		return "landing";
	}
	
	@RequestMapping("/processform")
	public String getPage() {
		return "main-menu";
	}
	
	@RequestMapping("/getName")
	public String showPage() {
		return "show-menu";
	}
	
	// Read form data and put it inside MODEL - @RequestParam
	@RequestMapping("/processformV2")
//	public String JspToMODEL(HttpServletRequest httpServletRequest, Model model) {
	public String JspToMODEL(@RequestParam("stnm") String name, Model model) {
		
		//String name = httpServletRequest.getParameter("stnm");
		String newNm = name.toUpperCase();
		String msg = "Youre a dumb guy : " + newNm;
		model.addAttribute("message", msg);
		
		return "main-menu-model";
	}
	@RequestMapping("/processformTwo")
	public String getPages() {
		return "show-menu-model";
	}
}
