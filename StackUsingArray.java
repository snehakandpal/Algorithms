import java.util.*;

public class StackUsingArray {

	private int capacity = 5;
	private int[] stack = new int[capacity];
	private int t = -1;
	
	void push(int num) {
		if(size() == capacity)
			throw new StackOverflowError();
		t += 1;
		stack[t] = num;
		System.out.println("Pushed element :" + stack[t]);
		System.out.println("Stack :");
		printStack();
	}
	
	void pop() {
		if(isEmpty())
			throw new EmptyStackException();
		System.out.println("Popped element :" + stack[t]);
		t -= 1;
		System.out.println("Stack :");
		printStack();
	}
	
	int top() {
		if(isEmpty())
			throw new EmptyStackException();
		return t;
	}
	
	boolean isEmpty() {
		return t < 0;
	}
	
	int size() {
		return t + 1;
	}
	
	void printStack() {
		for(int i = 0; i < size(); i++) {
			System.out.println(stack[i]);
		}
	}
	
	public static void main(String[] args) {
		StackUsingArray sa = new StackUsingArray();  
		sa.push(23);  
		sa.push(2);  
		sa.push(73);  
		sa.push(21);  
		sa.push(1);
		System.out.println("Size of stack = " + sa.size());
		System.out.println("Index of top element " + sa.top() + ".");
		System.out.println();
		
		sa.pop();  
		sa.pop();  
		sa.push(44);
		sa.pop();  
		sa.pop(); 
		System.out.println("Size of stack = " + sa.size());
		System.out.println("Index of top element " + sa.top() + ".");
	}
}
