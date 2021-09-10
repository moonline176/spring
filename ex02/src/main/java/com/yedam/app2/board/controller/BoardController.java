package com.yedam.app2.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app2.board.domain.BoardAttachVO;
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
		System.out.println("cri======" + cri);
		int total = boardService.getTotalCount(cri);
		model.addAttribute("list", boardService.getList(cri));
		model.addAttribute("pageMaker", new PageVO(cri, total));
	}

	// 단건 조회(수정페이지)
	@GetMapping({ "/get", "/modify" }) // 수정폼
	public void get(@RequestParam("bno") Long bno, Model model, @ModelAttribute("cri") Criteria cri) {
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
		System.out.println("modify=" + cri);
//		rttr.addFlashAttribute("pageNum", cri.getPageNum());
//		rttr.addFlashAttribute("amount",cri.getAmount());
		return "redirect:/board/list"; // redirect 파라미터 전달x
	}

	// 등록
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr)
			throws IllegalStateException, IOException {
		
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

	/**
	 * 첨부파일로 등록된 파일에 대하여 다운로드를 제공한다. *
	 * 
	 * @param commandMap
	 * @param response
	 * @throws Exception
	 */

	@RequestMapping(value = "/download")
	public void cvplFileDownload(@RequestParam Map<String, Object> commandMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String uuid = (String) commandMap.get("uuid");
		// uuid로 첨부파일 검색
		BoardAttachVO attachVO = boardService.attachRead(uuid);
		String fileName = "";
		if (attachVO != null) {
			fileName = attachVO.getFileName();
		}

		File uFile = new File("c:/upload", uuid + fileName);
		long fSize = uFile.length();
		if (fSize > 0) {
			String mimetype = "application/x-msdownload";
			response.setContentType(mimetype);
			response.setHeader("Content-Disposition",
					"attachment;filename=\"" + URLEncoder.encode(fileName, "utf-8") + "\"");
			// setDisposition(atchFileId, request, response);

			BufferedInputStream in = null;
			BufferedOutputStream out = null;

			try {
				in = new BufferedInputStream(new FileInputStream(uFile));
				out = new BufferedOutputStream(response.getOutputStream());
				FileCopyUtils.copy(in, out);
				out.flush();
			} catch (IOException ex) {
			} finally {
				in.close();
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
		} else {
			response.setContentType("application/x-msdownload");
			PrintWriter printwriter = response.getWriter();
			printwriter.println("<html>");
			printwriter.println("<h2>Could not get file name:<br>" + fileName + "</h2>");
			printwriter.println("<center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
			printwriter.println("&copy; webAccess");
			printwriter.println("</html>");
			printwriter.flush();
			printwriter.close();
		}
	}

}
