package br.pucrs.br.alpro3np.arvores.testes;

import br.pucrs.br.alpro3np.arvores.BinarySearchTree;

public class CharBinarySearchTreeTest {
	public static void main(String[] args) {
		System.out.println("Teste");
		BinarySearchTree<Character> tree = new BinarySearchTree<>();
		char cs[] = { 'C', 'E', 'I', 'K', 'O', 'F', 'N', 'G', 'S', 'U', 'P', 'T' };
		for (char c : cs) {
			tree.addObject(c);
		}

		System.out.println(tree);
//		System.out.println(tree.isBalanced());
//		System.out.println(tree.getMax());
//		System.out.println(tree.getPath(30));

	}
}
