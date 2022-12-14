package com.micol.nek.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.micol.nek.common.Command;
import com.micol.nek.member.service.MemberService;
import com.micol.nek.member.service.MemberVO;
import com.micol.nek.member.serviceImpl.MemberServiceImpl;

public class MemberSelectList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 멤버 목록 보기 
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<>();
		members = dao.memberSelectList();
		request.setAttribute("members", members);	//결과를 담는다.
		return "member/memberList";
	}

}
