package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.HoaDon_DichVu;
import entity.NhanVien;
import entity.Phong;

public class QuanLyHoaDon_DichVu {
	public boolean themHoaDon_DichVu(String ngayLapHoaDon_DV,String maPhong,String maNhanVien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Insert into HoaDon_DichVu values(?,?,?)");
			statement.setDate(1, java.sql.Date.valueOf(ngayLapHoaDon_DV));
			statement.setString(2, maPhong);
			statement.setString(3, maNhanVien);
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
	public int layMaHoaDonLonNhat() {
		int result = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select Max(MaHoaDon_DV) from HoaDon_DichVu");
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
	public HoaDon_DichVu timHoaDonDichVuTheoMaHD(int maHDDV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("select * from HoaDon_DichVu where MaHoaDon_DV = ?");
			statement.setInt(1, maHDDV);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Date ngayLapHD = rs.getDate(2);
				String maPhong = rs.getString(3);
				String maNhanVien = rs.getString(4);
				Phong p = new Phong(maPhong);
				NhanVien nv = new NhanVien(maNhanVien);
				return new HoaDon_DichVu(maHDDV, ngayLapHD, p, nv);
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
}
