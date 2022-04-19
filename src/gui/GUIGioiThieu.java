package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class GUIGioiThieu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnNext;
	private JLabel lblGiangVien;
	public GUIGioiThieu() {
		setType(Type.POPUP);
		Dimension manHinh = Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("QUẢN LÝ KHÁCH SẠN");
		int rong = manHinh.width;
		int cao = manHinh.height;
		setSize(rong, cao);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\image\\hotel.png"));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		new JPanel();
		//		p.add(b = Box.createHorizontalBox());
		ImageIcon hinh = new ImageIcon(".\\image\\introkhachsan.png");
		JLabel lblHinh = new JLabel(hinh);
		add(lblHinh);
		btnNext = new JButton(null,new ImageIcon(".\\image\\next.png"));
		
		btnNext.setBounds(1400,10,150,150);
		btnNext.setBackground(Color.WHITE);
		lblHinh.add(btnNext);
		lblHinh.add(lblGiangVien = new JLabel(new ImageIcon(".\\image\\giangvien.png")));
		lblGiangVien.setBounds(10,600,1500,200);
		lblGiangVien.setFont(new Font("serif",Font.PLAIN,30));
		btnNext.setBorder(BorderFactory.createEmptyBorder());
		btnNext.setFocusPainted(false);
		btnNext.setContentAreaFilled(false);
		btnNext.addActionListener(this);
		setVisible(true);
		//int i =0;
		while(true) {
			lblGiangVien.setVisible(true);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
			lblGiangVien.setVisible(false);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
			new GUIGioiThieu();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnNext)) {
			try {
				new GUIDangNhap();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
		}
	}
}
