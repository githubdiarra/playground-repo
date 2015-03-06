/**
 * 
 */
package edu.mycourses.adt.basic;

/**
 * @author Ibrahima Diarra
 * 
 */
@SuppressWarnings("unchecked")
public class GeneralizedArrayQueue<T> implements GeneralizedQueue<T> {

	private T[] a;
	private int tail;
	private int N;
	
	public GeneralizedArrayQueue(int capacity) {
		a = (T[]) new Object[capacity];
		tail = 0;
		N = 0;
	}

	@Override
	public boolean isEmpty() {
		return tail == 0;
	}

	@Override
	public void insert(T item) {
		if(tail == a.length)
			resize(2 * a.length);
		a[tail++] = item;
		N++;
	}

	private void resize(int max) {
		T[] temp = (T[]) new Object[max];
		for (int x = 0; x < tail; x++)
			temp[x] = a[x];
		a = temp;
		tail = N;
	}

	@Override
	public T delete(int k) {
		int i = tail - k;
		T item = a[i];
		a[i] = null;
		N--;
		return item;
	}

}
