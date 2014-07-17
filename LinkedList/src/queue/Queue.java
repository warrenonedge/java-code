package queue;

import linkedList.LinkNode;
import linkedList.LinkedList;

public class Queue extends LinkedList {
	LinkedList queue;
	LinkNode first,last;
	
	public Queue() {
		this.first = null;
		this.last = this.first;
	}
	
	public Queue(int[] item) {
		this.queue.insertBeg(item);
		this.first = queue.getHead();
		this.last = this.first;		
	}
	
	public Queue(int[] item1, int[] item2) {
		this.queue.insertBeg(item1);
		this.queue.insertEnd(item2);
		this.first = this.getHead();
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
		if (first != null) {
			LinkNode removed = first;
			first = first.getNext();
			if (first == null) last = null;
			return removed;
		}
		return first;
	}
}
