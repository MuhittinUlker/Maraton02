package com.muhittinu;

public class Bilet {

	private EFirmaAdi firmaAdi;
	private double biletFiyati;
	
	public Bilet(EFirmaAdi firmaAdi, double biletFiyati) {
		super();
		this.firmaAdi = firmaAdi;
		this.biletFiyati = biletFiyati;
	}

	public EFirmaAdi getFirmaAdi() {
		return firmaAdi;
	}

	public void setFirmaAdi(EFirmaAdi firmaAdi) {
		this.firmaAdi = firmaAdi;
	}

	public double getBiletFiyati() {
		return biletFiyati;
	}
	
	
	
}
