package com.yedam.app2.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app2.board.domain.BoardVO;
import com.yedam.app2.board.mapper.BoardMapper;
import com.yedam.app2.board.service.BoardService;

import lombok.extern.java.Log;



@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class BoardMapperClient {
	
	@Autowired BoardService boardMapper;
	
	//전체조회
	@Test
	public void getList() {
		log.info(boardMapper.getList().toString());
	}
	
	//입력
	//@Test
	public void insert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는글");
		board.setContent("새글 내용");
		board.setWriter("newbie");
		boardMapper.insert(board);
	}
	
	//상세(단건)조회
	//@Test
	public void read() {
		BoardVO board = new BoardVO();
		board.setBno(4);
		boardMapper.read(board);
		log.info(board.toString());
	}
	
	//삭제
	//@Test
	public void delete() {
		BoardVO board = new BoardVO();
		board.setBno(5);
		boardMapper.remove(board);
		
	}
	
	// 수정
	//@Test
	//@Rollback
	public void update() { //int로 변경해서 적용 건 수 확인가능
		BoardVO board = new BoardVO();
		board.setBno(4);
		board.setTitle("변경된 제목");
		board.setContent("변경된 내용");
		board.setWriter("홍길동");
		
		boardMapper.update(board);
	
	}
	
	
	
}	
