package javaAlgorithms.Trees;

import javaAlgorithms.Queues.LinkedListQueue;

public class BinaryTrees<Item>{
	protected BinaryTreeNode root = null;
	
	public BinaryTreeNode getRoot(){
		return this.root;
	}
	
	public void insert(Item item){
		BinaryTreeNode newNode = new BinaryTreeNode(item);
		LinkedListQueue<BinaryTreeNode> binaryQueue = new LinkedListQueue<BinaryTreeNode>();
		
		if(root==null){
			System.out.println("Adding into empty Binary tree");
			root = newNode;
			return;
		}
		if(binaryQueue.isEmpty()){
			binaryQueue.enqueue(root);
		}
		while(!binaryQueue.isEmpty()){
			BinaryTreeNode currentNode = binaryQueue.dequeue();
			if(currentNode.getLeft()==null){
				currentNode.setLeft(newNode);
				return;
			}else if(currentNode.getRight()==null){
				currentNode.setRight(newNode);
				return;
			}else{
				binaryQueue.enqueue(currentNode.getLeft());
				binaryQueue.enqueue(currentNode.getRight());
				
			}
		}
	}
	
	public void printNodes(BinaryTreeNode root){
		LinkedListQueue<BinaryTreeNode> binaryQueue = new LinkedListQueue<BinaryTreeNode>();
		
		if(root==null){
			System.out.println("Binary tree is empty");
			return;
		}
		if(binaryQueue.isEmpty()){
			binaryQueue.enqueue(root);
		}
		while(!binaryQueue.isEmpty()){
			BinaryTreeNode currentNode = binaryQueue.dequeue();
			if(currentNode.getLeft()==null && currentNode.getRight()==null){
				System.out.println(currentNode.getItem());
			}else if(currentNode.getLeft()!=null){
				binaryQueue.enqueue(currentNode.getLeft());
			}else{
				binaryQueue.enqueue(currentNode.getRight());
			}
		}
	}
	
}
