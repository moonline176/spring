package com.yedam.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // = @Controller + @ResponseBody --> 전부 ajax 요청시에 사용
public class AjaxController {

	@RequestMapping("/ex07")
	public SampleVO ex07(SampleVO sample) {
		sample.setName("홍길동");
		sample.setAge(50);
		return sample; //json type으로 넘어감
	}
	
	@RequestMapping("/ex08")
	public List<SampleVO> ex07() {
		List<SampleVO> list = new ArrayList<>();
		list.add(new SampleVO("choi",10,new Date()));
		list.add(new SampleVO("park",10,new Date()));
		list.add(new SampleVO("kim",10,new Date()));
		
		return list; //json type으로 넘어감
	}

}
