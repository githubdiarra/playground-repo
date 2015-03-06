/**
 * 
 */
package edu.mycourses.adt.basic;

import java.util.Iterator;

/**
 * @author Ibrahima Diarra
 *
 */
public class LinkedListQueue<T> implements Queue<T>{
	
	private LinkedList<T> list = new LinkedList<T>();
	
	public LinkedListQueue(){
		
	}
	
	public LinkedListQueue(final LinkedListQueue<T> q) {
		this();
		int size = q.size();
		int count  = 0;
		while (count < size) {
			final T item = q.dequeue();
			enqueue(item);
			q.enqueue(item);
			count++;
		}
	}
	
	public int size(){
		return list.size();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public void enqueue(T item){
		list.insertAtEnd(item);
	}
	
	public T dequeue(){
		return list.removeFirst();
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LinkedListQueue [");
		if (list != null)
			builder.append("list=").append(list);
		builder.append("]");
		return builder.toString();
	}
}
