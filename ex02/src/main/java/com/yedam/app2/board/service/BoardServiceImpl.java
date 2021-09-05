package com.yedam.app2.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app2.board.domain.BoardVO;
import com.yedam.app2.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	// 스프링 4.3 이상부터는 autowired가 자동 적용된다
	@Autowired BoardMapper boardMapper;
	
	@Override
	public int insert(BoardVO vo) {
		return boardMapper.insert(vo);
	}

	@Override
	public int update(BoardVO vo) {
		return boardMapper.update(vo);
	}

	@Override
	public int remove(BoardVO vo) {
		
		return boardMapper.remove(vo);
	}

	@Override
	public BoardVO read(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardMapper.read(vo);
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return boardMapper.getList();
	}

}
