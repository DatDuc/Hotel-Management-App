package entity;

import java.sql.Date;

import entity.PhieuDatPhong;
import entity.Phong;

public class CT_PhieuDatPhong {
	private int maCT_PhieuDatPhong;
	private PhieuDatPhong pdp;
	private Phong phong;
	private Date ngayDen;
	private Date ngayDi;
	public CT_PhieuDatPhong(int maCT_PhieuDatPhong, PhieuDatPhong pdp, Phong phong, Date ngayDen, Date ngayDi) {
		super();
		this.maCT_PhieuDatPhong = maCT_PhieuDatPhong;
		this.pdp = pdp;
		this.phong = phong;
		this.ngayDen = ngayDen;
		this.ngayDi = ngayDi;
	}
	public CT_PhieuDatPhong() {
		super();
	}
	public CT_PhieuDatPhong(int maCT_PhieuDatPhong) {
		super();
		this.maCT_PhieuDatPhong = maCT_PhieuDatPhong;
	}
	public int getMaCT_PhieuDatPhong() {
		return maCT_PhieuDatPhong;
	}
	public void setMaCT_PhieuDatPhong(int maCT_PhieuDatPhong) {
		this.maCT_PhieuDatPhong = maCT_PhieuDatPhong;
	}
	public PhieuDatPhong getPdp() {
		return pdp;
	}
	public void setPdp(PhieuDatPhong pdp) {
		this.pdp = pdp;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public Date getNgayDen() {
		return ngayDen;
	}
	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}
	public Date getNgayDi() {
		return ngayDi;
	}
	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}
	@Override
	public String toString() {
		return "CT_PhieuDatPhong [maCT_PhieuDatPhong=" + maCT_PhieuDatPhong + ", pdp=" + pdp + ", phong=" + phong
				+ ", ngayDen=" + ngayDen + ", ngayDi=" + ngayDi + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maCT_PhieuDatPhong;
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
		CT_PhieuDatPhong other = (CT_PhieuDatPhong) obj;
		if (maCT_PhieuDatPhong != other.maCT_PhieuDatPhong)
			return false;
		return true;
	}
	
}
