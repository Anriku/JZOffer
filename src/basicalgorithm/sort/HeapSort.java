package basicalgorithm.sort;

/**
 * 堆排序
 * 最好、最坏和平均时间复杂度都是O(nlogn).
 * 其中构建堆的复杂度为O(n)
 * 其中重建堆的复杂度为O(nlogn)
 * <p>
 * 不稳定
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {10, 1, 3, 2, 20, 35, 23, 3, 6, 3, 6, 10};
        sort(array);
        for (int i :
                array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] array) {

        for (int i = (array.length - 1) / 2; i >= 1; i--) {
            heapAdjust(array, i, array.length - 1);
        }

        for (int i = array.length - 1; i > 1; i--) {
            swap(array, i);
            heapAdjust(array, 1, i - 1);
        }

    }

    private static void swap(int[] array, int i) {
        int temp = array[1];
        array[1] = array[i];
        array[i] = temp;
    }

    /**
     * 进行大根堆的调整
     *
     * @param array
     * @param s     开始调整的节点
     * @param e     结束调整的节点
     */
    public static void heapAdjust(int[] array, int s, int e) {

        int temp = array[s];

        for (int i = s * 2; i <= e; i = i * 2) {

            // 两个孩子哪个大
            if (i < e && array[i] < array[i + 1]) {
                i++;
            }
            // 父节点大于两个孩子，这时此根节点下面的子树已经是大根堆了。
            // 特别注意这里是index为s处的节点。与下面所有节点的比较。
            if (temp >= array[i]) {
                break;
            }
            // 到这一步，说明父节点至少小于最大的一个孩子。这时进行交换
            array[s] = array[i];
            // 然后继续到较大孩子处去将下面的子树也做成大根堆
            s = i;
        }
        array[s] = temp;
    }

}
