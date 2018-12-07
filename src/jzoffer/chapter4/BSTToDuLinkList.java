package jzoffer.chapter4;

/**
 * 二叉搜索树转换为双向链表(还有问题没解决)
 */
public class BSTToDuLinkList {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(10);
        head.left = new Node<>(6);
        head.right = new Node<>(14);
        head.left.left = new Node<>(4);
        head.left.right = new Node<>(8);
        head.right.left = new Node<>(12);
        head.right.right = new Node<>(16);

        Node<Integer> re = convert(head);
        while (re != null) {
            re = re.right;
        }

    }


    public static <T> Node<T> convert(Node<T> head) {
        if (head == null) {
            return null;
        }

        Node<T> lastNodeInList = new Node<>(null);
        convertNode(head, lastNodeInList);

        while (lastNodeInList.left != null) {
            lastNodeInList = lastNodeInList.left;
        }
        return lastNodeInList.right;
    }


    public static <T> void convertNode(Node<T> head, Node<T> lastNodeInList) {

        if (head.left != null) {
            convertNode(head.left, lastNodeInList);
        }

        head.left = lastNodeInList;
        lastNodeInList.right = head;

        lastNodeInList = head;

        if (head.right != null) {
            convertNode(head.right, lastNodeInList);
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
