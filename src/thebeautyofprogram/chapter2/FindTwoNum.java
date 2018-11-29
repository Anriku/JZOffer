package thebeautyofprogram.chapter2;

import java.util.Random;

/**
 * 寻找数值中和为定值的两个数
 */
public class FindTwoNum {

    public static void main(String[] args) {
        int[] num = {11, 15, 1, 2, 4, 5, 7};
        findTowNum(num, 15);
    }

    public static void findTowNum(int[] num, int sum) {
        quickSort(num, 0, num.length - 1);
        int start = 0, end = num.length - 1;
        while (start < end) {
            int re = num[start] + num[end];
            if (re == sum) {
                System.out.println("num1 is " + num[start] + ", num2 is " + num[end]);
                break;
            } else if (re < sum) {
                start++;
            } else {
                end--;
            }
        }
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }

        int index = partition(nums, start, end);
        if (index > start) {
            quickSort(nums, start, index - 1);
        }
        if (index < end) {
            quickSort(nums, index + 1, end);
        }
    }

    public static int partition(int[] nums, int start, int end) {

        Random random = new Random();
        int index = random.nextInt(end - start + 1) + start;
        swap(nums, index, end);

        // small指向的是上一个小于枢纽元素的的元素
        int small = start - 1;

        for (index = start; index < end; index++) {
            if (nums[index] < nums[end]) {
                small++;
                if (small != index) {
                    swap(nums, small, index);
                }
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }

    private static void swap(int[] nums, int index, int end) {
        int temp = nums[index];
        nums[index] = nums[end];
        nums[end] = temp;
    }

}
