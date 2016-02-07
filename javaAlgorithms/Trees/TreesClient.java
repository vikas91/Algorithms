package javaAlgorithms.Trees;

public class TreesClient {
	public static void main(String args[]){
		BinaryTrees<Integer> binaryTree = new BinaryTrees<Integer>();
		
		System.out.println("Starting Execution");
		for(int i=1; i<=17; i++){
			binaryTree.insert(i);
		}
		BinaryTreeNode newNode = new BinaryTreeNode(18);
		binaryTree.lastNode.setLeft(newNode);
		newNode = new BinaryTreeNode(19);
		binaryTree.lastNode.setRight(newNode);
		newNode = new BinaryTreeNode(20);
		binaryTree.lastNode.getLeft().setLeft(newNode);
		newNode = new BinaryTreeNode(21);
		binaryTree.lastNode.getLeft().setRight(newNode);
		binaryTree.printNodes();
//		System.out.println("\n++++++++ PreOrder +++++++");
//		binaryTree.preOrderRecursive();
//		System.out.println("\n++++++++ PreOrder Non recursive +++++++");
//		binaryTree.preOrderNonRecursive();
//		
//		
//		System.out.println("\n++++++++ InOrder +++++++");
//		binaryTree.inOrderRecursive();
//		System.out.println("\n++++++++ InOrder Non recursive +++++++");
//		binaryTree.inOrderNonRecursive();
//		
//		System.out.println("\n++++++++ postOrder +++++++");
//		binaryTree.postOrderRecursive();
//		System.out.println("\n++++++++ postOrder Non recursive +++++++");
//		binaryTree.postOrderNonRecursive();
//		
//		System.out.println("\n++++++++ levelOrder +++++++");
//		binaryTree.levelOrder();
		
		System.out.println("\n+++++++++++ Height Recursive +++++++++");
		System.out.println(binaryTree.heightRecursive());
		
		System.out.println("\n+++++++++++ Height Non Recursive +++++++++");
		System.out.println(binaryTree.heightNonRecursive());
		
		System.out.println("\nEnding Execution");
		
		
	}
}
