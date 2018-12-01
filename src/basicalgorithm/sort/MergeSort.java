package basicalgorithm.sort;

/**
 * 归并排序
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] array = {10, 1, 3, 2, 20, 35, 23, 3, 6, 3, 6, 10};
        sort(array);
        for (int i :
                array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] array) {
        mSort(array, array, 0, array.length - 1);
    }


    /**
     * 两步：1.分治 2.合并
     *
     *
     * @param array 待排序数组
     * @param re 排序后的数组
     * @param s 待排序数组开始的位置
     * @param e 待排序数组结束的位置
     */
    public static void mSort(int[] array, int[] re, int s, int e) {

        if (s == e) {
            re[s] = array[s];
        } else {
            // 数组长度为什么是array.length。是因为mMerge使用的我们原始用来排序的数组的的数组的index。
            int[] re2 = new int[array.length];
            int m = (e + s) / 2;
            mSort(array, re2, s, m);
            mSort(array, re2, m + 1, e);
            mMerge(re2, re, s, m, e);
        }
    }

    /**
     * 进行归并操作
     * @param array
     * @param re
     * @param s
     * @param m
     * @param e
     */
    private static void mMerge(int[] array, int[] re, int s, int m, int e) {
        int i, j, k;

        for (i = s, j = m + 1, k = s; i <= m && j <= e; k++) {
            if (array[i] >= array[j]) {
                re[k] = array[j++];
            } else if (array[i] < array[j]) {
                re[k] = array[i++];
            }
        }

        while (i <= m) {
            re[k++] = array[i++];
        }

        while (j <= e) {
            re[k++] = array[j++];
        }
    }

}
