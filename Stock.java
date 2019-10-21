package stockExchange;

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
			if (buyStockQ.peek().isMarket()) 
				bid = "market size: " + buyStockQ.peek().getNumberOfShares();
			else
				bid = "" + buyStockQ.peek().getNumberOfShares();
		
		return companyName + " (" + tiker + ")\n" +
				"Price: " + price + " " + "hi: " + highestSell + " " + "lo: " + lowestSell + " " + "vol: " + volume + "\n"
				+ "Ask: " + ask + " " + "Bid: " + bid;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void buyStock(TradeOrder to) {
		buyStockQ.add(to);
		executeTrade();
	}
	public void sellStock(TradeOrder to) {
		sellStockQ.add(to);
		executeTrade();
	}
	public void executeTrade() {
 		if((buyStockQ.peek() != null && sellStockQ.peek() != null) && buyStockQ.peek().getPrice() >= sellStockQ.peek().getPrice()) {
			int numberToSell = 0;
			if(buyStockQ.peek().getNumberOfShares() > sellStockQ.peek().getNumberOfShares()) {
				numberToSell = sellStockQ.peek().getNumberOfShares();
				TradeOrder b = buyStockQ.poll();
				TradeOrder s = sellStockQ.poll();
				b.setNumberOfShares(b.getNumberOfShares() - numberToSell);
				b.getTrader().addMail("You bought: " + numberToSell + " " + b.getStockSymbol() + " at " + s.getPrice() + 
						" amt " + numberToSell * s.getPrice());
				buyStockQ.add(b);
				s.getTrader().addMail("You sold: " + numberToSell + " " + b.getStockSymbol() + " at " + s.getPrice() + 
						" amt " + numberToSell * s.getPrice());
				if(getLowestSell() > s.getPrice()) {
					setLowestSell(s.getPrice());
				}
				if(getHighestSell() < s.getPrice()) {
					setHighestSell(s.getPrice());
				}
				volume += numberToSell;
			}
			else if(buyStockQ.peek().getNumberOfShares() < sellStockQ.peek().getNumberOfShares()) {
				numberToSell = buyStockQ.peek().getNumberOfShares();
				TradeOrder b = buyStockQ.poll();
				TradeOrder s = sellStockQ.poll();
				s.setNumberOfShares(s.getNumberOfShares() - numberToSell);
				b.getTrader().addMail("You bought: " + numberToSell + " " + b.getStockSymbol() + " at " + s.getPrice() + 
						" amt " + numberToSell * s.getPrice());
				s.getTrader().addMail("You sold: " + numberToSell + " " + b.getStockSymbol() + " at " + s.getPrice() + 
						" amt " + numberToSell * s.getPrice());
				sellStockQ.add(s);
				if(getLowestSell() > s.getPrice()) {
					setLowestSell(s.getPrice());
				}
				if(getHighestSell() < s.getPrice()) {
					setHighestSell(s.getPrice());
				}
				volume += numberToSell;
			}
			else {
				numberToSell = buyStockQ.peek().getNumberOfShares();
				TradeOrder b = buyStockQ.poll();
				TradeOrder s = sellStockQ.poll();
				b.getTrader().addMail("You bought: " + numberToSell + " " + b.getStockSymbol() + " at " + s.getPrice() + 
						" amt " + numberToSell * s.getPrice());
				s.getTrader().addMail("You sold: " + numberToSell + " " + b.getStockSymbol() + " at " + s.getPrice() + 
						" amt " + numberToSell * s.getPrice());
				if(getLowestSell() > s.getPrice()) {
					setLowestSell(s.getPrice());
				}
				if(getHighestSell() < s.getPrice()) {
					setHighestSell(s.getPrice());
				}
				volume += numberToSell;
			}
		}
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
