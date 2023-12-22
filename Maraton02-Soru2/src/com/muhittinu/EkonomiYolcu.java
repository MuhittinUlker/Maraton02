package com.muhittinu;

import java.util.ArrayList;
import java.util.List;

public class EkonomiYolcu extends Yolcu {

	private int EKONOMIFIYAT = 100;
	private double indirimOranı = 0.05;
	private List<Bilet> biletler;
	
	public EkonomiYolcu(String ad, String soyad) {
		super(ad, soyad);
		this.biletler = new ArrayList<>();
	}

	@Override
	public void yolcuBilgileriniGetir() {
		System.out.println("***Yolcu Adı-Soyadı\tBilet Bilgileri***");
		for (Bilet bilet : biletler) {
			System.out.println(super.getAd()+" "+super.getSoyad()+"\t\t"+bilet.getFirmaAdi()+"-"+bilet.getBiletFiyati()+" TL");
		}
	}

	@Override
	public void biletAl(EFirmaAdi firmaAdi) {
		double biletParasi=0;
		
			if (dahaOnceBiletAlmisMi(firmaAdi)) {
				biletParasi=((getBASEFIYAT()+EKONOMIFIYAT)*(1-indirimOranı));
				Bilet yBilet = new Bilet(firmaAdi, biletParasi);
				biletler.add(yBilet);
			}else {
				biletParasi=getBASEFIYAT()+EKONOMIFIYAT;
				Bilet yBilet = new Bilet(firmaAdi, biletParasi);
				biletler.add(yBilet);
			}	
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
			System.out.println(super.getAd()+" "+super.getKoltukNo()+" koltuk numarası ile uçağa binebilirsiniz.");
		}else {
			System.out.println("Önce check-in yapmalısınız.");
		}
	}
	
	private boolean dahaOnceBiletAlmisMi(EFirmaAdi firmaAdi) {
		for (Bilet bilet : biletler) {
			if (bilet.getFirmaAdi().name().equals(firmaAdi.name())) {
				return true;
			}
		}
		return false;
	}

}
