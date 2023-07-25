package com.sunnytodayagain.practice1.service;

import com.sunnytodayagain.practice1.domain.Member;

public interface MemberService {

	public boolean idCheck(String searchId);
	
	public int join(Member m);
}
