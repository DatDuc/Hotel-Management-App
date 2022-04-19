package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import dao.QuanLyThongKe_DAO;

public class GUIThongKeDichVu extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Frame con;
	private JButton btnTheoThang;
	private JButton btnTheoNgay;
	private JButton btnTheoNam;
	private TitledBorder titleBorder;
	private TitledBorder titleBorderNhap;
	private JComboBox<String> cboNgay;
	private JComboBox<String> cboThang;
	private JComboBox<String> cboNam;
	private JPanel pDichVu;
	private QuanLyThongKe_DAO qltk = new QuanLyThongKe_DAO();
	private JLabel lblTitle;
	private JButton btnQuayLai;
	@SuppressWarnings("deprecation")
	public GUIThongKeDichVu(Frame cha) {
		con = cha;
		int rong = Toolkit.getDefaultToolkit().getScreenSize().width;
		int dai = Toolkit.getDefaultToolkit().getScreenSize().height;
		setSize(rong-100, dai-320);
		Box b , b1,b2;
		add(b = Box.createVerticalBox());
		JPanel pNorth1 = new JPanel();
		pNorth1.add(lblTitle = new JLabel("THÔNG KÊ DOANH THU DỊCH VỤ"));
		b.add(b1 = Box.createHorizontalBox());
		b1.add(pNorth1, BorderLayout.NORTH);
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTitle.setForeground(new Color(0xFFAA00));
		b.add(b1=Box.createHorizontalBox());
		b1.add(new JLabel("Ngày: "));
		b1.add(cboNgay = new JComboBox<String>());
		cboNgay.addItem("");
		for (int i = 1; i < 32; i++) {
			cboNgay.addItem(i+"");
		}
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
		b1.add(btnTheoNgay = new JButton("Thống kê doanh thu theo ngày",new ImageIcon(".\\image\\calendaricon32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnTheoThang = new JButton("Thống kê doanh thu theo tháng",new ImageIcon(".\\image\\calendaricon32.png")));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnTheoNam = new JButton("Thống kê doanh thu theo năm",new ImageIcon(".\\image\\calendaricon32.png")));
		btnTheoNam.setFont(new Font("SansSerif", Font.BOLD, 15));
		b1.setBorder(titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.red),"Chọn mục muốn thống kê"));
		titleBorder.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		titleBorder.setTitleColor(new Color(0xFFAA00));
		btnTheoNgay.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnTheoThang.setFont(new Font("SansSerif", Font.BOLD, 15));
		b.add(b2=Box.createHorizontalBox());
		b2.add(pDichVu = new JPanel(),BorderLayout.CENTER);
		pDichVu.setPreferredSize(new Dimension(800, 515));
		pDichVu.setBackground(Color.WHITE);
//		b2.add(pPhong = new JPanel(),BorderLayout.CENTER);
//		pPhong.setPreferredSize(new Dimension(600, 600));
//		b2.add(pTong = new JPanel(),BorderLayout.EAST);
//		pTong.setPreferredSize(new Dimension(600,600));
		b.add(b1 = Box.createHorizontalBox());
		b1.add(btnQuayLai = new JButton("Quay lại", new ImageIcon(".\\image\\logout32.png")));
		btnQuayLai.setBackground(Color.red);
		btnTheoNgay.addActionListener(this);
		btnTheoNam.addActionListener(this);
		btnTheoThang.addActionListener(this);
		btnQuayLai.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTheoNgay)) {
			DefaultCategoryDataset chartData = new DefaultCategoryDataset();
			if(cboNgay.getSelectedItem().toString().equals("") || cboThang.getSelectedItem().toString().equals("") || cboNam.getSelectedItem().toString().equals(""))
				JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày tháng năm muốn thống kê");
			else { 
				String ngayDV = cboNam.getSelectedItem().toString()+"-"+cboThang.getSelectedItem().toString()+"-"+cboNgay.getSelectedItem().toString();
				double doanhThuDV = qltk.layDoanhThuDichVuTheoNgay(ngayDV);
				chartData.setValue(doanhThuDV, "Doanh thu", ngayDV);
				JFreeChart chart = ChartFactory.createBarChart("Thống kê doanh thu dịch vụ", "Ngày", "Số tiền", chartData,PlotOrientation.VERTICAL,true,true,false);
				CategoryPlot plot = chart.getCategoryPlot();
				plot.setRangeGridlinePaint(Color.red);
				ChartPanel chartPanel = new ChartPanel(chart);
				chartPanel.setPreferredSize(new Dimension(800, 500));
				pDichVu.removeAll();
				pDichVu.add(chartPanel,BorderLayout.CENTER);
				pDichVu.validate();
				
//				DefaultCategoryDataset chartDataPhong = new DefaultCategoryDataset();
//				String ngayPhong = cboNam.getSelectedItem().toString()+"-"+cboThang.getSelectedItem().toString()+"-"+cboNgay.getSelectedItem().toString();
//				double doanhThuPhong = qltk.layDanhThuPhongTheoNgay(ngayPhong);
//				chartDataPhong.setValue(doanhThuPhong, "Doanh thu", ngayPhong);
//				JFreeChart chartPhong = ChartFactory.createBarChart("Thống kê doanh thu phòng", "Thời gian", "Số tiền", chartDataPhong,PlotOrientation.VERTICAL,true,true,false);
//				CategoryPlot plotPhong = chart.getCategoryPlot();
//				plotPhong.setRangeGridlinePaint(Color.red);
//				ChartPanel chartPanelPhong = new ChartPanel(chartPhong);
//				chartPanelPhong.setPreferredSize(new Dimension(500, 500));
//				pPhong.removeAll();
//				pPhong.add(chartPanelPhong,BorderLayout.CENTER);
//				pPhong.validate();
//				
//				DefaultCategoryDataset chartDataTong = new DefaultCategoryDataset();
//				double doanhThuTong= doanhThuDV+doanhThuPhong;
//				chartDataTong.setValue(doanhThuTong, "Doanh thu", ngayPhong);
//				JFreeChart chartTong= ChartFactory.createBarChart("Thống kê tổng doanh thu", "Thời gian", "Số tiền", chartDataTong,PlotOrientation.VERTICAL,true,true,false);
//				CategoryPlot plotTong = chart.getCategoryPlot();
//				plotTong.setRangeGridlinePaint(Color.red);
//				ChartPanel chartPanelTong = new ChartPanel(chartTong);
//				chartPanelTong.setPreferredSize(new Dimension(500, 500));
//				pTong.removeAll();
//				pTong.add(chartPanelTong,BorderLayout.CENTER);
//				pTong.validate();
			}
		}else if(o.equals(btnTheoThang)) {
			DefaultCategoryDataset chartData = new DefaultCategoryDataset();
			if(cboThang.getSelectedItem().toString().equals("") || cboNam.getSelectedItem().toString().equals(""))
				JOptionPane.showMessageDialog(this, "Vui lòng chọn tháng năm muốn thống kê");
			else {
				for(int i = 1; i < 32; i++) {
					String ngay = i+"";
					String ngayDV = cboNam.getSelectedItem().toString()+"-"+cboThang.getSelectedItem().toString()+"-"+ngay;
					double doanhThuDV = qltk.layDoanhThuDichVuTheoNgay(ngayDV);
					chartData.setValue(doanhThuDV, "Doanh thu",i+"");
				}
				JFreeChart chart = ChartFactory.createBarChart("Thống kê doanh thu dịch vụ tháng "+cboThang.getSelectedItem().toString()+" năm "+cboNam.getSelectedItem().toString(), "Ngày", "Số tiền", chartData,PlotOrientation.VERTICAL,true,true,false);
				CategoryPlot plot = chart.getCategoryPlot();
				plot.setRangeGridlinePaint(Color.red);
				ChartPanel chartPanel = new ChartPanel(chart);
				chartPanel.setPreferredSize(new Dimension(800, 500));
				pDichVu.removeAll();
				pDichVu.add(chartPanel,BorderLayout.CENTER);
				pDichVu.validate();
			}
		}else if(o.equals(btnTheoNam)) {
			DefaultCategoryDataset chartData = new DefaultCategoryDataset();
			if(cboNam.getSelectedItem().toString().equals(""))
				JOptionPane.showMessageDialog(this, "Vui lòng chọn năm muốn thống kê");
			else {
				for(int i = 1; i < 13; i++) {
					String thang = i+"";
					String nam = cboNam.getSelectedItem().toString();
					double doanhThuDV = qltk.layDoanhThuDichVuTheoThangNam(thang, nam);
					chartData.setValue(doanhThuDV, "Doanh thu",""+i);
				}
				JFreeChart chart = ChartFactory.createBarChart("Thống kê doanh thu dịch vụ năm "+cboNam.getSelectedItem().toString(), "Tháng", "Số tiền", chartData,PlotOrientation.VERTICAL,true,true,false);
				CategoryPlot plot = chart.getCategoryPlot();
				plot.setRangeGridlinePaint(Color.red);
				ChartPanel chartPanel = new ChartPanel(chart);
				chartPanel.setPreferredSize(new Dimension(800, 500));
				pDichVu.removeAll();
				pDichVu.add(chartPanel,BorderLayout.CENTER);
				pDichVu.validate();
			}
		}else if(o.equals(btnQuayLai)) {
			con.dispose();
			con = new GUIMenu(1);
		}
	}
}
