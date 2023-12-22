package com.muhittinu;

import java.util.UUID;

public class Kitap {

	private String ad;
	private String yazar;
	private String ISBN;
	private double fiyat;
	private EStatus status;
	
	public Kitap(String ad, String yazar, double fiyat) {
		super();
		this.ad = ad;
		this.yazar = yazar;
		this.fiyat = fiyat;
		this.ISBN = UUID.randomUUID().toString();
		this.status = EStatus.RENTABLE;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getYazar() {
		return yazar;
	}

	public void setYazar(String yazar) {
		this.yazar = yazar;
	}

	public EStatus getStatus() {
		return status;
	}

	public void setStatus(EStatus status) {
		this.status = status;
	}

	public String getISBN() {
		return ISBN;
	}

	public double getFiyat() {
		return fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	
	
}
