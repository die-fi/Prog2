package de.hsa.stockgame.core;

import java.util.Random;

public class RandomStockPriceProvider extends StockPriceProvider {
	
	Random rand=new Random();
	
	public RandomStockPriceProvider() {
		System.out.println("ShareArray bei rspp an:"+getShares());
	}

	@Override
	public void updateShareRate(Share share) {
		// TODO Auto-generated method stub
//		Preis der Aktie zufällig verändern
//		((max-min)+1)+min
		share.setPrice((long)rand.nextInt((10-1)+1)+1);
	}

}
