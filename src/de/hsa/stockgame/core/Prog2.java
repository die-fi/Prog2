package de.hsa.stockgame.core;

public class Prog2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Share audi=new Share("AUDI",5);
//		Share bmw=new Share("BMW",10);
//		Share siemens=new Share("SIEMENS",15);
//		Share fiat=new Share("FIAT",20);
//		
//		Share bmw2=new Share("BMW",10);
//		Share bmw3=new Share("BMW",11);
		
//		System.out.println(bmw.equals(bmw)); // Referenz auf sich selbst
//		System.out.println(bmw.equals(bmw2)); // Referenz auf die gleiche Aktie
//		System.out.println(bmw.equals(bmw3)); // Referenz auf ungleiche (im Preis) Aktie
		
//		ShareDepositAccount player=new ShareDepositAccount("player");
//		player.show();
//		
//		player.buyShare(audi, 10);
//		player.show();
//		
//		player.buyShare(siemens, 10);
//		player.show();
//		
//		player.buyShare(fiat, 10);
//		player.show();
//		
//		player.sellShare(bmw, 1);
//		player.show();
//		
//		player.buyShare(bmw, 1);
//		player.show();
//		
//		player.sellShare(bmw, 1);
//		player.show();
		
//		AccountManagerImpl testImpl=new AccountManagerImpl();
//		testImpl.addPlayer("Rostik");
		
		AccountManagerImpl ami=new AccountManagerImpl();
		ami.showAvailableShares();
		
		ami.addPlayer("Dieter");
		System.out.println(ami.getTotalValue("Dieter"));
		
		ami.buyShare("Dieter","AUDI",100);
		System.out.println(ami.getTotalValue("Dieter"));
		
		ami.buyShare("Dieter","AUDI",100);
		System.out.println(ami.getTotalValue("Dieter"));
		
		ami.buyShare("Dieter","FIAT",10);
		System.out.println(ami.getTotalValue("Dieter"));
		
		ami.buyShare("Dieter","BMW",1000);
		System.out.println(ami.getTotalValue("Dieter"));
		
		
	}
}
