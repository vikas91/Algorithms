package javaAlgorithms.UnionFind;

public class WeightedQUPathCompression extends WeightedQuickUnion {
	public WeightedQUPathCompression(int N){
		super(N);
	}
	protected int get_root(int p){
		while(inputArray[p]!=p){
			inputArray[p]=inputArray[inputArray[p]];
			p=inputArray[p];
		}
		return p;
	}
	
}
