package de.hsa.stockgame.core;

import de.hsa.stockgame.exception.ShareNotExistsException;

public interface StockPriceInfo {
	
	/**
	 * 
	 * @param String - Name der Gesuchten Aktie
	 * @return boolean true = Aktie existiert, false existiert nicht
	 */	
	public boolean isShareListed(String shareName);
	
	
	/**
	 * Gibt den aktuellen Kurs der Aktie wieder.
	 * @param share
	 * @return long - Preis der Aktie
	 */	
	public long getCurrentShareRate(String shareName) throws ShareNotExistsException;
	
	/**
	 * Gibt alle im Spiel vorhandene Aktien und deren Kurz als Text aus
	 * @return Share[] - Wiedergabe aller Share in einem ShareArray
	 */	
	public Share[] getAllSharesAsSnapShot();

}
