/**
 * 
 */
package edu.mycourses.adt.basic;

import java.util.Iterator;

/**
 * @author Ibrahima Diarra
 *
 */
public class LinkedList<T> implements Iterable<T>{

	private Node first;
	private Node last;
	private int N = 0;
	
	public void insertAtEnd(T item){
		if (isEmpty()) {
			addTolast(item);
			first = last;
		} else {
			insertItemAtEnd(item);
		}
		N++;
	}
	
	private void insertItemAtEnd(T item) {
		final Node old = last;
		addTolast(item);
		old.next = last;
	}

	private void addTolast(final T item){
		last = new Node();
		last.item = item;
	}
	
	public void insertAtBeginning(T item) {
		if (isEmpty()) {
			addTofirst(item);
		} else {
			insertAtbeginning(item);
		}
		N++;
	}
	
	private void addTofirst(final T item){
		first = new Node();
		first.item = item;
	}
	
	private void insertAtbeginning(T item) {
		final Node old = first;
		addTofirst(item);
		first.next = old;
	}
	
	public void insertAfter(final Node one, final Node two){
		if(one == null || two == null) 
			return;
		two.next = one.next;
		one.next = two;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	private Integer max(Node first) {
		if (first == null)
			return 0;
		Integer max = (Integer) first.item;
		Integer val = 0;
		for (Node n = first; n != null; n = n.next) {
			val = (Integer) n.item;
			if (val.compareTo(max) > 0)
				max = val;
		}
		return max;
	}
	
	public Integer max(){
		return max(first);
	}
	
	private Integer max(Node first, Integer max){
		if(first == null)
			return max;
		Integer temp = (Integer) first.item;
		Integer nextmax = temp > max? temp : max;
		return max(first.next, nextmax);
	}

	public Integer maxr(){
		return max(first, 0);
	}
	
	public T removeFirst() {
		if (isEmpty())
			return null;
		T item = first.item;
		if (first.next == null) {
			first = null;
			last = first;
		} else {
			first = first.next;
		}
		N--;
		return item;
	}
	
	private T removeAfter(final Node node){
		Node n = null;
		for(n = first; n != null; n = n.next){
			if(n.item.equals(node.item))
				break;
		}
		if(n == null || n.next == null)
			return null;
		T item = n.next.item;
		n.next = n.next.next;
		return item;
	}
	
	public boolean removeAfter(T item) {
		final Node node = new Node();
		node.item = item;
		T result = removeAfter(node);
		return result != null;
	}
	
	public T removeLast(){
		return deleteKth(N);
	}
	
	public T deleteKth(int k){
		Node current = null;
		Node previous = null;
		int c = 0;
		boolean found = false;
		for(Node n = first; n != null; n = n.next){
			if(current != null) previous = current;
			current = n;
			c++;
			if(c == k){
				found = true;
				break;
			}
		}
		
		if(!found) return null;
		
		final T item = current.item;
		if(previous == null)
			first = null;
		else
			previous.next = previous.next.next;
		N--;
		return item;
	}
	
	public T getFirst() {
		if (isEmpty())
			return null;
		return first.item;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LinkedList [");
		if (first != null)
			builder.append("first=").append(first);
		builder.append("]");
		return builder.toString();
	}

	private class Node{
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

		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			final T item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
		}
		
	}
}
