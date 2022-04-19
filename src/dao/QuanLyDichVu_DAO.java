package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DichVu;

public class QuanLyDichVu_DAO {
	public ArrayList<DichVu> layToanBoDichVu(){
		ArrayList<DichVu> dsDichVu  = new ArrayList<DichVu>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from DichVu");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				double gia = rs.getDouble(3);
				String donVi = rs.getString(4);
				int soLuong = rs.getInt(5);
				DichVu dv = new DichVu(ma, ten, gia, donVi, soLuong);
				dsDichVu.add(dv);
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
		return dsDichVu;
	}
	public boolean themDichVu(String ten,double gia,String donVi,int soLuong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Insert into DichVu(TenDichVu,Gia,DonVi,SoLuong) values(?,?,?,?)");
			statement.setString(1,ten);
			statement.setDouble(2,gia);
			statement.setString(3,donVi);
			statement.setInt(4, soLuong);
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
	public boolean xoaDichVu(String maDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Delete from DichVu where MaDichVu = ?");
			statement.setString(1, maDichVu);
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
	public boolean suaDichVu(DichVu dv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Update DichVu set TenDichVu = ?, Gia = ?,DonVi = ?,SoLuong = ? where MaDichVu = ?");
			statement.setString(1, dv.getTenDichVu());
			statement.setDouble(2, dv.getGia());
			statement.setString(3, dv.getDonVi());
			statement.setInt(4, dv.getSoLuong());
			statement.setString(5, dv.getMaDichVu());
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
	public DichVu timDichVuTheoMa(String maDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from DichVu where MaDichVu = ?");
			statement.setString(1, maDichVu);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ten = rs.getString(2);
				double gia = rs.getDouble(3);
				String donVi = rs.getString(4);
				int SoLuong = rs.getInt(5);
				return new DichVu(maDichVu, ten, gia, donVi, SoLuong);
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
	public ArrayList<DichVu> timDichVuTheoTatCa(String ma,String ten,String gia,String donVi,String soLuong){
		ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * \r\n" + 
					"from DichVu \r\n" + 
					"where MaDichVu like N'%"+ma+"%' and TenDichVu like N'%"+ten+"%' and Gia like N'%"+gia+"%' and DonVi like N'%"+donVi+"%' and SoLuong like N'%"+soLuong+"%'");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maDV = rs.getString(1);
				String tenDV = rs.getString(2);
				double giaDV = rs.getDouble(3);
				String donViDV = rs.getString(4);
				int soLuongDV = rs.getInt(5);
				DichVu dv = new DichVu(maDV, tenDV, giaDV, donViDV, soLuongDV);
				dsDichVu.add(dv);
			}
			return dsDichVu;
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
	public void setSoLuongDichVu(String maDichVu,int soLuong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Update DichVu set SoLuong = ? where MaDichVu = ?");
			statement.setInt(1, soLuong);
			statement.setString(2, maDichVu);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	public int laySoLuongDichVu(String maDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select SoLuong from DichVu where MaDichVu  = ?");
			statement.setString(1, maDichVu);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int soLuong = rs.getInt(1);
				return soLuong;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public boolean capNhatSoLuongSuDung(String maDV,String soLuong) {
		ConnectDB.getInstance();
		Connection con  = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n =0;
		try {
			statement = con.prepareStatement("update DichVu set SoLuong = ? where (MaDichVu = ? and DonVi = N'Lon') "
					+ "or (MaDichVu = ? and DonVi = N'Chai')");
			statement.setInt(1, Integer.parseInt(soLuong));
			statement.setString(2, maDV);
			statement.setString(3, maDV);
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
}
