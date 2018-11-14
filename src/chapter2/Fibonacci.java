package chapter2;

/**
 * Fibonacci数列
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(getNInFibonacci(1000000L));
    }


    public static long getNInFibonacci(long n) {
        if (n < 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        long first = 1, second = 0;
        long result = 0;

        for (long i = 2; i <= n; i++) {
            result = first + second;
            second = first;
            first = result;
        }
        return result;
    }

}
