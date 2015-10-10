package br.pucrs.br.alpro3np.arvores;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void testEmptyTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		String expected = "BinarySearchTree [root= # ]";
		String actual = tree.toString();
		assertEquals("Fail querying empty tree!", expected, actual);
	}

	@Test
	public void testAddObject() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.addObject(42);
		String expected = String
				.format("BinarySearchTree [root= 42 degree = 0 level = 0 height = 0 delta = 0 father = ? uncle = ? "
						+ "%n[ # ] " + "%n[ # ]]");
		String actual = tree.toString();
		assertEquals("Fail after addObject()!", expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddObjectDuplicateKeys() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.addObject(42);
		tree.addObject(42);
	}

	@Test
	public void testContainsObjectEmptyTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		boolean expected = false;
		boolean actual = tree.containsObject(42);
		assertEquals("Fail after searching empty tree!", expected, actual);
	}

	@Test
	public void testContainsObjectSimpleTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.addObject(42);
		boolean expected = true;
		boolean actual = tree.containsObject(42);
		assertEquals("Fail after searching empty tree!", expected, actual);
	}

}
