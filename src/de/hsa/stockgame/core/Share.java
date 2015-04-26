package de.hsa.stockgame.core;

public class Share {
	
	private final String name;
	private long price; //in Cent
	
	public Share(String name,long price) {
		this.name=name;
		this.price=price;
	}
	
	public Share(Share toCopy) {
		this.name=toCopy.getName();
		this.price=toCopy.getPrice();
	}
	
	public String getName() {
		return name;
	}
	
	public long getPrice() {
		return price;
	}
	
	public void setPrice(long price) {
		this.price=price;
	}
	
	@Override public String toString() {
		return "Aktie >> "+this.name+" >> Preis >> "+this.price/100.0+" €";
	}
	
	/*@Override public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if(obj==this) {
			return true;
		}
		if(obj.getClass()==this.getClass()) {
			Share temp=(Share)obj;
			if(this.name.equals(temp.getName())&&(this.price==temp.getPrice())) {
				return true;
			}
		}
		return false;
	}*/
	
	@Override public boolean equals(Object obj) {
		if(!(obj instanceof Share)) {
			return false;
		}
		return true;
	}
}
