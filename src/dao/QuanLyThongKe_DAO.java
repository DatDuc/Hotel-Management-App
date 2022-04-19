package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import connectDB.ConnectDB;

public class QuanLyThongKe_DAO {
	public double layDoanhThuDichVuTheoNgay(String ngay){
		double doanhThu =0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("select hddv.MaHoaDon_DV,SoLuongSuDung,Gia,TongTien=sum(ctdv.SoLuongSuDung*dv.Gia) from HoaDon_DichVu hddv "
					+" join CT_DichVu ctdv on hddv.MaHoaDon_DV = ctdv.MaHoaDon_DV\r\n" + 
					"join DichVu dv on dv.MaDichVu = ctdv.MaDichVu where hddv.NgayLapHoaDon_DV = ? \r\n" + 
					"group by hddv.MaHoaDon_DV,SoLuongSuDung,Gia");
			statement.setDate(1, java.sql.Date.valueOf(ngay));
			ResultSet rs= statement.executeQuery();
			while(rs.next()) {
				doanhThu += rs.getDouble(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return doanhThu;
	}
	public double layDoanhThuPhongTheoNgay(String ngay) {
		double doanhThu = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("select tienPhong =\r\n" + 
					"case \r\n" + 
					"					when DATEDIFF(Dd,NgayDen,NgayDi) > 1 then DATEDIFF(Dd,NgayDen,NgayDi)*GiaPhong\r\n" + 
					"					else GiaPhong\r\n" + 
					"					end\r\n" + 
					"					from Phong as p join CT_PhieuDatPhong as ctpdp on p.MaPhong = ctpdp.MaPhong\r\n" + 
					"					join PhieuDatPhong pdp on pdp.MaPhieu = ctpdp.MaPhieu\r\n" + 
					"					join HoaDon hd on hd.MaHoaDon = pdp.MaPhieu where NgayLapHoaDon = ?");
			statement.setDate(1, java.sql.Date.valueOf(ngay));
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				doanhThu += rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return doanhThu;
	}
	public double layDoanhThuDichVuTheoThangNam(String thang,String nam) {
		double doanhThu = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("select hddv.MaHoaDon_DV,SoLuongSuDung,Gia,TongTien=sum(ctdv.SoLuongSuDung*dv.Gia) "
					+ "from HoaDon_DichVu hddv join CT_DichVu ctdv on hddv.MaHoaDon_DV = ctdv.MaHoaDon_DV\r\n" + 
					"join DichVu dv on dv.MaDichVu = ctdv.MaDichVu where DATEPART(MM,hddv.NgayLapHoaDon_DV) = ?\r\n" + 
					"and DATEPART(yyyy,hddv.NgayLapHoaDon_DV) = ?\r\n" + 
					"group by hddv.MaHoaDon_DV,SoLuongSuDung,Gia");
			statement.setInt(1, Integer.parseInt(thang));
			statement.setInt(2, Integer.parseInt(nam));
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				doanhThu += rs.getDouble(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return doanhThu;
	}
	public double layDoanhThuPhongTheoThangNam(String thang,String nam) {
		double doanhThu = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("select tienPhong =\r\n" + 
					"case \r\n" + 
					"					when DATEDIFF(Dd,NgayDen,NgayDi) > 1 then DATEDIFF(Dd,NgayDen,NgayDi)*GiaPhong\r\n" + 
					"					else GiaPhong\r\n" + 
					"					end\r\n" + 
					"					from Phong as p join CT_PhieuDatPhong as ctpdp on p.MaPhong = ctpdp.MaPhong\r\n" + 
					"					join PhieuDatPhong pdp on pdp.MaPhieu = ctpdp.MaPhieu\r\n" + 
					"					join HoaDon hd on hd.MaHoaDon = pdp.MaPhieu \r\n" + 
					"					where datepart(MM,NgayLapHoaDon) = ? and DATEPART(yyyy,NgayLapHoaDon) = ? ");
			statement.setInt(1, Integer.parseInt(thang));
			statement.setInt(2, Integer.parseInt(nam));
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				doanhThu += rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return doanhThu;
	}
	public Map<String,Integer> laySoLanDatPhongTheoThang(String thang,String nam) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("select p.MaPhong,SoLan=count(*) from Phong p join CT_PhieuDatPhong ctpdp on p.MaPhong=ctpdp.MaPhong\r\n" + 
					"						join PhieuDatPhong pdp on pdp.MaPhieu=ctpdp.MaPhieu\r\n" + 
					"					join NhanVien nv on nv.MaNhanVien= pdp.MaNhanVien\r\n" + 
					"where  DATEPART(MM,pdp.NgayLapPhieu) = ? and DATEPART(yyyy,pdp.NgayLapPhieu) = ? \r\n" + 
					"group by p.MaPhong");
			statement.setInt(1,Integer.parseInt(thang));
			statement.setInt(2,Integer.parseInt(nam));
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				map.put(rs.getString(1),rs.getInt(2));
			}
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	public Map<String,Integer> laySoLanDatPhongTheoNam(String nam) {
		Map<String,Integer> map = new TreeMap<String, Integer>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("select p.MaPhong,SoLan=count(*) from Phong p join CT_PhieuDatPhong ctpdp on p.MaPhong=ctpdp.MaPhong\r\n" + 
					"						join PhieuDatPhong pdp on pdp.MaPhieu=ctpdp.MaPhieu\r\n" + 
					"					join NhanVien nv on nv.MaNhanVien= pdp.MaNhanVien\r\n" + 
					"where  DATEPART(yyyy,pdp.NgayLapPhieu) = ? \r\n" + 
					"group by p.MaPhong");
			statement.setInt(1,Integer.parseInt(nam));
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				map.put(rs.getString(1),rs.getInt(2));
			}
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	
//	select nv.MaNhanVien,count(*) from Phong p join CT_PhieuDatPhong ctpdp on p.MaPhong=ctpdp.MaPhong
//			join PhieuDatPhong pdp on pdp.MaPhieu=ctpdp.MaPhieu
//		join NhanVien nv on nv.MaNhanVien= pdp.MaNhanVien
//where  DATEPART(MM,pdp.NgayLapPhieu)= 11 and DATEPART(yyyy,pdp.NgayLapPhieu) = 2020
//group by nv.MaNhanVien
}
