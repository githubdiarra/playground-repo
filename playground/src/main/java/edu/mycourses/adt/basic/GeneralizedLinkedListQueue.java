/**
 * 
 */
package edu.mycourses.adt.basic;

/**
 * @author Ibrahima Diarra
 *
 */
public class GeneralizedLinkedListQueue <T> implements GeneralizedQueue<T>{

	private LinkedList<T> list = new LinkedList<T>();
	
	public GeneralizedLinkedListQueue(){
		
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void insert(T item) {
		list.insertAtEnd(item);
	}

	@Override
	public T delete(int k) {
		int i = list.size() - k;
		return list.deleteKth(i);
	}
}
