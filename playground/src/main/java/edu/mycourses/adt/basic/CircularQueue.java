/**
 * 
 */
package edu.mycourses.adt.basic;

import java.util.Iterator;

/**
 * @author Ibrahima Diarra
 * 
 */
public class CircularQueue <T> implements Iterable<T>{
	
	private Node last;
	private int N = 0;
	
	public void enqueue(T item){
		Node newnode = new Node();
		newnode.item = item;
		if(last == null){
			last = newnode;
			last.next = last;
		}else{
			final Node old = last;
			newnode.next = last.next;
			last = newnode;
			old.next = last;
		}
		N++;
	}

	public T dequeue() {
		if (isEmpty())
			return null;
		T item = null;
		if (last == last.next) {
			item = last.item;
			last = null;
		} else {
			item = last.next.item;
			last.next = last.next.next;
		}
		N--;
		return item;
	}
	
	public int size(){
		return N;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	private class Node {
		T item;
		Node next;

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [");
			if (item != null)
				builder.append("item=").append(item).append(", ");
			if (next != null)
				builder.append("next=").append(next);
			builder.append("]");
			return builder.toString();
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T>{
		
		private Node current = null;
		
		public ListIterator() {
			if (last != null)
				current = last.next;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			T item = current.item;
			if (current == last)
				current = null;
			else
				current = current.next;
			return item;
		}

		@Override
		public void remove() {
			
		}
		
	}
}
