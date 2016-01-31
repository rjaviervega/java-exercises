/*
* Linked List Class Sample
*
* This class uses the Node Class, tests some of its methods
* and prints out results of the Linked List.
*/

public class LinkedListSample {
	
	public static void main (String args[]) {
		System.out.println("Single Link Lists - Nodes");
		System.out.println("=========================");
		
		System.out.println("");
		
		Node n = new Node(1);		
		n.appendDataToTail(2);
		n.appendDataToTail(3);
		n.appendDataToTail(4);		
		n.appendDataToTail(1);
		n.appendDataToTail(1);
		n.appendDataToTail(1);				
		n.appendDataToTail(5);
		n.appendDataToTail(5);
		n.appendDataToTail(6);		
		n.appendDataToTail(3);

		// Print All Nodes
		n.print(n);		
		
		System.out.println("");
		
		// Partition Nodes By Value
		System.out.println("Partition Nodes By Value");
		System.out.println("========================");
		Node n2 = n.partitionByValue(n, 3);
		
		// Print Partitioned Nodes
		n2.print(n2);		
		
		System.out.println("");
		
		System.out.println("Number with Digits as Nodes in Linked List");
		System.out.println("==========================================");
		
		Node n3 = new Node(7);		
		n3.appendDataToTail(1);
		n3.appendDataToTail(6);

		Node n4 = new Node(5);		
		n4.appendDataToTail(9);
		n4.appendDataToTail(2);
		
		Node n5 = n.addNumberNodes(n3, n4);
		
		// Print Results
		n5.print(n5);
	}
	
}