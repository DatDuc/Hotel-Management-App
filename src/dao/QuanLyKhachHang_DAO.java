package dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import connectDB.ConnectDB;
import entity.KhachHang;

public class QuanLyKhachHang_DAO {
	public ArrayList<KhachHang> layToanBoKhachHang(){
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from KhachHang");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gioiTinh = rs.getString(3);
				String cMND = rs.getString(4);
				String sDT = rs.getString(5);
				Date ngaySinh = rs.getDate(6);
				KhachHang kh = new KhachHang(ma, ten, gioiTinh, cMND, sDT, ngaySinh);
				dsKhachHang.add(kh);
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
		return dsKhachHang;
	}
	public boolean themKhachHang(String ten,String gt,String cMND,String sDT,Date ngaySinh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Insert into KhachHang(TenKhachHang,GioiTinh,"
					+ "CMND,SoDienThoai,NgaySinh) values(?,?,?,?,?)");
			statement.setString(1, ten);
			statement.setString(2, gt);
			statement.setString(3, cMND);
			statement.setString(4, sDT);
			statement.setDate(5,ngaySinh);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean xoaKhachHang(String maKhachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Delete from KhachHang where MaKhachHang = ?");
			statement.setString(1, maKhachHang);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException  e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	public boolean suaKhacHang(KhachHang kh){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Update KhachHang set TenKhachHang=?,GioiTinh=?,CMND=?,SoDienThoai=?,NgaySinh=? where MaKhachHang = ?");
			statement.setString(1, kh.getTenKhachHang());
			statement.setString(2, kh.getGioiTinh());
			statement.setString(3, kh.getcMND());
			statement.setString(4, kh.getSoDienThoai());
			statement.setDate(5, kh.getNgaySinh());
			statement.setString(6, kh.getMaKhachHang());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	public KhachHang timKhacHangTheoMa(String maKhachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from KhachHang where MaKhachHang = ?");
			statement.setString(1, maKhachHang);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ten = rs.getString(2);
				String gioiTinh = rs.getString(3);
				String cMND = rs.getString(4);
				String sDT = rs.getString(5);
				Date ngaySinh = rs.getDate(6);
				return new KhachHang(maKhachHang, ten, gioiTinh, cMND, sDT, ngaySinh);
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
		return null;
	}
	public KhachHang timKhachHangTheoTen(String tenKhachHang){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from KhachHang where TenKhachHang = ?");
			statement.setString(1, tenKhachHang);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String gioiTinh = rs.getString(3);
				String cMND = rs.getString(4);
				String sDT = rs.getString(5);
				Date ngaySinh = rs.getDate(6);
				KhachHang kh = new KhachHang(ma, tenKhachHang, gioiTinh, cMND, sDT, ngaySinh);
				return kh;
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
		return null;
	}
	public KhachHang timKhachHangTheoCMND(String cMND) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from KhachHang where CMND = ?");
			statement.setString(1, cMND);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gioiTinh = rs.getString(3);
				String sDT = rs.getString(4);
				Date ngaySinh = rs.getDate(6);
				return new KhachHang(ma, ten, gioiTinh, cMND, sDT, ngaySinh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<KhachHang> timKhachHangTheoTatCa(String ma,String ten,String gioiTinh,String cMND,String sDT,String ngaySinh){
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * \r\n" + 
					"from KhachHang \r\n" + 
					"where MaKhachHang like N'%"+ma+"%' and TenKhachHang like N'%"+ten+"%' and GioiTinh like N'%"+gioiTinh+"%' and \r\n" + 
					"CMND like N'%"+cMND+"%' and SoDienThoai like N'%"+sDT+"%' and NgaySinh like N'%"+ngaySinh+"%'";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String gioitinh = rs.getString(3);
				String cmnd = rs.getString(4);
				String sdt = rs.getString(5);
				Date nSinh = rs.getDate(6);
				KhachHang kh =new KhachHang(maKH, tenKH,gioitinh, cmnd, sdt, nSinh);
				dsKhachHang.add(kh);
			}
			return dsKhachHang;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public KhachHang layKhachHangTheoMaPhieuDatPhong(String maPDP){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select kh.* \r\n" + 
					"from KhachHang as kh join PhieuDatPhong as pdp on pdp.MaKhachHang = kh.MaKhachHang \r\n" + 
					"where MaPhieu = ?");
			statement.setString(1, maPDP);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maKH = rs.getString(1);
				String ten = rs.getString(2);
				String gioiTinh = rs.getString(3);
				String cMND = rs.getString(4);
				String sDT = rs.getString(5);
				Date ngaySinh = rs.getDate(6);
				return  new KhachHang(maKH, ten, gioiTinh, cMND, sDT, ngaySinh);

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
		return null;
	}
	public ArrayList<KhachHang> timKhachHangTheoDatPhong(String ten,String cMND,String sDT){
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * \r\n" + 
					"from KhachHang \r\n" + 
					"where TenKhachHang like N'%"+ten+"%' and CMND like N'%"+cMND+"%' and SoDienThoai like N'%"+sDT+"%'";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String gioitinh = rs.getString(3);
				String cmnd = rs.getString(4);
				String sdt = rs.getString(5);
				Date nSinh = rs.getDate(6);
				KhachHang kh =new KhachHang(maKH, tenKH,gioitinh, cmnd, sdt, nSinh);
				dsKhachHang.add(kh);
			}
			return dsKhachHang;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Map<String, Integer> khachHangDatPhongNhieu(){
		Map<String, Integer> map = new TreeMap<String, Integer>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(""
					+ "select kh.MaKhachHang , count(*) from KhachHang kh join PhieuDatPhong pdp on kh.MaKhachHang=pdp.MaKhachHang\r\n" + 
					"							join CT_PhieuDatPhong ctpdp on pdp.MaPhieu= ctpdp.MaPhieu\r\n" + 
					"							group by kh.MaKhachHang\r\n" + 
					"							");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma= rs.getString(1);
				int soLan = rs.getInt(2);
				map.put(ma, soLan);
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
	public ArrayList<Double> danhSachSoLanDatPhong(){
		ArrayList<Double> ds = new ArrayList<Double>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("select kh.MaKhachHang , count(*) from KhachHang kh join PhieuDatPhong pdp on kh.MaKhachHang=pdp.MaKhachHang\r\n" + 
					"							join CT_PhieuDatPhong ctpdp on pdp.MaPhieu= ctpdp.MaPhieu\r\n" + 
					"							group by kh.MaKhachHang\r\n" + 
					"							order by count(*) DESC");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				double num = rs.getDouble(2);
				ds.add(num);
			}
			return ds;
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
}
