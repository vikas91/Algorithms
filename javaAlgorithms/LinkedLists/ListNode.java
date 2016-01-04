package javaAlgorithms.LinkedLists;

public class ListNode<Item> {
	private Item item;
	private ListNode next;
	
	public ListNode(Item item){
		this.item = item;
	}
	public void setItem(Item item){
		this.item = item;
	}
	public Item getItem(){
		return this.item;
	}
	
	public void setNext(ListNode next){
		this.next = next;
	}
	public ListNode getNext(){
		return this.next;
	}
}
