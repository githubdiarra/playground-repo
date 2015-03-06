package edu.mycourses.adt.basic;

public interface Bag<T> extends Iterable<T> {

	int size();

	boolean isEmpty();

	void add(T item);

}