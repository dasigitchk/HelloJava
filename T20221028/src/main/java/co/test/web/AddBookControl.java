package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.common.Controller;
import co.test.common.HttpUtil;
import co.test.service.BookService;
import co.test.vo.BookVO;

public class AddBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "WEB-INF/result/addOutput.jsp";
		
		
		String book = request.getParameter("title");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String price = request.getParameter("price");
		
		//DB입력.
		BookVO  vo = new BookVO(null, book, author, press, Integer.parseInt(price));
		BookService service = new BookService();
		service.addBook(vo);
	
		
		//페이지이동.
		HttpUtil.forward(request, response, path);
	}

}
