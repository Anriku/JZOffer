package sort;

import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,10,8,3,20,15};

        quickSort(nums, 0, 7);
        for (int i:
             nums) {
            System.out.println(i);
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
        // 注意这里是取start到end中间的index
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
