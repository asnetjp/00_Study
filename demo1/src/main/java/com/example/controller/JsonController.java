package com.example.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JsonController {

  @GetMapping(value = "/")
  public ModelAndView index(HttpServletResponse response, ModelAndView mav) {
    mav.setViewName("index");
    return mav;
  }
 
  @PostMapping("/")
  public ModelAndView postIndex(HttpServletResponse response,  @RequestBody JsonModel model, ModelAndView mav) {
    mav.setViewName("index");
    return mav;
  }
  
  

}
