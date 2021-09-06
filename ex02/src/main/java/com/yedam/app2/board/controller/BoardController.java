package com.yedam.app2.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app2.board.domain.BoardVO;
import com.yedam.app2.board.domain.Criteria;
import com.yedam.app2.board.domain.PageVO;
import com.yedam.app2.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
//@SessionAttributes("cri")
public class BoardController {

	@Autowired
	BoardService boardService;

	// 전체조회
	@GetMapping("/list")
	public void list(Model model, @ModelAttribute("cri") Criteria cri) {
		System.out.println("cri======"+cri);
		int total = boardService.getTotalCount(cri);
		model.addAttribute("list", boardService.getList(cri));
		model.addAttribute("pageMaker", new PageVO(cri, total));
	}

	// 단건 조회(수정페이지)
	@GetMapping({ "/get", "/modify" }) // 수정폼
	public void get(@RequestParam("bno") Long bno, Model model, @ModelAttribute("cri") Criteria cri ) {
		BoardVO board = new BoardVO();
		board.setBno(bno);
		model.addAttribute("board", boardService.read(board));
		
	}

	// 수정
	@PostMapping("/modify")
	public String modify(BoardVO vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		int result = boardService.update(vo);
		if (result == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		System.out.println("modify="+cri);
//		rttr.addFlashAttribute("pageNum", cri.getPageNum());
//		rttr.addFlashAttribute("amount",cri.getAmount());
		return "redirect:/board/list"; // redirect 파라미터 전달x
	}

	// 등록
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {

		boardService.insert(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect:/board/list"; // redirect 파라미터 전달x
	}

	@GetMapping("/register") // 등록
	public void registerForm() {

	}

	// 삭제
	@RequestMapping("/remove")
	public String remove(BoardVO vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		int result = boardService.remove(vo);
		if (result == 1) {
			rttr.addFlashAttribute("result", "success");
		}
//		rttr.addFlashAttribute("pageNum", cri.getPageNum()); session 덕분에 생략가능
//		rttr.addFlashAttribute("amount",cri.getAmount());
		return "redirect:/board/list"; // redirect 파라미터 전달x
	}
}
