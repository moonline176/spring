package com.yedam.app2.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app2.board.domain.BoardVO;
import com.yedam.app2.board.service.BoardService;


@Controller
@RequestMapping("/board/*")

	public class BoardController {

	@Autowired BoardService boardService;
	//전체조회
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", boardService.getList());
		
	}
	
	//단건 조회(수정페이지)
	@GetMapping({"/get","/modify"}) //수정폼
	public void get(@RequestParam("bno") Long bno, Model model) {
		BoardVO board = new BoardVO();
		board.setBno(bno);
		model.addAttribute("board", boardService.read(board));
	}
	
	//수정
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		int result = boardService.update(vo);
		if(result == 1) {
		rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/get?bno="+vo.getBno(); //redirect 파라미터 전달x
	}
	
	//등록
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		
		boardService.insert(vo);
		rttr.addFlashAttribute("result",vo.getBno());
		return "redirect:/board/list"; //redirect 파라미터 전달x
	}
	
	@GetMapping("/register") //등록
	public void registerForm() {
		
	}
	
	//삭제
	@RequestMapping("/remove")
	public String remove(BoardVO vo, RedirectAttributes rttr) {
		int result = boardService.remove(vo);
		if(result == 1) {
		rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list"; //redirect 파라미터 전달x
	}
}
