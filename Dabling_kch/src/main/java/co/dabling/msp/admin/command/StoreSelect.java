package co.dabling.msp.admin.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.store.service.StoreService;
import co.dabling.msp.store.service.impl.StoreServiceImpl;
import co.dabling.msp.store.vo.StoreVO;

public class StoreSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 매장 1건 조회
		String businessNum = request.getParameter("businessNum");
		StoreService service = new StoreServiceImpl();
		StoreVO store = new StoreVO();
		store = service.storeSelect(businessNum);
		request.setAttribute("store", store);
//		String job = request.getParameter("job");
//		if (job.equals("update")) {
//			return "admin/memberUpdateForm.jsp";
//		}
		return "admin/storeSelect.tiles";
	}
}
