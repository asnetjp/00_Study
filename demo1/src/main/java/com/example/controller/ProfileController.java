package com.example.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.AnotherTestForm;
import com.example.domain.TestForm;
@Controller
//RequestMappingに指定された値でコンテキストルート以下のURLを作っていく
@RequestMapping("profile")
public class ProfileController {
	
    @RequestMapping(value = "name") //name.htmlに対して以下のメソッドが処理を行う
    public String name() {
    	//String型の戻り値がViewへの遷移を表している
    	
        return "/name.html";
    }
    
    @RequestMapping(value = "age", method = RequestMethod.POST)
    /*
     * @ModelAttribute オブジェクトに名前をつけてViewに渡す。このとき参照しているのはメソッドの引数として指定されているもの（TestForm form）
     */
    public String age(@ModelAttribute(name = "s") TestForm form) {
        return "/age.html";
    }

	
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    public String hello(TestForm form,Model model) {
    	model.addAttribute("name",form.getZz());
    	model.addAttribute("age",form.getAge());
    	model.addAttribute("blood",form.getBlood());
        return "/hello.html";
    }
    
    @RequestMapping("dice")
	public String dice(ModelMap modelMap) {
    	int dice = 0;
    	ArrayList<Integer> randomList = new ArrayList<Integer>();
    	for(int i = 0; i<5; i++) {
    		/*
    		 * Math.floor 与えられた数値以下の最大の整数を返す
    		 * Math.floorがlong型なのでintに変換
    		 */
    		dice = (int)Math.floor(Math.random() * 100);
    		randomList.add(dice);
    	}
		modelMap.addAttribute("dice",randomList);
		return "dice";
	}
    
    @RequestMapping(value="hoge")
    public String hoge(@ModelAttribute(name = "check") AnotherTestForm form) {
    	return "hoge";
    }
}
