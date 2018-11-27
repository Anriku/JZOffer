package JZOffer.chapter2;

/**
 * 自定义整数次方幂
 */
public class CustomPow {

    private static boolean mIsValidate = true;

    public static void main(String[] args) {
        System.out.println(pow(2, -1));
    }

    public static double pow(double base, int exponent) {
        mIsValidate = true;

        if (doubleEqual(base ,0.0) && exponent < 0) {
            mIsValidate = false;
            return 0d;
        }

        int ex = exponent;
        if (exponent < 0) {
            ex = -exponent;
        }
        double result = powExponent(base, ex);

        if (exponent < 0) {
            result = 1d / result;
        }
        return result;
    }

    public static double powExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        // 移位相当于除以2
        double result = powExponent(base, exponent >> 1);
        result *= result;

        // 如果exponent为奇数就还得x base。
        if ((exponent & 1) == 1){
            result *= base;
        }

        return result;
    }

    public static boolean doubleEqual(double a, double b) {
        return a - b > -0.0000001 && a - b < 0.0000001;
    }
}
