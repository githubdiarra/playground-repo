package edu.mycourses.adt.basic;

public interface Queue<T> extends Iterable<T> {

	boolean isEmpty();

	int size();

	void enqueue(T item);

	T dequeue();

}