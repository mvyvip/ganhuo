package com.ganhuo.app.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping("/a/b/c")
	public String test(String name,Model model) {
		model.addAttribute("name", "test");
		System.out.println("TestController.test()");
		return "test";
	}
	
	@RequestMapping("/index2")
	public ModelAndView test2(String name) {
		System.out.println(name);
		ModelAndView m = new ModelAndView();
		m.addObject("name", "test");
		m.setViewName("test");
		return m;
	}
	
	@RequestMapping("/index3")
	public ModelAndView test3(String name) {
		System.out.println(name);
		ModelAndView m = new ModelAndView();
		m.addObject("name", "test");
		m.setViewName("redirect:index2.jsp");
		return m;
	}
	
	@ResponseBody
	@RequestMapping(value = "/test4",method = RequestMethod.POST)
	public Map<String,Object> test4(String name) throws Exception {
		System.out.println(name);
		
		Thread.sleep(3000);
		System.out.println("save----- " + name);
		
		Map<String,Object> m = new HashMap<>();
		m.put("name", name);
		m.put("password", "root");
		return m;
	}
	
	@ResponseBody
	@RequestMapping(value = "/test5",method = RequestMethod.GET)
	public Map<String,Object> test5(String name) throws Exception {
		System.out.println(name);
		
		Thread.sleep(3000);
		System.out.println("save----- " + name);
		
		Map<String,Object> m = new HashMap<>();
		m.put("name", name);
		m.put("password", "root");
		return m;
	}
}
