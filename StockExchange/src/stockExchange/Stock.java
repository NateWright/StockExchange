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
	private double HighestSell;
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
	}
	
	@Override
	public String toString() {
		Double ask;
		if (buyStockQ.peek() != null)
			ask = buyStockQ.peek().getPrice();
		else
			ask = 0.0d;
		int bid;
		if (buyStockQ.peek() != null)
			bid = buyStockQ.peek().getNumberOfShares();
		else
			bid = 0;
		return companyName + "(" + tiker + ")\n" +
				"Price: " + price + " " + "hi: " + HighestSell + " " + "lo: " + lowestSell + " " + "vol: " + volume + "\n"
				+ "ask: " + ask + " " + "bid: " + bid + "\n";
	}
	
	public void buyStock(TradeOrder to) {
		buyStockQ.add(to);
	}
	public void sellStock(TradeOrder to) {
		sellStockQ.add(to);
	}
	public double getLowestSell() {
		return lowestSell;
	}
	public void setLowestSell(double lowestSell) {
		this.lowestSell = lowestSell;
	}
	public double getHighestSell() {
		return HighestSell;
	}
	public void setHighestSell(double highestSell) {
		HighestSell = highestSell;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
}
