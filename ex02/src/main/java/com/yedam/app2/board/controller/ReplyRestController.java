package com.yedam.app2.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app2.board.domain.Criteria;
import com.yedam.app2.board.domain.ReplyPageVO;
import com.yedam.app2.board.domain.ReplyVO;
import com.yedam.app2.board.service.ReplyService;


@RestController
@RequestMapping("/reply/*")
public class ReplyRestController {

	@Autowired
	ReplyService replyService;

	//해당 게시글의 댓글 조회
	@GetMapping("/")
	public ReplyPageVO getList(Criteria cri, @RequestParam Long bno){
		return replyService.getList(cri, bno);
	}
	
	//댓글조회
	@GetMapping("/{rno}") // queryString 방식
	public ReplyVO read(@PathVariable Long rno, ReplyVO vo){
		vo.setRno(rno);
		return replyService.readRe(vo);
	}
	
	//등록
	@PostMapping("/") //post : 파라미터 질의문자열 (query string) -> ?id=100&pw=111&name=choi 
	public ReplyVO insert(ReplyVO vo) { //form에 값 넘겨줌
		replyService.insertRe(vo);
		return vo;
	}
	
	//수정
	@PutMapping("/")  //put, delete : 파라미터 json만 가능 -> { id:100, pw:"111", name:"choi"}
	public ReplyVO update(@RequestBody ReplyVO vo) { //RequestBody 필요
		replyService.updateRe(vo);
		return replyService.readRe(vo);
	}
	
	//삭제
	@DeleteMapping("/{rno}")
	public boolean delete(@PathVariable Long rno, ReplyVO vo) {
		vo.setRno(rno);
		int r = replyService.deleteRe(vo);
		return r == 1 ? true : false;
	}
	

}
