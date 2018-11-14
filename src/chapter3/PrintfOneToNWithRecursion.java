package chapter3;

/**
 * 使用全排序来进行1到N位数的打印
 */
public class PrintfOneToNWithRecursion {

    public static void main(String[] args) {
        printOneToN(2);
    }

    public static void printOneToN(int n) {
        char[] num = new char[n];
        for (int i = 0; i < n; i++) {
            num[i] = '0';
        }
        printfWithRecursion(num, 0);
    }

    public static void printfWithRecursion(char num[], int index) {
        if (index == num.length) {
            printNumChar(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            num[index] = (char) (i + '0');
            printfWithRecursion(num, index + 1);
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

}
