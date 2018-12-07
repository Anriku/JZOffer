package jzoffer.chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

/**
 * 输入n个整数，找出其中最小的k个数。
 * 比如：输入4, 5, 1, 6, 2, 7, 3, 8
 * 最小的4个数为1, 2, 3, 4
 */
public class LeastNumbers {


    public static void main(String[] args) {
        int[] num = {4, 5, 1, 6, 2, 7, 3, 8};
//        getLeastNumbers1(num, 4);
//        for (int i = 0; i < 4; i++) {
//            System.out.println(num[i]);
//        }
//        System.out.println();

        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2);
            }
        });

        getLeastNumbers2(num, treeSet, 4);
        for (Integer i :
                treeSet) {
            System.out.println(i);
        }
    }


    /**
     * 用TreeSet进行保存最小的k个值。
     * TreeSet的size小于k时直接添加进入。
     * TreeSet满后，与TreeSet中的最大判断。当前值小的话就进行替换。
     *
     * 这种方法适合处理数据大的情况。时间复杂度为O(nlogk)
     *
     * @param num
     * @param treeSet
     * @param k
     */
    public static void getLeastNumbers2(int[] num, TreeSet<Integer> treeSet, int k) {

        for (int i : num) {
            if (treeSet.size() < k) {
                treeSet.add(i);
                continue;
            }
            if (treeSet.first() > i) {
                treeSet.pollFirst();
                treeSet.add(i);
            }
        }
    }

    /**
     * 使用快排思想解决。平均复杂度为O(n)。适合处理数据量小的数据。
     *
     * @param num
     * @param k
     */
    public static void getLeastNumbers1(int[] num, int k) {
        if (num.length <= k) {
            return;
        }

        int index = partition(num, 0, num.length - 1);
        int start = 0;
        int end = num.length - 1;

        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(num, start, end);
        }
    }

    public static int partition(int[] num, int s, int e) {

        int index = (new Random()).nextInt(e - s + 1) + s;
        swap(num, e, index);

        int small = s - 1;

        for (int i = s; i < e; i++) {
            if (num[s] < num[e]) {
                small++;
                if (small != i) {
                    swap(num, i, small);
                }
            }
        }
        small++;
        swap(num, small, e);
        return small;
    }

    public static void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }

}
