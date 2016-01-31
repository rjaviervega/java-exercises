/*
* Simple Implementation of a Stack Class
* using Single Liked List Node. (Node.java)
*
*/
public class MyStack 
{	
	public Node top = null;
	public Integer size = 0;
		
	public MyStack() {
		size = 0;
	}
			
	public void push(int data) {
		if (top==null) {
			top = new Node(data);
			top.next = null;
		} else {
			Node n = new Node(data);
			n.next = top;
			top = n;
		}
		size++;
	}
	
	public Integer pop() {	
		Integer ret = null;
		if (top!=null) {
			ret = top.data;
			top = top.next;
		}	
		size--;							
		return ret;
	}	
	
	public boolean isEmpty() {
		if (size==0) return true; else return false;
	}
	
	public Integer peek() {
		Integer r = null;
		if (top!=null) {
			r = top.data;
		}
		return r;		
	}	
}
