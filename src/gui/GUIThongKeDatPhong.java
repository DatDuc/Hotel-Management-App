package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import dao.QuanLyKhachHang_DAO;
import dao.QuanLyThongKe_DAO;

public class GUIThongKeDatPhong extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Frame con;
	private JButton btnTheoThang;
	private JButton btnTheoNam;
	private TitledBorder titleBorder;
	private TitledBorder titleBorderNhap;
	private JComboBox<String> cboThang;
	private JComboBox<String> cboNam;
	private JPanel pDichVu;
	private QuanLyThongKe_DAO qltk = new QuanLyThongKe_DAO();
	private QuanLyKhachHang_DAO qlkh = new QuanLyKhachHang_DAO();
	private JLabel lblTitle;
	private JButton btnQuayLai;
	private JButton btnKhachHang;
	public GUIThongKeDatPhong(Frame cha) {
		con = cha;
		int rong = Toolkit.getDefaultToolkit().getScreenSize().width;
		int dai = Toolkit.getDefaultToolkit().getScreenSize().height;
		setSize(rong-100, dai-320);
		Box b , b1,b2;
		add(b = Box.createVerticalBox());
		JPanel pNorth1 = new JPanel();
		pNorth1.add(lblTitle = new JLabel("THÔNG KÊ SỐ LẦN ĐẶT PHÒNG"));
		b.add(b1 = Box.createHorizontalBox());
		b1.add(pNorth1, BorderLayout.NORTH);
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTitle.setForeground(new Color(0xFFAA00));
		b.add(b1=Box.createHorizontalBox());
		b1.add(new JLabel("Tháng: "));
		b1.add(cboThang = new JComboBox<String>());
		cboThang.addItem("");
		for(int i = 1 ; i< 13 ; i++) {
			if( i == 10 || i== 11 || i ==12)
				cboThang.addItem(i+"");
			else
				cboThang.addItem("0"+i);
		}
		b1.add(new JLabel("Năm: "));
		b1.add(cboNam = new JComboBox<String>());
		cboNam.addItem("");
		java.util.Date date = new java.util.Date();
		@SuppressWarnings("deprecation")
		int nam = date.getYear()+1900;
		for(int i =  nam;  i >= 2015 ; i--) {
			cboNam.addItem(i+"");
		}
		b1.setBorder(titleBorderNhap = new TitledBorder(BorderFactory.createLineBorder(Color.red),"Chọn ngày tháng năm"));
		titleBorderNhap.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorderNhap.setTitleColor(new Color(0xFFAA00));
		b1.setMaximumSize(new Dimension(500, 50));
		b.add(b1 = Box.createHorizontalBox());
//		b1.add(scroll = new JScrollPane());
//		b1.setBorder(BorderFactory.createLineBorder(Color.red));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnTheoThang = new JButton("Thống kê số lần đặt phòng theo tháng",new ImageIcon(".\\image\\calendaricon32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnTheoNam = new JButton("Thống kê số lần đặt phòng theo năm",new ImageIcon(".\\image\\calendaricon32.png")));
		btnTheoNam.setFont(new Font("SansSerif", Font.BOLD, 15));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnKhachHang = new JButton("Khách hàng đặt phòng nhiều nhất",new ImageIcon(".\\image\\customer32.png")));
		btnKhachHang.setFont(new Font("SansSerif", Font.BOLD, 15));
		b1.add(Box.createHorizontalStrut(50));
		b1.setBorder(titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.red),"Chọn mục muốn thống kê"));
		titleBorder.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorder.setTitleColor(new Color(0xFFAA00));
		btnTheoThang.setFont(new Font("SansSerif", Font.BOLD, 15));
		b.add(b2=Box.createHorizontalBox());
		b2.add(pDichVu = new JPanel(),BorderLayout.CENTER);
		pDichVu.setPreferredSize(new Dimension(1400, 515));
		pDichVu.setBackground(Color.WHITE);
//		b2.add(pPhong = new JPanel(),BorderLayout.CENTER);
//		pPhong.setPreferredSize(new Dimension(600, 600));
//		b2.add(pTong = new JPanel(),BorderLayout.EAST);
//		pTong.setPreferredSize(new Dimension(600,600));
		b.add(b1 = Box.createHorizontalBox());
		b1.add(btnQuayLai = new JButton("Quay lại", new ImageIcon(".\\image\\logout32.png")));
		btnQuayLai.setBackground(Color.red);
		btnTheoNam.addActionListener(this);
		btnTheoThang.addActionListener(this);
		btnQuayLai.addActionListener(this);
		btnKhachHang.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTheoThang)) {
			DefaultCategoryDataset chartData = new DefaultCategoryDataset();
			if(cboThang.getSelectedItem().toString().equals("") || cboNam.getSelectedItem().toString().equals(""))
				JOptionPane.showMessageDialog(this, "Vui lòng chọn tháng năm muốn thống kê");
			else {
				Map<String, Integer> map = qltk.laySoLanDatPhongTheoThang(cboThang.getSelectedItem().toString(),cboNam.getSelectedItem().toString());
				map.forEach((p,v) -> {
					chartData.setValue(map.get(p), "Số lần", p);
				});
				JFreeChart chart = ChartFactory.createBarChart("Thống kê số lần đặt phòng tháng "+cboThang.getSelectedItem().toString()+" năm "+cboNam.getSelectedItem().toString(), "Phòng", "Số lần", chartData,PlotOrientation.VERTICAL,true,true,false);
				CategoryPlot plot = chart.getCategoryPlot();
				plot.setRangeGridlinePaint(Color.red);
				ChartPanel chartPanel = new ChartPanel(chart);
				chartPanel.setPreferredSize(new Dimension(1400, 500));
				pDichVu.removeAll();
				pDichVu.add(chartPanel,BorderLayout.CENTER);
				pDichVu.validate();
			}
		}else if(o.equals(btnTheoNam)) {
			DefaultCategoryDataset chartData = new DefaultCategoryDataset();
			if(cboNam.getSelectedItem().toString().equals(""))
				JOptionPane.showMessageDialog(this, "Vui lòng chọn năm muốn thống kê");
			else {
				Map<String, Integer> map = qltk.laySoLanDatPhongTheoNam(cboNam.getSelectedItem().toString());
				map.forEach((p,v) -> {
					chartData.setValue(map.get(p), "Số lần",p);
				});
				JFreeChart chart = ChartFactory.createBarChart("Thống kê số lần đặt phòng năm "+cboNam.getSelectedItem().toString(), "Phòng", "Số lần", chartData,PlotOrientation.VERTICAL,true,true,false);
				CategoryPlot plot = chart.getCategoryPlot();
				plot.setRangeGridlinePaint(Color.red);
				ChartPanel chartPanel = new ChartPanel(chart);
				chartPanel.setPreferredSize(new Dimension(1400, 500));
				pDichVu.removeAll();
				pDichVu.add(chartPanel,BorderLayout.CENTER);
				pDichVu.validate();
			}
		}else if(o.equals(btnQuayLai)) {
			con.dispose();
			con = new GUIMenu(1);
		}else if(o.equals(btnKhachHang)) {
			DefaultCategoryDataset chartData = new DefaultCategoryDataset();
			ArrayList<Double> soLan = qlkh.danhSachSoLanDatPhong();
			double soLanNhieuNhat = soLan.get(0);
			Map<String, Integer> map = qlkh.khachHangDatPhongNhieu();
			map.forEach((p,v) -> {
				if(v == soLanNhieuNhat) {
					chartData.setValue(map.get(p), "Số lần",p);
				}
			});
			JFreeChart chart = ChartFactory.createBarChart("Khách hàng đặt phòng nhiều nhất", "Khách hàng", "Số lần", chartData,PlotOrientation.VERTICAL,true,true,false);
			CategoryPlot plot = chart.getCategoryPlot();
			plot.setRangeGridlinePaint(Color.red);
			ChartPanel chartPanel = new ChartPanel(chart);
			chartPanel.setPreferredSize(new Dimension(500, 500));
			pDichVu.removeAll();
			pDichVu.add(chartPanel,BorderLayout.CENTER);
			pDichVu.validate();
		}
	}
}
