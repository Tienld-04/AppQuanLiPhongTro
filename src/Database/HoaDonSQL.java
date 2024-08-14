package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.HoaDon;

public class HoaDonSQL {
	// thêm 1 hóa đơn vào cơ sở dữ liệu
	public void insertHoaDon(HoaDon hd) {
		Connection connection = DAO.getConnection();
		String sql = "INSERT INTO tHoaDon(MaHD, MaPhong, NgayThanhToan, TienPhong, TienDien, TienNuoc, TienDichVu) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, hd.getMaHoaDon());
            statement.setString(2, hd.getMaPhong());
            statement.setString(3, hd.getNgayThanhToan());
            statement.setFloat(4, hd.getTienPhong());
            statement.setFloat(5, hd.getTienDien());
            statement.setFloat(6, hd.getTienNuoc());
            statement.setFloat(7, hd.getTienDV());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	// kiểm tra Hóa đơn tồn tại trong data base không
		public boolean kiemTraTonTaiSQL(HoaDon hd) {
		    Connection connection = DAO.getConnection();
		    String sql = "SELECT COUNT(*) AS count FROM tHoaDon WHERE MaHD = ?";
		    try (PreparedStatement statement = connection.prepareStatement(sql)) {
		        statement.setString(1, hd.getMaHoaDon());
		        ResultSet resultSet = statement.executeQuery();
		        if (resultSet.next()) {
		            int count = resultSet.getInt("count");
		            return count > 0;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return false;
		}
		// cập nhật Hóa đơn trong data base
		public void capNhatHoaDonSQL(HoaDon hd) {
		    if (kiemTraTonTaiSQL(hd)) {
		        Connection connection = DAO.getConnection();
		        String sql = "UPDATE tHoaDon SET MaPhong = ?, NgayThanhToan = ?, TienPhong = ?, TienDien = ?, TienNuoc = ?, TienDichVu = ? WHERE MaHD = ?";
		        try (PreparedStatement statement = connection.prepareStatement(sql)) {
		            statement.setString(1, hd.getMaPhong());
		            statement.setString(2, hd.getNgayThanhToan());
		            statement.setFloat(3, hd.getTienPhong());
		            statement.setFloat(4, hd.getTienDien());
		            statement.setFloat(5, hd.getTienNuoc());
		            statement.setFloat(6, hd.getTienDV());
		            statement.setString(7, hd.getMaHoaDon());
		            statement.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    } else {
		        System.out.println("Không tồn tại Hóa đơn có mã " + hd.getMaHoaDon() + " trong cơ sở dữ liệu.");
		    }
		}
		// thêm Hóa đơn vào data base
		public void themHoaDonSQL(HoaDon hd) {
		    if (!kiemTraTonTaiSQL(hd)) {
		        insertHoaDon(hd);
		    } else {
		        System.out.println("Hóa Đơn có mã " + hd.getMaHoaDon() + " đã tồn tại trong cơ sở dữ liệu.");
		    }
		}
		// lấy ra tất cả các hóa đơn
	public List<HoaDon> getAllHoaDonSQL() {
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        Connection connection = DAO.getConnection();
        String sql = "SELECT * FROM tHoaDon";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	String maHoaDon = resultSet.getString("MaHD");
                String maPhong = resultSet.getString("MaPhong");
                String ngayThanhToan = resultSet.getString("NgayThanhToan");
                float tienPhong = resultSet.getFloat("TienPhong");
                float tienDien = resultSet.getFloat("TienDien");
                float tienNuoc= resultSet.getFloat("TienNuoc");
                float tienDV = resultSet.getFloat("TienDichVu");

                HoaDon hd = new HoaDon(maHoaDon, maPhong, ngayThanhToan, tienPhong, tienDien, tienNuoc, tienDV);
                danhSachHoaDon.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachHoaDon;
    }
	// xóa hóa đơn khỏi database theo mã
	public void xoaHoaDonTheoMaSQL(String maHoaDon) {
        Connection connection = DAO.getConnection();
        String sql = "DELETE FROM tHoaDon WHERE MaHD = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maHoaDon);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	// tìm hóa đơn theo mã 
	public List<HoaDon> timHoaDonTheoMaSQL(String maHD) {
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        Connection connection = DAO.getConnection();
        String sql = "SELECT * FROM tHoaDon WHERE MaHD = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maHD);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	String maHoaDon = resultSet.getString("MaHD");
                String maPhong = resultSet.getString("MaPhong");
                String ngayThanhToan = resultSet.getString("NgayThanhToan");
                float tienPhong = resultSet.getLong("TienPhong");
                float tienDien = resultSet.getLong("TienDien");
                float tienNuoc= resultSet.getLong("TienNuoc");
                float tienDV = resultSet.getLong("TienDichVu");
                HoaDon hd = new HoaDon(maHoaDon, maPhong, ngayThanhToan, tienPhong, tienDien, tienNuoc, tienDV);
                danhSachHoaDon.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachHoaDon;
    }
}
