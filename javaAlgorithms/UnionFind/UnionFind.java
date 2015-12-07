package javaAlgorithms.UnionFind;

/* Interface for union-find which implements 2 methods
 * 1) isconnected which check if two nodes are connected
 * 2) union which connects 2 given nodes
 */
public interface UnionFind {
	public void union(int p, int q);
	public boolean isconnected(int p, int q);
}

