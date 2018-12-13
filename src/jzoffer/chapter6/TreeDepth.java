package jzoffer.chapter6;

/**
 * 问题一：输入一棵二叉树，求改二叉树的深度。换句话就是求从根节点到页节点经过的最长路径。
 * 其实就是在二叉树的后续遍历上进行一下修改就行。
 * 
 * 问题二：输入一个二叉树节点，判断这棵二叉树是不是平衡二叉树。
 * 
 */
class TreeDepth {

	public static void main(String[] args) {
		Node<Integer> node = new Node<>(1);
		node.left = new Node<>(2);
		node.right = new Node<>(3);
		node.left.left = new Node<>(4);
		node.left.right = new Node<>(5);
		node.left.right.left = new Node<>(7);
		node.right.right = new Node<>(6);
		Depth depth = new Depth();

		System.out.println(isBalance(node, depth));
		System.out.println(depth.depth);
	}

	/**
	 * 获取树的深度
	 *
	 * @param root
	 */
	public static <T> int getTreeDepth(Node<T> root) {
		if (root == null) {
			return 0;
		}

		int left = getTreeDepth(root.left);
		int right = getTreeDepth(root.right);

		return (left > right ? left : right) + 1;
	}


	/**
	 * 判断一棵二叉树是否为平衡二叉树。
	 */
	public static <T> boolean isBalance(Node<T> root, Depth depth) {
		if (root == null) {
			depth.depth = 0;
			return true;
		}

		Depth left = new Depth();
		Depth right = new Depth();
		if (isBalance(root.left, left) && isBalance(root.right, right)) {
			int distance = left.depth - right.depth;
			if (distance >= -1 && distance <= 1) {
				depth.depth = (left.depth > right.depth ? left.depth : right.depth) + 1;
				return true;
			}
		}
		return false;
	}

	static class Depth {
		int depth;
	}

	static class Node<T> {
		T value;
		Node<T> left;
		Node<T> right;

		public Node(T value) {
			this.value = value;
		}
	}

}