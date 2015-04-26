package de.hsa.stockgame.core;

import java.util.Random;

public class RandomStockPriceProvider extends StockPriceProvider {
	final long MAX_CHANGE = 20;					// Bestimmt die Änderungsspanne des Preises
									// BSP.: MAX_CHANGE=20 geht von -10 bis +10 
	Random rand=new Random();
	
	public RandomStockPriceProvider() {
		System.out.println("ShareArray bei rspp an:"+getShares());
	}

	@Override	
	public void updateShareRate(Share share) {
		long change= -MAX_CHANGE/2 + rand.nextInt((int)MAX_CHANGE);
		
		if (share.getPrice() + change >= 0) {			// Prüft ob der Aktienpreis nach der Änderung in negative gehen würde.
			share.setPrice(share.getPrice() + change);
		}
	}

}
