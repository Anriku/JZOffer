package jzoffer.chapter5;

import java.util.Arrays;

/**
 * 输入一个正整数数组，把数组里所有数字拼成一个数，打印能拼出的所有数字中最小的一个。
 * 如：3, 32, 321拼成的最小数字为321323
 *
 * 其实相当于一种贪心算法，这个需要证明子问题最小就能得到最终的结果最小
 */
public class MinNumber {

    public static void main(String[] args) {
        int[] num = {3, 32, 321};
        System.out.println(getMinNumber(num));
    }

    public static String getMinNumber(int[] num) {
        String[] strNum = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            strNum[i] = String.valueOf(num[i]);
        }

        Arrays.sort(strNum, (str1, str2) -> {
            String strCombine1 = str1 + str2;
            String strCombine2 = str2 + str1;
            return strCombine1.compareTo(strCombine2);
        });
        StringBuilder sb = new StringBuilder();
        for (String str : strNum) {
            sb.append(str);
        }
        return sb.toString();
    }

}
