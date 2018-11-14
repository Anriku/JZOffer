package chapter3;

/**
 * 用于打印1到N位数。N的长度不确定因此不能用int、long等来做。这里通过字符数字来解决。
 */
public class PrintfOneToNWithCharArray {

    public static void main(String[] args) {
        printfOneToN(100);
    }

    public static void printfOneToN(int n) {
        char[] num = new char[n];
        for (int i = 0; i < n; i++) {
            num[i] = '0';
        }

        while (increasable(num)) {
            printNumChar(num);
        }
    }

    private static void printNumChar(char[] num) {
        int startIndex = 0;
        while (startIndex < num.length - 1 && num[startIndex] == '0') {
            startIndex++;
        }
        for (int i = startIndex; i < num.length; i++) {
            System.out.print(num[i]);
        }
        System.out.println();
    }

    private static boolean increasable(char[] num) {
        int carryOut = 0;
        boolean increasable = true;

        for (int i = num.length - 1; i >= 0; i--) {
            int numI = num[i] - '0' + carryOut;
            if (i == num.length - 1) {
                numI++;
            }

            if (numI >= 10) {
                if (i == 0) {
                    increasable = false;
                } else {
                    carryOut = 1;
                    numI -= 10;
                    num[i] = (char) (numI + '0');
                }
            } else {
                num[i] = (char) (numI + '0');
                break;
            }
        }
        return increasable;
    }

}
