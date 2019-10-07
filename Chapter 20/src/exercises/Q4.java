package exercises;

import java.util.Iterator;
import java.util.List;

public class Q4 {

	public <E> void appendA (List<E> list1, List<E> list2) {
		Iterator<E> iter = list2.iterator();
		while(iter.hasNext()) {
			list1.add(iter.next());
		}
	}
	
	public <E> void appendB (List<E> list1, List<E> list2) {
		for(E o: list2) {
			list1.add(o);
		}
	}
}
