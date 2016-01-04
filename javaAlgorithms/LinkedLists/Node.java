package javaAlgorithms.LinkedLists;

public class Node<Item> {
	Item item;
	Node<Item> next;
	
	public Node(Item item){
		this.item=item;
	}
	public void setItem(Item item){
		this.item=item;
	}
	public Item getItem(Item item){
		return this.item;
	}
}
