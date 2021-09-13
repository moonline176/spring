package com.book.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.app.domain.BookVO;
import com.book.app.mapper.BookMapper;
import com.book.app.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired BookMapper bookMapper;
	
	@Override
	public int insert(BookVO vo) {
		// TODO Auto-generated method stub
		return bookMapper.insert(vo);
	}

	@Override
	public int update(BookVO vo) {
		// TODO Auto-generated method stub
		return bookMapper.update(vo);
	}

	@Override
	public int delete(BookVO vo) {
		// TODO Auto-generated method stub
		return bookMapper.delete(vo);
	}

	@Override
	public BookVO read(BookVO vo) {
		// TODO Auto-generated method stub
		return bookMapper.read(vo);
	}

	@Override
	public List<BookVO> getList() {
		// TODO Auto-generated method stub
		return bookMapper.getList();
	}

}
