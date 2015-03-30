/**
 * 
 */
package edu.lambda;

/**
 * @author Ibrahima Diarra
 *
 *Understanding Git
 */
public class Chapter2 {
	
	ThreadLocal<String> name = ThreadLocal.withInitial(()-> "Ibrahima");
}
