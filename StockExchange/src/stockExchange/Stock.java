package stockExchange;

/*
 * Stores a stock's details
 * Created by Jared Crawford
 */
public class Stock {
	private String tiker;
	private String companyName;
	private int lowestSell;
	private int HighestSell;
	private int volume;
	
	//The Stock object for storing the details of a stock
	public Stock(String tik, String cName, int lSell, int hSell, int v) {
		tiker = tik;
		companyName = cName;
		lowestSell = lSell;
		HighestSell = hSell;
		volume = v;
	}
}
