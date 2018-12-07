package jzoffer.chapter5;

/**
 * 输入一个整数，求从1到n个整数的十进制表示中1出现的次数。
 */
public class NumOfOneBetweenOneToN {

    public static void main(String[] args) {
        System.out.println(getNumOfOneBetweenOneToN(10));
    }

    public static int getNumOfOneBetweenOneToN(int n) {
        if (n <= 0) {
            return 0;
        }

        return getNumOfOneBetweenOneToN(String.valueOf(n), 0);
    }

    /**
     * 以1到21345举例
     *
     * @param n
     * @param s
     * @return
     */
    public static int getNumOfOneBetweenOneToN(String n, int s) {
        int firstDigit = 0;
        int otherDigit = 0;
        int length = n.length() - s;
        int first = n.charAt(s) - '0';

        if (length == 1) {
            if (first > 0) {
                return 1;
            } else {
                return 0;
            }
        }


        // 获取10000到19999中万位为1的个数
        if (first > 1) {
            firstDigit = powInt(10, length - 1);
        } else if (first == 1) {
            firstDigit = Integer.valueOf(n.substring(s + 1)) + 1;
        }

        // 获取1346到21345中后四位中1个数
        otherDigit = first * (length - 1) * powInt(10, length - 2);

        return firstDigit + otherDigit + getNumOfOneBetweenOneToN(n, s + 1);
    }

    public static int powInt(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }
}
