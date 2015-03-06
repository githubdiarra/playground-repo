/**
 * 
 */
package edu.mycourses.adt.basic;

/**
 * @author Ibrahima Diarra
 * 
 */
public interface GeneralizedQueue<T> {

	boolean isEmpty();

	/**
	 * Add an Item
	 * 
	 * @param item
	 */
	void insert(T item);

	/**
	 * Delete and return the kth least recently inserted item.
	 * 
	 * @param k
	 * @return deleted item
	 */
	T delete(int k);
}
