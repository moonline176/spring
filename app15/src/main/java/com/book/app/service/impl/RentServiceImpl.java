package com.book.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.app.domain.RentVO;
import com.book.app.mapper.RentMapper;
import com.book.app.service.RentService;

@Service
public class RentServiceImpl implements RentService {

	@Autowired RentMapper rentMapper;
	
	@Override
	public List<RentVO> getListR() {
		// TODO Auto-generated method stub
		return rentMapper.getListR();
	}

}
