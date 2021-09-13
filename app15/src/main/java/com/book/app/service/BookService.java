package com.book.app.service;

import java.util.List;

import com.book.app.domain.BookVO;

public interface BookService {
	//CRUD
			//등록
			public int insert(BookVO vo);
			
			//수정
			public int update(BookVO vo);
			
			//삭제
			public int delete(BookVO vo);
			
			//단건 조회
			public BookVO read(BookVO vo);
			
			//전체 조회
			public List<BookVO> getList(); 
}
