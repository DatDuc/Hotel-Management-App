package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractButton;
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
import dao.QuanLyKhachHang_DAO;
import dao.QuanLyNhanVien_DAO;
import dao.QuanLyPhieuDatPhong_DAO;
import dao.QuanLyPhong_DAO;
import entity.CT_PhieuDatPhong;
import entity.KhachHang;
import entity.PhieuDatPhong;
import entity.Phong;

public class GUIDanhSachPhongChuyen extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GUIMenu menu;
	private Frame frameCha;
	private JPanel pNorth1;
	private JLabel lblTitle;
	private JPanel p;
	private TitledBorder titleBorderPhong;
	private TitledBorder titleBorderChuThich;
	private JButton btnDenHan1;
	private JButton btnDangSuDung1;
	private JButton btnDaDat1;
	private JLabel lblTongSoPhong;
	private JLabel tongSoPhong;
	private JLabel lblHinhTongSoPhong;
	private JButton btnQuayLai;
	private static JButton[] btnPhong1;
	public static String maPhong1;
	private static JButton[] btnPhong2;
	public static String maPhong2;
	public static String maNV;
	public static int maPhieu;
	private QuanLyPhong_DAO qlp = new QuanLyPhong_DAO();
	private QuanLyPhieuDatPhong_DAO qlpdp = new QuanLyPhieuDatPhong_DAO();
	private JLabel lblTitle2;
	private Box b4,b5;
	private JLabel lblMaKhacHang;
	private JComboBox<String> cboMaKhachHang;
	private JLabel lblGioiTinh;
	private JLabel lblTenKhachHang;
	private JLabel lblNgaySinh;
	private JDateChooser dcNgaySinh;
	private JLabel lblCMND;
	private JLabel lblSoDienThoai;
	private JTextField txtSoDienThoai;
	private JDateChooser dcNgayNhanPhong;
	private JDateChooser dcNgayTraPhong;
	private TitledBorder titleBorderKhachHang;
	private DefaultTableModel modelTable;
	private QuanLyKhachHang_DAO qlkh = new QuanLyKhachHang_DAO();
	private QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
	private JTable table;
	private JButton btnChuyenPhong;
	private JButton btnLamMoi;
	private TitledBorder titleBorderNut;
	private JButton btnHuyCTPhong;
	private JButton btnTimKiem;
	private DefaultTableModel modelTableCTDP;
	private JTable tableCTDP;
	private TitledBorder titleBorderCTDP;
	private QuanLyCT_PhieuDatPhong_DAO qlctpdp = new QuanLyCT_PhieuDatPhong_DAO();
	private DefaultTableModel modelTablePDP;
	private JTable tablePDP;
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtCMND;
	private JTextField txtGioiTinh;
	private JTextField txtMaPhong;
	private JLabel lblMoTa;
	private JLabel lblMaPhong;
	private JTextField txtSoGiuong;
	private JTextField txtMoTa;
	private JLabel lblGiaPhong;
	private JTextField txtGiaPhong;
	private JLabel lblSoNguoi;
	private JTextField txtSoNguoi;
	private JLabel lblLoaiPhong;
	private JTextField txtLoaiPhong;
	private TitledBorder titleBorderTTPhong;
	private DefaultTableModel modelTableCTDP2;
	private JTable tableCTDP2;
	private TitledBorder titleBorderCTDP2;
	private JButton btnTimKiem2;
	private JLabel lblSoGiuong;
	private JButton btnDongY;
	private TitledBorder titleBorderPDP;
	private TitledBorder titleBorderP;
	private JButton btnDaDat2;
	private JButton btnChuaDat;
	private JButton btnDangSuDung2;
	private JButton btnDenHan2;
	private AbstractButton btnDangChon;
	private static String countTruoc1=null;
	private static int count1 =1;
	private static String countSau1=null;
	private static String countTruoc2=null;
	private static int count2 =1;
	private static String countSau2=null;

	@SuppressWarnings("serial")
	public GUIDanhSachPhongChuyen(Frame cha) {
		frameCha = cha;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int rong = screenSize.width;
		int cao = screenSize.height;
		Box bMain, b123,b1, b2, b3, b;
		pNorth1 = new JPanel();
		pNorth1.add(lblTitle = new JLabel("DANH SÁCH PHÒNG KHÁCH SẠN"));
		add(bMain = Box.createVerticalBox());
		bMain.add(b123 = Box.createHorizontalBox());
		b123.add(b1 = Box.createVerticalBox());
		b1.add(b = Box.createHorizontalBox());
		b.add(pNorth1, BorderLayout.NORTH);
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblTitle.setForeground(new Color(0xFFAA00));
		b1.add(b = Box.createHorizontalBox());
		b.add(lblTongSoPhong = new JLabel("Tổng số phòng: "));
		lblTongSoPhong.setForeground(new Color(0xFFAA00));
//		lblTongSoPhong.setBounds(5, 0, 48, 48);
		lblTongSoPhong.setFont(new Font("SansSerif", Font.BOLD, 20));
		b.add(lblHinhTongSoPhong = new JLabel(new ImageIcon(".\\image\\tongPhong.gif")));
		lblHinhTongSoPhong.add(tongSoPhong = new JLabel(qlp.tongSoPhong() + ""));
		tongSoPhong.setForeground(new Color(0xFFAA00));
		tongSoPhong.setBounds(13, 0, 48, 48);
		tongSoPhong.setFont(new Font("SansSerif", Font.BOLD, 20));
		b1.add(b4 = Box.createHorizontalBox());
		p = new JPanel();
		goiDanhSachPhong1(p, b4, qlp.layTatCaCacPhongGomTinhTrangChuyen());
		b4.setPreferredSize(new Dimension(rong - 1000,600));
		b4.setBorder(titleBorderPhong = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Danh sách phòng"));
		titleBorderPhong.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderPhong.setTitleColor(new Color(0xFFAA00));
		titleBorderPhong.setTitlePosition(TitledBorder.ABOVE_TOP);
		b1.add(b = Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(50));
		b1.add(b = Box.createHorizontalBox());
		JLabel lblDangSuDung, lblTrong, lblDenHan;
//		b.add(mauXanh = new JPanel());
//		mauXanh.setBackground(Color.decode("#73d669"));
		b.add(btnDaDat1 = new JButton(new ImageIcon(".\\image\\blueRound26.png")));
		btnDaDat1.setContentAreaFilled(false);
		btnDaDat1.setFocusPainted(false);
		btnDaDat1.setBorder(BorderFactory.createEmptyBorder());
		b.add(lblTrong = new JLabel("Phòng đang được đặt"));
		lblTrong.setFont(new Font("SansSerif", Font.ITALIC, 13));
//		b.add(mauHong = new JPanel());
//		mauHong.setBackground(Color.decode("#ec4f82"));
		b.add(btnDangSuDung1 = new JButton(new ImageIcon(".\\image\\pinkRound26.png")));
		btnDangSuDung1.setContentAreaFilled(false);
		btnDangSuDung1.setFocusPainted(false);
		btnDangSuDung1.setBorder(BorderFactory.createEmptyBorder());
		b.add(lblDangSuDung = new JLabel("Phòng đang sử dụng"));
		lblDangSuDung.setFont(new Font("SansSerif", Font.ITALIC, 13));
//		b.add(mauDo = new JPanel());
//		mauDo.setBackground(Color.decode("#cc2701"));
		b.add(btnDenHan1 = new JButton(new ImageIcon(".\\image\\redRound26.png")));
		btnDenHan1.setContentAreaFilled(false);
		btnDenHan1.setFocusPainted(false);
		btnDenHan1.setBorder(BorderFactory.createEmptyBorder());
		b.add(lblDenHan = new JLabel("Phòng đến hạn trả"));
		lblDenHan.setFont(new Font("SansSerif", Font.ITALIC, 13));
		b.setBorder(titleBorderChuThich = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Tìm kiếm"));
		titleBorderChuThich.setTitleColor(new Color(0xFFAA00));
		titleBorderChuThich.setTitleFont(new Font("SansSerif", Font.BOLD, 13));
		b.setToolTipText("Chọn để lọc tình trạng phòng!");
		b.add(btnTimKiem = new JButton("Tìm", new ImageIcon(".\\image\\search32.png")));
		btnTimKiem.addActionListener(this);
		String headerCTDP[] = { "Mã phiếu", "Mã phòng", "Ngày đến", "Ngày đi" };
		modelTableCTDP = new DefaultTableModel(headerCTDP, 0);
		tableCTDP = new JTable(modelTableCTDP) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}

			public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
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
		tableCTDP.setAutoCreateRowSorter(true);
		DefaultTableCellRenderer renderCenterCTDP = new DefaultTableCellRenderer();
		renderCenterCTDP.setHorizontalAlignment(JLabel.CENTER);
		JTableHeader headerTableCTDP = new JTableHeader();
		headerTableCTDP.setOpaque(false);
		tableCTDP.getTableHeader().setReorderingAllowed(false);
		for (int i = 0; i < 4; ++i) {
			tableCTDP.getColumnModel().getColumn(i).setCellRenderer(renderCenterCTDP);
		}
		int widthColCTDP[] = { 10, 10, 10, 10 };
		for (int i = 0; i < 4; ++i) {
			tableCTDP.getColumnModel().getColumn(i).setPreferredWidth(widthColCTDP[i] * 3);
			;
		}
		JScrollPane scrollCTDV = new JScrollPane(tableCTDP);
		scrollCTDV.setBorder(BorderFactory.createLineBorder(Color.RED));
		b1.add(b=Box.createHorizontalBox());
		b.add(scrollCTDV);
		scrollCTDV.setBorder(titleBorderCTDP = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Đang đặt của phòng"));
		titleBorderCTDP.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderCTDP.setTitleColor(new Color(0xFFAA00));
		scrollCTDV.setPreferredSize(new Dimension(300, 300));
		b1.setPreferredSize(new Dimension(rong-1000, cao-320));
		b123.add(b2 = Box.createVerticalBox());
		b2.add(b = Box.createHorizontalBox());
		JPanel pNorth2 = new JPanel();
		pNorth2.add(lblTitle2 = new JLabel("CHUYỂN PHÒNG"));
		b.add(pNorth2, BorderLayout.NORTH);
		lblTitle2.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTitle2.setForeground(new Color(0xFFAA00));
		b2.add(b = Box.createHorizontalBox());
		Box bKH,bKH1,bKH2;
		b.add(bKH1 = Box.createVerticalBox());
		bKH1.add(Box.createVerticalStrut(20));
		bKH1.add(bKH = Box.createHorizontalBox());
		bKH.add(lblMaKhacHang = new JLabel("Mã khách hàng: "));
		bKH.add(txtMaKhachHang = new JTextField());
		bKH1.add(Box.createVerticalStrut(20));
		bKH1.add(bKH = Box.createHorizontalBox());
		bKH.add(lblTenKhachHang= new JLabel("Tên khách hàng: "));
		bKH.add(txtTenKhachHang= new JTextField());
		bKH1.add(Box.createVerticalStrut(20));
		bKH1.add(bKH = Box.createHorizontalBox());
		bKH.add(lblCMND = new JLabel("CMND: "));
		bKH.add(txtCMND= new JTextField());
		bKH1.add(Box.createVerticalStrut(20));
		b.add(bKH2 = Box.createVerticalBox());
		bKH2.add(Box.createVerticalStrut(20));
		bKH2.add(bKH = Box.createHorizontalBox());
		bKH.add(lblGioiTinh = new JLabel("Giới tính: "));
		bKH.add(txtGioiTinh = new JTextField());
		bKH2.add(Box.createVerticalStrut(20));
		bKH2.add(bKH = Box.createHorizontalBox());
		bKH.add(lblSoDienThoai = new JLabel("Số điện thoại: "));
		bKH.add(txtSoDienThoai = new JTextField());
		bKH2.add(Box.createVerticalStrut(20));
		bKH2.add(bKH = Box.createHorizontalBox());
		bKH.add(lblNgaySinh = new JLabel("Ngày sinh"));
		bKH.add(dcNgaySinh = new JDateChooser());
		bKH2.add(Box.createVerticalStrut(20));
		dcNgaySinh.setDateFormatString("yyyy-MM-dd");
		lblMaKhacHang.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblTenKhachHang.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblCMND.setPreferredSize(lblTenKhachHang.getPreferredSize());
		bKH1.setPreferredSize(new Dimension(220, 130));
		lblGioiTinh.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblSoDienThoai.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblSoDienThoai.getPreferredSize());
		b.setBorder(titleBorderKhachHang = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Thông tin khách hàng"));
		titleBorderKhachHang.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderKhachHang.setTitleColor(new Color(0xFFAA00));
		b2.add(Box.createVerticalStrut(10));
		b2.add(b = Box.createHorizontalBox());
		Box  bP,bP1,bP2;
		b.add(bP1 = Box.createVerticalBox());
		bP1.add(Box.createVerticalStrut(20));
		bP1.add(bP = Box.createHorizontalBox());
		bP.add(lblMaPhong = new JLabel("Mã phòng: "));
		bP.add(txtMaPhong = new JTextField());
		bP1.add(Box.createVerticalStrut(20));
		bP1.add(bP = Box.createHorizontalBox());
		bP.add(lblSoGiuong = new JLabel("Số giường: "));
		bP.add(txtSoGiuong = new JTextField());
		bP1.add(Box.createVerticalStrut(20));
		bP1.add(bP = Box.createHorizontalBox());
		bP.add(lblMoTa = new JLabel("Mô tả: "));
		bP.add(txtMoTa = new JTextField());
		bP1.add(Box.createVerticalStrut(20));
		b.add(bP2 = Box.createVerticalBox());
		bP2.add(Box.createVerticalStrut(20));
		bP2.add(bP = Box.createHorizontalBox());
		bP.add(lblGiaPhong = new JLabel("Giá phòng: "));
		bP.add(txtGiaPhong = new JTextField());
		bP2.add(Box.createVerticalStrut(20));
		bP2.add(bP = Box.createHorizontalBox());
		bP.add(lblSoNguoi = new JLabel("Số người: "));
		bP.add(txtSoNguoi = new  JTextField());
		bP2.add(Box.createVerticalStrut(20));
		bP2.add(bP = Box.createHorizontalBox());
		bP.add(lblLoaiPhong = new JLabel("Loại phòng: "));
		bP.add(txtLoaiPhong = new JTextField());
		bP2.add(Box.createVerticalStrut(20));
		lblMaPhong.setPreferredSize(lblSoGiuong.getPreferredSize());
		lblSoGiuong.setPreferredSize(lblSoGiuong.getPreferredSize());
		lblMoTa.setPreferredSize(lblSoGiuong.getPreferredSize());
		lblGiaPhong.setPreferredSize(lblLoaiPhong.getPreferredSize());
		lblSoNguoi.setPreferredSize(lblLoaiPhong.getPreferredSize());
		lblLoaiPhong.setPreferredSize(lblLoaiPhong.getPreferredSize());
		b.setBorder(titleBorderTTPhong = new TitledBorder(BorderFactory.createLineBorder(Color.red),"Thông tin phòng"));
		titleBorderTTPhong.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderTTPhong.setTitleColor(new Color(0xFFAA00));
		String headerPDP[] = {"Mã phiếu đặt","Ngày lập phiếu đặt","Ngày đến","Ngày đi"};
		modelTablePDP = new DefaultTableModel(headerPDP, 0);
		tablePDP = new JTable(modelTablePDP) {
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
		for(int i = 0 ; i <4;++i) {
			tablePDP.getColumnModel().getColumn(i).setCellRenderer(renderCenterPDP);
		}
		int widthColPDP[]= {15,20,10,10}; 
		for(int i = 0 ; i <4;++i) {
			tablePDP.getColumnModel().getColumn(i).setPreferredWidth(widthColPDP[i]*3);;
		}
		JScrollPane scrollPDP = new JScrollPane(tablePDP);
		scrollPDP.setBorder(titleBorderPDP = new TitledBorder(BorderFactory.createLineBorder(Color.RED),"Phiếu đặt phòng"));
		titleBorderPDP.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderPDP.setTitleColor(new Color(0xFFAA00));
		b2.add(Box.createVerticalStrut(10));
		b2.add(scrollPDP);
		scrollPDP.setPreferredSize(new Dimension(rong-1300, 150));
		JPanel pDongY = new JPanel();
		b2.add(Box.createVerticalStrut(15));
		pDongY.add(btnDongY = new JButton("Đồng ý phòng muốn chuyển",new ImageIcon(".\\image\\accepticon32.png")));
		b.add(pDongY);
		b2.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b.add(btnChuyenPhong = new JButton("Chuyển phòng", new ImageIcon(".\\image\\changeRoom32.png")));
		b.add(Box.createHorizontalStrut(10));
		b.add(btnLamMoi = new JButton("Làm mới", new ImageIcon(".\\image\\reload32.png")));
		b.add(Box.createHorizontalStrut(20));
		b.add(btnQuayLai = new JButton("Quay lại", new ImageIcon(".\\image\\logout32.png")));
		btnQuayLai.setBackground(Color.red);
		b.add(Box.createHorizontalStrut(5));
		b.setBorder(titleBorderNut = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Chọn thao tác"));
		titleBorderNut.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderNut.setTitleColor(new Color(0xFFAA00));
		b2.add(Box.createVerticalStrut(10));
		b2.add(b = Box.createHorizontalBox());
		JLabel lblDangChon;
		JPanel pDC = new JPanel();
		b.add(pDC);
		pDC.add(btnDangChon = new JButton(new ImageIcon(".\\image\\yellowRound32.png")));
		btnDangChon.setContentAreaFilled(false);
		btnDangChon.setFocusPainted(false);
		btnDangChon.setBorder(BorderFactory.createEmptyBorder());
		pDC.add(lblDangChon = new JLabel("Phòng đang được chọn"));
		lblDangChon.setFont(new Font("SansSerif", Font.ITALIC, 18));
		b123.add(b3 = Box.createVerticalBox());
		b3.add(b = Box.createHorizontalBox());
		b3.add(b5 = Box.createHorizontalBox());
		p = new JPanel();
		goiDanhSachPhong2(p, b5, qlp.layTatCaCacPhongGomTinhTrang());
		b5.setPreferredSize(new Dimension(rong - 1000, cao));
		b5.setBorder(titleBorderPhong = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Danh sách phòng chuyển"));
		titleBorderPhong.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderPhong.setTitleColor(new Color(0xFFAA00));
		titleBorderPhong.setTitlePosition(TitledBorder.ABOVE_TOP);
//		b3.add(b = Box.createHorizontalBox());
//		JLabel lblDangSuDung2, lblTrong2, lblDenHan2;
//		b.add(btnChuaDat = new JButton(new ImageIcon(".\\image\\greenRound26.png")));
//		btnChuaDat.setContentAreaFilled(false);
//		btnChuaDat.setFocusPainted(false);
//		btnChuaDat.setBorder(BorderFactory.createEmptyBorder());
//		b.add(lblTrong2 = new JLabel("Phòng trống"));
//		lblTrong2.setFont(new Font("SansSerif", Font.ITALIC, 12));
//		b.add(btnDangSuDung2 = new JButton(new ImageIcon(".\\image\\pinkRound26.png")));
//		btnDangSuDung2.setContentAreaFilled(false);
//		btnDangSuDung2.setFocusPainted(false);
//		btnDangSuDung2.setBorder(BorderFactory.createEmptyBorder());
//		b.add(lblDangSuDung2 = new JLabel("Phòng đang sử dụng"));
//		lblDangSuDung2.setFont(new Font("SansSerif", Font.ITALIC, 12));
//		b.add(btnDenHan2 = new JButton(new ImageIcon(".\\image\\redRound26.png")));
//		btnDenHan2.setContentAreaFilled(false);
//		btnDenHan2.setFocusPainted(false);
//		btnDenHan2.setBorder(BorderFactory.createEmptyBorder());		
//		b.add(lblDenHan2 = new JLabel("Phòng đến hạn trả"));
//		lblDenHan2.setFont(new Font("SansSerif", Font.ITALIC, 12));
		b.setBorder(titleBorderChuThich = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Tìm kiếm"));
		titleBorderChuThich.setTitleColor(new Color(0xFFAA00));
		titleBorderChuThich.setTitleFont(new Font("SansSerif", Font.BOLD, 15));
//		b.add(btnDaDat2= new JButton(new ImageIcon(".\\image\\blueRound26.png")));
//		btnDaDat2.setContentAreaFilled(false);
//		btnDaDat2.setFocusPainted(false);
//		btnDaDat2.setBorder(BorderFactory.createEmptyBorder());
//		b.add(Box.createHorizontalStrut(5));
//		b.add(lblDangDuocDat= new JLabel("Phòng đang được đặt"));
//		lblDangDuocDat.setFont(new Font("SansSerif", Font.ITALIC, 12));
		b.setToolTipText("Chọn để lọc tình trạng phòng!");
		b.add(btnTimKiem2 = new JButton("Tìm kiếm phòng", new ImageIcon(".\\image\\search32.png")));
		String header[] = { "Mã phòng", "Giá phòng", "Số giường", "Số người", "Mô tả", "Loại phòng" };
		modelTable = new DefaultTableModel(header, 0);
		table = new JTable(modelTable) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}

			public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
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
		for (int i = 0; i < 6; ++i) {
			table.getColumnModel().getColumn(i).setCellRenderer(renderCenter);
		}
		int widthCol[] = { 20, 20, 20, 20, 20, 20 };
		for (int i = 0; i < 6; ++i) {
			table.getColumnModel().getColumn(i).setPreferredWidth(widthCol[i] * 3);
			;
		}
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBorder(titleBorderP = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Phòng muốn chuyển"));
		b3.add(b = Box.createHorizontalBox());
		b.add(scroll);
		titleBorderP.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderP.setTitleColor(new Color(0xFFAA00));
		scroll.setPreferredSize(new Dimension(200, 100));
		String headerCTDP2[] = { "Mã phiếu", "Mã phòng", "Ngày đến", "Ngày đi" };
		modelTableCTDP2 = new DefaultTableModel(headerCTDP2, 0);
		tableCTDP2 = new JTable(modelTableCTDP2) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}

			public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
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
		tableCTDP2.setAutoCreateRowSorter(true);
		DefaultTableCellRenderer renderCenterCTDP2 = new DefaultTableCellRenderer();
		renderCenterCTDP.setHorizontalAlignment(JLabel.CENTER);
		JTableHeader headerTableCTDP2 = new JTableHeader();
		headerTableCTDP2.setOpaque(false);
		tableCTDP2.getTableHeader().setReorderingAllowed(false);
		for (int i = 0; i < 4; ++i) {
			tableCTDP2.getColumnModel().getColumn(i).setCellRenderer(renderCenterCTDP2);
		}
		int widthColCTDP2[] = { 10, 10, 10, 10 };
		for (int i = 0; i < 4; ++i) {
			tableCTDP2.getColumnModel().getColumn(i).setPreferredWidth(widthColCTDP2[i] * 3);
			;
		}
		JScrollPane scrollCTDV2 = new JScrollPane(tableCTDP2);
		scrollCTDV2.setBorder(BorderFactory.createLineBorder(Color.RED));
		b3.add(b = Box.createHorizontalBox());
		b.add(scrollCTDV2);
		scrollCTDV2.setPreferredSize(new Dimension(600, 300));
		scrollCTDV2.setBorder(titleBorderCTDP2 = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Đang đặt của phòng muốn chuyển"));
		titleBorderCTDP2.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderCTDP2.setTitleColor(new Color(0xFFAA00));
		b3.setPreferredSize(new Dimension(560, 400));
		b1.setPreferredSize(new Dimension(560, 400));
		txtMaKhachHang.setEditable(false);
		txtMaPhong.setEditable(false);
		txtTenKhachHang.setEditable(false);
		txtGioiTinh.setEditable(false);
		txtCMND.setEditable(false);
		txtSoDienThoai.setEditable(false);
		txtMoTa.setEditable(false);
		dcNgaySinh.setEnabled(false);
		txtGiaPhong.setEditable(false);
		txtSoGiuong.setEditable(false);
		txtSoNguoi.setEditable(false);
		txtLoaiPhong.setEditable(false);
		btnQuayLai.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTimKiem2.addActionListener(this);
		btnDongY.addActionListener(this);
		btnChuyenPhong.addActionListener(this);
		btnDaDat1.addActionListener(this);
//		btnDaDat2.addActionListener(this);
		btnDangSuDung1.addActionListener(this);
//		btnDangSuDung2.addActionListener(this);
//		btnChuaDat.addActionListener(this);
		btnDenHan1.addActionListener(this);
//		btnDenHan2.addActionListener(this);
		btnDongY.setVisible(false);
		scrollCTDV.setVisible(false);
		scrollCTDV2.setVisible(false);
	}

	public void taoJButton(JButton btn, Dimension kichThuoc) {
		btn.setPreferredSize(kichThuoc);
		btn.setMaximumSize(kichThuoc);
		btn.setMinimumSize(kichThuoc);
	}

	public void goiDanhSachPhong1(JPanel p, Box b1, ArrayList<Phong> dsTatCaPhong) {
		b1.removeAll();
		b1.revalidate();
		b1.repaint();
		int y = qlp.tongSoPhong() / 3 + 1;
		DecimalFormat df = new DecimalFormat("#,###.# VND");
		ArrayList<String> dsThongTinPhong = new ArrayList<String>();
		for (Phong phong : dsTatCaPhong) {
			String mauSac = "";
			if (phong.getTinhTrangPhong() == 0) { // chưa đặt
				mauSac = "#77d56c";
			}else if(phong.getTinhTrangPhong() == 3) {// da dat
				mauSac="#0080FF";		
			}else if (phong.getTinhTrangPhong() == 1) { // đăng sử dụng
				mauSac = "#ea5483";
			} else if (phong.getTinhTrangPhong() == 2) { // đến hạn trả
				mauSac = "#e33309";
			}
			dsThongTinPhong.add("<html><center>Phòng: " + phong.getMaPhong() + "<br/>" + "Mô tả: " + phong.getMoTa()
					+ "<br/>" + "Giá: " + df.format(phong.getGiaPhong()) + "<br/>" + "Loại phòng: "
					+ qlp.layTenLoaiPhong(phong.getLoaiPhong().getMaLoai()).getTenLoai() + "<br/>" + "Số giường: "
					+ phong.getSoGiuong() + "<br/>" + "Số người:" + phong.getSoNguoi() + "<!--color" + mauSac
					+ "color-->" + "<!--id" + phong.getMaPhong() + "id-->" + "</html>");
		}
		String[] thongTinPhong;
		thongTinPhong = dsThongTinPhong.toArray(new String[0]);
		btnPhong1 = new JButton[dsThongTinPhong.size()];
		p = new JPanel();
		p.revalidate();
		p.repaint();
		p.setOpaque(false);
		p.setLayout(new GridLayout(y, y+1, 20, 30));
		try {
			for (int i = 0; i < thongTinPhong.length; i++) {
				btnPhong1[i] = new JButton();
				btnPhong1[i].setText(thongTinPhong[i]);
				int dau = thongTinPhong[i].indexOf("<!--color");
				int cuoi = thongTinPhong[i].indexOf("color-->");
				String mauSac = thongTinPhong[i].substring(dau + 9, cuoi);
				btnPhong1[i].setBackground(Color.decode(mauSac));
				p.add(btnPhong1[i]);
				btnPhong1[i].addActionListener(this);
				taoJButton(btnPhong1[i], new Dimension(40, 130));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		b1.add(new JScrollPane(p));
	}
	public void goiDanhSachPhong2(JPanel p, Box b1, ArrayList<Phong> dsTatCaPhong) {
		b1.removeAll();
		b1.revalidate();
		b1.repaint();
		int y = qlp.tongSoPhong() / 3 + 1;
		DecimalFormat df = new DecimalFormat("#,###.# VND");
		ArrayList<String> dsThongTinPhong = new ArrayList<String>();
		for (Phong phong : dsTatCaPhong) {
			String mauSac = "";
			if (phong.getTinhTrangPhong() == 0) { // chưa đặt
				mauSac = "#77d56c";
			}else if(phong.getTinhTrangPhong() == 3) {// da dat
				mauSac="#0080FF";		
			}else if (phong.getTinhTrangPhong() == 1) { // đăng sử dụng
				mauSac = "#ea5483";
			} else if (phong.getTinhTrangPhong() == 2) { // đến hạn trả
				mauSac = "#e33309";
			}
			dsThongTinPhong.add("<html><center>Phòng: " + phong.getMaPhong() + "<br/>" + "Mô tả: " + phong.getMoTa()
					+ "<br/>" + "Giá: " + df.format(phong.getGiaPhong()) + "<br/>" + "Loại phòng: "
					+ qlp.layTenLoaiPhong(phong.getLoaiPhong().getMaLoai()).getTenLoai() + "<br/>" + "Số giường: "
					+ phong.getSoGiuong() + "<br/>" + "Số người:" + phong.getSoNguoi() + "<!--color" + mauSac
					+ "color-->" + "<!--id" + phong.getMaPhong() + "id-->" + "</html>");
		}
		String[] thongTinPhong;
		thongTinPhong = dsThongTinPhong.toArray(new String[0]);
		btnPhong2 = new JButton[dsThongTinPhong.size()];
		p = new JPanel();
		p.revalidate();
		p.repaint();
		p.setOpaque(false);
		p.setLayout(new GridLayout(y, y+1, 20, 30));
		try {
			for (int i = 0; i < thongTinPhong.length; i++) {
				btnPhong2[i] = new JButton();
				btnPhong2[i].setText(thongTinPhong[i]);
				int dau = thongTinPhong[i].indexOf("<!--color");
				int cuoi = thongTinPhong[i].indexOf("color-->");
				String mauSac = thongTinPhong[i].substring(dau + 9, cuoi);
				btnPhong2[i].setBackground(Color.decode(mauSac));
				p.add(btnPhong2[i]);
				btnPhong2[i].addActionListener(this);
				taoJButton(btnPhong2[i], new Dimension(40, 130));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		b1.add(new JScrollPane(p));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		for (int i = 0; i < btnPhong1.length; i++) {
			if (o.equals(btnPhong1[i])) {
				count1++;
				int dau = btnPhong1[i].getText().indexOf("<!--id");
				int cuoi = btnPhong1[i].getText().indexOf("id-->");
				String ma = btnPhong1[i].getText().substring(dau + 6, cuoi);
				Phong phong = qlp.timPhongTheoMaPhong(ma);
				xoaDongTrongBangCTPDP();
				ArrayList<CT_PhieuDatPhong> dsCTPDP = qlctpdp.layCT_PhieuDatPhongTheoMaPhong(ma);
				CT_PhieuDatPhong ctpdp = dsCTPDP.get(0);
				themDongVaoBangCTPDP(ctpdp);
				int row = tableCTDP.getRowCount()-1;
				tableCTDP.getSelectionModel().setSelectionInterval(row, row);
				txtMaKhachHang.setText("");
				txtCMND.setText("");
				txtTenKhachHang.setText("");
				txtSoDienThoai.setText("");
				txtGioiTinh.setText("");
				dcNgaySinh.setDate(null);
				xoaDongTrongBangPDP();
				DecimalFormat df = new DecimalFormat("###.#");
				txtMaPhong.setText(phong.getMaPhong());
				txtGiaPhong.setText(df.format(phong.getGiaPhong()));
				txtSoGiuong.setText(phong.getSoGiuong()+"");
				txtSoNguoi.setText(phong.getSoNguoi()+"");
				txtMoTa.setText(phong.getMoTa());
				txtLoaiPhong.setText(qlp.layTenLoaiPhong(phong.getLoaiPhong().getMaLoai()).getTenLoai());
				PhieuDatPhong pdp = qlpdp.layPhieuDatPhongTheoMaCT_PhieuDatPhong(ctpdp.getMaCT_PhieuDatPhong());
				themDongVaoBangPDP(pdp);
				KhachHang kh = qlkh.layKhachHangTheoMaPhieuDatPhong(pdp.getMaPhieuDatPhong()+"");
				txtMaKhachHang.setText(kh.getMaKhachHang());
				txtTenKhachHang.setText(kh.getTenKhachHang());
				txtGioiTinh.setText(kh.getGioiTinh());
				txtSoDienThoai.setText(kh.getSoDienThoai());
				txtCMND.setText(kh.getcMND());
				dcNgaySinh.setDate(kh.getNgaySinh());
				
				
				if(count1 ==1) {
					if(ma.equals(txtMaPhong.getText().trim()))
						btnPhong1[1].setEnabled(false);
				}
				
				else {
					countTruoc1=countSau1;
					countSau1=ma;
					if(ma.equals(txtMaPhong.getText().trim())){
						btnPhong1[i].setBackground(Color.decode("#FFCC00"));
					}
					for(int j = 0 ;j < btnPhong1.length;j++) {
						int dau1 = btnPhong1[j].getText().indexOf("<!--id");
						int cuoi1 = btnPhong1[j].getText().indexOf("id-->");
						String ma1 = btnPhong1[j].getText().substring(dau1 + 6, cuoi1);
						if(ma1.equals(countTruoc1) && !ma1.equals(countSau1)) {
							ArrayList<Phong> dsPhong = qlp.timPhongTheoTatCaGomTinhTrangChuyen(countTruoc1,"","","","","");
							Phong p =dsPhong.get(0);
							if (p.getTinhTrangPhong() == 0) { // chưa đặt
								btnPhong1[j].setBackground(Color.decode("#77d56c"));
							}else if(p.getTinhTrangPhong() == 3) {// da dat
								btnPhong1[j].setBackground(Color.decode("#0080FF"));
							}else if (p.getTinhTrangPhong() == 1) { // đăng sử dụng
								btnPhong1[j].setBackground(Color.decode("#ea5483"));
							} else if (p.getTinhTrangPhong() == 2) { // đến hạn trả
								btnPhong1[j].setBackground(Color.decode("#e33309"));
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < btnPhong2.length; i++) {
			if (o.equals(btnPhong2[i])) {
				count2++;
				int dau = btnPhong2[i].getText().indexOf("<!--id");
				int cuoi = btnPhong2[i].getText().indexOf("id-->");
				String ma = btnPhong2[i].getText().substring(dau + 6, cuoi);
				if(count2 ==1) {
//					countTruoc=countSau;
//					countSau=ma;
					xoaDongTrongBang();
					Phong phong = qlp.timPhongTheoMaPhong(ma);
					themDongVaoBang(phong);		
					if(ma.equals(modelTable.getValueAt(table.getRowCount()-1,0).toString()))
						btnPhong2[i].setEnabled(false);
				}else {
					countTruoc2=countSau2;
					countSau2=ma;
					xoaDongTrongBangCTPDP2();
					ArrayList<CT_PhieuDatPhong> dsCTPDP = qlctpdp.layCT_PhieuDatPhongTheoMaPhong(ma);
					for (CT_PhieuDatPhong ct_PhieuDatPhong : dsCTPDP) {
						themDongVaoBangCTPDP2(ct_PhieuDatPhong);
					}
					xoaDongTrongBang();
					Phong phong = qlp.timPhongTheoMaPhong(ma);
					themDongVaoBang(phong);		
					if(ma.equals(modelTable.getValueAt(table.getRowCount()-1,0).toString()))
						btnPhong2[i].setBackground(Color.decode("#FFCC00"));
					for(int j = 0 ;j < btnPhong2.length;j++) {
						int dau1 = btnPhong2[j].getText().indexOf("<!--id");
						int cuoi1 = btnPhong2[j].getText().indexOf("id-->");
						String ma1 = btnPhong2[j].getText().substring(dau1 + 6, cuoi1);
						if(ma1.equals(countTruoc2) && !ma1.equals(countSau2))
							btnPhong2[j].setBackground(Color.decode("#77d56c"));
					}
				}
			}
		}
		if (o.equals(btnQuayLai)) {
			String ma = GUIDangNhap.ma;
			if(ma.equals("NV000001")) {
				frameCha.dispose();
				menu = new GUIMenu(1);
				menu.setVisible(true);
			}else {
				frameCha.dispose();
				GUIMenuDanhChoNhanVien menuNV = new GUIMenuDanhChoNhanVien(qlnv.layNhanVienTheoMa(ma).getTenNhanVien());
				menuNV.setVisible(true);
			}
		} else if (o.equals(btnLamMoi)) {
			lamMoiTextFields();
			xoaDongTrongBangCTPDP();
			xoaDongTrongBangCTPDP2();
			xoaDongTrongBangPDP();
			xoaDongTrongBang();
		} else if (o.equals(btnHuyCTPhong)) {
			int row = table.getSelectedRow();
			modelTable.removeRow(row);
		} else if (o.equals(btnTimKiem)) {
			timPhongChuyen1();
		}else if(o.equals(btnDongY)) {
			int row = -1;
			row = tableCTDP.getSelectedRow();
			if(row == -1)
				JOptionPane.showMessageDialog(this, "Vui lòng chọn chi tiết phiếu đặt phòng muốn chuyển");
			else {
				PhieuDatPhong pdp = qlpdp.layPhieuDatPhongTheoMaCT_PhieuDatPhong(Integer.parseInt(modelTableCTDP.getValueAt(row, 0).toString()));
				xoaDongTrongBangPDP();	
				themDongVaoBangPDP(pdp);
				KhachHang kh = qlkh.layKhachHangTheoMaPhieuDatPhong(modelTablePDP.getValueAt(tablePDP.getRowCount()-1,0).toString());
				txtMaKhachHang.setText(kh.getMaKhachHang());
				txtTenKhachHang.setText(kh.getTenKhachHang());
				txtGioiTinh.setText(kh.getGioiTinh());
				txtSoDienThoai.setText(kh.getSoDienThoai());
				txtCMND.setText(kh.getcMND());
				dcNgaySinh.setDate(kh.getNgaySinh());
			}
		}else if(o.equals(btnChuyenPhong)) {
			int rowPDP = 0;
			int rowCTPDP1 = tableCTDP.getSelectedRow();
			int rowP= table.getRowCount();
			rowPDP=tablePDP.getRowCount();
			if(rowPDP == 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng muốn chuyển đi");
			}else if(rowP == 0){
				JOptionPane.showMessageDialog(this, "Vui lòng chọn phong muốn chuyển tới");
			}else {
				int kq = JOptionPane.showConfirmDialog(this,"Bạn có muốn chuyển phòng không","Nhắc nhở",JOptionPane.YES_NO_OPTION);
				if(kq == JOptionPane.YES_OPTION) {
					boolean flag = true;
					String ngayDen = modelTablePDP.getValueAt(rowPDP-1, 2).toString();
					String ngayDi = modelTablePDP.getValueAt(rowPDP-1, 3).toString();
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String ngayHienTai = sdf.format(date);
					String maPhongDaDat = "";
					for (int i = 0; i < tableCTDP2.getRowCount(); i++) {
						if (qlctpdp.layCT_PhieuDatPhongTheoThoiGianPhong(modelTableCTDP2.getValueAt(i, 1).toString(), ngayDen,
								ngayDi).size() > 0) {
							flag = false;
							maPhongDaDat += modelTableCTDP2.getValueAt(i, 1).toString() + " ";
							break;
						}
					}
					if (flag == false) {
						JOptionPane.showMessageDialog(this, "Phòng " + maPhongDaDat + " đã được đặt ");
					}else {
						String maPhongDi = modelTableCTDP.getValueAt(rowCTPDP1, 1).toString();
						String maPhongDen = modelTable.getValueAt(rowP-1, 0).toString();
						String maPDP = modelTablePDP.getValueAt(rowPDP-1, 0).toString();
						if(
						qlctpdp.suaNgayTraPhongCT_PhieuDatPhongTheoMaCT_PDP(modelTableCTDP.getValueAt(rowCTPDP1, 0).toString())&&
						qlctpdp.taoCT_PhieuDatPhong(Integer.parseInt(maPDP), maPhongDen, ngayHienTai, ngayDi)) {
							JOptionPane.showMessageDialog(this, "Chuyển phòng từ "+maPhongDi+" sang phòng "+maPhongDen+" thành công");
							goiDanhSachPhong1(dcNgayNhanPhong, b4, qlp.layTatCaCacPhongGomTinhTrangChuyen());
							goiDanhSachPhong2(dcNgayNhanPhong, b5, qlp.layTatCaCacPhongGomTinhTrang());
							xoaDongTrongBang();
							xoaDongTrongBangCTPDP();
							xoaDongTrongBangCTPDP2();
							xoaDongTrongBangPDP();
							lamMoiTextFields();
						}
					}
				}
			}
		}else if(o.equals(btnTimKiem2)) {
			timPhongChuyen2();
		}else if(o.equals(btnChuaDat)) {
			ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoTinhTrang("Chưa đặt");
			goiDanhSachPhong1(p, b5, dsPhong);
		}else if(o.equals(btnDaDat1)) {
			ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoTinhTrang("Đã đặt");
			goiDanhSachPhong1(p, b4, dsPhong);
		}else if(o.equals(btnDangSuDung1)) {
			ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoTinhTrang("Đang sử dụng");
			goiDanhSachPhong1(p, b4, dsPhong);
		}else if(o.equals(btnDenHan1)) {
			ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoTinhTrang("Đến hạn");
			goiDanhSachPhong1(p, b4, dsPhong);
		}else if(o.equals(btnDaDat2)) {
			ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoTinhTrang("Đã đặt");
			goiDanhSachPhong2(p, b5, dsPhong);
		}else if(o.equals(btnDangSuDung2)) {
			ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoTinhTrang("Đang sử dụng");
			goiDanhSachPhong2(p, b5, dsPhong);
		}else if(o.equals(btnDenHan2)) {
			ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoTinhTrang("Đến hạn");
			goiDanhSachPhong2(p, b5, dsPhong);
		}
	}



	public void themDongVaoBangPDP(PhieuDatPhong pdp) {
		int row = tableCTDP.getSelectedRow();
		modelTablePDP.addRow(new Object[] {
				pdp.getMaPhieuDatPhong(),
				pdp.getNgayLapPhieu(),
				modelTableCTDP.getValueAt(row, 2),
				modelTableCTDP.getValueAt(row, 3)
		});
	}
	public void xoaDongTrongBangCTPDP() {
		while (modelTableCTDP.getRowCount() > 0) {
			modelTableCTDP.removeRow(0);
		}
	}
	public void themDongVaoBang(Phong p) {
		//String header[] = { "Mã phòng", "Giá phòng", "Số giường", "Số người", "Mô tả", "Loại phòng" };
		DecimalFormat df = new DecimalFormat("###.#");
		modelTable.addRow(new Object[] {
				p.getMaPhong(),df.format(p.getGiaPhong()),p.getSoGiuong(),p.getSoNguoi(),
				p.getMoTa(),qlp.layTenLoaiPhong(p.getLoaiPhong().getMaLoai()).getTenLoai()
		});
	}
	public void xoaDongTrongBang() {
		while (table.getRowCount() > 0) {
			modelTable.removeRow(0);
		}
	}
	public void xoaDongTrongBangPDP() {
		while (modelTablePDP.getRowCount() > 0) {
			modelTablePDP.removeRow(0);
		}
	}
	public void xoaDongTrongBangCTPDP2() {
		while (modelTableCTDP2.getRowCount() > 0) {
			modelTableCTDP2.removeRow(0);
		}
	}
	public void themDongVaoBangCTPDP(CT_PhieuDatPhong ctpdp) {
//		String headerCTDP[] = {"Mã phiếu đặt","Mã phòng","Ngày đến","Ngày đi"};
		modelTableCTDP.addRow(new Object[] { ctpdp.getMaCT_PhieuDatPhong(), ctpdp.getPhong().getMaPhong(),
				ctpdp.getNgayDen(), ctpdp.getNgayDi() });
	}
	public void themDongVaoBangCTPDP2(CT_PhieuDatPhong ctpdp) {
//		String headerCTDP[] = {"Mã phiếu đặt","Mã phòng","Ngày đến","Ngày đi"};
		modelTableCTDP2.addRow(new Object[] { ctpdp.getMaCT_PhieuDatPhong(), ctpdp.getPhong().getMaPhong(),
				ctpdp.getNgayDen(), ctpdp.getNgayDi() });
	}
	public boolean kiemTraDuLieu() {
		String ma = cboMaKhachHang.getSelectedItem().toString();
		if (ma.equals("")) {
			JOptionPane.showMessageDialog(this, "Hãy chọn khách hàng");
			return false;
		}
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String ngayDen = sdf.format(dcNgayNhanPhong.getDate());
//		String ngayDi = sdf.format(dcNgayTraPhong.getDate());
		java.util.Date dateNow = new java.util.Date();
		@SuppressWarnings("deprecation")
		java.util.Date date = new java.util.Date(dateNow.getYear(), dateNow.getMonth(), dateNow.getDate());
		if (dcNgayNhanPhong.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Ngày nhận phòng không được trống");
			return false;
		}
		if (dcNgayTraPhong.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Ngày trả phòng không được trống");
			return false;
		}
		if (dcNgayNhanPhong.getDate().after(dcNgayTraPhong.getDate())) {
			JOptionPane.showMessageDialog(this, "Ngày nhận phòng phải trước hoặc bằng ngày đi");
			return false;
		}
		if (dcNgayNhanPhong.getDate().compareTo(date) < 0) {
			JOptionPane.showMessageDialog(this, "Ngày nhận phòng phải sau hoặc bằng ngày hiện tại");
			return false;
		}
		return true;
	}

	public void lamMoiTextFields() {
		txtMaKhachHang.setText("");
		txtTenKhachHang.setText("");
		txtMaPhong.setText("");
		txtCMND.setText("");
		txtSoDienThoai.setText("");
		txtGioiTinh.setText("");
		dcNgaySinh.setDate(null);
		txtMoTa.setText("");
		txtGiaPhong.setText("");
		txtSoGiuong.setText("");
		txtSoNguoi.setText("");
		txtLoaiPhong.setText("");
		ArrayList<Phong> dsPhong1 = qlp.layTatCaCacPhongGomTinhTrangChuyen();
		goiDanhSachPhong1(p, b4, dsPhong1);
		ArrayList<Phong> dsPhong2 = qlp.layTatCaCacPhongGomTinhTrang();
		goiDanhSachPhong2(p, b5, dsPhong2);
	}

	public void timPhongChuyen1() {
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
		ArrayList<Phong> dsPhongTim = qlp.timPhongTheoTatCaGomTinhTrangChuyen(maPhong, gia, soGiuong, soNguoi, moTa,
				loaiPhong);
		if(kq == JOptionPane.YES_OPTION) {
			if (dsPhongTim.size() == 0) {
				goiDanhSachPhong1(p, b4, qlp.layTatCaCacPhongGomTinhTrangChuyen());
				JOptionPane.showMessageDialog(this, "Không tìm thấy phòng");
				String ma = this.txtMaPhong.getText().trim();
				for(int i = 0 ; i < btnPhong1.length;i++) {
					int dau = btnPhong1[i].getText().indexOf("<!--id");
					int cuoi = btnPhong1[i].getText().indexOf("id-->");
					String maP = btnPhong1[i].getText().substring(dau + 6, cuoi);
					if(maP.equals(ma))
						btnPhong1[i].setBackground(Color.decode("#FFCC00"));
				}
			}else {
				goiDanhSachPhong1(p, b4, dsPhongTim);
				String ma = this.txtMaPhong.getText().trim();
				for(int i = 0 ; i < btnPhong1.length;i++) {
					int dau = btnPhong1[i].getText().indexOf("<!--id");
					int cuoi = btnPhong1[i].getText().indexOf("id-->");
					String maP = btnPhong1[i].getText().substring(dau + 6, cuoi);
					if(maP.equals(ma))
						btnPhong1[i].setBackground(Color.decode("#FFCC00"));
				}
			}
		}
	}
	public void timPhongChuyen2() {
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
		ArrayList<Phong> dsPhongTim = qlp.timPhongTheoTatCaGomTinhTrang(maPhong, gia, soGiuong, soNguoi, moTa,
				loaiPhong);
		if(kq == JOptionPane.YES_OPTION) {
			if (dsPhongTim.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy phòng");
				goiDanhSachPhong2(p, b5, qlp.layTatCaCacPhongGomTinhTrang());
				String ma = modelTable.getValueAt(table.getRowCount()-1, 0).toString();
				for(int i = 0 ; i < btnPhong2.length;i++) {
					int dau = btnPhong2[i].getText().indexOf("<!--id");
					int cuoi = btnPhong2[i].getText().indexOf("id-->");
					String maP = btnPhong2[i].getText().substring(dau + 6, cuoi);
					if(maP.equals(ma))
						btnPhong2[i].setBackground(Color.decode("#FFCC00"));
				}
			}else {
				goiDanhSachPhong2(p, b5, dsPhongTim);
				String ma = modelTable.getValueAt(table.getRowCount()-1, 0).toString();
				for(int i = 0 ; i < btnPhong2.length;i++) {
					int dau = btnPhong2[i].getText().indexOf("<!--id");
					int cuoi = btnPhong2[i].getText().indexOf("id-->");
					String maP = btnPhong2[i].getText().substring(dau + 6, cuoi);
					if(maP.equals(ma))
						btnPhong2[i].setBackground(Color.decode("#FFCC00"));
				}
			}
		}
	}
}
