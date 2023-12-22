package com.muhittinu;

import java.util.Scanner;

public class KutuphaneIslemleri {

	static KitapIslemleri kitapIslemci = new KitapIslemleri();
	static Menuler menu = new Menuler();
	static Scanner scanner = new Scanner(System.in);
	static int secim;
	static String yazi;

	public void kiralamaIslemleri() {

		while (true) {
			menu.kiralamaIslemlerMenusuYaz();
			secim = kullanicidanIntDegerAl("Seçiminizi girin:");

			switch (secim) {
			case 1:
				kiralamaYap();
				break;
			case 2:
				teslimEt();
				break;
			case 3:
				kiradakiKitaplariListele();
				break;
			case 0:
				menu.appMenu();
				break;
			default:
				break;
			}
		}
	}

	private void kiralamaYap() {
		System.out.println("Müşteri Adı\tMüşteri ID");
		for (Musteri musteri : Runner.kutuphane.getMusteriListesi()) {
			System.out.println(musteri.getAd() + "\t\t" + musteri.getId());
		}
		String id = kullanicidanStringDegerAl("Kiralama yapacak müşteri ID'sini girin: ");
		Musteri musteri = musteriKim(id);
		if (musteri != null) {
			kiradaOlmayanlariListele();
			boolean kiralandiMi = false;
			String isbn = kullanicidanStringDegerAl("Kiralamak istediğiniz kitabın ISBN numarasını girin: ");
			for (Kitap kitap : Runner.kutuphane.getKitapListesi()) {
				if (kitap.getISBN().equals(isbn)) {
					if (kitap.getStatus().name().equals(EStatus.RENTABLE.name())) {
						if (musteri.getBakiye() >= kitap.getFiyat()) {
							musteri.setBakiye(musteri.getBakiye() - kitap.getFiyat());
							Runner.kutuphane.getKiralananKitaplar().add(kitap);
							kitap.setStatus(EStatus.INRENT);
							kiralandiMi = true;
							System.out.println(
									musteri.getAd() + " " + kitap.getAd() + " isimli kitabı başarı ile kiraladı.");
						} else {
							System.out.println(kitap.getAd() + " adlı kitabı kiralamak için bakiyeniz yetersiz..\n"
									+ (kitap.getFiyat() - musteri.getBakiye())
									+ " TL eksiğiniz var.\nKiralama yapmak için lütfen bakiye yükleyin..");
							return;
						}
					} else {
						System.out.println("Kiralamak istediğiniz kitap farklı bir müşterimizde kirada.");
						return;
					}
				}
			}
			if (!kiralandiMi) {
				System.out.println("Kiralamak istediğiniz kitap kütüphanemizde bulunamadı..");
			}
		} else {
			System.out.println("Böyle bir müşteri bulunamadı.");
		}

	}

	private void teslimEt() {
		boolean teslimMi = false;
		System.out.println("Müşteri Adı\tMüşteri ID");
		for (Musteri musteri : Runner.kutuphane.getMusteriListesi()) {
			System.out.println(musteri.getAd() + "\t\t" + musteri.getId());
		}
		String id = kullanicidanStringDegerAl("Teslim yapacak müşteri ID'sini girin: ");
		Musteri musteri = musteriKim(id);
		if (musteri != null) {
			kiradakiKitaplariListele();
			String isbn = kullanicidanStringDegerAl("Teslim edeceğiniz kitap ISBN'ini girin: ");
			for (Kitap kitap : Runner.kutuphane.getKitapListesi()) {
				if (kitap.getISBN().equals(isbn)) {
					kitap.setStatus(EStatus.RENTABLE);
					musteri.getKiralananKitaplar().remove(kitap);
					Runner.kutuphane.getKiralananKitaplar().remove(kitap);
					System.out.println("Kitabı teslim ettiniz. Teşekkürler..");
					teslimMi = true;
				}
			}
			if (!teslimMi) {
				System.out.println("Teslim etmek istediğiniz kitap sizin adınıza kayıtlı değil..");
			}
		} else {
			System.out.println("Böyle bir müşteri bulunamadı.");
		}
	}

	private void kiradaOlmayanlariListele() {
		boolean kiralanacakMi = false;
		System.out.println("***** Kiralanabilecek Kitaplar *****");
		System.out.println("KitapAdı\tKitapFiyatı\tKitapISBN");
		for (Kitap kitap : Runner.kutuphane.getKitapListesi()) {
			if (kitap.getStatus().name().equals(EStatus.RENTABLE.name())) {
				System.out.println(kitap.getAd() + "\t" + kitap.getFiyat() + "\t\t" + kitap.getISBN());
				kiralanacakMi = true;
			}
		}
		if (!kiralanacakMi) {
			System.out.println("Kiralanabilecek kitabımız kalmamıştır.");
		}
	}

	private void kiradakiKitaplariListele() {
		System.out.println("*****Kiradaki kitaplar*****");
		System.out.println("KitapAdı\tKitapYazarı\tKitapISBN");
		boolean kiradaVarMı = false;
		for (Kitap kitap : Runner.kutuphane.getKiralananKitaplar()) {
			System.out.println(kitap.getAd() + "\t" + kitap.getYazar() + "\t" + kitap.getISBN());
			kiradaVarMı = true;
		}
		if (!kiradaVarMı) {
			System.out.println("Kirada hiç kitap yok.");
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

	private Musteri musteriKim(String string) {
		for (Musteri musteri : Runner.kutuphane.getMusteriListesi()) {
			if (musteri.getId().equals(string)) {
				return musteri;
			}
		}
		return null;
	}
}
