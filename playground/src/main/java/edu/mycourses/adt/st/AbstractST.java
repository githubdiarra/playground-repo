package edu.mycourses.adt.st;

public abstract class AbstractST<Key, Value> implements ST<Key, Value>{

	public AbstractST() {
	
	}

	@Override
	public abstract void put(Key key, Value value);

	@Override
	public abstract Value get(Key key);

	@Override
	public void delete(Key key) {
		put(key, null);
	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public abstract int size();

	@Override
	public abstract Iterable<Key> keys();

}
