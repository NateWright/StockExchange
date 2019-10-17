package stockExchange;

import java.util.HashMap;

public class StockExchange {

			private HashMap <String, Stock> stocks = new HashMap<String, Stock>();
	
	public StockExchange()
	{
		
	}
	
	public Stock getStock(String smbl) {
		return stocks.get(smbl);
	}
	
	public void listStock(String ticker, String companyName, Double stockPrice)
	{
		stocks.put(ticker, new Stock(ticker, companyName, stockPrice));
	}
	
}
