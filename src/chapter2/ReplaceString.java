package chapter2;

/**
 * 将字符串中空格替换为%20
 */
public class ReplaceString {

    private static void replace(char[] str, int length) {
        int spaceCount = 0;
        int newLength, oldIndex;

        for (int i = 0; str[i] != '\0'; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        newLength = length + spaceCount * 2;

        oldIndex = length - 1;
        for (int newIndex = newLength - 1; newIndex >= 0; oldIndex--, newIndex--) {
            if (str[oldIndex] == ' ') {
                str[newIndex--] = '0';
                str[newIndex--] = '2';
                str[newIndex] = '%';
            } else {
                str[newIndex] = str[oldIndex];
            }
        }
    }

    public static void main(String[] args) {
        char[] str = new char[100];
        str[0] = 'W';
        str[1] = 'e';
        str[2] = ' ';
        str[3] = 'a';
        str[4] = 'r';
        str[5] = 'e';
        str[6] = ' ';
        str[7] = 'h';
        str[8] = 'a';
        str[9] = 'p';
        str[10] = 'p';
        str[11] = 'y';

        replace(str, 12);
        System.out.println(str);
    }

}
