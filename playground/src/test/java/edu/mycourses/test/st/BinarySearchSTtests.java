/**
 * 
 */
package edu.mycourses.test.st;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.mycourses.adt.st.BinarySearchST;

/**
 * @author Ibrahima Diarra
 *
 */
public class BinarySearchSTtests {
	
	BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(20);
	
	@Before
	public void init() {
		st.put("grape", "grape".length());
		st.put("mango", "mango".length());
		st.put("Apple", "Apple".length());
	}
	
	@Test
	public void testContains() {
		assertTrue(st.contains("mango"));
	}
	
	@Test
	public void testget() {
		int mango = st.get("mango");
		assertTrue(mango == "mango".length());
	}
}
