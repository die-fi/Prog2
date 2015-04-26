package de.hsa.stockgame.core;

public interface AccountManager {
	
//	Anlegen eines Mitspielers	
	void addPlayer(String playername);

//	Kauf/Verkauf vonAktien
	void buyShare(String playerName,String shareName,int shareQuantitiy);
	void sellShare(String playerName,String shareName, int shareQuantity);
	
//	Wert eines Assets eines Mitspielers
	long getAssetValue(String player,Asset asset);
	
//	Gesamtwert aller Assets eines Mitspielers
	long getTotalValue(String player);
	
//	Abfragen des Kurses einer Aktie
	long getSharePrice(String shareName);
	
//	Abfragen aller verfügbaren Aktien und ihres Kurses in Textform
	void showAvailableShares();
}
