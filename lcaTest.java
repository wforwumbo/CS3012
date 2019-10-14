package lca;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lca.lca.Node;

class lcaTest {

	@Test
	/* Code to test if binary tree can add new elements */
	public void testInsertNewElements() {
		lca bt = new lca(); 		//Create Binary Tree to run tests on
		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);

		/* Contains Elements 6, 4, 8, 3, 5, 7, 9 */
		assertTrue(bt.containsNode(6)); // Return True
		assertTrue(bt.containsNode(4)); // Return True
		assertFalse(bt.containsNode(1)); // Return False
		
		/* Test to see if we can add large amount of Elements */
		for(int i = 0; i < 100; i++) {
			bt.add(i);
		}
		assertTrue(bt.containsNode(99));
		
	}
	
	@Test
	/* Code to test if binary tree can delete elements */
	public void testDelete() {

		lca bt = new lca(); 		//Create Binary Tree to run tests on
		
		//test leaf node delete & lone node delete
		bt.add(5);
		bt.add(6);
		bt.delete(5);
		assertFalse(bt.containsNode(5));
		bt.add(5);
		bt.delete(6);
		assertFalse(bt.containsNode(6));

		
		
		bt.delete(6);
		bt.createBinaryTree();
		
		assertTrue(bt.containsNode(9));
		bt.delete(9);
		assertFalse(bt.containsNode(9));
		
		
		bt.delete(6);
		assertFalse(bt.containsNode(6));
		
		
	}
	
	@Test
	/* Code to test if binary tree is empty */
	public void testisEmpty() {
		lca bt = new lca();		//Binary Tree to run tests on
		bt.createEmptyList();
		
		//Empty Tree
		assertTrue(bt.isEmpty());
		bt.add(5);
		//Tree with one Element
		assertFalse(bt.isEmpty());

	}

	
	
	@Test
	/* Code to test if binary tree can calculate lca */
	public void testLCA() {
		lca bt = new lca(); 		//Create Binary Tree to run tests on	
		bt.createBinaryTree();
		
		// Creating Nodes to represent Nodes in the binary tree bt
		Node node5 = new Node(5);	
		Node node3 = new Node(3);
		Node lowest = bt.lowestCommonAncestor(bt.root, node3, node5); //Check lowest common ancestor of 3 and 5 is 4
		
		// Creating Nodes to represent Nodes in the binary tree bt
		Node node7 = new Node(7);
		Node node9= new Node(9);
		Node lowest2 = bt.lowestCommonAncestor(bt.root, node7, node9);//Check lowest common ancestor of 7 and 9 is 8
		
			//			    6	
			//			 _______
			//			/		\
			//		   4         8
			//		  / \       / \
			//		 3   5     7   9

		
		assertEquals(4, lowest.data); // Need to create method to check if tree is empty or maybe create method to calculate length?
		assertEquals(8, lowest2.data); // Need to create method to check if tree is empty or maybe create method to calculate length?

		
	}
	

}
