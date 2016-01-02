package javaAlgorithms.LinkedLists;

public class LinkedListProblems<Item> extends SingleLinkedLists<Item> {
	
	Node fastPointer, slowPointer;
	
	// Use 2 pointers, first one moves through N nodes.
	// Now Iterate both pointers simultaneously until first pointer reaches null
	// return second pointer
	public Item findNthNodeFromEnd(int n){
		Node firstTempNode, secondTempNode;
		if(root==null){
			System.out.println("Linked List is empty");
			throw new IndexOutOfBoundsException();
		}
		// Here we know the length of linked list
		// However handle the exception while iterating firstTempNode
		if(n>length){
			System.out.println("Linked List size is less than given index");
			throw new IndexOutOfBoundsException();
		}
		
		firstTempNode = secondTempNode = root;
		
		for(int i=1; i<n; i++){
			if(firstTempNode==null){
				System.out.println("Linked List size is less than given index");
				throw new IndexOutOfBoundsException();
			}
			firstTempNode=firstTempNode.next;
		}
		while(firstTempNode!=null){
			firstTempNode=firstTempNode.next;
			secondTempNode=secondTempNode.next;
		}
		return secondTempNode.item;
	}
	
	// Use 2 pointer a faster and slow pointer.
	// If fast pointer and second pointer are equal before both of them are null
	// loop exits in Linked list
	public boolean findIfLoopExists(){
		
		if(root==null){
			System.out.println("Linked List is empty");
			return false;
		}
		fastPointer = slowPointer = root;
		
		while(fastPointer.next!=null || fastPointer!=null){
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			if(fastPointer==slowPointer){
				return true;
			}
		}
		return false;
	}
	
	public int findLoopLength(){
		int count=0;
		if(findIfLoopExists()){
			do{
				fastPointer=fastPointer.next;
				count++;
			}while(fastPointer!=slowPointer);
		}
		return count;
	}
	
	public void reverseLinkedlist(){
		Node tempNode=root;
		Node returnRoot=null;
		while(tempNode!=null){
			Node currentNode=new Node();
			currentNode.item=tempNode.item;
			currentNode.next=returnRoot;
			returnRoot=currentNode; 
			tempNode=tempNode.next;
		}
		root=returnRoot;
	}
	
}
