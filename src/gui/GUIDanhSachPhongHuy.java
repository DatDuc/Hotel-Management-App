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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
import javax.swing.UIManager;
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

public class GUIDanhSachPhongHuy extends JPanel implements ActionListener,MouseListener{
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
	private JLabel lblTongSoPhong;
	private JLabel tongSoPhong;
	private JLabel lblHinhTongSoPhong;
	private JButton btnQuayLai;
	private static JButton[] btnPhong;
	public static String maPhong;
	public static String maNV;
	public static int maPhieu;
	private QuanLyPhieuDatPhong_DAO qlpdp = new QuanLyPhieuDatPhong_DAO();
	private QuanLyPhong_DAO qlp = new QuanLyPhong_DAO();
	private JLabel lblTitle2;
	private Box b4;
	private QuanLyCT_PhieuDatPhong_DAO qlctpdp = new QuanLyCT_PhieuDatPhong_DAO();
	private QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
	private QuanLyKhachHang_DAO qlkh= new QuanLyKhachHang_DAO();
	private JButton btnHuyPhong;
	private JButton btnLamMoi;
	private TitledBorder titleBorderNut;
	private JButton btnTimKiem;
	private JLabel lblLoaiPhong;
	private JLabel lblMaPhong;
	private JTextField txtMaPhong;
	private JTextField txtLoaiPhong;
	private JLabel lblGiaPhong;
	private JTextField txtGiaPhong;
	private JLabel lblMoTa;
	private JTextField txtMoTa;
	private JLabel lblSoGiuong;
	private JTextField txtSoGiuong;
	private DefaultTableModel tableModel1;
	private JTable table1;
	private JScrollPane scroll1;
	private DefaultTableModel tableModel2;
	private JTable table2;
	private JScrollPane scroll2;
	private JLabel lblSoNguoi;
	private JTextField txtSoNguoi;
	private JButton btnHuyTaCaPhong;
	private JLabel lblMaKhachHang;
	private JTextField txtMaKhachHang;
	private JLabel lblTenKhachHang;
	private JTextField txtTenKhachHang;
	private JLabel lblGioiTinh;
	private JTextField txtGioiTinh;
	private JLabel lblCMND;
	private JTextField txtCMND;
	private JLabel lblSoDienThoai;
	private JTextField txtSoDienThoai;
	private JLabel lblNgaySinh;
	private JDateChooser dcNgaySinh;
	private TitledBorder titleBorderKH;
	private static int count=1;
	private static String countTruoc=null;
	private static String countSau=null;
	
	public GUIDanhSachPhongHuy(Frame cha) {
		frameCha = cha;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int rong = screenSize.width;
		int cao = screenSize.height;
		Box bMain, b123,b1, b2, b;
		pNorth1 = new JPanel();
		pNorth1.add(lblTitle = new JLabel("DANH SÁCH PHÒNG ĐÃ ĐẶT KHÁCH SẠN"));
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
		b.add(lblHinhTongSoPhong = new JLabel(new ImageIcon(".\\image\\tongPhong.gif")));
		lblHinhTongSoPhong.add(tongSoPhong = new JLabel(qlp.tongSoPhong() + ""));
		tongSoPhong.setForeground(new Color(0xFFAA00));
		tongSoPhong.setBounds(13, 0, 48, 48);
		tongSoPhong.setFont(new Font("SansSerif", Font.BOLD, 20));
		b1.add(b4 = Box.createHorizontalBox());
		p = new JPanel();
		goiDanhSachPhong(p, b4, qlp.layDanhSachPhongTheoTinhTrang("Đã đặt"));
		b1.setPreferredSize(new Dimension(rong/2, cao - 320));
		b4.setBorder(titleBorderPhong = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Danh sách phòng"));
		b4.setPreferredSize(new Dimension((rong/2)-20, cao-320));
		titleBorderPhong.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderPhong.setTitleColor(new Color(0xFFAA00));
		titleBorderPhong.setTitlePosition(TitledBorder.ABOVE_TOP);
		b123.add(Box.createHorizontalStrut(50));
		b123.add(b2 = Box.createVerticalBox());
		b2.add(b = Box.createHorizontalBox());
		b123.add(Box.createHorizontalStrut(50));
		JPanel pNorth2 = new JPanel();
		pNorth2.add(lblTitle2 = new JLabel("HỦY PHÒNG"));
		b.add(pNorth2, BorderLayout.NORTH);
		lblTitle2.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTitle2.setForeground(new Color(0xFFAA00));
		Box bKH,bPhong,bKHP;
		b2.add(bKHP = Box.createHorizontalBox());
		bKHP.add(bKH = Box.createVerticalBox());
		bKH.add(b = Box.createHorizontalBox());
		b.add(lblMaKhachHang = new JLabel("Mã khách hàng: "));
		b.add(txtMaKhachHang = new JTextField());
		bKH.add(Box.createVerticalStrut(8));
		bKH.add(b = Box.createHorizontalBox());
		b.add(lblTenKhachHang = new JLabel("Tên khách hàng: "));
		b.add(txtTenKhachHang = new JTextField());
		bKH.add(Box.createVerticalStrut(8));
		bKH.add(b = Box.createHorizontalBox());
		b.add(lblGioiTinh = new JLabel("Giới tính: "));
		b.add(txtGioiTinh = new JTextField());
		bKH.add(Box.createVerticalStrut(8));
		bKH.add(b = Box.createHorizontalBox());
		b.add(lblCMND = new JLabel("CMND: "));
		b.add(txtCMND= new JTextField());
		bKH.add(Box.createVerticalStrut(8));
		bKH.add(b = Box.createHorizontalBox());
		b.add(lblSoDienThoai= new JLabel("Số điện thoại: "));
		b.add(txtSoDienThoai = new JTextField());
		bKH.add(Box.createVerticalStrut(8));
		bKH.add(b = Box.createHorizontalBox());
		b.add(lblNgaySinh = new JLabel("Ngày sinh: "));
		b.add(dcNgaySinh = new JDateChooser());
		bKH.add(Box.createVerticalStrut(10));
		dcNgaySinh.setDateFormatString("dd-MM-yyyy");
		bKH.setBorder(titleBorderKH = new TitledBorder(BorderFactory.createLineBorder(Color.red),"Thông tin khách hàng"));
		titleBorderKH.setTitleFont(new Font("SansSerif",Font.BOLD,20));
		titleBorderKH.setTitleColor(new Color(0xFFAA00));
		lblMaKhachHang.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblCMND.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblSoDienThoai.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblTenKhachHang.setPreferredSize(lblTenKhachHang.getPreferredSize());
		txtMaKhachHang.setEditable(false);
		dcNgaySinh.setEnabled(false);
		txtCMND.setEditable(false);
		txtGioiTinh.setEditable(false);
		txtTenKhachHang.setEditable(false);
		txtSoDienThoai.setEditable(false);
		bKHP.add(bPhong = Box.createVerticalBox());
		bPhong.add(b = Box.createHorizontalBox());
		b.add(lblMaPhong = new JLabel("Mã phòng: "));
		b.add(txtMaPhong= new JTextField());
		bPhong.add(Box.createVerticalStrut(8));
		bPhong.add(b = Box.createHorizontalBox());
		b.add(lblLoaiPhong =new JLabel("Loại phòng: "));
		b.add(txtLoaiPhong= new JTextField());
		bPhong.add(Box.createVerticalStrut(8));
		bPhong.add(b= Box.createHorizontalBox());
		b.add(lblGiaPhong =new JLabel("Giá phòng : "));
		b.add(txtGiaPhong= new JTextField());
		bPhong.add(Box.createVerticalStrut(8));
		bPhong.add(b= Box.createHorizontalBox());
		b.add(lblMoTa=new JLabel("Mô tả: "));
		b.add(txtMoTa= new JTextField());
		bPhong.add(Box.createVerticalStrut(8));
		bPhong.add(b= Box.createHorizontalBox());
		b.add(lblSoGiuong=new JLabel("Số giường: "));
		b.add(txtSoGiuong= new JTextField());
		bPhong.add(Box.createVerticalStrut(8));
		bPhong.add(b = Box.createHorizontalBox());
		b.add(lblSoNguoi=new JLabel("Số người: "));
		b.add(txtSoNguoi= new JTextField());
		bPhong.add(Box.createVerticalStrut(10));
		bPhong.setBorder(titleBorderPhong = new TitledBorder(BorderFactory.createLineBorder(Color.red),"Thông tin phòng"));
		titleBorderPhong.setTitleFont(new Font("SansSerif",Font.BOLD,20));
		titleBorderPhong.setTitleColor(new Color(0xFFAA00));
		lblMaPhong.setPreferredSize(lblLoaiPhong.getPreferredSize());
		lblLoaiPhong.setPreferredSize(lblLoaiPhong.getPreferredSize());
		lblGiaPhong.setPreferredSize(lblLoaiPhong.getPreferredSize());
		lblMoTa.setPreferredSize(lblLoaiPhong.getPreferredSize());
		lblSoGiuong.setPreferredSize(lblLoaiPhong.getPreferredSize());
		lblSoNguoi.setPreferredSize(lblLoaiPhong.getPreferredSize());
		txtLoaiPhong.setEditable(false);
		txtMaPhong.setEditable(false);
		txtSoGiuong.setEditable(false);
		txtMoTa.setEditable(false);
		txtGiaPhong.setEditable(false);
		txtSoNguoi.setEditable(false);
		b2.add(b = Box.createHorizontalBox());
		String headerPDP[] = {"Mã phiếu đặt phòng","Mã khách hàng","Tên khách hàng","Số điện thoại","Ngày nhận phòng","Ngày trả phòng"};
		tableModel1= new DefaultTableModel(headerPDP, 0);
		table1 = new JTable(tableModel1) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

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
		
		table1.setAutoCreateRowSorter(true);
		DefaultTableCellRenderer renderCenterPDP = new DefaultTableCellRenderer();
		renderCenterPDP.setHorizontalAlignment(JLabel.CENTER);
		JTableHeader headerTablePDP = new JTableHeader();
		headerTablePDP.setOpaque(false);
		table1.getTableHeader().setReorderingAllowed(false);
		for(int i = 0 ; i <6;++i) {
			table1.getColumnModel().getColumn(i).setCellRenderer(renderCenterPDP);
		}
		int widthColPDP[]= {10,10,30,20,20,20}; 
		for(int i = 0 ; i <6;++i) {
			table1.getColumnModel().getColumn(i).setPreferredWidth(widthColPDP[i]*3);;
		}
		scroll1 = new JScrollPane(table1);
//		scrollDichVu1.setPreferredSize(new Dimension(950, 530));
		JTableHeader header1 = table1.getTableHeader();
		header1.setOpaque(false); // xét cứng cột
		table1.getTableHeader().setReorderingAllowed(false);
//		scrollDichVu1.setPreferredSize(new Dimension(400, 300));
		scroll1.setBorder(BorderFactory.createLineBorder(Color.RED));
		b.add(scroll1);
		scroll1.setPreferredSize(new Dimension(rong/3,170));
		b2.add(Box.createVerticalStrut(10));
		b2.add(b =Box.createHorizontalBox());
		b.add(btnHuyTaCaPhong = new JButton("Hủy tất cả phòng",new ImageIcon(".\\image\\cancel32.png")));
		b.add(Box.createHorizontalStrut(50));
		String header2[] = { "Mã phiếu", "Mã phòng", "Ngày đến", "Ngày đi" };
		tableModel2 = new DefaultTableModel(header2, 0);
		table2 = new JTable(tableModel2) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

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
		table2.setAutoCreateRowSorter(true);
		DefaultTableCellRenderer renderCenter2 = new DefaultTableCellRenderer();
		renderCenter2.setHorizontalAlignment(JLabel.CENTER);
		JTableHeader headerTable2 = new JTableHeader();
		headerTable2.setOpaque(false);
		table2.getTableHeader().setReorderingAllowed(false);
		for (int i = 0; i < 4; ++i) {
			table2.getColumnModel().getColumn(i).setCellRenderer(renderCenter2);
		}
		int widthColCTDP2[] = { 10, 10, 10, 10 };
		for (int i = 0; i < 4; ++i) {
			table2.getColumnModel().getColumn(i).setPreferredWidth(widthColCTDP2[i] * 3);
			;
		}
		scroll2 = new JScrollPane(table2);
		scroll2.setPreferredSize(new Dimension(rong/3,170));
		scroll2.setBorder(BorderFactory.createLineBorder(Color.red));
		b2.add(Box.createVerticalStrut(10));
		b2.add(b =Box.createHorizontalBox());
		b.add(scroll2);
		b2.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(70));
		b.add(btnTimKiem = new JButton("Tìm kiếm phòng", new ImageIcon(".\\image\\search32.png")));
		b.add(Box.createHorizontalStrut(50));
		b.add(btnHuyPhong = new JButton("Hủy phòng", new ImageIcon(".\\image\\cancel32.png")));
		b.add(Box.createHorizontalStrut(50));
		b.add(btnLamMoi = new JButton("Làm mới", new ImageIcon(".\\image\\reload32.png")));
		b.add(Box.createHorizontalStrut(70));
		b.add(btnQuayLai = new JButton("Quay lại", new ImageIcon(".\\image\\logout32.png")));
		btnQuayLai.setBackground(Color.red);
		b.add(Box.createHorizontalStrut(5));
		b.setBorder(titleBorderNut = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Chọn thao tác"));
		titleBorderNut.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderNut.setTitleColor(new Color(0xFFAA00));
		btnHuyTaCaPhong.setEnabled(false);
		btnQuayLai.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnHuyPhong.addActionListener(this);
		btnTimKiem.addActionListener(this);
		table1.addMouseListener(this);
		btnHuyPhong.setEnabled(false);
		btnHuyTaCaPhong.addActionListener(this);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		for (int i = 0; i < btnPhong.length; i++) {
			if (o.equals(btnPhong[i])) {
				count++;
				int dau = btnPhong[i].getText().indexOf("<!--id");
				int cuoi = btnPhong[i].getText().indexOf("id-->");
				String ma = btnPhong[i].getText().substring(dau + 6, cuoi);
				Phong phong = qlp.timPhongTheoMaPhong(ma);
				btnHuyPhong.setEnabled(true);
				txtMaPhong.setText(phong.getMaPhong());
				DecimalFormat df = new DecimalFormat("###.#");
				txtGiaPhong.setText(df.format(phong.getGiaPhong()));
				txtLoaiPhong.setText(qlp.layTenLoaiPhong(phong.getLoaiPhong().getMaLoai()).getTenLoai());
				txtSoGiuong.setText(phong.getSoGiuong()+"");
				txtMoTa.setText(phong.getMoTa());
				txtSoNguoi.setText(phong.getSoNguoi()+"");
				xoaBang1();
				ArrayList<PhieuDatPhong> dsPDP = qlpdp.layPhieuDatPhongTheoMaPhong(ma);
				PhieuDatPhong pdp = dsPDP.get(0);
				themDongVaoBang1(pdp);
				xoaBang2();
				ArrayList<CT_PhieuDatPhong> dsCTPDPCuaPhong = qlctpdp.layCT_PhieuDatPhongTheoMaPhong(ma);
				CT_PhieuDatPhong CTPDPCuaPhong = dsCTPDPCuaPhong.get(0);
				int maCTPDPCuaPhong = CTPDPCuaPhong.getMaCT_PhieuDatPhong();
				ArrayList<CT_PhieuDatPhong> dsCTPDP = qlctpdp.layTatCaCT_PhieuDatPhongTheoMaPhieuDatPhong(pdp.getMaPhieuDatPhong()+"");
				for (CT_PhieuDatPhong ct_PhieuDatPhong : dsCTPDP) {
					themDongVaoBang2(ct_PhieuDatPhong);
				}
				int rowCTPDP = table2.getRowCount();
				for(int j = 0 ; j < rowCTPDP;j++) {
					if(maCTPDPCuaPhong == Integer.parseInt(tableModel2.getValueAt(j, 0).toString())) {
						table2.getSelectionModel().setSelectionInterval(j,j);
					}
				}
				KhachHang kh = qlkh.timKhacHangTheoMa(pdp.getKhachHang().getMaKhachHang());
				txtMaKhachHang.setText(kh.getMaKhachHang());
				txtTenKhachHang.setText(kh.getTenKhachHang());
				txtCMND.setText(kh.getcMND());
				txtSoDienThoai.setText(kh.getSoDienThoai());
				txtGioiTinh.setText(kh.getGioiTinh());
				dcNgaySinh.setDate(kh.getNgaySinh());
				if(count >1) {
					countTruoc=countSau;
					countSau=ma;
					if(ma.equals(txtMaPhong.getText().trim())){
						btnPhong[i].setBackground(Color.decode("#FFCC00"));
					}
					for(int j = 0 ;j < btnPhong.length;j++) {
						int dau1 = btnPhong[j].getText().indexOf("<!--id");
						int cuoi1 = btnPhong[j].getText().indexOf("id-->");
						String ma1 = btnPhong[j].getText().substring(dau1 + 6, cuoi1);
						if(ma1.equals(countTruoc) && !ma1.equals(countSau)) {
							ArrayList<Phong> dsPhong = qlp.timPhongTheoTatCaGomTinhTrangHuy(countTruoc,"","","","","");
							Phong p =dsPhong.get(0);
							if (p.getTinhTrangPhong() == 0) { // chưa đặt
								btnPhong[j].setBackground(Color.decode("#77d56c"));
							}else if(p.getTinhTrangPhong() == 3) {// da dat
								btnPhong[j].setBackground(Color.decode("#0080FF"));
							}else if (p.getTinhTrangPhong() == 1) { // đăng sử dụng
								btnPhong[j].setBackground(Color.decode("#ea5483"));
							} else if (p.getTinhTrangPhong() == 2) { // đến hạn trả
								btnPhong[j].setBackground(Color.decode("#e33309"));
							}
						}
					}
				}
			}
		} if(o.equals(btnTimKiem)) {
			timPhong();
		}else if(o.equals(btnLamMoi)) {
			xoaBang2();
			lamMoiTextfields();
			xoaBang1();
		}else if(o.equals(btnQuayLai)) {
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
		}else if(o.equals(btnHuyTaCaPhong)) {
			int row =table1.getSelectedRow();
			int maPDP = Integer.parseInt(tableModel1.getValueAt(row, 0).toString());
			int kq= JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy tất cả các phòng của phiếu đặt phòng "+maPDP+" không","Nhắc nhở",JOptionPane.YES_NO_OPTION);
			String maPhong = "";
			ArrayList<CT_PhieuDatPhong> dsCTPDP = qlctpdp.layTatCaCT_PhieuDatPhongTheoMaPhieuDatPhong(maPDP+"");
			for (CT_PhieuDatPhong ct_PhieuDatPhong : dsCTPDP) {
				maPhong+=ct_PhieuDatPhong.getPhong().getMaPhong()+" ";
				qlctpdp.xoaCT_PhieuDatPhong(ct_PhieuDatPhong.getMaCT_PhieuDatPhong());
			}
			if(kq == JOptionPane.YES_OPTION) {
				if(qlpdp.xoaPhieuDatPhong(maPDP)) {
					JOptionPane.showMessageDialog(this, "Hủy phòng "+maPhong+" thành công");
					lamMoiTextfields();
					xoaBang1();
					xoaBang2();
				}else {
					JOptionPane.showMessageDialog(this, "Hủy phòng "+maPhong+" không thành công");
					xoaBang1();
					xoaBang2();
					lamMoiTextfields();
				}
			}
		}else if(o.equals(btnHuyPhong)) {
			
			ArrayList<CT_PhieuDatPhong> dsCTPDP = qlctpdp.layCT_PhieuDatPhongTheoMaPhong(txtMaPhong.getText());
			CT_PhieuDatPhong CTPDP = dsCTPDP.get(0);
			int maCTPDP = CTPDP.getMaCT_PhieuDatPhong();
			int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy phòng "+txtMaPhong.getText()+" của phiếu đặt phòng "+tableModel1.getValueAt(table1.getRowCount()-1,0).toString()+" không?"
					,"Nhắc nhở",JOptionPane.YES_NO_OPTION);
			if(kq == JOptionPane.YES_OPTION) {
				if(qlctpdp.xoaCT_PhieuDatPhong(maCTPDP)) {
					JOptionPane.showMessageDialog(this, "Hủy phòng "+txtMaPhong.getText()+" thành công");
					lamMoiTextfields();
					xoaBang1();
					xoaBang2();
				}else {
					JOptionPane.showMessageDialog(this, "Hủy phòng "+txtMaPhong.getText()+" không thành công");
					lamMoiTextfields();
					xoaBang1();
					xoaBang2();
				}
			}
		}
	}
	public void themDongVaoBang2(CT_PhieuDatPhong ctpdp) {
		tableModel2.addRow(new Object[] {
				ctpdp.getMaCT_PhieuDatPhong(),ctpdp.getPhong().getMaPhong(),ctpdp.getNgayDen()
				,ctpdp.getNgayDi()
		});
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
			new GUIMenu(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void themDongVaoBang1(PhieuDatPhong pdp) {
		CT_PhieuDatPhong ctpdp = qlctpdp.layCT_PhieuDatPhongTheoMaPhieuDatPhong(pdp.getMaPhieuDatPhong()+"");
		tableModel1.addRow(new Object[] {
			pdp.getMaPhieuDatPhong(),pdp.getKhachHang().getMaKhachHang(),qlkh.timKhacHangTheoMa(pdp.getKhachHang().getMaKhachHang()).getTenKhachHang(),
			qlkh.timKhacHangTheoMa(pdp.getKhachHang().getMaKhachHang()).getSoDienThoai(),ctpdp.getNgayDen(),ctpdp.getNgayDi()
		});
		table1.setModel(tableModel1);
	}
	public void xoaBang2() {
		while(table2.getRowCount() >0) {
			tableModel2.removeRow(0);
		}
	}	
	public void xoaBang1() {
		while(table1.getRowCount() >0) {
			tableModel1.removeRow(0);
		}
	}
	public void lamMoiTextfields() {
		txtMaPhong.setText("");
		txtGiaPhong.setText("");
		txtLoaiPhong.setText("");
		txtSoGiuong.setText("");
		txtMoTa.setText("");
		txtSoNguoi.setText("");
		btnHuyTaCaPhong.setEnabled(false);
		ArrayList<Phong> dsPhong = qlp.timPhongTheoTatCaGomTinhTrangHuy("", "", "", "", "", "");
		goiDanhSachPhong(p, b4, dsPhong);
		btnHuyPhong.setEnabled(false);
		txtMaKhachHang.setText("");
		txtTenKhachHang.setText("");
		txtCMND.setText("");
		txtSoDienThoai.setText("");
		txtGioiTinh.setText("");
		dcNgaySinh.setDate(null);
	}
	public void timPhong() {
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
		ArrayList<Phong> dsPhongTim = qlp.timPhongTheoTatCaGomTinhTrangHuy(maPhong, gia, soGiuong, soNguoi, moTa,
				loaiPhong);
		if(kq == JOptionPane.YES_OPTION) {
			if (dsPhongTim.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy phòng");
				goiDanhSachPhong(p, b4, qlp.layDanhSachPhongTheoTinhTrang("Đã đặt"));
				String ma = this.txtMaPhong.getText().trim();
				for(int i = 0 ; i < btnPhong.length;i++) {
					int dau = btnPhong[i].getText().indexOf("<!--id");
					int cuoi = btnPhong[i].getText().indexOf("id-->");
					String maP = btnPhong[i].getText().substring(dau + 6, cuoi);
					if(maP.equals(ma))
						btnPhong[i].setBackground(Color.decode("#FFCC00"));
				}
			}else {
				goiDanhSachPhong(p, b4, dsPhongTim);
				String ma = this.txtMaPhong.getText().trim();
				for(int i = 0 ; i < btnPhong.length;i++) {
					int dau = btnPhong[i].getText().indexOf("<!--id");
					int cuoi = btnPhong[i].getText().indexOf("id-->");
					String maP = btnPhong[i].getText().substring(dau + 6, cuoi);
					if(maP.equals(ma))
						btnPhong[i].setBackground(Color.decode("#FFCC00"));
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
		Object o = e.getSource();
		if(o.equals(table1)) {
			btnHuyTaCaPhong.setEnabled(true);
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
}
