package com.muhittinu;

import java.util.Scanner;

public class Menuler {
	
	static Scanner scanner = new Scanner(System.in);
	static int secim;
	static KitapIslemleri kitapIslemci = new KitapIslemleri();
	static MusteriIslemleri musteriIslemci = new MusteriIslemleri();
	static KutuphaneIslemleri kutuphaneIslemci = new KutuphaneIslemleri();
	
	public void appMenu() {
		while (true) {
			islemlerMenusuYaz();
			System.out.println("Seçiminizi girin:");
			secim = kullanicidanIntDegerAl();
						
			switch (secim) {
			
			case 1:
				
				kitapIslemci.kitapIslemleri();
				
				break;
			case 2:
				
				musteriIslemci.musteriIslemleri();
				
				break;
			case 3:
				
				kutuphaneIslemci.kiralamaIslemleri();
				
				break;
			case 0:
				
				System.out.println("Sistemden çıkış yapıldı.");
				System.exit(0);
				
				break;
			default:
				break;
			}
		}
		
	}
	
	public void islemlerMenusuYaz() {
		System.out.println(" _________________________");
		System.out.println("|                         |");
		System.out.println("| 1- Kitap İşlemleri      |");
		System.out.println("| 2- Müşteri İşlemleri    |");
		System.out.println("| 3- Kiralama İşlemleri   |");
		System.out.println("| 0- Çıkış                |");
		System.out.println("|_________________________|");
	}
	
	public void kitapIslemlerMenusuYaz() {
		System.out.println(" _________________________");
		System.out.println("|                         |");
		System.out.println("| 1- Kitap Ekle           |");
		System.out.println("| 2- Kitap Sil            |");
		System.out.println("| 3- Kitap Ara (id ile)   |");
		System.out.println("| 4- Kitapları Listele    |");
		System.out.println("| 0- Üst Menü             |");
		System.out.println("|_________________________|");
	}
	
	public void musteriIslemlerMenusuYaz() {
		System.out.println(" _________________________");
		System.out.println("|                         |");
		System.out.println("| 1- Müşteri Ekle         |");
		System.out.println("| 2- Müşteri Sil          |");
		System.out.println("| 3- Müşteri Ara (id ile) |");
		System.out.println("| 4- Müşterileri Listele  |");
		System.out.println("| 0- Üst Menü             |");
		System.out.println("|_________________________|");
	}
	
	public void kiralamaIslemlerMenusuYaz() {
		System.out.println(" _________________________");
		System.out.println("|                         |");
		System.out.println("| 1- Kiralama Yap         |");
		System.out.println("| 2- Teslim Et            |");
		System.out.println("| 3- Kiralananları Listele|");
		System.out.println("| 0- Üst Menü             |");
		System.out.println("|_________________________|");
	}
	
	private int kullanicidanIntDegerAl() {
		secim = scanner.nextInt();
		scanner.nextLine();
		return secim;
	}
	
}
