package javaAlgorithms.LinkedLists;

public class DoubleLinkedLists<Item> {
	private int length;
	private Node root=null;
	private class Node {
		Item item;
		Node next;
		Node previous;
	}
	public DoubleLinkedLists(){
		
	}
	
	// Adds item at beginning of linked list.
	// Time complexity O(1)
	public void add(Item input){
		// Check if memory exists here and only then create a node
		Node newNode=new Node();
		newNode.item=input;
		
		if(root==null){
			newNode.next=null;
			newNode.previous=null;
			root=newNode;
			length=length + 1;
			return;
		}
		
		Node tempNode=root;
		newNode.next=tempNode;
		newNode.previous=null;
		root=newNode;
		length=length + 1;
	}
	
	//Removes item from beginning of linked list.
	//Time complexity O(1)
	public Item delete(){
		if(root==null || length==0){
			System.out.println("Linked List is Empty.Nothing to delete");
			throw new IndexOutOfBoundsException();
		}
		Node tempNode=root;
		root=tempNode.next;
		length=length-1;
		return tempNode.item;
	}
	
	// Adds item at given index of linked list
	public void add(Item input, int index){
		// Check if memory exists here and only then create a node
		Node newNode=new Node();
		newNode.item=input;
		
		if(index>length || index<0){
			System.out.println("Cant add node at the given index");
			throw new IndexOutOfBoundsException();
		}
		// Add item at beginning of empty linked list
		if(root==null){
			System.out.println("Adding node at begining of empty linked list");
			newNode.next=null;
			newNode.previous=null;
			root=newNode;
			length=length + 1;
			return;
		}
		// Add item at beginning of non empty linked list
		if(index==0){
			System.out.println("Adding node at begining of non empty linked list");
			Node tempNode=root;
			root=newNode;
			root.next=tempNode;
			root.previous=null;
			length=length + 1;
		}
		// Add item in middle of linked list
		else{
			Node currentNode = root;
			for(int i=1; i<index; i++){
				currentNode=currentNode.next;
			}
			Node tempNode=currentNode.next;
			currentNode.next=newNode;
			newNode.next=tempNode;
			newNode.previous=currentNode;
			length=length+1;
		}
	}
	
	// Adds item at given index of linked list
	public Item delete(int index){
		
		if(index>length || index<0){
			System.out.println("Cant delete node at the given index");
			throw new IndexOutOfBoundsException();
		}
		// Add item at beginning of empty linked list
		if(root==null){
			System.out.println("Cannot delete node from empty linked list");
			return null;
		}
		// Delete item at beginning of non empty linked list
		if(index==0){
			System.out.println("Delete node at begining of non empty linked list");
			Node tempNode=root;
			root=tempNode.next;
			length=length - 1;
			return tempNode.item;
		}
		// Add item in middle of linked list
		else{
			Node currentNode = root;
			for(int i=1; i<index; i++){
				currentNode=currentNode.next;
			}
			Node tempNode=currentNode.next;
			currentNode.next=tempNode.next;
			length=length-1;
			return tempNode.item;
		}
	}
	// print all nodes of linked list
	public void printNodes(){
		Node tempNode = root;
		while(tempNode!=null){
			System.out.println(tempNode.item);
			tempNode=tempNode.next;
		}
	}
	
	// This will return length of linked list
	public int length(){
		return length;
	}
	
	public static void main(String args[]){
		DoubleLinkedLists<Integer> mylinkedlist = new DoubleLinkedLists<Integer>();
		for(int i=0;i<10; i++){
			mylinkedlist.add(i);
		}
		mylinkedlist.printNodes();
	}
}
