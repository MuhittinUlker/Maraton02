package com.muhittinu;

import java.util.Scanner;

public class MusteriIslemleri {
	static Menuler menu = new Menuler();
	static Scanner scanner = new Scanner(System.in);
	static int secim;
	static String yazi;
	static double para;

	public void musteriIslemleri() {
		while (true) {
			menu.musteriIslemlerMenusuYaz();
			secim = kullanicidanIntDegerAl("Seçiminizi girin:");
			switch (secim) {
			case 1:
				musteriEkle();
				break;
			case 2:
				musteriSil();
				break;
			case 3:
				musteriAra();
				break;
			case 4:
				musterileriListele();
				break;
			case 0:
				menu.appMenu();
				break;
			default:
				break;
			}
		}
	}
	
	private void musteriEkle() {
		String ad = kullanicidanStringDegerAl("Müşteri Adı girin: ");
		String soyad = kullanicidanStringDegerAl("Müşteri Soyadı girin: ");
		String tel = kullanicidanStringDegerAl("Müşteri Tel girin: ");
		String adres = kullanicidanStringDegerAl("Müşteri Adresi girin: ");
		double bakiye = kullanicidanDoubleDegerAl("Bakiye yükleyin: ");
		Musteri musteri = new Musteri(ad, soyad, tel, adres, bakiye);
		Runner.kutuphane.getMusteriListesi().add(musteri);
		System.out.println(ad+" adlı müşteri başarıyla eklendi.");
	}
	
	private void musteriSil() {
		musterileriListele();
		String id = kullanicidanStringDegerAl("Silmek istediğiniz müşteri ID'sini girin: ");
		boolean silindiMi = false;
		for (Musteri musteri : Runner.kutuphane.getMusteriListesi()) {
			if (musteri.getId().equals(id)) {
				System.out.println(id+" ID'li müşteri sistemden silindi.");
				Runner.kutuphane.getMusteriListesi().remove(musteri);
				silindiMi=true;
			}
		}
		if (!silindiMi) {
			System.out.println("Silmek istediğiniz müşteri sistemde kayıtlı değil..");
		}
	}
	
	private void musterileriListele() {
		System.out.println("Müşteri Adı-Soyadı\tMüşteri Tel\tMüşteri Adres\tMüşteri ID");
		for (Musteri musteri : Runner.kutuphane.getMusteriListesi()) {
			System.out.println(musteri.getAd()+" "+musteri.getSoyad()+"\t\t"+musteri.getTel()+"\t\t"+musteri.getAdres()+"\t\t"+musteri.getId());
		}
	}
	
	
	private void musteriAra() {
		musterileriListele();
		String id = kullanicidanStringDegerAl("Bulmak istediğiniz müşteri ID'sini girin: ");
		boolean bulunduMu = false;
		for (Musteri musteri : Runner.kutuphane.getMusteriListesi()) {
			if (musteri.getId().equals(id)) {
				System.out.println("MüşteriAdı-Soyadı\tMüşteri Tel\tMüşteri Adres");
				System.out.println(musteri.getAd()+" "+musteri.getSoyad()+"\t\t"+musteri.getTel()+"\t\t"+musteri.getAdres());
				bulunduMu=true;
			}
		}
		if (!bulunduMu) {
			System.out.println("Aradığınız müşteri sistemde kayıtlı değil..");
		}
	}
	
	private String kullanicidanStringDegerAl(String string) {
		System.out.println(string);
		yazi = scanner.nextLine();
		return yazi;
	}

	private int kullanicidanIntDegerAl(String string) {
		System.out.println(string);
		secim = scanner.nextInt();
		scanner.nextLine();
		return secim;
	}
	private double kullanicidanDoubleDegerAl(String string) {
		System.out.println(string);
		para = scanner.nextDouble();
		return para;
	}

}
