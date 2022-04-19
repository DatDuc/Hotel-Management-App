package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

public class QuanLyNhanVien_DAO {
	public String layMatKhau(String tenDangNhap) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		String matKhau = "";
		try {

			String sql = "Select MatKhau from TaiKhoan where TenDangNhap = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, tenDangNhap);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				matKhau = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return matKhau;
	}

	public boolean themTaiKhoan(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int n = 0;
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Insert into TaiKhoan values (?,?,?)");
			statement.setString(1, tk.getTenDangNhap());
			statement.setString(2, tk.getMatKhau());
			statement.setString(3, tk.getNhanVien().getMaNhanVien());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean doiTaiKhoan(String tenDangNhap, String matKhau) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Update TaiKhoan set MatKhau = ? where TenDangNhap = ?");
			statement.setString(1, matKhau);
			statement.setString(2,tenDangNhap);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean xoaTaiKhoan(String maNhanVien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Delete from TaiKhoan where maNhanVien = " + maNhanVien + "");
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	public ArrayList<TaiKhoan> layToanBoTaiKhoan(){
		ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<TaiKhoan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from TaiKhoan");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String tenDangNhap = rs.getString(1);
				String matKhau = rs.getString(2);
				String ma = rs.getString(3);
				NhanVien nv = new NhanVien(ma);
				TaiKhoan tk = new TaiKhoan(tenDangNhap, matKhau, nv);
				dsTaiKhoan.add(tk);
			}
			return dsTaiKhoan;
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
	public NhanVien layNhanVienTheoMa(String maNhanVien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from NhanVien where MaNhanVien = ?");
			statement.setString(1, maNhanVien);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String ten = rs.getString(2);
				String gioiTinh = rs.getString(3);
				String cMND = rs.getString(4);
				String sDT = rs.getString(5);
				Date ngaySinh = rs.getDate(6);
				String diaChi = rs.getString(7);
				return new NhanVien(maNhanVien, ten, gioiTinh, cMND, sDT, ngaySinh, diaChi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	public boolean themNhanVien(String ten,String gt,String cMND,String sDT,Date ngaySinh,String diaChi) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Insert into NhanVien(TenNhanVien,GioiTinh,CMND,SoDienThoai,NgaySinh,DiaChi) values(?,?,?,?,?,?)");
			statement.setString(1,ten);
			statement.setString(2,gt);
			statement.setString(3, cMND);
			statement.setString(4, sDT);
			statement.setDate(5, ngaySinh);
			statement.setString(6,diaChi);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean xoaNhanVien(String maNhanVien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Delete from NhanVien where MaNhanVien = ?");
			statement.setString(1, maNhanVien);
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean suaNhanVien(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Update NhanVien set TenNhanVien = ?,GioiTinh = ?, CMND = ?,"
					+ "SoDienThoai = ?,NgaySinh = ?,DiaChi = ? where MaNhanVien = ?");
			statement.setString(1, nv.getTenNhanVien());
			statement.setString(2, nv.getGioiTinh());
			statement.setString(3, nv.getcMND());
			statement.setString(4, nv.getSoDienThoai());
			statement.setDate(5, nv.getNgaySinh());
			statement.setString(6, nv.getDiaChi());
			statement.setString(7, nv.getMaNhanVien());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public ArrayList<NhanVien> timNhanVienTheoTen(String tenNhanVien) {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from NhanVien where TenNhanVien = ?");
			statement.setString(1, tenNhanVien);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getString(1);
				String gioiTinh = rs.getString(3);
				String cMND = rs.getString(4);
				String soDienThoai = rs.getString(5);
				Date ngaySinh = rs.getDate(6);
				String diaChi = rs.getString(7);
				NhanVien nv = new NhanVien(ma, tenNhanVien, gioiTinh, cMND, soDienThoai, ngaySinh, diaChi);
				dsNhanVien.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return dsNhanVien;
	}

	public ArrayList<NhanVien> timKiemNhanVienTheoTatCa(String ma, String ten, String gioiTinh, String cMND, String sDT,
			String ngaySinh, String diaChi) {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement= con.prepareStatement("Select * \r\n" + 
					"from NhanVien \r\n" + 
					"where MaNhanVien like N'%"+ma+"%' and TenNhanVien like N'%"+ten+"%' and GioiTinh like N'%"+gioiTinh+"%' and \r\n" + 
					"CMND like N'%"+cMND+"%' and SoDienThoai like N'%"+sDT+"%' and NgaySinh like N'%"+ngaySinh+"%' and DiaChi like N'%"+diaChi+"%'");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String gt = rs.getString(3);
				String cmnd = rs.getString(4);
				String sdt = rs.getString(5);
				Date ngaysinh = rs.getDate(6);
				String diachi = rs.getString(7);
				NhanVien nv = new NhanVien(maNV, tenNV, gt, cmnd, sdt,ngaysinh, diachi);
				dsNhanVien.add(nv);
			}
			return dsNhanVien;
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
	public ArrayList<NhanVien> layToanBoNhanVien(){
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from NhanVien");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String gt = rs.getString(3);
				String cmnd = rs.getString(4);
				String sdt = rs.getString(5);
				Date ngaysinh = rs.getDate(6);
				String diachi = rs.getString(7);
				NhanVien nv = new NhanVien(maNV, tenNV, gt, cmnd, sdt,ngaysinh, diachi);
				dsNhanVien.add(nv);
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
		return dsNhanVien;
	}
	public NhanVien timNhanVienTheoCMND(String cMND) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from NhanVien where CMND = ?");
			statement.setString(1, cMND);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gt = rs.getString(3);
				String sDT = rs.getString(5);
				Date ngaySinh = rs.getDate(6);
				String diaChi = rs.getString(7);
				return new NhanVien(ma, ten, gt, cMND, sDT, ngaySinh, diaChi);
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
