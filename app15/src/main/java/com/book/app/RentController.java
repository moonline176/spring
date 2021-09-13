package com.book.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.book.app.service.RentService;

@Controller
public class RentController {

	@Autowired RentService rentService;
	
	//전체조회
	@GetMapping("/bookrent")
	public void list(Model model) {
		model.addAttribute("rlist",rentService.getListR());
	}
}
