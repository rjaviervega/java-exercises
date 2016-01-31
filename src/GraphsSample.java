/*
* Graph Simple Implementation and Programming Exercises
* This class implements a simple Graph Data Structure
* and functions to perform basic algorithms on the Graph.
* Algorithms include searching, printing and creating a graph.
*
*/
import java.util.*; 

public class GraphsSample {
	
	public static void main (String args[]) {		
		System.out.println("Graphs Sample");
		System.out.println("=============");
		
		GraphNode n = new GraphNode(0);
		
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);
		GraphNode n8 = new GraphNode(8);		
				
		n.addNode(n1);
		n1.addNode(n3);
		n3.addNode(n4);
		n4.addNode(n1);
		
		n.addNode(n2);
		n2.addNode(n5);
		n2.addNode(n6);
		n6.addNode(n7);
		
		System.out.println("Route: "+ n.route(n7));
	    System.out.println("Route: "+ n.routeBFS(n7));														
	}
}

enum State {
	Unvisited, Visited, Visiting;
}


class GraphNode 
{	
	int data;
	public State state;
	public ArrayList<GraphNode> nodes; 
	
	public GraphNode(int v) {
		nodes = new ArrayList<GraphNode>();
		data = v;
		state = State.Unvisited;
	}
	
	public void addNode(GraphNode n) {
		if (n!=null)
			nodes.add(n);
	}
	
	public boolean route(GraphNode end) {		
		
		if (nodes.size()==0) return false;
		if (this==end) return true;
		
		this.state = State.Visiting;
		
		for (GraphNode n : nodes) {			
			if (n==end) return true;
			if (n.state==State.Unvisited)			
				if (n.route(end)) return true;;
			n.state = State.Visiting;
		}
		
		this.state = State.Visited;
		
		return false;
	}
	
	//
	// Find if there is a route to end Node
	// from initial node.
	//
	public boolean routeBFS(GraphNode end) {
		 ArrayDeque<GraphNode> q = new ArrayDeque<GraphNode>();
				
		if (this==end) return true;
		this.state = State.Visited;		
		q.add(this);
		
		while (!q.isEmpty()) {
			GraphNode g = q.poll();
			if (g!=null) {
				for (GraphNode n: g.nodes) {
					if (n.state==State.Unvisited) {
						if (n==end) return true;
						n.state = State.Visited;
						q.add(n);
					}
				}
			}
			g.state = State.Visited;
		}
				
		return false;
	}	
}