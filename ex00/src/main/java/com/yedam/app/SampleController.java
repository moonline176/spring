package com.yedam.app;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.java.Log;


//pojo : 상속 x 
@Controller // -> @Controller 상속해서, @Service, @Repository(=dao)
@RequestMapping("/sample/*")
@Log
public class SampleController {
	
	@RequestMapping("/ex09")
	@ResponseBody //자바객체 -> json 스트링 변환
	public SampleVO ex07(SampleVO sample) {
		sample.setName("홍길동");
		sample.setAge(50);
		return sample; //json type으로 넘어감
	}
	
	@RequestMapping("/ex06/{name}/{age}")
	public void ex06(@PathVariable String name,
					 @PathVariable int age) {
		log.info("name="+name);
		log.info("age"+age);
	}
	
	@RequestMapping("/ex05")
	public void ex05(SampleVoList list) {
		log.info(list.toString());
		}
	
	@RequestMapping("/ex04")
	public void ex04(@RequestParam List<String> ids) {
		log.info(ids.toString());
	}
	
	@RequestMapping("/ex03")
	public void ex03(@RequestParam String[] ids) {
		// String[] ids = request.getParameterValues("ids");
		log.info(Arrays.toString(ids));
	}
	
	@GetMapping("/ex02")
	public void ex02(@RequestParam (name="username")String name,
					 @RequestParam (required = false, defaultValue = "10")int age
			) {
		//String name = request.getParameter("name");\
		log.info("name="+name);
		log.info("age="+age);
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleVO vo, Model model) {
		log.info(vo.toString());
		//model.addAttribute("sampleVO", vo);
		model.addAttribute("pageNo", "10");
		return "sample/ex01";
	}
	
	//@RequestMapping(value="/a", method = RequestMethod.POST)
	@GetMapping("/a")
	public String basic1() {
		log.info("basic1......");
		return "sample/basica";	//jsp 뷰페이지 리턴
	}
	@RequestMapping("/b")
	public void basic2() {	//void 인경우 url과 일치하는 뷰페이지로 포워드
		log.info("basic2......");

	}
	
}
