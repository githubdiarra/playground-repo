/**
 * 
 */
package edu.mycourses.test.st;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.mycourses.adt.st.BinarySearchTreeST;

/**
 * @author Ibrahima Diarra
 *
 */
public class BinarySearchTreeSTtests {

	BinarySearchTreeST<Character, Integer> st = new BinarySearchTreeST<Character, Integer>();
	final String word = "searchexample";
	
	@Before
	public void init() {
		char[] chars = word.toCharArray();
		for(int i = 0; i < chars.length; i++)
			st.put(chars[i], i);
	}
	
	@Test
	public void testsize() {
		int size = st.size();
		assertTrue(size > 0);
	}
	
	@Test
	public void testget() {
		Integer e = st.get('s');
		assertTrue(e != null);
	}
	
	@Test
	public void testmin() {
		Character min = st.min();
		assertTrue(min != null);
	}
	
	@Test
	public void testmax() {
		Character max = st.max();
		assertTrue(max != null);
	}
	
	@Test
	public void testrank() {
			int p = st.rank('p');
		assertTrue(p < word.length());
	}
}
