package basicalgorithm.dp;

/**
 * 最长递增子序列
 * <p>
 * 1:可以用排序后的序列和没排序的序列一起求最长公共子序列
 * <p>
 * 2:动态规划
 * <p>
 * 3.动态规划+二分搜索
 */
public class LIS {


    public static void main(String[] args) {
        int[] sequence = {5, 1, 3, 2, 4};
        int[] indexs = new int[5];

        System.out.println(getMaxLength(sequence, indexs));
    }

    /**
     * 动态规划求解
     *
     * @param sequence
     * @param indexs
     * @return
     */
    public static int getMaxLength(int[] sequence, int[] indexs) {
        int[] maxLengths = new int[sequence.length];
        maxLengths[0] = 0;
        sequence[0] = -1;
        indexs[0] = -1;
        int k = 0;

        for (int i = 1; i < sequence.length; i++) {
            k = 0;
            for (int j = 1; j < i - 1; j++) {
                if (sequence[j] < sequence[i] && maxLengths[j] > maxLengths[k]) {
                    k = j;
                }
            }
            maxLengths[i] = maxLengths[k] + 1;
            indexs[i] = k;
        }

        int maxLength = 0;
        for (int i = 0; i < maxLengths.length; i++) {
            if (maxLengths[i] > maxLength) {
                maxLength = maxLengths[i];
            }
        }
        return maxLength;
    }

}
