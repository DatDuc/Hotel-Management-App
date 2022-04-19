package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiPhong;
import entity.Phong;

public class QuanLyPhong_DAO {
	public ArrayList<String> layTatCaTenLoai(){
		ArrayList<String> dsTenLoai = new ArrayList<String>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select TenLoai from LoaiPhong");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ten = rs.getString(1);
				dsTenLoai.add(ten);
			}
			return dsTenLoai;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return null;
	}
	public ArrayList<LoaiPhong> layTatCaLoaiPhong(){
		ArrayList<LoaiPhong> dsLoaiPhong = new ArrayList<LoaiPhong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from LoaiPhong");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maLoai = rs.getString(1);
				String tenLoai = rs.getString(2);
				LoaiPhong loaiPhong = new LoaiPhong(maLoai, tenLoai);
				dsLoaiPhong.add(loaiPhong);
			}
			return dsLoaiPhong;
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
	public ArrayList<Phong> layTatCaPhong(){
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from Phong");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				double gia = rs.getDouble(2);
				int soGiuong = rs.getInt(3);
				int soNguoi = rs.getInt(4);
				String moTa = rs.getString(5);
				String maLoai = rs.getString(6);
				LoaiPhong loaiPhong = new LoaiPhong(maLoai);
				Phong phong = new Phong(ma, gia, soGiuong,soNguoi, moTa, loaiPhong);
				dsPhong.add(phong);
			}
			return dsPhong;
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
	public LoaiPhong layTenLoaiPhong(String maLoai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from LoaiPhong where MaLoai = ?");
			statement.setString(1, maLoai);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ten = rs.getString(2);
				return new LoaiPhong(maLoai, ten);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return null;
	}
	public LoaiPhong layMaLoaiPhong(String tenLoai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from LoaiPhong where TenLoai = ?");
			statement.setString(1, tenLoai);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				return new LoaiPhong(ma, tenLoai);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return null;
	}
	public boolean themPhong(double gia,int soGiuong,int soNguoi,String moTa,String maLoai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0 ;
		try {
			statement = con.prepareStatement("Insert into Phong(GiaPhong,SoGiuong,SoNguoi,MoTa,MaLoai) values (?,?,?,?,?)");
			statement.setDouble(1, gia);
			statement.setInt(2, soGiuong);
			statement.setInt(3, soNguoi);
			statement.setString(4,moTa);
			statement.setString(5,maLoai);
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
		return n > 0 ;
	}
	public boolean xoaPhong(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Delete from Phong where MaPhong = ?");
			statement.setString(1, maPhong);
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
	public boolean suaPhong(Phong p) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Update Phong set GiaPhong = ?,SoGiuong = ?,SoNguoi = ?,MoTa = ? ,MaLoai = ? where MaPhong = ?");
			statement.setDouble(1, p.getGiaPhong());
			statement.setInt(2, p.getSoGiuong());
			statement.setInt(3, p.getSoNguoi());
			statement.setString(4, p.getMoTa());
			statement.setString(5, p.getLoaiPhong().getMaLoai());
			statement.setString(6, p.getMaPhong());
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
	public Phong timPhongTheoMaPhong(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select * from Phong where MaPhong = ?");
			statement.setString(1, maPhong);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				double gia = rs.getDouble(2);
				int soGiuong = rs.getInt(3);
				int soNguoi= rs.getInt(4);
				String moTa = rs.getString(5);
				String maLoai = rs.getString(6);
				LoaiPhong loaiPhong = new LoaiPhong(maLoai);
				return new Phong(maPhong, gia, soGiuong,soNguoi, moTa, loaiPhong);
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
	public ArrayList<Phong> timPhongTheoTatCa(String ma,String gia ,String soGiuong,String soNguoi,String moTa,String tenLoai){
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select p.MaPhong,GiaPhong,SoGiuong,SoNguoi,MoTa,p.MaLoai from Phong p join LoaiPhong lp on p.MaLoai=lp.MaLoai\r\n" + 
					"where p.MaPhong like N'%"+ma+"%' and GiaPhong like N'%"+gia+"%' and SoGiuong like N'%"+soGiuong+"%' and \r\n" + 
					"SoNguoi like N'%"+soNguoi+"%' and MoTa like N'%"+moTa+"%' and TenLoai like N'%"+tenLoai+"%'");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maP = rs.getString(1);
				double giaPhong = rs.getDouble(2);
				int	sGiuong = rs.getInt(3);
				int sNguoi = rs.getInt(4);
				String mTa = rs.getString(5);
				String maLoai = rs.getString(6);
				LoaiPhong lp = new LoaiPhong(maLoai);
				Phong p = new Phong(maP, giaPhong, sGiuong,sNguoi, mTa, lp);
				dsPhong.add(p);
			}
			return dsPhong;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return null;
	}
	public int tongSoPhong() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select COUNT(*) as TongSoPhong from Phong");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String tongSoPhong = rs.getString(1);
				return Integer.parseInt(tongSoPhong);
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
		return 0;
	}
	public ArrayList<Phong> layTatCaCacPhongGomTinhTrang(){
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(""
//					+ "select p.*,case when ctp.TinhTrang is null then 0\r\n" + 
//					"else ctp.TinhTrang end as TinhTrang from Phong as p left join(\r\n" + 
//					"select distinct ct_pdp.MaPhong, case\r\n" + 
//					"when ct_pdp.maPhieu is null then 0 \r\n" + 
//					"when ct_pdp.ngayDi = getdate() then 2\r\n" + 
//					"when ct_pdp.NgayDen<= GETDATE() and ct_pdp.NgayDi > GETDATE() then 1\r\n" + 
//					"--when ct_pdp.NgayDen > GETDATE() then 3\r\n" + 
//					"else 3\r\n" + 
//					"end as TinhTrang\r\n" + 
//					"from  CT_PhieuDatPhong as ct_pdp right join Phong as p on ct_pdp.MaPhong = p.MaPhong\r\n" + 
//					"where ((ct_pdp.NgayDen <= GETDATE() and ct_pdp.NgayDi  >= GETDATE()))\r\n" + 
//					"--where ((ct_pdp.NgayDi >= getdate()))\r\n" + 
//					")as ctp on p.MaPhong = ctp.MaPhong"
					
					
					
					+ "select p.*,case when ctp.TinhTrang is null then 0\r\n" + 
					"else ctp.TinhTrang end as TinhTrang from Phong as p left join(\r\n" + 
					"					select distinct ct_pdp.MaPhong, case\r\n" + 
					"					when ct_pdp.NgayDen > GETDATE() then 3\r\n" + 
					"					--when ct_pdp.NgayDi = GETDATE() then 2 \r\n" + 
					"					when ct_pdp.NgayDen<= GETDATE() and ct_pdp.NgayDi >GETDATE() then 1\r\n" + 
					"					else 2\r\n" + 
					"					end as TinhTrang\r\n" + 
					"					from  CT_PhieuDatPhong as ct_pdp right join Phong as p on ct_pdp.MaPhong = p.MaPhong\r\n" + 
					"					where (ct_pdp.NgayDi >= GETDATE()-1)\r\n" + 
					"					)as ctp on p.MaPhong = ctp.MaPhong where ctp.TinhTrang is null "
					);
			
			
					
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				double gia = rs.getDouble(2);
				int soGiuong = rs.getInt(3);
				int soNguoi = rs.getInt(4);
				String moTa = rs.getString(5);
				String maLoai = rs.getString(6);
				String tinhTrang = rs.getString(7);
				LoaiPhong lp = new LoaiPhong(maLoai);
				Phong phong =  new Phong(ma, gia, soGiuong, soNguoi,moTa, lp, Integer.parseInt(tinhTrang));
				dsPhong.add(phong);
			}
			return dsPhong;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public ArrayList<Phong> layTatCaCacPhongGomTinhTrangChuyen(){
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("select p.*,case when ctp.TinhTrang is null then 0\r\n" + 
					"					else ctp.TinhTrang end as TinhTrang from Phong as p left join(\r\n" + 
					"					select distinct ct_pdp.MaPhong, case\r\n" + 
					"					when ct_pdp.NgayDen > GETDATE() then 3\r\n" + 
					"					--when ct_pdp.NgayDi = GETDATE() then 2 \r\n" + 
					"					when ct_pdp.NgayDen<= GETDATE() and ct_pdp.NgayDi >GETDATE() then 1\r\n" + 
					"					else 2\r\n" + 
					"					end as TinhTrang\r\n" + 
					"					from  CT_PhieuDatPhong as ct_pdp right join Phong as p on ct_pdp.MaPhong = p.MaPhong\r\n" + 
					"					where (ct_pdp.NgayDi >= GETDATE()-1)\r\n" + 
					"					)as ctp on p.MaPhong = ctp.MaPhong where ctp.TinhTrang != 0");
			
			
//					+ "select p.*,case when ctp.TinhTrang is null then 0\r\n" + 
//					"					else ctp.TinhTrang end as TinhTrang from Phong as p left join(\r\n" + 
//					"						select distinct ct_pdp.MaPhong, case\r\n" + 
					
//					"						when ct_pdp.maPhieu is null then 0 \r\n" + 


//					"						when ct_pdp.ngayDi = ? then 2 \r\n" + //den han tra
//					" 						when ct_pdp.NgayDen > ? then 3   \r\n"+//da dat 
//					"						else 1"+ //dang su dung
//					"						end as TinhTrang\r\n" + 
//					"						from  CT_PhieuDatPhong as ct_pdp right join Phong as p on ct_pdp.MaPhong = p.MaPhong\r\n" + 
					
					
//					"						where ((ct_pdp.NgayDen <= ? and ct_pdp.NgayDi  >= ?))\r\n" +
					
//					"						where ((ct_pdp.NgayDi >= ?))\r\n" + 
//					"					)as ctp on p.MaPhong = ctp.MaPhong where TinhTrang != 0");
			
			
//			statement.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
//			statement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
//			statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				double gia = rs.getDouble(2);
				int soGiuong = rs.getInt(3);
				int soNguoi = rs.getInt(4);
				String moTa = rs.getString(5);
				String maLoai = rs.getString(6);
				String tinhTrang = rs.getString(7);
				LoaiPhong lp = new LoaiPhong(maLoai);
				Phong phong =  new Phong(ma, gia, soGiuong, soNguoi,moTa, lp, Integer.parseInt(tinhTrang));
				dsPhong.add(phong);
			}
			return dsPhong;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public ArrayList<Phong> timPhongTheoTatCaGomTinhTrang(String maPhong,String giaPhong,String soGiuong,String soNguoi,String moTa,String tenLoai){
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select p.*,case when ctp.TinhTrang is null then 0\r\n" + 
					"else ctp.TinhTrang end as TinhTrang from Phong as p left join(\r\n" + 
					"select distinct pdp.MaPhong, case\r\n" + 
//					"when pdp.maPhieu is null then 0\r\n" + 
					"when pdp.ngayDi = ? then 2\r\n" + 
					" when pdp.NgayDen > ? then 3   \r\n"+//da dat 
					"else 1\r\n" + 
					"end as TinhTrang\r\n" + 
					"from  CT_PhieuDatPhong as pdp right join Phong as p on pdp.MaPhong = p.MaPhong\r\n" + 
					"join LoaiPhong as lp on lp.MaLoai = p.MaLoai\r\n" + 
					"where ( (pdp.NgayDi  >= ?))\r\n" + //pdp.NgayDen <= ? and 
					")as ctp on p.MaPhong = ctp.MaPhong join LoaiPhong as lp on lp.MaLoai = p.MaLoai where \r\n" + 
					"p.MaPhong like N'%"+maPhong+"%' and p.GiaPhong like N'%"+giaPhong+"%' and p.SoGiuong like N'%"+soGiuong+"%' and p.SoNguoi like N'%"+soNguoi+"%'\r\n" + 
					" and p.MoTa like N'%"+moTa+"%' and lp.TenLoai like N'%"+tenLoai+"%' and ctp.TinhTrang is null";
			statement = con.prepareStatement(sql);
			statement.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
			statement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
			statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				double gia = rs.getDouble(2);
				int soG = rs.getInt(3);
				int soN = rs.getInt(4);
				String mTa = rs.getString(5);
				String maLoai = rs.getString(6);
				String tinhTrang = rs.getString(7);
				LoaiPhong lp = new LoaiPhong(maLoai);
				Phong phong =  new Phong(ma, gia, soG, soN,mTa, lp, Integer.parseInt(tinhTrang));
				dsPhong.add(phong);
			}
			return dsPhong;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return null;
	}
	public ArrayList<Phong> timPhongTheoTatCaGomTinhTrangChuyen(String maPhong,String giaPhong,String soGiuong,String soNguoi,String moTa,String tenLoai){
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select p.*,case when ctp.TinhTrang is null then 0\r\n" + 
					"else ctp.TinhTrang end as TinhTrang from Phong as p left join(\r\n" + 
					"select distinct pdp.MaPhong, case\r\n" + 
//					"when pdp.maPhieu is null then 0\r\n" + 
					"when pdp.ngayDi = ? then 2\r\n" + 
					"when pdp.NgayDen > ? then 3   \r\n"+//da dat 
					"else 1\r\n" + 
					"end as TinhTrang\r\n" + 
					"from  CT_PhieuDatPhong as pdp right join Phong as p on pdp.MaPhong = p.MaPhong\r\n" + 
					"join LoaiPhong as lp on lp.MaLoai = p.MaLoai\r\n" + 
					"where ( (pdp.NgayDi  >= ?))\r\n" + 
					")as ctp on p.MaPhong = ctp.MaPhong join LoaiPhong as lp on lp.MaLoai = p.MaLoai where TinhTrang != 0 and \r\n" + 
					"p.MaPhong like N'%"+maPhong+"%' and p.GiaPhong like N'%"+giaPhong+"%' and p.SoGiuong like N'%"+soGiuong+"%' and p.SoNguoi like N'%"+soNguoi+"%'\r\n" + 
					" and p.MoTa like N'%"+moTa+"%' and lp.TenLoai like N'%"+tenLoai+"%'";
			statement = con.prepareStatement(sql);
			statement.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
			statement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
			statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				double gia = rs.getDouble(2);
				int soG = rs.getInt(3);
				int soN = rs.getInt(4);
				String mTa = rs.getString(5);
				String maLoai = rs.getString(6);
				String tinhTrang = rs.getString(7);
				LoaiPhong lp = new LoaiPhong(maLoai);
				Phong phong =  new Phong(ma, gia, soG, soN,mTa, lp, Integer.parseInt(tinhTrang));
				dsPhong.add(phong);
			}
			return dsPhong;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return null;
	}
	public ArrayList<Phong> timPhongTheoTatCaGomTinhTrangHuy(String maPhong,String giaPhong,String soGiuong,String soNguoi,String moTa,String tenLoai){
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select p.*,case when ctp.TinhTrang is null then 0\r\n" + 
					"else ctp.TinhTrang end as TinhTrang from Phong as p left join(\r\n" + 
					"select distinct pdp.MaPhong, case\r\n" + 
//					"when pdp.maPhieu is null then 0\r\n" + 
					"when pdp.ngayDi = ? then 2\r\n" + 
					"when pdp.NgayDen > ? then 3   \r\n"+//da dat 
					"else 1\r\n" + 
					"end as TinhTrang\r\n" + 
					"from  CT_PhieuDatPhong as pdp right join Phong as p on pdp.MaPhong = p.MaPhong\r\n" + 
					"join LoaiPhong as lp on lp.MaLoai = p.MaLoai\r\n" + 
					"where ( (pdp.NgayDi  >= ?))\r\n" + 
					")as ctp on p.MaPhong = ctp.MaPhong join LoaiPhong as lp on lp.MaLoai = p.MaLoai where TinhTrang != 0 and \r\n" + 
					"p.MaPhong like N'%"+maPhong+"%' and p.GiaPhong like N'%"+giaPhong+"%' and p.SoGiuong like N'%"+soGiuong+"%' and p.SoNguoi like N'%"+soNguoi+"%'\r\n" + 
					" and p.MoTa like N'%"+moTa+"%' and lp.TenLoai like N'%"+tenLoai+"%' and Tinhtrang = 3 ";
			statement = con.prepareStatement(sql);
			statement.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
			statement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
			statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				double gia = rs.getDouble(2);
				int soG = rs.getInt(3);
				int soN = rs.getInt(4);
				String mTa = rs.getString(5);
				String maLoai = rs.getString(6);
				String tinhTrang = rs.getString(7);
				LoaiPhong lp = new LoaiPhong(maLoai);
				Phong phong =  new Phong(ma, gia, soG, soN,mTa, lp, Integer.parseInt(tinhTrang));
				dsPhong.add(phong);
			}
			return dsPhong;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return null;
	}
	public ArrayList<Phong> layDanhSachPhongTheoMaPhieuDatPhong(String maPDP){
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("Select p.*\r\n" + 
					"from PhieuDatPhong as pdp join CT_PhieuDatPhong ct_pdp on pdp.MaPhieu=ct_pdp.MaPhieu\r\n" + 
					"						join Phong as p on ct_pdp.MaPhong = p.MaPhong\r\n" + 
					"where pdp.MaPhieu = ?");
			statement.setString(1, maPDP);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maPhong = rs.getString(1);
				double gia = rs.getDouble(2);
				int soGiuong = rs.getInt(3);
				int soNguoi  = rs.getInt(4);
				String moTa = rs.getString(5);
				String maLoai = rs.getString(6);
				LoaiPhong lp = new LoaiPhong(maLoai);
				Phong phong = new Phong(maPhong, gia, soGiuong, soNguoi, moTa, lp);
				dsPhong.add(phong);
			}
			return dsPhong;
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
	public ArrayList<Phong> layDanhSachPhongTheoTinhTrang(String tinhTrang){
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		String tim= "";
		if(tinhTrang.equals("Chưa đặt"))
			tim = "is null";
		else if(tinhTrang.equals("Đã đặt"))
			tim = " = 3";
		else if(tinhTrang.equals("Đang sử dụng"))
			tim = " = 1";
		else 
			tim = " = 2";
		try {
			statement = con.prepareStatement("select p.*,case when ctp.TinhTrang is null then 0\r\n" + 
					"else ctp.TinhTrang end as TinhTrang from Phong as p left join(\r\n" + 
					"					select distinct ct_pdp.MaPhong, case\r\n" + 
					"					when ct_pdp.NgayDen > GETDATE() then 3"+
										"when ct_pdp.NgayDen<= GETDATE() and ct_pdp.NgayDi >GETDATE() then 1 else 2"+
					"					end as TinhTrang\r\n" + 
					"					from  CT_PhieuDatPhong as ct_pdp right join Phong as p on ct_pdp.MaPhong = p.MaPhong\r\n" + 
					"					where (ct_pdp.NgayDi >= GETDATE()-1)\r\n" + 
					"					)as ctp on p.MaPhong = ctp.MaPhong where TinhTrang " +tim);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				double gia = rs.getDouble(2);
				int soG = rs.getInt(3);
				int soN = rs.getInt(4);
				String mTa = rs.getString(5);
				String maLoai = rs.getString(6);
				String tT = rs.getString(7);
				LoaiPhong lp = new LoaiPhong(maLoai);
				Phong phong =  new Phong(ma, gia, soG, soN,mTa, lp, Integer.parseInt(tT));
				dsPhong.add(phong);
			}
			return dsPhong;
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
	public boolean themLoaiPhong(String tenLoai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Insert into LoaiPhong (TenLoai) values(?)");
			statement.setString(1, tenLoai);
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
		return n> 0;
	}
	public ArrayList<LoaiPhong> timLoaiPhongTheoTen(String tenLoai){
		ArrayList<LoaiPhong> dsLoaiPhong = new ArrayList<LoaiPhong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement =null;
		try {
			statement = con.prepareStatement("Select * from LoaiPhong where TenLoai like N'%"+tenLoai+"%'");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				LoaiPhong lp = new LoaiPhong(ma, ten);
				dsLoaiPhong.add(lp);
			}
			return dsLoaiPhong;
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
	public boolean xoaLoaiPhong(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0 ;
		try {
			statement = con.prepareStatement("Delete from LoaiPhong where MaLoai = ?");
			statement.setString(1, ma);
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
	public boolean suaLoaiPhong(LoaiPhong lp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Update LoaiPhong set TenLoai = ? where MaLoai = ?");
			statement.setString(1, lp.getTenLoai());
			statement.setString(2, lp.getMaLoai());
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
	public ArrayList<Phong> timPhongTheoTatCaGomTinhTrangTra(String maPhong,String giaPhong,String soGiuong,String soNguoi,String moTa,String tenLoai){
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select p.*,case when ctp.TinhTrang is null then 0\r\n" + 
					"else ctp.TinhTrang end as TinhTrang from Phong as p left join(\r\n" + 
					"select distinct pdp.MaPhong, case\r\n" + 
//					"when pdp.maPhieu is null then 0\r\n" + 
					"when pdp.ngayDi = ? then 2\r\n" + 
					"when pdp.NgayDen > ? then 3   \r\n"+//da dat 
					"else 1\r\n" + 
					"end as TinhTrang\r\n" + 
					"from  CT_PhieuDatPhong as pdp right join Phong as p on pdp.MaPhong = p.MaPhong\r\n" + 
					"join LoaiPhong as lp on lp.MaLoai = p.MaLoai\r\n" + 
					"where ( (pdp.NgayDi  >= ?))\r\n" + 
					")as ctp on p.MaPhong = ctp.MaPhong join LoaiPhong as lp on lp.MaLoai = p.MaLoai where TinhTrang != 0 and \r\n" + 
					"p.MaPhong like N'%"+maPhong+"%' and p.GiaPhong like N'%"+giaPhong+"%' and p.SoGiuong like N'%"+soGiuong+"%' and p.SoNguoi like N'%"+soNguoi+"%'\r\n" + 
					" and p.MoTa like N'%"+moTa+"%' and lp.TenLoai like N'%"+tenLoai+"%' and TinhTrang != 3";
			statement = con.prepareStatement(sql);
			statement.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
			statement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
			statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				double gia = rs.getDouble(2);
				int soG = rs.getInt(3);
				int soN = rs.getInt(4);
				String mTa = rs.getString(5);
				String maLoai = rs.getString(6);
				String tinhTrang = rs.getString(7);
				LoaiPhong lp = new LoaiPhong(maLoai);
				Phong phong =  new Phong(ma, gia, soG, soN,mTa, lp, Integer.parseInt(tinhTrang));
				dsPhong.add(phong);
			}
			return dsPhong;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return null;
	}
	public ArrayList<Phong> layTatCaCacPhongGomTinhTrangTra(){
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("select p.*,case when ctp.TinhTrang is null then 0\r\n" + 
					"					else ctp.TinhTrang end as TinhTrang from Phong as p left join(\r\n" + 
					"					select distinct ct_pdp.MaPhong, case\r\n" + 
					"					when ct_pdp.NgayDen > GETDATE() then 3\r\n" + 
					"					--when ct_pdp.NgayDi = GETDATE() then 2 \r\n" + 
					"					when ct_pdp.NgayDen<= GETDATE() and ct_pdp.NgayDi >GETDATE() then 1\r\n" + 
					"					else 2\r\n" + 
					"					end as TinhTrang\r\n" + 
					"					from  CT_PhieuDatPhong as ct_pdp right join Phong as p on ct_pdp.MaPhong = p.MaPhong\r\n" + 
					"					where (ct_pdp.NgayDi >= GETDATE()-1)\r\n" + 
					"					)as ctp on p.MaPhong = ctp.MaPhong where ctp.TinhTrang != 0 and ctp.TinhTrang != 3");
			
			
//					+ "select p.*,case when ctp.TinhTrang is null then 0\r\n" + 
//					"					else ctp.TinhTrang end as TinhTrang from Phong as p left join(\r\n" + 
//					"						select distinct ct_pdp.MaPhong, case\r\n" + 
					
//					"						when ct_pdp.maPhieu is null then 0 \r\n" + 


//					"						when ct_pdp.ngayDi = ? then 2 \r\n" + //den han tra
//					" 						when ct_pdp.NgayDen > ? then 3   \r\n"+//da dat 
//					"						else 1"+ //dang su dung
//					"						end as TinhTrang\r\n" + 
//					"						from  CT_PhieuDatPhong as ct_pdp right join Phong as p on ct_pdp.MaPhong = p.MaPhong\r\n" + 
					
					
//					"						where ((ct_pdp.NgayDen <= ? and ct_pdp.NgayDi  >= ?))\r\n" +
					
//					"						where ((ct_pdp.NgayDi >= ?))\r\n" + 
//					"					)as ctp on p.MaPhong = ctp.MaPhong where TinhTrang != 0");
			
			
//			statement.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
//			statement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
//			statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				double gia = rs.getDouble(2);
				int soGiuong = rs.getInt(3);
				int soNguoi = rs.getInt(4);
				String moTa = rs.getString(5);
				String maLoai = rs.getString(6);
				String tinhTrang = rs.getString(7);
				LoaiPhong lp = new LoaiPhong(maLoai);
				Phong phong =  new Phong(ma, gia, soGiuong, soNguoi,moTa, lp, Integer.parseInt(tinhTrang));
				dsPhong.add(phong);
			}
			return dsPhong;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
