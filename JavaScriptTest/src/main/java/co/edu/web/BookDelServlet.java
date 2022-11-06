package co.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.common.BookDAO;


@WebServlet("/BookDelServlet")
public class BookDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookDelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		String bc = request.getParameter("bookCode");
		BookDAO dao = new BookDAO();
		dao.deleteBook(bc);
		
		Gson gson = new GsonBuilder().create(); // gson 인스턴스 호출.
		response.getWriter().print(gson.toJson(vo)); //print를쓰면 값이 웹브라우저에 보여짐.
	}
}
