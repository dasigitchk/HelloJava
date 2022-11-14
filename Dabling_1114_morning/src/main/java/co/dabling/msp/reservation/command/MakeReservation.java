package co.dabling.msp.reservation.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.reservation.service.ReservationService;
import co.dabling.msp.reservation.service.impl.ReservationServiceImpl;
import co.dabling.msp.reservation.vo.ReservationVO;

public class MakeReservation implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MakeReservation도착");

		ReservationService service = new ReservationServiceImpl();
		ReservationVO reservation = new ReservationVO();
	
		int memberCode = Integer.parseInt(request.getParameter("memberCode"));
		int storeCode = Integer.parseInt(request.getParameter("storeCode"));
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		int person = Integer.parseInt(request.getParameter("person"));
		
		reservation.setMemberCode(memberCode);
		reservation.setStoreCode(storeCode);
		reservation.setReservationDate(date);
		reservation.setReservationTime(time);
		reservation.setReservationPeople(person);
		
		int book = service.reservationInsert(reservation) ;
		
		String message ="예약완료";
		return "ajax:"+message;
	}

}
