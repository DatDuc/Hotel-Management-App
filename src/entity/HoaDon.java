package entity;

import java.util.Date;

public class HoaDon {
	private int maHoaDon;
	private Date ngayLapHoaDon;
	public HoaDon(int maHoaDon, Date ngayLapHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	public HoaDon() {
		super();
	}
	public HoaDon(int maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
	public int getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}
	public void setNgayLapHoaDon(Date ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", nhanVien="+ ", khachHang=" + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maHoaDon;
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
		HoaDon other = (HoaDon) obj;
		if (maHoaDon != other.maHoaDon)
			return false;
		return true;
	}
	
	
}
