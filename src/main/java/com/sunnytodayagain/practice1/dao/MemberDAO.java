package com.sunnytodayagain.practice1.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sunnytodayagain.practice1.domain.Member;

@Mapper
public interface MemberDAO {

	public String selectOneId(String searchId);
	
	public int insert(Member m);
}
