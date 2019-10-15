package stockExchange;

import java.util.HashMap;

public class StockExchange {

			private HashMap <String, Double> stock = new HashMap<String, Double>();
	
	public StockExchange()
	{
		
	}
	
	public void listStock(String ticker, String companyName, Double stockPrice)
	{
		stock.put(ticker, stockPrice);
	}
	
}
