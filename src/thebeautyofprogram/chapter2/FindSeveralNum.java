package thebeautyofprogram.chapter2;

import java.util.Stack;

/**
 * 寻找和为定值的多个数的所有组合
 */
public class FindSeveralNum {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        findSeveralNum(stack, 6, 6);
    }

    public static void findSeveralNum(Stack<Integer> stack, int sum, int n) {
        if (sum <= 0 || n <= 0) {
            return;
        }

        if (sum == n) {
            for (int i : stack) {
                System.out.println(i);
            }
            System.out.println(n);
            System.out.println("===============================");
        }

        stack.push(n);
        findSeveralNum(stack, sum - n, n - 1);
        stack.pop();
        findSeveralNum(stack, sum, n - 1);
    }

}
