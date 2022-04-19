package entity;

public class DichVu {
	private String maDichVu;
	private String tenDichVu;
	private double gia;
	private String donVi;
	private int soLuong;
	public DichVu() {
		super();
	}
	public DichVu(String maDichVu, String tenDichVu, double gia, String donVi, int soLuong) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.gia = gia;
		this.donVi = donVi;
		this.soLuong = soLuong;
	}
	public DichVu(String maDichVu) {
		super();
		this.maDichVu = maDichVu;
	}
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", gia=" + gia + ", donVi=" + donVi
				+ ", soLuong=" + soLuong + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDichVu == null) ? 0 : maDichVu.hashCode());
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
		DichVu other = (DichVu) obj;
		if (maDichVu == null) {
			if (other.maDichVu != null)
				return false;
		} else if (!maDichVu.equals(other.maDichVu))
			return false;
		return true;
	}
	
}
