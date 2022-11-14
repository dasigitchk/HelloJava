package co.dabling.msp.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.dabling.msp.common.Command;
import co.dabling.msp.member.service.MemberService;
import co.dabling.msp.member.service.impl.MemberServiceImpl;
import co.dabling.msp.member.vo.MemberVO;

public class MemberInfo implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 일반회원 정보 한건 가져오기
		HttpSession session = request.getSession();
		MemberService dao = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		int memberCode = (int) session.getAttribute("memberCode");
		member.setMemberCode(memberCode);

		request.setAttribute("memberInfo", dao.memberSelect(member.getMemberCode()));

		// 일반회원 내정보보기 사이트로 가기
		return "member/memberInfo.tiles";
	}

}
