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
		double price1 = to1.getPrice();
		double price2 = to2.getPrice();
		
		if (to1.isMarket()) {
			price1 = to1.getTrader().getBrokerage().getStock(to1.getStockSymbol()).getDefaultPrice();
		}
		if (to2.isMarket()) {
			price2 = to2.getTrader().getBrokerage().getStock(to2.getStockSymbol()).getDefaultPrice();
		}
		
		if (price1 > price2)
			if (ascend)
				return 1;
			else
				return -1;
		if (price1 < price2)
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
