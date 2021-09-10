package com.yedam.app2.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app2.board.domain.BoardAttachVO;
import com.yedam.app2.board.domain.BoardVO;
import com.yedam.app2.board.domain.Criteria;
import com.yedam.app2.board.mapper.BoardAttachMapper;
import com.yedam.app2.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	// 스프링 4.3 이상부터는 autowired가 자동 적용된다
	@Autowired BoardMapper boardMapper;
	@Autowired BoardAttachMapper attachMapper;
	
	@Override
	public int insert(BoardVO vo) {
		boardMapper.insert(vo); 
		//첨부파일 등록
		if(vo.getAttachList() == null) 
			return 1;
		
		for( BoardAttachVO attach :vo.getAttachList()) {
			System.out.println(attach.toString());
			attach.setBno(vo.getBno());
			attachMapper.insert(attach);
		}
		return 1;
	}

	@Override
	public int update(BoardVO vo) {
		return boardMapper.update(vo);
	}

	@Override
	public int remove(BoardVO vo) {
		
		return boardMapper.remove(vo);
	}
	
	//게시글 조회
	@Override
	public BoardVO read(BoardVO vo) {
		//게시글 조회
		vo = boardMapper.read(vo);
		
		//첨부파일 조회
		vo.setAttachList(attachMapper.findByBno(vo.getBno()));
		return vo;
	}
	
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getList(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getTotalCount(cri);
	}

	@Override
	public void updateReplycnt() {
		// TODO Auto-generated method stub
	}

	@Override
	public BoardAttachVO attachRead(String uuid) {
		return attachMapper.read(uuid);
	}

}
