/**
 * 
 */
package edu.mycourses.adt.basic.analysis;

import java.util.Arrays;

import edu.mycourses.util.Utils;

/**
 * @author Ibrahima Diarra
 *
 */
public class ThreeSumFast {


	public static int count(int[] a){
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for(int i = 0; i < N; i++)
			for(int j = i+1; j < N; j++)
				if(Arrays.binarySearch(a, -a[i]-a[j]) > j)
					cnt++;
		return cnt;
	}
	public static void main(String[] args) {
		int[] a = Utils.readInts(args[0]);
		System.out.println(count(a));
	}

}
