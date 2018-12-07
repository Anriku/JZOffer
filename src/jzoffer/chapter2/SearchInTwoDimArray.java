package jzoffer.chapter2;

/**
 * 一个下面例子中的特点的数组。输入某个数在其中进行查询
 */
public class SearchInTwoDimArray {

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 2},
                {4, 7, 10, 13},
                {6, 8, 11, 15},
        };

        System.out.println(findNum(array, 4, 4, 1));
    }

    private static boolean findNum(int[][] array, int rows, int columns, int searchNum) {
        int startRow = 0;
        int endColumn = columns - 1;

        boolean isFind = false;

        while (startRow < rows && endColumn >= 0) {
            if (searchNum < array[startRow][endColumn]) {
                endColumn--;
            } else if (searchNum > array[startRow][endColumn]) {
                startRow++;
            } else {
                isFind = true;
                break;
            }
        }

        return isFind;
    }

}
