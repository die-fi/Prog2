package de.hsa.stockgame.core;

import de.hsa.stockgame.exception.ShareNotExistsException;

public interface StockPriceInfo {
	
	public boolean isShareListed(String shareName);
	
	public long getCurrentShareRate(String shareName) throws ShareNotExistsException;
	
	public Share[] getAllSharesAsSnapShot();

}