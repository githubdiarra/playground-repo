/**
 * 
 */
package edu.mycourses.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.mycourses.adt.client.MoveToFront;

/**
 * @author Ibrahima Diarra
 *
 */
public class MoveToFrontTest {

	char[] data = "We are heading next to South India in tow".toLowerCase().toCharArray();
	MoveToFront<Character> mvf = new MoveToFront<Character>();
	
	@Test
	public void moveToFrontTest(){
		for(Character c : data)
			mvf.insert(c);
		assertTrue(mvf.getFirst() == 'w');
	}
}
