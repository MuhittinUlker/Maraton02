package com.muhittinu;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Musteri extends User{

	private String id;
	private double bakiye;
	private List<Kitap> kiralananKitaplar;
	

	public Musteri() {
		super();
		this.id = UUID.randomUUID().toString();
		this.kiralananKitaplar = new ArrayList<>();
	}

	public Musteri(String ad, String soyad, String tel, String adres, double bakiye) {
		super(ad, soyad, tel, adres);
		this.bakiye = bakiye;
		this.id = UUID.randomUUID().toString();
		this.kiralananKitaplar = new ArrayList<>();
	}

	public List<Kitap> getKiralananKitaplar() {
		return kiralananKitaplar;
	}

	public void setKiralananKitaplar(List<Kitap> kiralananKitaplar) {
		this.kiralananKitaplar = kiralananKitaplar;
	}

	public String getId() {
		return id;
	}

	public double getBakiye() {
		return bakiye;
	}

	public void setBakiye(double bakiye) {
		this.bakiye = bakiye;
	}
	
}
