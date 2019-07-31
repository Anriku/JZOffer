package jzoffer.chapter5;

/**
 * 在数组中有两个数字，如果前面一个大于后面一个数字，则这两个数字组成一个逆序对。
 * 输入一个数字求出数组中逆序对的总数。
 */
public class InversePairs {


    public static void main(String[] args) {
        int[] num = {8, 5, 6, 7};
        System.out.println(mSort(num, num, 0, num.length - 1));
    }

    public static int mSort(int[] array, int[] re, int s, int e) {
        int count = 0;
        if (s == e) {
            re[s] = array[s];
        } else {
            int m = (e + s) / 2;
            int[] re2 = new int[array.length];
            count += mSort(array, re2, s, m);
            count += mSort(array, re2, m + 1, e);
            count += mMerge(re2, re, s, m, e);
        }
        return count;
    }

    private static int mMerge(int[] array, int[] re, int s, int m, int e) {
        int i, j, k;
        int count = 0;
        for (i = m, j = e, k = e; i >= s && j >= m + 1; k--) {
            if (array[i] > array[j]) {
                count = count + j - m;
                re[k] = array[i--];
            } else {
                re[k] = array[j--];
            }
        }

        while (i >= s) {
            re[k--] = array[i--];
        }
        while (j >= m + 1) {
            re[k--] = array[j--];
        }

        return count;
    }

}
