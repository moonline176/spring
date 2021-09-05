package com.yedam.app2.board.mapper;

import java.util.List;

import com.yedam.app2.board.domain.BoardVO;

public interface BoardMapper {
	//CRUD
	//등록
	public int insert(BoardVO vo);
	
	//수정
	public int update(BoardVO vo);
	
	//삭제
	public int remove(BoardVO vo);
	
	//단건 조회
	public BoardVO read(BoardVO vo);
	
	//전체 조회
	public List<BoardVO> getList();
}
