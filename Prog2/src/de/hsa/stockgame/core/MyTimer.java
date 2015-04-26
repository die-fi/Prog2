package de.hsa.stockgame.core;

import java.util.Timer;
//import java.util.TimerTask;

public class MyTimer extends Timer {
	
//	private int counter;
//	private static MyTimer instance;
//	
//	private MyTimer() {
//		startTiming();
//	};
//	
//	public static MyTimer getInstance() {
//		if (MyTimer.instance==null) {
//		      MyTimer.instance=new MyTimer ();
//		    }
//		    return MyTimer.instance;
//	}
//	
//	private void modifyUserObject() {
//        System.out.println("modifyUserObject: " + ++counter);
//    }
//	
//	private void startTiming() {
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            public void run() {
//                MyTimer.this.modifyUserObject();
//            }
//        }, 2000, 1000);
//    }
	
	private static MyTimer instance;
	
	private MyTimer() {
		
	}
	
	public static MyTimer getInstance() {
		if (MyTimer.instance==null) {
		      MyTimer.instance=new MyTimer ();
		    }
		    return MyTimer.instance;
	}

}
