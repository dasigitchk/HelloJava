package co.edu;

import java.util.Arrays;

public class Student {
	
	//필드.
	private String StudId; // 외부에서 접근못하게 숨김 호출하면 에러남.
	private String name;
	private String major;
	private int age; // 정수값 23, 0, -12
	private String[] hobbies = new String[5];
	//주로 필드값을 프라이빗으로 숨기고 아래의 메소드를 이용해 불러옴.
	
	//정적메소드.
	public static void staticMethod() {
		System.out.println("staticMethod call.");
	}
	
	// 생성자(필드의 값을 초기화) 생성자 오버로딩(동일한 이름의 생성자를 여러번 정의)
	public Student() {
		// 매개값이 없는 생성자 = > 기본생성자. 지정안하면 자바컴파일러가 자동으로 만듦. 만약 생성자 정의를하면 기본생성자를 안만들어 줌.
		this.name = "기본값";
		this.StudId = "000-000"; 
	}
	public Student(String StudId, String name) {
		this.StudId = StudId;
		this.name = name;
	}
	public Student(String StudId, String name, String major) {
		this(StudId, name);  // 기본생성자 호출.
		this.StudId = StudId;
		this.name = name;
		this.major = major;
	}
	//메소드.
	void setHobbies(String[] hobbies) {
//		this.hobbies = hobbies;
		for(String hobby : hobbies) {
			for(int i = 0; i < this.hobbies.length; i++) {
				if(this.hobbies[i] == null) {
					this.hobbies[i] = hobby;
					break;
				}
			}
		}
	}
	String[] getHobbies(String hobbies) {
		return this.hobbies;
	}
	String getHobb() {
		String str = "취미는 ";
		for(String hobby : hobbies) {
			if(hobby != null) {
			str += hobby + " ";
			}
		}
		str +="입니다.";
		return str;
	}
	// 취미추가.
	void addHobby(String hobby) {
		for(int i = 0; i<hobbies.length; i++ ) {
			if(hobbies[i] == null) {
				hobbies[i] = hobby;
				break;
			}
		}
	}

	void setStudId(String StudId) {
			this.StudId = StudId;
		}
	String getStudId() {
		return this.StudId;
	}
	
	//학생이름
	void setName(String name) {
		this.name = name;
	}
	String getName() {
		return this.name;
	}
	
	void setMajor(String major) {
		this.major = major;
	}
	String getMajor() {
		return this.major;
	}
	void setAge(int age) {
		if(age < 0) {
			this.age = 0; //위에 선언된 필드 age를 가르킴. 매개변수 age가 아님. 매개변수와 필드값을 같게 작성하는 룰?이있음.
		}else {
			this.age = age;
		}
	}
	int getAge() {
		return this.age;
	}
	
	//showInfo()
	public String showInfo() {
		return "이름은 " + this.name + "이고 학번은 " + this.StudId + " 입니다.";
	}
	String showInfo2() {
		return "이름은 " + this.name + "이고  학번은 " +this.StudId + " 이고 전공은 "	+ this.major + "입니다.";};
	void study() {
		System.out.println(name + " 가 공부합니다.");
	}
	void playGame() {
		System.out.println( name + " 가 게임을 합니다.");
	}
	void sleep() {
		System.out.println(name + " 가 잠을 잡니다.");
	}

	@Override
	public String toString() {
		return "Student [StudId=" + StudId + ", name=" + name + ", major=" + major + ", age=" + age + ", hobbies="
				+ Arrays.toString(hobbies) + "]";
	}
}
