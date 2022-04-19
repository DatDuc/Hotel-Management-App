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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import dao.QuanLyNhanVien_DAO;
import dao.QuanLyPhong_DAO;
import entity.LoaiPhong;


public class GUILoaiPhong extends JFrame implements ActionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GUIMenu menu;
	
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnLamMoi;
	private JButton btnTim;
	private JButton btnQuayLai;
	private DefaultTableModel modelTable;
	private JTextField txtMaLoaiPhong;
	private JTextField txtTenLoai;
	private JButton btnSua;
	private QuanLyPhong_DAO qlp = new QuanLyPhong_DAO();
	private QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
	private JTable table;
	private Frame frame;
	@SuppressWarnings("serial")
	public GUILoaiPhong(Frame frameCha) {
		frame = frameCha;
		setType(Type.POPUP);
		setTitle("QUẢN LÝ LOẠI PHÒNG");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\image\\hotel.png"));
		int rong = Toolkit.getDefaultToolkit().getScreenSize().width;
		int cao= Toolkit.getDefaultToolkit().getScreenSize().height;
		setSize(rong/2, cao/2);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel pNorth = new JPanel();
		JLabel lblTitle;
		pNorth.add(lblTitle = new JLabel("QUẢN LÝ LOẠI PHÒNG"));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTitle.setForeground(new Color(0xFFAA00));
		Box bMain,b;
		bMain = Box.createVerticalBox();
		bMain.add(pNorth,BorderLayout.NORTH);
		bMain.add(b= Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(100));
		b.add(new JLabel("Mã loại phòng: "));
		b.add(txtMaLoaiPhong = new JTextField());
		b.add(Box.createHorizontalStrut(100));
		b.add(new JLabel("Tên lọai phòng: "));
		b.add(txtTenLoai = new JTextField());
		b.add(Box.createHorizontalStrut(100));
		bMain.add(Box.createVerticalStrut(20));
		bMain.add(b=Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(5));
		b.add(btnThem = new JButton("Thêm", new ImageIcon(".\\image\\add32.png")));
		b.add(Box.createHorizontalStrut(50));
		b.add(btnXoa = new JButton("Xóa", new ImageIcon(".\\image\\remove32.png")));
		b.add(Box.createHorizontalStrut(50));
		b.add(btnSua = new JButton("Sửa", new ImageIcon(".\\image\\update32.png")));
		b.add(Box.createHorizontalStrut(50));
		b.add(btnLamMoi = new JButton("Làm mới", new ImageIcon(".\\image\\reload32.png")));
		b.add(Box.createHorizontalStrut(50));
		b.add(btnTim = new JButton("Tìm", new ImageIcon(".\\image\\search32.png")));
		b.add(Box.createHorizontalStrut(50));
		b.add(btnQuayLai = new JButton("Quay Lại", new ImageIcon(".\\image\\logout32.png")));
		btnQuayLai.setBackground(Color.red);
		b.add(Box.createHorizontalStrut(5));
		Border borderButton = BorderFactory.createLineBorder(Color.red);
		TitledBorder titleBorderButton = new TitledBorder(borderButton, "Chọn tác vụ");
		titleBorderButton.setTitleFont(new Font("SansSerif", Font.ITALIC, 15));
		titleBorderButton.setTitleColor(new Color(0xFFAA00));
		b.setBorder(titleBorderButton);
		btnThem.setMaximumSize(new Dimension(100, 50));
		btnThem.setMaximumSize(btnThem.getMaximumSize());
		btnXoa.setMaximumSize(btnThem.getMaximumSize());
		btnXoa.setMaximumSize(btnThem.getMaximumSize());
		btnLamMoi.setMaximumSize(btnThem.getMaximumSize());
		btnTim.setMaximumSize(btnThem.getMaximumSize());
		String header[] = {"Mã loại","Tên loại"};
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
		for(int i = 0 ; i <2;++i) {
			table.getColumnModel().getColumn(i).setCellRenderer(renderCenter);
		}
		int widthCol[]= {20,20}; 
		for(int i = 0 ; i <2;++i) {
			table.getColumnModel().getColumn(i).setPreferredWidth(widthCol[i]*3);;
		}
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBorder(BorderFactory.createLineBorder(Color.RED));
		bMain.add(b = Box.createHorizontalBox());
		b.add(scroll);
		bMain.add(Box.createVerticalStrut(20));
		docDuLieuVaoBang();
		btnTim.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnQuayLai.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		table.addMouseListener(this);
		txtMaLoaiPhong.setEditable(false);
		btnXoa.setEnabled(false);
		btnSua.setEnabled(false);
		bMain.setMaximumSize(new Dimension((rong/2)-200, (cao/2)-100));
		add(bMain);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnQuayLai)) {
			this.dispose();
			frame.dispose();
			String ma = GUIDangNhap.ma;
			if(ma.equals("NV000001")) {
				frame.dispose();
				menu = new GUIMenu(1);
				menu.setVisible(true);
				menu.doiPanel(new GUIPhong(frame));
			}else {
				frame.dispose();
				GUIMenuDanhChoNhanVien menuNV = new GUIMenuDanhChoNhanVien(qlnv.layNhanVienTheoMa(ma).getTenNhanVien());
				menuNV.setVisible(true);
				menu.doiPanel(new GUIPhong(frame));
			}
		}else if(o.equals(btnThem)) {
			if(kiemTraDuLieuNhap()) {
				int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm loại phòng không?","Nhắc nhở",JOptionPane.YES_NO_OPTION);
				if(kq == JOptionPane.OK_OPTION) {
					if(txtMaLoaiPhong.getText().trim().equals("")) {
						String ten = txtTenLoai.getText().trim();
						if(qlp.themLoaiPhong(ten)) {
							JOptionPane.showMessageDialog(this, "Thêm loại phòng "+qlp.layMaLoaiPhong(ten).getMaLoai()+" thành công");
							lamMoiTextfields();
						}
					}else {
						JOptionPane.showMessageDialog(this, "Thêm phòng trùng mã");
					}
				}
			}
		}else if(o.equals(btnLamMoi)) {
			lamMoiTextfields();
		}else if(o.equals(btnXoa)) {
			String ma = txtMaLoaiPhong.getText().trim();
			int kq  = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa loại phòng"+ma+" không?","Nhắc nhở",JOptionPane.YES_NO_OPTION);
			if(kq == JOptionPane.YES_OPTION) {
				if(qlp.xoaLoaiPhong(ma)) {
					JOptionPane.showMessageDialog(this,"Xóa loại phòng "+ma+" thành công");
					lamMoiTextfields();
				}else {
					JOptionPane.showMessageDialog(this, "Xóa loại phòng "+ma+" không thành công" );
				}
			}
		}else if(o.equals(btnSua)) {
			String ma = txtMaLoaiPhong.getText().trim();
			int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa phòng "+ma+" không?","Nhắc nhở",JOptionPane.YES_NO_OPTION);
			if(kq == JOptionPane.YES_OPTION) {
				if(kiemTraDuLieuNhap()) {
					LoaiPhong lp = taoLoaiPhongTuTextfields();
					if(qlp.suaLoaiPhong(lp)) {
						JOptionPane.showMessageDialog(this, "Sửa phòng "+ma+" thành công");
						lamMoiTextfields();
					}else {
						JOptionPane.showMessageDialog(this, "Sửa phòng "+ma+"không thành công");
					}
				}
			}
		}else if(o.equals(btnTim)) {
			String ten = txtTenLoai.getText().trim();
			ArrayList<LoaiPhong> dsLoaiPhong = qlp.timLoaiPhongTheoTen(ten);
			if(dsLoaiPhong.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy loại phòng");
				lamMoiTextfields();
			}else {
				xoaBang();
				for (LoaiPhong loaiPhong : dsLoaiPhong) {
					themDongVaoBang(loaiPhong);
				}
			}
		}
	}
	public void lamMoiTextfields() {
		txtMaLoaiPhong.setText("");
		txtTenLoai.setText("");
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		xoaBang();
		docDuLieuVaoBang();
	}
	public void themDongVaoBang(LoaiPhong lp) {
		modelTable.addRow(new Object[] {
			lp.getMaLoai(),lp.getTenLoai()
		});
	}
	public void xoaBang() {
		for(int i = table.getRowCount()-1;i>=0;i--) {
			modelTable.removeRow(i);
		}
	}
	public void docDuLieuVaoBang() {
		ArrayList<LoaiPhong> dsLoaiPhong = qlp.layTatCaLoaiPhong();
		for (LoaiPhong loaiPhong : dsLoaiPhong) {
			themDongVaoBang(loaiPhong);
		}
	}
	public boolean kiemTraDuLieuNhap() {
		String ten = txtTenLoai.getText().trim();
		if(!ten.matches("^.{1,}")) {
			txtTenLoai.selectAll();
			txtTenLoai.requestFocus();
			JOptionPane.showMessageDialog(this, "Tên loại phòng không được trống");
			return false;
		}
		return true;
	}
	public LoaiPhong taoLoaiPhongTuTextfields() {
		String ma = txtMaLoaiPhong.getText().trim();
		String ten = txtTenLoai.getText().trim();
		return new LoaiPhong(ma, ten);
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
		txtMaLoaiPhong.setText(modelTable.getValueAt(row, 0).toString());
		txtTenLoai.setText(modelTable.getValueAt(row, 1).toString());
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
