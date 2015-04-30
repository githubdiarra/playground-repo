/**
 * 
 */
package edu.mycourses.adt.graph;

/**
 * @author Ibrahima Diarra
 *
 */
public interface IGraph {

	/**
	 * 
	 * @return number of vertices
	 */
	int V();
	
	/**
	 * 
	 * @return number of edges
	 */
	int E();
	
	/**
	 * Add edge v-w to this graph
	 * @param v
	 * @param w
	 */
	void addEdge(int v, int w);
	
	/**
	 * 
	 * @param v
	 * @return collection of vertices adjacent to v
	 */
	Iterable<Integer> adj(int v);
}
