package stockExchange;

import java.util.Comparator;

/*
 * Compares prices in TradeOrder class
 * Created by: Nazarii Klymok
 */

public class PriceComparator implements Comparator<TradeOrder> {
	private boolean ascend; 
	
	public PriceComparator() {
		ascend = true;
	}
	
	public PriceComparator(boolean a) {
		ascend = a;
	}
	
	public int compare(TradeOrder to1, TradeOrder to2) {
		int diff = to1.getPrice() - to2.getPrice();
		if (ascend)
			return diff;
		else
			return -diff;
	}
	
	/*
	 * Switches the comparator order to ascending or descending
	 * @param boolean that sets the order for comparator 
	 */
	
	public void setAscending(boolean a) {
		if(a)
			ascend = true;
		else
			ascend = false;
	}
}
