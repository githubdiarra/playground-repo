/**
 * 
 */
package edu.mycourses.adt.basic.analysis.unionfind;

/**
 * @author Ibrahima Diarra
 *
 */
public class QuickUnion extends QuickFind {


	public QuickUnion(int N) {
		super(N);
	}

	@Override
	public void union(int p, int q) {
		final int i = find(p);
		final int j = find(q);
		if (i == j)
			return;
		id[i] = j;
		count--;
	}
	
	@Override
	public int find(int p) {
		while (p != id[p])
			p = id[p];
		return p;
	}

}
