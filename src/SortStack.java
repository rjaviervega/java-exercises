/*
* This class implements a sorted stack using
* a combination of push and pop calls to 
* sort the values in the stack.
*/
public class SortStack 
{	
	public static void main(String args[]) {

		System.out.println("SortStack Sample");
		
		MyStack s1 = new MyStack();
		
		s1.push(4);
		s1.push(7);
		s1.push(2);
		s1.push(3);
		s1.push(6);
		s1.push(1);
						
		MyStack s2 = sortStack(s1);		
		while (s2.size>0) System.out.println("Stack POP: " + s2.pop() );
	}
		
	public static MyStack sortStack(MyStack s) {
		MyStack r = new MyStack();
		
		while (s.size!=0) {
			int tmp = s.pop();
			while(r.size!=0 && r.peek()!=null && r.peek()>tmp) {
				s.push(r.pop());				
			}
			r.push(tmp);
		}		
		return r;
	}

	public static void log(String s) {
		System.out.println(s);		
	}	
}