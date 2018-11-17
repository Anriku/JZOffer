package chapter4;

/**
 * 顺时针打印矩阵
 */
public class ClockwisePrintMatrix {


    public static void main(String[] args) {
        int[][] martix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
        };

        printMatrix(martix, 4, 5, 0);
    }

    public static void printMatrix(int[][] matrix, int rows, int columns, int start) {

        if (rows <= 0 || columns <= 0) {
            return;
        }

        while (2 * start < rows && 2 * start < columns) {
            printNums(matrix, rows, columns, start);

            start++;
        }

    }

    private static void printNums(int[][] matrix, int rows, int columns, int start) {

        int endRow = rows - 1 - start;
        int endColumn = columns - 1 - start;

        // 从左打印到右
        for (int i = start; i <= endColumn; i++) {
            System.out.println(matrix[start][i]);
        }

        // 从上打印到下
        if (start < endRow) {
            for (int i = start + 1; i <= endRow; i++) {
                System.out.println(matrix[i][endColumn]);
            }

            // 从右到左
            if (start < endColumn) {
                for (int i = endColumn - 1; i >= start; i--) {
                    System.out.println(matrix[endRow][i]);
                }

                // 从下到上
                if (start < endRow - 1) {
                    for (int i = endRow - 1; i > start; i--) {
                        System.out.println(matrix[i][start]);
                    }
                }
            }
        }

    }

}
