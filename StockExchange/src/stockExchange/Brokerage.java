package stockExchange;

import java.util.TreeMap;
import java.util.TreeSet;

public class Brokerage implements Login {

		private TreeMap<String, Trader> registered;
		private TreeSet<Trader> loggedIn;
		private StockExchange se;
	
	public Brokerage(StockExchange test)
	{
		
		registered = new TreeMap<>();
		loggedIn = new TreeSet<>();
		se = test;
	}
		
	public int addUser(String userName, String password)
	{
		if (userName.length() < 4 || userName.length() > 10)
			return -1;
		if (password.length() < 2 || password.length() > 10)
			return -2;
		if (registered.containsKey(userName))
			return -3;
		
		registered.put(userName, new Trader(userName, password, this));
		return 0;
	}
	
	public int login(String userName, String password)
	{
		if (!userName.contains(userName))
			return -1;
		if (!registered.get(userName).getPassword().equals(password))
			return -2;
		if (loggedIn.contains(registered.get(userName)))
			return -3;
		
		Trader t = registered.get(userName);
		loggedIn.add(t);
		t.showWindow();
		t.addMail("Welcome to SafeTrade, " + t.getName() + "!");
		return 0;
	}
	
	public void logout(Trader userName) {
		loggedIn.remove(userName);
	}
	
	public String getQuote(String smbl) {
		return se.getStock(smbl).toString();
	}
	
	public String getCompanyName(String smbl) {
		return se.getStock(smbl).getCompanyName();
	}
	
	public void placeOrder(TradeOrder to) {
		se.placeOrder(to);
	}
	
}
