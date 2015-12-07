package javaAlgorithms.UnionFind;

public class WeightedQUPathCompression extends WeightedQuickUnion {
	public WeightedQUPathCompression(int N){
		super(N);
	}
	protected Root get_root_obj(int p){
		int root_length=1;
		while(inputArray[p]!=p){
			inputArray[p]=inputArray[inputArray[p]];
			p=inputArray[p];
			root_length++;
		}
		Root root_obj = new Root(root_length, p);
		return root_obj;
	}
	
}
