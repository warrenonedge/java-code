package linkedList;
import java.util.Arrays;

public class LinkedList {
	LinkNode head = null;
	int length = 0;

	public LinkedList(int[] item) {
		this.head = new LinkNode(item);
		this.length = 1;
	}

	public LinkedList(int[] item, LinkNode next) {
		this.head = new LinkNode(item);
		this.length = 1;
		if (next != null)
			this.length += 1;
		this.head.next = next;

	}

	public void insertEnd(int[] item) {

		LinkNode newNode = new LinkNode(item);
		if (this.length == 0) {
			this.head = newNode;
			this.length += 1;
			return;
		}
		LinkNode find = this.get(this.length-1);
//		while (find.hasNext()) {
//			find = find.next;
//		}
		find.next = newNode;
		this.length += 1;
	}

	public void insertBeg(int[] item) {
		LinkNode newNode = new LinkNode(item);
		if (this.length == 0) {
			this.head = newNode;
			this.length += 1;
			return;
		}
		newNode.next = this.head;
		this.head = newNode;
		this.length += 1;
	}
	
	public void insertAt(int index, int[] item) {
		if (this.length == 0) throw new EmptyLinkedListException(this);
		else if (index == 0) {
			this.insertBeg(item);
			return;
		}
		else if (index == this.length) {
			this.insertEnd(item);
			return;
		}
		LinkNode newNode = new LinkNode(item);
		LinkNode find = this.get(index-1);
		newNode.next = find.next;
		find.next = newNode;
		this.length += 1;
	}
	
	public LinkNode removeBeg() {
		if (this.length == 0) throw new EmptyLinkedListException(this);
		LinkNode temp = this.head;
		this.head = this.head.next;
		this.length -= 1;
		return temp;
	}
	
	
	public LinkNode removeEnd() {
		if (this.length == 0) throw new EmptyLinkedListException(this);
		LinkNode find = this.get(this.length-2);
		LinkNode temp = find.next;
		find.next = null;
		this.length -= 1;
		return temp;
	}
	
	public LinkNode removeAt(int index) {
		if (this.length == 0) throw new EmptyLinkedListException(this);
		LinkNode find = this.get(index-1);
		LinkNode temp = find.next;
		find.next = find.next.next;
		this.length -= 1;
		return temp;
	}
	
	public void fillTo(int index) {
		if (index < this.length) throw new IndexInBoundsException(index);
		else {
			int [] fill = new int [0];
			for (int i = this.length; i <= index; i++) this.insertEnd(fill);
		}
	}
	
	public void fill() {
		int [] fill = new int [0];
		for (int i = 0; i < this.length; i++) this.set(i, fill);
	}
	
	public int length() {
		return this.length;
	}
	
	public LinkNode get(int index) {
		if (index >= this.length) {
			throw new IndexOutOfBoundsException(index);	
		}
		LinkNode find = this.head;
		for (int i = 0; i < index; i++) {
			find = find.next;
		}
		return find;
		
	}
	
	public void set(int index, int [] item) {
		if (index >= this.length) {
			throw new IndexOutOfBoundsException(index);	
		}
		LinkNode find = head;
		for (int i = 0; i < index; i++) {
			find = find.next;
		}
		find.data = item;
	}
	
	public String toString() {
		if (this.head == null) return "LinkedList(null)";
		String result = "LinkedList(";
		LinkNode find = this.head;
		result += String.format("LinkedNode(%s), ", Arrays.toString(find.data));
		while (find.hasNext()) {
			result += String.format("LinkedNode(%s), ",
					Arrays.toString(find.next.data));
			find = find.next;
		}
		result = result.substring(0, result.length() - 2);
		result += ")";
		return result;
	}
	public void print() {
		System.out.println(this.toString());
	}

}

@SuppressWarnings("serial")
class EmptyLinkedListException extends RuntimeException {
	public EmptyLinkedListException(LinkedList list) {
		super(list.toString());
	}
}

@SuppressWarnings("serial")
class IndexOutOfBoundsException extends RuntimeException {
	public IndexOutOfBoundsException(int index) {
		super(String.format("Index: %d",index));
	}
}

@SuppressWarnings("serial")
class IndexInBoundsException extends RuntimeException {
	public IndexInBoundsException(int index) {
		super(String.format("Index: %d",index));
	}
}