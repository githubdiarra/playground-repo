/**
 * 
 */
package edu.mycourses.util;

/**
 * @author Ibrahima Diarra
 * 
 */
public class StopWatch {

	final long start;

	public StopWatch() {
		start = System.currentTimeMillis();
	}

	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start) / 1000d;
	}
}
