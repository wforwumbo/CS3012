package lca;

public class lca {

	public static void main(String[] args) {
				
	}
	
	Node root;			// Starting Node in tree

	/* Auxiliary Node Class will store values and keep reference to each child */
	class Node{
		int data;
		Node left,right;		//Left and Right Child
		
		Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	/* addRecursive -- Method to insert a new node */
	private Node addRecursive(Node current, int data){
		/* Reached Leaf Node, insert new Node */
		if(current == null){
			return new Node(data);	//Create new Node and Return
		}
		/* New Node data is less than Current Node: Go to left Child */
		if(data < current.data){
			current.left = addRecursive(current.left, data);
		}
		/* New Node Value > Current Node: Go to right Child */
		else if(data > current.data){
			current.right = addRecursive(current.right, data);
		}
		/* Value Already Exists */
		else{
			return current;
		}

		return current;
	}

	public void add(int data){
		root = addRecursive(root, data); //Begins recursion from root Node
	}
	
	/* createBinaryTree() - Used to create Binary Tree to run tests on */
	public lca createBinaryTree(){
		lca binarytree = new lca();

		binarytree.add(6);			//			    6	
		binarytree.add(4);			//			 _______
		binarytree.add(8);			//			/		\
		binarytree.add(3);			//		   4         8
		binarytree.add(5);			//		  / \       / \
		binarytree.add(7);			//		 3   5     7   9
		binarytree.add(9);

		return binarytree;
	}

	/* containsNodeRecursive() - Recursively checks if tree contains specified value */
	private boolean containsNodeRecursive(Node current, int data){
		if(current == null){
			return false;
		}
		if( data == current.data){
			return true;
		}
		return data < current.data
			?containsNodeRecursive(current.left, data)
			:containsNodeRecursive(current.right, data);
	}

	/* Public Method that starts containsNodeReursive from the root */
	public boolean containsNode(int data){
		return containsNodeRecursive(root, data);
	}

	/*deleteRecursive() - Recursively traverses tree to find Node to Delete */
	private Node deleteRecursive(Node current, int data){
		/* Empty Tree or Node not found */
		if(current == null){
			return null;
		}
		/* Node to delete found */
		if(data == current.data){
			/* Node is leaf node */
			if(current.left == null && current.right == null){
				return null;
			}
			/* Node has one child */
			if(current.right == null){
				return current.left;	// return non null child so it can be assigned to parent node
			}
			if(current.left == null){
				return current.right;
			}
			int smallestValue = findSmallestValue(current.right);
			current.data = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}
		/* Data < CurrentNodeData so go left */
		if(data < current.data){
			current.left = deleteRecursive(current.left, data);
			return current;
		}
		/* Data > CurrentNodeData so go right */
		current.right = deleteRecursive(current.right, data);
		return current;
	}


	private int findSmallestValue(Node root){
		return root.left == null ? root.data : findSmallestValue(root.left);
	}

	/*Public method that starts deletion from the root */
	public void delete(int data){
		root = deleteRecursive(root, data);
	}

	/* Method to check if tree is empty */
	public boolean isEmpty(){
			if(root == null) return true;
			else return false;
	}
	
	/* LCA Implementation */
	public static Node lowestCommonAncestor(Node root, Node a, Node b) {
		if(root == null)
			return null;
		if(root.data == a.data || root.data == b.data )
			return root;
 
		Node left=lowestCommonAncestor(root.left,a,b);
		Node right=lowestCommonAncestor(root.right,a,b);
 
		// If we get left and right not null , it is lca for a and b
		if(left!=null && right!=null)
			return root;
		if(left== null)
			return right;
		else
			return left;
 
	}

	
}