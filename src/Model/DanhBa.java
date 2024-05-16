package Model;

public class DanhBa {
	private String ten;
	private int nS;
	private String dC;
	private String sDT;
	private byte[] anh;
	public DanhBa() {
		super();
	}
	public DanhBa(String ten, int nS, String dC, String sDT, byte[] anh) {
		super();
		this.ten = ten;
		this.nS = nS;
		this.dC = dC;
		this.sDT = sDT;
		this.anh = anh;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getnS() {
		return nS;
	}
	public void setnS(int nS) {
		this.nS = nS;
	}
	public String getdC() {
		return dC;
	}
	public void setdC(String dC) {
		this.dC = dC;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public byte[] getAnh() {
		return anh;
	}
	public void setAnh(byte[] anh) {
		this.anh = anh;
	}
	
}