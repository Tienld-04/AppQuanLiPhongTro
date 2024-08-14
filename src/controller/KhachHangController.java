package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.QuanLiKhachHangView;

public class KhachHangController implements ActionListener {
       public QuanLiKhachHangView QLKhachHangview;
       
       public KhachHangController(QuanLiKhachHangView qlKhachHangView){
    	   this.QLKhachHangview = qlKhachHangView;
       }
      
			@Override
	   public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cm=e.getActionCommand();
				if(cm.equals("Cập nhật khách thuê")) {
					try {
						QLKhachHangview.thucHienCapNhatKhachHang();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				if(cm.equals("Xóa khách thuê"))
					QLKhachHangview.xoaKhachHangDuocChon();;
				if(cm.equals("Tìm"))
					QLKhachHangview.timKhachHangTheoMa();
				if(cm.equals("Hiển thị dữ liệu"))
					QLKhachHangview.hienThiDuLieu();
				if(cm.equals("Xóa form"))
					QLKhachHangview.xoaForm();
				
			}
			
}
