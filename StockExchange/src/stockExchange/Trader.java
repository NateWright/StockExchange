package stockExchange;

import java.util.LinkedList;


public class Trader implements Comparable<Trader> {
	private String name;
	private LinkedList<String> mailbox;
	private TraderWindow tw;
	private String password;
	private String quote;
	private Brokerage brokerage;
	
	//No args constructor to allow for blank slates	
	public Trader(String n, String p, Brokerage b) {
		name = n;
		password = p;
		brokerage = b;
		mailbox = new LinkedList<>();
	}

//	These methods allow TraderWindow to access specific information of the user 
	public String getName() {
		return name;
	}

	public void quit() {
		brokerage.logout(this);
	}
	
	public void showWindow() {
		tw = new TraderWindow(this);		
	}

	public void placeOrder(TradeOrder tradeOrder) {
		if (tradeOrder.isMarket()) {
			if(tradeOrder.isBuying()) {
				if (tradeOrder.getPrice() == 0.0d)
					tradeOrder.setPrice(brokerage.getStock(tradeOrder.getStockSymbol()).getLowestSell());
				addMail("New order:  Buy " + tradeOrder.getStockSymbol() + " (" + brokerage.getCompanyName(tradeOrder.getStockSymbol()) + ")\r\n" + 
						 tradeOrder.getNumberOfShares() +" shares at market ");
			}
			else {
				if (tradeOrder.getPrice() == 0.0d)
					tradeOrder.setPrice(brokerage.getStock(tradeOrder.getStockSymbol()).getHighestSell());
				addMail("New order: Sell " + tradeOrder.getStockSymbol() + " (" + brokerage.getCompanyName(tradeOrder.getStockSymbol()) + ")\r\n" + 
						tradeOrder.getNumberOfShares() + " shares at market ");
			}
		}
		else
			if (tradeOrder.isBuying()) {
				if (tradeOrder.getPrice() == 0.0d)
					tradeOrder.setPrice(brokerage.getStock(tradeOrder.getStockSymbol()).getLowestSell());
				addMail("New order:  Buy " + tradeOrder.getStockSymbol() + " (" + brokerage.getCompanyName(tradeOrder.getStockSymbol()) + ")\r\n" + 
						tradeOrder.getNumberOfShares() + " shares at " + tradeOrder.getPrice());
			}
			else {
				if (tradeOrder.getPrice() == 0.0d)
					tradeOrder.setPrice(brokerage.getStock(tradeOrder.getStockSymbol()).getHighestSell());
				addMail("New order:  Sell " + tradeOrder.getStockSymbol() + " (" + brokerage.getCompanyName(tradeOrder.getStockSymbol()) + ")\r\n" + 
						tradeOrder.getNumberOfShares() + " shares at " + tradeOrder.getPrice());
			}
		brokerage.placeOrder(tradeOrder);

	}
	//These methods allow TraderWindow to access specific information of the user  ^^^

	public void addMail(String message) {
		mailbox.add(message);
		getMail();
		
	}
	
	public void getMail() {
		tw.showMessage(mailbox.removeLast());
	}
	
	public void setQuote(String q) {
		quote = q;
	}
	
	public void getQuote(String smbl) {
		addMail(brokerage.getQuote(smbl));
	}
	
	public Brokerage getBrokerage() {
		return brokerage;
	}

	public String getPassword() {
		return password;
	}
	
	public int compareTo(Trader t) {
		return getName().compareTo(t.getName());
	}
	
	public boolean equals(Object t) {
		if (t instanceof Trader)
			return getName().equals(((Trader) t).getName());
		return false;
	}
	
}
	
