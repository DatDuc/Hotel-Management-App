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

import dao.QuanLyNhanVien_DAO;
import entity.NhanVien;
import entity.TaiKhoan;

public class GUINhanVien extends JPanel implements ActionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Frame frame;
	private JLabel lblTitle;
	private JLabel lblMaNhanVien;
	private JTextField txtMaNhanVien;
	private JLabel lblTenNhanVien;
	private JTextField txtTenNhanVien;
	private JLabel lblGioitinh;
	private JComboBox<String> cboGioiTinh;
	private JLabel lblCMND;
	private JTextField txtCMND;
	private JLabel lblNgaySinh;
	private JDateChooser dcNgaySinh;
	private JLabel lblSDT;
	private JTextField txtSDT;
	private JLabel lblDiaChi;
	private JTextField txtDiaChi;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLapMatKhau;
	private JButton btnLamMoi;
	private JButton btnQuayLai;
	private DefaultTableModel modelTable;
	private JTable table;
	private JButton btnTim;
	private JButton btnDoiMatKhau;
	private QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
	private JLabel lblThongBao;
	private JButton btnXemMatKhau;

	public GUINhanVien(Frame frameCha) {
		frame = frameCha;
		Dimension manHinh = Toolkit.getDefaultToolkit().getScreenSize();
		int width = manHinh.width;
		int height = manHinh.height;
		JPanel pNorth = new JPanel();
		pNorth.add(lblTitle = new JLabel("QUẢN LÝ NHÂN VIÊN"));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTitle.setForeground(new Color(0xFFAA00));
		Box bMain,b1,b2,b3,b123,b;
		bMain = Box.createVerticalBox();
		bMain.add(pNorth,BorderLayout.NORTH);
		bMain.add(Box.createVerticalStrut(50));
		bMain.add(b123 = Box.createHorizontalBox());
		b123.add(b1 = Box.createVerticalBox());
		b1.add(b = Box.createHorizontalBox());
		b.add(lblMaNhanVien = new JLabel("Mã nhân viên: "));
		b.add(txtMaNhanVien = new JTextField());
		b1.add(Box.createVerticalStrut(20));
		b1.add(b = Box.createHorizontalBox());
		b.add(lblCMND = new JLabel("CMND: "));
		b.add(txtCMND = new JTextField());
		b123.add(Box.createHorizontalStrut(50));
		b123.add(b2 = Box.createVerticalBox());
		b2.add(b = Box.createHorizontalBox());
		b.add(lblTenNhanVien = new JLabel("Tên nhân viên: "));
		b.add(txtTenNhanVien = new JTextField());
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
		bMain.add(Box.createVerticalStrut(20));
		bMain.add(b = Box.createHorizontalBox());
		b.add(lblDiaChi = new JLabel("Địa chỉ: "));
		b.add(txtDiaChi = new JTextField());
		b.setMaximumSize(new Dimension(width/2,20));
		b123.setMaximumSize(new Dimension(width/2, 150));
		lblMaNhanVien.setPreferredSize(lblMaNhanVien.getPreferredSize());
		lblCMND.setPreferredSize(lblMaNhanVien.getPreferredSize());
		lblDiaChi.setPreferredSize(lblMaNhanVien.getPreferredSize());
		lblTenNhanVien.setPreferredSize(lblTenNhanVien.getPreferredSize());
		lblSDT.setPreferredSize(lblTenNhanVien.getPreferredSize());
		lblGioitinh.setPreferredSize(lblNgaySinh.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblNgaySinh.getPreferredSize());
		cboGioiTinh.setMaximumSize(new Dimension(100, 20));
		dcNgaySinh.setMaximumSize(new Dimension(100, 20));
		bMain.add(Box.createVerticalStrut(20));
		bMain.add(b1 = Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(5));
		b1.add(btnThem = new JButton("Thêm", new ImageIcon(".\\image\\add32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnXoa = new JButton("Xóa", new ImageIcon(".\\image\\remove32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnSua = new JButton("Sửa", new ImageIcon(".\\image\\update32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnLapMatKhau = new JButton("Tạo tài khoản", new ImageIcon(".\\image\\key32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnDoiMatKhau = new JButton("Đổi mật khẩu", new ImageIcon(".\\image\\changePass32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnLamMoi = new JButton("Làm mới", new ImageIcon(".\\image\\reload32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnXemMatKhau = new JButton("Xem mật khẩu", new ImageIcon(".\\image\\eyes32.jpg")));
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
		btnThem.setMaximumSize(new Dimension(100, 50));
		btnLapMatKhau.setMaximumSize(new Dimension(200, 50));
		btnThem.setMaximumSize(btnThem.getMaximumSize());
		btnXoa.setMaximumSize(btnThem.getMaximumSize());
		btnSua.setMaximumSize(btnThem.getMaximumSize());
		btnLamMoi.setMaximumSize(btnThem.getMaximumSize());
		btnTim.setMaximumSize(btnThem.getMaximumSize());
		btnXemMatKhau.setMaximumSize(btnLapMatKhau.getMaximumSize());
		String header[] = { "Mã nhân viên", "Tên nhân viên","Giới tính", "CMND", "Số điện thoại","Ngày sinh","Địa chỉ" };
		modelTable = new DefaultTableModel(header, 0);
		table = new JTable(modelTable) {
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
		table.setAutoCreateRowSorter(true);
		DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
		renderCenter.setHorizontalAlignment(JLabel.CENTER);
		JTableHeader headerTable = new JTableHeader();
		headerTable.setOpaque(false);
		table.getTableHeader().setReorderingAllowed(false);
		for (int i = 0; i < 7; ++i) {
			table.getColumnModel().getColumn(i).setCellRenderer(renderCenter);
		}
		int widthCol[] = { 10, 20, 10, 10, 10, 10, 150 };
		for (int i = 0; i < 7; ++i) {
			table.getColumnModel().getColumn(i).setPreferredWidth(widthCol[i] * 3);
			;
		}
		JScrollPane scroll = new JScrollPane(table);
		lblThongBao = new JLabel();
		JPanel pThongBao = new JPanel();
		pThongBao.add(lblThongBao);
		bMain.add(pThongBao,BorderLayout.WEST);
		lblThongBao.setFont(new Font("Time new roman", Font.ITALIC, 15));
		lblThongBao.setForeground(Color.red);
		scroll.setBorder(BorderFactory.createLineBorder(Color.RED));
		docDuLieuLenBang();
		scroll.setPreferredSize(new Dimension(width-300, height/2));
		bMain.add(scroll, BorderLayout.CENTER);
		bMain.add(Box.createVerticalStrut(50));
		bMain.add(b1 = Box.createHorizontalBox());
		bMain.setPreferredSize(new Dimension(width - 200, height - 100));
		txtMaNhanVien.setEditable(false);
		btnXoa.setEnabled(false);
		btnSua.setEnabled(false);
		btnDoiMatKhau.setEnabled(false);
		btnLapMatKhau.setEnabled(false);
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnXoa.addActionListener(this);
		btnQuayLai.addActionListener(this);
		btnSua.addActionListener(this);
		btnDoiMatKhau.addActionListener(this);
		btnLapMatKhau.addActionListener(this);
		btnXemMatKhau.addActionListener(this);
		table.addMouseListener(this);
		add(bMain);
	}

	public void timNhanVien() {
		String maNV = "", tenNV = "", cMND = "", ngaySinh = "", sDT = "", gioiTinh = "", diaChi = "";
		if (txtMaNhanVien.getText().trim() != null)
			maNV = txtMaNhanVien.getText().trim();
		if (txtTenNhanVien.getText().trim() != null)
			tenNV = txtTenNhanVien.getText().trim();
		if (txtCMND.getText().trim() != null)
			cMND = txtCMND.getText().trim();
		if (txtSDT.getText().trim() != null)
			sDT = txtSDT.getText().trim();
		if (txtDiaChi.getText().trim() != null)
			diaChi = txtDiaChi.getText().trim();
		if (dcNgaySinh.getDate() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ngaySinh = sdf.format(dcNgaySinh.getDate());
		}
		gioiTinh= cboGioiTinh.getSelectedItem().toString();
		for(int i = table.getRowCount() - 1; i>=0;--i) {
			modelTable.removeRow(i);
		}
		ArrayList<NhanVien> dsNhanVien = qlnv.timKiemNhanVienTheoTatCa(maNV, tenNV, gioiTinh, cMND, sDT, ngaySinh,diaChi);
		if(dsNhanVien.size()==0) {
			JOptionPane.showMessageDialog(this,"Không tìm thấy nhân viên");
			docDuLieuLenBang();
		}else {
			for (NhanVien nhanVien : dsNhanVien) {
				themDongVaoBang(nhanVien);
				table.setModel(modelTable);
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTim)) {
			timNhanVien();
		}else if(o.equals(btnThem)) {
			if(kiemTraDuLieuNhap()) {
				int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm nhân viên không?","Nhắc nhở",JOptionPane.YES_NO_OPTION);
				if(kq == JOptionPane.YES_OPTION) {
					String ten = txtTenNhanVien.getText().trim();
					String cMND = txtCMND.getText().trim();
					String sDT = txtSDT.getText().trim();
					String diaChi = txtDiaChi.getText().trim();
					Date ngaySinh = new Date(dcNgaySinh.getDate().getYear(), dcNgaySinh.getDate().getMonth(),dcNgaySinh.getDate().getDate());
					String gioiTinh = cboGioiTinh.getSelectedItem().toString();
					if(qlnv.themNhanVien(ten,gioiTinh,cMND,sDT,ngaySinh,diaChi)) {
						NhanVien nv = qlnv.timNhanVienTheoCMND(cMND);
						JOptionPane.showMessageDialog(this, "Đã thêm nhân viên "+nv.getMaNhanVien()+" " +nv.getTenNhanVien()+" thành công hãy tạo tài khoản cho nhân viên");
						xoaBang();
						docDuLieuLenBang();
						lamMoiTextfields();
					}else {
							lblThongBao.setText("Lỗi: Nhân viên không được trùng mã");
							lamMoiTextfields();
					}
				}
			}
		}else if(o.equals(btnLamMoi)) {
			lamMoiTextfields();
			xoaBang();
			docDuLieuLenBang();
		}else if(o.equals(btnXoa)) {
			int kq = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa nhân viên "+txtMaNhanVien.getText()+"?","Nhắc nhở",JOptionPane.YES_NO_OPTION);
			if(kq == JOptionPane.YES_NO_OPTION) {
					int row = table.getSelectedRow();
					String maNhanVien = modelTable.getValueAt(row, 0).toString();
					if(qlnv.xoaNhanVien(maNhanVien)) {
						modelTable.removeRow(row);
						JOptionPane.showMessageDialog(this,"Đã xóa nhân viên "+maNhanVien+" thành công");
						lamMoiTextfields();
					}else {
						JOptionPane.showMessageDialog(this, "Xóa nhân viên "+maNhanVien+" không thành công");
						lamMoiTextfields();
					}
				}
			}else if(o.equals(btnQuayLai)) {
				new GUIMenu(1);
				frame.dispose();
			}else if(o.equals(btnSua)) {
				int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa nhân viên "+txtMaNhanVien.getText()+"?","Nhắc nhở",JOptionPane.YES_NO_OPTION);
				int row = table.getSelectedRow();
				if(kq == JOptionPane.YES_OPTION) {
					if(kiemTraDuLieuNhap()) {
						NhanVien nv = taoNhanVienTuTextfields();
						if(qlnv.suaNhanVien(nv)) {
							JOptionPane.showMessageDialog(this,"Sửa nhân viên "+nv.getMaNhanVien()+" thành công.");
							lamMoiTextfields();
							table.setValueAt(nv.getTenNhanVien(), row,1);
							table.setValueAt(nv.getGioiTinh(), row,2);
							table.setValueAt(nv.getcMND(), row,3);
							table.setValueAt(nv.getSoDienThoai(),row,4);
							table.setValueAt(nv.getNgaySinh(), row,5);
							table.setValueAt(nv.getDiaChi(), row,6);
							table.getSelectionModel().clearSelection();
						}else {
							JOptionPane.showMessageDialog(this, "Sửa nhân viên "+nv.getMaNhanVien()+" không thành công.");
						}
					}
				}
			}else if(o.equals(btnDoiMatKhau)) {
				String matKhau =qlnv.layMatKhau(txtMaNhanVien.getText());
				if(matKhau.length() == 0) {
					JOptionPane.showMessageDialog(this,"Nhân viên chưa có mật khẩu hãy thiết lập mật khẩu");
					lamMoiTextfields();
				}else {
					new GUIDoiMatKhau(txtMaNhanVien.getText());
				}
			}else if(o.equals(btnLapMatKhau)) {
				String matKhau = qlnv.layMatKhau(txtMaNhanVien.getText());
				if(matKhau.length() > 0) {
					JOptionPane.showMessageDialog(this, "Nhân viên đã có mật khẩu");
					lamMoiTextfields();
				}else {
					new GUIThietLapMatKhau(txtMaNhanVien.getText());
				}
			}else if(o.equals(btnXemMatKhau)) {
				xemTaiKhoanCuaNhanVien();	
			}
		}
	public void themDongVaoBang(NhanVien nv) {
		modelTable.addRow(new Object[] { nv.getMaNhanVien(), nv.getTenNhanVien(),nv.getGioiTinh(),nv.getcMND(),nv.getSoDienThoai(),
				nv.getNgaySinh(),nv.getDiaChi() });
	}

	public void docDuLieuLenBang() {
		ArrayList<NhanVien> dsNhanVien = qlnv.layToanBoNhanVien();
		for (NhanVien nhanVien : dsNhanVien) {
			themDongVaoBang(nhanVien);
		}
	}
	public void xoaBang() {
		for(int i = table.getRowCount()-1;i>=0;i--) {
			modelTable.removeRow(i);
		}
	}
	@SuppressWarnings("deprecation")
	public boolean kiemTraDuLieuNhap() {
		String ten = txtTenNhanVien.getText().trim();
		String cMND = txtCMND.getText().trim();
		String sDT = txtSDT.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		java.util.Date ngaySinh = dcNgaySinh.getDate();
		java.util.Date ngayHienTai = new java.util.Date();
		if (ten.matches("[0-9]{1,}") || ten.length() == 0) {
			lblThongBao.setText("Lỗi: Tên nhân viên không được trống và chứa ký tự số");
			txtTenNhanVien.selectAll();
			txtTenNhanVien.requestFocus();
			return false;
			
		}else if(!cboGioiTinh.getSelectedItem().toString().equals("Nam")&&!cboGioiTinh.getSelectedItem().toString().equals("Nữ")){
			lblThongBao.setText("Giới tính nhân viên không được trống");
			return false;
			
		}else if (!cMND.matches("^[0-9]{9,13}")) {
			lblThongBao.setText("Lỗi: CMND phải là số và có từ 9 đến 13 số và không được trống");
			txtCMND.selectAll();
			txtCMND.requestFocus();
			return false;
		} else if (!sDT.matches("^[0-9]{9,13}")) {
			lblThongBao.setText("Lỗi: Số điện thoại phải là số và có từ 9 đến 13 số và không được trống");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		}else if (dcNgaySinh.getDate() == null || ngayHienTai.getYear()-ngaySinh.getYear() <= 18) {
			lblThongBao.setText("Lỗi : Nhân viên phải trên 18 tuổi và không được trống");
			dcNgaySinh.setDate(null);
			return false;
		} else if (!diaChi.matches("^.{1,}")) {
			lblThongBao.setText("Lỗi : Địa chỉ nhân viên không được trống");
			txtDiaChi.requestFocus();
			return false;
		}
		return true;
	}

	@SuppressWarnings("deprecation")
	public NhanVien taoNhanVienTuTextfields() {
		String ma = txtMaNhanVien.getText().trim();
		String ten = txtTenNhanVien.getText().trim();
		String cMND = txtCMND.getText().trim();
		String sDT = txtSDT.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		Date ngaySinh = new Date(dcNgaySinh.getDate().getYear(), dcNgaySinh.getDate().getMonth(),dcNgaySinh.getDate().getDate());
		String gioiTinh = cboGioiTinh.getSelectedItem().toString();
		return new NhanVien(ma, ten, gioiTinh, cMND, sDT, ngaySinh, diaChi);
	}
	public void lamMoiTextfields() {
		txtMaNhanVien.setText("");
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.requestFocus();
		txtTenNhanVien.setText("");
		txtDiaChi.setText("");
		txtSDT.setText("");
		txtCMND.setText("");
		cboGioiTinh.setSelectedIndex(0);
		lblThongBao.setText("");
		dcNgaySinh.setDate(null);
		btnXoa.setEnabled(false);
		btnSua.setEnabled(false);
		btnDoiMatKhau.setEnabled(false);
		btnLapMatKhau.setEnabled(false);
	}
	public void xemTaiKhoanCuaNhanVien() {
		JPanel p = new JPanel();
		String header[] = {"Tên đăng nhập","Mật khẩu"};
		DefaultTableModel modelTaiKhoan = new DefaultTableModel(header, 0);
		JTable tableTaiKhoan = new JTable(modelTaiKhoan) {
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
		tableTaiKhoan.setAutoCreateRowSorter(true);
		DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
		renderCenter.setHorizontalAlignment(JLabel.CENTER);
		JTableHeader headerTable = new JTableHeader();
		headerTable.setOpaque(false);
		tableTaiKhoan.getTableHeader().setReorderingAllowed(false);
		for (int i = 0; i < 2; ++i) {
			tableTaiKhoan.getColumnModel().getColumn(i).setCellRenderer(renderCenter);
		}
		int widthCol[] = {20,20};
		for (int i = 0; i < 2; ++i) {
			tableTaiKhoan.getColumnModel().getColumn(i).setPreferredWidth(widthCol[i] * 3);
			;
		}
		JScrollPane scrollTaiKhoan = new JScrollPane(tableTaiKhoan);
		ArrayList<TaiKhoan> dsTaiKhoan = qlnv.layToanBoTaiKhoan();
		for (TaiKhoan taiKhoan : dsTaiKhoan) {
			modelTaiKhoan.addRow(new Object[] {
					taiKhoan.getTenDangNhap(),taiKhoan.getMatKhau()
			});
		}
		tableTaiKhoan.setModel(modelTaiKhoan);
		p.add(scrollTaiKhoan);
		JOptionPane.showConfirmDialog(this, p,"Tài khoản",JOptionPane.OK_OPTION,JOptionPane.PLAIN_MESSAGE);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaNhanVien.setText(modelTable.getValueAt(row,0).toString());
		txtTenNhanVien.setText(modelTable.getValueAt(row,1).toString());
		cboGioiTinh.setSelectedItem(modelTable.getValueAt(row,2).toString());
		txtCMND.setText(modelTable.getValueAt(row,3).toString());
		txtSDT.setText(modelTable.getValueAt(row,4).toString());
		txtDiaChi.setText(modelTable.getValueAt(row,6).toString());
		java.util.Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(modelTable.getValueAt(row,5).toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtMaNhanVien.setEditable(false);
		dcNgaySinh.setDate(date);
		btnXoa.setEnabled(true);
		btnSua.setEnabled(true);
		btnDoiMatKhau.setEnabled(true);
		btnLapMatKhau.setEnabled(true);
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
