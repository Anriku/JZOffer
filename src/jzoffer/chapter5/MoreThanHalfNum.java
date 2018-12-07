package jzoffer.chapter5;

import java.util.Random;

/**
 * 数组有一个数字出现次数超过了一半，请找出这个数字。
 */
public class MoreThanHalfNum {


    public static void main(String[] args) {
        int[] num = {1, 2, 3, 2 ,2 ,2 ,5, 4, 2};
        System.out.println(getMoreThanHalfNum1(num));
        System.out.println(getMoreThanHalfNum2(num));
    }

    /**
     * 借助于快排的思想进行寻找
     *
     * @param num
     * @return
     */
    public static int getMoreThanHalfNum1(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        int middle = num.length >> 1;
        int start = 0;
        int end = num.length - 1;
        int index = partition(num, start, end);

        while (middle != index) {
            if (index > middle) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(num, start, end);
        }

        return num[middle];
    }

    public static int partition(int[] num, int s, int e) {
        int index = (new Random()).nextInt(e + 1 - s) + s;
        swap(num, index, e);

        int small = s - 1;
        for (int i = s; i < e; i++) {
            if (num[i] < num[e]) {
                small++;
                swap(num, small, i);
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


    /**
     * 根据数组的特点进行寻找
     *
     * @param num
     * @return
     */
    public static int getMoreThanHalfNum2(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        int result = num[0];
        int times = 1;

        for (int i = 1; i < num.length; i++) {
            if (result == num[i]) {
                times++;
            } else {
                if (times == 0) {
                    result = num[i];
                    times = 1;
                } else {
                    times--;
                }
            }
        }
        return result;
    }
}
