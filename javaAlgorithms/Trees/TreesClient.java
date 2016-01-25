package javaAlgorithms.Trees;

public class TreesClient {
	public static void main(String args[]){
		BinaryTrees<Integer> binaryTree = new BinaryTrees<Integer>();
		binaryTree.printNodes(binaryTree.getRoot());
		for(int i=0; i<=15; i++){
			binaryTree.insert(i);
		}
		
		binaryTree.printNodes(binaryTree.getRoot());
		
	}
}
