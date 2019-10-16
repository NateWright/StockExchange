package stockExchange;

import java.util.Comparator;

/*
 * Compares prices in TradeOrder class
 * Created by: Nazarii Klymok
 */

public class PriceComparator implements Comparator<TradeOrder> {
	private boolean ascend = true; 
	
	public PriceComparator() {

	}
	
	public PriceComparator(boolean a) {
		ascend = a;
	}
	
	@Override
	public int compare(TradeOrder to1, TradeOrder to2) {
		if (to1.getPrice() > to2.getPrice())
			if (ascend)
				return 1;
			else
				return -1;
		if (to1.getPrice() < to2.getPrice())
			if (ascend)
				return -1;
			else 
				return 1;
		else
			return 0;
		}
	
	/**
	 * Switches the comparator order to ascending or descending
	 * @param a boolean that sets the order for comparator 
	 */
	
	public void setAscending(boolean a) {
		if(a)
			ascend = true;
		else
			ascend = false;
	}
}
