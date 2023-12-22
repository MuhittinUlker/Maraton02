package com.muhittinu;

import java.util.Random;
import java.util.UUID;
	
	
public abstract class Yolcu {
	
	static Random rnd = new Random();
	
	private String id;
	private String ad;
	private String soyad;
	private String koltukNo;
	private boolean checkIn;
	private int BASEFIYAT;
	
	public Yolcu(String ad, String soyad) {
		super();
		this.id = UUID.randomUUID().toString(); // yolcu id yolcu yaratılırken rastgele oluşturuluyor
		this.ad = ad;
		this.soyad = soyad;
		this.koltukNo = Integer.toString(rnd.nextInt(0,350)); // koltuk no yolcu yaratılırken 0-350 arasında rastgele oluşturuluyor.
		this.checkIn = false;
		this.BASEFIYAT = 100;
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	public String getKoltukNo() {
		return koltukNo;
	}

	public boolean isCheckIn() {
		return checkIn;
	}


	public void setCheckIn(boolean checkIn) {
		this.checkIn = checkIn;
	}


	public int getBASEFIYAT() {
		return BASEFIYAT;
	}


	public abstract void yolcuBilgileriniGetir();
	public abstract void biletAl(EFirmaAdi firmaAdi);
	public abstract void checkInYap();
	public abstract void ucagaBin();
	
}
