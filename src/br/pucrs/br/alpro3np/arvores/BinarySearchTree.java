package br.pucrs.br.alpro3np.arvores;

/**
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public class BinarySearchTree {

	private Node root;

	/**
	 * 
	 * @param key
	 */
	public void addObject(int key) {
		root = addObject0(root, key);
	}

	/**
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	private Node addObject0(Node node, int key) {
		if (node == null)
			return new Node(key);

		if (key < node.key) {
			node.left = addObject0(node.left, key);
			if (h(node.left) - h(node.right) == 2) {
				System.out.println("Desequilibrada!" + node.key);
			}

		} else if (key > node.key){
			node.right = addObject0(node.right, key);
			if (h(node.left) - h(node.right) == -2) {
				System.out.println("Desequilibrada!" + node.key);
			}

		} else
			throw new IllegalArgumentException(
					Messages.getString("BinarySearchTree.0")); //$NON-NLS-1$

		node.height = 1 + Math.max(h(node.left), h(node.right));

		return node;
	}

	private int h(Node node) {
		return node == null ? -1 : node.height;
	}

	@Override
	public String toString() {
		return String.format("BinarySearchTree %n[root=%s]", //$NON-NLS-1$
				toString0(root));
	}

	private String toString0(Node node) {
		if (node == null)
			return " # "; //$NON-NLS-1$
		int delta = getHeight0(node.left) - getHeight0(node.right);

		String msg = String
				.format(" %d degree = %d level = %d height = %d delta = %d father = ? uncle = ? %n[%s] %n[%s]",
						node.key, degree(node), level(node), h(node), delta,
						toString0(node.left), toString0(node.right));

		return msg;
	}

	private int level(Node node) {
		return level0(root, node, 0);
	}

	private int level0(Node node, Node target, int level) {
		if (target.key < node.key)
			return level0(node.left, target, level + 1);
		else if (target.key > node.key)
			return level0(node.right, target, level + 1);
		else
			return level;
	}

	private int degree(Node node) {
		if (node == null)
			return -1;

		int d = 0;

		if (node.left != null)
			d++;

		if (node.right != null)
			d++;

		return d;
	}

	public boolean containsObject(int key) {
		return containsObject0(root, key);
	}

	private boolean containsObject0(Node node, int key) {
		if (node == null)
			return false;

		if (key < node.key)
			return containsObject0(node.left, key);
		else if (key > node.key)
			return containsObject0(node.right, key);

		return true;
	}

	public int getHeight() {
		return getHeight0(root);
	}

	private int getHeight0(Node node) {
		if (node == null)
			return -1;

		return 1 + Math.max(getHeight0(node.left), getHeight0(node.right));

	}

	public boolean isBalanced() {
		return isBalanced0(root);
	}

	private boolean isBalanced0(Node node) {
		if (node == null)
			return true;

		int delta = getHeight0(node.left) - getHeight0(node.right);

		if (delta == 2 || delta == -2)
			return false;

		return isBalanced0(node.left) && isBalanced0(node.right);

	}

}
