package co.dabling.msp.store.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUtils;

import co.dabling.msp.common.Command;
import co.dabling.msp.store.service.StoreService;
import co.dabling.msp.store.service.impl.StoreServiceImpl;
import co.dabling.msp.store.vo.StoreVO;

public class StoreMyPage implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		// 매장 마이페이지
		HttpSession session = request.getSession();
		StoreService service = new StoreServiceImpl();
		StoreVO store = new StoreVO();
		
		String businessNum = (String) session.getAttribute("businessNum");
		System.out.println(businessNum);
		System.out.println(session);
		
		store = service.storeSelect(businessNum); 
		request.setAttribute("store", store);
		
		
		
		return "store/storeMyPage.tiles";
		
	}
}
