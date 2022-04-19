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

public class GUIDoiMatKhau extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private JLabel lblTenDangNhap;
	private JTextField txtTenDangNhap;
	private JLabel lblMatKhau;
	private JPasswordField txtMatKhau;
	private JLabel lblMatKhauMoi;
	private JPasswordField txtMatKhauMoi;
	private JButton btnDoiMatKhau;
	private JButton btnThoat;
	private JButton btnNhamMat;
	private JButton btnNhamMatMoi;
	private JButton btnMoMat;
	private JButton btnMoMatMoi;
	private QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
	public GUIDoiMatKhau(String maNhanVien) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\image\\hotel.png"));
		setType(Type.POPUP);
		setTitle("ĐỔI MẬT KHẨU");
		setSize(400, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel pNorth = new JPanel(); 
		Box bMain ,b;
		add(bMain = Box.createVerticalBox());
		pNorth.add(lblTitle = new JLabel("ĐỔI MẬT KHẨU"));
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
		b.add(lblMatKhau = new JLabel("Mật khẩu cũ: "));
		b.add(txtMatKhau= new JPasswordField());
		txtMatKhau.setText("Nhập mật khẩu cũ");
		txtMatKhau.setForeground(new Color(0xFFAA00));
		txtMatKhau.setEchoChar((char) 0);
		txtMatKhau.setText("Nhập mật khẩu cũ");
		txtMatKhau.addFocusListener(new FocusListener() {
		    @SuppressWarnings("deprecation")
			@Override
		    public void focusGained(FocusEvent e) {
		    	if(txtMatKhau.getText().equals("Nhập mật khẩu cũ")) {
		    		txtMatKhau.setText("");
		    		txtMatKhau.setEchoChar('*');
		    	}
		    }
		    @SuppressWarnings("deprecation")
			@Override
		    public void focusLost(FocusEvent e) {
		    	if(txtMatKhau.getText().isEmpty()) {
					txtMatKhau.setEchoChar((char) 0);
					txtMatKhau.setText("Nhập mật khẩu cũ");
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
		b.add(lblMatKhauMoi = new JLabel("Mật khẩu mới: "));
		b.add(txtMatKhauMoi= new JPasswordField());
		txtMatKhauMoi.setText("Nhập mật khẩu mới");
		txtMatKhauMoi.setEchoChar((char)0);
		txtMatKhauMoi.setForeground(new Color(0xFFAA00));
		txtMatKhauMoi.addFocusListener(new FocusListener() {
		    @SuppressWarnings("deprecation")
			@Override
		    public void focusGained(FocusEvent e) {
		    	if(txtMatKhauMoi.getText().equals("Nhập mật khẩu mới")) {
			    	txtMatKhauMoi.setText("");				
			    	txtMatKhauMoi.setEchoChar('*');
		    	}
		    }
		    @SuppressWarnings("deprecation")
			@Override
		    public void focusLost(FocusEvent e) {
		    	if(txtMatKhauMoi.getText().isEmpty()) {
			    	txtMatKhauMoi.setText("Nhập mật khẩu mới");
			    	txtMatKhauMoi.setEchoChar((char) 0);
		    	}
		    }
		    });
		b.add(Box.createHorizontalStrut(2));
		b.add(btnNhamMatMoi = new JButton(new ImageIcon(".\\image\\eyesclose.png")));
		b.add(btnMoMatMoi = new JButton(new ImageIcon(".\\image\\eyesopen.png")));
		b.add(Box.createHorizontalStrut(18));
		btnNhamMatMoi.setMaximumSize(new Dimension(20, 30));
		btnNhamMat.setFocusPainted(false);
		btnNhamMat.setBorder(BorderFactory.createEmptyBorder());
		btnNhamMat.setContentAreaFilled(false);
		btnMoMat.setFocusPainted(false);
		btnMoMat.setBorder(BorderFactory.createEmptyBorder());
		btnMoMat.setContentAreaFilled(false);
		btnNhamMatMoi.setFocusPainted(false);
		btnNhamMatMoi.setBorder(BorderFactory.createEmptyBorder());
		btnNhamMatMoi.setContentAreaFilled(false);
		btnMoMatMoi.setFocusPainted(false);
		btnMoMatMoi.setBorder(BorderFactory.createEmptyBorder());
		btnMoMatMoi.setContentAreaFilled(false);
		b.add(Box.createHorizontalStrut(10));
		bMain.add(Box.createVerticalStrut(20));
		bMain.add(b = Box.createHorizontalBox());
		b.add(btnDoiMatKhau = new JButton("Đổi mật khẩu", new ImageIcon(".\\image\\changePass32.png")));
		b.add(Box.createHorizontalStrut(30));
		b.add(btnThoat = new JButton("Thoát", new ImageIcon(".\\image\\exit32.png")));
		lblTenDangNhap.setPreferredSize(lblMatKhauMoi.getPreferredSize());
		lblMatKhau.setPreferredSize(lblMatKhauMoi.getPreferredSize());
		btnThoat.setMaximumSize(new Dimension(90,40));
		btnThoat.setMaximumSize(btnDoiMatKhau.getMaximumSize());
		txtTenDangNhap.setEditable(false);
		txtTenDangNhap.setText(maNhanVien);
		txtTenDangNhap.setPreferredSize(txtMatKhau.getPreferredSize());
		txtTenDangNhap.setMaximumSize(txtMatKhau.getMaximumSize());
		txtTenDangNhap.setForeground(Color.blue);
		txtTenDangNhap.setBackground(Color.lightGray);
		btnMoMat.setVisible(false);
		btnMoMatMoi.setVisible(false);
		btnNhamMat.addActionListener(this);
		btnMoMat.addActionListener(this);
		btnNhamMatMoi.addActionListener(this);
		btnMoMatMoi.addActionListener(this);
		btnThoat.addActionListener(this);
		btnDoiMatKhau.addActionListener(this);
		setVisible(true);
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
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
		}else if(o.equals(btnNhamMatMoi)) {
			txtMatKhauMoi.setEchoChar((char)0);
			btnNhamMatMoi.setVisible(false);
			btnMoMatMoi.setVisible(true);
		}else if(o.equals(btnMoMatMoi)) {
			txtMatKhauMoi.setEchoChar('*');
			btnMoMatMoi.setVisible(false);
			btnNhamMatMoi.setVisible(true);
		}else if (o.equals(btnThoat)) {
			this.dispose();
		}else if(o.equals(btnDoiMatKhau)) {
			doiMatKhau();
		}
	}
	@SuppressWarnings("deprecation")
	public void doiMatKhau() {
		String matKhau = qlnv.layMatKhau(txtTenDangNhap.getText());
		NhanVien nv = qlnv.layNhanVienTheoMa(txtTenDangNhap.getText());
		if(txtMatKhau.getText().equals("Nhập mật khẩu cũ")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu cũ");
			txtMatKhau.requestFocus();
		}else {
			if(!txtMatKhau.getText().equals(matKhau)) {
				JOptionPane.showMessageDialog(this, "Mật khẩu cũ không hợp lệ");
				txtMatKhau.requestFocus();
				txtMatKhau.setText("");
			}else {
				if(txtMatKhauMoi.getText().equals("Nhập mật khẩu mới")) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu mới");
					txtMatKhauMoi.requestFocus();
				}else {
					if(!txtMatKhauMoi.getText().matches("^[a-zA-Z0-9]{8,}")) {
						JOptionPane.showMessageDialog(this, "Mật khẩu mới phải ít nhất 8 ký tự và không có ký tự đặc biệt");
						txtMatKhauMoi.setText("");
						txtMatKhauMoi.requestFocus();
					}else if(txtMatKhauMoi.getText().equals(txtMatKhau.getText())) {
						JOptionPane.showMessageDialog(this, "Mật khẩu mới không được giống mật khẩu cũ");
						txtMatKhauMoi.setText("");
						txtMatKhauMoi.requestFocus();
					}else {
						if(qlnv.doiTaiKhoan(txtTenDangNhap.getText(),txtMatKhauMoi.getText())) {
						JOptionPane.showMessageDialog(this, "Đổi mật khẩu nhân viên "+nv.getMaNhanVien()+" thành công");
						this.dispose();
						}else {
						JOptionPane.showMessageDialog(this, "Đổi mật khẩu nhân viên "+txtTenDangNhap.getText()+"không thành công");
					}
				}
			}
		}
	}
	}
}