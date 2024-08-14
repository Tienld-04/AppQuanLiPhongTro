package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.QuanLiHoaDonView;

public class HoaDonController implements ActionListener{
     public QuanLiHoaDonView qlHoaDonView;
     
	public HoaDonController(QuanLiHoaDonView qlHoaDonView) {
		this.qlHoaDonView = qlHoaDonView;
	}

	@Override
	
	public void actionPerformed(ActionEvent e) {
		
		String cm=e.getActionCommand();
		//JOptionPane.showMessageDialog(qlHoaDonView, "Bạn vừa nhấn vào : "+ cm);
		if(cm.equals("Cập nhật hóa đơn"))
			qlHoaDonView.thucHienCapNhatHoaDon();;
		if(cm.equals("Xóa hóa đơn"))
			qlHoaDonView.xoaHoaDonDuocChon();;
		if(cm.equals("Xóa form"))
			qlHoaDonView.xoaForm();
		if(cm.equals("Tìm"))
			qlHoaDonView.timHoaDonTheoMa();;
		if(cm.equals("Hiển thị dữ liệu"))
			qlHoaDonView.hienThiDuLieu();
		if(cm.equals("Tổng tiền")) {
			qlHoaDonView.tongTienCuaKhachHangDangChon();
		}
	}
}