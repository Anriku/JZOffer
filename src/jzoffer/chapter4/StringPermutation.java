package jzoffer.chapter4;

/**
 * 字符串的全排序。
 */
public class StringPermutation {

    public static void main(String[] args) {
        char[] string = {'a', 'b', 'c'};
        permutation(string, 0);
    }

    public static void permutation(char[] string, int begin) {
        if (begin == string.length) {
            for (char c : string) {
                System.out.print(c);
            }
            System.out.println();
        } else {
            for (int i = begin; i < string.length; i++) {
                swap(string, i, begin);
                permutation(string, begin + 1);
                swap(string, i, begin);
            }
        }
    }

    public static void swap(char[] string, int a, int b) {
        char temp = string[a];
        string[a] = string[b];
        string[b] = temp;
    }

}
