/**
 * 
 */
package edu.mycourses.adt.st;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ibrahima Diarra
 *
 */
public class BinarySearchTreeST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {

	private Node root;
	
	@Override
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node x, Key key, Value value) {
		if (x == null)
			return new Node(key, value, 1);
		int comp = key.compareTo(x.key);
		if (comp < 0)
			x.left = put(x.left, key, value);
		else if (comp > 0)
			x.right = put(x.right, key, value);
		else x.value = value;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	@Override
	public Value get(Key key) {
		return get(root, key).value;
	}

	private Node get(Node x, Key key) {
		if (x == null)
			return null;
		int comp = key.compareTo(x.key);
		if (comp < 0)
			return get(x.left, key);
		else if (comp > 0)
			return get(x.right, key);
		else
			return x;
	}

	@Override
	public void delete(Key key) {

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
	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if(x == null)
			return 0;
		return x.N;
	}

	@Override
	public Iterable<Key> keys() {
		List<Key> keys = new ArrayList<Key>(root.N);
		collectkeys(root, keys);
		return keys;
	}

	private void collectkeys(Node x, List<Key> keys) {
		if (x == null)
			return;
		collectkeys(x.left, keys);
		keys.add(x.key);
		collectkeys(x.right, keys);
	}

	@Override
	public Key min() {
		return min(root).key;
	}

	private Node min(Node x) {
		if (x == null)
			return null;
		if(x.left == null) 
			return x;
		else 
			return min(x.left);
	}

	@Override
	public Key max() {
		return max(root).key;
	}

	private Node max(Node x) {
		if (x == null)
			return null;
		if (x.right == null)
			return x;
		else
			return max(x.right);
	}

	@Override
	public Key floor(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key ceiling(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rank(Key key) {
		return rank(key, root);
	}


	private int rank(Key key, Node x) {
		if (x == null)
			return 0;
		int comp = key.compareTo(x.key);
		if (comp < 0)
			return rank(key, x.left);
		else if (comp > 0)
			return 1 + size(x.left) + rank(key, x.right);
		else
			return size(x.left);
	}

	@Override
	public Key select(int rank) {
		return select(root, rank).key;
	}

	private Node select(Node x, Integer k) {
		if (x == null)
			return null;
		int t = size(x.left);
		if (k < t)
			return select(x.left, k);
		else if (k > t)
			return select(x.right, k - t - 1);
		else
			return x;
	}

	@Override
	public void deleteMin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMax() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size(Key lo, Key hi) {
		return rank(hi) - rank(lo);
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return null;
	}

	protected void collectNodes(Node x, List<Node> nodes) {
		if (x == null)
			return;
		collectNodes(x.left, nodes);
		nodes.add(x);
		collectNodes(x.right, nodes);
	}

	private class Node{
		
		public Key key;
		public Value value;
		public Node left;
		public Node right;
		int N;
		
		public Node(Key key, Value value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [");
			if (key != null)
				builder.append("key=").append(key).append(", ");
			if (value != null)
				builder.append("value=").append(value).append(", ");
			builder.append("N=").append(N).append("]");
			return builder.toString();
		}
	}
}
