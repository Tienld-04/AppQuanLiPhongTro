package model;

import java.util.Objects;

public class HoaDon {
      private String maHoaDon;
      private String maPhong;
      private String ngayThanhToan;
      private float tienPhong, tienDien, tienNuoc, tienDV;
      
      public HoaDon(){ 
      }
	public HoaDon(String maHoaDon, String maPhong, String ngayThanhToan, float tienPhong, float tienDien,
			float tienNuoc, float tienDV) {
		super();
		this.maHoaDon = maHoaDon;
		this.maPhong = maPhong;
		this.ngayThanhToan = ngayThanhToan;
		this.tienPhong = tienPhong;
		this.tienDien = tienDien;
		this.tienNuoc = tienNuoc;
		this.tienDV = tienDV;
	}
	

	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getNgayThanhToan() {
		return ngayThanhToan;
	}
	public void setNgayThanhToan(String ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}
	public float getTienPhong() {
		return tienPhong;
	}
	public void setTienPhong(float tienPhong) {
		this.tienPhong = tienPhong;
	}
	public float getTienDien() {
		return tienDien;
	}
	public void setTienDien(float tienDien) {
		this.tienDien = tienDien;
	}
	public float getTienNuoc() {
		return tienNuoc;
	}
	public void setTienNuoc(float tienNuoc) {
		this.tienNuoc = tienNuoc;
	}
	public float getTienDV() {
		return tienDV;
	}
	public void setTienDV(float tienDV) {
		this.tienDV = tienDV;
	}
	public float getTongTien() {
		return tienDien+tienNuoc+tienDV+tienPhong;
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", maPhong=" + maPhong + ", ngayThanhToan=" + ngayThanhToan
				+ ", tienPhong=" + tienPhong + ", tienDien=" + tienDien + ", tienNuoc=" + tienNuoc + ", tienDV="
				+ tienDV + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon, maPhong, ngayThanhToan, tienDV, tienDien, tienNuoc, tienPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon) && Objects.equals(maPhong, other.maPhong)
				&& Objects.equals(ngayThanhToan, other.ngayThanhToan)
				&& Float.floatToIntBits(tienDV) == Float.floatToIntBits(other.tienDV)
				&& Float.floatToIntBits(tienDien) == Float.floatToIntBits(other.tienDien)
				&& Float.floatToIntBits(tienNuoc) == Float.floatToIntBits(other.tienNuoc)
				&& Float.floatToIntBits(tienPhong) == Float.floatToIntBits(other.tienPhong);
	}
	
	
}
	
	
	