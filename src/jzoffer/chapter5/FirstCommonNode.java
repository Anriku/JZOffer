package jzoffer.chapter5;

import java.util.Stack;

/**
 * 输入两个链表，找出他们第一个公共节点。
 *
 * 扩展题目：找出二叉树中两个叶节点的最低公共节点。
 */
public class FirstCommonNode {

	public static void main(String[] args) {
		Node list1 = new Node(1);
		Node list2 = new Node(4);
		list1.next = new Node(2);
		list1.next.next = new Node(3);
		list1.next.next.next = new Node(6);
		list1.next.next.next.next = new Node(7);
		list2.next = new Node(5);
		list2.next.next = list1.next.next.next;

		Node m1 = findFirstCommonNode1(list1, list2);
		System.out.println(m1.value);
		Node m2 = findFirstCommonNode2(list1, list2);
		System.out.println(m2.value);
	}

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
        Node firstCommonNode = null;

        while (list1 != null) {
            stack1.push(list1);
            list1 = list1.next;
        }

        while (list2 != null) {
            stack2.push(list2);
            list2 = list2.next;
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
        	Node n1 = stack1.pop();
        	Node n2 = stack2.pop();
        	if (n1.value == n2.value) {
        		firstCommonNode = n1;
        	} else {
        		return firstCommonNode;
        	}
        }

        return firstCommonNode;
    }

    /**
     * 先移动长链表使其剩余部分长度等于短链表
     * 
     * @param list1
     * @param list2
     * @return
     */
    public static Node findFirstCommonNode2(Node list1, Node list2) {
    	int len1 = getListLength(list1);
    	int len2 = getListLength(list2);
    	int distance = 0;
    	Node longList, shortList;

    	if (len1 > len2) {
    		distance = len1 - len2;
    		longList = list1;
    		shortList = list2;
    	} else {
    		distance = len2 - len1;
    		longList = list2;
    		shortList = list1;
    	}

    	for (int i = 0; i < distance; i++) {
    		longList = longList.next;
    	}

    	while (longList != null && shortList != null && longList.value != shortList.value) {
    		longList = longList.next;
    		shortList = shortList.next;

    	}

    	return shortList;

    }

    public static int getListLength(Node list) {
    	int len = 0;
    	while (list != null) {
    		len++;
    		list = list.next;
    	}
    	return len;
    }


    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
