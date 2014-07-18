package queue;

import linkedList.LinkNode;
import linkedList.LinkedList;

public class Queue {
	LinkedList queue = new LinkedList();
	LinkNode first,last = queue.getHead();
	
	public Queue() {
		this.first = null;
		this.last = this.first;
	}
	
	public Queue(int[] item) {
		this.queue.insertBeg(item);
		this.first = this.queue.getHead();
		this.last = this.first;		
	}
	
	public Queue(int[] item1, int[] item2) {
		this.queue.insertBeg(item1);
		this.queue.insertEnd(item2);
		this.first = this.queue.getHead();
		this.last = this.first.getNext();
	}
	
	public void enqueue(int[] item) {
		if (first == null) {
			this.queue.insertEnd(item);
			this.first = this.queue.getHead();
			this.last = this.first;
		}
		else {
			this.last.setNext(new LinkNode(item));
			this.last = this.last.getNext();
		}
		
	}
	
	public LinkNode dequeue() {
		if (this.first == null) return this.first;
		LinkNode removed = this.first;
		//this.first = this.first.getNext();
		this.queue.removeBeg();
		this.first = this.queue.getHead();
		if (this.first == null) this.last = null;
		return removed;
	}
	
	public LinkNode getFirst() {
		return this.first;
	}
	
	public LinkNode getLast() {
		return this.last;
	}
	
	public LinkedList getQueue() {
		return this.queue;
	}
	public int length() {
		return this.queue.length();
	}
	
	public String toString() {
		return "Queue" + this.queue.toString().substring(10);
	}
	
	public void print() {
		System.out.println(this.toString());
		System.out.print("Head: ");
		this.first.print();
		System.out.print("Last: ");
		this.last.print();
	}
}
