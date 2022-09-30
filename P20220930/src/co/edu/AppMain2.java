package co.edu;

public class AppMain2 {
	public static void main(String[] args) {
		
	Student.staticMethod();
	
	Math.random(); //정적메소드.
	Math.round(.5);
	
	Student s1 = new Student();
	//s1.staticMethod(); // 노란밑줄은 에러는 아니지만 warning.
	
	s1.setStudId("111-111");
	s1.setName("홍길동");
	s1.setMajor("컴퓨터공학");
	s1.setAge(20);
	
Student s2 = new Student();
	
	s2.setStudId("222-222");
	s2.setName("아무개");
	s2.setMajor("역사학과");
	s2.setAge(20);
	
	System.out.println(s1.getStudId()); //String = null 초기값 출력.
	System.out.println(s1.getAge());
	System.out.println(s1.showInfo());
	System.out.println(s2.showInfo2());
	
	System.out.println("여기 >>>>" + s1);
	
	String[] hob = {"독서", "자전거"};
	s1.setHobbies(hob);
	s1.addHobby("음악듣기");
	System.out.println(s1.getHobb());
	
	Student s3 = new Student();
	System.out.println(s3.getName());
	
	Student s4 = new Student("111-234", "김충현");
	System.out.println(s4.showInfo());
	
	Student s5 = new Student("111-234", "이충현", "역사학과");
	System.out.println(s5.showInfo());
	}
}
