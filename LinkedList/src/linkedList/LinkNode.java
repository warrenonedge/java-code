package linkedList;
import java.util.Arrays;

public class LinkNode {
	int[] data;
	LinkNode next = null;

	public LinkNode(int[] item) {
		this.data = item;
	}
	
	public int[] getData() {
		return this.data;
	}
	
	public void setDataAt(int index, int num) {
		if (index >= this.data.length) throw new IndexOutOfBoundsException(index);
		this.data[index] = num;
	}
	
	public void setData(int [] item) { 
		this.data = item;
	}
	
	public void setNext(LinkNode next) {
		this.next = next;
	}
	public int length() {
		return this.data.length;
	}
	public boolean hasNext() {
		if (this.next == null)
			return false;
		return true;
	}

	public String toString() {
		return ("LinkedNode("+Arrays.toString(this.data)+")");
	}
	
	public void print() {
		System.out.println(this.toString());
	}
}