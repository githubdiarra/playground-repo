/**
 * 
 */
package edu.mycourses.adt.client;

import edu.mycourses.adt.basic.LinkedList;

/**
 * @author Ibrahima Diarra
 *
 */
public class MoveToFront <T>{

	private LinkedList<T> list = new LinkedList<T>();
	
	public MoveToFront(){	
	}
	
	public void insert(final T item){
		remove(item);
		list.insertAtBeginning(item);
	}
	
	public T getFirst(){
		return list.getFirst();
	}
	
	private void remove(final T item){
		int index = indexOf(item);
		if(index != -1)
			list.deleteKth(index);
	}

	private int indexOf(T item) {
		int count = 0;
		boolean found = false;
		for(T c : list){
			count++;
			if(c == item){
				found = true;
				break;
			}
		}
		return found == true? count : -1 ;
	}
}
