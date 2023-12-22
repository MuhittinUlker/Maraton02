package com.muhittinu;

import java.util.Scanner;

public class KitapIslemleri {

	static Menuler menu = new Menuler();
	static Scanner scanner = new Scanner(System.in);
	static int secim;
	static String yazi;
	static double para;

	public void kitapIslemleri() {
		while (true) {
			menu.kitapIslemlerMenusuYaz();
			secim = kullanicidanIntDegerAl("Seçiminizi girin:");
			switch (secim) {
			case 1:
				kitapEkle();
				break;
			case 2:
				kitapSil();
				break;
			case 3:
				kitapAra();
				break;
			case 4:
				kitaplariListele();
				break;
			case 0:
				menu.appMenu();
			default:
				break;
			}
		}
	}

	private void kitapEkle() {
		String ad = kullanicidanStringDegerAl("Kitap adı girin: ");
		String yazar = kullanicidanStringDegerAl("Kitap yazar adı girin: ");
		double fiyat = kullanicidanDoubleDegerAl("Kitap fiyatı girin: ");
		Kitap kitap = new Kitap(ad, yazar,fiyat);
		for (Kitap kkitap : Runner.kutuphane.getKitapListesi()) {
			if (kkitap.getISBN().equals(kitap.getISBN())) {
				System.out.println("Eklemeye çalıştığınız kitap sistemde kayıtlı.");
			}
		}
		Runner.kutuphane.getKitapListesi().add(kitap);
	}

	private void kitapSil() {
		kitaplariListele();
		boolean sildiMi = false;
		String isbn = kullanicidanStringDegerAl("Silmek istediğiniz kitabın ISBN numarasını girin: ");
		for (int i = 0; i < Runner.kutuphane.getKitapListesi().size(); i++) {
			if (Runner.kutuphane.getKitapListesi().get(i).getISBN().equals(isbn)) {
				Runner.kutuphane.getKitapListesi().remove(i);
				sildiMi = true;
				System.out.println(isbn + " ISBN'li kitap silindi..");
			}
		}
		if (!sildiMi) {
			System.out.println("Girdiğiniz ISBN numarası ile kayıtlı bir kitap yoktur.");
		}
	}

	private void kitapAra() {
		kitaplariListele();
		String isbn = kullanicidanStringDegerAl("Aradığınız kitabın ISBN numarasını girin: ");
		for (int i = 0; i < Runner.kutuphane.getKitapListesi().size(); i++) {
			if (Runner.kutuphane.getKitapListesi().get(i).getISBN().equals(isbn)) {
				System.out.println(Runner.kutuphane.getKitapListesi().get(i).getAd() + " "
						+ Runner.kutuphane.getKitapListesi().get(i).getYazar());
			} else {
				System.out.println("Girdiğiniz ISBN numarası ile kayıtlı bir kitap yoktur.");
			}
		}
	}

	public void kitaplariListele() {
		System.out.println("*****Kitap Listesi*****");
		System.out.println("KitapAdı\tKitapYazarı\tKitapISBN");
		for (Kitap kitap : Runner.kutuphane.getKitapListesi()) {
			System.out.println(kitap.getAd() + "\t" + kitap.getYazar() + "\t" + kitap.getISBN());
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
