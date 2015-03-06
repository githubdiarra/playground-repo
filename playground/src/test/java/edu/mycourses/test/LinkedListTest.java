/**
 * 
 */
package edu.mycourses.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.mycourses.adt.basic.LinkedList;
import edu.mycourses.adt.client.ADTClient;

/**
 * @author Ibrahima Diarra
 *
 */
public class LinkedListTest {

	final private String[] data = new String[]{"to", "to", "to"};
	LinkedList<String> list = new LinkedList<String>();
	LinkedList<Integer> ilist = new LinkedList<Integer>();
	private static final Logger L = LogManager.getLogger(LinkedListTest.class);
	
	@Before
	public void setup(){	
		for(String s : data)
			list.insertAtBeginning(s);
		for(int x = 4; x <= 96; x++)
			ilist.insertAtBeginning(x);
	}
	
	@Test
	public final void testInertAtBeginning() {
		assertTrue(list.size() == data.length);
	}
	
	@Test
	public final void testInertAtEnd() {
		LinkedList<String> list = new LinkedList<String>();
		for(String s : data){
			list.insertAtEnd(s);
		}
		assertNotNull(list);
	}

	@Test
	public void testRemovelast(){
		L.debug("Removing last item");
		L.debug("Removed: " + list.removeLast());
	}
	
	@Test
	public void deleteKth(){
		L.debug("Deleting: " + list.deleteKth(2));
		L.debug("size: " + list.size());
	}
	
	@Test
	public void linkedListSearchTest(){
		final String key = "mk";
		L.debug("Searching: " + key);
		L.debug(ADTClient.find(list, key));
	}
	
	@Test
	public void linkedListRemoveTest(){
		final String key = data[0];
		L.debug("Removing: " + key);
		L.debug("Total removed: " +ADTClient.remove(list, key));
	}
	
	@Test
	public void linkedlistMaxIntTest(){
		L.debug("Max: " + ilist.max());
		L.debug("Recursive Max: " + ilist.maxr());
	}
}
