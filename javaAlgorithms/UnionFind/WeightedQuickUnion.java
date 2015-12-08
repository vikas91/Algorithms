package javaAlgorithms.UnionFind;
/* This algorithm reduces the problem with QU which gives long trees 
 * When connecting 2 nodes we always make larger node root of smaller node
 * This implementation we create an extra array to maintain size of root of nodes
 * Size is appropriate node is updated whenever we create a union of two nodes
 */

public class WeightedQuickUnion extends QuickUnion {
	protected int[] sizeArray;
	
	public WeightedQuickUnion(int N){
		super(N);
		sizeArray = new int[N];
		for(int i=0; i<sizeArray.length; i++){
			sizeArray[i]=1;
		}
	}
	
	public void union(int p, int q){
		int p_root = get_root(p);
		int q_root = get_root(q);
		if (sizeArray[p_root]<sizeArray[q_root]){
			inputArray[p_root] = q_root;
			sizeArray[q_root] += sizeArray[p_root];
		}else{
			inputArray[q_root] = p_root;
			sizeArray[p_root] +=sizeArray[q_root];
		}
		
	}
}
