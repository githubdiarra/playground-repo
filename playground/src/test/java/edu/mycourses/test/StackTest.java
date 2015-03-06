/**
 * 
 */
package edu.mycourses.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.mycourses.adt.basic.ArrayStack;

/**
 * @author Ibrahima Diarra
 *
 */
public class StackTest {

	
	@Test
	public void copyStackTest(){
		ArrayStack<Integer> s = new ArrayStack<Integer>();
		for(int x = 0; x < 6; x++)
			s.push(x);
		ArrayStack<Integer> q = new ArrayStack<Integer>(s);
		s.pop();
		s.pop();
		q.push(6);
		assertTrue(s.size() < q.size());
	}
}
