package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
@Controller
//RequestMappingに指定された値でコンテキストルート以下のURLを作っていく
@RequestMapping("profile")
//クラスをnameという名前でセッションに保持
@SessionAttributes(names = "name")
public class ProfileController {
	/*
	 * 指定したクラスにリクエストパラメータをバインド（結びつけ）する
	 * setter?
	*/
	@ModelAttribute("name")
	public String setName(String name) {
		return name;
	}
    @RequestMapping(value = "name") //name.htmlに対して以下のメソッドが処理を行う
    public String name() {
    	//戻り値がViewへの遷移を表している
        return "name";
    }
    @RequestMapping(value = "age", method = RequestMethod.POST)
    //@RequestParam でViewから th:action で送られてきたパラメータを受け取る。name属性の値を指定。
    public String age(@RequestParam("name") String name, ModelMap modelMap) {
        setName(name);
        return "age";
    }
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    public String hello(@RequestParam("age") String age, ModelMap modelMap, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
    	modelMap.addAttribute("age", age);
        return "hello";
    }
}
