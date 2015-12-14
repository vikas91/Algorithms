package javaAlgorithms.Queues;

public interface Queue<Item> {
	public void enqueue(Item input);
	public Item dequeue();
}
