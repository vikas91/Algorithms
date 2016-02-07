package javaAlgorithms.LinkedLists;

public class LinkedListClient {
	
	public static void main(String args[]){
		SingleLinkedLists<Integer> mylinkedlist = new SingleLinkedLists<Integer>();
		for(int i=0;i<10; i++){
			mylinkedlist.add(i,i);
		}
		mylinkedlist.printNodes();
		System.out.println();
		
		
//		mylinkedlist.reverseLinkedlist();
//		mylinkedlist.printNodes();
	}

}
