/**
 * 
 */
package edu.lambda;

/**
 * @author Ibrahima Diarra
 *
 */
public class Chapter2 {
	
	ThreadLocal<String> name = ThreadLocal.withInitial(()-> "Ibrahima");
}
