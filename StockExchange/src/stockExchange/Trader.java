package stockExchange;

import java.util.LinkedList;


public class Trader {
	private String name;
	private LinkedList<String> mailbox;
	private TraderWindow tw;
	private String password;
	private String quote;
	
	//No args constructor to allow for blank slates	
	public Trader(String n, String p) {
		name = n;
		password = p;
	}

//	These methods allow TraderWindow to access specific information of the user 
	public String getName() {
		return name;
	}

	public void quit() {

	}

	public void getQuote(String quote) {
	
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
	
	public String getQuote() {
		return quote;
	}

	public String getPassword() {
		return password;
	}
	
}
	
