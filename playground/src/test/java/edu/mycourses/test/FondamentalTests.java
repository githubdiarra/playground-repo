/**
 * 
 */
package edu.mycourses.test;

import static org.junit.Assert.*;

import org.junit.Test;

import static edu.mycourses.adt.client.ADTClient.*;

/**
 * @author Ibrahima Diarra
 *
 */
public class FondamentalTests {

	@Test
	public void parenthesesTest(){
		assertTrue(checkParentheses("[()]{}{[()()]()}"));
		assertFalse(checkParentheses("[(])"));
		assertFalse(checkParentheses(")("));
	}
	
	@Test
	public void positiveIntBinaryTest(){
		System.out.println("binary 50: " + positiveIntBinary(50));
		System.out.println("binary 48: " + positiveIntBinary(48));
		System.out.println("binary 125860: " + positiveIntBinary(125860));
		System.out.println("binary -44: " + positiveIntBinary(-44));
		assertTrue(true);
	}
	
	@Test
	public void addLeftParenthesis(){
		final String input = "1 + 2 ) * 3 + 4 ))";
		System.out.println("Added left parentheses");
		System.out.println(input);
		System.out.println(balanceRightParenthesis(input));
		System.out.println("Infix to Postfix: " + infixToPostfix(balanceRightParenthesis(input)));
		System.out.println("Result: " + evaluatePostfix(infixToPostfix(balanceRightParenthesis(input))));
	}
}
