/**
 * 
 */
package edu.mycourses.test;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.mycourses.adt.basic.CircularQueue;

/**
 * @author Ibrahima Diarra
 *
 */
public class CircularQueueTest {

	final private String[] data = new String[]{"to", "be", "or"};
	final private CircularQueue<String> queue = new CircularQueue<String>();
	final private Logger logger = LogManager.getLogger(CircularQueueTest.class);
	
	
	@Before
	public void setUp() throws Exception {
		for(String d : data)
			queue.enqueue(d);
	}

	@Test
	public final void testEnqueue() {
		assertTrue(!queue.isEmpty());
	}

	@Test
	public final void testDequeue() {
		while(!queue.isEmpty())
			logger.debug(queue.dequeue());
		assertTrue(queue.isEmpty());
	}

	@Test
	public final void testSize() {
		assertTrue(queue.size() > 0);
	}
	
	@Test
	public final void testIterator() {
		for (String s : queue)
			logger.debug(s);
	}
}
