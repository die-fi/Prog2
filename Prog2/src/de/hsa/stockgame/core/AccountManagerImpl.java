package de.hsa.stockgame.core;

public class AccountManagerImpl implements AccountManager {
	
	private Share[] shares={new Share("AUDI",5),new Share("BMW",10),new Share("SIEMENS",15),new Share("FIAT",20)};
	private Player[] players={new Player("default")};

	@Override
	public void addPlayer(String name) {
		// TODO Auto-generated method stub
		Player[] temp=new Player[players.length+1];
		int i;
		for(i=0;i<players.length;i++) {
			temp[i]=new Player(players[i]);
		}
		temp[i]=new Player(name);
		players=temp;
	}
	
//	Prüft ob übergebene Aktie im Array verfügbar ist
//	ja -> Referenz auf gefundene Aktie
//	nein -> null
	public Share shareListed(String shareName) {
		Share res=null;
		for(int i=0;i<shares.length;i++) {
			if(shares[i].getName()==shareName) {
				res=shares[i];
			}
		}
		return res;
	}

//	Prüft ob übergebene Player im Array verfügbar ist
//	ja -> Referenz auf gefundenen Player
//	nein -> null
	public Player playerListed(String playerName) {
		Player res=null;
		for(int i=0;i<players.length;i++) {
			if(players[i].getName()==playerName) {
				res=players[i];
			}
		}
		return res;
	}
	
	@Override
	public void buyShare(String playerName,String shareName,int shareQuantitiy) {
		// TODO Auto-generated method stub
		Share tempShare=shareListed(shareName);
		Player tempPlayer=playerListed(playerName);
		
//		wenn Aktie UND Player in der Liste enthalten
		if((tempShare!=null)&&(tempPlayer!=null)) {
			if(tempShare.getPrice()*shareQuantitiy<=tempPlayer.getCashAccount().getTotalValue()) {
				tempPlayer.getCashAccount().decreaseValue(tempShare.getPrice()*shareQuantitiy);
				if(tempPlayer.getShareDepositAccount().getShareItemArray()==null) {
//					Fall 1: wenn noch kein ShareDepositAccount vorhanden
//							wird zum ersten Element
					ShareItem[] temp=new ShareItem[] {new ShareItem(tempShare,shareQuantitiy)};
					tempPlayer.getShareDepositAccount().setShareItemArray(temp);
				}
				else {
//					Fall 2: ShareDepositAccount vorhanden
					tempPlayer.getShareDepositAccount().addShareItem(tempShare,shareQuantitiy);
				}
			}
			else {
				System.out.println("NICHT MÖGLICH, nicht genug Geld!!!");
			}
		}
	}
	
	@Override
	public void sellShare(String playerName,String shareName, int shareQuantity) {
		// TODO Auto-generated method stub
		Share tempShare=shareListed(shareName);
		Player tempPlayer=playerListed(playerName);
		
		if(tempPlayer.getShareDepositAccount().getShareItemArray()==null) {
//			Fall 1: kein ShareDepot verfügbar
			System.out.println(tempPlayer.getShareDepositAccount().getShareItemArray());
			System.out.println("NICHT MÖGLICH, kein DepositAccount verfügbar!!!");
		}
//		Fall 2: ShareDepot verfügbar
		else {
//			Fall 2.1: ShareItem verfügbar, wird nur aktualisiert
			if(tempPlayer.getShareDepositAccount().includedInShareItemArray(tempShare)!=null) {
//				Fall 2.2: Aktie in ausreichender Stückzahl verfügbar
				tempPlayer.getCashAccount().increaseValue(tempShare.getPrice()*shareQuantity);
				if((tempPlayer.getShareDepositAccount().includedInShareItemArray(tempShare).getNumber()-shareQuantity)>=0) {
					tempPlayer.getShareDepositAccount().removeShareItem(tempShare,shareQuantity);
				}
				else {
//				Fall 2.3: Aktie in NICHT ausreichensder Stückzahl verfügbar
					System.out.println("NICHT MÖGLICH, keine ausreichende Anzahl vorhanden!!!");
				}
			}
			else {
				System.out.println("NICHT MÖGLICH, keine Aktie mit diesem Namen vorhanden!!!");
			}
		}
	}
	
	@Override
	public long getAssetValue(String player,Asset asset) {
		// TODO Auto-generated method stub
		Player tempPlayer = playerListed(player);
		if (tempPlayer!=null) {
			switch (asset) {
			case 1:
				return tempPlayer.getCashAccount().getTotalValue();
			case 2:
				return tempPlayer.getShareDepositAccount().getTotalValue();
			default:
				System.out.println("Asset eingabe unbekannt");
				break;
			}
		}
		else 
			System.out.println("Keinen Player mit dem Namen vorhanden");
		return 0;
	}
	
	@Override
	public long getTotalValue(String playerName) {
		// TODO Auto-generated method stub
		Player tempPlayer=playerListed(playerName);
		if(tempPlayer!=null) {
			return tempPlayer.getCashAccount().getTotalValue();
		}
		return 0;
	}
	
	@Override
	public long getSharePrice(String shareName) {
		// TODO Auto-generated method stub
		Share tempShare=shareListed(shareName);
		if(tempShare!=null) {
			return tempShare.getPrice();
		}
		else {
			return 0;
		}
	}
	
	public void showAvailableShares() {
		for(int i=0;i<shares.length;i++) {
			System.out.println(shares[i].toString());
		}
	}
	
	public void showAvailablePlayers() {
		for(int i=0;i<players.length;i++) {
			System.out.println(players[i].getName());
		}
	}
	
	public void info(String playerName) {
		Player tempPlayer=playerListed(playerName);
		if(tempPlayer==null) {
			System.out.println("Player existiert NICHT");
		}
		else {
			System.out.println(tempPlayer.getShareDepositAccount());
			tempPlayer.getShareDepositAccount().show();
		}
	}
}
