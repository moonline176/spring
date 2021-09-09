package com.yedam.app2.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.app2.board.domain.BoardAttachVO;
import com.yedam.app2.board.domain.BoardVO;

import lombok.extern.java.Log;

@Log
@Controller
public class UploadController {

	@GetMapping("page2") // 페이지 p.364
	public ResponseEntity<BoardVO> page2(@RequestParam int h) {
		ResponseEntity<BoardVO> result = null;
		if (h > 10) {
			result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BoardVO());
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(new BoardVO());
		}
		return result;
	}

	@GetMapping("page1")
	public void page1(HttpServletResponse response) throws IOException {
		String mimetype = "application/xml";
		response.setContentType(mimetype);

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div>test</div>");
		out.println("<div>안녕하세요</div>");
		out.println("</body>");
		out.println("</html>");
	}

	@PostMapping("/uploadFormAction")
	public void uploadFormAction(MultipartFile[] uploadFile) throws IllegalStateException, IOException { // 여러 파일 보낼때 []
																											// 추가
		for (int i = 0; i < uploadFile.length; i++) {// 다중파일 보낼 때 for문 이용
			MultipartFile ufile = uploadFile[i];
			if (!ufile.isEmpty() && ufile.getSize() > 0) {
				String filename = ufile.getOriginalFilename(); // 원본 파일명
				/* String saveName = System.currentTimeMillis()+""; */ // 현재 시간을 나타내는 출력문 + 새 파일명
				UUID uuid = UUID.randomUUID();
				File file = new File("c:/upload", uuid + filename); // 똑같은 파일이 다운로드 될 경우 덮어쓰기가 되기 때문에 이 점에 주의할 것!! ->
																	// 파일명 구분 해줄것
				ufile.transferTo(file);
			}
		}
	}

	@PostMapping("/uploadAjaxAction")
	@ResponseBody
	public List<BoardAttachVO> uploadAjaxAction(MultipartFile[] uploadFile, BoardVO vo)
			throws IllegalStateException, IOException { // 여러 파일 보낼때 [] 추가
		List<BoardAttachVO> list = new ArrayList<BoardAttachVO>();
		String path = "c:/upload";
		if (uploadFile != null) {
			for (int i = 0; i < uploadFile.length; i++) {// 다중파일 보낼 때 for문 이용
				MultipartFile ufile = uploadFile[i];
				if (!ufile.isEmpty() && ufile.getSize() > 0) {
					String filename = ufile.getOriginalFilename(); // 원본 파일명
					UUID uuid = UUID.randomUUID();
					File file = new File(path, uuid + filename); // 똑같은 파일이 다운로드 될 경우 덮어쓰기가 되기 때문에 이 점에 주의할 것!! -> 파일명
																	// 구분
					ufile.transferTo(file);
					// 파일정보
					BoardAttachVO attachvo = new BoardAttachVO();
					attachvo.setUuid(uuid.toString());
					attachvo.setFileName(filename);
					attachvo.setUploadPath(path);
					list.add(attachvo);
				}
			}
		}
		return list;
	}
}
