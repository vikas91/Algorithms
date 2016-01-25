package javaAlgorithms.LinkedLists;

public class SingleLinkedLists<Item> {
	protected int length;
	protected ListNode root;
	
	public SingleLinkedLists(){
		
	}
	
	public ListNode getRoot(){
		return root;
	}
	
	public void setRoot(ListNode node){
		this.root = node;
	}
	
	// Adds item at beginning of linked list.
	// Time complexity O(1)
	public void addAtBegining(Item input){
		// Check if memory exists here and only then create a node
		ListNode newNode = new ListNode(input);
		
		if(root==null){
			System.out.println("Adding into empty Linked list");
			newNode.setNext(null);
			setRoot(newNode);
			length = length + 1;
			return;
		}
		
		ListNode tempNode = root;
		newNode.setNext(tempNode);
		root=newNode;
		length=length + 1;
	}
	
	// Adds item at end of linked list.
	// Time complexity O(N)
	public void addAtEnd(Item input){
		ListNode newNode = new ListNode(input);
		
		if(root==null){
			System.out.println("Adding into empty Linked list");
			newNode.setNext(null);
			setRoot(newNode);
			length = length + 1;
			return;
		}
		
		ListNode tempNode = root;
		while(tempNode.getNext()!=null){
			tempNode = tempNode.getNext();
		}
		tempNode.setNext(newNode);
		length = length + 1;
	}
	
	
	//Removes item from beginning of linked list.
	//Time complexity O(1)
	public Item deleteFromBegining(){
		if(root==null || length==0){
			System.out.println("Linked List is Empty.Nothing to delete");
			throw new IndexOutOfBoundsException();
		}
		ListNode tempNode = root;
		
		root = tempNode.getNext();
		length = length-1;
		Item item = (Item) tempNode.getItem();
		return item;
	}
	
	
	//Removes item from beginning of linked list.
	//Time complexity O(N)
	public Item deleteFromEnd(){
		if(root==null || length==0){
			System.out.println("Linked List is Empty.Nothing to delete");
			throw new IndexOutOfBoundsException();
		}
		
		ListNode tempNode=root;
		ListNode currentNode=null;
		while(tempNode.getNext()!=null){
			currentNode=tempNode;
			tempNode =  tempNode.getNext();
		}
		Item item = (Item) tempNode.getItem();
		if(currentNode!=null){
			currentNode.setNext(null);
		}else{
			root=null;
		}
		
		length = length-1;
		return item;
	}
	
	// Adds item at given index of linked list
	public void add(Item input, int index){
		// Check if memory exists here and only then create a node
		ListNode newNode = new ListNode(input);
		
		if(index>length || index<0){
			System.out.println("Cant add node at the given index");
			throw new IndexOutOfBoundsException();
		}
		// Add item at beginning of empty linked list
		if(root==null){
			System.out.println("Adding node at begining of empty linked list");
			newNode.setNext(null);
			root = newNode;
			length = length + 1;
			return;
		}
		// Add item at beginning of non empty linked list
		if(index==0){
			System.out.println("Adding node at begining of non empty linked list");
			ListNode tempNode = root;
			root = newNode;
			root.setNext(tempNode);
			length = length + 1;
		}
		// Add item in middle of linked list
		else{
			ListNode currentNode = root;
			for(int i=1; i<index; i++){
				currentNode = currentNode.getNext();
			}
			ListNode tempNode = currentNode.getNext();
			currentNode.setNext(newNode);
			newNode.setNext(tempNode);
			length = length+1;
		}
	}
	
	// Adds item at given index of linked list
	public Item delete(int index){
		
		if(index>length || index<0){
			System.out.println("Cant delete node at the given index");
			throw new IndexOutOfBoundsException();
		}
		// Add item at beginning of empty linked list
		if(root==null){
			System.out.println("Cannot delete node from empty linked list");
			return null;
		}
		// Delete item at beginning of non empty linked list
		if(index==0){
			System.out.println("Delete node at begining of non empty linked list");
			ListNode tempNode = root;
			root=tempNode.getNext();
			length = length - 1;
			Item item = (Item) tempNode.getItem();
			return item;
		}
		// Add item in middle and end of linked list
		else{
			ListNode currentNode = root;
			for(int i=1; i<index; i++){
				currentNode = currentNode.getNext();
			}
			ListNode tempNode = currentNode.getNext();
			currentNode.setNext(tempNode.getNext());
			length = length-1;
			Item item = (Item) tempNode.getItem();
			return item;
		}
	}
	// print all nodes of linked list
	public void printNodes(){
		ListNode tempNode = root;
		while(tempNode!=null){
			System.out.print(tempNode.getItem());
			tempNode=tempNode.getNext();
		}
	}
	// This will return item from linked list if it exists 
	public boolean find(Item input){
		ListNode tempNode = root;
		while(tempNode!=null){
			if(tempNode.getItem()==input){
				return true; 
			}
			tempNode=tempNode.getNext();
		}
		System.out.println("Item doesnt exist in Linked List");
		return false;
	}
	
	// This will reverse the current linked list
	public void reverseLinkedlist(){
		ListNode tempNode=root;
		ListNode returnRoot=null;
		while(tempNode!=null){
			ListNode currentNode = new ListNode(tempNode.getItem());
			currentNode.setNext(returnRoot);
			returnRoot = currentNode; 
			tempNode = tempNode.getNext();
		}
		root=returnRoot;
	}
	
	// This will reverse the current linked list
	private void printNodesReverseRecursionInternal(ListNode head){
		if (head.getNext()!=null){
			printNodesReverseRecursionInternal(head.getNext());
		}
		System.out.print(head.getItem());
	}
	
	public void printNodesReverseRecursion(){
		ListNode tempNode=root;
		printNodesReverseRecursionInternal(tempNode);
	}
	
	// This will return length of linked list
	public int length(){
		return length;
	}
	
	// This will return Linked List nodes as Array List
	public Item[] printNodesAsArrayList(){
		Item[] resultArray = (Item[]) new Object[length()];
		ListNode tempNode = root;
		int arrayindex=0;
		while(tempNode!=null){
			resultArray[arrayindex] = (Item) tempNode.getItem();
			arrayindex = arrayindex + 1;
			tempNode=tempNode.getNext();
		}
		return resultArray;
	}
	
	// Use 2 pointer a faster and slow pointer.
	// If fast pointer and second pointer are equal before both of them are null
	// loop exits in Linked list
	
    private ListNode fastPointer=null;
    private ListNode slowPointer=null;
    
	public boolean findIfLoopExists(){
		if(root==null){
			System.out.println("Linked List is empty");
			return false;
		}
		
		fastPointer = root;
		slowPointer = root;
		
		while(fastPointer.getNext()!=null || fastPointer!=null){
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();
			if(fastPointer==null){
				break;
			}
			if(fastPointer==slowPointer){
				return true;
			}
		}
		return false;
	}
	
	// This will find mid of linked list
	public ListNode findMid(){
		findIfLoopExists();
		return slowPointer;
	}
	
	// This will return the loop length if it exists
	public int findLoopLength(){
		int count=0;
		if(findIfLoopExists()){
			do{
				fastPointer=fastPointer.getNext();
				count++;
			}while(fastPointer!=slowPointer);
		}
		return count;
	}
	
	// This will delete duplicates from sorted linked list
	public void deleteDuplicates() {
		
		// Check if linked list is sorted first here
		ListNode tempNode=root;
        while(tempNode!=null){
        	ListNode nextNode=tempNode.getNext();
            while(nextNode!=null && tempNode.getItem()==nextNode.getItem()){
                nextNode=nextNode.getNext();
            }
            tempNode.setNext(nextNode);
            tempNode=tempNode.getNext();
        }
    }
	
	// Use 2 pointers, first one moves through N nodes.
	// Now Iterate both pointers simultaneously until first pointer reaches null
	// return second pointer
	public Item findNthNodeFromEnd(int n){
		ListNode firstTempNode, secondTempNode;
		if(root==null){
			System.out.println("Linked List is empty");
			throw new IndexOutOfBoundsException();
		}
		// Here we know the length of linked list
		// However handle the exception while iterating firstTempNode
		if(n>length){
			System.out.println("Linked List size is less than given index");
			throw new IndexOutOfBoundsException();
		}
		
		firstTempNode = secondTempNode = root;
		
		for(int i=1; i<n; i++){
			if(firstTempNode==null){
				System.out.println("Linked List size is less than given index");
				throw new IndexOutOfBoundsException();
			}
			firstTempNode=firstTempNode.getNext();
		}
		while(firstTempNode!=null){
			firstTempNode=firstTempNode.getNext();
			secondTempNode=secondTempNode.getNext();
		}
		Item item = (Item) secondTempNode.getItem();
		return item;
	}
}
