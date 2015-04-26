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
    	clockLabel = new JLabel("Lade AktienInterface...");
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
        	String output = "<html><body><table> <tr><td><b>Aktienname</b></td><td><b>Kurswert</b></td></tr>";
        	output += getTextForShareArray(shares);
        	output+="</table></body></html>";
        	return output;
        }
        
        private String getTextForShareArray(Share[] ShareArray) {        	
        	String output = "==============";
        	for(int i=0;i<ShareArray.length;i++) {
        		output += "<tr><td>" + ShareArray[i].getName() + "</td><td>" + ShareArray[i].getPrice() + "</td></tr>";
        	}
        	return output;
        }
    }

    public void start()
    {
    	MyTimer myTimer=MyTimer.getInstance();
    	myTimer.scheduleAtFixedRate(new TickerTask(), 1000, TICK_PERIOD);
    }
}
