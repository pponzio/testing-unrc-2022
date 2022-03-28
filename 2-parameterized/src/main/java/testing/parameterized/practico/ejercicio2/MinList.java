package testing.parameterized.practico.ejercicio2;
// Adapted from Introduction to Software Testing's example 
// Original authors: Paul Ammann & Jeff Offutt

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MinList<T extends Comparable<? super T>> extends ArrayList<T> {
	
	private static final long serialVersionUID = 6049758342913449752L;

	public MinList(Collection<T> res) {
		addAll(res);
	}

/**
 * Returns the mininum element in a list
 * @param list Comparable list of elements to search
 * @return the minimum element in the list
 * @throws NullPointerException if list is null or
 *         if any list elements are null
 * @throws ClassCastException if list elements are not mutually comparable
 * @throws IllegalArgumentException if list is empty
 */
	public T min () {
		if (this.size() == 0) {
			throw new IllegalArgumentException ("Min.min");
		}

		Iterator<T> itr = this.iterator();
		T result = itr.next();

		if (result == null) throw new NullPointerException ("Min.min");

		while (itr.hasNext()) {   
			// throws NPE, CCE as needed
			T comp = itr.next();
			if (comp.compareTo (result) < 0) {
				result = comp;
			}
		}
		return result;
	}

}