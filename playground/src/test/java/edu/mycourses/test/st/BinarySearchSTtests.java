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
	
	BinarySearchST<Character, Integer> st = new BinarySearchST<Character, Integer>(20);
	
	@Before
	public void init() {
		char[] chars = "bcd".toCharArray();
		for(int i = 0; i < chars.length; i++)
			st.put(chars[i], i);
	}
	
	@Test
	public void testContains() {
		assertTrue(st.contains('a'));
	}
	
	@Test
	public void testget() {
		int mango = st.get('b');
		assertTrue(mango >= 0);
	}
	
	@Test
	public void testceil() {
		Character ceil = st.ceiling('j');
		assertTrue(ceil != null && ceil >= 0);
	}
	
	@Test
	public void testfloor() {
		Character floor = st.floor('a');
		assertTrue(floor >= 0);
	}
}
