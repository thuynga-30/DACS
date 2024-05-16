package Model;

public class user {
	private String fullname;
	private String phoneNumber;
	private String passWord;
	public user() {
		super();
	}
	public user(String phoneNumber, String fullname,String passWord) {
		super();
		this.phoneNumber = phoneNumber;
		this.fullname=fullname;
		this.passWord = passWord;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}