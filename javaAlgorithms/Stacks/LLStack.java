package javaAlgorithms.Stacks;

import java.util.Iterator;

public class LLStack<Item> implements Stack<Item> {
	
	private Node first = null;
	
	public LLIterator iterator(){
		return new LLIterator();
	}
	
	class LLIterator implements Iterator<Item>{
		
		private Node current = null;
		
		public boolean hasNext(){
			return current==null;
		}
		public void remove(){
			
		}
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	private class Node{
		Item item;
		Node next;
	}
	// Add item at begining of LL
	public void push(Item input){
		Node oldfirst = first;
		first = new Node();
		first.item = input;
		first.next = oldfirst;
	}
	// Remove item from begining of LL
	public Item pop(){
		if(!isEmpty()){
			Node oldfirst = first;
			first = oldfirst.next;
			return oldfirst.item;
		}else{
			System.out.print("Cannot pop from empty stack");
			throw new RuntimeException("Stack is Empty");
		}
		
	}
	
	public boolean isEmpty(){
		return first==null;
	}

}
