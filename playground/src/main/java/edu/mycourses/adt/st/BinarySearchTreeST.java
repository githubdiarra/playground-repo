/**
 * 
 */
package edu.mycourses.adt.st;

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
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null)
			return null;
		int comp = key.compareTo(x.key);
		if (comp < 0)
			return get(x.left, key);
		else if (comp > 0)
			return get(x.right, key);
		else
			return x.value;
	}

	private Node getNode(Node x, Key key) {
		if (x == null)
			return null;
		int comp = key.compareTo(x.key);
		if (comp < 0)
			return getNode(x.left, key);
		else if (comp > 0)
			return getNode(x.right, key);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key min() {
		return min(root);
	}

	private Key min(Node x) {
		if(x == null) return null;
		Node left = x;
		while(left.left != null)
			left = left.left;
		return left.key;
	}

	@Override
	public Key max() {
		return max(root);
	}

	private Key max(Node x) {
		if(x == null) return null;
		Node right = x;
		while(right.right != null)
			right = right.right;
		return right.key;
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
		Node node = getNode(root, key);
		return node == null ? 0 : node.N;
	}

	@Override
	public Key select(int k) {
		return select(root, k);
	}

	private Key select(Node x, int k) {
		//if(x == null)
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return null;
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
