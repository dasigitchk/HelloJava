package co.dabling.msp.reservation.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.reservation.service.ReservationService;
import co.dabling.msp.reservation.service.impl.ReservationServiceImpl;
import co.dabling.msp.reservation.vo.ReservationVO;

public class ReservationCancel implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 예약취소실행
		
		ReservationService dao = new ReservationServiceImpl();
		ReservationVO vo = new ReservationVO(); 
		vo.setReservationCode(Integer.parseInt(request.getParameter("reservationCode")));
		dao.reservationCancel(vo);
		
		return "/m/reservationCancelForm";
	}

}
