Create database QLPHONGTRO

create table tPhong(
	MaPhong nvarchar(50),
	Tang int,
	GiaPhong float,
	SoLuongNguoiMax int,
	TrangThai nvarchar(50),
	PRIMARY KEY (MaPhong)
);
create table tKHachHang(
	MaKH nvarchar(50),
	MaPhong nvarchar(50),
	HoTen nvarchar(50),
	CCCD bigint,
	SDT bigint,
	NgaySinh nvarchar(50),
	PRIMARY KEY (MaKH),
	FOREIGN KEY (MaPhong) REFERENCES tPhong(MaPhong),
);

create table tHoaDon(
	MaHD nvarchar(50),
	MaPhong nvarchar(50),
	NgayThanhToan nvarchar(50),
	TienPhong float,
	TienDien float,
	TienNuoc float,
	TienDichVu float,
	PRIMARY KEY (MaHD),
	FOREIGN KEY (MaPhong) REFERENCES tPhong(MaPhong),

);

