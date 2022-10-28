package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import co.edu.common.Control;
import co.edu.common.HttpUtil;

public class SignOut  implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		HttpSession session = req.getSession();
		session.invalidate();
		HttpUtil.forward(req, resp, "member/signOut.tiles");
	}

}
