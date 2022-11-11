package co.dabling.msp.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;

public class MemberInfoUpdateForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원정보수정 폼 호출
		return "member/memberInfoUpdateForm.tiles";
	}

}
