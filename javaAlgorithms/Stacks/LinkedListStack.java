package javaAlgorithms.Stacks;

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
		Item item = (Item)linkedlist.getRoot().getItem();
		return item;
	}

}
