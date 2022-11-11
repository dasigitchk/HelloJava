package co.dabling.msp.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.member.service.MemberService;
import co.dabling.msp.member.service.impl.MemberServiceImpl;
import co.dabling.msp.member.vo.MemberVO;

public class MemberInfo implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 일반회원 정보 한건 가져오기
		// 로그인되어있는 회원본인의 정보를 가져오는 것이기 때문에 session에 저장된 memberCode를 memberSelect의 매개변수로 넣어서 한건을 가져오시면 될 거 같아요.
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> list = new ArrayList<>();
		list = dao.memberList(); // 전체목록
		request.setAttribute("list", list); // 결과를담음
		// 일반회원 내정보보기 사이트로 가기
		return "member/memberInfo.tiles";
	}

}
