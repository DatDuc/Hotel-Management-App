package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectDB.ConnectDB;

public class QuanLyCT_DichVu_DAO {
	public boolean themCTDV(String maDV,int maHD_DV,int soLuongSuDung) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Insert into CT_DichVu values(?,?,?)");
			statement.setString(1, maDV);
			statement.setInt(2, maHD_DV);
			statement.setInt(3, soLuongSuDung);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
}
