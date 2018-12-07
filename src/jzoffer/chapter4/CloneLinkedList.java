package jzoffer.chapter4;

/**
 * 复制复杂链表
 */
public class CloneLinkedList {


    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(10);
        head.next.next.next = new Node<>(12);
        head.next.next.next.next = new Node<>(5);
        head.next.next.next.next.next = null;

        head.sibling = head.next.next.next;

        Node<Integer> ret = cloneList(head);

        while (ret != null) {
            System.out.println(ret.value);
            if (ret.sibling != null){
                System.out.println("sibling " + ret.sibling.value);
            }
            ret = ret.next;
        }
    }

    public static <T> Node<T> cloneList(Node<T> head) {
        cloneNodes(head);
        connectSibling(head);
        return getClonedList(head);
    }

    public static <T> void cloneNodes(Node<T> head) {
        Node<T> node = head;
        while (node != null) {
            Node<T> clonedNode = new Node<>(node.value);
            clonedNode.next = node.next;
            clonedNode.sibling = null;
            node.next = clonedNode;
            node = clonedNode.next;
        }
    }

    public static <T> void connectSibling(Node<T> head) {
        Node<T> node = head;
        Node<T> clonedNode;

        while (node != null) {
            clonedNode = node.next;
            if (node.sibling != null) {
                clonedNode.sibling = node.sibling.next;
            }
            node = clonedNode.next;
        }
    }

    public static <T> Node<T> getClonedList(Node<T> head) {
        Node<T> node = head;
        Node<T> clonedHead = null;
        Node<T> clonedNode = null;

        if (node != null) {
            clonedHead = clonedNode = node.next;
            node = node.next.next;
        }

        while (node != null) {
            clonedNode.next = node.next;
            clonedNode = clonedNode.next;
            node = node.next.next;
        }
        return clonedHead;
    }

    static class Node<T> {
        T value;
        Node<T> next;
        Node<T> sibling;

        public Node(T value) {
            this.value = value;
        }
    }

}
