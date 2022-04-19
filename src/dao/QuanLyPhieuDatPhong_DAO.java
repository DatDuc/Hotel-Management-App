package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;

public class QuanLyPhieuDatPhong_DAO {
	public ArrayList<PhieuDatPhong> layPhieuDatPhongTheoMaPhong(String ma){
		ArrayList<PhieuDatPhong> dsPDP = new ArrayList<PhieuDatPhong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("select pdp.*,case\r\n" + 
					"when ctpdp.NgayDi = ? then 2  \r\n" + 
					"when ctpdp.NgayDen < ? then 1\r\n" + 
					"else 0\r\n" + 
					"end as tinhtrang from  Phong as p\r\n" + 
					"join CT_PhieuDatPhong as ctpdp on ctpdp.MaPhong = p.MaPhong\r\n" + 
					"join PhieuDatPhong as pdp on pdp.MaPhieu = ctpdp.MaPhieu\r\n" + 
					"join KhachHang as kh on kh.MaKhachHang = pdp.MaKhachHang where (\r\n" + 
					"(ctpdp.ngayDi  >= ?)and p.maPhong = ? )");
			statement.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
			statement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
			statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
			statement.setString(4, ma);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int maPhieu = rs.getInt(1);
				Date ngayLapPhieu = rs.getDate(2);
				String maNV = rs.getString(3);
				String maKH = rs.getString(4);
				NhanVien nv = new NhanVien(maNV);
				KhachHang kh = new KhachHang(maKH);
				dsPDP.add(new PhieuDatPhong(maPhieu, ngayLapPhieu, nv, kh));
			}
			return dsPDP;
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
	
	public boolean themPhieuDatPhong(String ngayLapPhieu,String maNV,String maKH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Insert into PhieuDatPhong values(?,?,?)");
			statement.setDate(1,java.sql.Date.valueOf(ngayLapPhieu));
			statement.setString(2, maNV);
			statement.setString(3, maKH);
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
	public int layMaPhieuLonNhat() {
		int result = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select Max(MaPhieu) from PhieuDatPhong");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	public PhieuDatPhong layPhieuDatPhongTheoMaCT_PhieuDatPhong(int maCT_PDP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("select pdp.MaPhieu,NgayLapPhieu,MaNhanVien,MaKhachHang\r\n" + 
					"from PhieuDatPhong as pdp join CT_PhieuDatPhong as ct_pdp on pdp.maPhieu = ct_pdp.MaPHieu\r\n" + 
					"where ct_pdp.MaCT_PhieuDatPhong = ?");
			statement.setInt(1,maCT_PDP);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int maPDP = rs.getInt(1);
				Date ngayLap = rs.getDate(2);
				String maNV = rs.getString(3);
				String maKH = rs.getString(4);
				NhanVien nv = new NhanVien(maNV);
				KhachHang kh = new KhachHang(maKH);
				return new PhieuDatPhong(maPDP, ngayLap, nv, kh);
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
//	public boolean suaNgayTraPhong(String maPhieu,String ngayDi) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		int n = 0;
//		try {
//			statement  = con.prepareStatement("Update PhieuDatPhong set NgayDi = ? where MaPhieu = ?");
//			statement.setInt(1, Integer.parseInt(maPhieu));
//			statement.setDate(2, java.sql.Date.valueOf(ngayDi));
//			n = statement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				statement.close();
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
//		}
//		return n > 0;
//	}
//	public ArrayList<PhieuDatPhong> layPhongVaKhachHangTrongPhieuDatPhong(){
//		ArrayList<PhieuDatPhong> dsPhieuDatPhong = new ArrayList<PhieuDatPhong>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//			statement = con.prepareStatement("select p.*,kh.*,pdp.NgayDen,NgayDi \r\n" + 
//					"from Phong p join PhieuDatPHong pdp on p.MaPhong = pdp.MaPhong\r\n" + 
//					"					join KhachHang kh on pdp.MaKhachHang = kh.MaKhachHang");
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				String maPhong = rs.getString(1);
//				double giaPhong = rs.getDouble(3);
//				int soGiuong = rs.getInt(4);
//				String moTa = rs.getString(5);
//				String maLoai = rs.getString(6);
//				String maKhachHang = rs.getString(7);
//				String tenKhachHang = rs.getString(8);
//				String gioiTinh = rs.getString(9);
//				String cMND = rs.getString(10);
//				String sDT = rs.getString(11);
//				Date ngaySinh = rs.getDate(12);
//				Date ngayDen = rs.getDate(13);
//				Date ngayDi = rs.getDate(14);
//
//				java.util.Date ngayHienTai = new java.util.Date();
//
//				int tinhTrangPhong = -1 ;
//
//				if (ngayHienTai.compareTo(ngayDi) > 0)
//					tinhTrangPhong = 0; // chưa đặt
//				else if (ngayHienTai.compareTo(ngayDen) < 0 && ngayHienTai.compareTo(ngayDi) > 0)
//					tinhTrangPhong = 3; //đang sử dụng
//				else if (ngayHienTai.compareTo(ngayDi) == 0)
//					tinhTrangPhong = 2;//đến hạn trả
//				else if (ngayHienTai.compareTo(ngayDi) < 0)
//					tinhTrangPhong = 1;//đã đặt
//				LoaiPhong lp = new LoaiPhong(maLoai);
//				KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, gioiTinh, cMND, sDT, ngaySinh);
//				Phong phong = new Phong(maPhong, giaPhong, soGiuong, moTa, lp,tinhTrangPhong);
//				dsPhieuDatPhong.add(new PhieuDatPhong(ngayDen, ngayDi, kh, phong));
//			}
//			return dsPhieuDatPhong;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				statement.close();
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
//		}
//		return null;
//	}
	public boolean xoaPhieuDatPhong(int maPDP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Delete from PhieuDatPhong where MaPhieu = ?");
			statement.setInt(1, maPDP);
			n=statement.executeUpdate();
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
	public PhieuDatPhong timPhieuDatPhongTheoMaPhieu(String maPDP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from PhieuDatPhong where MaPhieu = ?");
			statement.setNString(1, maPDP);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int maPhieu = rs.getInt(1);
				Date ngayLapPhieu = rs.getDate(2);
				String maNV = rs.getString(3);
				String maKH = rs.getString(4);
				NhanVien nv = new NhanVien(maNV);
				KhachHang kh = new KhachHang(maKH);
				return new PhieuDatPhong(maPhieu, ngayLapPhieu, nv, kh);
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
//	public boolean suaNgayDiPhieuDatPhong(int maPDP) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		int n =0;
//		try {
//			statement = con.prepareStatement("Update PhieuDatPhong set NgayDi = ? where maPhieu = ?");
//			statement.setDate(1,java.sql.Date.valueOf(LocalDate.now().minusDays(1)));
//			statement.setInt(2,maPDP);
//			n = statement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				statement.close();
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
//		}
//		return n > 0;
//	}
}
