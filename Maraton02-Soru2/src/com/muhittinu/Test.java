package com.muhittinu;

public class Test {

	public static void main(String[] args) {

		Yolcu yolcu = new BusinessYolcu("Mehmet","Ak", false);
		Yolcu yolcu2 = new BusinessYolcu("Hasan", "Kara", true);
		Yolcu yolcu3 = new EkonomiYolcu("Ali", "Yüzer");
		
		System.out.println("-----non-VIP Business Yolcu-----");
		yolcu.biletAl(EFirmaAdi.THY);
		yolcu.ucagaBin();
		yolcu.checkInYap();
		yolcu.checkInYap();
		yolcu.ucagaBin();
		yolcu.yolcuBilgileriniGetir();
		
		System.out.println("-----VIP Business Yolcu-----");
		yolcu2.biletAl(EFirmaAdi.ADJ);
		yolcu2.ucagaBin();
		yolcu2.checkInYap();
		yolcu2.checkInYap();
		yolcu2.ucagaBin();
		yolcu2.yolcuBilgileriniGetir();
		
		System.out.println("-----Ekonomi Yolcu-----");
		yolcu3.biletAl(EFirmaAdi.ADJ);
		yolcu3.biletAl(EFirmaAdi.ADJ);
		yolcu3.biletAl(EFirmaAdi.PGS);
		yolcu3.biletAl(EFirmaAdi.THY);
		yolcu3.ucagaBin();
		yolcu3.checkInYap();
		yolcu3.checkInYap();
		yolcu3.ucagaBin();
		yolcu3.yolcuBilgileriniGetir();
		
	}

}
