package co.dabling.msp.admin.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.member.service.MemberService;
import co.dabling.msp.member.service.impl.MemberServiceImpl;
import co.dabling.msp.member.vo.MemberVO;
import co.dabling.msp.store.vo.StoreVO;

public class MemberManagePage implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원 전체목록 가져오기
		MemberService service = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<>();
		members = service.memberList();
		request.setAttribute("members", members);
		
		return "admin/memberManagePage.tiles";
	}

}
