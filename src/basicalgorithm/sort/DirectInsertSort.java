package basicalgorithm.sort;

/**
 * 直接插入排序：
 * 最好：O(n)；最坏：O(n<sub>2</sub>)
 * 稳定性：稳定
 */
public class DirectInsertSort {

    public static void main(String[] args) {
        int[] array = {0, 1, 3, 2, 20, 35, 23, 3, 6, 3, 6, 10};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] array) {
        // index为0处不存元素。
        for (int i = 2; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                array[0] = array[i];

                int j;
                for (j = i - 1; array[j] > array[0]; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = array[0];
            }
        }
    }

}
