package de.hsa.stockgame.core;

public class ShareDepositAccount extends Asset {
	

	private ShareItem[] shareItemArray;

	
	public ShareDepositAccount(String name) {
		shareItemArray=null;
		this.name=name;
	}
	
	public ShareItem[] getShareItemArray() {
		return shareItemArray;
	}
	
	public void setShareItemArray(ShareItem[] shareItemArray) {
		this.shareItemArray=shareItemArray;
	}
	
	public ShareItem includedInShareItemArray(Share share) {
		ShareItem temp=null;
		for(int i=0;i<shareItemArray.length;i++) {
			if(shareItemArray[i].equals(share)) {
				temp=shareItemArray[i];
			}
		}
		return temp;
	}
	
//	verändert die Größe des Array, Einträge mit Anzahl=0 werden nicht übernommen
	//public
	private void resizeShareItemArray(int size) {
		ShareItem[] temp=null;
		if(size==1) {
			temp=new ShareItem[shareItemArray.length+1];
			for(int i=0;i<shareItemArray.length;i++) {
				temp[i]=new ShareItem(shareItemArray[i]);
			}
		}
		else if(size==-1) {
			temp=new ShareItem[shareItemArray.length-1];
			int j=0;
			for(int i=0;i<shareItemArray.length;i++) {
				if(shareItemArray[i].getNumber()!=0) {
					temp[j]=new ShareItem(shareItemArray[i]);
					j++;
				}
			}
		}
		this.shareItemArray=temp;
	}
	
	public void addShareItem(Share share,int amount) {
		ShareItem temp=includedInShareItemArray(share);
		if(temp!=null) {
//			Fall 1: ShareItem mit dem gleichen Namen vorhanden,
//					wird lediglich aktualisiert
			temp.addShare(amount, share.getPrice());
		}
		else {
//			Fall 2: ShareItem NICHT vorhanden
			int oldSize=shareItemArray.length;
//			Array vergrößern
			resizeShareItemArray(1);
//			neues ShareItem am Ende einfügen
			shareItemArray[oldSize]=new ShareItem(share,amount);
		}
	}
	
	public void removeShareItem(Share share,int amount) {
		ShareItem temp=includedInShareItemArray(share);
		if(temp==null) {
//			Fall 1: ShareItem mit dem gleichen Namen NICHT vorhanden
			System.out.println("KEINE Aktien mit diesem Namen!!!");
		}
		else {
//			Fall 2: ShareItem mit diesem Namen vorhanden,
//			wird lediglich aktualisiert
			temp.removeShare(amount, share.getPrice());
//			Fall 2.1: es werden alle verfügbaren Aktien im ShareItem verkauft
			if(temp.getNumber()==0) {
				resizeShareItemArray(-1);
			}
		}
	}
	
//	public void buyShare(Share share,int amount) {
//		if(share.getPrice()*amount<=cashAccount.getTotalValue()) {
//			this.cashAccount.decreaseValue(share.getPrice()*amount);
//			if(this.shareItemArray==null) {
////				Fall 1: wenn noch kein ShareDepositAccount vorhanden
////						wird zum ersten Element
//				shareItemArray=new ShareItem[] {new ShareItem(share,amount)};
//			}
//			else {
////				Fall 2: ShareDepositAccount vorhanden
//				addShareItem(share,amount);
//			}
//		}
//		else {
//			System.out.println("NICHT MÖGLICH, nicht genug Geld!!!");
//		}
//	}
	
//	public void sellShare(Share share,int amount) {
//		if(shareItemArray==null) {
////			Fall 1: kein ShareDepot verfügbar
//			System.out.println("NICHT MÖGLICH, kein DepositAccount verfügbar!!!");
//		}
////		Fall 2: ShareDepot verfügbar
//		else {
////			Fall 2.1: ShareItem verfügbar, wird nur aktualisiert
//			if(includedInShareItemArray(share)!=null) {
////				Fall 2.2: Aktie in ausreichender Stückzahl verfügbar
//				this.cashAccount.increaseValue(share.getPrice()*amount);
//				if((includedInShareItemArray(share).getNumber()-amount)>=0) {
//					removeShareItem(share,amount);
//				}
//				else {
////				Fall 2.3: Aktie in NICHT ausreichensder Stückzahl verfügbar
//					System.out.println("NICHT MÖGLICH, keine ausreichende Anzahl vorhanden!!!");
//				}
//			}
//			else {
//				System.out.println("NICHT MÖGLICH, keine Aktie mit diesem Namen vorhanden!!!");
//			}
//		}
//	}
	
	public long getTotalValue() {
		long tempValue = 0;
		
		if (shareItemArray != null) {
			for (int i=0; shareItemArray.length > i; i++) {
				tempValue += shareItemArray[i].getTotalValue();
			}
		}
		return tempValue;
	}
	
	public String toString() {
		return "ShareDepositAccount >> "+this.name;
	}
	
	public void show() {
		System.out.println(this);
//		System.out.println(this.cashAccount.toString());
		if(shareItemArray!=null) {
			for(int i=0;i<shareItemArray.length;i++) {
				System.out.println(shareItemArray[i]);
			}
		}
		else {
			System.out.println("kein DepositAccount verfügbar");
		}
	}
}
