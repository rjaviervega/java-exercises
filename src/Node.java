import java.util.*;

/*
* Class: Node
* Implementation of Single Linked List on Java.
*
*/

public class Node 
{	
	Node next = null;
	int data;
	
	public Node(int d) {
		data = d;
	}
	
	public void appendNodeToTail(Node end){
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	} 
	
	public void appendDataToTail(int d) {
		Node newNode = new Node(d);
		Node n = this;
		while (n.next!=null){
			n = n.next;
		}
		n.next = newNode;		
	}
	
	public Node deleteNode(Node head, Node delete) {
		Node n = head;
		
		// Move head to next node
		if (n.data == delete.data) {
			return head.next;
		}
		
		// Else scan list and update pointers
		while (n.next!=null) {
			Node scan = n.next;
			if (scan.data==delete.data) {
				n.next = scan.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	
	//
	// Using runner pointer
	//
	public void removeDuplicates(Node head) {
		Node n = head;		
		while(n!=null) {
			Node n2 = n.next;
			Node prev = n;						
			while (n2!=null) {
				if (n.data == n2.data) {
					prev.next = n2.next;
				} else {
					prev = n2;
				}				
				n2= n2.next;
			}			
			n = n.next;
		}		
	}
	
	//
	// Remove Dups Using HashTable
	//
	public void removeDupsWithHash(Node head) {
		Hashtable hash = new Hashtable();
		Node previus = null;
		while(head!=null) {			
			if (hash.containsKey(head.data)) {
				previus.next = head.next;
			} else {
				previus = head;
				hash.put(head.data, true);				
			}
			head = head.next;						
		}
	}
	
	//
	// Kth to last
	//
	public void kthToLast(Node head, int kToLast) {
		
		Node first = head;
		
		// Find last element
		int eCount = 0;
		Node last = null;
		while (head!=null) {
			eCount++;
			if (head.next==null)
				last = head;
			head = head.next;
		}
		
		System.out.println("Last:" + last.data);
		
		Node kToLastNode = null;
		
		for (int i=0; i<=eCount-kToLast; i++) {
			kToLastNode = first;
			first = first.next;
		}
		
		System.out.println("KthToLast:" + kToLastNode.data);				
	}
	//
	
	
	
	public boolean deleteMeNode(Node n) {
		if (n == null || n.next == null) return false;
		
		n.data = n.next.data;
		n.next = n.next.next;
		
		return true;
	}
	
	
	//
	// Partition list by value higher and lower
	// than 'p'.
	//
	public Node partitionByValue(Node head, int p) {
		
		Node n0, n1=null, n2=null;
		n0 = head;
		
		while (n0!=null) {
			if (n0.data<=p) {
				if (n1==null) n1 = new Node(n0.data); else n1.appendDataToTail(n0.data);
			} else {
				if (n2==null) n2 = new Node(n0.data); else n2.appendDataToTail(n0.data);
			}			
			n0 = n0.next;
		}
		
		Node end = n1;
		while (end.next!=null) {			
			end = end.next;
		}
		end.next = n2;			
		
		return n1;			
	}
	
	
	
	//
	// Print all Nodes to screen
	//
	public void print(Node current) {
		System.out.println("Print All Nodes:");		
		while (current!=null) {
			System.out.println(current.data);
			current = current.next;
		}		
	}
	
	
	//
	// Add numbers of Linked List representing a 
	// number in which the Linked List stores one 
	// digit per node. (Left digit high).
	//
	public Node addNumberNodes(Node n1, Node n2) {
		
		Node res = null;
				
		int i = 0;
		double sum1 = 0; 
		double sum2 = 0;
		
		while (n1!=null) {
			sum1 = (n1.data * Math.pow(10,i)) + sum1;
			n1 = n1.next;
			i++;
		}
		
		i = 0;
		while (n2!=null) {
			sum2 = (n2.data * Math.pow(10,i)) + sum2;
			n2 = n2.next;
			i++;
		}
		
		Double s3 = sum2 + sum1;
		
		while (Math.round(s3.intValue() % 10)>0.1) {
			int p = Math.round(s3.intValue() % 10);
			s3 = s3/10;
			
			if (res==null) res = new Node(p); else res.appendDataToTail(p);
		}
				
		return res;		
	}
	
	
	public boolean detectLoop(Node n) {
		
		// Use runner pointer
		//
		// Run two pointers, one moving 2 times the other (n.next.next);
		// When they intercept, move first point to beginnin;
		// The move forward both pointers by one, and they will 
		// intercept on the loop.
		//
		
		// To be implemented.
		
		return true;
		
	}
	
	
}








