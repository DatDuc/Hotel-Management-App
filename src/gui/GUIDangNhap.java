package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import dao.QuanLyNhanVien_DAO;
import entity.NhanVien;

public class GUIDangNhap extends JFrame implements ActionListener,KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMatKhau;
	private JPasswordField txtMatKhau;
	private JButton btnDangNhap;
	private JButton btnThoat;
	private JLabel lblTieuDe;
	private JLabel lblTenDangNhap;
	private JTextField txtTenDangNhap;
	private JButton btnNhamMat;
	private JButton btnMoMat;
	public static String ten;
	public static String ma;
	private QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();

	public GUIDangNhap() throws Exception {
		setType(Type.POPUP);
		setTitle("ĐĂNG NHẬP ỨNG DỤNG");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\image\\hotel.png"));
		setSize(400, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pNorth = new JPanel();
		pNorth.add(lblTieuDe = new JLabel("ĐĂNG NHẬP"));
		lblTieuDe.setForeground(new Color(0xFFAA00));
		add(pNorth, BorderLayout.NORTH);
		lblTieuDe.setFont(new Font("SansSerif", Font.BOLD, 20));

		Box bMain, b1;
		add(bMain = Box.createVerticalBox());
		bMain.add(Box.createVerticalStrut(10));
		bMain.add(b1 = Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(50));
		b1.add(lblTenDangNhap = new JLabel("Tên đăng nhập: "));
		b1.add(txtTenDangNhap = new JTextField("Nhập tên đăng nhập"));
		b1.add(Box.createHorizontalStrut(50));
		bMain.add(Box.createVerticalStrut(10));
		bMain.add(b1 = Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(50));
		b1.add(lblMatKhau = new JLabel("Mật khẩu: "));
		b1.add(txtMatKhau = new JPasswordField(""));
		txtTenDangNhap.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTenDangNhap.getText().equals("Nhập tên đăng nhập")) {
					txtTenDangNhap.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTenDangNhap.getText().isEmpty()) {
					txtTenDangNhap.setForeground(new Color(0xFFAA00));
					txtTenDangNhap.setText("Nhập tên đăng nhập");
				}
			}
		});
		b1.add(btnNhamMat = new JButton(new ImageIcon(".\\image\\eyesclose.png")));
		btnNhamMat.setFocusPainted(false);
		btnNhamMat.setContentAreaFilled(false);
		btnNhamMat.setBorder(BorderFactory.createEmptyBorder());
		b1.add(btnMoMat = new JButton(new ImageIcon(".\\image\\eyesopen.png")));
		btnMoMat.setFocusPainted(false);
		btnMoMat.setContentAreaFilled(false);
		btnMoMat.setBorder(BorderFactory.createEmptyBorder());
		txtMatKhau.setForeground(new Color(0xFFAA00));
		btnMoMat.setVisible(false);
		txtMatKhau.setEchoChar((char) 0);
		txtMatKhau.setText("Nhập mật khẩu");
		txtMatKhau.addFocusListener(new FocusListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if (txtMatKhau.getText().isEmpty()) {
					txtMatKhau.setEchoChar((char) 0);
					txtMatKhau.setText("Nhập mật khẩu");

				}
			}

			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if (txtMatKhau.getText().equals("Nhập mật khẩu")) {
					txtMatKhau.setText("");
					txtMatKhau.setEchoChar('*');
				}
			}
		});
		b1.add(Box.createHorizontalStrut(30));
		bMain.add(Box.createVerticalStrut(20));
		lblMatKhau.setPreferredSize(lblTenDangNhap.getPreferredSize());
		bMain.add(b1 = Box.createHorizontalBox());
		b1.add(btnDangNhap = new JButton("Đăng nhập", new ImageIcon(".\\image\\login32.png")));
		b1.add(Box.createHorizontalStrut(30));
		b1.add(btnThoat = new JButton("Thoát", new ImageIcon(".\\image\\exit32.png")));
		btnDangNhap.setMaximumSize(new Dimension(150, 40));
		bMain.add(Box.createVerticalStrut(10));
		btnThoat.setMaximumSize(btnDangNhap.getMaximumSize());
		btnMoMat.addActionListener(this);
		btnNhamMat.addActionListener(this);
		btnThoat.addActionListener(this);
		btnDangNhap.addActionListener(this);
		txtMatKhau.addKeyListener(this);
		txtTenDangNhap.addKeyListener(this);
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
			new GUIDangNhap();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnNhamMat)) {
			btnNhamMat.setVisible(false);
			btnMoMat.setVisible(true);
			txtMatKhau.setEchoChar((char) 0);
			txtMatKhau.requestFocus();
		} else if (o.equals(btnMoMat)) {
			btnMoMat.setVisible(false);
			btnNhamMat.setVisible(true);
			txtMatKhau.setEchoChar('*');
			txtMatKhau.requestFocus();
		} else if (o.equals(btnThoat)) {
			this.dispose();
		} else if (o.equals(btnThoat)) {
			this.dispose();
		} else if (o.equals(btnDangNhap)) {
			dangNhap();
		}
	}

	@SuppressWarnings("deprecation")
	public void dangNhap() {
		NhanVien nv = qlnv.layNhanVienTheoMa(txtTenDangNhap.getText());
		if(txtTenDangNhap.getText().length() > 0 && txtTenDangNhap.getText().equals("admin")) {
				if(txtMatKhau.getText().equals("123")) {
					try {
							QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
							ArrayList<NhanVien> dsNV = qlnv.timNhanVienTheoTen("Phan Văn Thông");
							for (NhanVien nhanVien : dsNV) {
								ma= nhanVien.getMaNhanVien();
							}
						UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
						new GUIMenu(1);
						this.dispose();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if(txtMatKhau.getText().equals("Nhập mật khẩu")) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu");
					txtMatKhau.requestFocus();
				}else {
					JOptionPane.showMessageDialog(this, "Mật khẩu không hợp lệ");
					txtMatKhau.requestFocus();
					txtMatKhau.setText("");
			}
		}else if(txtTenDangNhap.getText().equals("Nhập tên đăng nhập")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên đăng nhập");
		}else {
			String matKhau = qlnv.layMatKhau(txtTenDangNhap.getText());
			if(txtMatKhau.getText().equals(matKhau)) {
				try {
					ma = nv.getMaNhanVien();
					ten =  nv.getTenNhanVien();
					UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					new GUIMenuDanhChoNhanVien(ten);
					this.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
				}else {
					if(txtMatKhau.getText().equals("Nhập mật khẩu")) {
						JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu");
						txtMatKhau.requestFocus();
					}else {
						JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không hợp lệ");
						txtMatKhau.requestFocus();
						txtMatKhau.setText("");
			}
		}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			dangNhap();
		}
	}
}
