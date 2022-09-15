package com.micol.nek.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.micol.nek.common.Command;
import com.micol.nek.member.service.MemberService;
import com.micol.nek.member.service.MemberVO;
import com.micol.nek.member.serviceImpl.MemberServiceImpl;

public class MemberSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 멤버 상세 보기
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id")); //form에서 넘어온 name = id
		vo = dao.memberSelect(vo); // 검색 결과 얻기 
		request.setAttribute("member", vo); // 페이지에 전달하기 위해 담음 
		
		return "member/memberSelect";
	}

}
