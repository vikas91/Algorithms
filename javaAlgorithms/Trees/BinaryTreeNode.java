package javaAlgorithms.Trees;

public class BinaryTreeNode<Item> {
	private Item item;
	private BinaryTreeNode left, right;
	
	public BinaryTreeNode(Item item) {
		this.item = item;
		this.left = null;
		this.right = null;
	}
	public Item getItem(){
		return this.item;
	}
	public void setItem(Item item){
		this.item = item;
	}
	public BinaryTreeNode getLeft(){
		return this.left;
	}
	public void setLeft(BinaryTreeNode leftNode){
		this.left = leftNode;
	}
	public BinaryTreeNode getRight(){
		return this.right;
	}
	public void setRight(BinaryTreeNode rightNode){
		this.right = rightNode;
	}
	
}
