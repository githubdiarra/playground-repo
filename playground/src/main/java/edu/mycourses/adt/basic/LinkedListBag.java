/**
 * 
 */
package edu.mycourses.adt.basic;

import java.util.Iterator;

/**
 * @author Ibrahima Diarra
 *
 */
public class LinkedListBag <T> implements Bag<T>{

	private LinkedList<T> list = new LinkedList<T>();
	
	/* (non-Javadoc)
	 * @see edu.mycourses.adt.basic.Bag#size()
	 */
	@Override
	public int size(){
		return list.size();
	}
	
	/* (non-Javadoc)
	 * @see edu.mycourses.adt.basic.Bag#isEmpty()
	 */
	@Override
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	/* (non-Javadoc)
	 * @see edu.mycourses.adt.basic.Bag#add(T)
	 */
	@Override
	public void add(T item){
		list.insertAtBeginning(item);
	}
	
	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LinkedListBag [");
		if (list != null)
			builder.append("list=").append(list);
		builder.append("]");
		return builder.toString();
	}

}
