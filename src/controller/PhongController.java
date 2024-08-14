package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.QuanLiPhongView;

public class PhongController implements ActionListener {
	public QuanLiPhongView quanLiPhongView;
	
	public PhongController(QuanLiPhongView quanLiPhongView) {
		this.quanLiPhongView = quanLiPhongView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
				
		if(cm.equals("Cập nhật phòng trọ")) 
			quanLiPhongView.thucHienThemHoacCapNhatPhong();;
		 
        if(cm.equals("Xóa form"))
        	quanLiPhongView.xoaFrom();
        
		if(cm.equals("Xóa phòng trọ")) 
			quanLiPhongView.xoaPhongDuocChon();
		
		if(cm.equals("Tìm")) 
			quanLiPhongView.timPhongTheoMa();;
		
		if(cm.equals("Hiển thị dữ liệu")) 
			quanLiPhongView.hienThiDuLieu();
		
	}

}