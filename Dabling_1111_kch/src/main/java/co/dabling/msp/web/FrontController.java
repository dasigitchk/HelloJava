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

import co.dabling.msp.admin.command.MemberManagePage;
import co.dabling.msp.admin.command.MemberSelect;
import co.dabling.msp.admin.command.MemberSelectForm;
import co.dabling.msp.admin.command.MemberUpdate;
import co.dabling.msp.admin.command.MemberUpdateForm;
import co.dabling.msp.admin.command.StoreApproval;
import co.dabling.msp.admin.command.StoreApprovalForm;
import co.dabling.msp.admin.command.StoreDelete;
import co.dabling.msp.admin.command.StoreDeleteForm;
import co.dabling.msp.admin.command.StoreManagePage;
import co.dabling.msp.admin.command.StoreSelect;
import co.dabling.msp.admin.command.StoreSelectForm;
import co.dabling.msp.admin.command.StoreUpdate;
import co.dabling.msp.admin.command.StoreUpdateForm;
import co.dabling.msp.common.Command;
import co.dabling.msp.main.MainCommand;
import co.dabling.msp.member.command.AjaxBusinessNumCheck;
import co.dabling.msp.member.command.AjaxEmailCheck;
import co.dabling.msp.member.command.Logout;
import co.dabling.msp.member.command.MemberJoin;
import co.dabling.msp.member.command.MemberJoinForm;
import co.dabling.msp.member.command.MemberLogin;
import co.dabling.msp.member.command.MemberloginForm;
import co.dabling.msp.menu.command.MenuInsert;
import co.dabling.msp.menu.command.MenuInsertForm;
import co.dabling.msp.review.command.Review;
import co.dabling.msp.review.command.Review1;
import co.dabling.msp.review.command.ReviewForm;
import co.dabling.msp.store.command.StoreDetailCommand;
import co.dabling.msp.store.command.StoreInsert;
import co.dabling.msp.store.command.StoreInsertForm;
import co.dabling.msp.store.command.StoreMyPage;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 명령을 저장할 공간을 맵으로 만들어줌<키,밸류>
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	// 요청한 것을 실행하는 명령을 모아두는 곳
	public void init(ServletConfig config) throws ServletException {

		// 메인페이지
		map.put("/main.do", new MainCommand());// 첨 보여줄 페이지
		// 식당 상세페이지(김현지)
		map.put("/store.do", new StoreDetailCommand());
		// 로그인(남미주)
		map.put("/memberloginForm.do", new MemberloginForm()); // 로그인폼
		map.put("/memberLogin.do", new MemberLogin()); // 로그인처리
		// 회원가입(남미주)
		map.put("/memberJoinForm.do", new MemberJoinForm()); // 회원가입폼
		map.put("/memberJoin.do", new MemberJoin()); // 회원가입 처리
		map.put("/ajaxEmailCheck.do", new AjaxEmailCheck()); // ajax 이용 이메일 중복체크
		map.put("/ajaxbusinessNumCheck.do", new AjaxBusinessNumCheck()); // ajax 이용 사업자번호 중복체크
		map.put("/logout.do", new Logout()); // 로그아웃
		// 매장페이지(배수빈)
		map.put("/storeInsertForm.do", new StoreInsertForm()); // 매장승인신청
		map.put("/storeInsert.do", new StoreInsert()); // 매장 승인완료
		map.put("/storeMyPage.do", new StoreMyPage()); // 매장 마이페이지
		map.put("/menuInsertForm.do", new MenuInsertForm()); // 메뉴등록폼
		map.put("/menuInsert.do", new MenuInsert()); // 메뉴등록 처리
		// 내정보조회(김지한)
		// member테이블을 사용하는 것은 member~ 로 통일해주세요
//		map.put("/myInfo.do", new MyInfo()); // 내정보조회 
//		map.put("/myInfoUpdateForm.do", new MyInfoUpdateForm());
		map.put("/memberUpdate.do", new MemberUpdate());
		map.put("/review.do", new Review());
		map.put("/reviewForm.do", new ReviewForm());
		map.put("/review1.do", new Review1()); // 이건뭐죵??
//		map.put("/cancel.do", new Cancel());
//		map.put("/history.do", new history()); // 이것도 reservation에 있는 이름들이랑 통일 부탁드려요 
		// 관리자페이지-회원(김충현)
		map.put("/storeManagePage.do", new StoreManagePage()); // 첫 페이지에 회원리스트 출력
		map.put("/memberSelectForm.do", new MemberSelectForm()); // 회원선택보기 페이지
		map.put("/memberSelect.do", new MemberSelect()); // 회원 선택보기
		map.put("/memberUpdateForm.do", new MemberUpdateForm()); // 회원정보수정(권한변경) 페이지
		map.put("/memberUpdate.do", new MemberUpdate()); // 회원정보수정
		// 관리자페이지-점포(김충현)
		map.put("/storeManagePage.do", new MemberManagePage()); // 첫 페이지에 매장리스트 출력
		map.put("/storeSelectForm.do", new StoreSelectForm()); // 매장선택보기 페이지
		map.put("/storeSelect.do", new StoreSelect()); // 매장 선택보기
		map.put("/storeUpdateForm.do", new StoreUpdateForm()); // 매장정보수정(권한변경) 페이지
		map.put("/storeUpdate.do", new StoreUpdate()); //매장정보 수정
		map.put("/storeDeleteForm.do", new StoreDeleteForm()); //매장정보삭제 페이지 
		map.put("/storeDelete.do", new StoreDelete()); //매장정보 삭제
		map.put("/storeApprovalForm.do", new StoreApprovalForm()); //등록대기매장 페이지
		map.put("/storeApproval.do", new StoreApproval()); // 등록승인
	}

	// 요청을 분석하고 실행, 결과를 돌려주는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 한글 깨짐 방지

		String uri = request.getRequestURI();// 요청한 uri를 구함
		String contextPath = request.getContextPath(); // 루트(컨텍스트패스) 를 구함
		String page = uri.substring(contextPath.length()); // 실제 수행할 요청을 구함

		Command command = map.get(page);// init 메소드에서 수행할 명령을 가져온다

		String viewPage = command.exec(request, response);// 명령을 수행하고 결과를 돌려받음

		if (!viewPage.endsWith(".do") && viewPage != null) {// 리턴되는 페이지 끝에 .do가 포함되어있지않다면
			// ajax(요청한 페이지의 결과를 다시 돌려줌) 처리
			if (viewPage.startsWith("ajax:")) {
				response.setContentType("text/html; charset=utf-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}

			// 타일즈 처리
			if (!viewPage.endsWith(".tiles")) {
				// 타일즈가 아니면 뷰페이지 리턴
				viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);

		} else {// .do로 들어온다면 다시 명령 실행시키기
			response.sendRedirect(viewPage);// 다시 실행으로 돌려보냄
			// sendRedirect : 권한은 위임하나 요청정보가 안감, 페이지만 돌려줌
		}

	}

}
