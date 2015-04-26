package de.hsa.stockgame.core;

public class Player {
	
	private final String name;
	private CashAccount cashAccount;
	//private ShareItem shareItem;
	private ShareDepositAccount shareDepositAccount;
	
	public Player(String name) {
		this.name=name;
		this.cashAccount=new CashAccount(name,50);
		this.shareDepositAccount=new ShareDepositAccount(name);
	}
	
	public Player(Player toCopy) {
		this.name=toCopy.name;
		this.cashAccount=toCopy.cashAccount;
		this.shareDepositAccount=toCopy.shareDepositAccount;
	}
	
	public String getName() {
		return this.name;
	}
	
	public CashAccount getCashAccount() {
		return cashAccount;
	}
	
	public ShareDepositAccount getShareDepositAccount() {
		return shareDepositAccount;
	}
	
	public String toString() {
		if(shareDepositAccount!=null) {
			return "Player >> "+this.name+" >> Cash: "+this.cashAccount.getTotalValue()+"\n"+this.shareDepositAccount.toString();
		}
		else {
			return "Player >> "+this.name+" >> Cash: "+this.cashAccount.getTotalValue()+"\nNOCH KEIN SHAREITEM VERFÜGBAR";
		}
	}

}
