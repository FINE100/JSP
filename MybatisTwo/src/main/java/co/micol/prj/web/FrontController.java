package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.Main;
import co.micol.prj.common.Command;
import co.micol.prj.member.command.AjaxMemberIdCheck;
import co.micol.prj.member.command.MemberDelete;
import co.micol.prj.member.command.MemberEdit;
import co.micol.prj.member.command.MemberJoinForm;
import co.micol.prj.member.command.MemberSelect;
import co.micol.prj.member.command.MemberSelectList;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// 요청과 명령을 매핑하는 곳
		map.put("/main.do", new Main()); //처음오는 페이지를 돌려준다.
		map.put("/memberSelectList.do", new MemberSelectList()); //멤버목록보기
		map.put("/memberJoinForm.do", new MemberJoinForm()); //멤버입력 폼 호출
		map.put("/memberSelect.do", new MemberSelect()); //멤버 상세 정보
		map.put("/memberDelete.do", new MemberDelete()); //멤버 삭제
		map.put("/memberEdit.do", new MemberEdit());  //멤버 정보 변경
		map.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck()); //ajax 반환해주는 곳 만들어야함 
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청을 분석하고, 실행하고, 결과를 돌려주는 곳
		request.setCharacterEncoding("utf-8");  //한글깨짐 방지
		String uri = request.getRequestURI(); 
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length()); // /main.do
		
		System.out.println(uri); //  mybatisTwo/main.do
		System.out.println(contextPath); // /mybatiTwo
		System.out.println("page: " +page); //main.do
		
		Command command = map.get(page);
		System.out.println("command : "+command);
		
//   ===================================================				
		
		String viewPage = command.exec(request, response);
		
		System.out.println(viewPage); // /main/main
		
		
		
		
		if(!viewPage.endsWith(".do")) {
			
			if(viewPage.startsWith("ajax:")) {
				//ajax 처리
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}else {
				viewPage = "/WEB-INF/views/" + viewPage + ".jsp";// /WEB-INF/views/main.jsp
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
				System.out.println("dispatcher: " + dispatcher);
			}
		}else {
			response.sendRedirect(viewPage);
		}
		
	}

}
