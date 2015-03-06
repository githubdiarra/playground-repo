/**
 * 
 */
package edu.mycourses.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.mycourses.adt.basic.LinkedListQueue;

/**
 * @author Ibrahima Diarra
 * 
 */
public class QueueTest {

	@Test
	public void copyQueueTest() {
		LinkedListQueue<Integer> q = new LinkedListQueue<Integer>();
		for (int x = 0; x < 8; x++)
			q.enqueue(x);
		LinkedListQueue<Integer> r = new LinkedListQueue<Integer>(q);
		q.dequeue();
		q.dequeue();
		r.enqueue(8);
		assertTrue(r.size() > q.size());
	}
}
