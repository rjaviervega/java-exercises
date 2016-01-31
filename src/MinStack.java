/*
* Stack that keeps minimum value stored in O(n) time.
* Implemented with Single Liked List Class (node.java).
*
* This class keeps another stack with minimum values
* in the same order as other values in Stack.
* 
*/
public class MinStack 
{	
	public Node top = null;
	MinStack minStack = null;
	int min = -1;
	
	public static void main(String args[]) {
		System.out.println("MinStack");
	}
		
	public MinStack() {
		// Empty Constructor
	}
			
	public void push(int data, boolean setMin) {
		if (top==null) {
			top = new Node(data);
			top.next = null;
		} else {
			Node n = new Node(data);
			n.next = top;
			top = n;
		}
		if (setMin) this.setMin(data);
	}
	
	public int pop(boolean unsetMin) {	
		int ret = 0;
		if (top!=null) {
			ret = top.data;
			top = top.next;
		}				
		if (unsetMin) minStack.pop(false);							
		return ret;
	}
	
	public int getMin() {
		if (minStack.top!=null) return minStack.top.data; else return 0;
	}
	
	public void setMin(int item) {
		if (minStack==null) minStack = new MinStack();		
		
		if (item<this.min || this.min==-1) {
			minStack.push(item, false);
			this.min = item;
		} else {
			minStack.push(this.min, false);
		}
	}	
}