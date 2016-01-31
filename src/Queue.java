/*
* Queue class implementation using Single Linked List
* and first/last nodes.
*/
public class Queue 
{
	Node first, last;
	
	public Queue(int data) {
		first = new Node(data);
		last = first;
	}
	
	public void enqueue(int data) {
		if (first==null) {
			first = new Node(data);
			last = first;			
		} else {
			Node n = new Node(data);
			last.next = n;
			last = n;
		}
	}
	
	public int dequeue(){
		int r = 0;
		if (first!=null) {
			r = first.data;
			first = first.next;
		} 
		return r;
	}
}