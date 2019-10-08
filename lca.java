
public class lca {

	public static void main(String[] args) {
		
		Node root;			// Starting Node in tree
		
	}
	
	/* Node Class To Create Tree */
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
			current.left = addRecursive(currennt.left, data);
		}
		/* New Node Value > Current Node: Go to right Child */
		else if(data > current.data){
			current.right = addRecursive(current.right, value);
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
	private lca createBinaryTree(){
		lca binarytree = new BinaryTree();

		binarytree.add(6);			//			    6	
		binarytree.add(4);			//			 _______
		binarytree.add(8);			//			/		\
		binarytree.add(3);			//		   4         8
		binarytree.add(5);			//		  / \       / \
		binarytree.add(7);			//		 3   5     7   9
		binarytree.add(9);

		return binaryTree;
	}

	/* containsNodeRecursive() - Recursively checks if tree contains specified value */
	private boolean containsNodeRecursive(Node current, int data){
		if(current == null){
			return false;
		}
		if( data == current.data){
			return true;
		}
		return value < current.data
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
			current.value = smallestValue;
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
		return root.left == null ? root.value : findSmallestValue(root.left);
	}

	/*Pubic method that starts deletion from the root */
	public void delete(int data){
		root = deleteRecursive(root, data);
	}

	/* Method to check if tree is empty */
	public boolean isEmpty(){
			if(root == null) return true;
			else return false;
	}

	
}
