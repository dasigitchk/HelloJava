package co.educationcenter;

public class Members {
	private String memId;
	private String passwd;
	private int memNo;
	private String name;
	private String tel;
	private String addr;
	private String lect;
	
	Members(String memId, String passwd,String name, String tel, String addr, String lect){
			this.memId = memId;
			this.passwd = passwd;
			this.name = name;
			this.tel = tel;
			this.addr = addr;
			this.lect = lect;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLect() {
		return lect;
	}

	public void setLect(String lect) {
		this.lect = lect;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}
