package com.ganhuo.app.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@ResponseBody
	@RequestMapping("/test")
	public Map<String,Object> test() {
		System.out.println("TestController.test()");
		Map<String,Object> m = new HashMap<>();
		m.put("name", "test");
		return m;
	}
}
