package JZOffer.chapter2;

/**
 * 通过中序遍历和前序遍历重建二叉树，并用后序遍历输出
 */
public class BuildBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = construct(new Integer[]{1, 2, 4, 7, 3, 5, 6, 8}, 0, 7,
                new Integer[]{4, 7, 2, 1, 5, 3, 8, 6}, 0, 7);


        traverseBinaryTree(root);
    }

    public static <T> void traverseBinaryTree(BinaryTreeNode<T> root) {

        if (root == null) {
            return;
        }

        traverseBinaryTree(root.right);
        traverseBinaryTree(root.left);
        System.out.println(root.value);
    }


    public static <T> BinaryTreeNode<T> construct(T[] preOrders, int startPre, int endPre,
                                                  T[] inOrders, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        int inTemp = startIn;
        BinaryTreeNode<T> root = new BinaryTreeNode<>();
        root.value = preOrders[startPre];
        root.left = root.right = null;

        if (startPre == endPre) {
            if (startIn == endIn && preOrders[startPre] == inOrders[startIn]) {
                return root;
            }
        }

        while (inOrders[inTemp] != root.value) {
            inTemp++;
        }

        int leftLength = inTemp - startIn;
        root.left = construct(preOrders, startPre + 1, startPre + leftLength,
                inOrders, startIn, inTemp - 1);
        root.right = construct(preOrders, startPre + leftLength + 1, endPre,
                inOrders, inTemp + 1, endIn);
        return root;
    }


    static class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }

}
