package jzoffer.chapter3;

/**
 * 删除单项链表倒数第k个节点
 *
 * 双指针还可以解决下面的问题：
 * 1. 求单向链表的中间节点。两个指针：一个指针一次走一步，另一个指针一次走两步。
 * 2. 判断单项链表是否是一个环。同样两个指针：一个指针一次走一步，另一个指针一次走两步。如果第二个指针走完了。仍然没有追上第一个指针。
 * 就说明不是一个环。
 */
public class LinkListReverseNode {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>();
        head.value = 1;
        Node<Integer> addNode = head;

        for (int i = 2; i < 10; i++) {
            addNode.next = new Node<>();
            addNode = addNode.next;
            addNode.value = i;
        }

        Node<Integer> traverseNode = getReverseNode(head, 9);

        while (traverseNode != null){
            System.out.println(traverseNode.value);
            traverseNode = traverseNode.next;
        }
    }

    public static  <T> Node<T> getReverseNode(Node<T> head, int reversePosition) {
        if (head == null || reversePosition <= 0) {
            return head;
        }

        Node<T> puppet = new Node<>();
        Node<T> first, second;
        puppet.next = head;
        first = second = puppet;

        for (int i = 0; i <= reversePosition; i++) {
            if (second != null) {
                second = second.next;
            } else {
                return head;
            }
        }

        while (second != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return first.next;
    }

    static class Node<T> {
        T value;
        Node<T> next;
    }
}
