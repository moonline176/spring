package com.book.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.app.domain.BookVO;
import com.book.app.service.BookService;
import com.book.app.service.RentService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	@Autowired
	RentService rentService;
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("bookinsert")
	public String bookrent() {
		return "/bookinsert";
	}
	
	//09/15 --> 
	// 전체 조회
	@RequestMapping("bookList")
	public String list(Model model) {
		model.addAttribute("list", bookService.getList());
		return "/bookList";
	}
	
	@RequestMapping("bookrent")
	public String rent(Model model) {
		model.addAttribute("list", rentService.getListR());
		return "/bookrent";
	}
	

	// 등록
	@PostMapping("insertBook")
	@ResponseBody
	public BookVO insertDept(@RequestBody BookVO vo) {
		System.out.println(vo);
		bookService.insert(vo); 
		return vo;
	}

}
