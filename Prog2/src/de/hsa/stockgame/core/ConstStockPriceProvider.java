package de.hsa.stockgame.core;

public class ConstStockPriceProvider extends StockPriceProvider {
	
	public ConstStockPriceProvider() {
		System.out.println("ShareArray bei cspp an:"+getShares());
	}

//	Objekte OHNE Veränderung an Preis ins neue Array kopieren 
	@Override
	public void updateShareRate(Share share) {
		// TODO Auto-generated method stub

	}
	
	public void startUpdate() {
		
	}

}
