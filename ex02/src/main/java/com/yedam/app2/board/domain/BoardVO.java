package com.yedam.app2.board.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class BoardVO {
	private long bno;	// 게시글 번호
	private String title;	// 게시글 제목
	private String content; // 게시글 내용
	private String writer; // 작성자
	@JsonFormat(pattern = "yyyy/MM/dd") //형식변환
	private Date regdate; //작성일자
	@JsonIgnore // json 데이터를 불러올때 제외시킴
	private Date updatedate;  //수정일자
}
