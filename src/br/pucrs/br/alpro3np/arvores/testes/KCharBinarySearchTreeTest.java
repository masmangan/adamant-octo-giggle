package br.pucrs.br.alpro3np.arvores.testes;

import br.pucrs.br.alpro3np.arvores.BinarySearchTree;

public class KCharBinarySearchTreeTest {
	public static void main(String[] args) {
		System.out.println("Teste");
		BinarySearchTree<Character> tree = new BinarySearchTree<>();
		char cs[] = { 'N', 'C', 'Q', 'B', 'H' };
		for (char c : cs) {
			tree.addObject(c);
		}
		tree.addObject('K');
		
		System.out.println(tree);
//		System.out.println(tree.isBalanced());
//		System.out.println(tree.getMax());
//		System.out.println(tree.getPath(30));

	}
}
