package javaAlgorithms.UnionFind;
/* This implementation of UF starts with same initilization of QF where root of every node is its index.
 * However we connect 2 nodes p,q by making root of p point to root of q
 * root of p is id[id[...id[p]]..] until id[p]=p 
 * two nodes are connected if they have same root
 */

public class QuickUnion implements UnionFind{
	
	protected int[] inputArray;
	
	public QuickUnion(int N){
		inputArray = new int[N];
		for(int i=0; i<N; i++){
			inputArray[i]=i;
		}
	}
	
	protected int get_root(int p){
		while(inputArray[p]!=p){
			p=inputArray[p];
		}
		return p;
	}
	public void union(int p, int q){
		int p_root = get_root(p);
		int q_root = get_root(q);
		inputArray[p_root] = q_root;
	}
	public boolean isconnected(int p, int q){
		return get_root(p)==get_root(q);
	}
}
