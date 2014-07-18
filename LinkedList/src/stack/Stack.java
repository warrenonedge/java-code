package stack;

import linkedList.LinkedList;
import linkedList.LinkNode;

public class Stack {
	LinkedList stack = new LinkedList();
	LinkNode top = new LinkNode();

	public Stack() {
		this.setTop();
	}
	
	public Stack(int[] item) {
		this.stack.insertBeg(item);
		this.setTop();
	}
	
	public void push(int [] item) {
		stack.insertBeg(item);
		this.setTop();
	}
	
	public LinkNode pop() {
		if (this.top == null) return this.top;
		LinkNode removed = this.top;
		this.stack.removeBeg();
		this.setTop();
		return removed;
	}
	
	public void setTop() {
		this.top = this.stack.getHead();
	}
	
	public LinkNode getTop() {
		return this.top;
	}
	
	public LinkedList getStack() {
		return this.stack;
	}
	
	public int length() {
		return this.stack.length();
	}
	
	public String toString() {
		return "Stack" + this.stack.toString().substring(10);
	}
	
	public void print() {
		System.out.println(this.toString());
		System.out.print("Top: ");
		this.top.print();
	}
}
