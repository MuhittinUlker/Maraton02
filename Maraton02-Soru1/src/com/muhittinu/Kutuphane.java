package com.muhittinu;

import java.util.ArrayList;
import java.util.List;

public class Kutuphane {

	private String ad;
	private List<Kitap> kitapListesi;
	private List<Musteri> musteriListesi;
	private List<Kitap> kiralananKitaplar;
	
	
	public Kutuphane() {
		super();
		this.musteriListesi=new ArrayList<>();
		this.kitapListesi=new ArrayList<>();
		this.kiralananKitaplar=new ArrayList<>();
	}

	public Kutuphane(String ad) {
		super();
		this.ad = ad;
		this.musteriListesi=new ArrayList<>();
		this.kitapListesi=new ArrayList<>();
		this.kiralananKitaplar=new ArrayList<>();
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public List<Kitap> getKitapListesi() {
		return kitapListesi;
	}

	public List<Musteri> getMusteriListesi() {
		return musteriListesi;
	}

	public List<Kitap> getKiralananKitaplar() {
		return kiralananKitaplar;
	}
	
}
