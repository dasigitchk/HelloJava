package co.dabling.msp.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.main.MainCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //명령을 저장할 공간을 맵으로 만들어줌<키,밸류>
	private HashMap<String, Command> map = new HashMap<String, Command>();  
	
    public FrontController() {
        super();
    }

    //요청한 것을 실행하는 명령을 모아두는 곳
	public void init(ServletConfig config) throws ServletException {
		
		//메인페이지
		map.put("/main.do", new MainCommand());//첨 보여줄 페이지
		//로그인
		//식당 상세페이지
		//
		
	}

	//요청을 분석하고 실행, 결과를 돌려주는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//한글 깨짐 방지

		String uri = request.getRequestURI();//요청한 uri를 구함
		String contextPath = request.getContextPath(); //루트(컨텍스트패스) 를 구함
		String page = uri.substring(contextPath.length()); //실제 수행할 요청을 구함
		
		Command command = map.get(page);//init 메소드에서 수행할 명령을 가져온다	

		
		String viewPage = command.exec(request, response);//명령을 수행하고 결과를 돌려받음

		if(!viewPage.endsWith(".do") && viewPage!=null) {//리턴되는 페이지 끝에 .do가 포함되어있지않다면
			//ajax(요청한 페이지의 결과를 다시 돌려줌) 처리
			if(viewPage.startsWith("ajax:")) {
				response.setContentType("text/html; charset=utf-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			
			//타일즈 처리
			if(!viewPage.endsWith(".tiles")) {
				//타일즈가 아니면 뷰페이지 리턴
				viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);

		}else {//.do로 들어온다면 다시 명령 실행시키기
			response.sendRedirect(viewPage);//다시 실행으로 돌려보냄
			//sendRedirect : 권한은 위임하나 요청정보가 안감, 페이지만 돌려줌
		}
		
	}

}
