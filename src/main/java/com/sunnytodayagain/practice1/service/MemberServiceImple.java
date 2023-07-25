package com.sunnytodayagain.practice1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.sunnytodayagain.practice1.dao.MemberDAO;
import com.sunnytodayagain.practice1.domain.Member;

import ch.qos.logback.core.encoder.Encoder;

@Service
public class MemberServiceImple implements MemberService {

	@Autowired
	MemberDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEndcoder;
	
	@Override
	public boolean idCheck(String searchId) {
		
		String resultId = dao.selectOneId(searchId);
		boolean result = false;
			
		if (resultId != null) {
				result = false;
			}
			
		return result ;
	}

	@Override
	public int join(Member m) {
		String pw = passwordEndcoder.encode(m.getMemberpw());
		m.setMemberpw(pw);
	
		
		return 	dao.insert(m);
	}

}
