package javaAlgorithms.Queues;

public class QueuesClient {
	public static void main(String args[]){
		LinkedListQueue<Integer> testQueue = new LinkedListQueue<Integer>();
		for(int i=0; i<10; i++){
			testQueue.enqueue(i);
			if(i%2==0){
				testQueue.dequeue();
			}
		}
		testQueue.printNodes();
		System.out.println("End of execution");
	}

}
