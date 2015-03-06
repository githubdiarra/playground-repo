package edu.mycourses.adt.client;

import edu.mycourses.adt.basic.ArrayQueue;
import edu.mycourses.adt.basic.Queue;

public class Josephus {

	public static void findSafeSit(final int position, final int size) {
		Queue<Integer> q1 = new ArrayQueue<Integer>();
		for (int x = 0; x < size; x++)
			q1.enqueue(x);
		int count = 0;
		while (q1.size() >= position) {
			count++;
			int pos = q1.dequeue();
			if (count == position) {
				System.out.print(pos + " ");
				count = 0;
			} else {
				q1.enqueue(pos);
			}
		}
		while (!q1.isEmpty())
			System.out.print(q1.dequeue() + " ");
	}
}
