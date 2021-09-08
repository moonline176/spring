package com.yedam.app2.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app2.board.domain.BoardVO;
import com.yedam.app2.board.domain.Criteria;

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
	public List<BoardVO> getList(Criteria cri);
	
	//댓글 수 업데이트
	public void updateReplycnt(@Param("bno") Long bno,
							   @Param("amount") Long amount
							   );
	public int getTotalCount(Criteria cri); 

}
