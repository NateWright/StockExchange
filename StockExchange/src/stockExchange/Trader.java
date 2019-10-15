package stockExchange;

import java.util.LinkedList;


public class Trader {
	private String name;
	private LinkedList<String> mailbox;
	private showMessage msg;
	
//No args constructor to allow for blank slates	
public Trader() {
	
}

//These methods allow TraderWindow to access specific information of the user 
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

public void mail(String message) {
	mailbox.add(message);
	while (!mailbox.isEmpty()) {
	showMessage(mailbox.get(1));
	}
}
}
