package br.pucrs.br.alpro3np.arvores.testes;

import br.pucrs.br.alpro3np.arvores.BinarySearchTree;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		System.out.println("Teste");
		BinarySearchTree tree = new BinarySearchTree();

		for (int i = 1; i <= 1024; i++) {
			tree.addObject(i);			
		}
		
		System.out.println(tree);		
		System.out.println(tree.isBalanced());
		System.out.println(tree.getMax());
		System.out.println(tree.getPath(30));
		
	}
}
