package com.micol.nek.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.micol.nek.common.Command;
import com.micol.nek.member.service.MemberService;
import com.micol.nek.member.service.MemberVO;
import com.micol.nek.member.serviceImpl.MemberServiceImpl;

public class MemberInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 멤버 추가 
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberAuthor(request.getParameter("memberAuthor"));
		
		// 성공, 실패에 따라 페이지를 나누어 보여줄 때 이 방법 사용
		
		int r = dao.memberInsert(vo);
		String viewPage = null;
		if(r != 0) {
		//	request.setAttribute("message", "정상적으로 입력 되었습니다.");
			viewPage = "memberSelectList.do";
			
		} else {
			request.setAttribute("message", "멤버 추가가 실패했습니다.");
			viewPage = "member/memberMessage";
		}
		return viewPage;
	}

}
