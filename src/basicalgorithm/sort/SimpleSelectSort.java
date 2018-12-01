package basicalgorithm.sort;

/**
 * 简单选择排序。
 * 最好，最坏都是O(n<sub>2</sub>)。
 * 稳定性：稳定
 */
public class SimpleSelectSort {

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 20, 35, 23, 3, 6, 3, 6, 10};
        sort(array);
        for (int i :
                array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

}
