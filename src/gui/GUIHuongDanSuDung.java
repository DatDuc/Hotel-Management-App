package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class GUIHuongDanSuDung extends JFrame implements TreeSelectionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultMutableTreeNode root;
	private JTree tree;
	private DefaultMutableTreeNode parentNodeQLTaiKhoan;
	@SuppressWarnings("unused")
	private DefaultMutableTreeNode nodeThietLapMatKhau;
	private DefaultMutableTreeNode parentNhanVien;
	private DefaultMutableTreeNode parentQLPhong;
	private DefaultMutableTreeNode parentDichVu;
	private DefaultMutableTreeNode parentKhachHang;
	private DefaultMutableTreeNode parentThongKe;
	private JLabel lblDuongDan;
	private JLabel lblHD1;
	private TitledBorder titleBorderHuongDan;
	public GUIHuongDanSuDung(Frame cha) {
		setType(Type.POPUP);
		int rong = Toolkit.getDefaultToolkit().getScreenSize().width;
		int cao = Toolkit.getDefaultToolkit().getScreenSize().height;
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\image\\hotel.png"));
		setSize(new Dimension((rong/2)+200, cao/2));
		setTitle("HƯỚNG DẪN SỬ DỤNG HỆ THỐNG");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Box bMain,b,b12,b1,b2;
		add(bMain = Box.createVerticalBox());
		bMain.add(b12 = Box.createHorizontalBox());
		b12.add(b1 = Box.createVerticalBox());
		b1.add(b = Box.createHorizontalBox());
		root = new DefaultMutableTreeNode("Danh sách chức năng hệ thống");
		tree = new JTree(root);
		root.add(parentNodeQLTaiKhoan = new DefaultMutableTreeNode("Đăng nhập"));
		parentNodeQLTaiKhoan.add(new DefaultMutableTreeNode("Đăng nhập"));
		root.add(parentNhanVien = new DefaultMutableTreeNode("Quản lý nhân viên"));
		parentNhanVien.add(new DefaultMutableTreeNode("Thêm nhân viên"));
		parentNhanVien.add(new DefaultMutableTreeNode("Xóa nhân viên"));
		parentNhanVien.add(new DefaultMutableTreeNode("Sửa nhân viên"));
		parentNhanVien.add(new DefaultMutableTreeNode("Tìm nhân viên"));
		parentNhanVien.add(nodeThietLapMatKhau = new DefaultMutableTreeNode("Tạo tài khoản"));
		parentNhanVien.add(new DefaultMutableTreeNode("Đổi mật khẩu"));
		root.add(parentQLPhong = new DefaultMutableTreeNode("Quản lý phòng"));
		parentQLPhong.add(new DefaultMutableTreeNode("Thêm phòng"));
		parentQLPhong.add(new DefaultMutableTreeNode("Xóa phòng"));
		parentQLPhong.add(new DefaultMutableTreeNode("Sửa phòng"));
		parentQLPhong.add(new DefaultMutableTreeNode("Tìm phòng"));
		parentQLPhong.add(new DefaultMutableTreeNode("Tìm khách hàng đặt phòng"));
		parentQLPhong.add(new DefaultMutableTreeNode("Đặt phòng"));
		parentQLPhong.add(new DefaultMutableTreeNode("Trả phòng"));
		parentQLPhong.add(new DefaultMutableTreeNode("Chuyển phòng"));
		root.add(parentDichVu = new DefaultMutableTreeNode("Quản lý dịch vụ"));
		parentDichVu.add(new DefaultMutableTreeNode("Thêm dịch vụ"));
		parentDichVu.add(new DefaultMutableTreeNode("Xóa dịch vụ"));
		parentDichVu.add(new DefaultMutableTreeNode("Sửa dịch vụ"));
		parentDichVu.add(new DefaultMutableTreeNode("Tìm dịch vụ"));
		parentDichVu.add(new DefaultMutableTreeNode("Thanh toán dịch vụ"));
		root.add(parentKhachHang = new DefaultMutableTreeNode("Quản lý khách hàng"));
		parentKhachHang.add(new DefaultMutableTreeNode("Thêm khách hàng"));
		parentKhachHang.add(new DefaultMutableTreeNode("Xóa khách hàng"));
		parentKhachHang.add(new DefaultMutableTreeNode("Sửa khách hàng"));
		parentKhachHang.add(new DefaultMutableTreeNode("Tìm khách hàng"));
		root.add(parentThongKe = new DefaultMutableTreeNode("Thống kê"));
		parentThongKe.add(new DefaultMutableTreeNode("Thống kê doanh thu phòng"));
		parentThongKe.add(new DefaultMutableTreeNode("Thống kê doanh thu dịch vụ"));
		parentThongKe.add(new DefaultMutableTreeNode("Thống kê doanh thu tổng"));
		JScrollPane scrollTree = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		b.add(scrollTree);
		TitledBorder titleBorder;
		scrollTree.setBorder(titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.red)));
		titleBorder.setTitle("Danh sách chức năng hệ thống");
		titleBorder.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorder.setTitleColor(new Color(0xFFAA00));
		lblDuongDan = new JLabel();
		b1.add(b = Box.createHorizontalBox());
		b.add(lblDuongDan);
		b12.add(b2 = Box.createVerticalBox());
		b2.add(b = Box.createHorizontalBox());
		JScrollPane scrollHuongDan = new JScrollPane(lblHD1 = new JLabel(""
				+ "<html>"
				+ ""
				+ "<div style=\"font-size:30\">Hệ thống đặt phòng khách sạn</div>"
				+ ""
				+ "</html>",new ImageIcon(".\\image\\everestBill.png"),JLabel.LEFT),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		b.add(scrollHuongDan);
		lblHD1.setHorizontalTextPosition(JLabel.CENTER);
		lblHD1.setVerticalTextPosition(JLabel.TOP);
		b2.setBorder(titleBorderHuongDan = new TitledBorder(BorderFactory.createLineBorder(Color.red)));
		titleBorderHuongDan.setTitle("Hướng dẫn sử dụng");
		titleBorderHuongDan.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderHuongDan.setTitleColor(new Color(0xFFAA00));
		b2.setPreferredSize(new Dimension(rong/3,cao/2));
		tree.addTreeSelectionListener(this);
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
	public void valueChanged(TreeSelectionEvent e) {
		TreePath path = tree.getSelectionPath();
		Object o = path.getLastPathComponent();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) o;
		String item = node.getUserObject().toString();
		lblDuongDan.setText("");
		if(item.equals("Đăng nhập")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "<div>Nhập tên đăng nhập</div>"
					+ "<u>Bước 2:</u><br/>"
					+ "Nhập mật khẩu<div style=\"color:red\">(Không được nhập ký tự đặc biệt)</div>"
					+ "<u>Bước 3:</u><br/>"
					+ "<div>Nhấn nút ĐĂNG NHẬP</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsddangnhap.png"));
		}else if(item.equals("Tạo tài khoản")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng quản lý nhân viên<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn nhân viên muốn tạo tài khoản<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "<div>Nhấn nút TẠO TÀI KHOẢN</div>"
					+ "<u>Bước 4:</u><br/>"
					+ "<div>Nhập mật khẩu</div>"
					+ "<u>Bước 5:</u><br/>"
					+ "<div>Nhập lại mật khẩu</div>"
					+ "<u>Bước 6:</u><br/>"
					+ "<div>Nhấn nút TẠO TÀI KHOẢN</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdqlnvtaotaikhoan.png"));
		}else if(item.equals("Đổi mật khẩu")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng quản lý nhân viên<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn nhân viên muốn đổi mật khẩu<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "<div>Nhấn nút ĐỔI MẬT KHẨU</div>"
					+ "<u>Bước 4:</u><br/>"
					+ "<div>Nhập mật khẩu cũ</div>"
					+ "<u>Bước 5:</u><br/>"
					+ "<div>Nhập mật khẩu mới</div>"
					+ "<u>Bước 6:</u><br/>"
					+ "<div>Nhấn nút ĐỔI MẬT KHẨU</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdqlnvdoimatkhau.png"));
		}else if(item.equals("Đặt phòng")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng ĐẶT PHÒNG<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn phòng muốn đặt <br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "Nhập thông tin khách hàng muốn đặt<br/>"
					+ "<u>Bước 4:</u><br/>"
					+ "Chọn nút tìm kiếm khách hàng<br/>"
					+ "<div style=\"color:red\">(Thêm khách hàng nếu chưa có thông tin khách hàng)</div>"
					+ "<u>Bước 5:</u><br/>"
					+ "Chọn nút ĐẶT PHÒNG<br/>"
					+ "<u>Bước 6:</u><br/>"
					+ "Chọn nút OK để in phiếu đặt phòng<br/>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsddatphong.png"));
		}else if(item.equals("Trả phòng")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng TRẢ PHÒNG<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn phòng muốn trả <br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "Chọn phiếu đặt phòng muốn trả<br/>"
					+ "<u>Bước 4:</u><br/>"
					+ "Chọn nút ĐỒNG Ý PHÒNG MUỐN TRẢ<br/>"
					+ "<u>Bước 5:</u><br/>"
					+ "Chọn nút TRẢ PHÒNG<br/>"
					+ "<u>Bước 6:</u><br/>"
					+ "Chọn nút OK để in hóa đơn<br/>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdtraphong.png"));
		}else if(item.equals("Chuyển phòng")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng CHUYỂN PHÒNG<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn phòng muốn chuyển <br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "Chọn phiếu chi tiết phiếu đặt phòng muốn trả<br/>"
					+ "<u>Bước 4:</u><br/>"
					+ "Chọn nút ĐỒNG Ý PHÒNG MUỐN CHUYỂN<br/>"
					+ "<u>Bước 5:</u><br/>"
					+ "Chọn phòng muốn chuyển đến<br/>"
					+ "<u>Bước 6:</u><br/>"
					+ "Chọn nút CHUYỂN PHÒNG<br/>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdchuyenphong.png"));
		}else if(item.equals("Thanh toán dịch vụ")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng THANH TOÁN DỊCH VỤ<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn phòng muốn thanh toán dịch vụ <br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "Chọn dịch vụ khách hàng sử dụng<br/>"
					+ "<u>Bước 4:</u><br/>"
					+ "Chọn nút THÊM DỊCH VỤ KHÁCH HÀNG SỬ DỤNG<br/>"
					+ "<u>Bước 5:</u><br/>"
					+ "Chọn dịch vụ muốn thanh toán<br/>"
					+ "<u>Bước 6:</u><br/>"
					+ "Nhập số lượng sử dụng<br/>"
					+ "<u>Bước 7:</u><br/>"
					+ "Chọn nút ĐỒNG Ý<br/>"
					+ "<u>Bước 8:</u><br/>"
					+ "Chọn nút THANH TOÁN<br/>"
					+ "<u>Bước 9:</u><br/>"
					+ "Chọn nút OK để in hóa đơn<br/>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdthanhtoandichvu.png"));
		}else if(item.equals("Thống kê doanh thu phòng")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng THỐNG KÊ DOANH THU PHÒNG<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn ngày tháng năm muốn thống kê<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "<div>Nhấn nút THỐNG KÊ theo thời gian muốn thống kê</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdthongkephong.png"));
		}else if(item.equals("Thống kê doanh thu dịch vụ")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng THỐNG KÊ DOANH THU DỊCH VỤ<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn ngày tháng năm muốn thống kê<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "<div>Nhấn nút THỐNG KÊ theo thời gian muốn thống kê</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdthongkedichvu.png"));
		}else if(item.equals("Thống kê doanh thu tổng")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng THỐNG KÊ DOANH THU TỔNG<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn ngày tháng năm muốn thống kê<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "<div>Nhấn nút THỐNG KÊ theo thời gian muốn thống kê</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdthanhtoantong.png"));
		}else if(item.equals("Thêm nhân viên")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ NHÂN VIÊN<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Nhập thông tin nhân viên<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "<div>Nhấn nút THÊM</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdqlnvthem.png"));
		}else if(item.equals("Xóa nhân viên")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ NHÂN VIÊN<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn nhân viên muốn xóa<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "<div>Nhấn nút XÓA</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdqlnvxoa.png"));
		}else if(item.equals("Sửa nhân viên")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ NHÂN VIÊN<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn nhân viên muốn sửa<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "Nhập thông tin muốn sửa<br/>"
					+ "<u>Bước 4:</u><br/>"
					+ "<div>Nhấn nút SỬA</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdqlnvsua.png"));
		}else if(item.equals("Tìm nhân viên")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ NHÂN VIÊN<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Nhập thông tin nhân viên<br/>"
					+ "<u>Bước 3:</u>"
					+ "<div>Nhấn nút TÌM</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdqlnvtim.png"));
		}else if(item.equals("Thêm khách hàng")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ KHÁCH HÀNG<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Nhập thông tin khách hàng<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "<div>Nhấn nút THÊM</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdqlkhthem.png"));
		}else if(item.equals("Xóa khách hàng")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ KHÁCH HÀNG<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn khách hàng muốn xóa<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "<div>Nhấn nút XÓA</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdqlkhxoa.png"));
		}else if(item.equals("Sửa khách hàng")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ KHÁCH HÀNG<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn khách hàng muốn sửa<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "Nhập thông tin muốn sửa<br/>"
					+ "<u>Bước 4:</u><br/>"
					+ "<div>Nhấn nút SỬA</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdqlkhsua.png"));
		}else if(item.equals("Tìm khách hàng")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ KHÁCH HÀNG<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Nhập thông tin khách hàng muốn tìm<br/>"
					+ "<u>Bước 3:</u>"
					+ "<div>Nhấn nút TÌM</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdqlkhtim.png"));
		}else if(item.equals("Thêm dịch vụ")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ DỊCH VỤ<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Nhập thông tin dịch vụ<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "<div>Nhấn nút THÊM</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsddvthem.png"));
		}else if(item.equals("Xóa dịch vụ")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ DỊCH VỤ<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn dịch vụ muốn xóa<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "<div>Nhấn nút XÓA</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsddvxoa.png"));
		}else if(item.equals("Sửa dịch vụ")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ DỊCH VỤ<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn dịch vụ muốn sửa<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "Nhập thông tin muốn sửa<br/>"
					+ "<u>Bước 4:</u><br/>"
					+ "<div>Nhấn nút SỬA</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsddvsua.png"));
		}else if(item.equals("Tìm dịch vụ")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ DỊCH VỤ<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Nhập thông tin dịch vụ muốn tìm<br/>"
					+ "<u>Bước 3:</u>"
					+ "<div>Nhấn nút TÌM</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsddvtim.png"));
		}else if(item.equals("Thêm phòng")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ PHÒNG<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Nhập thông tin phòng<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "<div>Nhấn nút THÊM</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdqlpthem.png"));
		}else if(item.equals("Xóa phòng")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ PHÒNG<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn phòng muốn xóa<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "<div>Nhấn nút XÓA</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdqlpxoa.png"));
		}else if(item.equals("Sửa phòng")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ PHÒNG<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Chọn phòng muốn sửa<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "Nhập thông tin muốn sửa<br/>"
					+ "<u>Bước 4:</u><br/>"
					+ "<div>Nhấn nút SỬA</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsdqlpsua.png"));
		}else if(item.equals("Tìm phòng")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Chọn chức năng QUẢN LÝ PHÒNG<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Nhập thông tin phòng muốn tìm<br/>"
					+ "<u>Bước 3:</u>"
					+ "<div>Nhấn nút TÌM</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdsddvtim.png"));
		}else if(item.equals("Tìm khách hàng đặt phòng")) {
			lblHD1.setText("<html>"
					+ "<div style=\"font-size:20\">"
					+ "<u>Bước 1:</u><br/>"
					+ "Nhập thông tin khách hàng muốn tìm<br/>"
					+ "<u>Bước 2:</u><br/>"
					+ "Nhấn nút TÌM<br/>"
					+ "<u>Bước 3:</u><br/>"
					+ "Chọn khách hàng muốn đặt phòng<br/>"
					+ "<span style = \"color:red\">(Nếu không có nhấn nút QUAY LẠI và chọn chức năng <br/>QUẢN LÝ KHÁCH HÀNG để thêm khách hàng vào hệ thống)<br/></span>"
					+ "<u>Bước 4:</u><br/>"
					+ "<div>Nhấn nút ĐẶT PHÒNG</div>"
					+ "</div>"
					+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\hdstimkhachhangdatphong.png"));
		}else {
			lblHD1.setText(""
				+ "<html>"
				+ ""
				+ "<div style=\"font-size:30\">Hệ thống đặt phòng khách sạn</div>"
				+ ""
				+ "</html>");
			lblHD1.setIcon(new ImageIcon(".\\image\\everestBill.png"));
		}
	}
}
