package co.micol.prj;

<<<<<<< HEAD
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;

public class Main implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 시작하는 곳
		return "main/main";
	}

}
=======


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;

public class Main implements Command {

   @Override
   public String exec(HttpServletRequest request, HttpServletResponse response) {
      // 시작하는 곳
      return "main/main";
   }

}
>>>>>>> branch 'master' of https://github.com/FINE100/JSP.git
