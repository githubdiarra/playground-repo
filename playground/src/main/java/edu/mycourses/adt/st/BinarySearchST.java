/**
 * 
 */
package edu.mycourses.adt.st;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ibrahima Diarra
 *
 */
public class BinarySearchST<K extends Comparable<K>, V> implements OrderedST<K, V>{
	
	private K[] keys;
	private V[] values;
	private int N;

	@SuppressWarnings("unchecked")
	public BinarySearchST(int N) {
		keys = (K[]) new Comparable[N];
		values = (V[]) new Object[N];
	}
	
	@Override
	public void put(K key, V value) {
		checkArrays();
		int rank = rank(key);
		if (rank < N && key.compareTo(keys[rank]) == 0) {
			values[rank] = value;
			return;
		}
		for (int j = N; j > rank; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[rank] = key;
		values[rank] = value;
		N++;
	}

	@Override
	public V get(K key) {
		if (isEmpty())
			return null;
		int rank = rank(key);
		if (rank < N && key.compareTo(keys[rank]) == 0)
			return values[rank];
		return null;
	}

	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(K key) {
		int r = rank(key);
		return !isEmpty() && r < N && key.compareTo(keys[r]) == 0;
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
	public Iterable<K> keys() {
		return keys(min(), max());
	}

	@Override
	public K min() {
		return keys[0];
	}

	@Override
	public K max() {
		return keys[N - 1];
	}

	@Override
	public K floor(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K ceiling(K key) {
		return keys[rank(key)];
	}

	@Override
	public int rank(K key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int comp = key.compareTo(keys[mid]);
			if (comp < 0)
				hi = mid - 1;
			else if (comp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}

	@Override
	public K select(int k) {
		return keys[k];
	}

	@Override
	public void deleteMin() {
		delete(min());
	}

	@Override
	public void deleteMax() {
		delete(max());
	}

	@Override
	public int size(K lo, K hi) {
		return rank(hi) - rank(lo);
	}

	@Override
	public Iterable<K> keys(K lo, K hi) {
		int rl = rank(lo), rh = rank(hi);
		List<K> iterable = new ArrayList<K>(rh - rl);
		for (int i = rl; i < rh; i++)
			iterable.add(keys[i]);
		if (contains(keys[rh]))
			iterable.add(keys[rh]);
		return iterable;
	}
	
	private void checkArrays() {
		if (keys.length == N) {
			keys = Arrays.copyOf(keys, N * 2);
			values = Arrays.copyOf(values, N * 2);
		}
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("BinarySearchST [");
		if (keys != null)
			builder.append("keys=").append(
					Arrays.asList(keys).subList(0,
							Math.min(keys.length, maxLen)));
		builder.append("]");
		return builder.toString();
	}
}
