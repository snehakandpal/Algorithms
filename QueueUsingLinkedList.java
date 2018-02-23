import java.util.NoSuchElementException;

public class QueueUsingLinkedList {

	private Node first;
	private Node last;
	private int n;
	
	private class Node{
		int item;
		Node next;
	}
	
	void enqueue(int x) {
		//insert at end
		Node oldLast = last;
		last = new Node();
		last.item = x;
		last.next = null;
		if(isEmpty()) {
			first = last;
		}
		else {
			oldLast.next = last;
		}
		System.out.println("Pushed element: " + x);
		n++;
		printQueue();
	}
	
	void dequeue() {
		//remove at beginning
		if (isEmpty()) { 
			throw new NoSuchElementException("Underflow Exception");
		}
		System.out.println("Popped element: " + first.item);
		first = first.next;
		n--;
		if (isEmpty()) { 
			last = null;
		}
		printQueue();	
	}
	
	boolean isEmpty() {
		return first == null;
	}
	
	int size() {
		return n;
	}
	
	void printQueue() {
		for(Node x = first; x != null; x = x.next) {
			System.out.println(x.item);
		}
	}
	
	public static void main(String[] args) {
		QueueUsingLinkedList ql = new QueueUsingLinkedList();
		ql.enqueue(23);  
		ql.enqueue(2);  
		ql.enqueue(73);  
		ql.enqueue(21);  
		ql.enqueue(1);
		System.out.println("Size of queue = " + ql.size());
		System.out.println();
		
		ql.dequeue();  
		ql.dequeue();  
		ql.enqueue(44);
		ql.dequeue();  
		ql.dequeue(); 
		System.out.println("Size of queue = " + ql.size());
	}

}
