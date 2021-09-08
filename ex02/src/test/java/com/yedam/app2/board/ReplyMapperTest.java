package com.yedam.app2.board;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app2.board.domain.Criteria;
import com.yedam.app2.board.domain.ReplyVO;
import com.yedam.app2.board.mapper.ReplyMapper;
import com.yedam.app2.board.service.ReplyService;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class ReplyMapperTest {
	
	@Autowired ReplyService replyService;
	@Autowired ReplyMapper replyMapper;
	
		//전체조회
		//@Test
		public void getList() {
			Criteria cri = new Criteria(1,20);
			log.info(replyService.getList(cri,377L).toString());
		}
		
		@Test
		public void testList2() {
			Criteria cri = new Criteria(2,10);
			
			List<ReplyVO> replies = replyMapper.getList(cri,3145745L);
			
			replies.forEach(reply -> log.info(reply.toString()));
		}
}
