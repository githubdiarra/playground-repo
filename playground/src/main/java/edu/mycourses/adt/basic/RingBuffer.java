/**
 * 
 */
package edu.mycourses.adt.basic;

/**
 * @author Ibrahima Diarra
 * 
 */
public class RingBuffer<T> {

	private final T[] a;
	private int head;
	private int tail;
	private int N;

	@SuppressWarnings("unchecked")
	public RingBuffer(int capacity) {
		a = (T[]) new Object[capacity];
		head = 0;
		tail = 0;
		N = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public boolean isFull() {
		return N >= a.length;
	}

	public void enqueue(final T item) {
		a[tail++] = item;
		if (tail == a.length)
			tail = 0;
		N++;
	}

	public T dequeue() {
		final T item = a[head];
		a[head] = null;
		head++;
		if (head == a.length)
			head = 0;
		N--;
		return item;
	}
}
