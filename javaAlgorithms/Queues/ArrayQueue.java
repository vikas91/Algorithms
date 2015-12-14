package javaAlgorithms.Queues;

public class ArrayQueue<Item> implements Queue<Item> {
	
	private int maxsize = 1;
	private int start = 0;
	private int end = 0;
	
	private Item[] privateArray = (Item[]) new Object[maxsize];
	
	private void extendArraySize(){
		maxsize = maxsize * 2;
		Item[] oldArray = privateArray;
		privateArray = (Item[]) new Object[maxsize];
		
		for(int i=0; i<oldArray.length; i++){
			privateArray[i] = oldArray[i];
		}
	}
	
	// Add at end of Array
	public void enqueue(Item input){
		if(end==maxsize){
			extendArraySize();
		}
		privateArray[end] = input;
		end = end + 1 ;
	}
	// Remove from begining of Array
	public Item dequeue() throws RuntimeException{
		Item item = privateArray[start];
		// This is to check if queue is empty or not
		if(start==end){
			System.out.print("Queue is empty");
			start=end=0;
			return null;
		}
		privateArray[start] = null;
		start = start + 1;
		return item;
	}

}
