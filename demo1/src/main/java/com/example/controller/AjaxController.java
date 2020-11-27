package com.example.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AjaxController {

	  @GetMapping(value = "/jq")
	  public ModelAndView index(HttpServletResponse response, ModelAndView mav) {
	    mav.setViewName("jQuery");
	    return mav;
	  }
	 
	  @PostMapping("/jq")
	  public ModelAndView postIndex(HttpServletResponse response,  @RequestBody JsonModel model, ModelAndView mav) {
	    mav.setViewName("jQuery");
	    return mav;
	  }
  
  

}