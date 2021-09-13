package com.book.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.app.domain.BookVO;
import com.book.app.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;

	// 전체 조회
	@GetMapping("/bookList")
	public void list(Model model) {
		model.addAttribute("list", bookService.getList());
	}

	// 단건조회
	@GetMapping("/bookinsert/{booNo}")
	public void getBook(@PathVariable int bookNo, BookVO vo,Model model) {
		vo.setBookNo(bookNo);
		
		model.addAttribute("book",bookService.read(vo));
	}

	// 등록
	@PostMapping("insertBook")
	@ResponseBody
	public BookVO insertDept(@RequestBody BookVO vo) {

		bookService.insert(vo);
		return vo;
	}

	// 수정
	@PutMapping("updateBook")
	@ResponseBody
	public BookVO updateDept(@RequestBody BookVO vo) {
		bookService.update(vo);
		return vo;
	}

}
