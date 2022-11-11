package co.dabling.msp.store.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;

public class StoreInsertForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		// 매장 승인신청
		return "store/storeInsertForm.tiles";
	}

}
