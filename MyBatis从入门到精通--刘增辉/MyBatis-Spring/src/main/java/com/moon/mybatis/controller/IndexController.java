package com.moon.mybatis.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping(value = {"", "/index2"})
	public ModelAndView dicts2() {
		
		ModelAndView mv = new ModelAndView("index2");
		mv.addObject("now", new Date());
		
		return mv;
	}
	
	
	@RequestMapping(value = {"", "/index"})
	public ModelAndView dicts() {
		
		ModelAndView mv = new ModelAndView("index2");
		mv.addObject("now", new Date());
		
		return mv;
	}
	
	
	
}
