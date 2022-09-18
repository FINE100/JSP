package com.micol.nek;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.micol.nek.common.Command;
import com.micol.nek.member.command.AjaxMemberIdCheck;
import com.micol.nek.member.command.MemberInsert;
import com.micol.nek.member.command.MemberJoinForm;
import com.micol.nek.member.command.MemberSelect;
import com.micol.nek.member.command.MemberSelectList;

/**
 * Servlet implementation class FrontController 모든 .do 요청을 분석하고 처리한다.
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>(); // 요청한 값을 저장하기 위해서

	public FrontController() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		// 모든 요청을 등록하는 곳
		map.put("/main.do", new MainCommand()); // 처음 시작하는 페이지
		map.put("/memberSelectList.do", new MemberSelectList()); // 멤버 목록 보기
		map.put("/memberSelect.do", new MemberSelect()); // 멤버 상세 정보
		map.put("/memberJoinForm.do", new MemberJoinForm()); // 멤버 입력 화면
		map.put("/memberInsert.do", new MemberInsert()); // 멤버 입력 처리
		map.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck()); // 아이디 중복 체크
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청을 분석하고, 처리하고, 결과를 돌려주는 곳.
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지를 위해
		String uri = request.getRequestURI(); // 도메인을 제외한 실제 요청 정보
		String contextPath = request.getContextPath(); // contextPath 구함
		String page = uri.substring(contextPath.length()); // 처리할 요청명 구함 (uri = /contextPath/ 실제 요청 형태이므로 contextPath
															// 없애줌)

		System.out.println("URL : " + request.getRequestURL());
		System.out.println("URI : " + uri);
		System.out.println("contextPath : " + contextPath);
		System.out.println("page : " + page);
		System.out.println("user : " + request.getRemoteUser()); // 현재 user명이 없으므로 null 나옴

		Command command = map.get(page); // 처리할 command를 찾음
		String viewPage = command.exec(request, response); // command를 실행하고 돌려줄 페이지를 받음
		System.out.println("viewPage : " + viewPage);

		// view resolve 내용 (if문 전체)
		
		
		if (!viewPage.endsWith(".do")) { 							// viewPage의 끝에 .do가 없으면 (=!)
			if (viewPage.startsWith("ajax:")) { 					// ajax를 처리하기 위한 view Resolve
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5)); // 유효한 값이 아니므로 ajax: 총 5글자이므로 빼달라. 
				return;
			} else { // 리턴값이 보여줄 페이지를 가지고 올 때 
				viewPage = "/WEB-INF/views/" + viewPage + ".jsp"; // .do가 없을시 /WEB-INF/views/main/main.jsp 출력
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
			}
		} else {
			response.sendRedirect(viewPage); // 리턴값이 *.do로 올때 처리, main.do 다시 호출.
		}
	}

}
