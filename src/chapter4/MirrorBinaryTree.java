package chapter4;

/**
 * 获取二叉树的镜像
 */
public class MirrorBinaryTree {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(8);
        head.left = new Node<>(6);
        head.right = new Node<>(10);

        head.left.left = new Node<>(5);
        head.left.right = new Node<>(7);

        head.right.left = new Node<>(9);
        head.right.right = new Node<>(11);

        preOrderTraverse(head);
        Node<Integer> changeHead = getMirrorBinaryTree(head);
        System.out.println("==========================");
        preOrderTraverse(changeHead);
    }

    public static <T> Node<T> getMirrorBinaryTree(Node<T> head) {
        if (head == null) {
            return null;
        }

        Node<T> temp = head.left;
        head.left = head.right;
        head.right = temp;

        head.left = getMirrorBinaryTree(head.left);
        head.right = getMirrorBinaryTree(head.right);
        return head;
    }

    public static <T> void preOrderTraverse(Node<T> head) {
        if (head == null) {
            return;
        }

        System.out.println(head.value);
        preOrderTraverse(head.left);
        preOrderTraverse(head.right);
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
