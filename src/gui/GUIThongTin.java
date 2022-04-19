package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class GUIThongTin extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GUIThongTin(Frame frameCha) {
		setType(Type.POPUP);
		int rong = Toolkit.getDefaultToolkit().getScreenSize().width;
		int cao = Toolkit.getDefaultToolkit().getScreenSize().height;
		setTitle("THÔNG TIN ỨNG DỤNG");
		setSize(rong/2, cao/3);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\image\\hotel.png"));
		Box bMain,b12,b1,b2,b;
		ImageIcon hotel = new ImageIcon(".\\image\\everestBill.png");
		add(bMain = Box.createVerticalBox());
		bMain.add(b12 = Box.createHorizontalBox());
		b12.add(b1 = Box.createVerticalBox());
		b1.add(b = Box.createHorizontalBox());
		JLabel lblHinh,lblKhachSan = null;
		b.add(lblHinh = new JLabel(),BorderLayout.WEST);
		Image img = hotel.getImage();
		Image imgScale = img.getScaledInstance(250,(cao/4)+20,Image.SCALE_SMOOTH);
		ImageIcon hotelImg = new ImageIcon(imgScale);
		lblHinh.setIcon(hotelImg);
		b12.add(b2 = Box.createVerticalBox());
		b2.add(b = Box.createHorizontalBox());
		lblKhachSan = new JLabel("<html>"
				+ "<center>"
				+ "Giảng viên : Trần Thị Anh Thi <br/>"
				+ "<div style = \"color:red\">Thành viên trong nhóm </div>"
				+ "Phan Văn Thông - 18043151 <br/>"
				+ "Lê Văn Toàn - 18075801 <br/>"
				+ "Đỗ Đạt Đức - 18040671 <br/>"
				+ "Trần Đông Hoàng - 18081491<br/>"
				+ "<br/>"
				+ "</center>"
				+ "<left>"
				+ "Ứng dụng đặt phòng khách sạn <br/>"
				+ "Version : 1.0 (11-2020)<br/>"
				+ "<br/>"
				+ "Hệ thống giúp quản lý thông tin khách hàng,<br/>"
				+ " nhân viên, dịch vụ, phòng tốt hơn.<br/>"
				+ "Quan trọng nhất là giúp người dùng đặt phòng,<br/>"
				+ " thanh toán cho khách hàng linh hoạt,<br/>"
				+ " nhanh hơn. Có thể thông kê doanh thu một cách<br/>"
				+ " chính xác và đầy đủ theo ngày tháng năm<br/>"
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ "</left>"
				+ "</html>");
		lblKhachSan.setFont(new Font("Time new Romans",Font.BOLD,17));
		JScrollPane scroll = new JScrollPane(lblKhachSan,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		b.add(scroll);
		setVisible(true);
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
