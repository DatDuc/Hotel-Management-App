package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
import entity.TaiKhoan;

public class GUIThietLapMatKhau extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private JLabel lblTenDangNhap;
	private JTextField txtTenDangNhap;
	private JLabel lblMatKhau;
	private JPasswordField txtMatKhau;
	private JLabel lblMatKhau2;
	private JPasswordField txtMatKhau2;
	private JButton btnDangKy;
	private JButton btnThoat;
	private JButton btnNhamMat;
	private JButton btnNhamMat2;
	private JButton btnMoMat;
	private JButton btnMoMat2;
	private QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
	public GUIThietLapMatKhau(String maNhanVien) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\image\\hotel.png"));
		setType(Type.POPUP);
		setTitle("TẠO TÀI KHOẢN NHÂN VIÊN");
		setSize(400, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel pNorth = new JPanel(); 
		Box bMain ,b;
		add(bMain = Box.createVerticalBox());
		pNorth.add(lblTitle = new JLabel("TẠO TÀI KHOẢN"));
		bMain.add(pNorth);
		lblTitle.setFont(new Font("SansSerif",Font.BOLD, 30));
		lblTitle.setForeground(new Color(0xFFAA00));
		bMain.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(40));
		b.add(lblTenDangNhap = new JLabel("Tên đăng nhập: "));
		b.add(txtTenDangNhap = new JTextField());
		b.add(Box.createHorizontalStrut(50));
		bMain.add(Box.createVerticalStrut(10));
		bMain.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(40));
		b.add(lblMatKhau = new JLabel("Mật khẩu: "));
		b.add(txtMatKhau= new JPasswordField());
		txtMatKhau.setText("Nhập mật khẩu");
		txtMatKhau.setForeground(new Color(0xFFAA00));
		txtMatKhau.setEchoChar((char) 0);
		txtMatKhau.setText("Nhập mật khẩu");
		txtMatKhau.addFocusListener(new FocusListener() {
		    @SuppressWarnings("deprecation")
			@Override
		    public void focusGained(FocusEvent e) {
		    	if(txtMatKhau.getText().equals("Nhập mật khẩu")) {
		    		txtMatKhau.setText("");
		    		txtMatKhau.setEchoChar('*');
		    	}
		    }
		    @SuppressWarnings("deprecation")
			@Override
		    public void focusLost(FocusEvent e) {
		    	if(txtMatKhau.getText().isEmpty()) {
					txtMatKhau.setEchoChar((char) 0);
					txtMatKhau.setText("Nhập mật khẩu");
		    	}
		    }
		    });
		b.add(Box.createHorizontalStrut(2));
		b.add(btnNhamMat = new JButton(new ImageIcon(".\\image\\eyesclose.png")));
		b.add(btnMoMat = new JButton(new ImageIcon(".\\image\\eyesopen.png")));
		b.add(Box.createHorizontalStrut(18));
		btnNhamMat.setMaximumSize(new Dimension(10, 30));
		b.add(Box.createHorizontalStrut(10));
		bMain.add(Box.createVerticalStrut(10));
		bMain.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(40));
		b.add(lblMatKhau2 = new JLabel("Nhập lại mật khẩu: "));
		b.add(txtMatKhau2= new JPasswordField());
		txtMatKhau2.setText("Nhập lại mật khẩu");
		txtMatKhau2.setEchoChar((char)0);
		txtMatKhau2.setForeground(new Color(0xFFAA00));
		txtMatKhau2.addFocusListener(new FocusListener() {
		    @SuppressWarnings("deprecation")
			@Override
		    public void focusGained(FocusEvent e) {
		    	if(txtMatKhau2.getText().equals("Nhập lại mật khẩu")) {
			    	txtMatKhau2.setText("");				
			    	txtMatKhau2.setEchoChar('*');
		    	}
		    }
		    @SuppressWarnings("deprecation")
			@Override
		    public void focusLost(FocusEvent e) {
		    	if(txtMatKhau2.getText().isEmpty()) {
			    	txtMatKhau2.setText("Nhập lại mật khẩu");
			    	txtMatKhau2.setEchoChar((char) 0);
		    	}
		    }
		    });
		b.add(Box.createHorizontalStrut(2));
		b.add(btnNhamMat2 = new JButton(new ImageIcon(".\\image\\eyesclose.png")));
		b.add(btnMoMat2 = new JButton(new ImageIcon(".\\image\\eyesopen.png")));
		b.add(Box.createHorizontalStrut(18));
		btnNhamMat2.setMaximumSize(new Dimension(20, 30));
		btnNhamMat.setFocusPainted(false);
		btnNhamMat.setBorder(BorderFactory.createEmptyBorder());
		btnNhamMat.setContentAreaFilled(false);
		btnMoMat.setFocusPainted(false);
		btnMoMat.setBorder(BorderFactory.createEmptyBorder());
		btnMoMat.setContentAreaFilled(false);
		btnNhamMat2.setFocusPainted(false);
		btnNhamMat2.setBorder(BorderFactory.createEmptyBorder());
		btnNhamMat2.setContentAreaFilled(false);
		btnMoMat2.setFocusPainted(false);
		btnMoMat2.setBorder(BorderFactory.createEmptyBorder());
		btnMoMat2.setContentAreaFilled(false);
		b.add(Box.createHorizontalStrut(10));
		bMain.add(Box.createVerticalStrut(20));
		bMain.add(b = Box.createHorizontalBox());
		b.add(btnDangKy = new JButton("Tạo tài khoản", new ImageIcon(".\\image\\signup32.png")));
		b.add(Box.createHorizontalStrut(30));
		b.add(btnThoat = new JButton("Thoát", new ImageIcon(".\\image\\exit32.png")));
		lblTenDangNhap.setPreferredSize(lblMatKhau2.getPreferredSize());
		lblMatKhau.setPreferredSize(lblMatKhau2.getPreferredSize());
		btnThoat.setMaximumSize(btnDangKy.getMaximumSize());
		txtTenDangNhap.setEditable(false);
		txtTenDangNhap.setText(maNhanVien);
		txtTenDangNhap.setPreferredSize(txtMatKhau.getPreferredSize());
		txtTenDangNhap.setMaximumSize(txtMatKhau.getMaximumSize());
		txtTenDangNhap.setForeground(Color.blue);
		txtTenDangNhap.setBackground(Color.lightGray);
		btnMoMat.setVisible(false);
		btnMoMat2.setVisible(false);
		btnNhamMat.addActionListener(this);
		btnMoMat.addActionListener(this);
		btnNhamMat2.addActionListener(this);
		btnMoMat2.addActionListener(this);
		btnThoat.addActionListener(this);
		btnDangKy.addActionListener(this);
		setVisible(true);
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//			new GUIThietLapMatKhau("NV_001");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnNhamMat)) {
			txtMatKhau.setEchoChar((char)0);
			btnNhamMat.setVisible(false);
			btnMoMat.setVisible(true);
		}else if(o.equals(btnMoMat)) {
			txtMatKhau.setEchoChar('*');
			btnMoMat.setVisible(false);
			btnNhamMat.setVisible(true);
		}else if(o.equals(btnNhamMat2)) {
			txtMatKhau2.setEchoChar((char)0);
			btnNhamMat2.setVisible(false);
			btnMoMat2.setVisible(true);
		}else if(o.equals(btnMoMat2)) {
			txtMatKhau2.setEchoChar('*');
			btnMoMat2.setVisible(false);
			btnNhamMat2.setVisible(true);
		}else if (o.equals(btnThoat)) {
			this.dispose();
		}else if(o.equals(btnDangKy)) {
			thietLapMatKhau();
		}
	}
	@SuppressWarnings("deprecation")
	public void thietLapMatKhau() {
		if(txtMatKhau.getText().equalsIgnoreCase("Nhập mật khẩu")) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không được trống");
			txtMatKhau.requestFocus();
		}else {
			if(!txtMatKhau.getText().matches("^[a-zA-Z0-9]{8,}")) {
				JOptionPane.showMessageDialog(this, "Mật khẩu phải ít nhất 8 ký tự và không chứa ký tự đặc biệt");
				txtMatKhau.requestFocus();
				txtMatKhau.setText("");
			}else {
				if(txtMatKhau2.getText().equalsIgnoreCase("Nhập lại mật khẩu")) {
					JOptionPane.showMessageDialog(this, "Nhập lại mật khẩu không được trống");
					txtMatKhau2.requestFocus();
				}else {
					if(txtMatKhau.getText().equals(txtMatKhau2.getText())) {
						NhanVien nv = qlnv.layNhanVienTheoMa(txtTenDangNhap.getText());
						TaiKhoan tk = new TaiKhoan(txtTenDangNhap.getText(),txtMatKhau.getText(),nv);
						if(qlnv.themTaiKhoan(tk)) {
							JOptionPane.showMessageDialog(this, "Tạo tài khoản nhân viên "+txtTenDangNhap.getText()+" thành công");
							this.dispose();
						}else {
							JOptionPane.showMessageDialog(this, "Tạo tài khoản nhân viên "+txtTenDangNhap.getText()+" thành công");
						}
					}else {
						JOptionPane.showMessageDialog(this, "Nhập lại mật khẩu không trùng khớp");
						txtMatKhau2.requestFocus();
						txtMatKhau2.setText("");
					}
				}
			}
		}
	}
}
