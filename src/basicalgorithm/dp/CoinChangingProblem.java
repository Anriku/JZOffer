package basicalgorithm.dp;

import java.util.Scanner;

/**
 * 现有面值为c1,c2,...,cm元的m种硬币，求支付n元时所需硬币最少的枚数。各面值的硬币可重复使用任意次。
 */
public class CoinChangingProblem {

    public static void main(String[] args) {
        System.out.println(getMin());
    }

    public static int getMin() {
        Scanner scanner = new Scanner(System.in);
        // m表示有m种硬币，n表示所需支付的总金额
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        // values用来存储各种硬币的面值
        int values[] = new int[m];
        // results用来存储某一行所得的最优解
        int results[] = new int[n + 1];

        for (int i = 0; i < m; i++) {
            values[i] = scanner.nextInt();
        }

        // 初始化results
        for (int i = 1; i <= n; i++) {
            results[i] = Integer.MAX_VALUE;
        }
        // index为0处初始化为0，因为需要支付0元的组合本身就没有
        results[0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n - values[i]; j++) {
                results[j + values[i]] = Math.min(results[j + values[i]], results[j] + 1);
            }
        }
        return results[n];
    }

}
