package stockExchange;

/**
 * Data carrier for fields that correspond to the entry fields in a TraderWindow
 * Created by: Nazarii Klymok
 */
public class TradeOrder {
	private Trader trader;
	private String stockSymbol;
	private int numberOfShares;
	private double price;
	private boolean isBuying;
	private boolean isMarket;
	
	/**
	 * Initializes a TradeOrder with following parameters: 
	 * @param t - sets a trader for the TradeOrders
	 * @param ss - sets a stock symbol
	 * @param b - sets boolean 'isBuying'
	 * @param m - sets boolean 'isMarket'
	 * @param nos - sets a number of shares
	 * @param p - sets price
	 */
	public TradeOrder(Trader t, String ss, boolean b, boolean m, int nos, double p) {
		trader = t;
		stockSymbol = ss;
		numberOfShares = nos;
		price = p;
		isBuying = b;
		isMarket = m;
	}
	
	public Trader getTrader() {
		return trader;
	}

	public boolean isMarket() {
		return isMarket;
	}

	public void setMarket(boolean isMarket) {
		this.isMarket = isMarket;
	}

	public boolean isBuying() {
		return isBuying;
	}

	public void setBuying(boolean isBuying) {
		this.isBuying = isBuying;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	
}