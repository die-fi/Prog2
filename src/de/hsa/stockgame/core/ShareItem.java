package de.hsa.stockgame.core;

public class ShareItem extends Asset {
	
	private long value;
	private int number; //Anzahl der Aktien im Item
	private Share share;
	
	public ShareItem(Share share,int number) {
		name=share.getName();
		this.number=number;
		value+=share.getPrice()*number;
		this.share=share;
	}
	
	public ShareItem(ShareItem toCopy) {
		name=toCopy.name;
		number=toCopy.number;
		value=toCopy.value;
		share=toCopy.share;
	}
	
	public String getName() {
		return name;
	}
	
	public long getTotalValue() {
		return value;
	}
	
	public int getNumber() {
		return this.number;		
	}
	
	public void setNumber(int number) {
		this.number=number;
	}
	
	public void addShare(int number,long price) {
		this.setNumber(this.getNumber()+number);
		this.value+=price*number;
	}
	
	public void removeShare(int number,long price) {
		this.setNumber(this.getNumber()-number);
		this.value-=price*number;
	}
	
	public String toString() {
		return "ShareItem >> "+this.name+" >> Anzahl >> "+this.number+" >> Wert >> "+this.value/100.0+" € >> "+"@" + Integer.toHexString(hashCode());
	}

}
