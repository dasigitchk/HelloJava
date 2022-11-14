package co.dabling.msp.store.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.dabling.msp.common.Command;
import co.dabling.msp.reservation.service.ReservationService;
import co.dabling.msp.reservation.service.impl.ReservationServiceImpl;
import co.dabling.msp.reservation.vo.ReservationVO;
import co.dabling.msp.store.service.StoreService;
import co.dabling.msp.store.service.impl.StoreServiceImpl;
import co.dabling.msp.store.vo.StoreVO;

public class StoreReservationSearch implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		//현 예약현황 날짜 검색
		HttpSession session = request.getSession();
		StoreVO store = new StoreVO();
		StoreService storeService = new StoreServiceImpl();
		ReservationVO reservation = new ReservationVO();
		List <ReservationVO> reservationList = new ArrayList();
		ReservationService reservationService = new ReservationServiceImpl();
		
		// 로그인 가게코드찾기.
		String businessNum = (String) session.getAttribute("businessNum");
		store = storeService.storeSelect(businessNum);
		int storeCode = store.getStoreCode();
						
		String firstDate = request.getParameter("firstDate");
		String lastDate = request.getParameter("lastDate");
		System.out.println("가게코드" + storeCode);
		System.out.println(firstDate);
		System.out.println(lastDate);
		
		reservation.setFirstDate(firstDate);
		reservation.setLastDate(lastDate);
		reservationList = reservationService.storeReservationListSearch(storeCode,firstDate,lastDate);
		for(ReservationVO reservation1 : reservationList) {
			System.out.println(reservation1.getReservationDate());
		}
		request.setAttribute("reservationStatus", reservationList);

		// 매장 예약현황 사이트로 가기
		return "store/storeReservationStatus.tiles";
	}

}
