package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class GUITaiGioiThieu extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8854187428719129015L;
	public JLabel lblSo;
	public JProgressBar process;
	private JLabel lblPhanTram;
	public GUITaiGioiThieu() {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\image\\hotel.png"));
		
		setTitle("QUẢN LÝ KHÁCH SẠN");
		setSize(500,397);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel lblWelcome = new JLabel(new ImageIcon(".\\image\\everest.png"));
		lblWelcome.setForeground(new Color(0xFFAA00));
		JPanel p = new JPanel();
		Box b,b1;
		p.add(b = Box.createVerticalBox(),BorderLayout.CENTER);
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblWelcome);
		b.add(b1 = Box.createHorizontalBox());
		b1.add(lblSo = new JLabel("0"));
		b1.add(lblPhanTram = new JLabel("%"));
		lblSo.setFont(new Font("SansSerif",Font.PLAIN,40));
		lblWelcome.setFont(new Font("Sanserif",Font.BOLD,30));
		lblPhanTram.setFont(new Font("Sanserif",Font.PLAIN,40));
		b.add(Box.createVerticalStrut(20));
		b.add(b1 = Box.createHorizontalBox());
		b1.add(process = new JProgressBar());
		process.setBackground(new Color(0xFFAA00));
		process.setForeground(new Color(254, 82, 42));
		process.setValue(0);
		lblWelcome.add(process);
		process.setBounds(40, 330, 400, 20);
		add(lblWelcome);
		p.setBackground(Color.decode("#ffff82"));
		setUndecorated(true);
		setVisible(true);
		
	}
//	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//			new GUITaiGioiThieu();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
