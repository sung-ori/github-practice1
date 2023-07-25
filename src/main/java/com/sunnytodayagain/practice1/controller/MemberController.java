package com.sunnytodayagain.practice1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunnytodayagain.practice1.domain.Member;
import com.sunnytodayagain.practice1.service.MemberService;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Slf4j
@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("joinForm")
	public String home() {
		
		return"memberView/joinForm";
	}
	
	@GetMapping("idCheckForm")
	public String idCheckForm() {
		
		return "memberView/idCheckForm";
	}
	
	@PostMapping("idCheck")
	public String idCheck(String searchId, Model m) {
		boolean result = service.idCheck(searchId);
		m.addAttribute("result", result);
		m.addAttribute("searchId",searchId);
		
		return "memberView/idCheckForm";
	}
	
	@PostMapping("join")
	public String join(Member m) {
			
		service.join(m);
		return "redirect:/";
	}
	@GetMapping("loginForm")
	public String loginForm() {
		
		return "memberView/loginForm";
	}
}
