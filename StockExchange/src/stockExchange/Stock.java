package stockExchange;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Stores a stock's details
 * Created by Jared Crawford
 */
public class Stock {
	private String tiker;
	private String companyName;
	private double price;
	private double lowestSell;
	private double highestSell;
	private int volume;
	private PriceComparator buyComparator = new PriceComparator(false);
	private PriceComparator sellComparator = new PriceComparator(true);
	private PriorityQueue<TradeOrder> buyStockQ = new PriorityQueue<>(buyComparator);
	private PriorityQueue<TradeOrder> sellStockQ = new PriorityQueue<>(sellComparator);
	
	
	//The Stock object for storing the details of a stock
	public Stock(String tik, String cName, double p) {
		tiker = tik;
		companyName = cName;
		price = p;
		lowestSell = price;
		highestSell = price;
	}
	
	@Override
	public String toString() {
		String ask = "none";
		if (sellStockQ.peek() != null && sellStockQ.peek().getPrice() != 0) {
			ask = "" + sellStockQ.peek().getPrice();
			if (sellStockQ.peek().isMarket()) {
				ask = "market vol: " + sellStockQ.peek().getNumberOfShares();
			}
		}
		
		String bid = "none";
		if (buyStockQ.peek() != null && buyStockQ.peek().getNumberOfShares() != 0)
			bid = "" + buyStockQ.peek().getNumberOfShares();
		
		return companyName + " (" + tiker + ")\n" +
				"Price: " + price + " " + "hi: " + highestSell + " " + "lo: " + lowestSell + " " + "vol: " + volume + "\n"
				+ "Ask: " + ask + " " + "Bid: " + bid + "\n";
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void buyStock(TradeOrder to) {
		buyStockQ.add(to);
		if (!to.isMarket())
			to.getTrader().addMail("You bought: " + to.getNumberOfShares() + " " + to.getStockSymbol() + " at " + to.getPrice() + 
				" amt " + to.getNumberOfShares() * to.getPrice());
	}
	public void sellStock(TradeOrder to) {
		sellStockQ.add(to);
		if(!to.isBuying())
			to.getTrader().addMail("You sold: " + to.getNumberOfShares() + " " + to.getStockSymbol() + " at " + to.getPrice() + 
				" amt " + to.getNumberOfShares() * to.getPrice());
	}
	public double getLowestSell() {
		return lowestSell;
	}
	public void setLowestSell(double lowestSell) {
		this.lowestSell = lowestSell;
	}
	public double getHighestSell() {
		return highestSell;
	}
	public void setHighestSell(double hs) {
		highestSell = hs;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
}
