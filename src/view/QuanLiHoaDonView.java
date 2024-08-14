package view;

import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Database.HoaDonSQL;
import Database.PhongSQL;
import controller.HoaDonController;
import model.HoaDon;
import model.Phong;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;
public class QuanLiHoaDonView extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JTextField textFieldMaHoaDon;
	private JTextField textFieldMaPhong;
	private JTextField textFieldNgayThanhToan;
	private JTextField textFieldTienDien;
	private JTextField textFieldTienNuoc;
	private JTextField textFieldTienDichVu;
	private JTable tableDanhSachHoaDon; 
	private JTextField textFieldTimHoaDonTheoMa;
	private JTextField textFieldTongTien;
	private JTextField textFieldTienPhong;
	
	public QuanLiHoaDonView() {
		
				setBackground(new Color(192, 192, 192));
				setLayout(null);
				ActionListener action=new HoaDonController(this);
				JLabel lblNewLabel = new JLabel("Quản lí hóa đơn");
				lblNewLabel.setBackground(new Color(51, 0, 51));
				lblNewLabel.setForeground(new Color(0, 0, 130));
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
				lblNewLabel.setBounds(347, 0, 171, 38);
				add(lblNewLabel);
				
				JPanel jpnTTCN = new JPanel();
				jpnTTCN.setBackground(new Color(192, 192, 192));
				jpnTTCN.setBounds(10, 0, 838, 251);
				add(jpnTTCN);
				jpnTTCN.setLayout(null);
				
				JPanel jpnCN = new JPanel();
				jpnCN.setBackground(new Color(192, 192, 192));
				jpnCN.setBounds(549, 40, 298, 231);
				jpnTTCN.add(jpnCN);
				jpnCN.setLayout(null);
				
				JButton jbtCapNhatHoaDon = new JButton("Cập nhật hóa đơn");
				jbtCapNhatHoaDon.setBackground(new Color(173, 216, 230));
				jbtCapNhatHoaDon.setForeground(new Color(0, 0, 153));
				jbtCapNhatHoaDon.setFont(new Font("Tahoma", Font.BOLD, 17));
				jbtCapNhatHoaDon.setBounds(21, 22, 253, 50);
				jbtCapNhatHoaDon.addActionListener(action);
				jpnCN.add(jbtCapNhatHoaDon);
				
				JButton jbtXoaHoaDon = new JButton("Xóa hóa đơn");
				jbtXoaHoaDon.addActionListener(action); 
				jbtXoaHoaDon.setForeground(new Color(0, 0, 153));
				jbtXoaHoaDon.setFont(new Font("Tahoma", Font.BOLD, 17));
				jbtXoaHoaDon.setBackground(new Color(173, 216, 230));
				jbtXoaHoaDon.setBounds(21, 82, 253, 50);
				jpnCN.add(jbtXoaHoaDon);
				
				JButton btnXoaForm = new JButton("Xóa form");
				btnXoaForm.setForeground(new Color(0, 0, 139));
				btnXoaForm.setBackground(new Color(175, 238, 238));
				btnXoaForm.setFont(new Font("Tahoma", Font.BOLD, 17));
				btnXoaForm.setBounds(21, 148, 253, 42);
				btnXoaForm.addActionListener(action);
				jpnCN.add(btnXoaForm);
				//
				JPanel jpnTT = new JPanel();
				jpnTT.setBounds(10, 40, 529, 195);
				jpnTTCN.add(jpnTT);
				jpnTT.setForeground(new Color(102, 204, 255));
				jpnTT.setBackground(new Color(173, 216, 230));
				jpnTT.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn");
				lblNewLabel_1.setBounds(0, 4, 101, 38);
				jpnTT.add(lblNewLabel_1);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JLabel lblNewLabel_3 = new JLabel("Mã phòng");
				lblNewLabel_3.setBounds(0, 52, 86, 24);
				jpnTT.add(lblNewLabel_3);
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JLabel lblNewLabel_8 = new JLabel("Ngày thanh toán");
				lblNewLabel_8.setBounds(0, 93, 127, 24); 
				jpnTT.add(lblNewLabel_8);
				lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JLabel lblNewLabel_7 = new JLabel("Tiền dịch vụ");
				lblNewLabel_7.setBounds(279, 93, 101, 24);
				jpnTT.add(lblNewLabel_7);
				lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JLabel lblNewLabel_5 = new JLabel("Tiền điện");
				lblNewLabel_5.setBounds(279, 12, 101, 22);
				jpnTT.add(lblNewLabel_5);
				lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JLabel lblNewLabel_6 = new JLabel("Tiền nước");
				lblNewLabel_6.setBounds(279, 52, 75, 24);
				jpnTT.add(lblNewLabel_6);
				lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JLabel lblNewLabel_9 = new JLabel("Tiền phòng");
				lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_9.setBounds(0, 131, 86, 26);
				jpnTT.add(lblNewLabel_9);
				
				JButton btnTongTien = new JButton("Tổng Tiền");
				//btnTongTien.addActionListener(action);
				btnTongTien.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnTongTien.setBounds(279, 131, 111, 36);
				jpnTT.add(btnTongTien);
				btnTongTien.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        tongTienCuaKhachHangDangChon();
				    }
				});
				
				textFieldMaHoaDon = new JTextField();
				textFieldMaHoaDon.setBounds(130, 11, 111, 24);
				jpnTT.add(textFieldMaHoaDon);
				textFieldMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 17));
				textFieldMaHoaDon.setColumns(10);
				
				textFieldNgayThanhToan = new JTextField();
				textFieldNgayThanhToan.setBounds(130, 93, 111, 24);
				jpnTT.add(textFieldNgayThanhToan);
				textFieldNgayThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 17));
				textFieldNgayThanhToan.setColumns(10);
				
				textFieldMaPhong = new JTextField();
				textFieldMaPhong.setBounds(130, 52, 111, 24);
				jpnTT.add(textFieldMaPhong);
				textFieldMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 17));
				textFieldMaPhong.setColumns(10);
				
				textFieldTienNuoc = new JTextField();
				textFieldTienNuoc.setBounds(404, 52, 114, 24);
				jpnTT.add(textFieldTienNuoc);
				textFieldTienNuoc.setFont(new Font("Tahoma", Font.PLAIN, 17));
				textFieldTienNuoc.setColumns(10);
				
				textFieldTienDien = new JTextField();
				textFieldTienDien.setBounds(404, 10, 114, 24);
				jpnTT.add(textFieldTienDien);
				textFieldTienDien.setFont(new Font("Tahoma", Font.PLAIN, 17));
				textFieldTienDien.setColumns(10);
				
				textFieldTienDichVu = new JTextField();
				textFieldTienDichVu.setBounds(404, 93, 114, 24);
				jpnTT.add(textFieldTienDichVu);
				textFieldTienDichVu.setFont(new Font("Tahoma", Font.PLAIN, 17));
				textFieldTienDichVu.setColumns(10);
				
				textFieldTienPhong = new JTextField();
				textFieldTienPhong.setFont(new Font("Tahoma", Font.PLAIN, 17));
				textFieldTienPhong.setBounds(130, 132, 111, 24);
				jpnTT.add(textFieldTienPhong);
				textFieldTienPhong.setColumns(10);
				
				textFieldTongTien = new JTextField();
				textFieldTongTien.setFont(new Font("Tahoma", Font.PLAIN, 17));
				textFieldTongTien.setEditable(false);
				textFieldTongTien.setBounds(404, 131, 114, 36);
				jpnTT.add(textFieldTongTien);
				textFieldTongTien.setColumns(10);
				//
				tableDanhSachHoaDon=new JTable();
				tableDanhSachHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
				tableDanhSachHoaDon.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"M\u00E3 H\u00F3a \u0110\u01A1n", "M\u00E3 ph\u00F2ng", "Ngày thanh toán", "Ti\u1EC1n Ph\u00F2ng", "Ti\u1EC1n \u0111i\u1EC7n", "Ti\u1EC1n n\u01B0\u1EDBc", "Ti\u1EC1n d\u1ECBch v\u1EE5"
					}
				));
				tableDanhSachHoaDon.getColumnModel().getColumn(5).setMinWidth(14);
				tableDanhSachHoaDon.addMouseListener(new MouseAdapter() {
					
				        @Override
				        public void mouseClicked(MouseEvent e) {
				            // Lấy chỉ số của dòng được nhấp
				            int selectedRow = tableDanhSachHoaDon.getSelectedRow();
				            // Kiểm tra xem có dòng được chọn không
				            if (selectedRow != -1) {
				                // Hiển thị thông tin của dòng được chọn
				                hienThiThongTinHoaDonDangChon();
				            }
				        }
				});
				JScrollPane scrollPane = new JScrollPane(tableDanhSachHoaDon);
				scrollPane.setBounds(10, 332, 828, 138);
				add(scrollPane);
				
				JLabel lblNewLabel_2 = new JLabel("Mã hóa đơn");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
				lblNewLabel_2.setBounds(10, 271, 109, 38);
				add(lblNewLabel_2);
				
				JSeparator separator = new JSeparator();
				separator.setBounds(19, 266, 838, 2);
				add(separator);
				
				textFieldTimHoaDonTheoMa = new JTextField();
				textFieldTimHoaDonTheoMa.setFont(new Font("Tahoma", Font.PLAIN, 16));
				textFieldTimHoaDonTheoMa.setBounds(134, 278, 146, 32);
				add(textFieldTimHoaDonTheoMa);
				textFieldTimHoaDonTheoMa.setColumns(10);
				
				JButton jbtTimHoaDonTheoMa = new JButton("Tìm");
				jbtTimHoaDonTheoMa.setFont(new Font("Tahoma", Font.BOLD, 17));
				jbtTimHoaDonTheoMa.setForeground(new Color(0, 0, 0));
				jbtTimHoaDonTheoMa.setBackground(new Color(175, 238, 238));
				jbtTimHoaDonTheoMa.setBounds(304, 278, 95, 33);
				jbtTimHoaDonTheoMa.addActionListener(action);
				add(jbtTimHoaDonTheoMa);
				
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(10, 480, 828, 2);
				add(separator_1);
				
				JButton jbtHienThiDuLieu = new JButton("Hiển thị dữ liệu");
				jbtHienThiDuLieu.setForeground(new Color(0, 0, 0));
				jbtHienThiDuLieu.setBackground(new Color(175, 238, 238));
				jbtHienThiDuLieu.setFont(new Font("Tahoma", Font.BOLD, 17));
				jbtHienThiDuLieu.setBounds(428, 278, 171, 32);
				jbtHienThiDuLieu.addActionListener(action);
				add(jbtHienThiDuLieu);
				

	}
    
	// 
	public void xoaForm() {
		textFieldMaHoaDon.setText("");
		textFieldMaPhong.setText("");
		textFieldNgayThanhToan.setText("");
		textFieldTienDichVu.setText("");
		textFieldTienDien.setText("");
		textFieldTienNuoc.setText("");
		textFieldTienPhong.setText("");
		textFieldTongTien.setText("");
	}
 
	// Thêm hóa đơn vào table
	public void themHoaDonVaoTable(HoaDon hd) {
		DefaultTableModel model_table = (DefaultTableModel) tableDanhSachHoaDon.getModel();
		model_table.addRow(new Object[] {hd.getMaHoaDon(), hd.getMaPhong(), hd.getNgayThanhToan(), hd.getTienPhong(), hd.getTienDien(),
				hd.getTienNuoc(), hd.getTienDV()});
    }

	// Cập nhật Hóa đơn đơn vào table
	public void capNhatHoaDonVaoTable(HoaDon hd) {
		DefaultTableModel model_table = (DefaultTableModel) tableDanhSachHoaDon.getModel();
	    // Kiểm tra xem hóa đơn có tồn tại trong bảng hay không
	    boolean hoaDonTonTai = false;
	    int soLuongDong = model_table.getRowCount();
	    for (int i = 0; i < soLuongDong; i++) {
	        String id = model_table.getValueAt(i, 0) + "";
	        if (id.equals(hd.getMaHoaDon())) {
	            // Cập nhật thông tin của hóa đơn trong bảng
	            model_table.setValueAt(hd.getMaHoaDon() + "", i, 0);
				model_table.setValueAt(hd.getMaPhong()+"", i, 1);
				model_table.setValueAt(hd.getNgayThanhToan() + "", i, 2);
				model_table.setValueAt(hd.getTienPhong(), i, 3);
				model_table.setValueAt(hd.getTienDien(), i, 4);
				model_table.setValueAt(hd.getTienNuoc(), i, 5);
				model_table.setValueAt(hd.getTienDV(), i, 6);
	            hoaDonTonTai = true;
	            break;
	        }
	    }
	    // Nếu hóa đơn không tồn tại trong bảng, thêm vào bảng
	    if (!hoaDonTonTai) {
	        themHoaDonVaoTable(hd);
	    }
		
	}
	// get hóa đơn đang chọn
	public HoaDon getHoaDonDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) tableDanhSachHoaDon.getModel();
		int i_row = tableDanhSachHoaDon.getSelectedRow();
		String maHoaDon = model_table.getValueAt(i_row, 0) + "";
		String maPhong = model_table.getValueAt(i_row, 1) + "";
		String ngayThanhToan = model_table.getValueAt(i_row, 2)+"";
		Float tienPhong = Float.valueOf(model_table.getValueAt(i_row, 3)+"");
		Float tienDien = Float.valueOf(model_table.getValueAt(i_row, 4)+"");
		Float tienNuoc = Float.valueOf(model_table.getValueAt(i_row, 5)+"");
		Float tienDV = Float.valueOf(model_table.getValueAt(i_row, 6)+"");

		HoaDon hd = new HoaDon(maHoaDon, maPhong, ngayThanhToan ,tienPhong, tienDien, tienNuoc, tienDV);
		return hd;
	}
	// Hiển thị thong tin hóa đơn đang chọn
	public void hienThiThongTinHoaDonDangChon() {
		HoaDon hd = getHoaDonDangChon();
		textFieldMaHoaDon.setText(hd.getMaHoaDon()+"");
		textFieldMaPhong.setText(hd.getMaPhong()+"");
		textFieldNgayThanhToan.setText(hd.getNgayThanhToan()+"");
		textFieldTienPhong.setText(hd.getTienPhong()+"");
		textFieldTienDien.setText(hd.getTienDien()+"");
		textFieldTienNuoc.setText(hd.getTienNuoc()+"");
		textFieldTienDichVu.setText(hd.getTienDV()+"");
		
	}
   
	// hiển thị dữ liệu hóa đơn từ cơ sở dữ liệu
	public void hienThiDuLieu() {
        DefaultTableModel model = (DefaultTableModel) tableDanhSachHoaDon.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng trong bảng

        HoaDonSQL hoaDonSQL = new HoaDonSQL();
        List<HoaDon> danhSachHoaDon = hoaDonSQL.getAllHoaDonSQL();
        for (HoaDon hd : danhSachHoaDon) {
            model.addRow(new Object[] {hd.getMaHoaDon(), hd.getMaPhong(), hd.getNgayThanhToan(), hd.getTienPhong(), hd.getTienDien(),
    				hd.getTienNuoc(), hd.getTienDV()});
        }
    }
	
	
	// xóa đi hóa đơn được chọn
	public void xoaHoaDonDuocChon() {
        int selectedRow = tableDanhSachHoaDon.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) tableDanhSachHoaDon.getModel();
            String maHD = (String) model.getValueAt(selectedRow, 0);
            
            int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa HD này?");
            if (luaChon == JOptionPane.YES_OPTION) {
            	HoaDonSQL hoaDonSQL = new HoaDonSQL();
                hoaDonSQL.xoaHoaDonTheoMaSQL(maHD);
                model.removeRow(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.");
        }
    }
	// tìm hóa đơn theo mã
	public void timHoaDonTheoMa() {
		String maHoaDonTK = textFieldTimHoaDonTheoMa.getText();
        if (!maHoaDonTK.isEmpty()) {
        	 HoaDonSQL hoaDonSQL = new HoaDonSQL();
            List<HoaDon> danhSachHoaDon = hoaDonSQL.timHoaDonTheoMaSQL(maHoaDonTK);
            if (!danhSachHoaDon.isEmpty()) {
                // Xóa dữ liệu cũ trong bảng
                DefaultTableModel model = (DefaultTableModel) tableDanhSachHoaDon.getModel();
                model.setRowCount(0);
                // Thêm dữ liệu mới từ kết quả tìm kiếm
                for (HoaDon hd : danhSachHoaDon) {
                    model.addRow(new Object[] {hd.getMaHoaDon(), hd.getMaPhong(), hd.getNgayThanhToan(), hd.getTienPhong(), hd.getTienDien(),
            				hd.getTienNuoc(), hd.getTienDV()});
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn có mã " + maHoaDonTK);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hóa đơn để tìm kiếm.");
        }
	}
	// tính tổng tiền của 1 hóa đơn
	public void tongTienCuaKhachHangDangChon() {
	    try {
	        HoaDon hoaDon = getHoaDonDangChon();
	        float tienPhong = hoaDon.getTienPhong();
	        float tienDien = hoaDon.getTienDien();
	        float tienNuoc = hoaDon.getTienNuoc();
	        float tienDichVu = hoaDon.getTienDV();
	        float tongTien = tienPhong + tienDien + tienNuoc + tienDichVu;
	        textFieldTongTien.setText(String.valueOf(tongTien));
	    } catch (Exception e) {
	        // Xử lý nếu có lỗi xảy ra
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn để tính tổng tiền.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	// thêm hoặc cập nhật hóa đơn
		public void thucHienCapNhatHoaDon() {
			String maPhong = textFieldMaPhong.getText();
		    List<Phong> danhSachPhong = new PhongSQL().getAllMaPhongSQL();
		    boolean phongTonTai = false;
		    for (Phong phong : danhSachPhong) {
		        if (phong.getMaPhong().equals(maPhong)) {
		            phongTonTai = true;
		            break;
		        }
		    }
		    if (!phongTonTai) {
		        JOptionPane.showMessageDialog(this, "Mã phòng không tồn tại trong cơ sở dữ liệu. Vui lòng nhập lại.", "Thông báo", JOptionPane.WARNING_MESSAGE);
		        return;
		    }
	        try {
	        	String maHoaDon = textFieldMaHoaDon.getText();
	    		maPhong = textFieldMaPhong.getText();
	    		String ngayThanhToan= textFieldNgayThanhToan.getText();
	    		float tienPhong=Float.valueOf(textFieldTienPhong.getText());		
	    		float tienDien=Float.valueOf(textFieldTienDien.getText());
	    		float tienNuoc=Float.valueOf(textFieldTienNuoc.getText());
	    		float tienDV=Float.valueOf(textFieldTienDichVu.getText());

	    		HoaDon hd = new HoaDon(maHoaDon, maPhong, ngayThanhToan, tienPhong, tienDien, tienNuoc, tienDV);
	    		HoaDonSQL hoaDonSQL = new HoaDonSQL();
	            
	            // Kiểm tra xem khách hàng đã tồn tại trong cơ sở dữ liệu hay chưa
	            if (hoaDonSQL.kiemTraTonTaiSQL(hd)) {
	                // Nếu tồn tại, cập nhật thông tin khách hàng trong cơ sở dữ liệu
	               hoaDonSQL.capNhatHoaDonSQL(hd);
	                capNhatHoaDonVaoTable(hd);
	            } else {
	                // Nếu không tồn tại, thêm khách hàng mới vào cơ sở dữ liệu
	                hoaDonSQL.themHoaDonSQL(hd);;
	                themHoaDonVaoTable(hd);
	            }
	            JOptionPane.showMessageDialog(this, "Cập nhật khách hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        } catch (Exception e) {
	             JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi cập nhật khách hàng:\n" + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
	        }
	    }

		

}