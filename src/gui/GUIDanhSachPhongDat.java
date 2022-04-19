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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.text.ParseException;
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
import dao.QuanLyKhachHang_DAO;
import dao.QuanLyNhanVien_DAO;
import dao.QuanLyPhieuDatPhong_DAO;
import dao.QuanLyPhong_DAO;
import entity.CT_PhieuDatPhong;
import entity.KhachHang;
import entity.PhieuDatPhong;
import entity.Phong;

public class GUIDanhSachPhongDat extends JPanel implements ActionListener, MouseListener{
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
	private JButton btnDenHan;
	private JButton btnDangSuDung;
	private JButton btnChuaDat;
	private JLabel lblTongSoPhong;
	private JLabel tongSoPhong;
	private JLabel lblHinhTongSoPhong;
	private JButton btnQuayLai;
	private static JButton[] btnPhong;
	public static String maPhong;
	public static String maNV;
	public static int maPhieu;
	private QuanLyPhong_DAO qlp = new QuanLyPhong_DAO();
	private QuanLyPhieuDatPhong_DAO qlpdp = new QuanLyPhieuDatPhong_DAO();
	private JLabel lblTitle2;
	private Box b4;
	private JLabel lblMaKhacHang;
	public JTextField txtMaKhachHang;
	private JLabel lblGioiTinh;
	private JComboBox<String> cboGioiTinh;
	private JLabel lblTenKhachHang;
	private JTextField txtTenKhachHang;
	private JLabel lblNgaySinh;
	private JDateChooser dcNgaySinh;
	private JLabel lblCMND;
	private JTextField txtCMND;
	private JLabel lblSoDienThoai;
	private JTextField txtSoDienThoai;
	private JLabel lblNgayNhanPhong;
	private JDateChooser dcNgayNhanPhong;
	private JLabel lblNgayTraPhong;
	private JDateChooser dcNgayTraPhong;
	private TitledBorder titleBorderKhachHang;
	private DefaultTableModel modelTable;
	private QuanLyKhachHang_DAO qlkh = new QuanLyKhachHang_DAO();
	private QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
	private JTable table;
	private JButton btnDatPhong;
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
	private DefaultTableModel modelTableKH;
	private JTable tableKH;
	private JButton btnDaDat;

	@SuppressWarnings("serial")
	public GUIDanhSachPhongDat(Frame cha) {
		frameCha = cha;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int rong = screenSize.width;
		int cao = screenSize.height;
		Box bMain, b123,b1, b2, b3, b;
		pNorth1 = new JPanel();
		pNorth1.add(lblTitle = new JLabel("DANH SÁCH PHÒNG TRỐNG KHÁCH SẠN"));
		add(bMain = Box.createVerticalBox());
		bMain.add(b123 = Box.createHorizontalBox());
		b123.add(Box.createHorizontalStrut(50));
		b123.add(b1 = Box.createVerticalBox());
		b1.add(b = Box.createHorizontalBox());
		b.add(pNorth1, BorderLayout.NORTH);
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTitle.setForeground(new Color(0xFFAA00));
		b1.add(b = Box.createHorizontalBox());
		b.add(lblTongSoPhong = new JLabel("Tổng số phòng: "));
		lblTongSoPhong.setForeground(new Color(0xFFAA00));
//		lblTongSoPhong.setBounds(5, 0, 48, 48);
		lblTongSoPhong.setFont(new Font("SansSerif", Font.BOLD, 20));
//		b.add(lblHinhTongSoPhong = new JLabel(new ImageIcon(".\\image\\tenor.gif")));
		ImageIcon gif = new ImageIcon(".\\image\\tongPhong.gif");
//		Image imageGif= gif.getImage();
//		Image scaleImage = imageGif.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		b.add(lblHinhTongSoPhong = new JLabel(gif));
		lblHinhTongSoPhong.add(tongSoPhong = new JLabel(qlp.tongSoPhong() + ""));
		tongSoPhong.setForeground(new Color(0xFFAA00));
		tongSoPhong.setBounds(13, 0, 48,48);
		tongSoPhong.setFont(new Font("SansSerif", Font.BOLD, 20));
		b1.add(b4 = Box.createHorizontalBox());
		p = new JPanel();
		goiDanhSachPhong(p, b4, qlp.layTatCaCacPhongGomTinhTrang());
		b4.setPreferredSize(new Dimension(rong - 800, cao - 320));
//		b.setPreferredSize(new Dimension(rong-500,cao-120));
		b4.setBorder(titleBorderPhong = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Danh sách phòng"));
		titleBorderPhong.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderPhong.setTitleColor(new Color(0xFFAA00));
		titleBorderPhong.setTitlePosition(TitledBorder.ABOVE_TOP);
//		b1.add(b = Box.createHorizontalBox());
//		b1.add(Box.createHorizontalStrut(50));
//		b1.add(b = Box.createHorizontalBox());
//		JLabel lblDangSuDung, lblTrong, lblDenHan,lblDangDuocDat;
//		b.add(Box.createHorizontalStrut(5));
////		b.add(mauXanh = new JPanel());
////		mauXanh.setBackground(Color.decode("#73d669"));
//		b.add(btnChuaDat = new JButton(new ImageIcon(".\\image\\greenRound32.png")));
//		btnChuaDat.setContentAreaFilled(false);
//		btnChuaDat.setFocusPainted(false);
//		btnChuaDat.setBorder(BorderFactory.createEmptyBorder());
//		b.add(Box.createHorizontalStrut(5));
//		b.add(lblTrong = new JLabel("Phòng trống"));
//		lblTrong.setFont(new Font("SansSerif", Font.ITALIC, 16));
//		b.add(Box.createHorizontalStrut(5));
//		b.add(btnDangSuDung = new JButton(new ImageIcon(".\\image\\pinkRound32.png")));
//		btnDangSuDung.setContentAreaFilled(false);
//		btnDangSuDung.setFocusPainted(false);
//		btnDangSuDung.setBorder(BorderFactory.createEmptyBorder());
//		b.add(Box.createHorizontalStrut(5));
//		b.add(lblDangSuDung = new JLabel("Phòng đang sử dụng"));
//		lblDangSuDung.setFont(new Font("SansSerif", Font.ITALIC, 16));
//		b.add(Box.createHorizontalStrut(5));
//		b.add(btnDenHan = new JButton(new ImageIcon(".\\image\\redRound32.png")));
//		btnDenHan.setContentAreaFilled(false);
//		btnDenHan.setFocusPainted(false);
//		btnDenHan.setBorder(BorderFactory.createEmptyBorder());
//		b.add(Box.createHorizontalStrut(5));
//		b.add(lblDenHan = new JLabel("Phòng đến hạn trả"));
//		lblDenHan.setFont(new Font("SansSerif", Font.ITALIC, 16));
//		b.add(btnDaDat= new JButton(new ImageIcon(".\\image\\blueRound32.png")));
//		btnDaDat.setContentAreaFilled(false);
//		btnDaDat.setFocusPainted(false);
//		btnDaDat.setBorder(BorderFactory.createEmptyBorder());
//		b.add(Box.createHorizontalStrut(5));
//		b.add(lblDangDuocDat= new JLabel("Phòng đang được đặt"));
//		lblDangDuocDat.setFont(new Font("SansSerif", Font.ITALIC, 16));
//		b.setBorder(titleBorderChuThich = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Tìm kiếm"));
//		titleBorderChuThich.setTitleColor(new Color(0xFFAA00));
//		titleBorderChuThich.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
//		b.setToolTipText("Chọn để lọc tình trạng phòng!");
//		b.add(Box.createHorizontalStrut(10));
//		b.add(btnTimKiem = new JButton("Tìm kiếm", new ImageIcon(".\\image\\search32.png")));
//		btnTimKiem.addActionListener(this);
		b123.add(Box.createHorizontalStrut(20));
		b123.add(b2 = Box.createVerticalBox());
		b2.add(b = Box.createHorizontalBox());
		b123.add(Box.createHorizontalStrut(50));
		JPanel pNorth2 = new JPanel();
		pNorth2.add(lblTitle2 = new JLabel("ĐẶT PHÒNG"));
		b.add(pNorth2, BorderLayout.NORTH);
		lblTitle2.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTitle2.setForeground(new Color(0xFFAA00));
		Box bKH, bKH1;
		b2.add(b3 = Box.createHorizontalBox());
		b3.add(bKH = Box.createHorizontalBox());
		bKH.add(bKH1 = Box.createVerticalBox());
		bKH1.add(Box.createVerticalStrut(20));
		bKH1.add(b = Box.createHorizontalBox());
//		b.add(Box.createHorizontalStrut(100));
		b.add(lblMaKhacHang = new JLabel("Mã khách hàng: "));
		b.add(txtMaKhachHang = new JTextField());
		bKH1.add(Box.createVerticalStrut(20));
		bKH1.add(b = Box.createHorizontalBox());
		b.add(lblTenKhachHang = new JLabel("Tên khách hàng: "));
		b.add(txtTenKhachHang = new JTextField());
		bKH1.add(Box.createVerticalStrut(20));
		bKH1.add(b = Box.createHorizontalBox());
		b.add(lblCMND = new JLabel("CMND: "));
		b.add(txtCMND = new JTextField());
		bKH1.add(Box.createVerticalStrut(20));
		bKH1.add(b = Box.createHorizontalBox());
		b.add(lblNgayNhanPhong = new JLabel("Ngày nhận phòng: "));
		b.add(dcNgayNhanPhong = new JDateChooser());
		bKH1.add(Box.createVerticalStrut(30));
		bKH.add(bKH1 = Box.createVerticalBox());
		bKH1.add(Box.createVerticalStrut(20));
		bKH1.add(b = Box.createHorizontalBox());
		b.add(lblGioiTinh = new JLabel("Giới tính: "));
		b.add(cboGioiTinh = new JComboBox<String>());
		cboGioiTinh.addItem("     ");
		cboGioiTinh.addItem("Nam");
		cboGioiTinh.addItem("Nữ");
		bKH1.add(Box.createVerticalStrut(20));
		bKH1.add(b = Box.createHorizontalBox());
		b.add(lblNgaySinh = new JLabel("Ngày sinh: "));
		b.add(dcNgaySinh = new JDateChooser());
		dcNgaySinh.setDateFormatString("dd/MM/yyyy");
		dcNgayNhanPhong.setDateFormatString("dd/MM/yyyy");
		bKH1.add(Box.createVerticalStrut(20));
		bKH1.add(b = Box.createHorizontalBox());
		b.add(lblSoDienThoai = new JLabel("Số điện thoại: "));
		b.add(txtSoDienThoai = new JTextField());
		bKH1.add(Box.createVerticalStrut(20));
		bKH1.add(b = Box.createHorizontalBox());
		b.add(lblNgayTraPhong = new JLabel("Ngày trả phòng: "));
		b.add(dcNgayTraPhong = new JDateChooser());
		bKH1.add(Box.createVerticalStrut(30));
//		b.add(Box.createHorizontalStrut(100));
		dcNgayTraPhong.setDateFormatString("dd/MM/yyyy");
		String headerCTDP[] = { "Mã phiếu đặt", "Mã phòng", "Ngày đến", "Ngày đi" };
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
		b3.add(scrollCTDV);
		scrollCTDV.setBorder(
		titleBorderCTDP = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Đang đặt của phòng"));
		titleBorderCTDP.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderCTDP.setTitleColor(new Color(0xFFAA00));
		b3.setPreferredSize(new Dimension(400, 200));
		scrollCTDV.setPreferredSize(new Dimension(300, 200));
		b2.add(Box.createVerticalStrut(20));
		txtTenKhachHang.setPreferredSize(new Dimension(100, 20));
		txtCMND.setPreferredSize(new Dimension(100, 20));
		txtMaKhachHang.setPreferredSize(new Dimension(100, 20));
//		dcNgayNhanPhong.setPreferredSize(new Dimension(100, 20));
		lblTenKhachHang.setPreferredSize(lblNgayNhanPhong.getPreferredSize());
		lblCMND.setPreferredSize(lblNgayNhanPhong.getPreferredSize());
		lblMaKhacHang.setPreferredSize(lblNgayNhanPhong.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblNgayTraPhong.getPreferredSize());
		lblSoDienThoai.setPreferredSize(lblNgayTraPhong.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblNgayTraPhong.getPreferredSize());
		lblNgayNhanPhong.setPreferredSize(lblNgayNhanPhong.getPreferredSize());
		lblNgayTraPhong.setPreferredSize(lblNgayTraPhong.getPreferredSize());
		bKH.setBorder(titleBorderKhachHang = new TitledBorder(BorderFactory.createLineBorder(Color.red),
				"Thông tin khách hàng"));
		titleBorderKhachHang.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderKhachHang.setTitleColor(new Color(0xFFAA00));
		docThongTinKhachHang();
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
		scroll.setBorder(BorderFactory.createLineBorder(Color.RED));
		scroll.setPreferredSize(new Dimension(rong - 1300, cao - 650));
		b2.add(b = Box.createHorizontalBox());
		b.add(scroll, BorderLayout.CENTER);
		b2.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(50));
		b.add(btnTimKiem = new JButton("Tìm kiếm phòng", new ImageIcon(".\\image\\search32.png")));
		btnTimKiem.addActionListener(this);
		b.add(Box.createHorizontalStrut(10));
		b.add(btnDatPhong = new JButton("Đặt phòng", new ImageIcon(".\\image\\check-in32.png")));
		b.add(Box.createHorizontalStrut(10));
		b.add(btnHuyCTPhong = new JButton("Hủy phòng muốn đặt", new ImageIcon(".\\image\\refuseicon32.png")));
		b.add(Box.createHorizontalStrut(10));
		b.add(btnLamMoi = new JButton("Làm mới", new ImageIcon(".\\image\\reload32.png")));
		b.add(Box.createHorizontalStrut(20));
		b.add(btnQuayLai = new JButton("Quay lại", new ImageIcon(".\\image\\logout32.png")));
		btnQuayLai.setBackground(Color.red);
		b.add(Box.createHorizontalStrut(50));
		b.setBorder(titleBorderNut = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Chọn thao tác"));
		titleBorderNut.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderNut.setTitleColor(new Color(0xFFAA00));
		String headerPDP[] = {"Mã phiếu đặt","Mã khách hàng","Tên khách hàng","Số điện thoại"};
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
		int widthColPDP[]= {10,10,10,10}; 
				
		for(int i = 0 ; i <4;++i) {
			tablePDP.getColumnModel().getColumn(i).setPreferredWidth(widthColPDP[i]*3);;
		}
		JScrollPane scrollPDP = new JScrollPane(tablePDP);
		scroll.setBorder(BorderFactory.createLineBorder(Color.RED));
		b2.add(scrollPDP);
		scrollPDP.setPreferredSize(new Dimension(rong-1300, 150));
		cboGioiTinh.setEnabled(false);
		dcNgaySinh.setEnabled(false);
		txtMaKhachHang.setEditable(false);
		dcNgayNhanPhong.setEnabled(false);
		dcNgayTraPhong.setEnabled(false);
		txtTenKhachHang.setEditable(false);
		txtCMND.setEditable(false);
		txtSoDienThoai.setEditable(false);
		btnQuayLai.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnHuyCTPhong.addActionListener(this);
		btnDatPhong.addActionListener(this);
//		btnChuaDat.addActionListener(this);
//		btnDaDat.addActionListener(this);
//		btnDangSuDung.addActionListener(this);
//		btnDenHan.addActionListener(this);
		table.addMouseListener(this);
	}

	public void taoJButton(JButton btn, Dimension kichThuoc) {
		btn.setPreferredSize(kichThuoc);
		btn.setMaximumSize(kichThuoc);
		btn.setMinimumSize(kichThuoc);
	}

	public void goiDanhSachPhong(JPanel p, Box b1, ArrayList<Phong> dsTatCaPhong) {
		b1.removeAll();
		b1.revalidate();
		b1.repaint();
		int x = 6;
		int y = qlp.tongSoPhong() / 4 + 1;
		DecimalFormat df = new DecimalFormat("#,###.# VND");
		ArrayList<String> dsThongTinPhong = new ArrayList<String>();
		for (Phong phong : dsTatCaPhong) {
			String mauSac = "";
			if (phong.getTinhTrangPhong() == 0) { // chưa đặt
				mauSac = "#77d56c";
			}
				else if(phong.getTinhTrangPhong() == 3) {// da dat
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
				int cuoi = thongTinPhong[i].indexOf("color-->");
				String mauSac = thongTinPhong[i].substring(dau + 9, cuoi);
				btnPhong[i].setBackground(Color.decode(mauSac));
				p.add(btnPhong[i]);
				btnPhong[i].addActionListener(this);
				taoJButton(btnPhong[i], new Dimension(40, 120));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		b1.add(new JScrollPane(p));
	}
	public void docThongTinKhachHang() {
		String ma = GUIDangNhap.ma;
		if(ma.equals("NV000001")) {
			KhachHang khachHang = qlkh.timKhacHangTheoMa(GUITimKhachHangDatPhong.maKH);
			txtMaKhachHang.setText(khachHang.getMaKhachHang());
			txtTenKhachHang.setText(khachHang.getTenKhachHang());
			txtSoDienThoai.setText(khachHang.getSoDienThoai());
			txtCMND.setText(khachHang.getcMND());
			cboGioiTinh.setSelectedItem(khachHang.getGioiTinh());
			dcNgaySinh.setDate(khachHang.getNgaySinh());
		}else {
			KhachHang khachHang = qlkh.timKhacHangTheoMa(GUITimKhachHangDatPhongNV.maKH);
			txtMaKhachHang.setText(khachHang.getMaKhachHang());
			txtTenKhachHang.setText(khachHang.getTenKhachHang());
			txtSoDienThoai.setText(khachHang.getSoDienThoai());
			txtCMND.setText(khachHang.getcMND());
			cboGioiTinh.setSelectedItem(khachHang.getGioiTinh());
			dcNgaySinh.setDate(khachHang.getNgaySinh());
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		for (int i = 0; i < btnPhong.length; i++) {
			if (o.equals(btnPhong[i])) {
				int dau = btnPhong[i].getText().indexOf("<!--id");
				int cuoi = btnPhong[i].getText().indexOf("id-->");
				String ma = btnPhong[i].getText().substring(dau + 6, cuoi);
				Phong phong = qlp.timPhongTheoMaPhong(ma);
				dcNgayNhanPhong.setEnabled(true);
				dcNgayTraPhong.setEnabled(true);
				themDongVaoBangPhong(phong);
				xoaDongTrongBangCTPDP();
				ArrayList<CT_PhieuDatPhong> dsCTPDP = qlctpdp.layCT_PhieuDatPhongTheoMaPhong(ma);
				for (CT_PhieuDatPhong ct_PhieuDatPhong : dsCTPDP) {
					themDongVaoBangCTPDP(ct_PhieuDatPhong);
				}
				xoaDongTrongBangPDP();
				ArrayList<PhieuDatPhong> dsPDP = qlpdp.layPhieuDatPhongTheoMaPhong(ma);
				for (PhieuDatPhong phieuDatPhong : dsPDP) {
					themDongVaoBangPDP(phieuDatPhong);
				}
				btnPhong[i].setEnabled(false);
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
			xoaDongTrongBangPhong();
			xoaDongTrongBangCTPDP();
			xoaDongTrongBangPDP();
		} else if (o.equals(btnHuyCTPhong)) {
			int row = table.getSelectedRow();
			for(int i = 0 ; i < btnPhong.length ;i++) {
				int dau = btnPhong[i].getText().indexOf("<!--id");
				int cuoi = btnPhong[i].getText().indexOf("id-->");
				String ma = btnPhong[i].getText().substring(dau + 6, cuoi);
				if(modelTable.getValueAt(row,0).toString().equals(ma)) {
					btnPhong[i].setEnabled(true);
				}
			}
			modelTable.removeRow(row);			
		} else if (o.equals(btnDatPhong)) {
				if (kiemTraDuLieu()) {
					int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn đặt phòng không?","Nhắc nhở",JOptionPane.YES_NO_OPTION);
					if(kq == JOptionPane.YES_OPTION) {
						boolean flag = true;
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String ngayDen = sdf.format(dcNgayNhanPhong.getDate());
						String ngayDi = sdf.format(dcNgayTraPhong.getDate());
						Date date = new Date();
						String ngayHienTai = sdf.format(date);
						String maPhongDaDat = "";
						for (int i = 0; i < table.getRowCount(); i++) {
							if (qlctpdp.layCT_PhieuDatPhongTheoThoiGianPhong(modelTable.getValueAt(i, 0).toString(), ngayDen,
									ngayDi).size() > 0) {
								flag = false;
								maPhongDaDat += modelTable.getValueAt(i, 0).toString() + " ";
							}
						}
						if (flag == false) {
							JOptionPane.showMessageDialog(this, "Phòng " + maPhongDaDat + " đã được đặt ");
						}
						else {
	//						int rowP = table.getRowCount()-1;
	//						String ma = modelTable.getValueAt(rowP,0).toString();
							if(qlpdp.themPhieuDatPhong(ngayHienTai,GUIDangNhap.ma,txtMaKhachHang.getText().trim())) {
								int maPDP = qlpdp.layMaPhieuLonNhat();
								for(int i = 0 ; i < table.getRowCount();i++) {
									qlctpdp.taoCT_PhieuDatPhong(maPDP, modelTable.getValueAt(i, 0).toString(),ngayDen,ngayDi);
								}
								PhieuDatPhong pdp = qlpdp.timPhieuDatPhongTheoMaPhieu(maPDP+"");
								themDongVaoBangPDP(pdp);
								int in = JOptionPane.showConfirmDialog(this,"Đặt phòng thành công và in phiếu cho khách hàng","Nhắc nhở",JOptionPane.YES_NO_OPTION);
								if(in == JOptionPane.YES_OPTION) {
									inPhieuDatPhong();
									lamMoiTextFields();
									goiDanhSachPhong(p, b4, qlp.layTatCaCacPhongGomTinhTrang());
									xoaDongTrongBangPhong();
									xoaDongTrongBangCTPDP();
									xoaDongTrongBangPDP();
								}else {
									lamMoiTextFields();
									goiDanhSachPhong(p, b4, qlp.layTatCaCacPhongGomTinhTrang());
									xoaDongTrongBangPhong();
									xoaDongTrongBangCTPDP();
									xoaDongTrongBangPDP();
								}
							}
						}
					}
			}
		} else if (o.equals(btnTimKiem)) {
			timPhongDat();
		}else if(o.equals(btnChuaDat)) {
			ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoTinhTrang("Chưa đặt");
			goiDanhSachPhong(p, b4, dsPhong);
		}else if(o.equals(btnDaDat)) {
			ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoTinhTrang("Đã đặt");
			goiDanhSachPhong(p, b4, dsPhong);
		}else if(o.equals(btnDangSuDung)) {
			ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoTinhTrang("Đang sử dụng");
			goiDanhSachPhong(p, b4, dsPhong);
		}else if(o.equals(btnDenHan)) {
			ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoTinhTrang("Đến hạn");
			goiDanhSachPhong(p, b4, dsPhong);
		}
	}

	public void themDongVaoBangPhong(Phong phong) {
		DecimalFormat df = new DecimalFormat("###.#");
		modelTable.addRow(new Object[] {
//				String header[] = {"Mã phòng","Giá phòng","Số giường","Mô tả","Loại phòng"};
				phong.getMaPhong(), df.format(phong.getGiaPhong()), phong.getSoGiuong(), phong.getSoNguoi(), phong.getMoTa(),
				qlp.layTenLoaiPhong(phong.getLoaiPhong().getMaLoai()).getTenLoai() });
	}

	public void themDongVaoBangPDP(PhieuDatPhong pdp) {
//		String headerPDP[] = {"Mã phiếu đặt","Mã khách hàng","Tên khách hàng","Số điện thoại"};
		modelTablePDP.addRow(new Object[] {
				pdp.getMaPhieuDatPhong(),
				qlkh.timKhacHangTheoMa(pdp.getKhachHang().getMaKhachHang()).getMaKhachHang(),
				qlkh.timKhacHangTheoMa(pdp.getKhachHang().getMaKhachHang()).getTenKhachHang(),
				qlkh.timKhacHangTheoMa(pdp.getKhachHang().getMaKhachHang()).getSoDienThoai()
		});
	}

	public void xoaDongTrongBangPhong() {
		while (modelTable.getRowCount() > 0) {
			modelTable.removeRow(0);
		}
	}

	public void xoaDongTrongBangCTPDP() {
		while (modelTableCTDP.getRowCount() > 0) {
			modelTableCTDP.removeRow(0);
		}
	}
	public void xoaDongTrongBangPDP() {
		while (modelTablePDP.getRowCount() > 0) {
			modelTablePDP.removeRow(0);
		}
	}
	public void themDongVaoBangCTPDP(CT_PhieuDatPhong ctpdp) {
//		String headerCTDP[] = {"Mã phiếu đặt","Mã phòng","Ngày đến","Ngày đi"};
		modelTableCTDP.addRow(new Object[] { ctpdp.getMaCT_PhieuDatPhong(), ctpdp.getPhong().getMaPhong(),
				ctpdp.getNgayDen(), ctpdp.getNgayDi() });
	}
	public boolean kiemTraDuLieu() {
		String ma = txtMaKhachHang.getText().trim();
		if (ma.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin khách hàng");
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
			JOptionPane.showMessageDialog(this, "Ngày nhận phòng phải trước hoặc bằng ngày trả phòng");
			return false;
		}
		if (dcNgayNhanPhong.getDate().compareTo(date) < 0) {
			JOptionPane.showMessageDialog(this, "Ngày nhận phòng phải sau hoặc bằng ngày hiện tại");
			return false;
		}
		return true;
	}

	public void lamMoiTextFields() {
		dcNgayNhanPhong.setDate(null);
		dcNgayTraPhong.setDate(null);
		dcNgayNhanPhong.setEnabled(false);
		dcNgayTraPhong.setEnabled(false);
		ArrayList<Phong> dsPhong = qlp.layTatCaCacPhongGomTinhTrang();
		goiDanhSachPhong(p, b4, dsPhong);
	}

	public void timPhongDat() {
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
		int row = table.getRowCount();
		if(kq == JOptionPane.YES_OPTION) {
			if (dsPhongTim.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy phòng");
				goiDanhSachPhong(p, b4, qlp.layTatCaCacPhongGomTinhTrang());
				for (int i = 0; i < btnPhong.length;i++) {
					for(int j = 0 ;j < row;j++) {
						int dau = btnPhong[i].getText().indexOf("<!--id");
						int cuoi = btnPhong[i].getText().indexOf("id-->");
						String ma = btnPhong[i].getText().substring(dau + 6, cuoi);
						if(modelTable.getValueAt(j, 0).toString().equals(ma))
							btnPhong[i].setEnabled(false);
					}
				}
			}else {
				goiDanhSachPhong(p, b4, dsPhongTim);
				for (int i = 0; i < btnPhong.length;i++) {
					for(int j = 0 ;j < row;j++) {
						int dau = btnPhong[i].getText().indexOf("<!--id");
						int cuoi = btnPhong[i].getText().indexOf("id-->");
						String ma = btnPhong[i].getText().substring(dau + 6, cuoi);
						if(modelTable.getValueAt(j, 0).toString().equals(ma))
							btnPhong[i].setEnabled(false);
					}
				}
			}
		}
	}
	public void themDongVaoBangKH(KhachHang kh) {
		modelTableKH.addRow(new Object[] {
				kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getGioiTinh(),kh.getcMND(),kh.getSoDienThoai(),kh.getNgaySinh()
		});
	}
	@SuppressWarnings("serial")
	public void timKhachHangDatPhong() {
		String ten="",cMND="",sDT="";
		JPanel p = new JPanel();
		ten = txtTenKhachHang.getText().trim();
		cMND = txtCMND.getText().trim();
		sDT = txtSoDienThoai.getText().trim();
		if(ten.equals("") && cMND.equals("") && sDT.equals(""))
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin khách hàng muốn tìm");
		else {
			ArrayList<KhachHang> dsKhachHang = qlkh.timKhachHangTheoDatPhong(ten, cMND, sDT);
			if(dsKhachHang.size() == 0) {
				JOptionPane.showMessageDialog(this, "Khách hàng không có trong hệ thống");
			}else {
				String headerKH[] = {"Mã khách hàng","Tên khách hàng","Giới tính","CMND","Số điện thoại","Ngày sinh"};
				modelTableKH = new DefaultTableModel(headerKH, 0);
				tableKH = new JTable(modelTableKH) {
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
				tableKH.setAutoCreateRowSorter(true);
				DefaultTableCellRenderer renderCenterKH = new DefaultTableCellRenderer();
				renderCenterKH.setHorizontalAlignment(JLabel.CENTER);
				JTableHeader headerTableKH = new JTableHeader();
				headerTableKH.setOpaque(false);
				tableKH.getTableHeader().setReorderingAllowed(false);
				for(int i = 0 ; i <6;++i) {
					tableKH.getColumnModel().getColumn(i).setCellRenderer(renderCenterKH);
				}
				int widthColKH[]= {15,30,10,10,10,10}; 
				for(int i = 0 ; i <6;++i) {
					tableKH.getColumnModel().getColumn(i).setPreferredWidth(widthColKH[i]*3);;
				}
				JScrollPane scrollKH = new JScrollPane(tableKH);
				p.add(scrollKH);
				for (KhachHang khachHang : dsKhachHang) {
					themDongVaoBangKH(khachHang);
					tableKH.setModel(modelTableKH);
				}
				int kq =JOptionPane.showConfirmDialog(this, p,"Tìm khách hàng đặt phòng",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
				if(kq == JOptionPane.YES_OPTION) {
					int row = tableKH.getSelectedRow();
					txtMaKhachHang.setText(modelTableKH.getValueAt(row, 0).toString());
					txtTenKhachHang.setText(modelTableKH.getValueAt(row, 1).toString());
					cboGioiTinh.setSelectedItem(modelTableKH.getValueAt(row, 2).toString());
					txtCMND.setText(modelTableKH.getValueAt(row, 3).toString());
					txtSoDienThoai.setText(modelTableKH.getValueAt(row, 4).toString());
					java.util.Date date = null;
					try {
						date = new SimpleDateFormat("yyyy-MM-dd").parse(modelTableKH.getValueAt(row, 5).toString());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dcNgaySinh.setDate(date);
				}
			}
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
		int row = table.getSelectedRow();
		xoaDongTrongBangCTPDP();
		ArrayList<CT_PhieuDatPhong> dsCTPDP = qlctpdp
				.layCT_PhieuDatPhongTheoMaPhong(modelTable.getValueAt(row, 0).toString());
		for (CT_PhieuDatPhong ct_PhieuDatPhong : dsCTPDP) {
			themDongVaoBangCTPDP(ct_PhieuDatPhong);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public void inPhieuDatPhong() {
		JLabel lblMaPDP,lblMaNV,lblMaKhachHang;
		JPanel p = new JPanel();
		Box bMain,b,b1,b2,b12;
		p.setBackground(Color.WHITE);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		int rowPDP = tablePDP.getRowCount();
		int rowP = table.getRowCount();
		p.add(bMain = Box.createVerticalBox());
		bMain.add(b = Box.createHorizontalBox());
		b.add(new JLabel(new ImageIcon(".\\image\\everestBill.png")));
		bMain.add(b12 = Box.createHorizontalBox());
		b12.add(b1 = Box.createVerticalBox());
		b1.add(b = Box.createHorizontalBox());
		b.add(lblMaPDP = new JLabel("Mã phiếu: "+modelTablePDP.getValueAt(rowPDP-1, 0).toString()+"     "));
		b1.add(Box.createVerticalStrut(20));
		b1.add(b = Box.createHorizontalBox());
		b.add(lblMaNV = new JLabel("Mã nhân viên: " +GUIDangNhap.ma+"      "));
		b1.add(Box.createVerticalStrut(20));
		b1.add(b = Box.createHorizontalBox());
		b.add(lblMaKhachHang = new JLabel("Mã khách hàng: "+txtMaKhachHang.getText().trim()+"     "));
		b1.add(Box.createVerticalStrut(20));
		b12.add(b2 = Box.createVerticalBox());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ngayHienTai = sdf.format(date);
		b2.add(b = Box.createHorizontalBox());
		b.add(new JLabel("Ngày lập phiếu: "+ngayHienTai+"      "));
		b2.add(Box.createVerticalStrut(20));
		b2.add(b = Box.createHorizontalBox());
		b.add(new JLabel("Tên nhân viên: "+qlnv.layNhanVienTheoMa(GUIDangNhap.ma).getTenNhanVien()+"      "));
		b2.add(Box.createVerticalStrut(20));
		b2.add(b = Box.createHorizontalBox());
		b.add(new JLabel("Tên khách hàng: "+txtTenKhachHang.getText().trim()+"      "));
		b2.add(Box.createVerticalStrut(20));
		bMain.add(b = Box.createHorizontalBox());
		DefaultTableModel modelTableIn= new DefaultTableModel(0,8);
		modelTableIn.addRow(new Object[] {
			"Mã phòng","Giá","Số giường","Số người","Mô tả","Loại phòng","Ngày nhận phòng","Ngày trả phòng"});
		JTable tableIn = new JTable(modelTableIn);
		tableIn.setAutoCreateRowSorter(true);
		DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
		renderCenter.setHorizontalAlignment(JLabel.CENTER);
		JTableHeader headerTable = new JTableHeader();
		headerTable.setOpaque(false);
		tableIn.getTableHeader().setReorderingAllowed(false);
		for(int i = 0 ; i <8;++i) {
			tableIn.getColumnModel().getColumn(i).setCellRenderer(renderCenter);
		}
		int widthCol[]= {15,15,15,15,30,20,30,25}; 
		for(int i = 0 ; i <8;++i) {
			tableIn.getColumnModel().getColumn(i).setPreferredWidth(widthCol[i]*3);;
		}
		JScrollPane scrollIn = new JScrollPane(tableIn);
		bMain.add(scrollIn);
		scrollIn.setPreferredSize(new Dimension(600, 200));
		lblMaPDP.setPreferredSize(lblMaKhachHang.getPreferredSize());
		lblMaNV.setPreferredSize(lblMaKhachHang.getPreferredSize());
		bMain.add(b = Box.createHorizontalBox());
		b.add(new JLabel("Cảm ơn quý khách!      "));
		for(int i = 0 ; i < rowP ; i++) {
			modelTableIn.addRow(new Object[] {
					modelTable.getValueAt(i, 0),
					modelTable.getValueAt(i, 1),
					modelTable.getValueAt(i, 2),
					modelTable.getValueAt(i, 3),
					modelTable.getValueAt(i, 4),
					modelTable.getValueAt(i, 5),
					sdf.format(dcNgayNhanPhong.getDate()),
					sdf.format(dcNgayTraPhong.getDate())
			});
		}
		int kq = JOptionPane.showConfirmDialog(this, p,"IN PHIẾU ĐẶT PHÒNG",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
			if(kq == JOptionPane.YES_OPTION) {
				PrinterJob pj = PrinterJob.getPrinterJob();
				pj.setJobName("PhieuDatPhong_"+txtMaKhachHang.getText().trim()+"_"+ngayHienTai);

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
					ex.printStackTrace();
				}
			}
		}
}
