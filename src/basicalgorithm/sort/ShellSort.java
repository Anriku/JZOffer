package basicalgorithm.sort;

/**
 * 希尔排序
 * 最好：O(n<sub>1.3</sub>)；最坏：O(n<sub>2</sub>)
 * 稳定性：不稳定
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {0, 1, 3, 2, 20, 35, 23, 3, 6, 3, 6, 10};
        sort(array);
        for (int i :
                array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] array) {
        // index为0处不存元素。
        int increment = array.length - 1;

        do {
            increment = increment / 3 + 1;
            for (int i = increment + 1; i < array.length; i++) {
                if (array[i] < array[i - increment]) {
                    array[0] = array[i];
                    int j;
                    for (j = i - increment; j > 0 && array[j] > array[0] ; j = j - increment) {
                        array[j + increment] = array[j];
                    }
                    array[j + increment] = array[0];
                }
            }

        } while (increment > 1);
    }
}
