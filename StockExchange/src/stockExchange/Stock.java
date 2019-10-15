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
	private int lowestSell;
	private int HighestSell;
	private int volume;
	private Comparator<Integer> greatestFirst = (int1, int2) -> {
        return int1 - int2;
	};
	private PriorityQueue<Integer> buyStockQ = new PriorityQueue<>(greatestFirst);
	private PriorityQueue<Integer> sellStockQ = new PriorityQueue<>();
	
	
	//The Stock object for storing the details of a stock
	public Stock(String tik, String cName, int lSell, int hSell, int v) {
		tiker = tik;
		companyName = cName;
		lowestSell = lSell;
		HighestSell = hSell;
		volume = v;
	}
	public void buyStock(int price) {
		buyStockQ.add(price);
	}
	public void sellStock(int price) {
		sellStockQ.add(price);
	}
	
}
