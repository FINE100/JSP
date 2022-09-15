package com.micol.nex.member.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.micol.nek.member.service.MemberService;
import com.micol.nek.member.service.MemberVO;
import com.micol.nek.member.serviceImpl.MemberServiceImpl;

// 원래 서블릿은 하나만 만들면 됨. 지금은 공부용으로 여러개 작성.

//@WebServlet("/MemberList")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemberList() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수행할 코드 적는 곳(멤버목록 가져오기)
		request.setCharacterEncoding("UTF-8");
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<>();
		members = dao.memberSelectList();
		request.setAttribute("members", members);	//결과를 담는다.
		String viewPage = "/WEB-INF/views/member/memberList.jsp"; // 결과를 돌려줄 페이지, request.setAtrribute를 불러서 보여줄 수 있다.
		
		// 기존 request 객체를 새로 만들어진 request 객체에 담아서 줌. 
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
