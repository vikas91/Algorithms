package javaAlgorithms.Stacks;

public class LLStack<Item> implements Stack<Item> {
	
	private Node first = null;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public void push(Item input){
		Node oldfirst = first;
		Node first = new Node();
		first.item = input;
		first.next = oldfirst;
	}
	
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
