package com.muhittinu;

public abstract class User {

	private String ad;
	private String soyad;
	private String tel;
	private String adres;
	
	
	public User() {
		super();
	}

	public User(String ad, String soyad, String tel, String adres) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.tel = tel;
		this.adres = adres;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}
	
	
}
