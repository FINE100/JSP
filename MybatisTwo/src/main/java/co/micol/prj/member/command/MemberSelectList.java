package co.micol.prj.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class MemberSelectList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
<<<<<<< HEAD
		// 멤버목록 가져오기
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> list = new ArrayList<>();
		list = dao.memberSelectList();
		System.out.println(list);
		
=======
		// 멤버 목록 가져오기
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> list = new ArrayList<>();
		list = dao.memberSelectList();
>>>>>>> branch 'master' of https://github.com/FINE100/JSP.git
		request.setAttribute("members", list);
		return "member/memberSelectList";
	}

}
