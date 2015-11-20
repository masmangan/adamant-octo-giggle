package br.pucrs.alpro3np.recursividade;

public class MyMath {

	public static void main(String[] args) {
		System.out.println(MyMath.sum(2));
	}

	
	public static int factorial(int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		return fact(n);
	}
	
	private static int fact(int n) {
		if (n == 0)
			return 1;
		return n * fact(n - 1);
	}
	
	public static int sum(int n) {
		if (n < 0)
			throw new IllegalArgumentException();		
		return s(n);
	}

	private static int s(int n) {
		if (n == 0)
			return 0;
		return n + s(n - 1);
	}
	
	public static boolean isPalindrome(String s) {
		if (s == null)
			throw new IllegalArgumentException();
		s = s.trim();
		if (s.isEmpty())
			throw new IllegalArgumentException();
		return p(s);
	}

	private static boolean p(String s) {
		if (s.isEmpty())
			return true;
		if (s.length() == 1)
			return true;
		if (s.charAt(0) != s.charAt(s.length() - 1))
			return false;
		s = s.substring(1, s.length() - 2);
		return p(s);
	}
	
}
