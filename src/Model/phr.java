package Model;

public class phr {
	private String phoneNumber;
	private String blood;
	private double weight;
	private double height;
	private int huyetAp;
	private String tienSuBenh;
	public phr() {
		super();
	}
	public phr(String phoneNumber, String blood, double weight, double height, int huyetAp, String tienSuBenh) {
		super();
		this.phoneNumber = phoneNumber;
		this.blood = blood;
		this.weight = weight;
		this.height = height;
		this.huyetAp = huyetAp;
		this.tienSuBenh = tienSuBenh;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getHuyetAp() {
		return huyetAp;
	}
	public void setHuyetAp(int huyetAp) {
		this.huyetAp = huyetAp;
	}
	public String getTienSuBenh() {
		return tienSuBenh;
	}
	public void setTienSuBenh(String tienSuBenh) {
		this.tienSuBenh = tienSuBenh;
	}
	@Override
	public String toString() {
		return "phr [phoneNumber=" + phoneNumber + ", blood=" + blood + ", weight=" + weight + ", height=" + height
				+ ", huyetAp=" + huyetAp + ", tienSuBenh=" + tienSuBenh + "]";
	}
	

}
