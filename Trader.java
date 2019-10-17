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
	}

//	These methods allow TraderWindow to access specific information of the user 
	public String getName() {
		return name;
	}

	public void quit() {

	}
	
	public void showWindow() {
		tw = new TraderWindow(this);		
	}

	public void placeOrder(TradeOrder tradeOrder) {
	
	}
	//These methods allow TraderWindow to access specific information of the user  ^^^

	public void addMail(String message) {
		mailbox.add(message);
		
	}
	
	public void getMail() {
		tw.showMessage(mailbox.getFirst());
	}
	
	public void setQuote(String q) {
		quote = q;
	}
	
	public String getQuote(String smbl) {
		return brokerage.getQuote(smbl);
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
	
