package co.dabling.msp.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.member.service.MemberService;
import co.dabling.msp.member.service.impl.MemberServiceImpl;
import co.dabling.msp.member.vo.MemberVO;

public class MemberJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 처리
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setEmail(request.getParameter("email"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setPhone(request.getParameter("phone1")+request.getParameter("phone2")+request.getParameter("phone3"));
		vo.setAuthor(Integer.parseInt(request.getParameter("member")));
		if(request.getParameter("businessNum") == null) {
			vo.setBusinessNum("");
		} else { 
			vo.setBusinessNum(request.getParameter("businessNum"));
		}
		
		int n = dao.memberInsert(vo);
		String message = "회원가입에 실패하였습니다.";
		if(n>0) { 
			message = request.getParameter("name") + "님 의 가입을 축하합니다.";
		}
		request.setAttribute("message", message);
		
		return "member/memberJoin.tiles";
	}

}
