package javaAlgorithms.UnionFind;

/* This is an Implementation of Union Find
 * We initialize an N node array where value of each node is its index.
 * Two nodes are connected if they have same index.
 * union of two nodes p,q happen if all nodes having p values replaced by all nodes with q values
 */
public class QuickFind implements UnionFind{
	
	public int[] inputArray;
	
	public QuickFind(int N){
		inputArray = new int[N];
		for(int i=0; i<N; i++){
			this.inputArray[i]=i;
		}
	}
	
	public void union(int p, int q){
		if(!isconnected(p,q)){
			int p_value = inputArray[p];
			int q_value = inputArray[q];
			for(int i=0; i<inputArray.length; i++){
				if(inputArray[i]==p_value){
					inputArray[i]=q_value;
				}
			}
		}
	}
	public boolean isconnected(int p, int q){
		return inputArray[p]==inputArray[q];
	}
}

