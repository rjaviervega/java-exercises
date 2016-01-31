/*
* Queue implementation using two Stacks.
* Enqueue & Queue Stacks.
*/
public class MyQueue {
	MyStack enq, deq;
	
	public MyQueue() {
		enq = new MyStack();
		deq = new MyStack();
	}
	
	public void enq(int item) {
		enq.push(item);
	}
	
	public int deq() {
		shiftStacks();
		Integer r = deq.pop();				
		return r;
	}

	//
	// Move all elements to second stack
	//	
	private void shiftStacks() {
		if (deq.size==0) {
			Integer i = enq.pop();
			while (i!=null) {
				deq.push(i);
				i = enq.pop();
			}			
		}
	}		
}