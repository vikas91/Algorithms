package javaAlgorithms.Stacks;

import javaAlgorithms.LinkedLists.ListNode;
import javaAlgorithms.LinkedLists.SingleLinkedLists;

public class LinkedListStack<Item> implements Stack<Item> {
	
	private SingleLinkedLists<Item> linkedlist = new SingleLinkedLists<Item>();
	
	// Add item at begining of LL
	public void push(Item input){
		linkedlist.addAtBegining(input);
	}
	// Remove item from begining of LL
	public Item pop(){
		Item item = linkedlist.deleteFromBegining();
		return item;
	}
	
	public boolean isEmpty(){
		return linkedlist.getRoot()==null;
	}
	
	public Item topofStack(){
		return (Item)linkedlist.getRoot().getItem();
	}
	
	public Item getItem(int index){
		return linkedlist.getItem(index);
	}
	
	public int getLength(){
		return linkedlist.length();
	}

}
