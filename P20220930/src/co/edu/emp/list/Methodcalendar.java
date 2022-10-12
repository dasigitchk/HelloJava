package co.edu.emp.list;

import java.util.Calendar;

public class Methodcalendar {
	private static  Methodcalendar instance = new Methodcalendar(); //초기값 null
//	private Methodcalendar() {}
	public static Methodcalendar getInstance() {
		return instance;
	}
	
	public  void makeCal(int year, int month) {
		System.out.println("        >>>> " + year +"년 "+ month + "월 <<<<<     ");
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		for (String day : days) { // days만큼만 반복
			System.out.printf("%4s", day); // 4칸만큼 표현, 뒤에 s는 문자열이온다는뜻
		}
		System.out.println();

		// 1일의 위치지정.
		for (int i = 0; i < getFirstDay(year,month); i++) {
			System.out.printf("%4s", " ");
		}
		// 날짜 출력.
		for (int i = 1; i <= getLastDate(year, month); i++) {
			System.out.printf("%4d", i);// 숫자는 digit의 d를 붙여줌
			if ((i + getFirstDay(year, month)) % 7 == 0) {
				System.out.println();
				;
			}
		}
	} // end of makeCal()

	public  int getFirstDay(int year, int month) {
		Calendar cal  = Calendar.getInstance();
		cal.set(year, month -1, 1);
		return cal.get(Calendar.DAY_OF_WEEK) - 1; // 1
	} 

	public  int getLastDate(int year, int month) {
		Calendar last  = Calendar.getInstance();
		last.set(year, month -1, 1);
		return last.getActualMaximum(Calendar.DATE);
	}	
	
}// end of class.
