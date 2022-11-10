package co.dabling.msp.store.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.dabling.msp.common.Command;
import co.dabling.msp.store.service.StoreService;
import co.dabling.msp.store.service.impl.StoreServiceImpl;
import co.dabling.msp.store.vo.StoreVO;

public class StoreDetailCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("스토어디테일커맨드 도착");

		StoreService service = new StoreServiceImpl();
		StoreVO store = new StoreVO();
		HttpSession session = request.getSession();
		
		//버튼 클릭된 식당정보 받아와서 식당 조회
		int sc = Integer.parseInt(request.getParameter("storeCode"));
		System.out.println(sc);
		store = service.storeSelect(sc);
		
		//조회된 식당정보 리턴
		request.setAttribute("store", store);
		
		return "store/store.tiles";
	}

}
