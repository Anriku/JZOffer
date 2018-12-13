package jzoffer.chapter6;

/**
 * 把n个骰子扔到地上，所有骰子朝上一面的点数之和为s。输入n，打印出s所有的值出现的概率。
 *
 * 思路：使用两个数组进行结果的存储。第i个骰子的所有所能得到的值的范围是i~diceMaxValue * i。取值范围内的某个值j的出现的次数为。
 * 另外一个数组j - 1、j - 2...、j - diceMaxValue所有值想加。
 */
public class DicesProbability {

    public static void main(String[] args) {
        printDicesProbability(6, 2);
    }

    public static void printDicesProbability(int diceMaxValue, int num) {
        int[][] probability = new int[2][];
        double maxProbability = Math.pow(diceMaxValue, num);
        // 使用两个数交换计算
        probability[0] = new int[num * diceMaxValue + 1];
        probability[1] = new int[num * diceMaxValue + 1];

        int flag = 0;

        for (int i = 1; i <= diceMaxValue; i++) {
            probability[flag][i] = 1;
        }

        for (int i = 2; i <= num; i++) {

            // 第i个骰子最小值至少为i,前面的值都清零
            for (int j = 0; j < i; j++) {
                // 通过异或操作实现0、1互换
                probability[1 ^ flag][j] = 0;
            }

            // 第i个骰子最小值至少为i，然后一直计算到num * diceMaxValue最大值。
            for (int j = i; j <= i * diceMaxValue; j++) {
                // 首先将需要存放结果的位置清零
                probability[1 ^ flag][j] = 0;

                // 第j个值是前面的，j - 1、j - 2...、j - diceMaxValue的值的和。
                for (int k = 1; k <= diceMaxValue && k < j; k++) {
                    probability[1 ^ flag][j] += probability[flag][j - k];
                }
            }
            // 数组交换
            flag ^= 1;
        }

        for (int i = num; i <= num * diceMaxValue; i++) {
            System.out.println(i + ":" +probability[flag][i] / maxProbability);
        }
    }

}
