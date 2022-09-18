package co.micol.prj.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//FrontController & Command pattern 실습

public interface Command {
	public String exec(HttpServletRequest request, HttpServletResponse response);
	
	
}
