package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Database.PhongSQL;
import controller.PhongController;
import model.Phong;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class QuanLiPhongView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldMaPhong;
	private JTextField textFieldTang;
	private JTextField textFieldGiaThue;
	private JTextField textFieldSoLuongToiDa;
	private JTextField textFieldTrangThaiPhong;
	private JTable tableDanhSachPhong; 
	private JTextField textFieldTimPhongTheoMa;
	
	public QuanLiPhongView() {
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		ActionListener action=new PhongController(this);
		JLabel lblNewLabel = new JLabel("Quản lí phòng");
		lblNewLabel.setBackground(new Color(51, 0, 51));
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(347, 0, 171, 38);
		add(lblNewLabel);
		
		JPanel jpnTTCN = new JPanel();
		jpnTTCN.setBackground(new Color(192, 192, 192));
		jpnTTCN.setBounds(10, 0, 836, 218);
		add(jpnTTCN);
		jpnTTCN.setLayout(null);
		
		JPanel jpnCN = new JPanel();
		jpnCN.setBackground(new Color(205, 205, 205));
		jpnCN.setBounds(549, 40, 298, 178);
		jpnTTCN.add(jpnCN);
		jpnCN.setLayout(null);
		
		JButton jbtThemPhongTro = new JButton("Cập nhật phòng trọ");
		jbtThemPhongTro.setBackground(new Color(176, 224, 230));
		jbtThemPhongTro.setForeground(new Color(0, 0, 153));
		jbtThemPhongTro.setFont(new Font("Tahoma", Font.BOLD, 17));
		jbtThemPhongTro.setBounds(21, 21, 253, 40);
		jbtThemPhongTro.addActionListener(action);
		jpnCN.add(jbtThemPhongTro);
		
		JButton jbtXoaPhongTro = new JButton("Xóa phòng trọ");
		jbtXoaPhongTro.setForeground(new Color(0, 0, 153));
		jbtXoaPhongTro.setFont(new Font("Tahoma", Font.BOLD, 17));
		jbtXoaPhongTro.setBackground(new Color(176, 224, 230));
		jbtXoaPhongTro.setBounds(21, 71, 253, 35);
		jbtXoaPhongTro.addActionListener(action);
		jpnCN.add(jbtXoaPhongTro);
		
		JButton jbtXoaform = new JButton("Xóa form");
		jbtXoaform.setBounds(21, 116, 253, 35);
		jpnCN.add(jbtXoaform);
		jbtXoaform.setForeground(new Color(0, 0, 153));
		jbtXoaform.setFont(new Font("Tahoma", Font.BOLD, 17));
		jbtXoaform.setBackground(new Color(176, 224, 230));
		jbtXoaform.addActionListener(action);
		
		JPanel jpnTT = new JPanel();
		jpnTT.setBounds(10, 40, 539, 178);
		jpnTTCN.add(jpnTT);
		jpnTT.setForeground(new Color(102, 204, 255));
		jpnTT.setBackground(new Color(176, 224, 230));
		jpnTT.setLayout(null);
		
		textFieldMaPhong = new JTextField();
		textFieldMaPhong.setBounds(120, 10, 111, 24);
		jpnTT.add(textFieldMaPhong);
		textFieldMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldMaPhong.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mã phòng");
		lblNewLabel_1.setBounds(0, 4, 101, 38);
		jpnTT.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_3 = new JLabel("Tầng");
		lblNewLabel_3.setBounds(0, 52, 71, 24);
		jpnTT.add(lblNewLabel_3); 
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_8 = new JLabel("Giá thuê");
		lblNewLabel_8.setBounds(0, 97, 71, 16);
		jpnTT.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		textFieldGiaThue = new JTextField();
		textFieldGiaThue.setBounds(120, 93, 111, 24);
		jpnTT.add(textFieldGiaThue);
		textFieldGiaThue.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldGiaThue.setColumns(10);
		
		textFieldTang = new JTextField();
		textFieldTang.setBounds(120, 52, 111, 24);
		jpnTT.add(textFieldTang);
		textFieldTang.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldTang.setColumns(10);
		
		textFieldSoLuongToiDa = new JTextField();
		textFieldSoLuongToiDa.setBounds(407, 10, 114, 24);
		jpnTT.add(textFieldSoLuongToiDa);
		textFieldSoLuongToiDa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldSoLuongToiDa.setColumns(10);
		
		textFieldTrangThaiPhong = new JTextField();
		textFieldTrangThaiPhong.setBounds(407, 52, 114, 24);
		jpnTT.add(textFieldTrangThaiPhong);
		textFieldTrangThaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldTrangThaiPhong.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Trạng thái");
		lblNewLabel_7.setBounds(241, 52, 101, 24);
		jpnTT.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_6 = new JLabel("Số lượng người tối đa");
		lblNewLabel_6.setBounds(241, 10, 174, 24);
		jpnTT.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		tableDanhSachPhong=new JTable();
		tableDanhSachPhong.addMouseListener(new MouseAdapter(){
		        @Override
		        public void mouseClicked(MouseEvent e) {
		            // Lấy chỉ số của dòng được nhấp
		            int selectedRow = tableDanhSachPhong.getSelectedRow();
		            // Kiểm tra xem có dòng được chọn không
		            if (selectedRow != -1) {
		                // Hiển thị thông tin của dòng được chọn
		                hienThiThongTinPhongDangChon();
		            }
		        }
		});
		tableDanhSachPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableDanhSachPhong.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 ph\u00F2ng", "T\u1EA7ng", "Gi\u00E1 thu\u00EA", "S\u1ED1 l\u01B0\u1EE3ng ng\u01B0\u1EDDi t\u1ED1i \u0111a", "Tr\u1EA1ng Th\u00E1i"
			}
		));
		JScrollPane scrollPane = new JScrollPane(tableDanhSachPhong);
		scrollPane.setBounds(10, 302, 828, 138);
		add(scrollPane);
		//layDuLieuTuSQlVaoTable();
		
		JLabel lblNewLabel_2 = new JLabel("Mã phòng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(10, 240, 89, 38);
		add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 228, 838, 2);
		add(separator);
		
		textFieldTimPhongTheoMa = new JTextField();
		textFieldTimPhongTheoMa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldTimPhongTheoMa.setBounds(105, 240, 171, 32);
		add(textFieldTimPhongTheoMa);
		textFieldTimPhongTheoMa.setColumns(10);
		
		JButton jbtTimMaPhong = new JButton("Tìm");
		jbtTimMaPhong.setFont(new Font("Tahoma", Font.BOLD, 17));
		jbtTimMaPhong.setForeground(new Color(0, 0, 0));
		jbtTimMaPhong.setBackground(new Color(175, 238, 238));
		jbtTimMaPhong.setBounds(300, 240, 95, 33);
		jbtTimMaPhong.addActionListener(action);
		add(jbtTimMaPhong);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 461, 828, 2);
		add(separator_1);
		
		JButton jbtHuyTimKiem = new JButton("Hiển thị dữ liệu");
		jbtHuyTimKiem.setFont(new Font("Tahoma", Font.BOLD, 17));
		jbtHuyTimKiem.setBounds(407, 240, 171, 32);
		jbtHuyTimKiem.addActionListener(action);
		add(jbtHuyTimKiem);
		
        setVisible(true);
		}
		// xóa form
	  public void xoaFrom() {
			textFieldMaPhong.setText("");
			textFieldTang.setText("");
			textFieldGiaThue.setText("");
			textFieldSoLuongToiDa.setText("");
			textFieldTrangThaiPhong.setText("");
		}
	    // thêm phòng vào table
	    public void themPhongVaoTable(Phong p) {
	    	DefaultTableModel model = (DefaultTableModel) tableDanhSachPhong.getModel();
	    	model.addRow(new Object[] {p.getMaPhong(), p.getTang(), p.getGiaPhong(), p.getSLNguoiMax(), p.getTrangThai()});
	    }

	    // cập nhật phòng trong table
	    public void capNhatPhongTable(Phong p) {
	    	DefaultTableModel model_table = (DefaultTableModel) tableDanhSachPhong.getModel();
	    	
	    	boolean phongTonTai = false;
	    	int soLuongDong = model_table.getRowCount();	    
	    		for(int i=0; i < soLuongDong; i++) {
	    			String id = model_table.getValueAt(i, 0)+"";
	    			if(id.equals(p.getMaPhong())) {
	    				model_table.setValueAt(p.getMaPhong()+"", i, 0);
	    				model_table.setValueAt(p.getTang(), i, 1);
	    				model_table.setValueAt(p.getGiaPhong(), i, 2);
	    				model_table.setValueAt(p.getSLNguoiMax(), i, 3);
	    				model_table.setValueAt(p.getTrangThai()+"", i, 4);
	    				phongTonTai = true;
	    				break;
	    			}
	    		}
	    		if (!phongTonTai) {
	    	        themPhongVaoTable(p);
	    	    }
	    	}
	    // get Phòng đang chọn trong table
	    public Phong getPhongDangChon() {
	    	DefaultTableModel model_table = (DefaultTableModel) tableDanhSachPhong.getModel();
	    	int i_row = tableDanhSachPhong.getSelectedRow();
	    	String maPhong = model_table.getValueAt(i_row, 0)+"";
	    	int tang = Integer.valueOf(model_table.getValueAt(i_row, 1) + "");
	    	float giaPhong = Float.valueOf(model_table.getValueAt(i_row, 2) + "");
	    	int slNguoiMax = Integer.valueOf(model_table.getValueAt(i_row, 3) + "");
	    	String  trangThai = model_table.getValueAt(i_row, 4)+"";
	    	Phong p = new Phong(maPhong, tang, giaPhong, slNguoiMax, trangThai);
	    	
	    	return p;
	    }
	    // Hiển thị thông tin phòng đã chọn trên jtextFild
	    public void hienThiThongTinPhongDangChon() {
			Phong p = getPhongDangChon();
			this.textFieldMaPhong.setText(p.getMaPhong()+ "");
			this.textFieldTang.setText(p.getTang()+ "");
			this.textFieldGiaThue.setText(p.getGiaPhong()+"");
			this.textFieldSoLuongToiDa.setText(p.getSLNguoiMax()+"");
			this.textFieldTrangThaiPhong.setText(p.getTrangThai()+"");
		}
	    

	 // hiển thị dl database
		public void hienThiDuLieu() {
	        DefaultTableModel tb_model = (DefaultTableModel) tableDanhSachPhong.getModel();
	        tb_model.setRowCount(0); // Xóa tất cả các dòng trong bảng
	        PhongSQL phongSQL=new PhongSQL();
	        List<Phong> danhSachPhong = phongSQL.getAllPhongSQL();
	        for (Phong p : danhSachPhong) {
	            tb_model.addRow(new Object[] {p.getMaPhong()+"", p.getTang(), p.getGiaPhong(), p.getSLNguoiMax(), p.getTrangThai()+""});
	        }
	    }
		// thêm hoặc Cập nhật phòng
		public void thucHienThemHoacCapNhatPhong() {	
			try {
				PhongSQL phongSQL=new PhongSQL();			
				String maPhong = textFieldMaPhong.getText();
				int tang = Integer.parseInt(textFieldTang.getText());
				float giaPhong = Float.parseFloat(textFieldGiaThue.getText());
				int soLuongNguoiMax = Integer.parseInt(textFieldSoLuongToiDa.getText());
				String trangThai = textFieldTrangThaiPhong.getText();
				Phong p = new Phong(maPhong, tang, giaPhong, soLuongNguoiMax, trangThai);
				// Kiểm tra xem phòng đã tồn tại trong cơ sở dữ liệu hay chưa
				if (phongSQL.kiemTraTonTaiSQL(p)) {
					// Nếu tồn tại, cập nhật thông tin phòng trong cơ sở dữ liệu
					phongSQL.capNhatPhongSQL(p);
					capNhatPhongTable(p);
				} else {
					// Nếu không tồn tại, thêm phòng mới vào cơ sở dữ liệu
					phongSQL.themPhongSQL(p);
					themPhongVaoTable(p);
				}
				 JOptionPane.showMessageDialog(this, "Cập nhật khách hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				 JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi cập nhật khách hàng:\n" + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		}
		// Xóa Phòng được chọn
		public void xoaPhongDuocChon() {
			int selectedRow = tableDanhSachPhong.getSelectedRow();
			if (selectedRow != -1) {
				DefaultTableModel model = (DefaultTableModel) tableDanhSachPhong.getModel();
				String maPh = (String) model.getValueAt(selectedRow, 0);

				int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa Phòng này?");
				if (luaChon == JOptionPane.YES_OPTION) {
					PhongSQL phongSQL = new PhongSQL();	
					phongSQL.xoaPhongTheoMaSQL(maPh);
					model.removeRow(selectedRow);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.");
			}
		}
		
		// Tìm Phòng theo mã phòng
		public void timPhongTheoMa() {
			String maPhongTK = textFieldTimPhongTheoMa.getText();
			if (!maPhongTK.isEmpty()) {
				PhongSQL phongSQL=new PhongSQL();	
				List<Phong> danhSachPhong = phongSQL.timPhongTheoMaSQL(maPhongTK);
				if (!danhSachPhong.isEmpty()) {
					// Xóa dữ liệu cũ trong bảng
					DefaultTableModel model = (DefaultTableModel) tableDanhSachPhong.getModel();
					model.setRowCount(0);
					// Thêm dữ liệu mới từ kết quả tìm kiếm
					for (Phong p : danhSachPhong) {
						model.addRow(new Object[] { p.getMaPhong(), p.getTang(), p.getGiaPhong(), p.getSLNguoiMax(), p.getTrangThai()});
					}
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy phòng có mã " + maPhongTK);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã phòng để tìm kiếm.");
			}
		}

}