/**
 * 
 */
package edu.mycourses.adt.client;

import edu.mycourses.adt.basic.LinkedListStack;

/**
 * @author Ibrahima Diarra
 * 
 */
public class TextEditorBuffer {

	private LinkedListStack<Character> left = new LinkedListStack<Character>();
	private LinkedListStack<Character> right = new LinkedListStack<Character>();

	public TextEditorBuffer() {

	}

	public void insert(final Character character) {
		left.push(character);
	}

	public Character get() {
		return left.peek();
	}

	public Character delete() {
		return left.pop();
	}

	public void left(final int k) {
		int pos = k;
		while (pos > 0) {
			right.push(left.pop());
			pos--;
		}
	}

	public void right(final int k) {
		if (right.size() >= k) {
			int p = k;
			while (p > 0) {
				left.push(right.pop());
				p--;
			}
		}
	}

	public int size() {
		return left.size() + right.size();
	}
	
	public String text() {
		while (!right.isEmpty())
			left.push(right.pop());
		while (!left.isEmpty())
			right.push(left.pop());
		StringBuilder bd = new StringBuilder();
		for (Character c : right)
			bd.append(c);
		return bd.toString();
	}
}
