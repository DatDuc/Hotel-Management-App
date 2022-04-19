package entity;

public class Phong {
	private String maPhong;
	private double giaPhong;
	private int soGiuong;
	private int soNguoi;
	private String moTa;
	private LoaiPhong loaiPhong;
	private int tinhTrangPhong;
	public Phong() {
		super();
	}
	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}
	
	public Phong(String maPhong, double giaPhong, int soGiuong, int soNguoi, String moTa, LoaiPhong loaiPhong) {
		super();
		this.maPhong = maPhong;
		this.giaPhong = giaPhong;
		this.soGiuong = soGiuong;
		this.soNguoi = soNguoi;
		this.moTa = moTa;
		this.loaiPhong = loaiPhong;
	}
	public Phong(String maPhong, double giaPhong, int soGiuong, int soNguoi, String moTa, LoaiPhong loaiPhong,
			int tinhTrangPhong) {
		super();
		this.maPhong = maPhong;
		this.giaPhong = giaPhong;
		this.soGiuong = soGiuong;
		this.soNguoi = soNguoi;
		this.moTa = moTa;
		this.loaiPhong = loaiPhong;
		this.tinhTrangPhong = tinhTrangPhong;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public int getTinhTrangPhong() {
		return tinhTrangPhong;
	}
	public void setTinhTrangPhong(int tinhTrangPhong) {
		this.tinhTrangPhong = tinhTrangPhong;
	}
	public double getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(double giaPhong) {
		this.giaPhong = giaPhong;
	}
	public int getSoGiuong() {
		return soGiuong;
	}
	public int getSoNguoi() {
		return soNguoi;
	}
	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}
	public void setSoGiuong(int soGiuong) {
		this.soGiuong = soGiuong;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	
	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", giaPhong=" + giaPhong + ", soGiuong=" + soGiuong + ", soNguoi="
				+ soNguoi + ", moTa=" + moTa + ", loaiPhong=" + loaiPhong + ", tinhTrangPhong=" + tinhTrangPhong + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhong == null) ? 0 : maPhong.hashCode());
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
		Phong other = (Phong) obj;
		if (maPhong == null) {
			if (other.maPhong != null)
				return false;
		} else if (!maPhong.equals(other.maPhong))
			return false;
		return true;
	}
	
}
