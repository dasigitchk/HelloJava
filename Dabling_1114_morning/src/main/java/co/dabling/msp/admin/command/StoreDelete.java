package co.dabling.msp.admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.store.service.StoreService;
import co.dabling.msp.store.service.impl.StoreServiceImpl;

public class StoreDelete implements Command{
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 매장정보삭제 
		String businessNum = request.getParameter("businessNum");
		StoreService service = new StoreServiceImpl();
		service.storeDelete(businessNum);
		
		return "admin/storeDeleteForm.tiles";
	}

}
