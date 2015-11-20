package br.pucrs.alpro3np.recursividade;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyMathTest {

	@Test
	public void testSumZero() {
		int expected = 0;
		int actual = MyMath.sum(0);
		assertEquals(expected, actual);
	}

	@Test
	public void testSumOne() {
		int expected = 1;
		int actual = MyMath.sum(1);
		assertEquals(expected, actual);
	}	
	
	@Test
	public void testSumTwo() {
		int expected = 3;
		int actual = MyMath.sum(2);
		assertEquals(expected, actual);
	}	
}
