package basicalgorithm.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 0-1背包问题
 */
public class KnapsackProblem {

    public static final int TOP = 0;
    public static final int DIAGONAL = 1;


    public static void main(String[] args) {
        List<Item> list = new ArrayList<>();
        System.out.println(getMaxValue(list));
        for (Item item : list) {
            System.out.println(item);
        }
    }

    public static int getMaxValue(List<Item> list) {

        Scanner scanner = new Scanner(System.in);
        // m表示有多少种物品。n表示背包的最大承重量
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // path获取最大值种经过的情况
        int[][] path = new int[m + 1][n + 1];
        // results用于记录当前行以及上一行的获取的最优解
        int[][] results = new int[m + 1][n + 1];
        // items记录各个物品的属性
        Item[] items = new Item[m];

        // 输入物品
        for (int i = 0; i < m; i++) {
            int value = scanner.nextInt();
            int weight = scanner.nextInt();

            items[i] = new Item(weight, value);
        }

        // 让第一行为0
        for (int i = 0; i <= n; i++) {
            results[0][i] = 0;
        }
        // 让第一列为0
        for (int i = 1; i <= m; i++) {
            results[i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                results[i][j] = results[i - 1][j];
                path[i][j] = TOP;

                Item item = items[i - 1];
                // 如果物品重量大于当前承重，肯定不能装直接继续下面的。
                if (item.weight > j) {
                    continue;
                }

                if ((results[i - 1][j - item.weight] + item.value) > results[i - 1][j]) {
                    results[i][j] = results[i - 1][j - item.weight] + item.value;
                    path[i][j] = DIAGONAL;
                }
            }
        }

        for (int i = m, j = n; i > 0; i--) {
            if (path[i][j] == DIAGONAL) {
                list.add(items[i - 1]);
                j = n - items[i - 1].weight;
            }
        }
        return results[m][n];
    }

    static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "weight=" + weight +
                    ", value=" + value +
                    '}';
        }
    }


}
