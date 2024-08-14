package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.KhachHang;

public class KhachHangSQL {
	// thêm một khách hàng vào data base
	public void insertKhachHang(KhachHang kh) {
		Connection connection = DAO.getConnection();
		String sql = "INSERT INTO tKhachHang(MaKH, MaPhong, HoTen, CCCD, SDT, NgaySinh) VALUES(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, kh.getMaKH());
            statement.setString(2, kh.getMaPhong());
            statement.setString(3, kh.getHoTen());
            statement.setLong(4, kh.getCCCD());
            statement.setLong(5, kh.getSDT());
            statement.setString(6, kh.getNgaySinh());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
      }
	// kiểm tra khách hàng tồn tại trong data base không
	public boolean kiemTraTonTaiSQL(KhachHang kh) {
	    Connection connection = DAO.getConnection();
	    String sql = "SELECT COUNT(*) AS count FROM tKhachHang WHERE MaKH = ?";
	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setString(1, kh.getMaKH());
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
	// cập nhật kh trong data base
	public void capNhatKhachHangSQL(KhachHang kh) {
	    if (kiemTraTonTaiSQL(kh)) {
	        Connection connection = DAO.getConnection();
	        String sql = "UPDATE tKhachHang SET MaPhong = ?, HoTen = ?, CCCD = ?, SDT = ?, NgaySinh = ? WHERE MaKH = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, kh.getMaPhong());
	            statement.setString(2, kh.getHoTen());
	            statement.setLong(3, kh.getCCCD());
	            statement.setLong(4, kh.getSDT());
	            statement.setString(5, kh.getNgaySinh());
	            statement.setString(6, kh.getMaKH());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.out.println("Không tồn tại khách hàng có mã " + kh.getMaKH() + " trong cơ sở dữ liệu.");
	    }
	}
	// thêm kh vào data base
	public void themKhachHangSQL(KhachHang kh) {
	    if (!kiemTraTonTaiSQL(kh)) {
	        insertKhachHang(kh);
	    } else {
	        System.out.println("Khách hàng có mã " + kh.getMaKH() + " đã tồn tại trong cơ sở dữ liệu.");
	    }
	}
	
	// lấy ra các khách hàng trong csdl
	public List<KhachHang> getAllKhachHangSQL() {
        List<KhachHang> danhSachKhahHang = new ArrayList<>();
        Connection connection = DAO.getConnection();
        String sql = "SELECT * FROM tKhachHang";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	String maKH = resultSet.getString("MaKH");
                String maPhong = resultSet.getString("MaPhong");
                String hoTen = resultSet.getString("HoTen");
                long cCCD = resultSet.getLong("CCCD");
                long SDT = resultSet.getLong("SDT");
                String ngaySinh = resultSet.getString("NgaySinh");
                
                
                KhachHang kh = new KhachHang(maKH,maPhong,hoTen,cCCD,SDT,ngaySinh);
                danhSachKhahHang.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachKhahHang;
    }
	// xóa kh trong csdl
	public void xoaKhachHangTheoMaSQL(String maKH) {
        Connection connection = DAO.getConnection();
        String sql = "DELETE FROM tKhachHang WHERE MaKH = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maKH);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	// Tìm Khách hàng trong csdl
	public List<KhachHang> timKhachHangTheoMaSQL(String maKH) {
        List<KhachHang> danhSachKhachHang = new ArrayList<>();
        Connection connection = DAO.getConnection();
        String sql = "SELECT * FROM tKhachHang WHERE MaKH = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maKH);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	String maKhResult = resultSet.getString("MaKH");
                String maPhong = resultSet.getString("MaPhong");
                String hoTen = resultSet.getString("HoTen");
                long cCCD = resultSet.getLong("CCCD");
                long SDT = resultSet.getLong("SDT");
                String ngaySinh = resultSet.getString("NgaySinh");
                KhachHang kh = new KhachHang(maKhResult,maPhong,hoTen,cCCD,SDT,ngaySinh);
                danhSachKhachHang.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachKhachHang;
    }
	
}
