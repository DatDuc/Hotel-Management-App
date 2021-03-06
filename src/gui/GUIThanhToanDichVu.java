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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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

import dao.QuanLyCT_DichVu_DAO;
import dao.QuanLyDichVu_DAO;
import dao.QuanLyHoaDon_DichVu;
import dao.QuanLyNhanVien_DAO;
import dao.QuanLyPhong_DAO;
import entity.DichVu;
import entity.HoaDon_DichVu;
import entity.Phong;

public class GUIThanhToanDichVu extends JPanel implements ActionListener{
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
	private JButton btnDenHan;
	private JButton btnDangSuDung;
	private JButton btnDaDat;
	private JLabel lblTongSoPhong;
	private JLabel tongSoPhong;
	private JLabel lblHinhTongSoPhong;
	private JButton btnQuayLai;
	private static JButton[] btnPhong;
	public static String maPhong;
	public static String maNV;
	public static int maPhieu;
	private QuanLyCT_DichVu_DAO qlctdv = new QuanLyCT_DichVu_DAO();
	private QuanLyHoaDon_DichVu qlhddv = new QuanLyHoaDon_DichVu();
	private QuanLyPhong_DAO qlp = new QuanLyPhong_DAO();
	private JLabel lblTitle2;
	private Box b4;
	private QuanLyDichVu_DAO qldv = new QuanLyDichVu_DAO();
	private QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
	private JButton btnThanhToan;
	private JButton btnLamMoi;
	private TitledBorder titleBorderNut;
	private JButton btnHuyDichVuThanhToan;
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
	private JButton btnThemCTDV;
	private DefaultTableModel tableModel2;
	private JTable table2;
	private JScrollPane scroll2;
	private JTextField txtSoLuong;
	private JButton btnNhapSo;
	private JLabel lblSoNguoi;
	private JTextField txtSoNguoi;
	private JLabel lblTongTien;
	private JTextField txtTongTien;
	private JButton btnTraPhong;
	private JButton btnDangChon;
	private static int count=1;
	private static String countTruoc=null;
	private static String countSau=null;
	
	public GUIThanhToanDichVu(Frame cha) {
		frameCha = cha;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int rong = screenSize.width;
		int cao = screenSize.height;
		Box bMain, b123,b1, b2, b;
		pNorth1 = new JPanel();
		pNorth1.add(lblTitle = new JLabel("DANH S??CH PH??NG KH??CH S???N"));
		add(bMain = Box.createVerticalBox());
		bMain.add(b123 = Box.createHorizontalBox());
		b123.add(Box.createHorizontalStrut(50));
		b123.add(b1 = Box.createVerticalBox());
		b1.add(b = Box.createHorizontalBox());
		b.add(pNorth1, BorderLayout.NORTH);
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTitle.setForeground(new Color(0xFFAA00));
		b1.add(b = Box.createHorizontalBox());
		b.add(lblTongSoPhong = new JLabel("T???ng s??? ph??ng: "));
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
		goiDanhSachPhong(p, b4, qlp.layTatCaCacPhongGomTinhTrangTra());
		b1.setPreferredSize(new Dimension(rong/2, cao - 320));
		b4.setBorder(titleBorderPhong = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Danh s??ch ph??ng"));
		b4.setPreferredSize(new Dimension((rong/2)-20, cao-320));
		titleBorderPhong.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderPhong.setTitleColor(new Color(0xFFAA00));
		titleBorderPhong.setTitlePosition(TitledBorder.ABOVE_TOP);
		b1.add(b = Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(50));
		b1.add(b = Box.createHorizontalBox());
		JLabel lblDangSuDung, lblDangDuocDat, lblDenHan,lblDangChon;
		b.add(btnDaDat = new JButton(new ImageIcon(".\\image\\blueRound26.png")));
		btnDaDat.setContentAreaFilled(false);
		btnDaDat.setFocusPainted(false);
		btnDaDat.setBorder(BorderFactory.createEmptyBorder());
		b.add(lblDangDuocDat= new JLabel("Ph??ng ??ang ???????c ?????t"));
		lblDangDuocDat.setFont(new Font("SansSerif", Font.ITALIC, 15));
		b.add(btnDangSuDung = new JButton(new ImageIcon(".\\image\\pinkRound26.png")));
		btnDangSuDung.setContentAreaFilled(false);
		btnDangSuDung.setFocusPainted(false);
		btnDangSuDung.setBorder(BorderFactory.createEmptyBorder());
		b.add(lblDangSuDung = new JLabel("Ph??ng ??ang s??? d???ng"));
		lblDangSuDung.setFont(new Font("SansSerif", Font.ITALIC, 15));
		b.add(btnDenHan = new JButton(new ImageIcon(".\\image\\redRound26.png")));
		btnDenHan.setContentAreaFilled(false);
		btnDenHan.setFocusPainted(false);
		btnDenHan.setBorder(BorderFactory.createEmptyBorder());
		b.add(lblDenHan = new JLabel("Ph??ng ?????n h???n tr???"));
		lblDenHan.setFont(new Font("SansSerif", Font.ITALIC, 15));
		b.add(btnDangChon= new JButton(new ImageIcon(".\\image\\yellowRound26.png")));
		btnDangChon.setContentAreaFilled(false);
		btnDangChon.setFocusPainted(false);
		btnDangChon.setBorder(BorderFactory.createEmptyBorder());
		b.add(lblDangChon = new JLabel("Ph??ng ??ang ch???n"));
		lblDangChon.setFont(new Font("SansSerif", Font.ITALIC, 15));
		b.setBorder(titleBorderChuThich = new TitledBorder(BorderFactory.createLineBorder(Color.red), "T??m ki???m"));
		titleBorderChuThich.setTitleColor(new Color(0xFFAA00));
		titleBorderChuThich.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		b.setToolTipText("Ch???n ????? l???c t??nh tr???ng ph??ng!");
		b.add(Box.createHorizontalStrut(5));
		b.add(btnTimKiem = new JButton("T??m ki???m", new ImageIcon(".\\image\\search32.png")));
		btnTimKiem.addActionListener(this);
		b123.add(b2 = Box.createVerticalBox());
		b2.add(b = Box.createHorizontalBox());
		b123.add(Box.createHorizontalStrut(50));
		JPanel pNorth2 = new JPanel();
		pNorth2.add(lblTitle2 = new JLabel("THANH TO??N D???CH V???"));
		b.add(pNorth2, BorderLayout.NORTH);
		lblTitle2.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTitle2.setForeground(new Color(0xFFAA00));
		b2.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(100));
		b.add(lblMaPhong = new JLabel("M?? ph??ng: "));
		b.add(txtMaPhong= new JTextField());
		b.add(Box.createHorizontalStrut(100));
		b2.add(Box.createVerticalStrut(8));
		b2.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(100));
		b.add(lblLoaiPhong =new JLabel("Lo???i ph??ng: "));
		b.add(txtLoaiPhong= new JTextField());
		b2.add(Box.createVerticalStrut(8));
		b.add(Box.createHorizontalStrut(100));
		b2.add(b= Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(100));
		b.add(lblGiaPhong =new JLabel("Gi?? ph??ng : "));
		b.add(txtGiaPhong= new JTextField());
		b.add(Box.createHorizontalStrut(100));
		b2.add(Box.createVerticalStrut(8));
		b2.add(b= Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(100));
		b.add(lblMoTa=new JLabel("M?? t???: "));
		b.add(txtMoTa= new JTextField());
		b.add(Box.createHorizontalStrut(100));
		b2.add(Box.createVerticalStrut(8));
		b2.add(b= Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(100));
		b.add(lblSoGiuong=new JLabel("S??? gi?????ng: "));
		b.add(txtSoGiuong= new JTextField());
		b.add(Box.createHorizontalStrut(100));
		b2.add(Box.createVerticalStrut(8));
		b2.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(100));
		b.add(lblSoNguoi=new JLabel("S??? ng?????i: "));
		b.add(txtSoNguoi= new JTextField());
		b.add(Box.createHorizontalStrut(100));
		b2.add(Box.createVerticalStrut(10));
		b2.setBorder(titleBorderPhong = new TitledBorder(BorderFactory.createLineBorder(Color.red),"Th??ng tin ph??ng"));
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
		String[] header = "M?? d???ch v???;T??n d???ch v???;????n v???;S??? l?????ng;????n gi??".split(";");
		tableModel1= new DefaultTableModel(header, 0);
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
		DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
		centerRenderer1.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < table1.getColumnCount(); i++) {
			table1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer1);
		}
		table1.setAutoCreateRowSorter(true);
		// tableModel.isCellEditable(row, column);
		scroll1 = new JScrollPane(table1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollDichVu1.setPreferredSize(new Dimension(950, 530));
		JTableHeader header1 = table1.getTableHeader();
		header1.setOpaque(false); // x??t c???ng c???t
		table1.getTableHeader().setReorderingAllowed(false);
//		scrollDichVu1.setPreferredSize(new Dimension(400, 300));
		b.add(scroll1);
		scroll1.setPreferredSize(new Dimension(rong/3,170));
		b2.add(Box.createVerticalStrut(10));
		b2.add(b =Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(70));
		b.add(btnThemCTDV = new JButton("Th??m d???ch v??? kh??ch h??ng s??? d???ng",new ImageIcon(".\\image\\ctdv.jpg")));
		b.add(Box.createHorizontalStrut(50));
		b.add(lblTongTien = new JLabel("T???ng ti???n: "));
		b.add(txtTongTien = new JTextField());
		b.add(Box.createHorizontalStrut(50));
		b.add(btnTraPhong = new JButton("Tr??? ph??ng",new ImageIcon(".\\image\\checkout32.png")));
		b.add(Box.createHorizontalStrut(50));
		txtTongTien.setMaximumSize(new Dimension(150, 25));
		lblTongTien.setFont(new Font("SansSerif",Font.BOLD,15));
		txtTongTien.setEditable(false);
		txtTongTien.setForeground(Color.BLUE);
		String[] header2 = "M?? d???ch v???;T??n d???ch v???;????n v???;????n gi??;S??? l?????ng s??? d???ng;Th??nh ti???n;".split(";");
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
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < table2.getColumnCount(); i++) {
			table2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		table2.setAutoCreateRowSorter(true);
		// tableModel.isCellEditable(row, column);
		scroll2 = new JScrollPane(table2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll2.setPreferredSize(new Dimension(rong/3,170));
		b2.add(Box.createVerticalStrut(10));
		b2.add(b =Box.createHorizontalBox());
		b.add(scroll2);
		b2.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b.add(new JLabel("S??? l?????ng: "));
		b.add(Box.createHorizontalStrut(5));
		b.add(txtSoLuong = new JTextField("Nh???p s??? l?????ng s??? d???ng"));
		b2.setPreferredSize(new Dimension(rong/2, cao-140));
		txtSoLuong.setForeground(Color.BLUE);
		txtSoLuong.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		txtSoLuong.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSoLuong.getText().isEmpty()) {
					txtSoLuong.setText("Nh???p s??? l?????ng s??? d???ng");
					txtSoLuong.setForeground(Color.BLUE);
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSoLuong.getText().equals("Nh???p s??? l?????ng s??? d???ng")) {
					txtSoLuong.setText("");
					txtSoLuong.setForeground(Color.BLACK);
				}
				
			}
		});
		b.add(Box.createHorizontalStrut(5));
		b.add(btnNhapSo = new JButton(new ImageIcon(".\\image\\accepticon48.png")));
		txtSoLuong.setMaximumSize(new Dimension(200, 23));
		btnNhapSo.setContentAreaFilled(false);
		btnNhapSo.setBorder(BorderFactory.createEmptyBorder());
		btnNhapSo.setFocusPainted(false);
		b.add(Box.createHorizontalStrut(5));
		b.add(btnThanhToan = new JButton("Thanh to??n", new ImageIcon(".\\image\\iconthanhtoan32.png")));
		b.add(Box.createHorizontalStrut(10));
		b.add(btnHuyDichVuThanhToan = new JButton("H???y d???ch v???", new ImageIcon(".\\image\\refuseicon32.png")));
		b.add(Box.createHorizontalStrut(10));
		b.add(btnLamMoi = new JButton("L??m m???i", new ImageIcon(".\\image\\reload32.png")));
		b.add(Box.createHorizontalStrut(20));
		b.add(btnQuayLai = new JButton("Quay l???i", new ImageIcon(".\\image\\logout32.png")));
		btnQuayLai.setBackground(Color.red);
		b.add(Box.createHorizontalStrut(5));
		b.setBorder(titleBorderNut = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Ch???n thao t??c"));
		titleBorderNut.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderNut.setTitleColor(new Color(0xFFAA00));
		docDuLieuDichVu();
		btnTraPhong.setEnabled(false);
		btnQuayLai.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnHuyDichVuThanhToan.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnThemCTDV.addActionListener(this);
		btnNhapSo.addActionListener(this);
		btnDaDat.addActionListener(this);
		btnDangSuDung.addActionListener(this);
		btnDenHan.addActionListener(this);
		btnTraPhong.addActionListener(this);
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
			if (phong.getTinhTrangPhong() == 0) { // ch??a ?????t
				mauSac = "#77d56c";
			}else if(phong.getTinhTrangPhong() == 3) {// da dat
				mauSac="#0080FF";		
			}else if (phong.getTinhTrangPhong() == 1) { // ????ng s??? d???ng
				mauSac = "#ea5483";
			} else if (phong.getTinhTrangPhong() == 2) { // ?????n h???n tr???
				mauSac = "#e33309";
			}
			dsThongTinPhong.add("<html><center>Ph??ng: " + phong.getMaPhong() + "<br/>" + "M?? t???: " + phong.getMoTa()
					+ "<br/>" + "Gi??: " + df.format(phong.getGiaPhong()) + "<br/>" + "Lo???i ph??ng: "
					+ qlp.layTenLoaiPhong(phong.getLoaiPhong().getMaLoai()).getTenLoai() + "<br/>" + "S??? gi?????ng: "
					+ phong.getSoGiuong() + "<br/>" + "S??? ng?????i:" + phong.getSoNguoi() + "<!--color" + mauSac
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
				txtMaPhong.setText(phong.getMaPhong());
				DecimalFormat df = new DecimalFormat("###.#");
				txtGiaPhong.setText(df.format(phong.getGiaPhong()));
				txtLoaiPhong.setText(qlp.layTenLoaiPhong(phong.getLoaiPhong().getMaLoai()).getTenLoai());
				txtSoGiuong.setText(phong.getSoGiuong()+"");
				txtMoTa.setText(phong.getMoTa());
				txtSoNguoi.setText(phong.getSoNguoi()+"");
				xoaBangDichVu2();
				txtTongTien.setText("");
				btnTraPhong.setEnabled(true);
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
							ArrayList<Phong> dsPhong = qlp.timPhongTheoTatCaGomTinhTrangTra(countTruoc,"","","","","");
							Phong p =dsPhong.get(0);
							if (p.getTinhTrangPhong() == 0) { // ch??a ?????t
								btnPhong[j].setBackground(Color.decode("#77d56c"));
							}else if(p.getTinhTrangPhong() == 3) {// da dat
								btnPhong[j].setBackground(Color.decode("#0080FF"));
							}else if (p.getTinhTrangPhong() == 1) { // ????ng s??? d???ng
								btnPhong[j].setBackground(Color.decode("#ea5483"));
							} else if (p.getTinhTrangPhong() == 2) { // ?????n h???n tr???
								btnPhong[j].setBackground(Color.decode("#e33309"));
							}
						}
					}
				}
			}
		} if(o.equals(btnTimKiem)) {
			timPhong();
		}else if(o.equals(btnThemCTDV)) {
			btnTraPhong.setEnabled(false);
			int row =-1;
			row = table1.getSelectedRow();
			int row2 = table2.getRowCount();
			if(txtMaPhong.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui l??ng ch???n ph??ng tr?????c");
			}else {
			if(row == -1) 
				JOptionPane.showMessageDialog(this, "Vui l??ng ch???n d???ch v??? mu???n thanh to??n");
			else {
				String maDV = tableModel1.getValueAt(row, 0).toString();
				String ten = tableModel1.getValueAt(row, 1).toString();
				String donVi = tableModel1.getValueAt(row, 2).toString();
				String donGia = tableModel1.getValueAt(row, 4).toString();
				//String[] header2 = "M?? d???ch v???;T??n d???ch v???;????n v???;????n gi??;S??? l?????ng s??? d???ng;Th??nh ti???n;".split(";");
				tableModel2.addRow(new Object[] {
						maDV,ten,donVi,donGia,0,0
					});
				table1.getSelectionModel().clearSelection();
				table2.getSelectionModel().setSelectionInterval(row2, row2);
			}
			}
		}else if(o.equals(btnNhapSo)) {
			int row = -1;
			row = table2.getSelectedRow();
			String soLuong = txtSoLuong.getText().trim();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui l??ng ch???n d???ch v??? thanh to??n");
			}
			else {
				if(!soLuong.matches("^([1-9]{1,})([0-9]{0,})")){
					JOptionPane.showMessageDialog(this, "S??? l?????ng s??? d???ng ph???i l?? s??? l?????ng h??n 0");
				}else {
					DichVu dv = qldv.timDichVuTheoMa(tableModel2.getValueAt(row, 0).toString());
					if(Integer.parseInt(soLuong) > dv.getSoLuong() && dv.getDonVi().equals("Lon")) {
						JOptionPane.showMessageDialog(this, "S??? l?????ng s??? d???ng kh??ng qu?? "+dv.getSoLuong());
					}else if(Integer.parseInt(soLuong) > dv.getSoLuong() && dv.getDonVi().equals("Chai")) {
						JOptionPane.showMessageDialog(this, "S??? l?????ng s??? d???ng ph???i ??t h??n ho???c b???ng s??? l?????ng hi???n t???i c???a d???ch v???");
					}else {
						tableModel2.setValueAt(soLuong, row, 4);
						DecimalFormat df = new DecimalFormat("###.#");
						double thanhTien = Integer.parseInt(soLuong)*Double.parseDouble(tableModel2.getValueAt(table2.getSelectedRow(),3).toString());
						tableModel2.setValueAt(df.format(thanhTien), row,5);
						int row2 = table2.getRowCount();
						double tongTien = 0;
						for(int i = 0 ; i<row2;i++) {
							tongTien+=Double.parseDouble(tableModel2.getValueAt(i, 5).toString());
						}
						DecimalFormat df1 = new DecimalFormat("#,###.# VND");
						txtTongTien.setText(df1.format(tongTien));
						txtSoLuong.setText("Nh???p s??? l?????ng s??? d???ng");
						txtSoLuong.setForeground(Color.blue);
						table2.getSelectionModel().clearSelection();
					}
				}
			}
		}else if(o.equals(btnLamMoi)) {
			xoaBangDichVu2();
			lamMoiTextfields();
			xoaBangDichVu1();
			docDuLieuDichVu();
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
		}else if(o.equals(btnThanhToan)) {
			String maPhong = txtMaPhong.getText().trim();
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String ngayHienTai = sdf.format(date);
			int row = -1;
			row = table2.getRowCount();
			if(maPhong.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui l??ng ch???n ph??ng mu???n thanh to??n");
			}
//			for(int i = 0 ; i < table2.getRowCount();i++) {
//				if(tableModel2.getValueAt(i, 4).toString().equals("")) {
//					flag = false;
//				}
//			}
//			if(flag == false) {
//				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p s??? l?????ng s??? d???ng cho d???ch v???");
//			}
			else{
				if(row <= 0) {
					JOptionPane.showMessageDialog(this, "Vui l??ng ch???n d???ch v??? mu???n thanh to??n");
				}else {
					int trong = -1;
					for(int i = 0 ; i < row ;++i) {
						String sl =tableModel2.getValueAt(i, 4).toString();
						if(sl.equals("0")) {
							trong++;
						}
					}
					if(trong != -1) {
						JOptionPane.showMessageDialog(this, "Vui l??ng nh???p s??? l?????ng s??? d???ng cho d???ch v???");
					}else {
						int kq = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n thanh to??n c??c d???ch v??? kh??ng?", "Nh???c nh???", JOptionPane.YES_NO_OPTION);
						if(kq == JOptionPane.YES_OPTION) {
							if(qlhddv.themHoaDon_DichVu(ngayHienTai, maPhong, GUIDangNhap.ma)) {
								int maHDDV = qlhddv.layMaHoaDonLonNhat();
								for(int i = 0 ; i < table2.getRowCount() ; i++) {
									qlctdv.themCTDV(tableModel2.getValueAt(i,0).toString(),maHDDV,Integer.parseInt(tableModel2.getValueAt(i, 4).toString()));
									DichVu dv = qldv.timDichVuTheoMa(tableModel2.getValueAt(i, 0).toString());
									int soLuongConLai = dv.getSoLuong() - Integer.parseInt(tableModel2.getValueAt(i, 4).toString());
									qldv.capNhatSoLuongSuDung(tableModel2.getValueAt(i, 0).toString(),soLuongConLai+"");
									int in = JOptionPane.showConfirmDialog(this, "Thanh to??n d???ch v??? th??nh c??ng v?? in h??a ????n cho kh??ch h??ng","Nh???c nh???",JOptionPane.YES_NO_OPTION);
									if(in == JOptionPane.YES_OPTION) {
										inHoaDonDichVu();
										xoaBangDichVu1();
										docDuLieuDichVu();
										xoaBangDichVu2();
										txtTongTien.setText("");
										txtSoLuong.setText("Nh???p s??? l?????ng s??? d???ng");
										txtSoLuong.setForeground(Color.blue);
										txtTongTien.setText("");
										btnTraPhong.setEnabled(true);
									}else {
										xoaBangDichVu1();
										docDuLieuDichVu();
										xoaBangDichVu2();
										txtTongTien.setText("");
										txtSoLuong.setText("Nh???p s??? l?????ng s??? d???ng");
										txtSoLuong.setForeground(Color.blue);
										txtTongTien.setText("");
										btnTraPhong.setEnabled(true);
									}
								}
							}else {
								JOptionPane.showMessageDialog(this, "Thanh to??n d???ch v??? kh??ng th??nh c??ng");
							}
						}
					}
				}
			}
		}else if(o.equals(btnDaDat)) {
			ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoTinhTrang("???? ?????t");
			goiDanhSachPhong(p, b4, dsPhong);
		}else if(o.equals(btnDangSuDung)) {
			ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoTinhTrang("??ang s??? d???ng");
			goiDanhSachPhong(p, b4, dsPhong);
		}else if(o.equals(btnDenHan)) {
			ArrayList<Phong> dsPhong = qlp.layDanhSachPhongTheoTinhTrang("?????n h???n");
			goiDanhSachPhong(p, b4, dsPhong);
		}else if(o.equals(btnHuyDichVuThanhToan)) {
			int rowCount = table2.getRowCount();
			int row = -1;
			row = table2.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui l??ng ch???n d???ch v??? thanh to??n mu???n h???y");
			}else {
				if (rowCount == 1) {
					btnTraPhong.setEnabled(true);
				}
				tableModel2.removeRow(row);
			}
		}else if(o.equals(btnTraPhong)) {
			String ma = GUIDangNhap.ma;
			maPhong = txtMaPhong.getText().trim();
			if(ma.equals("NV000001")) {
				menu = new GUIMenu(1);
				menu.doiPanel(new GUIDanhSachPhongTra(menu));
				frameCha.dispose();
			}else {
				GUIMenuDanhChoNhanVien menuNV = new GUIMenuDanhChoNhanVien(qlnv.layNhanVienTheoMa(ma).getTenNhanVien());
				menuNV.doiPanel(new GUIDanhSachPhongTra(menuNV));
				frameCha.dispose();
			}
		}
	}
	public void docDuLieuDichVu() {
		ArrayList<DichVu> dsDichVu = qldv.layToanBoDichVu();
		for (DichVu dichVu : dsDichVu) {
			themDongVaoBangDichVu1(dichVu);
		}
	}
	public void themDongVaoBangDichVu1(DichVu dv) {
//		String[] header = "M?? d???ch v???;T??n d???ch v???;????n v???;S??? l?????ng;????n gi??".split(";");
		DecimalFormat df = new DecimalFormat("###.#");
		tableModel1.addRow(new Object[] {
			dv.getMaDichVu(),dv.getTenDichVu(),dv.getDonVi(),dv.getSoLuong(),df.format(dv.getGia())	
		});
		table1.setModel(tableModel1);
	}
	public void xoaBangDichVu2() {
		while(table2.getRowCount() >0) {
			tableModel2.removeRow(0);
		}
	}	
	public void xoaBangDichVu1() {
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
		txtTongTien.setText("");
		txtSoLuong.setText("Nh???p s??? l?????ng s??? d???ng");
		txtSoLuong.setForeground(Color.blue);
		btnTraPhong.setEnabled(false);
		ArrayList<Phong> dsPhong = qlp.layTatCaCacPhongGomTinhTrangTra();
		goiDanhSachPhong(p, b4, dsPhong);
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
		b.add(lblMaPhong = new JLabel("M?? ph??ng: "));
		b.add(txtMaPhong = new JTextField());
		b123.add(Box.createVerticalStrut(10));
		b123.add(b = Box.createHorizontalBox());
		b.add(lblSoGiuong = new JLabel("S??? gi?????ng: "));
		b.add(txtSoGiuong = new JTextField());
		b123.add(Box.createVerticalStrut(10));
		b123.add(b = Box.createHorizontalBox());
		b.add(lblmoTa = new JLabel("M?? t???: "));
		b.add(txtmoTa = new JTextField());
		b123.add(Box.createVerticalStrut(10));
		b123.setPreferredSize(new Dimension(150, 100));
		b12.add(b2 = Box.createVerticalBox());
		b2.add(b = Box.createHorizontalBox());
		b.add(lblGiaPhong = new JLabel("Gi?? ph??ng: "));
		b.add(txtGiaPhong = new JTextField());
		b2.add(Box.createVerticalStrut(10));
		b2.add(b = Box.createHorizontalBox());
		b.add(lblSoNguoi = new JLabel("S??? ng?????i: "));
		b.add(txtSoNguoi = new JTextField());
		b2.add(Box.createVerticalStrut(10));
		b2.add(b = Box.createHorizontalBox());
		b.add(lblLoaiPhong = new JLabel("Lo???i ph??ng: "));
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
		int kq = JOptionPane.showConfirmDialog(null, p1, "T??m ph??ng", JOptionPane.YES_NO_OPTION,
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
				JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y ph??ng");
				goiDanhSachPhong(p, b4, qlp.layTatCaCacPhongGomTinhTrangTra());
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

	public void inHoaDonDichVu() {
		JLabel lblMaPDP,lblMaNV,lblMaKhachHang;
		JPanel p = new JPanel();
		Box bMain,b,b1,b2,b12;
		int maHDDV = qlhddv.layMaHoaDonLonNhat();
		HoaDon_DichVu hddv = qlhddv.timHoaDonDichVuTheoMaHD(maHDDV);
		p.setBackground(Color.WHITE);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		int rowCTDV = table2.getRowCount();
		p.add(bMain = Box.createVerticalBox());
		bMain.add(b = Box.createHorizontalBox());
		b.add(new JLabel(new ImageIcon(".\\image\\everestBill.png")));
		bMain.add(b12 = Box.createHorizontalBox());
		b12.add(b1 = Box.createVerticalBox());
		b1.add(b = Box.createHorizontalBox());
		b.add(lblMaPDP = new JLabel("M?? h??a ????n d???ch v???: "+hddv.getMaHoaDon_DV()+"     "));
		b1.add(Box.createVerticalStrut(20));
		b1.add(b = Box.createHorizontalBox());
		b.add(lblMaNV = new JLabel("M?? nh??n vi??n: " +GUIDangNhap.ma+"      "));
		b1.add(Box.createVerticalStrut(20));
		b1.add(b = Box.createHorizontalBox());
		b.add(lblMaKhachHang = new JLabel("M?? ph??ng: "+txtMaPhong.getText().trim()+"     "));
		b1.add(Box.createVerticalStrut(20));
		b12.add(b2 = Box.createVerticalBox());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ngayHienTai = sdf.format(date);
		b2.add(b = Box.createHorizontalBox());
		b.add(new JLabel("Ng??y l???p phi???u: "+ngayHienTai+"      "));
		b2.add(Box.createVerticalStrut(20));
		b2.add(b = Box.createHorizontalBox());
		b.add(new JLabel("T??n nh??n vi??n: "+qlnv.layNhanVienTheoMa(GUIDangNhap.ma).getTenNhanVien()+"      "));
		b2.add(Box.createVerticalStrut(20));
//		b2.add(b = Box.createHorizontalBox());
//		b.add(lblTenKH = new JLabel("T??n kh??ch h??ng: "+txtTenKhachHang.getText().trim()+"      "));
//		b2.add(Box.createVerticalStrut(20));
		bMain.add(b = Box.createHorizontalBox());
		DefaultTableModel modelTableIn= new DefaultTableModel(0,6);
		modelTableIn.addRow(new Object[] {
			"M?? d???ch v???","T??n d???ch v???","????n v???","????n gi??","S??? l?????ng s??? d???ng","Th??nh ti???n"});
		JTable tableIn = new JTable(modelTableIn);
		tableIn.setAutoCreateRowSorter(true);
		DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
		renderCenter.setHorizontalAlignment(JLabel.CENTER);
		JTableHeader headerTable = new JTableHeader();
		headerTable.setOpaque(false);
		tableIn.getTableHeader().setReorderingAllowed(false);
		for(int i = 0 ; i <6;++i) {
			tableIn.getColumnModel().getColumn(i).setCellRenderer(renderCenter);
		}
		int widthCol[]= {15,15,15,15,30,25}; 
		for(int i = 0 ; i <6;++i) {
			tableIn.getColumnModel().getColumn(i).setPreferredWidth(widthCol[i]*3);;
		}
		JScrollPane scrollIn = new JScrollPane(tableIn);
		bMain.add(scrollIn);
		scrollIn.setPreferredSize(new Dimension(600, 200));
		lblMaPDP.setPreferredSize(lblMaKhachHang.getPreferredSize());
		lblMaNV.setPreferredSize(lblMaKhachHang.getPreferredSize());
		bMain.add(b = Box.createHorizontalBox());
		b.add(new JLabel("T???ng ti???n: "+txtTongTien.getText().trim()+"        "));
		bMain.add(b = Box.createHorizontalBox());
		b.add(new JLabel("C???m ??n qu?? kh??ch!      "));
		for(int i = 0 ; i < rowCTDV ; i++) {
			modelTableIn.addRow(new Object[] {
					tableModel2.getValueAt(i, 0).toString(),
					tableModel2.getValueAt(i, 1).toString(),
					tableModel2.getValueAt(i, 2).toString(),
					tableModel2.getValueAt(i, 3).toString(),
					tableModel2.getValueAt(i, 4).toString(),
					tableModel2.getValueAt(i, 5).toString()
			});
		}
		int kq = JOptionPane.showConfirmDialog(this, p,"IN H??A ????N D???CH V???",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
			if(kq == JOptionPane.YES_OPTION) {
				PrinterJob pj = PrinterJob.getPrinterJob();
				pj.setJobName("HoaDonDV_"+txtMaPhong.getText().trim()+"_"+ngayHienTai);
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
