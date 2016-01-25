//package javaAlgorithms.Stacks;
//
//import java.util.Iterator;
//
//import javaAlgorithms.LinkedLists.ListNode;
//import javaAlgorithms.Stacks.LinkedListStack.LLIterator;
//
//public class ArrayStack<Item> implements Stack<Item> {
//	private Item[] privateArray = (Item[]) new Object[1];
//	private int currentarrayIndex=0;
//	private int maxsize = 1;
//	
//	public LLIterator iterator(){
//		return new LLIterator(privateArray);
//	}
//	
//	class LLIterator implements Iterator<Item>{
//		
//		private ListNode current;
//		
//		public LLIterator(ListNode current){
//			this.current=current;
//		}
//		
//		public boolean hasNext(){
//			return this.current.getNext()==null;
//		}
//		public void remove(){
//			
//		}
//		public Item next(){
//			if(hasNext()){
//				Item item = (Item) this.current.getNext().getItem();
//				return item;
//			}
//			return null;
//		}
//	}
//	
//	private void extendArraySize(){
//		maxsize = maxsize * 2;
//		Item[] oldArray = privateArray;
//		privateArray = (Item[]) new Object[maxsize];
//		
//		for(int i=0; i<oldArray.length; i++){
//			privateArray[i] = oldArray[i];
//		}
//	}
//	public void push(Item input){
//		if(isFull()){
//			extendArraySize();
//		}
//		privateArray[currentarrayIndex] = input;
//		currentarrayIndex = currentarrayIndex + 1 ;
//	}
//	public Item pop() throws RuntimeException{
//		if(isEmpty()){
//			System.out.print("Stack is Empty");
//			throw new RuntimeException("Stack is Empty");
//		}
//		Item value = privateArray[currentarrayIndex];
//		privateArray[currentarrayIndex]=null;
//		currentarrayIndex = currentarrayIndex - 1;
//		return value;
//		
//	}
//	public boolean isEmpty(){
//		return currentarrayIndex==0;
//	}
//	
//	private boolean isFull(){
//		return currentarrayIndex==maxsize;
//	}
//
//}
