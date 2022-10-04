package co.edu.inherit.friend;

public class UnivFriend extends Friend {
	
	private String univ;
	private String major;
	
	public UnivFriend() {  
		super();  //부모클래스에 메소드에 매개변수가 있을때 ?
	}
	
	public  UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone);
		this.univ = univ;
		this.major = major;
	}

	public String getUniv() {
		return this.univ;
	}
	public void setUniv(String univ) {
		this.univ = univ;
	}
	public String getMajor() {
		return this.major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String showInfo() {
		return "학교친구의 이름은 " + getName() //
		+ ", 연락처는 " + getPhone() //
		+ ", 학교명은 " + this.univ //
		+ ", 전공은 " + this.major;
	}
	
}
