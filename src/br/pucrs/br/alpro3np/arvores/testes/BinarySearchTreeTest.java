package br.pucrs.br.alpro3np.arvores.testes;

import br.pucrs.br.alpro3np.arvores.BinarySearchTree;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		System.out.println("Teste");
		BinarySearchTree tree = new BinarySearchTree();

		tree.addObject(10);
		tree.addObject(20);
		tree.addObject(30);
		
		System.out.println(tree);		
		System.out.println(tree.isBalanced());
		
	}
}
