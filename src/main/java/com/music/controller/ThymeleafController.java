package com.music.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.music.pojo.User;


@Controller
@RequestMapping("th")
public class ThymeleafController {

	@RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "thymeleaf-imooc");
        return "thymeleaf/index";
    }
	
	@RequestMapping("center")
    public String center() {
        return "thymeleaf/center/center";
    }
	
	@RequestMapping("test")
    public String test(ModelMap map) {
		
		 
		
        return "thymeleaf/test";
    }
	
	@PostMapping("postform")
    public String postform(User u) {
		
		System.out.println("姓名：" + u.getUsername());
		
        return "redirect:/th/test";
    }
	
	@RequestMapping("showerror")
    public String showerror(User u) {
		
		int a = 1 / 0;
		
        return "redirect:/th/test";
    }
}