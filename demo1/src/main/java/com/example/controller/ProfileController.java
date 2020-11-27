package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.application.form.AnotherTestForm;
import com.example.application.form.SelectForm;
import com.example.application.form.TestForm;
import com.example.domain.service.RandomService;
import com.example.domain.service.TestInsertService;
import com.example.domain.service.TestService;

@Controller
@ComponentScan("com.example.domain")
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
    @Autowired
    RandomService randomService;
    
    @RequestMapping("dice")
	public String dice(ModelMap modelMap) {
    	List<Integer> randomList = randomService.random();
		modelMap.addAttribute("dice",randomList);
		return "dice";
	}
    
	@Autowired
	TestService testService;
	
	@RequestMapping("/ajaxTest")
	public String hoge1(Model model) {
		List<SelectForm> list = testService.getAllData();
		
		model.addAttribute("Select", list);
		return "ajaxTest";
	}
	
	@Autowired
	TestInsertService testInsert;
	
	@RequestMapping("hoge2")
	public String hoge2(AnotherTestForm form, Model model) {
		int results = 0;
		try {
			results = testInsert.insertData(form);
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		model.addAttribute("result",results);
		return "hoge2";
	}

}
