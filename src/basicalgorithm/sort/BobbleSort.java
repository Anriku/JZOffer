package basicalgorithm.sort;

/**
 * 冒泡排序：
 * 第3种方法：最好：O(n)；最坏：O(n<sub>2</sub>)
 * 稳定性：稳定
 */
public class BobbleSort {

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 20, 35, 23, 3, 6, 3, 6, 10};
        sort3(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 毫无优化的方法
     *
     * @param array
     */
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 由后向前相邻元素两两对比的排序。
     *
     * @param array
     */
    public static void sort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }


    /**
     * 如果某此由后向前的过程中都没由发生数据的交换就说明已经拍好序了。这时就跳出循环。
     *
     * @param array
     */
    public static void sort3(int[] array) {
        boolean isSorted = false;
        for (int i = 0; i < array.length && !isSorted; i++) {
            isSorted = true;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    isSorted = false;
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
