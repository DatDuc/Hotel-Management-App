package entity;

public class TaiKhoan {
	private String tenDangNhap;
	private String matKhau;
	private NhanVien nhanVien;
	public TaiKhoan() {
		super();
	}
	public TaiKhoan(String tenDangNhap, String matKhau, NhanVien nhanVien) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.nhanVien = nhanVien;
	}
	public TaiKhoan(String tenDangNhap) {
		super();
		this.tenDangNhap = tenDangNhap;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	@Override
	public String toString() {
		return "TaiKhoan [tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", nhanVien=" + nhanVien + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tenDangNhap == null) ? 0 : tenDangNhap.hashCode());
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
		TaiKhoan other = (TaiKhoan) obj;
		if (tenDangNhap == null) {
			if (other.tenDangNhap != null)
				return false;
		} else if (!tenDangNhap.equals(other.tenDangNhap))
			return false;
		return true;
	}
	
}
