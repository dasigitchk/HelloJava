package co.dabling.msp.admin.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.store.service.StoreService;
import co.dabling.msp.store.service.impl.StoreServiceImpl;
import co.dabling.msp.store.vo.StoreVO;

public class StoreManagePage  implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 매장전체목록 가져오기
		StoreService service = new StoreServiceImpl();
		List<StoreVO> stores = new ArrayList<>();
		stores = service.storeSelectList();
		request.setAttribute("stores", stores);
		
		return "admin/storeApprovalForm.tiles";
	}

}
