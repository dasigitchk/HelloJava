package co.edu.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.control.BulletinControl;
import co.edu.control.MainControl;
import co.edu.control.MemberList;
import co.edu.control.SearchBoard;
import co.edu.control.SignIn;
import co.edu.control.SignInForm;
import co.edu.control.SignOut;
import co.edu.control.SignUp;
import co.edu.control.SignUpForm;
import co.edu.control.WriteBoard;
import co.edu.control.WriteForm;
import co.edu.control.passwdReConfirm;
import co.edu.control.passwdReConfirmForm;

public class FrontController extends HttpServlet {

	HashMap<String, Control> controlList;
	String charset;

	// init()
//	@Override
//	public void init() throws ServletException {
//		
//		ServletContext sc = this.getServletContext();
//		sc.getInitParameter("charset");
//	}
//	
	
	// �������۽� �ѹ��� �����.
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		controlList = new HashMap<String, Control>();
		
		controlList.put("/main.do", new MainControl());
		controlList.put("/bulletin.do", new BulletinControl());
		controlList.put("/searchBoard.do", new SearchBoard());
		controlList.put("/writeBoardForm.do", new WriteForm());
		controlList.put("/writeBoard.do", new WriteBoard());
		
		// 회원가입.
		controlList.put("/signUpForm.do", new SignUpForm()); //회원가입화면.
		controlList.put("/signUp.do", new SignUp());
		controlList.put("/memberList.do", new MemberList());//회원가입 처리 => 회원가입되었습니다. 
		
		controlList.put("/signInForm.do", new SignInForm());
		controlList.put("/signIn.do", new SignIn());
		controlList.put("/signOut.do", new SignOut());
		
		//비밀번호 재전송
		controlList.put("/passwdReConfirmForm.do", new passwdReConfirmForm());
		controlList.put("/passwdReConfirm.do", new passwdReConfirm());
		
}

	// service()
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding(charset); // 한글처리.
		resp.setCharacterEncoding(charset); //한글.
		String uri = req.getRequestURI(); // http://localhost:8081/H20221025/main.do  ~8081�� �����ϰ�  /H29221025/main.do�� �ҷ����°� uri?��.
		String context = req.getContextPath(); // H20221025�� path?
		String path = uri.substring(context.length());
		
		System.out.println(path);
		Control subControl = controlList.get(path);
		
		subControl.exec(req, resp); //main.do ȣ�� => control����
	} 
} //end of class

