package de.hsa.stockgame.core;

import de.hsa.stockgame.view.StockPriceViewer;

public class StockGameLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConstStockPriceProvider cspp=new ConstStockPriceProvider();
		
		Share[] csppArraySnapShot=cspp.getAllSharesAsSnapShot();
		for(int i=0;i<csppArraySnapShot.length;i++) {
			System.out.println("cspp:"+csppArraySnapShot[i]);
		}
		
		RandomStockPriceProvider rspp= new RandomStockPriceProvider();
		
		Share[] rsppArraySnapShot=rspp.getAllSharesAsSnapShot();
		for(int i=0;i<rsppArraySnapShot.length;i++) {
			System.out.println("rspp:"+rsppArraySnapShot[i]);
		}
		
		cspp.startUpdate();
		
		rspp.startUpdate();
		
		StockPriceViewer spv=new StockPriceViewer(cspp);
		spv.start();
		
		StockPriceViewer spv2=new StockPriceViewer(rspp);
		spv2.start();
		
//		Share[] temp={new Share("EINS",5),new Share("ZWEI",10),new Share("DREI",15),new Share("VIER",20)};
//		System.out.println("neuen Array zuweisen...");
//		rspp.setUpdatedShares(temp);
//		
//		Share[] rsppArraySnapShot2=rspp.getAllSharesAsSnapShot();
//		for(int i=0;i<rsppArraySnapShot2.length;i++) {
//			System.out.println(rsppArraySnapShot2[i]);
//		}
		
	}

}
