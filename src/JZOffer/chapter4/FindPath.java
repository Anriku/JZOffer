package JZOffer.chapter4;

import java.util.Stack;

/**
 * 给定某个二叉树以及一个数字和。得到某个节点使其路径和为给定数字和
 */
public class FindPath {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(12);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(7);

        findPath(root, 19);
    }

    public static void findPath(BinaryTreeNode root, int expectedNum) {
        if (root == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();

        findPath(root, stack, 0, expectedNum);
    }

    public static void findPath(BinaryTreeNode root, Stack<Integer> stack, int currentSum, int expectedNum) {
        stack.push(root.value);
        currentSum += root.value;
        boolean isLeaf = (root.left == null) && (root.right == null);

        if (isLeaf && currentSum == expectedNum) {
            for (int i : stack) {
                System.out.println(i);
            }
        }

        if (root.left != null) {
            findPath(root.left, stack, currentSum, expectedNum);
        }

        if (root.right != null) {
            findPath(root.right, stack, currentSum, expectedNum);
        }
        int i = stack.pop();
    }

    static class BinaryTreeNode {

        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }
    }
}
