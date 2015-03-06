/**
 * 
 */
package edu.mycourses.test.uf;

import org.junit.Test;

import edu.mycourses.adt.basic.analysis.unionfind.UFClient;
import edu.mycourses.util.Utils;

/**
 * @author Ibrahima Diarra
 * 
 */
@SuppressWarnings("unused")
public class UnionFindTest {

	private String tinyPath = Utils.UF_BASE_PATH + "tinyUF.txt";
	private String mediumPath = Utils.UF_BASE_PATH + "mediumUF.txt";
	private String largePath = Utils.UF_BASE_PATH + "largeUF.txt";

	@Test
	public void runUF(){
		UFClient.main(new String[]{largePath});
	}
}
