import java.util.EmptyStackException;

public class StackUsingLinkedList {

	private Node first;
	private int n;
	
	private class Node {
		int item;
		Node next;
	}
	
	void push(int x) {
		Node oldFirst = first;
		first = new Node();
		first.item = x;
		first.next = oldFirst;
		System.out.println("Pushed element: " + x);
		n++;
		printStack();
	}
	
	void pop() {
		if (isEmpty()) 
			throw new EmptyStackException();
		System.out.println("Popped element: " + first.item);
		first = first.next;
		n--;
		printStack();
	}
	
	int size() {
		return n;
	}
	
	void printStack() {
		for(Node x = first; x != null; x = x.next) {
			System.out.println(x.item);
		}
	}
	
	boolean isEmpty() {
		return first == null;
	}
	
	public static void main(String[] args) {
		StackUsingLinkedList sl = new StackUsingLinkedList();
		sl.push(23);  
		sl.push(2);  
		sl.push(73);  
		sl.push(21);  
		sl.push(1);
		System.out.println("Size of stack = " + sl.size());
		System.out.println();
		
		sl.pop();  
		sl.pop();  
		sl.push(44);
		sl.pop();  
		sl.pop(); 
		System.out.println("Size of stack = " + sl.size());
	}
}
