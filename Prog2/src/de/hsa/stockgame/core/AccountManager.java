package de.hsa.stockgame.core;

public interface AccountManager {
	
//	Anlegen eines Mitspielers	
	void addPlayer(String playername);

//	Kauf/Verkauf vonAktien
	void buyShare(String playerName,String shareName,int shareQuantitiy);
	void sellShare(String playerName,String shareName, int shareQuantity);
	
//	Wert eines Assets eines Mitspielers
	/**
	 * Gibt den aktuellen Wert des Assets wieder.
	 * @param player - Name des Spielers
	 * @param asset - 1 = CashAccount, 2 = Gesamtes ShareDepositeAccount
	 * @return long - Preis der Aktie
	 */	
	long getAssetValue(String player, int asset);
	
//	Gesamtwert aller Assets eines Mitspielers
	long getTotalValue(String player);
	
//	Abfragen des Kurses einer Aktie
	long getSharePrice(String shareName);
	
//	Abfragen aller verfügbaren Aktien und ihres Kurses in Textform
	void showAvailableShares();
}
