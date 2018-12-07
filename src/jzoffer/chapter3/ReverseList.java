package jzoffer.chapter3;

/**
 * 将单项链表进行反转
 */
public class ReverseList {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>();
        head.value = 1;
        Node<Integer> addNode = head;

        for (int i = 2; i < 2; i++) {
            addNode.next = new Node<>();
            addNode = addNode.next;
            addNode.value = i;
        }

        Node<Integer> reverseHead = reverse(head);

        while (reverseHead != null) {
            System.out.println(reverseHead.value);
            reverseHead = reverseHead.next;
        }
    }


    public static <T> Node<T> reverse(Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<T> first, second, third;
        first = head;
        second = first.next;
        third = first.next.next;
        first.next = null;
        while (third != null) {
            second.next = first;
            first = second;
            second = third;
            third = third.next;
        }

        second.next = first;
        return second;
    }


    static class Node<T> {
        T value;
        Node<T> next;
    }

}
