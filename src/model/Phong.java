package model;

import java.util.Objects;

public class Phong {
	private String MaPhong;
	private int Tang;
	private float GiaPhong;
	private int SLNguoiMax;
	private String TrangThai;
	
	public Phong() {
		
	}
	public Phong(String maPhong) {
		MaPhong = maPhong;
	}
	public Phong(String maPhong, int tang, float giaPhong, int sLNguoiMax, String trangThai) {
		super();
		MaPhong = maPhong;
		Tang = tang;
		GiaPhong = giaPhong;
		SLNguoiMax = sLNguoiMax;
		TrangThai = trangThai;
	}
	public String getMaPhong() {
		return MaPhong;
	}
	public void setMaPhong(String maPhong) {
		MaPhong = maPhong;
	}
	public int getTang() {
		return Tang;
	}
	public void setTang(int tang) {
		Tang = tang;
	}
	public float getGiaPhong() {
		return GiaPhong;
	}
	public void setGiaPhong(float giaPhong) {
		GiaPhong = giaPhong;
	}
	public int getSLNguoiMax() {
		return SLNguoiMax;
	}
	public void setSLNguoiMax(int sLNguoiMax) {
		SLNguoiMax = sLNguoiMax;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(GiaPhong, MaPhong, SLNguoiMax, Tang, TrangThai);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phong other = (Phong) obj;
		return Float.floatToIntBits(GiaPhong) == Float.floatToIntBits(other.GiaPhong)
				&& Objects.equals(MaPhong, other.MaPhong) && SLNguoiMax == other.SLNguoiMax && Tang == other.Tang
				&& Objects.equals(TrangThai, other.TrangThai);
	}
	@Override
	public String toString() {
		return "Phong [MaPhong=" + MaPhong + ", Tang=" + Tang + ", GiaPhong=" + GiaPhong + ", SLNguoiMax=" + SLNguoiMax
				+ ", TrangThai=" + TrangThai + "]";
	}
	
	
	
}
