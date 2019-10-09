package lca;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class lcaTest {

	@Test
	/* Code to test if binary tree is empty */
	public void testisEmpty() {
		lca binaryTree = new lca();
		assertEquals(true, binaryTree.isEmpty()); // Need to create method to check if tree is empty or maybe create method to calculate length?
	}
	
	@Test
	/* Code to test if binary tree can add new elements */
	public void testInsertNewElements() {
		lca bt = new lca(); 		//Create Binary Tree to run tests on
		bt.createBinaryTree();
		
		/* Contains Elements 6, 4, 8, 3, 5, 7, 9 */
		assertTrue(bt.containsNode(6)); // Return True
		assertTrue(bt.containsNode(4)); // Return True
		assertFalse(bt.containsNode(1)); // Return False
	}
	
	@Test
	/* Code to test if binary tree can add new elements */
	public void testDelete() {
		lca bt = new lca(); 		//Create Binary Tree to run tests on
		bt.createBinaryTree();
		
		assertTrue(bt.containsNode(9));
		bt.delete(9);
		assertFalse(bt.containsNode(9));
		
		
		bt.delete(6);	//Should delete leaf with value = 6
		assertFalse(bt.containsNode(6)); // Need to adjust get method to return false if value is not in tree
	}
	
	/*
	@Test
	/* Code to test if binary tree can calculate lca */
	//public void lca() {
//		lca binaryTree = new lca();
	//	binaryTree.add(7);				//		_7_
	//	binaryTree.add(5);				//     /   \
	//	binaryTree.add(6);				//	 5		 6
		
	//	int lcaIndex = binaryTree.lca(Node a, Node b);	//Need method called lca that will return the index value of the lca of two given nodes
	//	assertEquals(lcaIndex = 0); 
	//}
	

}