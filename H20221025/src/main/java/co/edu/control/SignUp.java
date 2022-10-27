package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.edu.board.BoardVO;
import co.edu.board.MemberVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class SignUp implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				String id = req.getParameter("id");
				String passwd = req.getParameter("passwd");
				String name = req.getParameter("name");
				String email = req.getParameter("email");
				
				// DB
				BoardService service = new BoardServiceImpl();
				service.insertMember(new MemberVO(id, passwd, name, email, "user"));
				
				HttpUtil.forward(req, resp, "member/memberForm.tiles");
//				resp.sendRedirect("signUp.do");
	}

}
