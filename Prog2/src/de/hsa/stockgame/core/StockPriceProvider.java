package de.hsa.stockgame.core;

import java.util.TimerTask;

import de.hsa.stockgame.exception.*;

public abstract class StockPriceProvider implements StockPriceInfo {
	
	private Share[] shares={new Share("AUDI",5),new Share("BMW",10),new Share("SIEMENS",15),new Share("FIAT",20)};
	
//	public Share[] temp={new Share("EINS",5),new Share("ZWEI",10),new Share("DREI",15),new Share("VIER",20)};
	
	private static final int TICK_PERIOD = 1000;
	
	MyTimer myTimer=MyTimer.getInstance();
	
//	wird benutzt um die Adresse des ShareArrays anzuzeigen
	public Share[] getShares() {
		return shares;
	}
	
	public void setUpdatedShares(Share[] shares) {
		this.shares=shares;
	}
	
	private class TickerTask extends TimerTask
    {
        public void run() {
        	System.out.println("spp working...");
        	System.out.println("Shares ALT");
        	for(int i=0;i<shares.length;i++) {
            	System.out.println(shares[i]);
            }
            updateShareRates();
            System.out.println("Shares NEU");
            for(int i=0;i<shares.length;i++) {
            	System.out.println(shares[i]);
            }
        }
    }

	@Override
	public boolean isShareListed(String shareName) {
		// TODO Auto-generated method stub
		boolean res=false;
		for(int i=0;i<shares.length;i++) {
			if(shares[i].getName()==shareName) {
				res=true;
			}
		}
		return res;
	}

	@Override
	public long getCurrentShareRate(String shareName) throws ShareNotExistsException {
		// TODO Auto-generated method stub
		//		if(isShareListed(shareName)) {
//			for(int i=0;i<shares.length;i++) {
//				if(shares[i].getName()==shareName) {
//					return shares[i].getPrice();
//				}
//			}
//		}
//		return 0;
		
//		return getShare(shareName).getPrice();
		
		if(getShare(shareName)!=null) {
			return getShare(shareName).getPrice();
		}
		else {
			throw new ShareNotExistsException("EXCEPTION >> Aktie mit diesem Namen existiert nicht!!!");
		}
	}

	@Override
	public Share[] getAllSharesAsSnapShot() {
		// TODO Auto-generated method stub
		Share[] snapShot=new Share[shares.length];
		for(int i=0;i<shares.length;i++) {
			snapShot[i]=new Share(shares[i]);
		}
		return snapShot;
	}
	
//	#
	public void updateShareRates() {
		Share[] tempShareArray=getAllSharesAsSnapShot();
		for(int i=0;i<tempShareArray.length;i++) {
			updateShareRate(tempShareArray[i]);
		}
		this.setUpdatedShares(tempShareArray);
	}
	
//	#
	public abstract void updateShareRate(Share share);
	
	public void startUpdate() {
		System.out.println("spp startUpdate()");
		myTimer.scheduleAtFixedRate(new TickerTask(), 1000, TICK_PERIOD);
	}
	
	public Share getShare(String name)  {
		if(isShareListed(name)) {
			for(int i=0;i<shares.length;i++) {
				if(shares[i].getName()==name) {
					return shares[i];
				}
			}
		}
		return null;
	}
}
