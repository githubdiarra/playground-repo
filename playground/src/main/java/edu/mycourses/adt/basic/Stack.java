package edu.mycourses.adt.basic;

public interface Stack<T> extends Iterable<T> {

	boolean isEmpty();

	int size();

	void push(T item);

	T pop();

}