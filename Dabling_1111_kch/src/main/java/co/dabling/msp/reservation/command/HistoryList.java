package co.dabling.msp.reservation.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.history.service.HistoryService;
import co.dabling.msp.history.service.impl.HistoryServiceImpl;
import co.dabling.msp.history.vo.HistoryVO;

public class HistoryList implements Command  {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HistoryService dao = new HistoryServiceImpl();
		List<HistoryVO> list = new ArrayList<>();
		list=dao.HistoryList();
		request.setAttribute("list", list);
		return "history/history";
	}

}
