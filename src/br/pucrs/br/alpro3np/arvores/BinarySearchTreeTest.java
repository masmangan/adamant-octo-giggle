package br.pucrs.br.alpro3np.arvores;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void testEmptyTree() {
		BinarySearchTree tree = new BinarySearchTree();
		String expected = "BinarySearchTree [root= # ]";
		String actual = tree.toString();
		assertEquals("Fail querying empty tree!", expected, actual);
	}

	@Test
	public void testAddObject() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.addObject(42);
		String expected = "BinarySearchTree [root= 42 [ # ][ # ]]";
		String actual = tree.toString();
		assertEquals("Fail after addObject()!", expected, actual);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddObjectDuplicateKeys() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.addObject(42);
		tree.addObject(42);
	}

	@Test
	public void testContainsObjectEmptyTree() {
		BinarySearchTree tree = new BinarySearchTree();
		boolean expected = false;
		boolean actual = tree.containsObject(42);
		assertEquals("Fail after searching empty tree!", expected, actual);
	}
	
	@Test
	public void testContainsObjectSimpleTree() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.addObject(42);
		boolean expected = true;
		boolean actual = tree.containsObject(42);
		assertEquals("Fail after searching empty tree!", expected, actual);
	}

}
