package de.hsa.stockgame.view;

import de.hsa.stockgame.core.MyTimer;
import de.hsa.stockgame.core.Share;
import de.hsa.stockgame.core.StockPriceInfo;

import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class StockPriceViewer extends JFrame
{
	
	/**
	 * The serializable class StockPriceViewer does not declare a static final serialVersionUID field of type long
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int TICK_PERIOD = 1000;
	
    private JLabel clockLabel;
    StockPriceInfo spi=null;
	
    public StockPriceViewer()
    {
//        clockLabel = new JLabel("<html><body>Verfügbare Aktien:<br>");
    	clockLabel = new JLabel("<html><body>Verfügbare Aktien:<br>");
        add("Center", clockLabel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);
    }
    
    public StockPriceViewer(StockPriceInfo spi)
    {
		this();
		this.spi=spi;
	}

    public class TickerTask extends TimerTask
    {
    	
        public void run() {
        	
        	System.out.println("spv working...");
        	
        	Share[] temp=spi.getAllSharesAsSnapShot();
        	System.out.println("TickerTask aus StocKPriceViewer...");
        	for(int i=0;i<temp.length;i++) {
        		System.out.println(temp[i]);
        	}
        	
            String output = createText();
            clockLabel.setText(output);
            clockLabel.repaint();
        }

        private String createText() {
        	
        	Share[] shares=spi.getAllSharesAsSnapShot();
//        	String output=clockLabel.getText();
        	String output="<html><body>Verfügbare Aktien:<br>";
        	for(int i=0;i<shares.length;i++) {
        		output+=shares[i].toString()+"<br>";
        	}
        	output+="</body></html>";
        	return output;
        }
    }

    public void start()
    {
    	MyTimer myTimer=MyTimer.getInstance();
    	myTimer.scheduleAtFixedRate(new TickerTask(), 1000, TICK_PERIOD);
    }
}
