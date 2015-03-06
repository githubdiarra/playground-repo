/**
 * 
 */
package edu.mycourses.adt.basic.analysis.unionfind;

import edu.mycourses.util.IntReader;
import edu.mycourses.util.StdOut;

/**
 * @author Ibrahima Diarra
 * 
 */
public class UFClient {

	public static void main(String[] args) {
		IntReader intReader = new IntReader(args[0]);
		final int N = intReader.readInt();
		final UF uf = new WeightedQuickUnion(N);
		while (!intReader.isEmpty()) {
			int p = intReader.readInt();
			int q = intReader.readInt();
			if (uf.connected(p, q))
				continue;
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println("\n---------------------------\n");
		StdOut.println(uf.count() + " components");
	}
}
