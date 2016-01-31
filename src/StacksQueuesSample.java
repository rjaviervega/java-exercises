public class StacksQueuesSample {
	
	public static void main (String args[]) {
		
		System.out.println("MyQueue Sample");
		
		MyQueue mq = new MyQueue();
		
		mq.enq(1);
		mq.enq(2);
		mq.enq(3);
		
		System.out.println("Deq:" + mq.deq());
		System.out.println("Deq:" + mq.deq());
		System.out.println("Deq:" + mq.deq());				
		
		System.out.println("Min Stacks Sample");
		
		MinStack st = new MinStack();

		st.push(5, true);
		st.push(2, true);
		st.push(3, true);
		st.push(1, true);
		st.push(4, true);
		
		System.out.print("Pop:"+st.pop(true)+"\n");
		System.out.print("Min:"+st.getMin()+"\n");				
		System.out.print("Pop:"+st.pop(true)+"\n");
		System.out.print("Min:"+st.getMin()+"\n");				
		System.out.print("Pop:"+st.pop(true)+"\n");
		System.out.print("Min:"+st.getMin()+"\n");				
		System.out.print("Pop:"+st.pop(true)+"\n");			
		System.out.print("Min:"+st.getMin()+"\n");							
		System.out.print("Pop:"+st.pop(true)+"\n");		
		System.out.print("Min:"+st.getMin()+"\n");		
		
		System.out.println("Queue Sample");
		
		Queue q = new Queue(1);

		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		
		System.out.print("Num:"+q.dequeue()+"\n");
		System.out.print("Num:"+q.dequeue()+"\n");
		System.out.print("Num:"+q.dequeue()+"\n");
		System.out.print("Num:"+q.dequeue()+"\n");						
		System.out.print("Num:"+q.dequeue()+"\n");		
		
				
		System.out.println("ArrayStack Sample");
		
		ArrayStack aq = new ArrayStack();

		aq.enqueue(2);
		aq.enqueue(3);
		aq.enqueue(4);
		aq.enqueue(5);
		
		System.out.print("Num:"+aq.dequeue()+"\n");
		System.out.print("Num:"+aq.dequeue()+"\n");
		System.out.print("Num:"+aq.dequeue()+"\n");
		System.out.print("Num:"+aq.dequeue()+"\n");						
		System.out.print("Num:"+aq.dequeue()+"\n");		
		
	}
			
}