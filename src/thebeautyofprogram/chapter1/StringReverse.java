package thebeautyofprogram.chapter1;

import java.util.Arrays;

/**
 * 字符串反转。比如:abcdef转换为defabc
 */
public class StringReverse {


    public static void main(String[] args) {

        char[] text = new char[100];
        text[0] = 'I';
        text[1] = ' ';
        text[2] = 'a';
        text[3] = 'm';
        text[4] = ' ';
        text[5] = 'a';
        text[6] = ' ';
        text[7] = 's';
        text[8] = 't';
        text[9] = 'u';
        text[10] = 'd';
        text[11] = 'e';
        text[12] = 'n';
        text[13] = 't';
        reverseString(text, 6, 14);
        System.out.println(Arrays.toString(text));
    }

    /**
     * @param text 需要交换的字符串
     * @param m    前多少个字符需要交换
     * @param n    包含字符部分的长度
     */
    public static void reverseString(char[] text, int m, int n) {
        reverse(text, 0, m - 1);
        reverse(text, m, n - 1);
        reverse(text, 0, n - 1);
    }

    /**
     * @param text 需要反转的字符数组
     * @param s    交换开始index
     * @param e    交换结束index
     */
    public static void reverse(char[] text, int s, int e) {
        while (s < e) {
            System.out.println(s);
            char temp = text[s];
            text[s++] = text[e];
            text[e--] = temp;
        }
    }

}
