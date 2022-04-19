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
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import dao.QuanLyDichVu_DAO;
import dao.QuanLyNhanVien_DAO;
import entity.DichVu;

public class GUIDichVu extends JPanel implements ActionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Frame frame;
	private JLabel lblTitle;
	private JLabel lblMaDichVu;
	private JTextField txtMaDichVu;
	private JLabel lblTenDichVu;
	private JTextField txtTenDichVu;
	private JLabel lblDonVi;
	private JTextField txtDonVi;
	private JLabel lblDonGia;
	private JLabel lblSoLuong;
	private JTextField txtSoLuong;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JButton btnQuayLai;
	private DefaultTableModel modelTable;
	private JTable table;
	private JButton btnTim;
	private JTextField txtDonGia;
	private JLabel lblThongBao;
	private QuanLyDichVu_DAO qldv = new QuanLyDichVu_DAO();
	private GUIMenu menu;
	private QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
	
	public GUIDichVu(Frame frameCha){
		frame = frameCha;
		Dimension manHinh = Toolkit.getDefaultToolkit().getScreenSize();
		int width = manHinh.width;
		int height= manHinh.height;
		JPanel pNorth = new JPanel();
		pNorth.add(lblTitle = new JLabel("QUẢN LÝ DỊCH VỤ"));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTitle.setForeground(new Color(0xFFAA00));
		Box bMain,b1,b2,b12,b;
		bMain = Box.createVerticalBox();
		bMain.add(pNorth,BorderLayout.NORTH);
		bMain.add(Box.createVerticalStrut(50));
		bMain.add(b = Box.createHorizontalBox());
		b.add(lblMaDichVu = new JLabel("Mã dịch vụ: "));
		b.add(txtMaDichVu = new JTextField());
		b.setMaximumSize(new Dimension(200,200));
		bMain.add(Box.createVerticalStrut(20));
		bMain.add(b12 = Box.createHorizontalBox());
		b12.add(b1 = Box.createVerticalBox());
		b1.add(b = Box.createHorizontalBox());
		b.add(lblTenDichVu = new JLabel("Tên dịch vụ: "));
		b.add(txtTenDichVu = new JTextField());
		b1.add(Box.createVerticalStrut(20));
		b1.add(b = Box.createHorizontalBox());
		b.add(lblSoLuong = new JLabel("Số lượng: "));
		b.add(txtSoLuong = new JTextField());
		b12.add(Box.createHorizontalStrut(50));
		b12.add(b2 = Box.createVerticalBox());
		b2.add(b = Box.createHorizontalBox());
		b.add(lblDonVi = new JLabel("Đơn vị: "));
		b.add(txtDonVi = new JTextField());
		b2.add(Box.createVerticalStrut(20));
		b2.add(b = Box.createHorizontalBox());
		b.add(lblDonGia = new JLabel("Đơn giá: "));
		b.add(txtDonGia = new JTextField());
		b12.setMaximumSize(new Dimension(width/3,200));
		lblMaDichVu.setPreferredSize(lblTenDichVu.getPreferredSize());
		lblTenDichVu.setPreferredSize(lblTenDichVu.getPreferredSize());
		lblSoLuong.setPreferredSize(lblTenDichVu.getPreferredSize());
		lblDonVi.setPreferredSize(lblDonGia.getPreferredSize());
		lblDonGia.setPreferredSize(lblDonGia.getPreferredSize());
		bMain.add(Box.createVerticalStrut(20));
		bMain.add(b1=Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(5));
		b1.add(btnThem = new JButton("Thêm", new ImageIcon(".\\image\\add32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnXoa = new JButton("Xóa", new ImageIcon(".\\image\\remove32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnSua = new JButton("Sửa", new ImageIcon(".\\image\\update32.png")));
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
		btnThem.setMaximumSize(new Dimension(100, 50));
		btnThem.setMaximumSize(btnThem.getMaximumSize());
		btnXoa.setMaximumSize(btnThem.getMaximumSize());
		btnSua.setMaximumSize(btnThem.getMaximumSize());
		btnLamMoi.setMaximumSize(btnThem.getMaximumSize());
		btnTim.setMaximumSize(btnThem.getMaximumSize());
		String header[] = {"Mã dịch vụ","Tên dịch vụ","Đơn vị","Số lượng","Đơn giá"};
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
		for(int i = 0 ; i <5;++i) {
			table.getColumnModel().getColumn(i).setCellRenderer(renderCenter);
		}
		int widthCol[]= {20,40,20,20,20}; 
		for(int i = 0 ; i <5;++i) {
			table.getColumnModel().getColumn(i).setPreferredWidth(widthCol[i]*3);;
		}
		JScrollPane scroll = new JScrollPane(table);
		JPanel pThongBao = new JPanel();
		pThongBao.add(lblThongBao = new JLabel());
		lblThongBao.setForeground(Color.red);
		lblThongBao.setFont(new Font("Time new roman",Font.ITALIC,15));
		bMain.add(pThongBao);
		scroll.setBorder(BorderFactory.createLineBorder(Color.RED));
		bMain.add(Box.createVerticalStrut(50));
		bMain.add(scroll,BorderLayout.CENTER);
		bMain.add(Box.createVerticalStrut(50));
		bMain.add(b1 = Box.createHorizontalBox());
		bMain.setPreferredSize(new Dimension(width-200, height-100));
		docDuLieuVaoBang();
		txtMaDichVu.setEditable(false);
		btnXoa.setEnabled(false);
		btnSua.setEnabled(false);
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnQuayLai.addActionListener(this);
		btnLamMoi.addActionListener(this);
		table.addMouseListener(this);
		add(bMain);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTim)) {
			timDichVu();
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
		}else if(o.equals(btnThem)) {
			if(kiemTraDuLieuNhap()) {
				DichVu dv = taoDichVuTuTextfields();
				String ma = dv.getMaDichVu();
				int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm dịch vụ "+ma+" không?","Nhắc nhở",JOptionPane.YES_NO_OPTION);
				if(kq == JOptionPane.YES_OPTION) {
					String ten = txtTenDichVu.getText().trim();
					double gia = Double.parseDouble(txtDonGia.getText().trim());
					int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
					String donVi = txtDonVi.getText().trim();
					if(qldv.themDichVu(ten,gia,donVi,soLuong)) {
						JOptionPane.showMessageDialog(this, "Thêm dịch vụ "+ma+" thành công?");
						xoaBang();
						docDuLieuVaoBang();
						lamMoiTextFields();
					}else {
						JOptionPane.showMessageDialog(this,"Không được trùng mã dịch vụ");
						lamMoiTextFields();
					}
				}
			}
		}else if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			String ma = modelTable.getValueAt(row, 0).toString();
			int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa nhân viên "+ma+" không?","Nhắc nhở",JOptionPane.YES_NO_OPTION);
			if(kq == JOptionPane.YES_OPTION) {
				if(qldv.xoaDichVu(ma)) {
					JOptionPane.showMessageDialog(this, "Xóa dịch vụ "+ma+" thành công!");
					modelTable.removeRow(row);
					lamMoiTextFields();
				}else {
					JOptionPane.showMessageDialog(this, "Xóa dịch vụ "+ma+" không thành công");
					lamMoiTextFields();
				}
			}
		}else if(o.equals(btnSua)) {
			int row = table.getSelectedRow();
			if(kiemTraDuLieuNhap()) {
				DichVu dv =taoDichVuTuTextfields();
				String ma = dv.getMaDichVu();
				int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa dịch vụ "+ma+" không?","Nhắc nhở",JOptionPane.YES_OPTION);
				if(kq==JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(this, "Sửa dịch vụ "+ma+" thành công!");
					table.setValueAt(dv.getTenDichVu(), row,1);
					table.setValueAt(dv.getDonVi(), row,2);
					table.setValueAt(dv.getSoLuong(), row,3);
					table.setValueAt(dv.getGia(), row,4);
					lamMoiTextFields();
				}else {
					JOptionPane.showMessageDialog(this, "Sửa dịch vụ "+ma+" không thành công!");
					lamMoiTextFields();
				}
			}
		}
	}
	public void themDongVaoBang(DichVu dv) {
		DecimalFormat df = new DecimalFormat("###.#");
		modelTable.addRow(new Object[] {
				dv.getMaDichVu(),dv.getTenDichVu(),dv.getDonVi(),dv.getSoLuong(),df.format(dv.getGia())
		});
	}
	public void xoaBang() {
		for(int i = table.getRowCount()-1;i>=0;i--) {
			modelTable.removeRow(i);
		}
	}
	public void docDuLieuVaoBang() {
		ArrayList<DichVu> dsDichVu = qldv.layToanBoDichVu();
		for (DichVu dichVu : dsDichVu) {
			themDongVaoBang(dichVu);
		}
		table.setModel(modelTable);
	}
	public void lamMoiTextFields() {
		txtMaDichVu.setText("");
		txtTenDichVu.setText("");
		txtDonGia.setText("");
		txtDonVi.setText("");
		txtSoLuong.setText("");
		txtMaDichVu.requestFocus();
		txtMaDichVu.setEditable(false);
		btnXoa.setEnabled(false);
		btnSua.setEnabled(false);
		lblThongBao.setText("");
	}
	public boolean kiemTraDuLieuNhap() {
		String ten = txtTenDichVu.getText().trim();
		String gia = txtDonGia.getText().trim();
		String soLuong = txtSoLuong.getText().trim();
		String donVi = txtDonVi.getText().trim();
		if (!ten.matches("^.{1,}")) {
			lblThongBao.setText("Lỗi: Tên dịch vụ không được trống");
			txtTenDichVu.selectAll();
			txtTenDichVu.requestFocus();
			return false;	
		}else if(!donVi.matches("^[a-zA-Z0-9]{1,}")) {
			lblThongBao.setText("Lỗi: Đơn vị không được chứa ký tự đặc biệt và không được trống");
			txtDonVi.selectAll();
			txtDonVi.requestFocus();
			return false;
		}else if(!soLuong.matches("^([1-9]{1,})([0-9]){0,}")) {
			lblThongBao.setText("Lỗi: Số lượng phải là số lớn hơn 0 và không được trống");
			txtSoLuong.selectAll();
			txtSoLuong.requestFocus();
			return false;
		}else if(!gia.matches("^([1-9]{1,})([0-9]){0,}")) {
			lblThongBao.setText("Lỗi: Giá phải là số lớn hơn 0 và không được trống");
			txtDonGia.selectAll();
			txtDonGia.requestFocus();
			return false;
		}	
		return true;
	}
	public DichVu taoDichVuTuTextfields() {
		String ma = txtMaDichVu.getText().trim();
		String ten = txtTenDichVu.getText().trim();
		double gia = Double.parseDouble(txtDonGia.getText().trim());
		int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
		String donVi = txtDonVi.getText().trim();
		return new DichVu(ma, ten, gia, donVi, soLuong);
	}
	public void timDichVu() {
		String maDV = "",tenDV="",soLuong="",gia="",donVi="";
		if(txtMaDichVu.getText().trim() != null)
			maDV = txtMaDichVu.getText().trim();
		if(txtTenDichVu.getText().trim() != null)
			tenDV = txtTenDichVu.getText().trim();
		if(txtDonVi.getText().trim() != null)
			donVi = txtDonVi.getText().trim();
		if(txtDonGia.getText().trim() != null)
			gia = txtDonGia.getText().trim();
		if(txtSoLuong.getText().trim() != null)
			soLuong = txtSoLuong.getText().trim();
		ArrayList<DichVu> dsDichVu = qldv.timDichVuTheoTatCa(maDV, tenDV, gia, donVi, soLuong);
		for(int i = table.getRowCount()-1; i >= 0 ; --i) {
			modelTable.removeRow(i);
		}
		if(dsDichVu.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy dịch vụ");
				docDuLieuVaoBang();
		}else {
			for (DichVu dichVu : dsDichVu) {
				themDongVaoBang(dichVu);
				table.setModel(modelTable);
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
		txtMaDichVu.setText(modelTable.getValueAt(row, 0).toString());
		txtTenDichVu.setText(modelTable.getValueAt(row, 1).toString());
		txtDonVi.setText(modelTable.getValueAt(row, 2).toString());
		txtSoLuong.setText(modelTable.getValueAt(row, 3).toString());
		DecimalFormat df = new DecimalFormat("###.#");
		double gia = Double.parseDouble(modelTable.getValueAt(row, 4).toString());
		txtDonGia.setText(df.format(gia));
		btnXoa.setEnabled(true);
		btnSua.setEnabled(true);
		txtMaDichVu.setEditable(false);
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
	