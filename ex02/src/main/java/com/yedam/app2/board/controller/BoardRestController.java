package com.yedam.app2.board.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app2.board.domain.BoardVO;

@RestController // @controller 이면 ~.jsp 페이지를 리턴 , @RestController는 데이터를 리턴 --> 주로 ajax를 이용
public class BoardRestController {

	@RequestMapping("test1")
	@ResponseBody
	public Map<String, Object> test1(@RequestParam String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		
		if (id.equals("admin")) {
			map.put("result", true);
		} else {
			map.put("result", false);
		}
		return map;
	}
	
	@PostMapping( value = "test2" ) // ,produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE} 생략가능
	//test?id = choi -> /test/choi
	@ResponseBody //항상 필요 없으면 404에러 발생
	public BoardVO test2(BoardVO vo) {
		vo.setBno(10);
		vo.setContent("dddd");
		vo.setRegdate(new Date());
		return vo;
	}
}
