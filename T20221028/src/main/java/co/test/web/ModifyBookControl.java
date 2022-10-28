package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.common.Controller;
import co.test.common.HttpUtil;
import co.test.service.BookService;
import co.test.vo.BookVO;

public class ModifyBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookCode = request.getParameter("bookCode");
		String bookTitle = request.getParameter("bookTitle");
		String bookAuthor = request.getParameter("bookAuthor");
		String bookPress = request.getParameter("bookPress");
		String bookPrice = request.getParameter("bookPrice");
		
		BookVO vo = new BookVO(bookCode,bookTitle,bookAuthor,bookPress,Integer.parseInt(bookPrice));
		BookService service = new BookService();
		service.modifyBook(vo);
		
		HttpUtil.forward(request, response, "WEB-INF/result/modifyOutput.jsp");
	}

}
