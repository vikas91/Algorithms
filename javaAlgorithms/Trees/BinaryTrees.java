package javaAlgorithms.Trees;

import javaAlgorithms.Queues.LinkedListQueue;
import javaAlgorithms.Stacks.LinkedListStack;

public class BinaryTrees<Item>{
	protected BinaryTreeNode rootNode;
	public BinaryTreeNode lastNode;
	
	public BinaryTrees(){
		this.rootNode=null;
	}
	
	public BinaryTreeNode getRoot(){
		return this.rootNode;
	}
	
	public BinaryTreeNode getLastNode(){
		return this.lastNode;
	}
	
	
	public void insert(Item item){
		BinaryTreeNode newNode = new BinaryTreeNode(item);
		LinkedListQueue<BinaryTreeNode> binaryQueue = new LinkedListQueue<BinaryTreeNode>();
		
		if(this.rootNode==null){
			this.rootNode = newNode;
			return;
		}
		if(binaryQueue.isEmpty()){
			binaryQueue.enqueue(this.rootNode);
		}
		this.lastNode = newNode;
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
	
	public void printNodes(){
		LinkedListQueue<BinaryTreeNode> binaryQueue = new LinkedListQueue<BinaryTreeNode>();
		
		if(this.rootNode==null){
			System.out.println("Binary tree is empty");
			return;
		}
		if(binaryQueue.isEmpty()){
			binaryQueue.enqueue(this.rootNode);
		}
		while(!binaryQueue.isEmpty()){
			BinaryTreeNode currentNode = binaryQueue.dequeue();
			if(currentNode.getLeft()!=null){
				binaryQueue.enqueue(currentNode.getLeft());
			}
			if(currentNode.getRight()!=null){
				binaryQueue.enqueue(currentNode.getRight());
			}
			System.out.print(currentNode.getItem() + ",");
		}
	}
	
	public void preOrderRecursiveInner(BinaryTreeNode root){
		if(root!=null){
			System.out.print(root.getItem() + ",");
			preOrderRecursiveInner(root.getLeft());
			preOrderRecursiveInner(root.getRight());
		}
	}
	
	public void preOrderRecursive(){
		BinaryTreeNode tempNode = this.rootNode;
		preOrderRecursiveInner(tempNode);
	}
	
	public void preOrderNonRecursive(){
		if(this.rootNode==null){
			return;
		}
		LinkedListStack<BinaryTreeNode> binaryStack = new LinkedListStack<BinaryTreeNode>();
		binaryStack.push(this.rootNode);
		while(!binaryStack.isEmpty()){
			BinaryTreeNode currentNode = binaryStack.pop();
			if(currentNode.getRight()!=null){
				binaryStack.push(currentNode.getRight());
			}
			if(currentNode.getLeft()!=null){
				binaryStack.push(currentNode.getLeft());
			}
			System.out.print(currentNode.getItem() + ",");
		}
	}
	
	public void inOrderRecursiveInner(BinaryTreeNode root){
		if(root!=null){
			inOrderRecursiveInner(root.getLeft());
			System.out.print(root.getItem() + ",");
			inOrderRecursiveInner(root.getRight());
		}
	}
	
	public void inOrderRecursive(){
		BinaryTreeNode tempNode = this.rootNode;
		inOrderRecursiveInner(tempNode);
	}
	
	public void inOrderNonRecursive(){
		if(this.rootNode==null){
			return;
		}
		LinkedListStack<BinaryTreeNode> binaryStack = new LinkedListStack<BinaryTreeNode>();
		boolean is_complete=false;
		
		BinaryTreeNode currentNode = this.rootNode;
		
		while(!is_complete){
			if (currentNode!=null){
				binaryStack.push(currentNode);
				currentNode=currentNode.getLeft();
			}else{
				if(binaryStack.isEmpty()){
					is_complete=true;
				}else{
					currentNode = binaryStack.pop();
					Item item = (Item)currentNode.getItem();
					System.out.print(item + ",");
					currentNode = currentNode.getRight();
				}
				
			}
		}
	}
	
	public void postOrderRecursiveInner(BinaryTreeNode root){
		if(root!=null){
			postOrderRecursiveInner(root.getLeft());
			postOrderRecursiveInner(root.getRight());
			System.out.print(root.getItem() + ",");
		}
	}
	
	public void postOrderRecursive(){
		BinaryTreeNode tempNode = this.rootNode;
		postOrderRecursiveInner(tempNode);
	}
	
	public void postOrderNonRecursive(){
		BinaryTreeNode currentNode = this.rootNode;
		if(currentNode==null){
			return;
		}
		LinkedListStack<BinaryTreeNode> binaryStack = new LinkedListStack<BinaryTreeNode>();
		BinaryTreeNode previousNode=null;
		binaryStack.push(currentNode);
		
		while(!binaryStack.isEmpty()){
			currentNode = binaryStack.topofStack();
			if(previousNode==null || previousNode.getLeft()==currentNode || previousNode.getRight()==currentNode){
				if(currentNode.getLeft()!=null){
					binaryStack.push(currentNode.getLeft());
				}else if(currentNode.getRight()!=null){
					binaryStack.push(currentNode.getRight());
				}
			}else if(currentNode.getLeft()==previousNode){
				if(currentNode.getRight()!=null){
					binaryStack.push(currentNode.getRight());
				}
			}else{
				System.out.print(currentNode.getItem() + ",");
				binaryStack.pop();
			}
			previousNode = currentNode;
		}
	}
	
	public void levelOrder(){
		BinaryTreeNode current = this.rootNode;
		if(current==null){
			return;
		}
		LinkedListQueue<BinaryTreeNode> binaryQueue = new LinkedListQueue<BinaryTreeNode>();
		binaryQueue.enqueue(current);
		while(!binaryQueue.isEmpty()){
			current = binaryQueue.dequeue();
			if(current.getLeft()!=null){
				binaryQueue.enqueue(current.getLeft());
			}
			if(current.getRight()!=null){
				binaryQueue.enqueue(current.getRight());
			}
			System.out.print(current.getItem() +",");
		}
	}
	
	public int heightRecursive(BinaryTreeNode root){
		if(root==null){
			return 0;
		}
		int left=heightRecursive(root.getLeft());
		int right=heightRecursive(root.getRight());
		return 1 + (left>right?left:right);
		
	}
	public int heightRecursive(){
		BinaryTreeNode current = this.rootNode;
		return heightRecursive(current);
	}
	
	public int heightNonRecursive(){
		BinaryTreeNode current = this.rootNode;
		if(this.rootNode==null){
			return 0;
		}
		int maxHeight=0;
		LinkedListStack<BinaryTreeNode> binaryStack = new LinkedListStack<BinaryTreeNode>();
		BinaryTreeNode previous = null;
		binaryStack.push(current);
		while(!binaryStack.isEmpty()){
			current = binaryStack.topofStack();
			if(previous==null || previous.getLeft()==current || previous.getRight()==current){
				if(current.getLeft()!=null){
					binaryStack.push(current.getLeft());
				}else if (current.getRight()!=null){
					binaryStack.push(current.getRight());
				}
			}else if(current.getLeft()==previous){
				if(current.getRight()!=null){
					binaryStack.push(current.getRight());
				}
			}else{
				binaryStack.pop();
			}
			previous=current;
			if(binaryStack.getLength()>maxHeight){
				maxHeight=binaryStack.getLength(); 
			}
		}
		return maxHeight;
	}
	
	public 
}
