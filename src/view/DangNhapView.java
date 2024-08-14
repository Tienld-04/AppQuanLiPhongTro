package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DangNhapView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
 
	
	public DangNhapView() {
		setFont(new Font("Dialog", Font.BOLD, 8));
		setBackground(new Color(200, 200, 200));
		setTitle("App Quản Lý Thuê Trọ Siêu Cấp VIP Pro !!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 296);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		   
		JLabel lblNewLabel_3 = new JLabel("App Quản Lý Thuê Trọ");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 22));
		lblNewLabel_3.setBounds(83, 35, 292, 41);
		contentPane.add(lblNewLabel_3);
		
		JButton btnDangNhap = new JButton("Đăng nhập App");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View view = new View();
				DangNhapView.this.dispose();
			}
		});
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDangNhap.setBounds(125, 116, 187, 41);
		contentPane.add(btnDangNhap);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(54, 23, 368, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DangNhapView.class.getResource("/Image/222.jpg")));
		lblNewLabel.setBounds(0, 0, 444, 259);
		contentPane.add(lblNewLabel);
		setVisible(true);
	}
}
