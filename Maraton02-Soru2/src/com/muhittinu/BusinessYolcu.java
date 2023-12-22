package com.muhittinu;

import java.util.ArrayList;
import java.util.List;

public class BusinessYolcu extends Yolcu {

	private int BUSINESSFIYAT = 200;
	private int BUSINESSVIPFIYAT = 150;
	private boolean isVIP ;
	private List<Bilet> biletler;
	
	public BusinessYolcu(String ad, String soyad, boolean isVIP) {
		super(ad, soyad);
		this.isVIP=isVIP;
		this.biletler = new ArrayList<>();
	}
	@Override
	public void yolcuBilgileriniGetir() {
		System.out.println("***   Yolcu Ad-Soyad\tBilet Bilgileri***");
		for (Bilet bilet : biletler) {
			System.out.println(super.getAd()+" "+super.getSoyad()+"\t\t"+bilet.getFirmaAdi()+"-"+bilet.getBiletFiyati()+" TL");
		}
	}

	@Override
	public void biletAl(EFirmaAdi firmaAdi) {
		int biletParasi=0;
		String vip ="";
		if (isVIP) {
			biletParasi = getBASEFIYAT()+BUSINESSFIYAT+BUSINESSVIPFIYAT;
			vip="VIP ";
		}else {
			biletParasi = getBASEFIYAT()+BUSINESSFIYAT;
		}
		Bilet bilet = new Bilet(firmaAdi, biletParasi);
		biletler.add(bilet);
		System.out.println(super.getAd()+" adlı yolcu "+firmaAdi+" firmasından "+vip+"bilet almıştır.-->"+bilet.getFirmaAdi()+"-"+bilet.getBiletFiyati()+" TL");
	}

	@Override
	public void checkInYap() {
		if (!super.isCheckIn()) {
			super.setCheckIn(true);
			System.out.println(super.getAd()+" check-in başarılı.");
		}else {
			System.out.println("Daha önce check-in yapmışsınız.");
		}
	}

	@Override
	public void ucagaBin() {
		if (super.isCheckIn()) {
			System.out.println(super.getAd()+" "+super.getSoyad()+" "+super.getKoltukNo()+" koltuk numarası ile uçağa binebilirsiniz.");
		}else {
			System.out.println("Önce check-in yapmalısınız.");
		}
	}

}
