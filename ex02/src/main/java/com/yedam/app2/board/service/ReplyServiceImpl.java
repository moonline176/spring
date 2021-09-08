package com.yedam.app2.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app2.board.domain.Criteria;
import com.yedam.app2.board.domain.ReplyPageVO;
import com.yedam.app2.board.domain.ReplyVO;
import com.yedam.app2.board.mapper.BoardMapper;
import com.yedam.app2.board.mapper.ReplyMapper;

@Service //-> 이게 없으면 테스트나 실행이 불가능하다 중요!!
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired ReplyMapper replyMapper;
	@Autowired BoardMapper boardMapper;

	@Override
	public ReplyVO readRe(ReplyVO vo) {
		// TODO Auto-generated method stub
		return replyMapper.readRe(vo);
	}

	@Override
	public int insertRe(ReplyVO vo) {
		boardMapper.updateReplycnt(vo.getBno(), 1L);
		return replyMapper.insertRe(vo);
	}

	@Override
	public int updateRe(ReplyVO vo) {
		// TODO Auto-generated method stub
		return replyMapper.updateRe(vo);
	}
	
	@Override
	public int deleteRe(ReplyVO vo) {
		boardMapper.updateReplycnt(vo.getBno(), -1L);
		return replyMapper.deleteRe(vo);
	}
	
	@Override
	public ReplyPageVO getList(Criteria cri, Long bno) {
		ReplyPageVO vo = new ReplyPageVO();
		vo.setReplyCnt(replyMapper.getCountByBno(bno));
		vo.setList(replyMapper.getList(cri, bno));
		return vo;
	}

	@Override
	public int getCountByBno(Long bno) {
		// TODO Auto-generated method stub
		return replyMapper.getCountByBno(bno);
	}

}
