/**
 * 
 */
package edu.mycourses.adt.st;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ibrahima Diarra
 * 
 */
public class RedBlackBinarySearchTreeST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
	
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	@Override
	public void put(Key key, Value value) {
		root = put(root, key, value);
		root.color = BLACK;
	}

	private Node put(Node x, Key key, Value value) {
		if (x == null)
			return new Node(key, value, 1, RED);
		int comp = key.compareTo(x.key);
		if (comp < 0)
			x.left = put(x.left, key, value);
		else if (comp > 0)
			x.right = put(x.right, key, value);
		else
			x.value = value;
		// Start Red-black operations
		if (isRed(x.right) && !isRed(x.left))
			x = rotateLeft(x);
		if (isRed(x.left) && isRed(x.left.left))
			x = rotateRight(x);
		if (isRed(x.left) && isRed(x.right))
			flipColors(x);
		// End Red-black operations
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
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null)
			return null;
		int comp = key.compareTo(x.key);
		if (comp < 0)
			x.left = delete(x.left, key);
		else if (comp > 0)
			x.right = delete(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
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
		if (x == null)
			return 0;
		return x.N;
	}

	@Override
	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	@Override
	public Key min() {
		return min(root).key;
	}

	private Node min(Node x) {
		if (x == null)
			return null;
		if (x.left == null)
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
		Node x = floor(root, key);
		if (x == null)
			return null;
		return x.key;
	}

	private Node floor(Node x, Key key) {
		if (x == null)
			return null;
		int comp = key.compareTo(x.key);
		if (comp == 0)
			return x;
		if (comp < 0)
			return floor(x.left, key);
		Node t = floor(x.right, key);
		if (t != null)
			return t;
		else
			return x;
	}

	@Override
	public Key ceiling(Key key) {
		Node x = ceiling(root, key);
		if (x == null)
			return null;
		return x.key;
	}

	private Node ceiling(Node x, Key key) {
		if (x == null)
			return null;
		int comp = key.compareTo(x.key);
		if (comp == 0)
			return x;
		if (comp > 0)
			return ceiling(x.right, key);
		Node t = ceiling(x.left, key);
		if (t != null)
			return t;
		else
			return x;
	}

	@Override
	public int rank(Key key) {
		return rank(root, key);
	}

	private int rank(Node x, Key key) {
		if (x == null)
			return 0;
		int comp = key.compareTo(x.key);
		if (comp < 0)
			return rank(x.left, key);
		else if (comp > 0)
			return 1 + size(x.left) + rank(x.right, key);
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
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	@Override
	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x.right == null)
			return x.left;
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	@Override
	public int size(Key lo, Key hi) {
		return rank(hi) - rank(lo);
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) {
		List<Key> keys = new ArrayList<Key>(root.N);
		collectKeys(root, keys, lo, hi);
		return keys;
	}

	private void collectKeys(Node x, List<Key> keys, Key lo, Key hi) {
		if (x == null)
			return;
		int complo = lo.compareTo(x.key);
		int comphi = hi.compareTo(x.key);
		if (complo < 0)
			collectKeys(x.left, keys, lo, hi);
		if (complo <= 0 && comphi >= 0)
			keys.add(x.key);
		if (comphi > 0)
			collectKeys(x.right, keys, lo, hi);
	}

	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	private boolean isRed(Node x) {
		if (x == null)
			return false;
		return x.color == RED;
	}
	
	public void printByLevel() {
		printByLevel(root);
	}

	private void printByLevel(Node x) {
		Queue<Node> nodes = new LinkedList<Node>();
		nodes.add(x);
		final Node blank = new Node(null, null, -1, BLACK);
		nodes.add(blank);
		int level = 1;
		while (true) {
			Node n = nodes.poll();
			if (nodes.isEmpty())
				break;
			if (n == blank) {
				nodes.add(blank);
				level++;
			} else {
				System.out.println(level + "  " + n.key);
				if (n.left != null)
					nodes.add(n.left);
				if (n.right != null)
					nodes.add(n.right);
			}
		}
	}

	private class Node {

		 Key key;
		 Value value;
		 Node left;
		 Node right;
		 int N;
		 boolean color;

		public Node(Key key, Value value, int N, boolean color) {
			this.key = key;
			this.value = value;
			this.N = N;
			this.color = color;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [");
			if (key != null)
				builder.append("key=").append(key).append(", ");
			if (value != null)
				builder.append("value=").append(value).append(", ");
			builder.append("N=").append(N).append(", color=").append(color)
					.append("]");
			return builder.toString();
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BinarySearchTreeST [");
		if (root != null)
			builder.append("root=").append(root);
		builder.append("]");
		return builder.toString();
	}
}
