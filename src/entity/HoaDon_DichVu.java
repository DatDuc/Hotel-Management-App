package entity;

import java.sql.Date;

public class HoaDon_DichVu {
	private int maHoaDon_DV;
	private Date ngayLapHoaDon_DV;
	private Phong phong;
	private NhanVien nhanVien;
	public HoaDon_DichVu(int maHoaDon_DV, Date ngayLapHoaDon_DV, Phong phong, NhanVien nhanVien) {
		super();
		this.maHoaDon_DV = maHoaDon_DV;
		this.ngayLapHoaDon_DV = ngayLapHoaDon_DV;
		this.phong = phong;
		this.nhanVien = nhanVien;
	}
	public HoaDon_DichVu() {
		super();
	}
	public HoaDon_DichVu(int maHoaDon_DV) {
		super();
		this.maHoaDon_DV = maHoaDon_DV;
	}
	public int getMaHoaDon_DV() {
		return maHoaDon_DV;
	}
	public void setMaHoaDon_DV(int maHoaDon_DV) {
		this.maHoaDon_DV = maHoaDon_DV;
	}
	public Date getNgayLapHoaDon_DV() {
		return ngayLapHoaDon_DV;
	}
	public void setNgayLapHoaDon_DV(Date ngayLapHoaDon_DV) {
		this.ngayLapHoaDon_DV = ngayLapHoaDon_DV;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	@Override
	public String toString() {
		return "HoaDon_DichVu [maHoaDon_DV=" + maHoaDon_DV + ", ngayLapHoaDon_DV=" + ngayLapHoaDon_DV + ", phong="
				+ phong + ", nhanVien=" + nhanVien + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maHoaDon_DV;
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
		HoaDon_DichVu other = (HoaDon_DichVu) obj;
		if (maHoaDon_DV != other.maHoaDon_DV)
			return false;
		return true;
	}
	
}
