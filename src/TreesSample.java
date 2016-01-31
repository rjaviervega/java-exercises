/*
* Tree Sample Implementation and Practice Problems
* This class implemented a simple tree data structure
* using MyTreeNode Nodes.
*/

import java.util.*;

public class TreesSample {
	
	static boolean found = false;
	
	public static void main(String args[]) {
		
		System.out.println("Tree Sample:");
		
		// Create & Print Tree
		//
		MyTreeNode tree = new MyTreeNode(0);
		addMyTreeNodes(tree, 0, 14);														
		tree.printTree(tree);		
		System.out.println("Is Balanced: " + isBalanced(tree));
		//
		
		// Create Binary Search Tree From Array
		//
		int[] intList = new int[15];
		
		for (int i=0; i<intList.length; i++) {
			intList[i] = i;
		}
		MyTreeNode binarySearchTree = createBinarySearchTreeFromArray(intList);
		if (binarySearchTree!=null) {
			binarySearchTree.printTree(binarySearchTree);
		}
		//
		
		// Create Linked Lists for Each Depth
		// and print lists.
		linkedListForEachDepth(binarySearchTree);
		
		System.out.println("");
		
		System.out.println("Testing if Tree is Search Binary Tree:");
		System.out.println("======================================");
		System.out.println("isSearchBinaryTree:" + isBinarySearchTree(tree) );
		System.out.println("isSearchBinaryTree:" + isBinarySearchTree(binarySearchTree) );
		
		System.out.println("");
		
		System.out.println("Pre Order Traversal:");		
		preOrderTraversal(tree);		
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("In Order Traversal:");		
		inOrderTraversal(tree);		
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("Post Order Traversal:");		
		postOrderTraversal(tree);		
		
		System.out.println("");
		System.out.println("");
				
		System.out.println("Find Common Ancestor");
		System.out.println("====================");
		
		MyTreeNode tree2 = new MyTreeNode(2);
		MyTreeNode tree3 = new MyTreeNode(3);
		MyTreeNode tree4 = new MyTreeNode(4);
		MyTreeNode tree5 = new MyTreeNode(5);
		MyTreeNode tree6 = new MyTreeNode(6);
		MyTreeNode tree7 = new MyTreeNode(7);
		MyTreeNode tree8 = new MyTreeNode(8);
		
		tree2.left  = tree3;
		tree2.right = tree4;
		tree3.left  = tree5;
		tree3.right = tree6;
		tree4.left  = tree7;
		tree4.right = tree8;
		
		tree2.printTree(tree2);		
		
		findCommonAncestor(tree2, tree5, tree7);
		findCommonAncestor(tree2, tree7, tree8);
		
	}
	
	
	public static void addMyTreeNodes(MyTreeNode root, int i, int max) {
		ArrayDeque<MyTreeNode> q = new ArrayDeque<MyTreeNode>();
		
		q.add(root);
		
		while(!q.isEmpty() && i<max) {
			MyTreeNode n = q.poll();
			if (n.left==null) {
				n.left = new MyTreeNode(++i);
				q.add(n.left);
			}
			if (n.right==null) {
				n.right = new MyTreeNode(++i);
				q.add(n.right);
			}
		}
	}
	
	
	public static boolean isBalanced(MyTreeNode root) {
		
		if (root==null) return true;
		
		int h = root.getTreeHeight(root.left) - 
				root.getTreeHeight(root.right);
				
		if (h>1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
		
	}
	

	public static MyTreeNode createBinarySearchTreeFromArray(int[] intArray) {
		
		System.out.println("");
		System.out.println("Integers Array:");
		
		for(int i=0; i<intArray.length; i++) {
			if (i>0) System.out.print(",");
			System.out.print(i);
		}
		System.out.println("");
		
		return binaryST(intArray);
	}
	
	public static MyTreeNode binaryST(int[] intArray) {
		if (intArray.length==0) return null;

		int midIndex = intArray.length/2;		
		int midValue = intArray[midIndex];
		
		MyTreeNode n = new MyTreeNode(midValue);
		
		n.left = binaryST(Arrays.copyOfRange(intArray, 0, midIndex));		
		n.right = binaryST(Arrays.copyOfRange(intArray, ++midIndex, intArray.length));
		
		return n;		
	}


	public static void linkedListForEachDepth(MyTreeNode root) {
		
		System.out.println("");
		System.out.println("LinkedList for Each Depth:");
		System.out.println("==========================");
		
		ArrayList<Node> lists = new ArrayList<Node>();
		
		traverse(root, lists, 0);
		
		int i=0;
		for (Node n: lists) {
			System.out.print("List #"+ i++ +": ");
			while(n!=null) {
				System.out.print(n.data+",");
				n = n.next;
			}
			System.out.println("");
		}
	}
	
	public static void traverse(MyTreeNode n, ArrayList<Node> lists, int depthIndex) {
		if (n==null) return;
		
		if (lists.size()>depthIndex) {
			Node l = lists.get(depthIndex);	
			l.appendDataToTail(n.data);
		}
		else {
			Node l = new Node(n.data);
			lists.add(l);
		}
		
		int newDepth = ++depthIndex;
		
		traverse(n.left, lists, newDepth);
		traverse(n.right, lists, newDepth);					
	}


	//
	// Check if Binary Tree is Binary Search Tree
	//
	public static boolean isBinarySearchTree(MyTreeNode root) {
		
		// DFS - each node should be higher or equal to left, and
		// less than node on right.
		if (root==null) return true;
		
		if (root.left !=null && root.data < root.left.data)
			return false;
		
		if (root.right !=null && root.data > root.right.data )
			return false;			
		
		return isBinarySearchTree(root.left) && isBinarySearchTree(root.right);
	}


	//
	// Tree Traversal
	//
	public static void preOrderTraversal(MyTreeNode root) {
		if (root==null) return;
		System.out.print(root.data+",");		
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public static void inOrderTraversal(MyTreeNode root) {
		if (root==null) return;
		inOrderTraversal(root.left);
		System.out.print(root.data+",");		
		inOrderTraversal(root.right);
	}

	public static void postOrderTraversal(MyTreeNode root) {
		if (root==null) return;				
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data+",");		
	}
	
	
	//
	// Find the first common ansestor of two nodes
	//
	public static void findCommonAncestor(MyTreeNode root, MyTreeNode n1, MyTreeNode n2)
	{
		System.out.println("Common Ancestor Between: "+ n1.data +" & "+ n2.data);
		
		// Depth First Seach #1, DFS #2
		// Iterate over nodes til match if sound
		Stack p1 = new Stack();
		Stack p2 = new Stack();
		
		found = false;
		findPath(root, n1, p1);
		// Reset Found Flag
		found = false;
		findPath(root, n2, p2);
		
		// Iterate over p1 & p2 until ancestor is found
		// which is node where they diverge
		MyTreeNode n3 = null;
		MyTreeNode n4 = null;
		MyTreeNode n5 = null;
				
      	while (!p1.isEmpty() && !p2.isEmpty()) {
			n3 = (MyTreeNode) p1.pop();	
			n4 = (MyTreeNode) p2.pop();	
			if (n3 == n4) {
				System.out.println("Found Common Ancestor:"+ n3.data);
				break;
			} 
		}
		
		
	}
	
	
	//
	// DFS adding Nodes to path
	// Leave tree when Path is found.
	//
	public static void findPath(MyTreeNode root, MyTreeNode end, Stack path)
	{
		if (root==null) return;
		if (found) return;
				
		path.push(root);
//		System.out.println("Pushed:"+ root.data);
		if (root==end) {
			found = true;
			return;		
		}
		findPath(root.left, end, path);
		findPath(root.right, end, path);		
		
		if (found) return;
		
//		System.out.println("Poped:"+ root.data);				
		MyTreeNode nr = (MyTreeNode) path.pop();		
	}
	
	
	
	

}










class MyTreeNode {
	public MyTreeNode left = null;
	public MyTreeNode right = null;
	
	int data;
	
	boolean visited = false;
	
	public MyTreeNode(int v) {
		data = v;
	}	
	
	public void setData(int v) {
		data = v;
	}
	
	// Print All Nodes with (x,x)(x,x)(a,b)(c,d) format 
	//
	public void printTree(MyTreeNode root) {
		ArrayDeque<MyTreeNode> q = new ArrayDeque<MyTreeNode>();		
		q.add(root);
		int h = getTreeHeight(root);
		
		while(!q.isEmpty()) {
			MyTreeNode r = q.poll();
										
			if (h>getTreeHeight(r)) {
//				System.out.println("Tree Height: " + h);				
				System.out.println("");
				h = getTreeHeight(r);
			}
			
			if (r!=null && (r.left!=null || r.right!=null)){
				
				System.out.print("["+r.data+"]:");
				System.out.print("(");
				
				if (r.left!=null) {
					System.out.print(r.left.data+",");				
					q.add(r.left);
				}
				if (r.right!=null) {
					System.out.print(r.right.data);				
					q.add(r.right);	
				} 
				
				System.out.print(") ");			
			}
			
		}
		
	}
	
	public int getTreeHeight(MyTreeNode root) {
		if (root==null || root.left==null) return 0;
		return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
	}
	
	
	
	//
	// Code runs recursevly on O(N), O(H). 
	//
	public int checkHeight(MyTreeNode root) {
		if (root==null) return 0;
		
		int left = checkHeight(root.left);
		if (left==-1) return -1;

		int right = checkHeight(root.right);
		if (right==-1) return -1;
		
		int diff = Math.abs(left-right);
		
		if (diff>1) {
			return -1;
		} else {
			return Math.max(left, right) + 1;
		}
		
	}
	
	

	
}



/*
	// PSUDO CODE FOR BASIC ALGORITHMS
	// ===============================

	//
	// Psudo code for BFS:
	//
	void bfs(TreeNode root) {	
		Queue queue = new Queue();		
		root.visited = true;
		visit(root);
		queue.enqueue(root);
	
		while(!queue.isEmpty()) {
			Node r = queue.dequeu();
			foreach(Node n in r.adj) {
				if (n.visited==false) {
					visit(n);
					n.visited = true;
					queue.enqueue(n);
				}
			}			
		}	
	}
	
	//
	// Psudo code for DFS
	// 
	void dfs(TreeNode root) {
		if (root==null) return;
		visit(root);
		root.visited = true;
		
		foreach (Node n in root.adj) {
			if (n.visted==false) {
				dfs(n);
			}
		}
	}
*/