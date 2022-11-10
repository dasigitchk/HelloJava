package co.dabling.msp.admin.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.member.service.MemberService;
import co.dabling.msp.member.service.impl.MemberServiceImpl;
import co.dabling.msp.member.vo.MemberVO;

public class MemberSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원 1건 조회
		int memberCode = Integer.parseInt(request.getParameter("memberCode"));
		MemberService service = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		member = service.memberSelect(memberCode);
		request.setAttribute("member", member);
		String job = request.getParameter("job");
		System.out.println(job);
//		if(job.equals("update")) {
//			return "admin/memberUpdateForm.tiles";
//		}
		return "admin/memberSelect.tiles";
	}
}