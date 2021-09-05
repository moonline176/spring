package com.yedam.app2.board;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/*-context.xml",
	"file:src\\main\\webapp\\WEB-INF\\spring\\appServlet\\servlet-context.xml"})
@WebAppConfiguration 
public class BoardControllerTest {
	
	@Autowired private WebApplicationContext ctx;//가짜서버
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test //215페이지, 목록조회
	public void testList() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				.toString());
	}
	

	
	//@Test 
	public void testRegister() throws Exception{ 
	String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
			.param("title", "테스트 새글 제목")
			.param("content", "테스트 새글 내용")
			.param("writer", "user00")).andReturn().getModelAndView().getViewName();
	
		log.info(resultPage);
	}
	
	
	
	
}
