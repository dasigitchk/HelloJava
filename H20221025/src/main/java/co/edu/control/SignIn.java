package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class SignIn implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 아이디, 패스워드 => 검증 , 맞으면 session 객체에 id값을 저장.
		// 로그인성공 -> 로그인성공(signIn.jsp)
		HttpSession session = req.getSession();
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		// DB
		BoardService service = new BoardServiceImpl();
		
		if(service.signIn(id, passwd).equals(id)) {
			session.setAttribute("id", id);
			HttpUtil.forward(req, resp, "member/signIn.tiles");
		} else {
		HttpUtil.forward(req, resp, "member/signInForm.tiles");
		}
//		resp.sendRedirect("signUp.do");
	}

}
