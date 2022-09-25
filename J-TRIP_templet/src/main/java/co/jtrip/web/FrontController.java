package co.jtrip.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jtrip.common.Command;
import co.jtrip.main.Main;
import co.jtrip.tiles.command.Home;
import co.jtrip.tiles.command.Info;
import co.jtrip.tiles.command.Notice;
import co.jtrip.tiles.command.Product;
import co.jtrip.tiles.command.ProductAll;
import co.jtrip.tiles.command.ProductSingle;
import co.jtrip.tiles.command.Reservation;
import co.jtrip.tiles.command.ReviewBusan;
import co.jtrip.tiles.command.ReviewGangneung;
import co.jtrip.tiles.command.ReviewJeju;
import co.jtrip.tiles.command.ReviewUlleungdo;
import co.jtrip.tiles.commandt.Cart;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();  
    
    public FrontController() {
        super();      
    }

	public void init(ServletConfig config) throws ServletException {
		// 명령 집단 저장하는 곳
		map.put("/main.do", new Main());
		map.put("/home.do", new Home());
		map.put("/info.do", new Info());
		map.put("/product.do", new Product());
		map.put("/productAll.do", new ProductAll());
		map.put("/productSingle.do", new ProductSingle());
		map.put("/reviewBusan.do", new ReviewBusan());
		map.put("/reviewGangneung.do", new ReviewGangneung());
		map.put("/reviewJeju.do", new ReviewJeju());
		map.put("/reviewUlleungdo.do", new ReviewUlleungdo());
		map.put("/notice.do", new Notice());
		map.put("/cart.do", new Cart());
		map.put("/reservation.do", new Reservation());
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실제 수행할 서비스
		
		request.setCharacterEncoding("utf-8");  //한글깨짐 방지
		String uri = request.getRequestURI(); 
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		System.out.println("front의 page:"+page);
		Command command = map.get(page);
		String viewPage = command.exec(request, response);
		

		if (!viewPage.endsWith(".do")) {
			if (viewPage.startsWith("ajax:")) { // ajax를 사용할 때 
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			} else {
				if (viewPage.startsWith("no:")) {// tiles 사용안할때
					viewPage = "/WEB-INF/views/" + viewPage.substring(3) + ".jsp";
					System.out.println("viewPage_tiles 안 쓸때 경로 : " + viewPage);
				} else {
					viewPage = viewPage + ".tiles"; // tiles layout 사용할때
					System.out.println("viewPage_tiles 사용할때 경로: " + viewPage);					
				}
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
			}
		} else {
			response.sendRedirect(viewPage); //.do return
		}

	}


}

		
		
		
		

