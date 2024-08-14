package model;

import java.util.Objects;

public class KhachHang {
	private String MaKH;
	private String HoTen;
	private long SDT;
	private long CCCD;
	private String NgaySinh;
	private String maPhong;
	
	public KhachHang(String maKH, String maPhong, String hoTen, long cCCD, long SDT, String ngaySinh) {
		super();
		this.MaKH = maKH;
		this.HoTen = hoTen;
		this.SDT=SDT;
		this.CCCD = cCCD;
		this.NgaySinh = ngaySinh;
		this.maPhong = maPhong;
	}
	public KhachHang() {
		
	}
	
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public long getSDT() {
		return SDT;
	}
	public void setSDT(long SDT) {
		this.SDT=SDT;
	}
	public long getCCCD() {
		return CCCD;
	}
	public void setCCCD(long cCCD) {
		CCCD = cCCD;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	@Override
	public int hashCode() {
		return Objects.hash(CCCD, HoTen, MaKH, NgaySinh, SDT, maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return CCCD == other.CCCD && Objects.equals(HoTen, other.HoTen) && Objects.equals(MaKH, other.MaKH)
				&& Objects.equals(NgaySinh, other.NgaySinh) && SDT == other.SDT
				&& Objects.equals(maPhong, other.maPhong);
	}
	
}
