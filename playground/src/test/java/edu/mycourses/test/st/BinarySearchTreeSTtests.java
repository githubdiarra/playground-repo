/**
 * 
 */
package edu.mycourses.test.st;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.mycourses.adt.st.OrderedST;
import edu.mycourses.adt.st.RedBlackBinarySearchTreeST;

/**
 * @author Ibrahima Diarra
 *
 */
public class BinarySearchTreeSTtests {

	OrderedST<Character, Integer> st = new RedBlackBinarySearchTreeST<Character, Integer>();
	//OrderedST<Character, Integer> st = new BinarySearchTreeST<Character, Integer>();
	final String word = "searchexample";
	//final String word = "abcdefghijklmnopqrstuvwxyz";
	//final String word = "cba";
	
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
		int p = st.rank('x');
		assertTrue(p < word.length());
	}
	
	@Test
	public void testselect() {
		Character c = st.select(0);
		assertTrue(c != null);
	}
	
	@Test
	public void testkeys() {
		Iterable<Character> keys = st.keys();
		assertTrue(keys.iterator().hasNext());
	}
	
	@Test
	public void testrangsize() {
		int s = st.size('a', 'x');
		assertTrue(s > 0);
	}
	
	@Test
	public void testfloor() {
		char f = st.floor('p');
		assertTrue(f > 0);
	}
	
	@Test
	public void testceiling() {
		char f = st.ceiling('l');
		assertTrue(f > 0);
	}
	
	@Test
	public void testdeleteMin() {
		st.deleteMin();
		char f = st.select(0);
		assertTrue(f > 0);
	}
	
	@Test
	public void testdeleteMax() {
		st.deleteMax();
		char f = st.select(0);
		assertTrue(f > 0);
	}
	
	@Test
	public void testprintlevel() {
		st.printByLevel();
	}
}
