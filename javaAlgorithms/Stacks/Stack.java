package javaAlgorithms.Stacks;

public interface Stack<Item> extends Iterable<Item> {
	public void push(Item input);
	public Item pop();
	public boolean isEmpty();
}
