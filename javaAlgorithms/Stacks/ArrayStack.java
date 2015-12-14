package javaAlgorithms.Stacks;

public class ArrayStack<Item> implements Stack<Item> {
	private Item[] privateArray = (Item[]) new Object[1];
	private int currentarrayIndex=0;
	private int maxsize = 1;
	
	private void extendArraySize(){
		maxsize = maxsize * 2;
		Item[] oldArray = privateArray;
		privateArray = (Item[]) new Object[maxsize];
		
		for(int i=0; i<oldArray.length; i++){
			privateArray[i] = oldArray[i];
		}
	}
	public void push(Item input){
		if(isFull()){
			extendArraySize();
		}
		privateArray[currentarrayIndex] = input;
		currentarrayIndex = currentarrayIndex + 1 ;
	}
	public Item pop() throws RuntimeException{
		if(isEmpty()){
			System.out.print("Stack is Empty");
			throw new RuntimeException("Stack is Empty");
		}
		Item value = privateArray[currentarrayIndex];
		privateArray[currentarrayIndex]=null;
		currentarrayIndex = currentarrayIndex - 1;
		return value;
		
	}
	public boolean isEmpty(){
		return currentarrayIndex==0;
	}
	
	private boolean isFull(){
		return currentarrayIndex==maxsize;
	}

}
