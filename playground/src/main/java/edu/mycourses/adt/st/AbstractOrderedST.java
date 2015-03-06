package edu.mycourses.adt.st;

public abstract class AbstractOrderedST<Key extends Comparable<Key>, Value> extends AbstractST<Key, Value> implements
		OrderedST<Key, Value> {

	@Override
	public abstract Key min();

	@Override
	public abstract Key max();

	@Override
	public abstract Key floor(Key key);

	@Override
	public abstract Key ceiling(Key key);

	@Override
	public abstract int rank(Key key);

	@Override
	public abstract Key select(int k);
	
	@Override
	public abstract Iterable<Key> keys(Key lo, Key hi);
	
	@Override
	public abstract Iterable<Key> keys();

	@Override
	public abstract void put(Key key, Value value);

	@Override
	public abstract Value get(Key key);
	
	@Override
	public void deleteMin() {
		delete(min());
	}

	@Override
	public void deleteMax() {
		delete(max());
	}

	@Override
	public int size(Key lo, Key hi) {
		if (hi.compareTo(lo) < 0)
			return 0;
		else if (contains(hi))
			return rank(hi) - rank(lo) + 1;
		else
			return rank(hi) - rank(lo);
	}

	@Override
	public int size() {
		return size(min(), max());
	}

}
