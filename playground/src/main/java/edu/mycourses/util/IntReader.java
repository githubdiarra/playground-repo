/**
 * 
 */
package edu.mycourses.util;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Ibrahima Diarra
 *
 */
public class IntReader {

	private final Scanner scanner;
	
	public IntReader(final String filename){
		final InputStream is = Utils.getClassPathResource(filename);
		scanner = new Scanner(is);
	}
	
	public int readInt(){
		return scanner.nextInt();
	}
	
	public boolean isEmpty(){
		return !scanner.hasNext();
	}

}
