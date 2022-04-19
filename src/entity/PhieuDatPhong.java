package entity;

import java.util.Date;

public class PhieuDatPhong {
	private int maPhieuDatPhong;
	private int tinhTrangPhieu;
	private Date ngayLapPhieu;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	
	
	public PhieuDatPhong(int maPhieuDatPhong, int tinhTrangPhieu, Date ngayLapPhieu, NhanVien nhanVien,
			KhachHang khachHang) {
		super();
		this.maPhieuDatPhong = maPhieuDatPhong;
		this.tinhTrangPhieu = tinhTrangPhieu;
		this.ngayLapPhieu = ngayLapPhieu;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}
	public PhieuDatPhong(int maPhieuDatPhong, Date ngayLapPhieu, NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.maPhieuDatPhong = maPhieuDatPhong;
		this.ngayLapPhieu = ngayLapPhieu;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}
	public PhieuDatPhong() {
		super();
	}
	public PhieuDatPhong(int maPhieuDatPhong) {
		super();
		this.maPhieuDatPhong = maPhieuDatPhong;
	}
	public int getMaPhieuDatPhong() {
		return maPhieuDatPhong;
	}
	public void setMaPhieuDatPhong(int maPhieuDatPhong) {
		this.maPhieuDatPhong = maPhieuDatPhong;
	}
	public Date getNgayLapPhieu() {
		return ngayLapPhieu;
	}
	public void setNgayLapPhieu(Date ngayLapPhieu) {
		this.ngayLapPhieu = ngayLapPhieu;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	
	public int getTinhTrangPhieu() {
		return tinhTrangPhieu;
	}
	public void setTinhTrangPhieu(int tinhTrangPhieu) {
		this.tinhTrangPhieu = tinhTrangPhieu;
	}

	@Override
	public String toString() {
		return "PhieuDatPhong [maPhieuDatPhong=" + maPhieuDatPhong + ", tinhTrangPhieu=" + tinhTrangPhieu
				+ ", ngayLapPhieu=" + ngayLapPhieu + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maPhieuDatPhong;
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
		PhieuDatPhong other = (PhieuDatPhong) obj;
		if (maPhieuDatPhong != other.maPhieuDatPhong)
			return false;
		return true;
	}
	
}
