package de.hsa.stockgame.core;

public class CashAccount extends Asset {
	
	private long value;
	
	public CashAccount(String name,long value) {
		this.name=name;
		this.value=value*100;
	}
	
	public void decreaseValue(long value) { // Aktie kaufen
		this.value-=value;
	}
	
	public void increaseValue(long value) { // Aktie verkaufen
		this.value+=value;
	}
		
	public long getTotalValue() {
		return value;
	}
	
	public String toString() {
		return "Geldkonto >> "+name+" >> Betrag >> "+value/100.0+" €";
	}

}
