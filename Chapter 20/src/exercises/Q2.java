package exercises;

import java.util.List;

public class Q2 {

	public <E> void append (List<E> list1, List<E> list2) {
		while(list2.size()>0) {
			list1.add(list2.get(0));
			list2.remove(0);
		}
	}
}
