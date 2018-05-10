package com.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.music.pojo.User;


@Controller  
@SpringBootApplication 
public class LoginController {
 
/*	@Autowired
	private UserManageService userManageService;
	*/
    @RequestMapping("/user") 
	public String execute()throws Exception{
		
		
		return "view/plugins/main";
	}
    
    @RequestMapping("/errorPage")
    public String error(ModelMap map){
    	System.out.println("启动  ");
    	map.addAttribute("headerContent", "hello word!");
    return "error";
    }
}
