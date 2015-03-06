/**
 * 
 */
package edu.mycourses.adt.client;


import edu.mycourses.adt.basic.ArrayQueue;
import edu.mycourses.adt.basic.ArrayStack;
import edu.mycourses.adt.basic.LinkedList;
import edu.mycourses.adt.basic.LinkedListStack;
import edu.mycourses.adt.basic.Queue;
import edu.mycourses.adt.basic.Stack;

/**
 * @author Ibrahima Diarra
 *
 */
public class ADTClient {

	/**
	 * 
	 * @param input
	 * @return
	 */
	public static boolean checkParentheses(final String input) {
		final Stack<Character> stack = new ArrayStack<Character>();
		final char[] tokens = input.toCharArray();
		for (Character token : tokens) {
			if (token == ')' && (stack.isEmpty() || stack.pop() != '('))
				return false;
			stack.push(token);
		}
		return true;
	}
	
	/**
	 * 
	 * @param N
	 * @return
	 */
	public static String positiveIntBinary(int N) {
		if (N < 1)
			return "";
		final LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
		while (N > 0) {
			stack.push(N % 2);
			N = N / 2;
		}
		StringBuilder bd = new StringBuilder();
		for (Integer i : stack) {
			bd.append(i);
		}
		return bd.toString();
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public static String balanceRightParenthesis(final String input) {
		LinkedListStack<Character> s1 = new LinkedListStack<Character>();
		LinkedListStack<Character> s2 = new LinkedListStack<Character>();
		final char[] data = input.toCharArray();
		int newItem = 0;
		for (Character d : data) {
			if(d == ' ') continue;
			if(d == ')'){
				s2.push(d);
				addLeftParenthesis(s1,s2,newItem);
				newItem = 0;
			}else{
				s1.push(d);
				newItem++;
			}
		}
		return formatExpression(s1);
	}
	
	private static void addLeftParenthesis(LinkedListStack<Character> s1, LinkedListStack<Character> s2, int pushCount){
		Character c = null;
		int count = 0;
		int threshold = pushCount > 2 ? 3 : 4;
		while(!s1.isEmpty()){
			c = s1.pop();
			s2.push(c);
			if(c == '(' || c == ')') count--;
			else count++;
			if(count == threshold) 
				break;
		}
		s1.push('(');
		while(!s2.isEmpty()){
			s1.push(s2.pop());
		}	
	}
	
	private static String formatExpression(final LinkedListStack<Character> stack){
		final LinkedListStack<Character> t = new LinkedListStack<Character>();
		for (Character e : stack)
			t.push(e);
		final StringBuilder bd = new StringBuilder();
		for(Character e : t)
			bd.append(e).append(" ");
		return bd.toString();
	}
	
	public static String infixToPostfix(final String input){
		final LinkedListStack<Character> op = new LinkedListStack<Character>();
		final Queue<Character> exp = new ArrayQueue<Character>();
		final char[] data = input.toCharArray();
		for(Character c : data){
			if(c == ' ') continue;
			if(c == '+' || c == '-' || c == '/' || c == '*')
				op.push(c);
			else if(c == ')'){
				exp.enqueue(op.pop());
			}else if (c != '('){
				exp.enqueue(c);
			}

		}
		final StringBuilder bd = new StringBuilder();
		for(Character e : exp)
			bd.append(e);
		return bd.toString();
	}
	
	public static int evaluatePostfix(final String input){
		final char[] data = input.toCharArray();
		final LinkedListStack<Integer> s = new LinkedListStack<Integer>();
		for(Character c : data){
			if(c == ' ') continue;
			if(c == '*')
				s.push(s.pop() * s.pop());
			else if(c == '/')
				s.push(s.pop() / s.pop());
			else if(c == '+')
				s.push(s.pop() + s.pop());
			else if(c == '-')
				s.push(s.pop() - s.pop());
			else
				s.push(Integer.valueOf(c.toString()));
			
		}
		return s.pop();
	}
	
	public static <T> LinkedListStack<T> copy(final LinkedListStack<T> stack){
		final LinkedListStack<T> s1 = new LinkedListStack<T>();
		final LinkedListStack<T> s2 = new LinkedListStack<T>();
		for(T item : stack)
			s1.push(item);
		for(T item : s1)
			s2.push(item);
		return s2;
	}
	
	public static <T> boolean find(final LinkedList<T> list, T item) {
		for (T e : list) {
			if (e.equals(item))
				return true;
		}
		return false;
	}
	
	public static <T> int remove(final LinkedList<T> list, T item) {
		T previous = null;
		T current = null;
		int count = 0;
		for (T i : list) {
			if (current != null)
				previous = current;
			current = i;
			if (current.equals(item)) {
				list.removeAfter(previous);
				count++;
			}
		}
		return count;
	}
}
