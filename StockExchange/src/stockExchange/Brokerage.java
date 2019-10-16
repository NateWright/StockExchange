package stockExchange;

import java.util.TreeMap;
import java.util.TreeSet;

public class Brokerage {

		private TreeMap<String, Trader> registered;
		private TreeSet<Trader> loggedIn;
	
	//Constructor
	public Brokerage()
	{
		
	}
	
		//Registers a user
		public void addUser(String userName, Trader trader)
		{
		 registered.put(userName, trader);
		}
		
		//Logs in a user
		public void login(String userName, Trader trader)
		{
		 loggedIn.add(registered.get(userName));
		}
	
}
