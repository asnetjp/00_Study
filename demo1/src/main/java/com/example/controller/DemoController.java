package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.entity.UserData;
import com.example.domain.repository.UserDataRepository;


@Controller
public class DemoController {
	@Autowired
	UserDataRepository user;
	
	@GetMapping("/ajaxTest")
	public String ajax() {
		return "ajaxTest";
	}
	 @PostMapping("/ajaxTest")
	 @ResponseBody
	  public UserData ajaxAdd(@RequestBody UserData user) {
		user.setName("aaa");
	    return user;
	  }
}
