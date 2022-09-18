package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;

public class MemberJoinForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
<<<<<<< HEAD
		// 멤버입력 폼
=======
		
>>>>>>> branch 'master' of https://github.com/FINE100/JSP.git
		return "member/memberJoinForm";
	}

}
