package co.dabling.msp.admin.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.member.vo.MemberVO;
import co.dabling.msp.store.service.StoreService;
import co.dabling.msp.store.service.impl.StoreServiceImpl;
import co.dabling.msp.store.vo.StoreVO;
public class StoreApproval implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 등록승인
		String businessNum = request.getParameter("businessNum");
		System.out.println(businessNum);
		StoreService service = new StoreServiceImpl();
		service.storeApproval(businessNum);
		
		return "admin/storeApproval.tiles";
	}
}