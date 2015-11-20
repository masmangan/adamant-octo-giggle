package br.pucrs.br.alpro3np.arvores;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeapTest {

	@Test
	public void testFalse() {
		int[] v = {10, 20, 30, 40};
		boolean expected = false;
		boolean actual = Heap.isHeap(v);
		assertEquals(expected, actual);
	}

	@Test
	public void testLast() {
		int[] v = {30, 20, 10, 15, 5, 40};
		boolean expected = false;
		boolean actual = Heap.isHeap(v);
		assertEquals(expected, actual);
	}	
	@Test
	public void testTrue() {
		int[] v = {30, 20, 10, 15, 5, 4};
		boolean expected = true;
		boolean actual = Heap.isHeap(v);
		assertEquals(expected, actual);
	}	

}
