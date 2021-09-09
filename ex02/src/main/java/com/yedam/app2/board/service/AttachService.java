package com.yedam.app2.board.service;

import java.util.List;

import com.yedam.app2.board.domain.BoardAttachVO;

public interface AttachService {
	
	
	public void insert(BoardAttachVO vo);

	public void delete(String uuid);

	public List<BoardAttachVO> findByBno(Long bno);

	public void deleteAll(Long bno);

	public List<BoardAttachVO> getOldFiles(); //지난 파일 조회
	
	public BoardAttachVO read(String uuid);
}
