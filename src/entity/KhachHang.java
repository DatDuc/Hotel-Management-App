package entity;

import java.sql.Date;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private String gioiTinh;
	private String cMND;
	private String soDienThoai;
	private Date ngaySinh;
	public KhachHang() {
		super();
	}
	public KhachHang(String maKhachHang, String tenKhachHang, String gioiTinh, String cMND, String soDienThoai,
			Date ngaySinh) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.gioiTinh = gioiTinh;
		this.cMND = cMND;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
	}
	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getcMND() {
		return cMND;
	}
	public void setcMND(String cMND) {
		this.cMND = cMND;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", gioiTinh=" + gioiTinh
				+ ", cMND=" + cMND + ", soDienThoai=" + soDienThoai + ", ngaySinh=" + ngaySinh + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKhachHang == null) ? 0 : maKhachHang.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		if (maKhachHang == null) {
			if (other.maKhachHang != null)
				return false;
		} else if (!maKhachHang.equals(other.maKhachHang))
			return false;
		return true;
	}
}
