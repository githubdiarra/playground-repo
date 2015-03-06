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
public class ArrayQueue<T> implements Queue<T> {

	private T[] a;
	private int tail;
	private int head;

	public ArrayQueue(int capacity) {
		a = (T[]) new Object[capacity];
		tail = 0;
		head = 0;
	}

	public ArrayQueue(){
		this(10);
	}
	
	public ArrayQueue(final ArrayQueue<T> q) {
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
	
	@Override
	public boolean isEmpty() {
		return tail - head == 0;
	}

	@Override
	public int size() {
		return tail - head;
	}

	@Override
	public void enqueue(T item) {
		if (tail == a.length)
			resize(a.length * 2);
		a[tail++] = item;
	}

	@Override
	public T dequeue() {
		T item = a[head];
		a[head] = null; // avoid loitoring
		head++;
		if (head > 0 && size() == a.length / 4){
			resize(a.length / 2);
		}
		return item;
	}

	private void resize(int max) {
		T[] temp = (T[]) new Object[max];
		int size = size();
		for (int i = 0; i < size; i++, head++)
			temp[i] = a[head];
		a = temp;
		tail = size;
		head = 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<T> {

		int h = head;

		@Override
		public boolean hasNext() {
			return h < tail;
		}

		@Override
		public T next() {
			return a[h++];
		}

		@Override
		public void remove() {
		}
	}
}
