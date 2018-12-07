package jzoffer.chapter3;

/**
 * 判断Tree2是不是Tree1的子树
 */
public class FindSubTree {

    public static void main(String[] args) {
        TreeNode<Integer> tree1 = new TreeNode<>(8);
        TreeNode<Integer> tree2 = new TreeNode<>(8);

        tree1.left = new TreeNode<>(7);
        tree1.right = new TreeNode<>(9);

//        tree2.left = new TreeNode<>(7);
//        tree2.right = new TreeNode<>(9);

        System.out.println(findSubTree(tree1, null));
    }

    public static <T> boolean findSubTree(TreeNode<T> tree1, TreeNode<T> tree2) {

        boolean isSubTree = false;

        if (tree1 != null && tree2 != null) {
            isSubTree = verifySubTree(tree1, tree2);
        }
        if (tree1 != null && !isSubTree) {
            isSubTree = findSubTree(tree1.left, tree2);
        }
        if (tree1 != null && !isSubTree) {
            isSubTree = findSubTree(tree1.right, tree2);
        }

        return isSubTree;
    }

    private static <T> boolean verifySubTree(TreeNode<T> tree1, TreeNode<T> tree2) {
        if (tree2 == null) {
            return true;
        }

        if (tree1 == null) {
            return false;
        }

        if (tree1.value != tree2.value) {
            return false;
        }

        return verifySubTree(tree1.left, tree2.left) && verifySubTree(tree1.right, tree2.right);
    }


    static class TreeNode<T> {
        T value;
        TreeNode<T> left;
        TreeNode<T> right;


        public TreeNode(T value) {
            this.value = value;
        }

        public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
