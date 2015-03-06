package edu.mycourses.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.mycourses.adt.basic.RingBuffer;

public class RingBufferTest {

	@Test
	public void enqueueTest(){
		RingBuffer<Integer> b = new RingBuffer<Integer>(11);
		for(int x = 0; x < 25; x++)
			b.enqueue(x);
		assertTrue(b.isFull());
	}
	
	@Test
	public void dequeueTest(){
		RingBuffer<Integer> b = new RingBuffer<Integer>(11);
		for(int x = 0; x < 25; x++)
			b.enqueue(x);
		for(int x = 0; x < 25; x++)
			b.dequeue();
		assertTrue(b.isEmpty());
	}
}
