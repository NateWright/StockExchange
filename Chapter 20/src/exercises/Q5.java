package exercises;

import java.util.*;


public class Q5 {

	public LinkedList<String> mix(List<String>list1, List<String> list2){
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		LinkedList<String> output = new LinkedList<String>();
		while(iter1.hasNext()) {
			output.add(iter1.next()); output.add(iter2.next());
		}
		return output;
	}
	/*
	public static void main(String args[]) {
		List<String> list1 = new ArrayList<String>() {
			{ 
                add("A"); 
                add("B"); 
                add("C"); 
            }
		};
		List<String> list2 = new ArrayList<String>() {
			{ 
                add("1"); 
                add("2"); 
                add("3"); 
            }
		};
		System.out.print(mix(list1,list2));
	}
	*/
}
