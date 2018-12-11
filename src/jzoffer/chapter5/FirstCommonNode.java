package jzoffer.chapter5;

import java.util.Stack;

/**
 * 输入两个链表，找出他们第一个公共节点。
 *
 * 扩展题目：找出二叉树中两个叶节点的最低公共节点。
 */
public class FirstCommonNode {


    /**
     * 基于栈来实现链表由后向前遍历
     *
     * @param list1
     * @param list2
     * @return
     */
    public static Node findFirstCommonNode1(Node list1, Node list2) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        while (list1 != null) {
            stack1.push(list1);
            list1 = list1.next;
        }

        while (list2 != null) {
            stack2.push(list2);
            list2 = list2.next;
        }
    }


    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
