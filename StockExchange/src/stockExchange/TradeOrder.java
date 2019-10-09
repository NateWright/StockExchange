package stockExchange;

/**
 * Data carrier for fields that correspond to the entry fields in a TraderWindow
 * Created by: Nazarii Klymok
 */
public class TradeOrder {
	private String stockSymbol;
	private int numberOfShares;
	private int price;
	private boolean isBuying;
	private boolean isMarket;
	
	/**
	 * A constructor for instant and more compact initialization of the object
	 * @param ss sets a stock symbol
	 * @param nos sets a number of shares
	 * @param p sets price
	 * @param b correspond to boolean 'isBuying'
	 * @param m correspond to boolean 'isMarket'
	 */
	
	public TradeOrder(String ss, int nos, int p, boolean b, boolean m) {
		stockSymbol = ss;
		numberOfShares = nos;
		price = p;
		isBuying = b;
		isMarket = m;
	}
	
	public TradeOrder() {
		
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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
