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

import dao.QuanLyPhong_DAO;
import entity.LoaiPhong;
import entity.Phong;

public class GUIPhong extends JPanel implements ActionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Frame frame;
	private JLabel lblTitle;
	private JLabel lblMaPhong;
	private JTextField txtMaPhong;
	private JLabel lblLoaiPhong;
	private JComboBox<String> cboLoaiPhong;
	private JLabel lblGiaPhong;
	private JTextField txtGiaPhong;
	private JLabel lblMoTa;
	private JTextField txtMoTa;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JButton btnQuayLai; 
	private DefaultTableModel modelTable;
	private JTable table;
	private JButton btnTim;
	private JLabel lblSoNguoi;
	private JLabel lblSoGiuong;
	private JTextField txtSoGiuong;
	private JTextField txtSoNguoi;
	private QuanLyPhong_DAO qlp = new QuanLyPhong_DAO();
	private JLabel lblThongBao;
	private JButton btnLoaiPhong;

	@SuppressWarnings("serial")
	public GUIPhong(Frame frameCha){
		frame = frameCha;
		Dimension manHinh = Toolkit.getDefaultToolkit().getScreenSize();
		int width = manHinh.width;
		int height= manHinh.height;
		JPanel pNorth = new JPanel();
		pNorth.add(lblTitle = new JLabel("QUẢN LÝ PHÒNG"));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTitle.setForeground(new Color(0xFFAA00));
		Box bMain,b1,b2,b12,b;
		bMain = Box.createVerticalBox();
		bMain.add(pNorth,BorderLayout.NORTH);
		bMain.add(Box.createVerticalStrut(20));
		bMain.add(b12 = Box.createHorizontalBox());
		b12.add(b1 = Box.createVerticalBox());
		b1.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(200));
		b.add(lblMaPhong = new JLabel("Mã phòng: "));
		b.add(txtMaPhong = new JTextField());
		b.add(Box.createHorizontalStrut(100));
		b1.add(Box.createVerticalStrut(20));
		b1.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(200));
		b.add(lblGiaPhong= new JLabel("Giá phòng: "));
		b.add(txtGiaPhong = new JTextField());
		b.add(Box.createHorizontalStrut(100));
		b1.add(Box.createVerticalStrut(20));
		b1.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(200));
		b.add(lblMoTa = new JLabel("Mô tả: "));
		b.add(txtMoTa = new JTextField());
		b.add(Box.createHorizontalStrut(100));
		b12.add(b2 = Box.createVerticalBox());
		b2.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(100));
		b.add(lblSoNguoi = new JLabel("Số người "));
		b.add(txtSoNguoi = new JTextField());
		b.add(Box.createHorizontalStrut(200));
		b2.add(Box.createVerticalStrut(20));
		b2.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(100));
		b.add(lblSoGiuong= new JLabel("Số giường: "));
		b.add(txtSoGiuong= new JTextField());
		b.add(Box.createHorizontalStrut(200));
		b2.add(Box.createVerticalStrut(20));
		b2.add(b = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(100));
		b.add(lblLoaiPhong = new JLabel("Loại phòng: "));
		b.add(cboLoaiPhong = new JComboBox<String>());
		cboLoaiPhong.addItem("");
		b.add(Box.createHorizontalStrut(200));
		lblGiaPhong.setPreferredSize(lblGiaPhong.getPreferredSize());
		lblMoTa.setPreferredSize(lblGiaPhong.getPreferredSize());
		lblMaPhong.setPreferredSize(lblGiaPhong.getPreferredSize());
		lblLoaiPhong.setPreferredSize(lblLoaiPhong.getPreferredSize());
		lblSoNguoi.setPreferredSize(lblLoaiPhong.getPreferredSize());
		lblSoGiuong.setPreferredSize(lblLoaiPhong.getPreferredSize());
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
		b1.add(btnLoaiPhong = new JButton("Quản lý loại phòng", new ImageIcon(".\\image\\loaiphongicon.png")));
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
		String header[] = {"Mã phòng","Giá phòng","Số giường","Số người","Mô tả","Loại phòng"};
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
		int widthCol[]= {20,20,20,20,20,20}; 
		for(int i = 0 ; i <6;++i) {
			table.getColumnModel().getColumn(i).setPreferredWidth(widthCol[i]*3);;
		}
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBorder(BorderFactory.createLineBorder(Color.RED));
		bMain.add(Box.createVerticalStrut(20));
		JPanel pThongBao = new JPanel();
		pThongBao.add(lblThongBao = new JLabel(""));
		bMain.add(pThongBao);
		lblThongBao.setFont(new Font("Time new roman", Font.ITALIC, 15));
		lblThongBao.setForeground(Color.red);
		bMain.add(Box.createVerticalStrut(20));
		bMain.add(scroll,BorderLayout.CENTER);
		bMain.add(Box.createVerticalStrut(50));
		bMain.add(b1 = Box.createHorizontalBox());
		bMain.setPreferredSize(new Dimension(width-200, height-100));
		ArrayList<String> dsTenLoai = qlp.layTatCaTenLoai();
		docLoaiPhong(dsTenLoai);
		docDuLieuVaoBang();
		btnXoa.setEnabled(false);
		btnSua.setEnabled(false);
		txtMaPhong.setEditable(false);
		btnTim.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnQuayLai.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLoaiPhong.addActionListener(this);
		table.addMouseListener(this);
		add(bMain);
		
	}
	public void docLoaiPhong(ArrayList<String> dsTenLoai) {
		for (String string : dsTenLoai) {
			cboLoaiPhong.addItem(string);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTim)) {
			timPhong();
		}else if(o.equals(btnLamMoi)) {
			lamMoiTextFields();
		}else if(o.equals(btnQuayLai)) {
			new GUIMenu(1);
			frame.dispose();
		}else if(o.equals(btnThem)) {
			if(kiemTraDuLieuNhap()) {
				int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm phòng không?","Nhắc nhở",JOptionPane.YES_NO_OPTION);
				double gia = Double.parseDouble(txtGiaPhong.getText().trim());
				int soGiuong = Integer.parseInt(txtSoGiuong.getText().trim());
				int soNguoi = Integer.parseInt(txtSoNguoi.getText().trim()); 
				String moTa = txtMoTa.getText().trim();
				String loaiPhong = cboLoaiPhong.getSelectedItem().toString();
				String maLoai = qlp.layMaLoaiPhong(loaiPhong).getMaLoai();
				if(kq == JOptionPane.YES_OPTION) {
					if(qlp.themPhong(gia,soGiuong,soNguoi,moTa,maLoai)) {
						JOptionPane.showMessageDialog(this, "Thêm phòng thành công");
						lamMoiTextFields();
					}else {
						JOptionPane.showMessageDialog(this, "Không được trùng mã phòng");
					}
				}
			}
		}else if(o.equals(btnXoa)) {
			String maPhong = txtMaPhong.getText().trim();
			int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa phòng "+maPhong+" không?","Nhắc nhở",JOptionPane.YES_NO_OPTION);
			if(kq == JOptionPane.YES_OPTION) {
				if(qlp.xoaPhong(maPhong)) {
					JOptionPane.showMessageDialog(this, "Xóa phòng "+maPhong+" thành công");
					lamMoiTextFields();
				}else {
					JOptionPane.showMessageDialog(this, "Xóa phòng "+maPhong+" không thành công");
				}
			}
		}else if(o.equals(btnSua)) {
			if(kiemTraDuLieuNhap()) {
				String maPhong = txtMaPhong.getText().trim();
				int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa phòng "+maPhong+" không?","Nhắc nhở",JOptionPane.YES_NO_OPTION);
				if(kq == JOptionPane.YES_OPTION) {
					Phong p = taoPhongTuTextfields();
					if(qlp.suaPhong(p)) {
						JOptionPane.showMessageDialog(this, "Sửa phòng "+maPhong+" thành công");
						lamMoiTextFields();
					}else {
						JOptionPane.showMessageDialog(this, "Sửa phòng "+maPhong+" không thành công");
					}
				}
			}
		}else if(o.equals(btnLoaiPhong)) {
			new GUILoaiPhong(frame);
		}
	}
	public void themDongVaoBang(Phong p) {
		DecimalFormat df = new DecimalFormat("###.#");
		modelTable.addRow(new Object[] {
				p.getMaPhong(),df.format(p.getGiaPhong()),p.getSoGiuong(),p.getSoNguoi(),p.getMoTa(),
				qlp.layTenLoaiPhong(p.getLoaiPhong().getMaLoai()).getTenLoai()
		});
	}
	public void docDuLieuVaoBang() {
		ArrayList<Phong> dsPhong = qlp.layTatCaPhong();
		for (Phong phong : dsPhong) {
			themDongVaoBang(phong);
		}
	}
	public void lamMoiTextFields() {
		txtMaPhong.setText("");
		txtGiaPhong.setText("");
		txtSoGiuong.setText("");
		txtMoTa.setText("");
		cboLoaiPhong.setSelectedIndex(0);
		txtSoNguoi.setText("");
		lblThongBao.setText("");
		txtMaPhong.requestFocus();
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		txtMaPhong.setEditable(false);
		for(int i = table.getRowCount() - 1;i >=0 ; --i) {
			modelTable.removeRow(i);
		}
		docDuLieuVaoBang();
	}
	public boolean kiemTraDuLieuNhap() {
		String gia = txtGiaPhong.getText().trim();
		String soGiuong = txtSoGiuong.getText().trim();
		String soNguoi = txtSoNguoi.getText().trim();
		String moTa = txtMoTa.getText().trim();
		String loaiPhong = cboLoaiPhong.getSelectedItem().toString();
		if(!soNguoi.matches("^([1-9]{1,})")) {
			lblThongBao.setText("Lỗi: Số người phải là số lớn hơn 0 và không được trống");
			txtSoNguoi.selectAll();
			txtSoNguoi.requestFocus();
			return false;
		}else if(!gia.matches("^([1-9]{1,})([0-9]){0,}")) {
			lblThongBao.setText("Lỗi: Giá phòng phải là số lớn hơn 0 và không được trống");
			txtGiaPhong.selectAll();
			txtGiaPhong.requestFocus();
			return false;
		}else if(!soGiuong.matches("^([1-9]{1,})")) {
			lblThongBao.setText("Lỗi: Số giường phải là số lớn hơn 0 và không được trống");
			txtSoGiuong.selectAll();
			txtSoGiuong.requestFocus();
			return false;
		}else if(!moTa.matches("^.{1,}")){
			lblThongBao.setText("Mô tả không được trống");
			txtMoTa.selectAll();
			txtMoTa.requestFocus();
			return false;
		}else if(!loaiPhong.equals("Bình thường") && !loaiPhong.equals("VIP")) {
			lblThongBao.setText("Loại phòng không được trống");
			return false;
		}
		return true;
	}
	public Phong taoPhongTuTextfields() {
		String ma = txtMaPhong.getText().trim();
		double gia = Double.parseDouble(txtGiaPhong.getText().trim());
		int soGiuong = Integer.parseInt(txtSoGiuong.getText().trim());
		int soNguoi = Integer.parseInt(txtSoNguoi.getText().trim()); 
		String moTa = txtMoTa.getText().trim();
		String loaiPhong = cboLoaiPhong.getSelectedItem().toString();
		String maLoai = qlp.layMaLoaiPhong(loaiPhong).getMaLoai();
		LoaiPhong lp = new LoaiPhong(maLoai);
		return new Phong(ma,gia, soGiuong,soNguoi,moTa, lp);
	}
	public void timPhong() {
		String maPhong="", moTa="",gia="",loaiPhong="",soGiuong="",soNguoi="";
		if(txtMaPhong.getText().trim() != null)
			maPhong = txtMaPhong.getText().trim();
		if(txtMoTa.getText().trim() != null)
			moTa= txtMoTa.getText().trim();
			loaiPhong = cboLoaiPhong.getSelectedItem().toString();
		if(txtSoGiuong.getText().trim() != null)
			soGiuong = txtSoGiuong.getText().trim();
		if(txtSoGiuong.getText().trim() != null)
			soNguoi = txtSoNguoi.getText().trim();
		if(txtGiaPhong.getText().trim() != null)
			gia = txtGiaPhong.getText().trim();
		for(int i = table.getRowCount() -1 ;i >= 0 ;--i) {
			modelTable.removeRow(i);
		}
		ArrayList<Phong> dsPhong = qlp.timPhongTheoTatCa(maPhong, gia, soGiuong,soNguoi, moTa, loaiPhong);
		if(dsPhong.size() == 0) {
			JOptionPane.showMessageDialog(this, "Không tìm thấy phòng");
			docDuLieuVaoBang();
		}else {
			for (Phong phong : dsPhong) {
				themDongVaoBang(phong);
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
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMaPhong.setText(modelTable.getValueAt(row, 0).toString());
//		cboTinhTrang.setSelectedItem(modelTable.getValueAt(row, 1).toString());
		DecimalFormat df = new DecimalFormat("###.#");
		double gia = Double.parseDouble(modelTable.getValueAt(row, 1).toString());
		txtGiaPhong.setText(df.format(gia));
		txtSoGiuong.setText(modelTable.getValueAt(row, 2).toString());
		txtMoTa.setText(modelTable.getValueAt(row, 4).toString());
		cboLoaiPhong.setSelectedItem(modelTable.getValueAt(row, 5).toString());
		btnXoa.setEnabled(true);
		btnSua.setEnabled(true);
		txtSoNguoi.setText(modelTable.getValueAt(row, 3).toString());
		txtMaPhong.setEditable(false);
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
