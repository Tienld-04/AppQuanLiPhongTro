package model;

public class TaiKhoan {
	private String MaTK;
	private String MatKhau;
	
	public TaiKhoan() {
		
	}
	public TaiKhoan(String maTK, String matKhau) {
		MaTK = maTK;
		MatKhau = matKhau;
	}
	public String getMaTK() {
		return MaTK;
	}
	public void setMaTK(String maTK) {
		MaTK = maTK;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	
	
}
