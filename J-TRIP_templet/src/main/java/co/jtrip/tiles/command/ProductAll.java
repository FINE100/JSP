package co.jtrip.tiles.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jtrip.common.Command;

public class ProductAll implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		return "main/productAll";
	}

}
