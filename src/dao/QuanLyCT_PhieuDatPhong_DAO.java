package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import connectDB.ConnectDB;
import entity.CT_PhieuDatPhong;
import entity.PhieuDatPhong;
import entity.Phong;

public class QuanLyCT_PhieuDatPhong_DAO {
	public boolean taoCT_PhieuDatPhong(int maPDP,String maPhong,String ngayDen,String ngayDi) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Insert into CT_PhieuDatPhong values(?,?,?,?)");
			statement.setInt(1, maPDP);
			statement.setString(2, maPhong);
			statement.setDate(3, java.sql.Date.valueOf(ngayDen));
			statement.setDate(4, java.sql.Date.valueOf(ngayDi));
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
	public ArrayList<CT_PhieuDatPhong> layCT_PhieuDatPhongTheoMaPhong(String maPhong){
		ArrayList<CT_PhieuDatPhong> dsCTPDP = new ArrayList<CT_PhieuDatPhong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("select ct_pdp.* from CT_PhieuDatPhong ct_pdp join Phong p  "
					+ "on p.MaPhong=ct_pdp.MaPhong where  p.MaPhong = ? and NgayDi >= GETDATE()-1");
			statement.setString(1,maPhong);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int maCT = rs.getInt(1);
				int maPDP = rs.getInt(2);
				String maP = rs.getString(3);
				Date ngayDen = rs.getDate(4);
				Date ngayDi = rs.getDate(5);
				PhieuDatPhong pdp = new PhieuDatPhong(maPDP);
				Phong phong = new Phong(maP);
				CT_PhieuDatPhong ctPDP = new CT_PhieuDatPhong(maCT, pdp, phong, ngayDen, ngayDi);
				dsCTPDP.add(ctPDP);
			}
			return dsCTPDP;
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
	public ArrayList<CT_PhieuDatPhong> layCT_PhieuDatPhongTheoThoiGianPhong(String maPhong,String ngayDen,String ngayDi){
		ArrayList<CT_PhieuDatPhong> dsCTPDP = new ArrayList<CT_PhieuDatPhong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select ct_pdp.*	From CT_PhieuDatPhong ct_pdp join Phong p on ct_pdp.MaPhong = p.MaPhong \r\n" + 
//					"where (ct_pdp.NgayDi >= ? and ct_pdp.NgayDen <= ?)\r\n" +
					
					"where (ct_pdp.NgayDi >= getdate())"+
					"and p.MaPhong = ?");
			
//			statement.setDate(1, java.sql.Date.valueOf(ngayDen));
//			statement.setDate(2, java.sql.Date.valueOf(ngayDi));
			statement.setString(1, maPhong);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int maCT = rs.getInt(1);
				int maPDP = rs.getInt(2);
				String maP = rs.getString(3);
				Date ngayNhan = rs.getDate(4);
				Date ngayTra = rs.getDate(5);
				PhieuDatPhong pdp = new PhieuDatPhong(maPDP);
				Phong phong = new Phong(maP);
				CT_PhieuDatPhong ctPDP = new CT_PhieuDatPhong(maCT, pdp, phong, ngayNhan, ngayTra);
				dsCTPDP.add(ctPDP);
			}
			return dsCTPDP;
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
	public boolean xoaCT_PhieuDatPhong(int maCTPDP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Delete from CT_PhieuDatPhong where MaCT_PhieuDatPhong = ?");
			statement.setInt(1, maCTPDP);
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
	public CT_PhieuDatPhong layCT_PhieuDatPhongTheoMaPhieuDatPhong(String maPDP){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select ct_pdp.* \r\n" + 
					"from PhieuDatPhong as pdp join CT_PhieuDatPhong as ct_pdp on pdp.MaPhieu=ct_pdp.MaPhieu \r\n" + 
					"where pdp.MaPhieu = ?");
			statement.setString(1, maPDP);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int maCTPDP = rs.getInt(1);
				String maPhong =rs.getString(3);
				Date ngayDen = rs.getDate(4);
				Date ngayDi = rs.getDate(5);
				PhieuDatPhong pdp = new PhieuDatPhong(Integer.parseInt(maPDP));
				Phong phong = new Phong(maPhong);
				CT_PhieuDatPhong ctPDP = new CT_PhieuDatPhong(maCTPDP, pdp, phong, ngayDen, ngayDi);
				return ctPDP;
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
	public boolean suaNgayTraPhongCT_PhieuDatPhongTheoMaPDP(String maPDP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Update CT_PhieuDatPhong set NgayDi = GETDATE()-1 where MaPhieu = ?");
			statement.setInt(1, Integer.parseInt(maPDP));
			n = statement.executeUpdate();
		} catch (Exception e) {
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
	public boolean suaNgayTraPhongCT_PhieuDatPhongTheoMaCT_PDP(String maCT_PDP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Update CT_PhieuDatPhong set NgayDi = GETDATE()-1 where MaCT_PhieuDatPhong = ?");
			statement.setInt(1, Integer.parseInt(maCT_PDP));
			n = statement.executeUpdate();
		} catch (Exception e) {
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
	public ArrayList<CT_PhieuDatPhong> layTatCaCT_PhieuDatPhongTheoMaPhieuDatPhong(String maPDP){
		ArrayList<CT_PhieuDatPhong> dsPDP = new ArrayList<CT_PhieuDatPhong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select ct_pdp.* \r\n" + 
					"from PhieuDatPhong as pdp join CT_PhieuDatPhong as ct_pdp on pdp.MaPhieu=ct_pdp.MaPhieu \r\n" + 
					"where pdp.MaPhieu = ?");
			statement.setString(1, maPDP);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int maCTPDP = rs.getInt(1);
				String maPhong =rs.getString(3);
				Date ngayDen = rs.getDate(4);
				Date ngayDi = rs.getDate(5);
				PhieuDatPhong pdp = new PhieuDatPhong(Integer.parseInt(maPDP));
				Phong phong = new Phong(maPhong);
				CT_PhieuDatPhong ctPDP = new CT_PhieuDatPhong(maCTPDP, pdp, phong, ngayDen, ngayDi);
				dsPDP.add(ctPDP);
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
}
