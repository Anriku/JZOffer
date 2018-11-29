package thebeautyofprogram.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大连续子数组
 * <p>
 * 比如：1, -2, 3, 10, -4, 7, 2, -5。最长子数组为3, 10, -4, 7, 2
 */
public class TheMaximumChildArray {

    public static void main(String[] args) {
        int[] num = {1, -2, 3, 10, -4, 7, 2, -5};
        List<Integer> list = findMaximumChildArray(num);
        for (int i :
                list) {
            System.out.println(i);
        }
    }

    public static List<Integer> findMaximumChildArray(int[] num) {
        int maxSum = num[0];
        List<Integer> list = new ArrayList<>();
        list.add(num[0]);

        for (int i = 1; i < num.length - 1; i++) {
            if (maxSum < 0) {
                maxSum = num[i];
                list.clear();
                list.add(num[i]);
            } else {
                maxSum += num[i];
                list.add(num[i]);
            }
        }
        return list;
    }

}
