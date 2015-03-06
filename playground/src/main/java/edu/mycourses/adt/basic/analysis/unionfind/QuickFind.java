/**
 * 
 */
package edu.mycourses.adt.basic.analysis.unionfind;


/**
 * @author Ibrahima Diarra
 *
 */
public class QuickFind implements UF {

	protected final int[] id;
	protected int count;
	
	public QuickFind(final int N){
		id = new int[N];
		for(int x = 0; x < N; x++)
			id[x] = x;
		count = N;
	}
	
	@Override
	public void union(int p, int q) {
		final int pId = find(p);
		final int qId = find(q);
		if (pId == qId)
			return;
		for (int x = 0; x < id.length; x++)
			if (id[x] == pId)
				id[x] = qId;
		count--;
	}

	@Override
	public int find(int p) {
		return id[p];
	}

	@Override
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	@Override
	public int count() {
		return count;
	}
}
