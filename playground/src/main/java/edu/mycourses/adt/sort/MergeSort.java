package edu.mycourses.adt.sort;

public class MergeSort {

	public static void sort(Comparable<?>[] a){
		
		int lo = 0, hi = a.length -1, mid = (hi + lo) / 2;
		
		Comparable<?>[] aux = merge(a, lo, mid, hi);
		//copy value to original array
		int i = 0;
		for(Comparable<?> v : aux)
			a[i++] = v;
	}

	private static Comparable<?>[] merge(Comparable<?>[] a, int lo, int mid,
			int hi) {
		// TODO Auto-generated method stub
		return null;
	}
}
