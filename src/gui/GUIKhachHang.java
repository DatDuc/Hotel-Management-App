package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.toedter.calendar.JDateChooser;

import dao.QuanLyKhachHang_DAO;
import dao.QuanLyNhanVien_DAO;
import entity.KhachHang;

public class GUIKhachHang extends JPanel implements ActionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Frame frame;
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
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JButton btnQuayLai;
	private DefaultTableModel modelTable;
	private JTable table;
	private JButton btnTim;
	private QuanLyKhachHang_DAO qlkh = new QuanLyKhachHang_DAO();
	private JLabel lblThongBao;
	private GUIMenu menu;
	public static String ma;
	private QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();

	@SuppressWarnings("serial")
	public GUIKhachHang(Frame frameCha){
		frame = frameCha;
		Dimension manHinh = Toolkit.getDefaultToolkit().getScreenSize();
		int width = manHinh.width;
		int height= manHinh.height;
		JPanel pNorth = new JPanel();
		pNorth.add(lblTitle = new JLabel("QU???N L?? KH??CH H??NG"));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTitle.setForeground(new Color(0xFFAA00));
		Box bMain,b1,b2,b3,b123,b;
		bMain = Box.createVerticalBox();
		bMain.add(pNorth,BorderLayout.NORTH);
		bMain.add(Box.createVerticalStrut(50));
		bMain.add(b123 = Box.createHorizontalBox());
		b123.add(b1 = Box.createVerticalBox());
		b1.add(b = Box.createHorizontalBox());
		b.add(lblMaKhachHang = new JLabel("M?? kh??ch h??ng: "));
		b.add(txtMaKhachHang = new JTextField());
		b1.add(Box.createVerticalStrut(20));
		b1.add(b = Box.createHorizontalBox());
		b.add(lblCMND = new JLabel("CMND: "));
		b.add(txtCMND = new JTextField());
		b123.add(Box.createHorizontalStrut(50));
		b123.add(b2 = Box.createVerticalBox());
		b2.add(b = Box.createHorizontalBox());
		b.add(lblTenKhachHang = new JLabel("T??n kh??ch h??ng: "));
		b.add(txtTenKhachHang = new JTextField());
		b2.add(Box.createVerticalStrut(20));
		b2.add(b = Box.createHorizontalBox());
		b.add(lblSDT = new JLabel("S??? ??i???n tho???i: "));
		b.add(txtSDT = new JTextField());
		b123.add(Box.createHorizontalStrut(50));
		b123.add(b3 = Box.createVerticalBox());
		b3.add(b = Box.createHorizontalBox());
		b.add(lblGioitinh = new JLabel("Gi???i t??nh: "));
		b.add(Box.createHorizontalStrut(43));
		b.add(cboGioiTinh = new JComboBox<String>());
		cboGioiTinh.addItem("");
		cboGioiTinh.addItem("Nam");
		cboGioiTinh.addItem("N???");
		b3.add(Box.createVerticalStrut(20));
		b3.add(b = Box.createHorizontalBox());
		b.add(lblNgaySinh = new JLabel("Ng??y sinh: "));
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
		bMain.add(Box.createVerticalStrut(20));
		lblCMND.setPreferredSize(lblMaKhachHang.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblSDT.setPreferredSize(lblTenKhachHang.getPreferredSize());
		dcNgaySinh.setMaximumSize(new Dimension(150, 20));
		bMain.add(Box.createVerticalStrut(20));
		bMain.add(b1=Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(5));
		b1.add(btnThem = new JButton("Th??m", new ImageIcon(".\\image\\add32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnXoa = new JButton("X??a", new ImageIcon(".\\image\\remove32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnSua = new JButton("S???a", new ImageIcon(".\\image\\update32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnLamMoi = new JButton("L??m m???i", new ImageIcon(".\\image\\reload32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnTim = new JButton("T??m", new ImageIcon(".\\image\\search32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnQuayLai = new JButton("Quay L???i", new ImageIcon(".\\image\\logout32.png")));
		btnQuayLai.setBackground(Color.red);
		b1.add(Box.createHorizontalStrut(5));
		Border borderButton = BorderFactory.createLineBorder(Color.red);
		TitledBorder titleBorderButton = new TitledBorder(borderButton, "Ch???n t??c v???");
		titleBorderButton.setTitleFont(new Font("SansSerif", Font.ITALIC, 15));
		titleBorderButton.setTitleColor(new Color(0xFFAA00));
		b1.setBorder(titleBorderButton);
		btnThem.setMaximumSize(new Dimension(100, 50));
		btnThem.setMaximumSize(btnThem.getMaximumSize());
		btnXoa.setMaximumSize(btnThem.getMaximumSize());
		btnSua.setMaximumSize(btnThem.getMaximumSize());
		btnLamMoi.setMaximumSize(btnThem.getMaximumSize());
		btnTim.setMaximumSize(btnThem.getMaximumSize());
		String header[] = {"M?? kh??ch h??ng","T??n kh??ch h??ng","Gi???i t??nh","CMND","S??? ??i???n tho???i","Ng??y sinh"};
		modelTable = new DefaultTableModel(header, 0);
		table = new JTable(modelTable) {
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
		bMain.add(Box.createVerticalStrut(10));
		bMain.add(Box.createVerticalStrut(10));
		bMain.add(scroll,BorderLayout.CENTER);
		bMain.add(Box.createVerticalStrut(50));
		bMain.add(b1 = Box.createHorizontalBox());
		bMain.setPreferredSize(new Dimension(width-200, height-100));
		txtMaKhachHang.setEditable(false);
		btnXoa.setEnabled(false);
		btnSua.setEnabled(false);
		btnTim.addActionListener(this);
		table.addMouseListener(this);
		btnThem.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnQuayLai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		add(bMain);
		
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
				frame.dispose();
				menu = new GUIMenu(1);
				menu.setVisible(true);
			}else {
				frame.dispose();
				GUIMenuDanhChoNhanVien menuNV = new GUIMenuDanhChoNhanVien(qlnv.layNhanVienTheoMa(ma).getTenNhanVien());
				menuNV.setVisible(true);
			}
		}else if(o.equals(btnTim)) {
			timKhachHang();
		}else if(o.equals(btnThem)) {
			if(kiemTraDuLieuNhap()) {
				int kq = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n th??m kh??ch h??ng kh??ng?","Nh???c nh???",JOptionPane.YES_NO_OPTION);
				if(kq == JOptionPane.YES_OPTION) {
					String ten = txtTenKhachHang.getText().trim();
					String gioiTinh= cboGioiTinh.getSelectedItem().toString();
					String cMND= txtCMND.getText().trim();
					String sDT = txtSDT.getText().trim();
					@SuppressWarnings("deprecation")
					Date ngaySinh = new Date(dcNgaySinh.getDate().getYear(),dcNgaySinh.getDate().getMonth(),dcNgaySinh.getDate().getDate());
					if(qlkh.themKhachHang(ten,gioiTinh,cMND,sDT,ngaySinh)) {
						KhachHang kh = qlkh.timKhachHangTheoCMND(cMND);
						JOptionPane.showMessageDialog(this, "Th??m kh??ch h??ng "+kh.getMaKhachHang()+" th??nh c??ng!");
						lamMoiTextFields();
						for(int i = table.getRowCount()-1;i>=0;i--) {
							modelTable.removeRow(i);
						}
						docDuLieuVaoBang();
					}
						else {
							lamMoiTextFields();
							lblThongBao.setText("L???i: Kh??ng ???????c tr??ng m?? kh??ch h??ng");
					}
				}
			}
		}else if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			int kq = JOptionPane.showConfirmDialog(this,"B???n c?? mu???n x??a kh??ch h??ng "+modelTable.getValueAt(row, 0).toString()+" kh??ng?","Nh???c nh???",JOptionPane.YES_NO_OPTION);
			if(kq == JOptionPane.YES_OPTION) {
				if(qlkh.xoaKhachHang(modelTable.getValueAt(row, 0).toString())) {
					JOptionPane.showMessageDialog(this, "X??a kh??ch h??ng "+modelTable.getValueAt(row, 0).toString()+" th??nh c??ng");
					modelTable.removeRow(row);
					lamMoiTextFields();
				}else {
					JOptionPane.showMessageDialog(this, "X??a kh??ch h??ng "+modelTable.getValueAt(row, 0).toString()+" kh??ng th??nh c??ng");
					lamMoiTextFields();
				}
			}
		}else if(o.equals(btnSua)) {
			int row = table.getSelectedRow();
			if(kiemTraDuLieuNhap()) {
				KhachHang kh = taoKhachHangTuTextfields();
				int kq = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n s???a nh??n vi??n "+kh.getMaKhachHang()+" kh??ng?","Nh???c nh???",JOptionPane.YES_NO_OPTION);
				if(kq == JOptionPane.YES_OPTION) {
					if(qlkh.suaKhacHang(kh)) {
						JOptionPane.showMessageDialog(this, "S???a kh??ch h??ng " +kh.getMaKhachHang()+" th??nh c??ng");
						lamMoiTextFields();
						table.setValueAt(kh.getTenKhachHang(), row, 1);
						table.setValueAt(kh.getGioiTinh(), row, 2);
						table.setValueAt(kh.getcMND(), row, 3);
						table.setValueAt(kh.getSoDienThoai(), row, 4);
						table.setValueAt(kh.getNgaySinh(), row, 5);
						table.getSelectionModel().clearSelection();
					}else {
						JOptionPane.showMessageDialog(this, "S???a kh??ch h??ng " +kh.getMaKhachHang()+" kh??ng th??nh c??ng");
						lamMoiTextFields();
						table.getSelectionModel().clearSelection();
					}
				}
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
		txtMaKhachHang.setEditable(false);
		btnXoa.setEnabled(false);
		btnSua.setEnabled(false);
		lblThongBao.setText("");
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
			JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y kh??ch h??ng");
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
	@SuppressWarnings("deprecation")
	public boolean kiemTraDuLieuNhap() {
		txtMaKhachHang.getText().trim();
		String ten = txtTenKhachHang.getText().trim();
		String cMND = txtCMND.getText().trim();
		String sDT = txtSDT.getText().trim();
		java.util.Date ngayHienTai= new java.util.Date();
		java.util.Date ngaySinh = dcNgaySinh.getDate();
		if (ten.matches("[0-9]{1,}") || ten.length() == 0) {
			lblThongBao.setText("L???i: T??n kh??ch h??ng kh??ng ???????c tr???ng v?? ch???a k?? t??? s???");
			txtTenKhachHang.selectAll();
			txtTenKhachHang.requestFocus();
			return false;
			
		}else if(!cboGioiTinh.getSelectedItem().toString().equals("Nam")&&!cboGioiTinh.getSelectedItem().toString().equals("N???")){
			lblThongBao.setText("Gi???i t??nh kh??ch h??ng kh??ng ???????c tr???ng");
			return false;
			
		}else if (!cMND.matches("^[0-9]{9,13}")) {
			lblThongBao.setText("L???i: CMND ph???i l?? s??? v?? c?? t??? 9 ?????n 13 s??? v?? kh??ng ???????c tr???ng");
			txtCMND.selectAll();
			txtCMND.requestFocus();
			return false;
		} else if (!sDT.matches("^[0-9]{9,13}")) {
			lblThongBao.setText("L???i: S??? ??i???n tho???i ph???i l?? s??? v?? c?? t??? 9 ?????n 13 s??? v?? kh??ng ???????c tr???ng");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		}else if (dcNgaySinh.getDate() == null || ngayHienTai.getYear()-ngaySinh.getYear() <= 16) {
			lblThongBao.setText("L???i : Kh??ch h??ng ph???i tr??n 16 tu???i v?? kh??ng ???????c tr???ng");
			dcNgaySinh.setDate(null);
			return false;
		}
		return true;
	}
	@SuppressWarnings("deprecation")
	public KhachHang taoKhachHangTuTextfields() {
		String ma = txtMaKhachHang.getText().trim();
		String ten = txtTenKhachHang.getText().trim();
		String gioiTinh= cboGioiTinh.getSelectedItem().toString();
		String cMND= txtCMND.getText().trim();
		String sDT = txtSDT.getText().trim();
		Date ngaySinh = new Date(dcNgaySinh.getDate().getYear(),dcNgaySinh.getDate().getMonth(),dcNgaySinh.getDate().getDate());
		return new KhachHang(ma, ten, gioiTinh, cMND, sDT, ngaySinh);
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
		btnXoa.setEnabled(true);
		btnSua.setEnabled(true);
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
