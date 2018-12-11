package jzoffer.chapter5;

/**
 * 我们把只包含质数因子2、3和5的数称为丑数。求按从小到大的顺序的第1500个丑数，但14不是它包含7。
 * 习惯上我们把1作为第一个丑数
 */
public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(getUglyNumber(1500));
    }

    public static int getUglyNumber(int index) {
        int[] uglyNum = new int[index];
        uglyNum[0] = 1;
        int uglyNum2Index = 0;
        int uglyNum3Index = 0;
        int uglyNum5Index = 0;

        for (int i = 1; i < index; i++) {
            int min = min(uglyNum[uglyNum2Index] * 2, uglyNum[uglyNum3Index] * 3, uglyNum[uglyNum5Index] * 5);
            uglyNum[i] = min;

            while (uglyNum[uglyNum2Index] * 2 <= uglyNum[i]) {
                uglyNum2Index++;
            }
            while (uglyNum[uglyNum3Index] * 3 <= uglyNum[i]) {
                uglyNum3Index++;
            }
            while (uglyNum[uglyNum5Index] * 5 <= uglyNum[i]) {
                uglyNum5Index++;
            }
        }
        return uglyNum[index - 1];
    }

    public static int min(int a, int b, int c) {
        int temp = Math.min(a, b);
        return Math.min(temp, c);
    }

}
