package jzoffer.chapter4;

import java.util.Stack;

/**
 * 包含最小元素的栈
 */
public class MinStack {

    private static Stack<Integer> stack;
    private static Stack<Integer> minStack;

    public static void main(String[] args) {
        stack = new Stack<>();
        minStack = new Stack<>();

        push(9);
        push(2);
        push(3);
        push(5);
        push(3);
        push(1);

        while (!minStack.isEmpty()) {
            System.out.println(minStack.pop());
        }
    }

    public static void push(int value){
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else if (minStack.peek() > value) {
            minStack.push(value);
        } else if (minStack.peek() < value) {
            minStack.push(minStack.peek());
        }

        stack.push(value);

    }


    public static int pop() {
        minStack.pop();
        return stack.pop();
    }

    public static int min() {
        return minStack.peek();
    }
}
