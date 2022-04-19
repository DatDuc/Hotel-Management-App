package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HoaDon;

public class QuanLyHoaDon_DAO {
	public ArrayList<HoaDon> layTatCaHoaDon() {
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from HoaDon");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int ma = rs.getInt(1);
				Date ngayLapHoaDon = rs.getDate(2);
				HoaDon hd = new HoaDon(ma, ngayLapHoaDon);
				dsHoaDon.add(hd);
			}
			return dsHoaDon;
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
	public boolean themHoaDon(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Insert into HoaDon values (?,?)");
			statement.setInt(1,Integer.parseInt(ma));
			statement.setDate(2,java.sql.Date.valueOf(LocalDate.now()));
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
	public HoaDon timHoaDonTheoMa(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from HoaDon ");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Date ngayLapHoaDon = rs.getDate(2);
				return new HoaDon(Integer.parseInt(ma), ngayLapHoaDon);
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
