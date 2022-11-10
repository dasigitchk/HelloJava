package co.dabling.msp.admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;

public class StoreSelectForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 매장선택조회 화면출력
		return "admin/storeSelectForm.tiles";
	}

}
