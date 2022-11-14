package co.dabling.msp.admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;

public class MemberSelectForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원선택화면 출력
		return "admin/memberSelectForm.tiles";
	}

}
