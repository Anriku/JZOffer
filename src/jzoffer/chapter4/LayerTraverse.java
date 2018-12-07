package jzoffer.chapter4;

import java.util.LinkedList;

/**
 * 二叉树的层序遍历。通过队列来实现
 */
public class LayerTraverse {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(8);
        head.left = new Node<>(6);
        head.right = new Node<>(10);
        head.left.left = new Node<>(5);
        head.left.right = new Node<>(7);
        head.right.left = new Node<>(9);
        head.right.right = new Node<>(11);
        traverse(head);
    }

    public static <T> void traverse(Node<T> head) {
        LinkedList<Node<T>> queue = new LinkedList<>();
        queue.offerLast(head);

        while (queue.size() > 0) {
            Node<T> node = queue.pollFirst();
            System.out.println(node.value);
            if (node.left != null) {
                queue.offerLast(node.left);
            }
            if (node.right != null) {
                queue.offerLast(node.right);
            }
        }
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
