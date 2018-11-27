package thebeautyofprogram.chapter1;

/**
 * 字符串包含。
 *
 * 给定字符串a、b。快速判断b中的每个字符是否在a中都有
 */
public class StringContain {


    public static void main(String[] args) {
        System.out.println(stringContain("abcdef", "af"));
    }

    /**
     * 这种方法在Android源码中用得很多。因为int有32位，而字符只有26个。因此可以通过位运算来进行字符的存储。
     * 这里相当于一种变种的hash表。
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean stringContain(String a, String b) {
        int hash = 0;

        for (int i = 0; i < a.length(); i++) {
            hash = hash | (1 << (a.charAt(i) - 'A'));
        }
        for (int i = 0; i < b.length(); i++) {
            if ((hash & (1 << (b.charAt(i) - 'A'))) == 0) {
                return false;
            }
        }
        return true;
    }

}
