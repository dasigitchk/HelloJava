package co.dabling.msp.reservation.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationVO {
	private int reservationCode;
	private int memberCode;
	private int storeCode;
	private String reservationDate;
	private String reservationTime;
	private int reservationPeople;
}
