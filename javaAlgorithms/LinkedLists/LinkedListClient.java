package javaAlgorithms.LinkedLists;

import java.util.Arrays;

public class LinkedListClient {
	
	public static void main(String args[]){
		SingleLinkedLists<Integer> mylinkedlist = new SingleLinkedLists<Integer>();
		for(int i=0;i<10; i++){
			mylinkedlist.add(i,i);
		}
		System.out.println(Arrays.deepToString(mylinkedlist.printNodesAsArrayList()));
		System.out.println(mylinkedlist.findMid().getItem());
//		mylinkedlist.reverseLinkedlist();
//		mylinkedlist.printNodes();
	}

}
