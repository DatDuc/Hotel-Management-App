package entity;

public class CT_DichVu {
	private int maCTDV;
	private DichVu dichVu;
	private HoaDon_DichVu hoaDon_DV;
	private int soLuongSuDung;
	public CT_DichVu(int maCTDV, DichVu dichVu, HoaDon_DichVu hoaDon_DV, int soLuongSuDung) {
		super();
		this.maCTDV = maCTDV;
		this.dichVu = dichVu;
		this.hoaDon_DV = hoaDon_DV;
		this.soLuongSuDung = soLuongSuDung;
	}
	public CT_DichVu() {
		super();
	}
	public CT_DichVu(int maCTDv) {
		super();
		this.maCTDV = maCTDv;
	}
	@Override
	public String toString() {
		return "CT_DichVu [maCTDv=" + maCTDV + ", dichVu=" + dichVu + ", hoaDon_DV=" + hoaDon_DV + ", soLuongSuDung="
				+ soLuongSuDung + "]";
	}
	public int getMaCTDv() {
		return maCTDV;
	}
	public void setMaCTDv(int maCTDv) {
		this.maCTDV = maCTDv;
	}
	public DichVu getDichVu() {
		return dichVu;
	}
	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}
	public HoaDon_DichVu getHoaDon_DV() {
		return hoaDon_DV;
	}
	public void setHoaDon_DV(HoaDon_DichVu hoaDon_DV) {
		this.hoaDon_DV = hoaDon_DV;
	}
	public int getSoLuongSuDung() {
		return soLuongSuDung;
	}
	public void setSoLuongSuDung(int soLuongSuDung) {
		this.soLuongSuDung = soLuongSuDung;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maCTDV;
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
		CT_DichVu other = (CT_DichVu) obj;
		if (maCTDV != other.maCTDV)
			return false;
		return true;
	}
	
}
