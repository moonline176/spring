package com.yedam.app2.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app2.board.domain.Criteria;
import com.yedam.app2.board.domain.ReplyPageVO;
import com.yedam.app2.board.domain.ReplyVO;

public interface ReplyMapper {
	
	//전체조회
	public List<ReplyVO> getList(@Param("cri") Criteria cri,@Param("bno")  Long bno);
	
	//단건조회
	public ReplyVO readRe(ReplyVO vo);
	
	//등록
	public int insertRe(ReplyVO vo);
	
	//수정
	public int updateRe(ReplyVO vo);
	
	//삭제
	public int deleteRe(ReplyVO vo);
	
	//해당 게시글의 댓글 수
	public int getCountByBno(Long bno);
	
}
