package javaAlgorithms.UnionFind;

import java.util.Arrays;

public class UnionFindTestClient {
	public static void main(String args[]){
		QuickFind qf_instance = new QuickFind(10);
		System.out.print(Arrays.toString(qf_instance.inputArray));
		qf_instance.union(6, 3);
		qf_instance.union(2, 3);
		qf_instance.union(5, 3);
		qf_instance.union(5, 1);
		qf_instance.union(9, 3);
		qf_instance.union(3, 0);
		System.out.print(Arrays.toString(qf_instance.inputArray));
		System.out.println("\n-----------------------------------------\n");
		
		WeightedQuickUnion wqu2_instance = new WeightedQuickUnion(10);
		System.out.print(Arrays.toString(wqu2_instance.inputArray));
		wqu2_instance.union(9, 3);
		wqu2_instance.union(7, 4);
		wqu2_instance.union(7, 8);
		wqu2_instance.union(1, 6);
		wqu2_instance.union(1, 9);
		wqu2_instance.union(4, 2);
		wqu2_instance.union(5, 7);
		wqu2_instance.union(7, 6);
		wqu2_instance.union(0, 2);
		System.out.print(Arrays.toString(wqu2_instance.inputArray));
	}

}
