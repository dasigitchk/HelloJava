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
		
		int storeCode = 51; //Integer.parseInt(request.getParameter("storeCode"));		
		store = service.storeSelect(storeCode);
		request.setAttribute("store", store);
		System.out.println(storeCode);
		
		return "store/storeMyPage.tiles";
		
		//##로그인기능구현되면 확인해볼것.
		//로그인 매장의 코드 세션값.
		//store = service.storeSelect((int) session.getAttribute("storeCode")); 
		//request.setAttribute("store", store);
		//System.out.println(session.getAttribute("storeCode"));
		
	}
}
