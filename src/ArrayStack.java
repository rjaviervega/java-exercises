/*
* Simple Stack Implementation with Array
*
*/

public class ArrayStack 
{	
	int count;
	int data[];
	
	public ArrayStack() {
		count = 0;
	}
	
	public int dequeue() {
		count--;
		if(count>=0) return data[count]; else return -1;		
	}
	
	public void enqueue(int item) {		
		if (data==null) {
			data = new int[1];
			count = 0;
		}
							
		if (data.length<count+1) {
			int ndata[] = new int[count+1];			 
			for (int i=0; i<count; i++)  ndata[i] = data[i];			
			ndata[count] = item;
			count++;			
			data = ndata;
		} 
		else {
			data[count]=item;
			count++;
		}		
	}
	
}