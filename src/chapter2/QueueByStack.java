package chapter2;

import java.util.Stack;


/**
 * 通过两个栈来构建一个数列
 */
public class QueueByStack {


    public static void main(String[] args) {
        CQueue<Integer> cQueue = new CQueue<>();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        cQueue.appendTail(4);

        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());

        cQueue.appendTail(5);
        cQueue.appendTail(6);
        cQueue.appendTail(7);
        cQueue.appendTail(8);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());

    }

    static class CQueue<T> {

        private Stack<T> stack1;
        private Stack<T> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(T t) {
            stack1.push(t);
        }

        public T deleteHead() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }
    }
}
