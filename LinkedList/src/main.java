import linkedList.LinkedList;
import linkedList.LinkNode;


public class main {

	public static void main(String[] args) {
		int [] data = {1,2,3,4,5,6};
		LinkedList head = new LinkedList(data);
		head.print();
		System.out.println("Linked List Printed 1");
		int [] data1 = {5,5,4,5,4,8,9,8};
		head.insertEnd(data1);
		head.print();
		System.out.println("Linked List Printed 2");
		int [] data2 = {2,3,2,2,1};
		head.insertBeg(data2);
		head.print();
		System.out.println("Linked List Printed 3");
		System.out.println(head.length());
		LinkNode n = head.get(1);
		n.print();
		head.print();
		head.removeBeg();
		head.print();
		head.insertBeg(data2);
		head.print();
		LinkedList test = new LinkedList(data);
		test.removeBeg();
		test.print();
		head.print();
		head.removeEnd();
		head.print();
		head.insertEnd(data1);
		head.print();
		head.removeAt(1);
		head.print();
		head.insertAt(1, data);
		head.print();
		int [] insert = {0,0,0};
		head.insertAt(3, insert);
		head.print();
		head.fillTo(10);
		head.print();
		System.out.println(String.format("%s[3] = %d",head.get(1),head.get(1).getData()[3]));
	}

}
