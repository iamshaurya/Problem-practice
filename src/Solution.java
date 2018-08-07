import java.io.*;
import java.util.*;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}

}

class Solution {
	public static Node removeDuplicates(Node head) {
		// Write your code here
		if (head == null) {
			return head;
		} else {
			int previous = head.data;
			Node previousNode = head;
			Node lastNode = null;
			boolean remove = false;
			Node temp = head;
			while (temp != null) {
				temp = temp.next;
				if (temp != null && temp.data == previous) {
					remove = true;
					lastNode = temp;
				} else {
					if (remove) {
						remove(previousNode, lastNode);
						lastNode = null;
						remove = false;
					}
					if(temp != null){
						previous = temp.data;
						previousNode = temp;	
					}
					
				}
			}
		}
		return head;
	}

	public static void remove(Node start, Node end) {
		start.next = end.next;
	}


	public static Node insert(Node head, int data) {
		Node p = new Node(data);
		if (head == null)
			head = p;
		else if (head.next == null)
			head.next = p;
		else {
			Node start = head;
			while (start.next != null)
				start = start.next;
			start.next = p;

		}
		return head;
	}

	public static void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Node head = null;
		int T = sc.nextInt();
		while (T-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		head = removeDuplicates(head);
		display(head);

	}
}