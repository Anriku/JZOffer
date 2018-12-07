package basicalgorithm.dp;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w, h;
        Rect[][] rects;
        h = scanner.nextInt();
        w = scanner.nextInt();
        rects = new Rect[h][w + 1];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j <= w; j++) {
                if (j == w) {
                    rects[i][j] = new Rect(0, w);
                } else {
                    int status = scanner.nextInt();

                    rects[i][j] = new Rect(status, w);
                }
            }
        }

        System.out.println(getLargestRectangle(rects, w, h));
    }

    public static int getLargestRectangle(Rect[][] rects, int w, int h) {
        // 更新范围内每一小方块的值
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (rects[j][i].height == 0) {
                    rects[j][i].height = j > 0 ? (rects[j - 1][i].height + 1) : 1;
                } else {
                    rects[j][i].height = 0;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < h; i++) {
            max = Math.max(max, getLargestRectangle(rects[i]));
        }
        return max;
    }

    public static int getLargestRectangle(Rect[] rects) {
        int maxArea = 0;
        Stack<Rect> stack = new Stack<>();

        for (int i = 0; i < rects.length; i++) {
            rects[i].pos = i;
            if (stack.isEmpty()) {
                stack.push(rects[i]);
            } else {
                if (rects[i].height > stack.peek().height) {
                    stack.push(rects[i]);
                } else if (rects[i].height < stack.peek().height) {
                    int pos = i;
                    int minHeight = Integer.MAX_VALUE;
                    while (!stack.isEmpty() && rects[i].height <= stack.peek().height) {
                        Rect rect = stack.pop();
                        pos = rect.pos;
                        minHeight = Math.min(minHeight, rect.height);
                    }
                    maxArea = Math.max(maxArea, (i - pos) * minHeight);
                    rects[i].pos = pos;
                    stack.push(rects[i]);
                }
            }
        }
        return maxArea;
    }

    static class Rect {
        int height;
        int pos;

        public Rect(int height, int pos) {
            this.height = height;
            this.pos = pos;
        }
    }
}
