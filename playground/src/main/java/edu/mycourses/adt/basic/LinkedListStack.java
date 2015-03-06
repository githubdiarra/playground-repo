/**
 * 
 */
package edu.mycourses.adt.basic;

import java.util.Iterator;

/**
 * @author Ibrahima Diarra
 *
 */
public class LinkedListStack <T> implements Stack<T>{
	
	private LinkedList<T> list = new LinkedList<T>();
	
	public LinkedListStack(){
		
	}
	
	public LinkedListStack(LinkedListStack<T> s){
		this();
		LinkedListStack<T> temp = new LinkedListStack<T>();
		for(T item : s)
			temp.push(item);
		for(T item : temp)
			push(item);
	}
	
	public int size(){
		return list.size();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public void push(T item){
		list.insertAtBeginning(item);
	}
	
	public T pop(){
		return list.removeFirst();
	}
	
	public T peek() {
		return list.getFirst();
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LinkedListStack [");
		if (list != null)
			builder.append("list=").append(list);
		builder.append("]");
		return builder.toString();
	}
}
