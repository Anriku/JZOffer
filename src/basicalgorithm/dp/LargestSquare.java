package basicalgorithm.dp;

import java.util.Scanner;

/**
 * 有一个H x W各边长为1cm的正方形瓷砖排列在一起，其中gh有一部分转有污渍。
 * 求干净的瓷砖构成的最大正方形面积
 * <p>
 * 输入：1有污渍。0干净
 */
public class LargestSquare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();

        int[][] area = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                area[i][j] = scanner.nextInt();
            }
        }

        System.out.println(getLargestSquare(area, h, w));

    }

    public static int getLargestSquare(int[][] area, int h, int w) {
        int maxWidth = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                area[i][j] = (area[i][j] + 1) % 2;

                // i = 0 或j = 0情况在后不会考虑到这里进行处理
                maxWidth |= area[i][j];
            }
        }

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (area[i][j] == 1) {
                    int minWidth = Math.min(area[i - 1][j], area[i][j - 1]);
                    minWidth = Math.min(area[i - 1][j - 1], minWidth);

                    area[i][j] = minWidth + 1;
                    maxWidth = Math.max(area[i][j], maxWidth);
                }
            }
        }

        return maxWidth * maxWidth;
    }

}
