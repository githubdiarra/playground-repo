/**
 * 
 */
package edu.mycourses.adt.basic;

import java.util.Iterator;

/**
 * @author Ibrahima Diarra
 * 
 */
@SuppressWarnings("unchecked")
public class ArrayStack<T> implements Stack<T> {

	private T[] a;
	private int N;

	public ArrayStack(int capacity) {
		a = (T[]) new Object[capacity];
		N = 0;
	}

	public ArrayStack() {
		this(10);
	}

	public ArrayStack(ArrayStack<T> s){
		this();
		ArrayStack<T> temp = new ArrayStack<T>();
		for(T item : s)
			temp.push(item);
		for(T item : temp)
			push(item);
	}
	
	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public void push(T item) {
		if (N == a.length)
			resize(2 * a.length);
		a[N++] = item;
	}

	@Override
	public T pop() {
		T item = a[--N];
		a[N] = null; // avoid loitoring
		if (N > 0 && N == a.length / 4)
			resize(a.length / 2);
		return item;
	}

	private void resize(int max) {
		T[] temp = (T[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}

	@Override
	public Iterator<T> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<T> {
		private int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public T next() {
			return a[--i];
		}

		@Override
		public void remove() {

		}

	}
}
