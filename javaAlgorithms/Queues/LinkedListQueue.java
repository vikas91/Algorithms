package javaAlgorithms.Queues;

import javaAlgorithms.LinkedLists.SingleLinkedLists;

public class LinkedListQueue<Item> implements Queue<Item> {
	
	private SingleLinkedLists<Item> linkedlist = new SingleLinkedLists<Item>();
	
	// Add item at beginning of LL.
	public void enqueue(Item input){
		linkedlist.addAtBegining(input);
	}
	// Remove item from begining of LL
	public Item dequeue(){
		return linkedlist.deleteFromEnd();
	}
	public boolean isEmpty(){
		return linkedlist.getRoot()==null;
	}
	public Item topofQueue(){
		Item item = (Item)linkedlist.getRoot().getItem();
		return item;
	}
	public void printNodes(){
		linkedlist.printNodes();
	}
}
