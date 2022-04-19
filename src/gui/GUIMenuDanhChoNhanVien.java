package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.toedter.calendar.JDateChooser;

import dao.QuanLyKhachHang_DAO;
import dao.QuanLyNhanVien_DAO;
import entity.KhachHang;
import entity.NhanVien;

public class GUIMenuDanhChoNhanVien extends JFrame implements KeyListener,ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int ktrLogin;
	private JMenuBar menuBar;
	private JMenu menuTuyChon;
	private JPanel pMain;
	private JPanel childPanel;
	private JMenu menuKhachHang;
	private JMenu menuPhong;
	private JMenu menuDichVu;
	private JLabel lblUser;
	private JLabel lblNgayHienTai;
	private JMenuItem meimDangXuat;
	private JMenuItem meimThoat;
	private JMenuItem meimChuyenPhong;
	private JMenuItem meimDichVu;
	private JMenuItem meimKhachHang;
	private JMenuItem meimDatPhong;
	private JMenuItem meimTraPhong;
	private JLabel lblHinh;
	private JMenuItem meimThanhToanDichVu;
	private JMenuItem meimHuongDanSuDung;
	private JMenuItem meimThongTin;
	public static String ten;
	public static String ma;
	private static String tenNV;
	public GUIMenuDanhChoNhanVien(String tenNhanVien) {
//	ktrLogin = check;
	tenNV = tenNhanVien;
	setType(Type.POPUP);
	setTitle("QUẢN LÝ KHÁCH SẠN");
	Dimension manHinh = Toolkit.getDefaultToolkit().getScreenSize();
	int width = manHinh.width;
	int height = manHinh.height;
	setSize(width, height);
	setResizable(false);
	setIconImage(Toolkit.getDefaultToolkit().getImage(".\\image\\hotel.png"));
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	Box bFull,b1,b2;
	bFull = Box.createVerticalBox();
	b1 = Box.createHorizontalBox();
	menuBar = new JMenuBar();
	menuTuyChon = new JMenu("      Tùy chọn");
	menuTuyChon.setIcon(new ImageIcon(".\\image\\tuychon.png"));
//	menuNhanVien = new JMenu("  Nhân viên");
//	menuNhanVien.setIcon(new ImageIcon(".\\image\\employee.png"));
	menuPhong = new JMenu("         Phòng");
	menuPhong.setIcon(new ImageIcon(".\\image\\bed.png"));
	menuDichVu = new JMenu("        Dịch vụ");
	menuDichVu.setIcon(new ImageIcon(".\\image\\service.png"));
	menuBar.setPreferredSize(new Dimension(width, 100));
	menuKhachHang = new JMenu("    Khách hàng");
	menuKhachHang.setIcon(new ImageIcon(".\\image\\customer.png"));
//	menuThongKe = new JMenu("   Thống kê");
//	menuThongKe.setIcon(new ImageIcon(".\\image\\analysis.png"));
	bFull.add(b1);
	chinhFontMenu(menuTuyChon);
//	chinhFontMenu(menuNhanVien);
	chinhFontMenu(menuKhachHang);
	chinhFontMenu(menuDichVu);
	chinhFontMenu(menuPhong);
//	chinhFontMenu(menuThongKe);
//	meimDoiMatKhau = new JMenuItem("Đổi mật khẩu (Ctrl + C)", new ImageIcon(".\\image\\changePass32.png"));
	meimHuongDanSuDung = new JMenuItem("Hướng dẫn sử dụng (Ctrl + H)",new ImageIcon(".\\image\\manualicon32.png"));
	meimThongTin = new JMenuItem("Thông tin (Ctrl + A)",new ImageIcon(".\\image\\infomationicon32.png"));
	meimDangXuat = new JMenuItem("Đăng xuất (Ctrl + D)", new ImageIcon(".\\image\\logout32.png"));
	meimThoat = new JMenuItem("Thoát (Ctrl + T)", new ImageIcon(".\\image\\exit32.png"));
	menuTuyChon.add(meimHuongDanSuDung);
	menuTuyChon.add(meimThongTin);
	menuTuyChon.add(meimDangXuat);
	menuTuyChon.add(meimThoat);
//	menuTuyChon.add(meimDoiMatKhau);
//	meinNhanVien = new JMenuItem("Quản lý nhân viên (Ctrl + 1)",new ImageIcon(".\\image\\employee32.png"));
//	menuNhanVien.add(meinNhanVien);
//	meimPhong = new JMenuItem("Tìm kiếm phòng (Ctrl + 1)", new ImageIcon(".\\image\\search32.png"));
	meimDatPhong = new JMenuItem("Đặt phòng (Crtl + 1)", new ImageIcon(".\\image\\check-in32.png"));
	meimTraPhong = new JMenuItem("Trả phòng (Ctrl + 2)", new ImageIcon(".\\image\\checkout32.png"));
	meimChuyenPhong = new JMenuItem("Chuyển phòng (Ctrl + 3)",new ImageIcon(".\\image\\changeRoom32.png"));
//	menuPhong.add(meimPhong);
	menuPhong.add(meimDatPhong);
	menuPhong.add(meimTraPhong);
	menuPhong.add(meimChuyenPhong);
	meimDichVu = new JMenuItem("Quản lý dịch vụ (Ctrl + 4)",new ImageIcon(".\\image\\service32.png"));
	menuDichVu.add(meimDichVu);
	meimThanhToanDichVu = new JMenuItem("Thanh toán dịch vụ (Ctrl + 5)",new ImageIcon(".\\image\\iconthanhtoan32.png"));
	menuDichVu.add(meimThanhToanDichVu);
	meimKhachHang = new JMenuItem("Quản lý khách hàng (Ctrl + 6)", new ImageIcon(".\\image\\customer32.png"));
	menuKhachHang.add(meimKhachHang);
//	meimThongKe = new JMenuItem("Thống kê doanh thu (Ctrl + 8)",new ImageIcon(".\\image\\analysis.png"));
//	menuThongKe.add(meimThongKe);
	menuBar.add(Box.createHorizontalStrut(50));
	menuBar.add(new JLabel(new ImageIcon(".\\image\\employeemenu.png")));
	menuBar.add(Box.createHorizontalStrut(20));
	menuBar.add(lblUser = new JLabel());
	lblUser.setFont(new Font("SansSerif",Font.BOLD,20));
	menuBar.add(Box.createHorizontalStrut(40));
	menuBar.add(menuTuyChon);
//	menuBar.add(menuNhanVien);
	menuBar.add(menuPhong);
	menuBar.add(menuDichVu);
	menuBar.add(menuKhachHang);
//	menuBar.add(menuThongKe);
	menuBar.add(Box.createHorizontalStrut(width-1520));
	menuKhachHang.setPreferredSize(new Dimension(250, 250));
	menuTuyChon.setPreferredSize(menuKhachHang.getPreferredSize());
	menuPhong.setPreferredSize(menuKhachHang.getPreferredSize());
	menuDichVu.setPreferredSize(menuKhachHang.getPreferredSize());
//	menuNhanVien.setPreferredSize(menuKhachHang.getPreferredSize());
//	menuThongKe.setPreferredSize(menuKhachHang.getPreferredSize());
	menuBar.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.black));
	menuPhong.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.BLUE,Color.GREEN));
	menuTuyChon.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.BLUE,Color.GREEN));
//	menuNhanVien.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.BLUE,Color.GREEN));
	menuKhachHang.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.BLUE,Color.GREEN));
	menuDichVu.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.BLUE,Color.GREEN));
//	menuThongKe.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.BLUE,Color.GREEN));
	menuTuyChon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//	menuNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	menuPhong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	menuDichVu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	menuKhachHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//	menuThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	JLabel lblDongHo = new JLabel(new ImageIcon(".\\image\\olock32.png"));
	menuBar.add(Box.createHorizontalStrut(20));
	menuBar.add(lblDongHo);
	menuBar.add(lblNgayHienTai = new JLabel(sdf.format(date.getTime())));
	lblNgayHienTai.setFont(new Font("SansSerif",Font.BOLD,15));
	menuBar.add(Box.createHorizontalStrut(width-100));
	b1.add(menuBar);
	b2 = Box.createHorizontalBox();
	bFull.add(b2);
	//thay doi menu
	b2.add(pMain = new JPanel(),BorderLayout.CENTER);
	pMain.setPreferredSize(new Dimension(width-20, height-320));
	pMain.setLayout(new BorderLayout(0,0));
	pMain.add(lblHinh = new JLabel(new ImageIcon(".\\image\\intro.png")));
	lblHinh.setBounds(10, 320, 1516,700);
//	pMain.setSize(width-520,height-200);
	
	
//	meinNhanVien.addActionListener(this);
	meimKhachHang.addActionListener(this);
	meimDichVu.addActionListener(this);
//	meimPhong.addActionListener(this);
	meimThoat.addActionListener(this);
	meimDangXuat.addActionListener(this);
	meimDatPhong.addActionListener(this);
	meimChuyenPhong.addActionListener(this);
	meimTraPhong.addActionListener(this);
	meimThanhToanDichVu.addActionListener(this);
	meimHuongDanSuDung.addActionListener(this);
	meimThongTin.addActionListener(this);
//	meimDoiMatKhau.addActionListener(this);
	this.addKeyListener(this);
	Container con = this.getContentPane();
	lblUser.setText(tenNhanVien);
	con.add(bFull);
	setVisible(true);
}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void doiPanel(JPanel panel) {
		childPanel = panel;
		pMain.removeAll();
		pMain.add(childPanel);
		pMain.validate();
}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(meimKhachHang)){
			QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
			ArrayList<NhanVien> dsNV = qlnv.timNhanVienTheoTen(tenNV);
			for (NhanVien nhanVien : dsNV) {
				ma = nhanVien.getMaNhanVien();
			}
			doiPanel(new GUIKhachHang(this));
		}else if(o.equals(meimDichVu)) {
			doiPanel(new GUIDichVu(this));
		}
//		else if(o.equals(meimPhong)) {
//			doiPanel(new GUIPhongNhanVien(this));
//		}
		else if(o.equals(meimDangXuat)) {
			try {
				new GUIDangNhap();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
		}else if(o.equals(meimThoat)) {
			this.dispose();
		}else if(o.equals(meimDatPhong)) {
			try {
				UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
				new GUITimKhachHangDatPhongNV(this);
				this.dispose();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if(o.equals(meimChuyenPhong)) {
			doiPanel(new GUIDanhSachPhongChuyen(this));
		}else if(o.equals(meimTraPhong)) {
			doiPanel(new GUIDanhSachPhongTra(this));
		}else if(o.equals(meimThanhToanDichVu)){
			doiPanel(new GUIThanhToanDichVu(this));
		}else if(o.equals(meimHuongDanSuDung)) {
			new GUIHuongDanSuDung(this);
		}else if(o.equals(meimThongTin)) {
			new GUIThongTin(this);
		}
//		else if(o.equals(meimDoiMatKhau)) {
//			new GUIDoiMatKhau(lblUser.getText());
//		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_1) {
			try {
				UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
				new GUITimKhachHangDatPhongNV(this);
				this.dispose();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_2) {
			doiPanel(new GUIDanhSachPhongTra(this));
		}else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_3) {
			doiPanel(new GUIDanhSachPhongChuyen(this));
		}else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_4) {
			doiPanel(new GUIDichVu(this));
		}else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_5) {
			doiPanel(new GUIThanhToanDichVu(this));
		}else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_6) {
			doiPanel(new GUIKhachHang(this));
		}else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_T) {
			this.dispose();
		}else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_D) {
			this.dispose();
			try {
				new GUIDangNhap();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_H) {
			new GUIHuongDanSuDung(this);
		}else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_A) {
			new GUIThongTin(this);
		}
//		else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_C) {
//			new GUIDoiMatKhau(lblUser.getText());
//		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void chinhFontMenu(JMenu menu) {
		menu.setForeground(Color.decode("#f0ab61"));
		menu.setFont(new Font("SansSerif", Font.BOLD, 19));
	}
}

class GUITimKhachHangDatPhongNV extends JFrame implements ActionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private JLabel lblMaKhachHang;
	private JTextField txtMaKhachHang;
	private JLabel lblTenKhachHang;
	private JTextField txtTenKhachHang;
	private JLabel lblGioitinh;
	private JComboBox<String> cboGioiTinh;
	private JLabel lblCMND;
	private JTextField txtCMND;
	private JLabel lblNgaySinh;
	private JDateChooser dcNgaySinh;
	private JLabel lblSDT;
	private JTextField txtSDT;
	private JButton btnDatPhong;
	private JButton btnLamMoi;
	private JButton btnQuayLai;
	private DefaultTableModel modelTable;
	private JTable table;
	private JButton btnTim;
	private QuanLyKhachHang_DAO qlkh = new QuanLyKhachHang_DAO();
	private JLabel lblThongBao;
	private GUIMenu menu;
	public static String ma;
	public static String maKH;
	private QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();

	public GUITimKhachHangDatPhongNV(Frame frameCha){
		Dimension manHinh = Toolkit.getDefaultToolkit().getScreenSize();
		int width = manHinh.width;
		int height= manHinh.height;
		setType(Type.POPUP);
		setTitle("QUẢN LÝ KHÁCH SẠN");
		setSize(width/2,height/2);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\image\\hotel.png"));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		JPanel pNorth = new JPanel();
		pNorth.add(lblTitle = new JLabel("TÌM KHÁCH HÀNG ĐẶT PHÒNG"));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTitle.setForeground(new Color(0xFFAA00));
		Box bMain,b1,b2,b3,b123,b;
		bMain = Box.createVerticalBox();
		bMain.add(pNorth,BorderLayout.NORTH);
		bMain.add(b123 = Box.createHorizontalBox());
		b123.add(b1 = Box.createVerticalBox());
		b1.add(b = Box.createHorizontalBox());
		b.add(lblMaKhachHang = new JLabel("Mã khách hàng: "));
		b.add(txtMaKhachHang = new JTextField());
		b1.add(Box.createVerticalStrut(20));
		b1.add(b = Box.createHorizontalBox());
		b.add(lblCMND = new JLabel("CMND: "));
		b.add(txtCMND = new JTextField());
		b123.add(Box.createHorizontalStrut(50));
		b123.add(b2 = Box.createVerticalBox());
		b2.add(b = Box.createHorizontalBox());
		b.add(lblTenKhachHang = new JLabel("Tên khách hàng: "));
		b.add(txtTenKhachHang = new JTextField());
		b2.add(Box.createVerticalStrut(20));
		b2.add(b = Box.createHorizontalBox());
		b.add(lblSDT = new JLabel("Số điện thoại: "));
		b.add(txtSDT = new JTextField());
		b123.add(Box.createHorizontalStrut(50));
		b123.add(b3 = Box.createVerticalBox());
		b3.add(b = Box.createHorizontalBox());
		b.add(lblGioitinh = new JLabel("Giới tính: "));
		b.add(Box.createHorizontalStrut(43));
		b.add(cboGioiTinh = new JComboBox<String>());
		cboGioiTinh.addItem("");
		cboGioiTinh.addItem("Nam");
		cboGioiTinh.addItem("Nữ");
		b3.add(Box.createVerticalStrut(20));
		b3.add(b = Box.createHorizontalBox());
		b.add(lblNgaySinh = new JLabel("Ngày sinh: "));
		b.add(dcNgaySinh= new JDateChooser());
		dcNgaySinh.setDateFormatString("yyyy-MM-dd");
		b123.setMaximumSize(new Dimension(width/2, 150));
		lblMaKhachHang.setPreferredSize(lblMaKhachHang.getPreferredSize());
		lblCMND.setPreferredSize(lblMaKhachHang.getPreferredSize());
		lblTenKhachHang.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblSDT.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblGioitinh.setPreferredSize(lblNgaySinh.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblNgaySinh.getPreferredSize());
		cboGioiTinh.setMaximumSize(new Dimension(100, 20));
		lblCMND.setPreferredSize(lblMaKhachHang.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblSDT.setPreferredSize(lblTenKhachHang.getPreferredSize());
		dcNgaySinh.setMaximumSize(new Dimension(150, 20));
		String header[] = {"Mã khách hàng","Tên khách hàng","Giới tính","CMND","Số điện thoại","Ngày sinh"};
		modelTable = new DefaultTableModel(header, 0);
		table = new JTable(modelTable) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row,int col) {
				return false;
			}
			public Component prepareRenderer (TableCellRenderer renderer,int row , int col) {
				Component c = super.prepareRenderer(renderer, row, col);
				if(row % 2 ==0 && !isCellSelected(row, col)) {
					c.setBackground(Color.decode("#A9A9F5"));
				}else if(row % 2 != 0 && !isCellSelected(row, col)) {
					c.setBackground(Color.decode("#A9A9F5"));
				}else if(isCellSelected(row, col)) {
					c.setBackground(Color.decode("#0080FF"));
				}
				return c;
			}
		};
		table.setAutoCreateRowSorter(true);
		DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
		renderCenter.setHorizontalAlignment(JLabel.CENTER);
		JTableHeader headerTable = new JTableHeader();
		headerTable.setOpaque(false);
		table.getTableHeader().setReorderingAllowed(false);
		for(int i = 0 ; i <6;++i) {
			table.getColumnModel().getColumn(i).setCellRenderer(renderCenter);
		}
		int widthCol[]= {20,40,20,20,20,20}; 
		for(int i = 0 ; i <6;++i) {
			table.getColumnModel().getColumn(i).setPreferredWidth(widthCol[i]*3);;
		}
		JPanel pThongBao = new JPanel();
		pThongBao.add(lblThongBao = new JLabel());
		lblThongBao.setFont(new Font("Time new roman",Font.ITALIC,15));
		lblThongBao.setForeground(Color.red);
		JScrollPane scroll = new JScrollPane(table);
		bMain.add(pThongBao,BorderLayout.WEST);
		scroll.setBorder(BorderFactory.createLineBorder(Color.RED));
		docDuLieuVaoBang();
		bMain.add(scroll,BorderLayout.CENTER);
		bMain.add(b1 = Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(5));
		b1.add(btnDatPhong = new JButton("Đặt phòng", new ImageIcon(".\\image\\check-in32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnLamMoi = new JButton("Làm mới", new ImageIcon(".\\image\\reload32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnTim = new JButton("Tìm", new ImageIcon(".\\image\\search32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnQuayLai = new JButton("Quay Lại", new ImageIcon(".\\image\\logout32.png")));
		btnQuayLai.setBackground(Color.red);
		b1.add(Box.createHorizontalStrut(5));
		Border borderButton = BorderFactory.createLineBorder(Color.red);
		TitledBorder titleBorderButton = new TitledBorder(borderButton, "Chọn tác vụ");
		titleBorderButton.setTitleFont(new Font("SansSerif", Font.ITALIC, 15));
		titleBorderButton.setTitleColor(new Color(0xFFAA00));
		b1.setBorder(titleBorderButton);
		btnDatPhong.setMaximumSize(new Dimension(150, 50));
		btnDatPhong.setMaximumSize(btnDatPhong.getMaximumSize());
		btnLamMoi.setMaximumSize(btnDatPhong.getMaximumSize());
		btnTim.setMaximumSize(btnDatPhong.getMaximumSize());
		bMain.add(Box.createVerticalStrut(10));
		scroll.setPreferredSize(new Dimension(width-200, height-400));
		bMain.setPreferredSize(new Dimension(width-200, height-100));
		btnTim.addActionListener(this);
		table.addMouseListener(this);
		btnDatPhong.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnQuayLai.addActionListener(this);
		btnDatPhong.setEnabled(false);
		add(bMain);
		setUndecorated(true);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTim)) {
			timKhachHang();
		}else if(o.equals(btnLamMoi)) {
			lamMoiTextFields();
			xoaBang();
			docDuLieuVaoBang();
		}else if(o.equals(btnQuayLai)) {
			String ma = GUIDangNhap.ma;
			if(ma.equals("NV000001")) {
				menu = new GUIMenu(1);
				this.dispose();
			}else {
				new GUIMenuDanhChoNhanVien(qlnv.layNhanVienTheoMa(ma).getTenNhanVien());
				this.dispose();
			}
		}else if(o.equals(btnTim)) {
			timKhachHang();
		}else if(o.equals(btnDatPhong)) {
			String ma = GUIDangNhap.ma;
			if(ma.equals("NV000001")) {
				maKH = txtMaKhachHang.getText().trim();
				menu = new GUIMenu(1);
				menu.doiPanel(new GUIDanhSachPhongDat(menu));
				this.dispose();

			}else {
				maKH = txtMaKhachHang.getText().trim();
				GUIMenuDanhChoNhanVien menuNV = new GUIMenuDanhChoNhanVien(qlnv.layNhanVienTheoMa(ma).getTenNhanVien());
				menuNV.doiPanel(new GUIDanhSachPhongDat(menuNV));
				this.dispose();
			}
		}
	}
	public void themDongVaoBang(KhachHang kh) {
		modelTable.addRow(new Object[] {
				kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getGioiTinh(),kh.getcMND(),kh.getSoDienThoai(),kh.getNgaySinh()
		});
	}
	public void docDuLieuVaoBang() {
		ArrayList<KhachHang> dsKhachHang = qlkh.layToanBoKhachHang();
		for (KhachHang khachHang : dsKhachHang) {
			themDongVaoBang(khachHang);
		}
	}
	public void xoaBang() {
		for(int i = table.getRowCount()-1;i>=0;i--) {
			modelTable.removeRow(i);
		}
	}
	public void lamMoiTextFields() {
		txtMaKhachHang.setText("");
		txtTenKhachHang.setText("");
		txtCMND.setText("");
		txtSDT.setText("");
		dcNgaySinh.setDate(null);
		cboGioiTinh.setSelectedIndex(0);
		txtMaKhachHang.requestFocus();
		lblThongBao.setText("");
		txtMaKhachHang.setEditable(true);
		txtTenKhachHang.setEditable(true);
		txtCMND.setEditable(true);
		txtSDT.setEditable(true);
		cboGioiTinh.setEnabled(true);
		dcNgaySinh.setEnabled(true);
		btnDatPhong.setEnabled(false);
	}
	public void timKhachHang() {
	String maKH="",tenKH="",cMND ="",ngaySinh = "",sDT="",gioiTinh="";
	if(txtMaKhachHang.getText().trim() != null)
		maKH = txtMaKhachHang.getText().trim();
	if(txtTenKhachHang.getText().trim() != null)
		tenKH = txtTenKhachHang.getText().trim();
	if(txtCMND.getText().trim() != null)
		cMND = txtCMND.getText().trim();
	if(txtSDT.getText().trim() != null)
		sDT = txtSDT.getText().trim();
	if(dcNgaySinh.getDate() != null) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ngaySinh = sdf.format(dcNgaySinh.getDate());
	}
		gioiTinh = cboGioiTinh.getSelectedItem().toString();
		ArrayList<KhachHang> dsKhachHang = qlkh.timKhachHangTheoTatCa(maKH, tenKH, gioiTinh, cMND, sDT, ngaySinh);
		for(int i = table.getRowCount()-1;i>=0;i--) {
			modelTable.removeRow(i);
		}
		try {
		if(dsKhachHang.size() == 0) {
			JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng");
			docDuLieuVaoBang();
		}else {
			for (KhachHang khachHang : dsKhachHang) {
				themDongVaoBang(khachHang);
				table.setModel(modelTable);
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		txtMaKhachHang.setEditable(false);
		int row = table.getSelectedRow();
		txtMaKhachHang.setText(modelTable.getValueAt(row, 0).toString());
		txtTenKhachHang.setText(modelTable.getValueAt(row, 1).toString());
		cboGioiTinh.setSelectedItem(modelTable.getValueAt(row, 2));
		txtCMND.setText(modelTable.getValueAt(row, 3).toString());
		txtSDT.setText(modelTable.getValueAt(row, 4).toString());
		java.util.Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(modelTable.getValueAt(row, 5).toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dcNgaySinh.setDate(date);
		btnDatPhong.setEnabled(true);
		txtMaKhachHang.setEditable(false);
		txtTenKhachHang.setEditable(false);
		txtCMND.setEditable(false);
		txtSDT.setEditable(false);
		cboGioiTinh.setEnabled(false);
		dcNgaySinh.setEnabled(false);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}