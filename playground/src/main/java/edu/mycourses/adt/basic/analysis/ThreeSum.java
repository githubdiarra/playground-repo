/**
 * 
 */
package edu.mycourses.adt.basic.analysis;

import edu.mycourses.util.Utils;

/**
 * @author Ibrahima Diarra
 *
 */
public class ThreeSum {

	public static int count(final int[] a){
		int N = a.length;
		int cnt = 0;
		for(int i = 0; i < N; i++)
			for(int j=i+1; j < N; j++)
				for(int k = j+1; k < N; k++)
					if(a[i] + a[j] + a[k] == 0)
						cnt++;
		return cnt++;
	}
	
	public static void main(String[] args){
		int[] a = Utils.readInts(args[0]);
		System.out.println(count(a));
	}
}
