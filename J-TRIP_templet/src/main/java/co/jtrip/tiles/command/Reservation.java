package co.jtrip.tiles.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jtrip.common.Command;

public class Reservation implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 예약 페이지
		return "main/reservation";
	}

}
