package eduCenter;

public class Members {
	
	//필드
	private String memId;
	private int memNo;
	private int idNum;
	private String name;
	private String tel;
	private String addr;
	private String lect;
	
	//생성자
	Members(String name, int idNum, String addr, String tel, String lect){
			super();
			this.name = name;
			this.idNum = idNum;
			this.tel = tel;
			this.addr = addr;
			this.lect = lect;
	}
	
	//로그인용 데이터 임시저장용 생성자.
	Members(String name, int idNum){
		super();
		this.name = name;
		this.idNum = idNum;
}
	
	//getter & setter
	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
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
