package javaAlgorithms.Queues;

public class LLQueue<Item> implements Queue<Item> {
	
	private Node first, last;
	
	private class Node {
		Item value;
		Node next;
	}
	// Add item at end of LL.
	public void enqueue(Item input){
		Node oldLast = last;
		Node last = new Node();
		last.value = input;
		last.next = null;
		oldLast.next = last;
	}
	// Remove item from begining of LL
	public Item dequeue(){
		if(!isEmpty()){
			Node oldfirst = first;
			first = oldfirst.next;
			return oldfirst.value;
		}else{
			System.out.print("Cannot pop from empty stack");
			throw new RuntimeException("Stack is Empty");
		}
	}
	public boolean isEmpty(){
		return first==null;
	}

}
