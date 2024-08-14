package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Phong;
public class PhongSQL {
	// thêm 1 phòng vào cơ sở dữ liệu
	public void insertPhongSQL(Phong phong) {
		Connection connection = DAO.getConnection();
        String sql = "INSERT INTO tPhong(MaPhong, Tang, GiaPhong, SoLuongNguoiMax, TrangThai) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, phong.getMaPhong());
            statement.setInt(2, phong.getTang());
            statement.setFloat(3, phong.getGiaPhong());
            statement.setInt(4, phong.getSLNguoiMax());
            statement.setString(5, phong.getTrangThai());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	// kiểm tra khách hàng tồn tại trong data base không
	public boolean kiemTraTonTaiSQL(Phong p) {
	    Connection connection = DAO.getConnection();
	    String sql = "SELECT COUNT(*) AS count FROM tPhong WHERE MaPhong = ?";
	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setString(1, p.getMaPhong());
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
	public void capNhatPhongSQL(Phong p) {
	    if (kiemTraTonTaiSQL(p)) {
	        Connection connection = DAO.getConnection();
	        String sql = "UPDATE tPhong SET Tang = ?, GiaPhong = ?, SoLuongNguoiMax = ?, TrangThai = ? WHERE MaPhong = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, p.getTang()); 
	            statement.setFloat(2, p.getGiaPhong());
	            statement.setInt(3, p.getSLNguoiMax());	   
	            statement.setString(4, p.getTrangThai());
	            statement.setString(5, p.getMaPhong());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.out.println("Không tồn tại khách hàng có mã " + p.getMaPhong() + " trong cơ sở dữ liệu.");
	    }
	}
	// thêm kh vào data base
	public void themPhongSQL(Phong p) {
	    if (!kiemTraTonTaiSQL(p)) {
	        insertPhongSQL(p);
	    } else {
	        System.out.println("Khách hàng có mã " + p.getMaPhong() + " đã tồn tại trong cơ sở dữ liệu.");
	    }
	}
	
	// lấy ra tất cả mã phòng trong sql
	public List<Phong> getAllMaPhongSQL() {
        List<Phong> danhSachMaPhong = new ArrayList<>();
        Connection connection = DAO.getConnection();
        String sql = "SELECT * FROM tPhong";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	String maPhong = resultSet.getString("MaPhong");
            	
                Phong p = new Phong(maPhong);
                danhSachMaPhong.add(p); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachMaPhong;
    }
	// lấy ra tất cả phòng trong sql
	public List<Phong> getAllPhongSQL() { 
        List<Phong> danhSachPhong = new ArrayList<>();
        Connection connection = DAO.getConnection();
        String sql = "SELECT * FROM tPhong";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            	String maPhong = rs.getString("MaPhong");
            	int tang=rs.getInt("Tang");
    			float giaPhong=rs.getFloat("GiaPhong");
    			int soLuongNguoiMax=rs.getInt("SoLuongNguoiMax");
    			String trangThai=rs.getString("TrangThai");
    			Phong p=new Phong(maPhong, tang, giaPhong, soLuongNguoiMax, trangThai);
                danhSachPhong.add(p); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        	}
        return danhSachPhong;
		}
	// xóa phòng trong sql theo mã phòng
		public void xoaPhongTheoMaSQL(String maPhong) {
	        Connection connection = DAO.getConnection();
	        String sql = "DELETE FROM tPhong WHERE MaPhong = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, maPhong);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		// Tìm Phòng trong csdl
		public List<Phong> timPhongTheoMaSQL(String maPhong) {
	        List<Phong> danhSachPhong = new ArrayList<>();
	        Connection connection = DAO.getConnection();
	        String sql = "SELECT * FROM tPhong WHERE MaPhong = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, maPhong); // thiết lập maPhong cho MaPhong trong sql
	            ResultSet resultSet = statement.executeQuery(); // đối tượng chứa kết quả truy vấn
	            while (resultSet.next()) {
	            	String maPhongResult = resultSet.getString("MaPhong");
	            	int tang = resultSet.getInt("Tang");
	    			float giaPhong = resultSet.getFloat("GiaPhong");
	    			int soLuongNguoiMax = resultSet.getInt("SoLuongNguoiMax");
	    			String trangThai = resultSet.getString("TrangThai");
	    			Phong p = new Phong(maPhongResult, tang, giaPhong, soLuongNguoiMax, trangThai);
	                danhSachPhong.add(p); 
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return danhSachPhong;
	    }
	
}