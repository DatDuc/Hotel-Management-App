package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.toedter.calendar.JDateChooser;

import dao.QuanLyCT_PhieuDatPhong_DAO;
import dao.QuanLyHoaDon_DAO;
import dao.QuanLyKhachHang_DAO;
import dao.QuanLyNhanVien_DAO;
import dao.QuanLyPhieuDatPhong_DAO;
import dao.QuanLyPhong_DAO;
import entity.KhachHang;
import entity.PhieuDatPhong;
import entity.Phong;

public class GUIDanhSachPhongTra extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6591822141180090167L;
	private GUIMenu menu;
	private Frame frameCha;
	private JPanel pNorth1;
	private JLabel lblTitle;
	private JPanel p;
	private TitledBorder titleBorderPhong;
	private JLabel lblTongSoPhong;
	private JLabel tongSoPhong;
	private JLabel lblHinhTongSoPhong;
	private JButton btnQuayLai;
	private static JButton[] btnPhong;
	public static String maPhong;
	public static String maNV;
	public static int maPhieu;
	private QuanLyHoaDon_DAO qlhd = new QuanLyHoaDon_DAO();
	private QuanLyPhong_DAO qlp = new QuanLyPhong_DAO();
	private QuanLyCT_PhieuDatPhong_DAO qlctpdp = new QuanLyCT_PhieuDatPhong_DAO();
	private QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
	private JLabel lblTitle2;
	private JLabel lblMaKhacHang;
	private JTextField txtMaKhachHang;
	private JLabel lblGioiTinh;
	private JTextField txtGioiTinh;
	private JLabel lblTenKhachHang;
	private JTextField txtTenKhachHang;
	private JLabel lblNgaySinh;
	private JDateChooser dcNgaySinh;
	private JLabel lblCMND;
	private JTextField txtCMND;
	private JLabel lblSoDienThoai;
	private JTextField txtSoDienThoai;
	private TitledBorder titleBorderKhachHang;
	private DefaultTableModel modelTablePDP;
	private QuanLyKhachHang_DAO qlkh = new QuanLyKhachHang_DAO();
	private JTable tablePDP;
	private Box b4;
	private JButton btnTraPhong;
	private JButton btnLamMoi;
	private TitledBorder titleBorderNut;
	private JButton btnHuyCTPhong;
	private JButton btnTimKiem;
	private TitledBorder titleBorderPhieu;
	private JButton btnDongYPDP;
	private DefaultTableModel modelTable;
	private JTable table;
	private JLabel lblSoPhong;
	private JTextField txtSoPhong;
	private JLabel lblTongTien;
	private JTextField txtTongTien;
	private QuanLyPhieuDatPhong_DAO qlpdp = new QuanLyPhieuDatPhong_DAO();
	
	public GUIDanhSachPhongTra(Frame cha) {
		frameCha = cha;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int rong = screenSize.width;
		int cao = screenSize.height;
		Box bMain,b123,b1,b2,b3,b;		
		pNorth1 = new JPanel();
		pNorth1.add(lblTitle = new JLabel("DANH SÁCH PHÒNG KHÁCH SẠN"));
		add( bMain= Box.createVerticalBox());
		bMain.add(b123 = Box.createHorizontalBox());
		b123.add(Box.createHorizontalStrut(50));
		b123.add(b1 = Box.createVerticalBox());
		b1.add(b = Box.createHorizontalBox());
		b.add(pNorth1,BorderLayout.NORTH);
		lblTitle.setFont(new Font("SansSerif",Font.BOLD,30));
		lblTitle.setForeground(new Color(0xFFAA00));
		b1.add(b = Box.createHorizontalBox());
		b.add(lblTongSoPhong = new JLabel("Tổng số phòng: "));
		lblTongSoPhong.setForeground(new Color(0xFFAA00));
//		lblTongSoPhong.setBounds(5, 0, 48, 48);
		lblTongSoPhong.setFont(new Font("SansSerif", Font.BOLD, 20));
		b.add(lblHinhTongSoPhong = new JLabel(new ImageIcon(".\\image\\tongPhong.gif")));
		lblHinhTongSoPhong.add(tongSoPhong = new JLabel(qlp.tongSoPhong()+""));
		tongSoPhong.setForeground(new Color(0xFFAA00));
		tongSoPhong.setBounds(13, 0, 48, 48);
		tongSoPhong.setFont(new Font("SansSerif", Font.BOLD, 20));
		b1.add(b4 = Box.createHorizontalBox());
		p = new JPanel();
		ArrayList<PhieuDatPhong> dsPDP1 = qlpdp.layPhieuDatPhongTheoMaPhong(GUIThanhToanDichVu.maPhong);
		PhieuDatPhong pdp1 = dsPDP1.get(0);
		ArrayList<Phong> dsPhongDoc = qlp.layDanhSachPhongTheoMaPhieuDatPhong(pdp1.getMaPhieuDatPhong()+"");
		goiDanhSachPhong(p, b4,dsPhongDoc);
		b4.setPreferredSize(new Dimension(rong-800,cao-320));
//		b.setPreferredSize(new Dimension(rong-500,cao-120));
		b4.setBorder(titleBorderPhong = new TitledBorder(BorderFactory.createLineBorder(Color.red),"Danh sách phòng chuẩn bị trả"));
		titleBorderPhong.setTitleFont(new Font("SansSerif",Font.BOLD,20));
		titleBorderPhong.setTitleColor(new Color(0xFFAA00));
		titleBorderPhong.setTitlePosition(TitledBorder.ABOVE_TOP);
		b123.add(Box.createHorizontalStrut(20));
		b123.add(b2 = Box.createVerticalBox());
		b2.add(b = Box.createHorizontalBox());
		b123.add(Box.createHorizontalStrut(50));
		JPanel pNorth2 = new JPanel();
		pNorth2.add(lblTitle2 = new JLabel("TRẢ PHÒNG"));
		b.add(pNorth2,BorderLayout.NORTH);
		lblTitle2.setFont(new Font("SansSerif",Font.BOLD,30));
		lblTitle2.setForeground(new Color(0xFFAA00));
		String headerPDP[] = {"Mã phiếu","Mã khách hàng","Tên khách hàng","Số điện thoại","Ngày nhận phòng","Ngày trả phòng"};
		modelTablePDP = new DefaultTableModel(headerPDP, 0);
		tablePDP = new JTable(modelTablePDP) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 5939083519223745986L;
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
		tablePDP.setAutoCreateRowSorter(true);
		DefaultTableCellRenderer renderCenterPDP = new DefaultTableCellRenderer();
		renderCenterPDP.setHorizontalAlignment(JLabel.CENTER);
		JTableHeader headerTablePDP = new JTableHeader();
		headerTablePDP.setOpaque(false);
		tablePDP.getTableHeader().setReorderingAllowed(false);
		for(int i = 0 ; i <6;++i) {
			tablePDP.getColumnModel().getColumn(i).setCellRenderer(renderCenterPDP);
		}
		int widthColPDP[]= {10,10,30,20,20,20}; 
		for(int i = 0 ; i <6;++i) {
			tablePDP.getColumnModel().getColumn(i).setPreferredWidth(widthColPDP[i]*3);;
		}
		JScrollPane scrollPDP = new JScrollPane(tablePDP);
		scrollPDP.setBorder(BorderFactory.createLineBorder(Color.RED));
		scrollPDP.setPreferredSize(new Dimension(rong-1300,cao-700));
		b2.add(b = Box.createHorizontalBox());
		b.add(scrollPDP,BorderLayout.CENTER);
		b2.add(Box.createVerticalStrut(40));
		scrollPDP.setBorder(titleBorderPhieu = new TitledBorder(BorderFactory.createLineBorder(Color.red),"Phiếu đặt phòng"));
		titleBorderPhieu.setTitleFont(new Font("SansSerif",Font.BOLD,20));
		titleBorderPhieu.setTitleColor(new Color(0xFFAA00));
		JPanel pDongYPDP = new JPanel();
		pDongYPDP.add(btnDongYPDP = new JButton("Đồng ý phòng muốn trả",new ImageIcon(".\\image\\ctdv.jpg")));
		b2.add(pDongYPDP);
		ArrayList<PhieuDatPhong> dsPDP = qlpdp.layPhieuDatPhongTheoMaPhong(GUIThanhToanDichVu.maPhong);
		PhieuDatPhong pdp2 = dsPDP.get(0);
		themDongVaoBangPDP(pdp2);
		Box bKH;
		b2.add(bKH = Box.createHorizontalBox());
		bKH.add(b3 = Box.createVerticalBox());
		b3.add(Box.createVerticalStrut(15));
		b3.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(50));
		b.add(lblMaKhacHang = new JLabel("Mã khách hàng: "));
		b.add(txtMaKhachHang = new JTextField());
		b.add(Box.createHorizontalStrut(50));
		b3.add(Box.createVerticalStrut(30));
		b3.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(50));
		b.add(lblTenKhachHang = new JLabel("Tên khách hàng: "));
		b.add(txtTenKhachHang = new JTextField());
		b.add(Box.createHorizontalStrut(50));
		b3.add(Box.createVerticalStrut(30));
		b3.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(50));
		b.add(lblCMND= new JLabel("CMND: "));
		b.add(txtCMND= new JTextField());
		b.add(Box.createHorizontalStrut(50));
		b3.add(Box.createVerticalStrut(15));
		bKH.add(b3 = Box.createVerticalBox());
		b3.add(Box.createVerticalStrut(15));
		b3.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(50));
		b.add(lblGioiTinh = new JLabel("Giới tính: "));
		b.add(txtGioiTinh = new JTextField());
		b.add(Box.createHorizontalStrut(70));
		b3.add(Box.createVerticalStrut(30));
		b3.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(50));
		b.add(lblNgaySinh = new JLabel("Ngày sinh: "));
		b.add(dcNgaySinh = new JDateChooser());
		dcNgaySinh.setDateFormatString("dd/MM/yyyy");
		b.add(Box.createHorizontalStrut(70));
		b3.add(Box.createVerticalStrut(30));
		b3.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(50));
		b.add(lblSoDienThoai = new JLabel("Số điện thoại :"));
		b.add(txtSoDienThoai = new JTextField());
		b.add(Box.createHorizontalStrut(70));
		b3.add(Box.createVerticalStrut(15));
		txtMaKhachHang.setPreferredSize(new Dimension(170, 20));
		lblMaKhacHang.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblTenKhachHang.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblCMND.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblSoDienThoai.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblSoDienThoai.getPreferredSize());
		txtMaKhachHang.setEditable(false);
		txtTenKhachHang.setEditable(false);
		txtCMND.setEditable(false);
		txtSoDienThoai.setEditable(false);
		bKH.setBorder(titleBorderKhachHang = new TitledBorder(BorderFactory.createLineBorder(Color.red),"Thông tin khách hàng"));
		titleBorderKhachHang.setTitleFont(new Font("SansSerif",Font.BOLD,20));
		titleBorderKhachHang.setTitleColor(new Color(0xFFAA00));
		
		String header[] = {"Mã phòng","Giá phòng","Số giường","Số người","Mô tả","Loại phòng"};
		modelTable = new DefaultTableModel(header, 0);
		table = new JTable(modelTable) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2373383290943445373L;
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
		int widthCol[]= {20,20,20,20,20,20}; 
		for(int i = 0 ; i <6;++i) {
			table.getColumnModel().getColumn(i).setPreferredWidth(widthCol[i]*3);;
		}
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBorder(BorderFactory.createLineBorder(Color.RED));
		b2.add(scroll);
		scroll.setPreferredSize(new Dimension(rong-1300,cao-700));
		b2.add(Box.createVerticalStrut(10));
		b2.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(50));
		b.add(lblSoPhong = new JLabel("Số phòng: "));
		b.add(txtSoPhong = new JTextField());
		b.add(Box.createHorizontalStrut(50));
		b.add(Box.createHorizontalStrut(50));
		b.add(lblTongTien = new JLabel("Tổng tiền: "));
		b.add(txtTongTien = new JTextField());
		b.add(Box.createHorizontalStrut(50));
		ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoMaPhieuDatPhong(modelTablePDP.getValueAt(tablePDP.getRowCount()-1, 0).toString());
		for (Phong phong : dsPhong) {
			themDongVaoBang(phong);
		}
		KhachHang kh = qlkh.layKhachHangTheoMaPhieuDatPhong(modelTablePDP.getValueAt(tablePDP.getRowCount()-1, 0).toString());
		txtMaKhachHang.setText(kh.getMaKhachHang());
		txtTenKhachHang.setText(kh.getTenKhachHang());
		txtGioiTinh.setText(kh.getGioiTinh());
		txtCMND.setText(kh.getcMND());
		txtSoDienThoai.setText(kh.getSoDienThoai());
		dcNgaySinh.setDate(kh.getNgaySinh());
		double tongTien = 0;
		Date ngayHienTai = new Date();
		long soNgayO= ngayHienTai.getTime() - 
				qlctpdp.layCT_PhieuDatPhongTheoMaPhieuDatPhong(modelTablePDP.getValueAt(tablePDP.getRowCount()-1, 0).toString())
				.getNgayDen().getTime();
		soNgayO = soNgayO / (1000 * 60 * 60 * 24);
		if(soNgayO >= 0 && soNgayO <1)
			soNgayO = 1;
		if(soNgayO < 0)
			soNgayO = 0;
		int rowP = table.getRowCount();
		for (int i = 0; i < rowP; i++) {
			double gia = Double.parseDouble(modelTable.getValueAt(i, 1).toString());
			tongTien+= (soNgayO * gia);
		}
		DecimalFormat df = new DecimalFormat("#,###.# VND");
		txtTongTien.setText(df.format(tongTien));
		txtSoPhong.setText(rowP + "");
		lblSoPhong.setFont(new Font("SansSerif",Font.BOLD,15));
		lblTongTien.setFont(new Font("SansSerif",Font.BOLD,15));
		txtTongTien.setEditable(false);
		txtSoPhong.setEditable(false);
		txtTongTien.setForeground(Color.BLUE);
		txtSoPhong.setForeground(Color.BLUE);
		b2.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(50));
		b.add(btnTraPhong = new JButton("Trả phòng",new ImageIcon(".\\image\\checkout32.png")));
		b.add(Box.createHorizontalStrut(20));
		b.add(btnLamMoi = new JButton("Làm mới",new ImageIcon(".\\image\\reload32.png")));
		b.add(Box.createHorizontalStrut(30));
		b.add(btnQuayLai = new JButton("Quay lại",new ImageIcon(".\\image\\logout32.png")));
		btnQuayLai.setBackground(Color.red);
		b.add(Box.createHorizontalStrut(10));
		b.setBorder(titleBorderNut = new TitledBorder(BorderFactory.createLineBorder(Color.red),"Chọn thao tác"));
		txtGioiTinh.setEditable(false);
		dcNgaySinh.setEnabled(false);
		titleBorderNut.setTitleFont(new Font("SansSerif",Font.BOLD,20));
		titleBorderNut.setTitleColor(new Color(0xFFAA00));
		btnQuayLai.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTraPhong.addActionListener(this);
		btnDongYPDP.addActionListener(this);
		btnLamMoi.setVisible(false);
		btnDongYPDP.setVisible(false);
	}
	public void taoJButton(JButton btn,Dimension kichThuoc) {
		btn.setPreferredSize(kichThuoc);
		btn.setMaximumSize(kichThuoc);
		btn.setMinimumSize(kichThuoc);
	}
	public void goiDanhSachPhong(JPanel p,Box b1,ArrayList<Phong> dsTatCaPhong) {
		b1.removeAll();
		b1.revalidate();
		b1.repaint();
		int x = 6;
		int y = qlp.tongSoPhong() / 4 + 1;
		DecimalFormat df = new DecimalFormat("#,###.# VND");
		ArrayList<String> dsThongTinPhong = new ArrayList<String>();
		for (Phong phong : dsTatCaPhong) {
			String mauSac ="#FFCC00";
//			if (phong.getTinhTrangPhong() == 0) { // chưa đặt
//				mauSac = "#77d56c";
//			}else if(phong.getTinhTrangPhong() == 3) {// da dat
//				mauSac="#0080FF";		
//			}else if (phong.getTinhTrangPhong() == 1) { // đăng sử dụng
//				mauSac = "#ea5483";
//			} else if (phong.getTinhTrangPhong() == 2) { // đến hạn trả
//				mauSac = "#e33309";
//			}
			dsThongTinPhong.add("<html><center>Phòng: " + phong.getMaPhong() + "<br/>"
			+ "Mô tả: " + phong.getMoTa() + "<br/>"
			+ "Giá: " + df.format(phong.getGiaPhong()) + "<br/>" 
			+ "Loại phòng: " + qlp.layTenLoaiPhong(phong.getLoaiPhong().getMaLoai()).getTenLoai() + "<br/>"
			+ "Số giường: " + phong.getSoGiuong()+"<br/>"
			+"Số người:" + phong.getSoNguoi()
			+"<!--color" + mauSac + "color-->"
			+ "<!--id" + phong.getMaPhong() + "id-->"
			+ "</html>");
		}
		String[] thongTinPhong;
		thongTinPhong = dsThongTinPhong.toArray(new String[0]);
		btnPhong = new JButton[dsThongTinPhong.size()];
		p = new JPanel();
		p.revalidate();
		p.repaint();
		p.setOpaque(false);
		p.setLayout(new GridLayout(y, x, 20, 30));
		try {
			for (int i = 0; i < thongTinPhong.length; i++) {
				btnPhong[i] = new JButton();
				btnPhong[i].setText(thongTinPhong[i]);
				int dau = thongTinPhong[i].indexOf("<!--color");
				int cuoi= thongTinPhong[i].indexOf("color-->");
				String mauSac = thongTinPhong[i].substring(dau + 9,cuoi);
				btnPhong[i].setBackground(Color.decode(mauSac));
				p.add(btnPhong[i]);
				taoJButton(btnPhong[i],new Dimension(40,120));
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		b1.add(new JScrollPane(p));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		for(int i = 0 ; i < btnPhong.length;i++) {
			if(o.equals(btnPhong[i])) {
				int dau = btnPhong[i].getText().indexOf("<!--id");
				int cuoi = btnPhong[i].getText().indexOf("id-->");
				String ma = btnPhong[i].getText().substring(dau + 6, cuoi);
				xoaDongTrongBangPDP();
				xoaDongTrongBang();
				ArrayList<PhieuDatPhong> dsPDP = qlpdp.layPhieuDatPhongTheoMaPhong(ma);
				for (PhieuDatPhong phieuDatPhong : dsPDP) {
					themDongVaoBangPDP(phieuDatPhong);
				}
				txtMaKhachHang.setText("");
				txtTenKhachHang.setText("");
				txtTongTien.setText("");
				txtSoPhong.setText("");
				txtCMND.setText("");
				txtSoDienThoai.setText("");
				txtGioiTinh.setText("");
				dcNgaySinh.setDate(null);
			}
		}
		if(o.equals(btnQuayLai)) {
			String ma = GUIDangNhap.ma;
			if(ma.equals("NV000001")) {
				frameCha.dispose();
				menu = new GUIMenu(1);
				menu.doiPanel(new GUIThanhToanDichVu(menu));
			}else {
				frameCha.dispose();
				GUIMenuDanhChoNhanVien menuNV = new GUIMenuDanhChoNhanVien(qlnv.layNhanVienTheoMa(ma).getTenNhanVien());
				menuNV.doiPanel(new GUIThanhToanDichVu(menuNV));
			}
		}else if(o.equals(btnLamMoi)) {
			lamMoiTextFields();
			xoaDongTrongBang();
			xoaDongTrongBangPDP();
		}else if(o.equals(btnHuyCTPhong)) {
			int row = tablePDP.getSelectedRow();
			modelTablePDP.removeRow(row);
		}else if(o.equals(btnDongYPDP)) {
			int row = -1;
			row = tablePDP.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu đặt phòng muốn thanh toán");
			}else {
				xoaDongTrongBang();
				ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoMaPhieuDatPhong(modelTablePDP.getValueAt(row, 0).toString());
				for (Phong phong : dsPhong) {
					themDongVaoBang(phong);
				}
				KhachHang kh = qlkh.layKhachHangTheoMaPhieuDatPhong(modelTablePDP.getValueAt(row, 0).toString());
				txtMaKhachHang.setText(kh.getMaKhachHang());
				txtTenKhachHang.setText(kh.getTenKhachHang());
				txtGioiTinh.setText(kh.getGioiTinh());
				txtCMND.setText(kh.getcMND());
				txtSoDienThoai.setText(kh.getSoDienThoai());
				dcNgaySinh.setDate(kh.getNgaySinh());
				int rowP = table.getRowCount();
				txtSoPhong.setText(rowP + "");
				double tongTien = 0;
				Date ngayHienTai = new Date();
				long soNgayO= ngayHienTai.getTime() - 
						qlctpdp.layCT_PhieuDatPhongTheoMaPhieuDatPhong(modelTablePDP.getValueAt(row, 0).toString())
						.getNgayDen().getTime();
				soNgayO = soNgayO / (1000 * 60 * 60 * 24);
				if(soNgayO >= 0 && soNgayO <1)
					soNgayO = 1;
				if(soNgayO < 0)
					soNgayO = 0;
				for (int i = 0; i < rowP; i++) {
					double gia = Double.parseDouble(modelTable.getValueAt(i, 1).toString());
					tongTien+= (soNgayO * gia);
				}
				DecimalFormat df = new DecimalFormat("#,###.# VND");
				txtTongTien.setText(df.format(tongTien));
			}
		}else if(o.equals(btnTraPhong)) {
			int row1 = -1;
			row1= tablePDP.getRowCount();
			int row = -1;
			row = table.getRowCount();
			String maPhongTra = "";
			for(int i = 0; i < row ;i++) {
				maPhongTra+=modelTable.getValueAt(i,0).toString()+" ";
			}
			if(row1 <= 0 )
				JOptionPane.showMessageDialog(this,"Vui lòng chọn phòng muốn trả");
			else {
				if(row <= 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu đặt phòng muốn trả");
				}else {
					int rowPDP=tablePDP.getRowCount()-1;
					String maPDP = modelTablePDP.getValueAt(rowPDP,0).toString();
					int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn trả phòng "+maPhongTra+" không","Nhắc nhở",JOptionPane.YES_NO_OPTION);
					if(kq == JOptionPane.YES_OPTION) {
						if(qlhd.themHoaDon(maPDP)) {
							qlctpdp.suaNgayTraPhongCT_PhieuDatPhongTheoMaPDP(maPDP);
							int in = JOptionPane.showConfirmDialog(this, "Trả phòng thành công và in hóa đơn cho khách hàng","Nhắc nhở",JOptionPane.YES_NO_OPTION);
							if(in == JOptionPane.YES_OPTION) {
								inHoaDon();
								String ma = GUIDangNhap.ma;
								if(ma.equals("NV000001")) {
									frameCha.dispose();
									menu = new GUIMenu(1);
									menu.doiPanel(new GUIThanhToanDichVu(menu));
								}else {
									frameCha.dispose();
									GUIMenuDanhChoNhanVien menuNV = new GUIMenuDanhChoNhanVien(qlnv.layNhanVienTheoMa(ma).getTenNhanVien());
									menuNV.doiPanel(new GUIThanhToanDichVu(menuNV));
								}
							}else {
								String ma = GUIDangNhap.ma;
								if(ma.equals("NV000001")) {
									frameCha.dispose();
									menu = new GUIMenu(1);
									menu.doiPanel(new GUIThanhToanDichVu(menu));
								}else {
									frameCha.dispose();
									GUIMenuDanhChoNhanVien menuNV = new GUIMenuDanhChoNhanVien(qlnv.layNhanVienTheoMa(ma).getTenNhanVien());
									menuNV.doiPanel(new GUIThanhToanDichVu(menuNV));
								}
							}
						}else {
							JOptionPane.showMessageDialog(this, "Trả phòng không thành công");
							String ma = GUIDangNhap.ma;
							if(ma.equals("NV000001")) {
								frameCha.dispose();
								menu = new GUIMenu(1);
								menu.doiPanel(new GUIThanhToanDichVu(menu));
							}else {
								frameCha.dispose();
								GUIMenuDanhChoNhanVien menuNV = new GUIMenuDanhChoNhanVien(qlnv.layNhanVienTheoMa(ma).getTenNhanVien());
								menuNV.doiPanel(new GUIThanhToanDichVu(menuNV));
							}
						}
					}
				}
			}
		}else if(o.equals(btnTimKiem)) {
			timPhongTra();
		}
	}
	public void xoaDongTrongBangPDP() {
			while (modelTablePDP.getRowCount() > 0) {
				modelTablePDP.removeRow(0);
				}
			}
	public void themDongVaoBangPDP(PhieuDatPhong pdp) {
//		String headerPDP[] = {"Mã phiếu đặt","Mã khách hàng","Tên khách hàng","Số điện thoại"};
		modelTablePDP.addRow(new Object[] {
				pdp.getMaPhieuDatPhong(),
				qlkh.timKhacHangTheoMa(pdp.getKhachHang().getMaKhachHang()).getMaKhachHang(),
				qlkh.timKhacHangTheoMa(pdp.getKhachHang().getMaKhachHang()).getTenKhachHang(),
				qlkh.timKhacHangTheoMa(pdp.getKhachHang().getMaKhachHang()).getSoDienThoai(),
				qlctpdp.layCT_PhieuDatPhongTheoMaPhieuDatPhong(pdp.getMaPhieuDatPhong()+"").getNgayDen(),
				qlctpdp.layCT_PhieuDatPhongTheoMaPhieuDatPhong(pdp.getMaPhieuDatPhong()+"").getNgayDi()
		});
	}
	public void themDongVaoBang(Phong phong) {
		DecimalFormat df = new DecimalFormat("###.#");
		modelTable.addRow(new Object[] {
//				String header[] = {"Mã phòng","Giá phòng","Số giường","Mô tả","Loại phòng"};
				phong.getMaPhong(),df.format(phong.getGiaPhong()),phong.getSoGiuong(),phong.getSoNguoi(),phong.getMoTa(),
				qlp.layTenLoaiPhong(phong.getLoaiPhong().getMaLoai()).getTenLoai()
		});
	}
	public void xoaDongTrongBang() {
		while(modelTable.getRowCount()>0) {
			modelTable.removeRow(0);
		}
	}
	public void lamMoiTextFields() {
		txtMaKhachHang.setText("");
		txtTenKhachHang.setText("");
		txtCMND.setText("");
		txtGioiTinh.setText("");
		dcNgaySinh.setDate(null);
		txtSoDienThoai.setText("");
		txtSoPhong.setText("");
		txtTongTien.setText("");
		ArrayList<Phong> dsPhong = qlp.layTatCaCacPhongGomTinhTrangTra();
		goiDanhSachPhong(p, b4, dsPhong);
	}
	public void timPhongTra() {
		JLabel lblMaPhong, lblLoaiPhong, lblmoTa, lblSoNguoi, lblSoGiuong, lblGiaPhong;
		JTextField txtMaPhong, txtmoTa, txtSoGiuong, txtSoNguoi, txtGiaPhong;
		JComboBox<String> cboLoaiPhong;
		JPanel p1 = new JPanel(new GridLayout(0, 1));
		p1.setPreferredSize(new Dimension(400, 100));
		Box b12, b123, b2, b;
		p1.add(b12 = Box.createHorizontalBox());
		b12.add(b123 = Box.createVerticalBox());
		b123.add(b = Box.createHorizontalBox());
		b.add(lblMaPhong = new JLabel("Mã phòng: "));
		b.add(txtMaPhong = new JTextField());
		b123.add(Box.createVerticalStrut(10));
		b123.add(b = Box.createHorizontalBox());
		b.add(lblSoGiuong = new JLabel("Số giường: "));
		b.add(txtSoGiuong = new JTextField());
		b123.add(Box.createVerticalStrut(10));
		b123.add(b = Box.createHorizontalBox());
		b.add(lblmoTa = new JLabel("Mô tả: "));
		b.add(txtmoTa = new JTextField());
		b123.add(Box.createVerticalStrut(10));
		b123.setPreferredSize(new Dimension(150, 100));
		b12.add(b2 = Box.createVerticalBox());
		b2.add(b = Box.createHorizontalBox());
		b.add(lblGiaPhong = new JLabel("Giá phòng: "));
		b.add(txtGiaPhong = new JTextField());
		b2.add(Box.createVerticalStrut(10));
		b2.add(b = Box.createHorizontalBox());
		b.add(lblSoNguoi = new JLabel("Số người: "));
		b.add(txtSoNguoi = new JTextField());
		b2.add(Box.createVerticalStrut(10));
		b2.add(b = Box.createHorizontalBox());
		b.add(lblLoaiPhong = new JLabel("Loại phòng: "));
		b.add(cboLoaiPhong = new JComboBox<String>());
		b2.add(Box.createVerticalStrut(10));
		cboLoaiPhong.addItem("");
		qlp.layTatCaTenLoai().forEach(t -> {
			cboLoaiPhong.addItem(t);
		});
		lblSoGiuong.setPreferredSize(lblSoGiuong.getPreferredSize());
		lblmoTa.setPreferredSize(lblSoGiuong.getPreferredSize());
		lblMaPhong.setPreferredSize(lblSoGiuong.getPreferredSize());
		lblGiaPhong.setPreferredSize(lblLoaiPhong.getPreferredSize());
		lblSoNguoi.setPreferredSize(lblLoaiPhong.getPreferredSize());
		lblLoaiPhong.setPreferredSize(lblLoaiPhong.getPreferredSize());
		int kq = JOptionPane.showConfirmDialog(null, p1, "Tìm phòng", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		String maPhong = "", moTa = "", gia = "", loaiPhong = "", soGiuong = "", soNguoi = "";
		if (txtMaPhong.getText().trim() != null)
			maPhong = txtMaPhong.getText().trim();
		if (txtmoTa.getText().trim() != null)
			moTa = txtmoTa.getText().trim();
		loaiPhong = cboLoaiPhong.getSelectedItem().toString();

		if (txtSoGiuong.getText().trim() != null)
			soGiuong = txtSoGiuong.getText().trim();
		if (txtSoGiuong.getText().trim() != null)
			soNguoi = txtSoNguoi.getText().trim();
		if (txtGiaPhong.getText().trim() != null)
			gia = txtGiaPhong.getText().trim();
		ArrayList<Phong> dsPhongTim = qlp.timPhongTheoTatCaGomTinhTrangTra(maPhong, gia, soGiuong, soNguoi, moTa,
				loaiPhong);
		if(kq == JOptionPane.YES_OPTION) {
			if (dsPhongTim.size() == 0) {
				goiDanhSachPhong(p, b4, qlp.layTatCaCacPhongGomTinhTrangTra());
			}else {
				goiDanhSachPhong(p, b4, dsPhongTim);
			}
		}
	}
	public void inHoaDon() {
		JLabel lblMaHD,lblMaNV,lblMaKhachHang;
		JPanel p = new JPanel();
		Box bMain,b,b1,b2,b12;
		p.setBackground(Color.WHITE);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		int row = tablePDP.getRowCount()-1;
		int rowP = table.getRowCount();
		p.add(bMain = Box.createVerticalBox());
		bMain.add(b = Box.createHorizontalBox());
		b.add(new JLabel(new ImageIcon(".\\image\\everestBill.png")));
		bMain.add(b12 = Box.createHorizontalBox());
		b12.add(b1 = Box.createVerticalBox());
		b1.add(b = Box.createHorizontalBox());
		b.add(lblMaHD = new JLabel("Mã HD: "+modelTablePDP.getValueAt(row, 0).toString()+"    "));
		b1.add(Box.createVerticalStrut(20));
		b1.add(b = Box.createHorizontalBox());
		b.add(lblMaNV = new JLabel("Mã NV: " + GUIDangNhap.ma+"      "));
		b1.add(Box.createVerticalStrut(20));
		b1.add(b = Box.createHorizontalBox());
		b.add(lblMaKhachHang = new JLabel("Mã KH: "+modelTablePDP.getValueAt(row, 1).toString()+"  "));
		b1.add(Box.createVerticalStrut(20));
		b12.add(b2 = Box.createVerticalBox());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ngayHienTai = sdf.format(date);
		b2.add(b = Box.createHorizontalBox());
		b.add(new JLabel("Ngày lập HD: "+ngayHienTai+"      "));
		b2.add(Box.createVerticalStrut(20));
		b2.add(b = Box.createHorizontalBox());
		b.add(new JLabel("Tên NV: "+qlnv.layNhanVienTheoMa(GUIDangNhap.ma).getTenNhanVien()+"      "));
		b2.add(Box.createVerticalStrut(20));
		b2.add(b = Box.createHorizontalBox());
		b.add(new JLabel("Tên KH: "+modelTablePDP.getValueAt(row, 2).toString()+"      "));
		b2.add(Box.createVerticalStrut(20));
		bMain.add(b = Box.createHorizontalBox());
//		String header[] = {"Mã phòng","Giá","Loại phòng","Ngày nhận phòng","Ngày trả phòng"};
		DefaultTableModel modelTableIn= new DefaultTableModel(0,5);
		modelTableIn.addRow(new Object[] {
			"Mã phòng","Giá","Loại phòng","Ngày nhận phòng","Ngày trả phòng"});
		JTable tableIn = new JTable(modelTableIn);
		tableIn.setAutoCreateRowSorter(true);
		DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
		renderCenter.setHorizontalAlignment(JLabel.CENTER);
		JTableHeader headerTable = new JTableHeader();
		headerTable.setOpaque(false);
		tableIn.getTableHeader().setReorderingAllowed(false);
		for(int i = 0 ; i <5;++i) {
			tableIn.getColumnModel().getColumn(i).setCellRenderer(renderCenter);
		}
		int widthCol[]= {20,20,20,25,20}; 
		for(int i = 0 ; i <5;++i) {
			tableIn.getColumnModel().getColumn(i).setPreferredWidth(widthCol[i]*3);;
		}
		JScrollPane scrollIn = new JScrollPane(tableIn);
		bMain.add(scrollIn);
		scrollIn.setPreferredSize(new Dimension(500, 150));
		lblMaHD.setPreferredSize(lblMaKhachHang.getPreferredSize());
		lblMaNV.setPreferredSize(lblMaKhachHang.getPreferredSize());
		for(int i = 0 ; i < rowP;i++) {
			modelTableIn.addRow(new Object[] {
					modelTable.getValueAt(i, 0),
					modelTable.getValueAt(i, 1),
					modelTable.getValueAt(i, 5),
					modelTablePDP.getValueAt(row, 4),
					ngayHienTai
			});
		}
		bMain.add(Box.createVerticalStrut(10));
		bMain.add(b = Box.createHorizontalBox());
		double tongTien = 0;
		long soNgayO= date.getTime() - 
				qlctpdp.layCT_PhieuDatPhongTheoMaPhieuDatPhong(modelTablePDP.getValueAt(row, 0).toString())
				.getNgayDen().getTime();
		soNgayO = soNgayO / (1000 * 60 * 60 * 24);
		if(soNgayO >= 0 && soNgayO <1)
			soNgayO = 1;
		if(soNgayO < 0)
			soNgayO = 0;
		for (int i = 0; i < rowP; i++) {
			double gia = Double.parseDouble(modelTable.getValueAt(i, 1).toString());
			tongTien+= (soNgayO * gia);
		}
		DecimalFormat df = new DecimalFormat("#,###.# VND      ");
		b.add(new JLabel("Tổng tiền: "+df.format(tongTien)));
		bMain.add(Box.createVerticalStrut(10));
		bMain.add(b = Box.createHorizontalBox());
		b.add(new JLabel("Cảm ơn và hẹn gặp lại quý khách !      "));
		int kq = JOptionPane.showConfirmDialog(this, p,"IN HÓA ĐƠN",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
		if(kq == JOptionPane.YES_OPTION) {
			PrinterJob pj = PrinterJob.getPrinterJob();
			pj.setJobName("Hoadon_"+txtMaKhachHang.getText().trim()+"_"+ngayHienTai);

			pj.setPrintable(new Printable() {
				public int print(Graphics pg, PageFormat pf, int pageNum) {
					if (pageNum > 0) {
						return Printable.NO_SUCH_PAGE;
					}
					Graphics2D g2 = (Graphics2D) pg;
					g2.translate(pf.getImageableX(), pf.getImageableY());
					p.paint(g2);
					return Printable.PAGE_EXISTS;
				}
			});
			if (pj.printDialog() == false)
				return;
			try {
				pj.print();
			} catch (PrinterException ex) {
				// handle exception
			}
		}
	}
}
