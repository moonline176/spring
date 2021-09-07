package com.yedam.app2.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app2.board.domain.BoardVO;

@RestController
public class AjaxTestController {
	
	@GetMapping("/ajax1")
	@ResponseBody 
	public BoardVO test1(BoardVO vo) {
		vo.setContent("content test");
		return vo;
	}
	
	@PostMapping("/ajax2") //get은 json 이용불가
	@ResponseBody //json 변형
	public BoardVO test2(@RequestBody BoardVO vo) { //json 구조
		vo.setContent("content test");
		return vo;
	}
}
