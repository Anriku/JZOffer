package jzoffer.chapter6;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子。即这5张牌是不是连续的。2～10为数字本身，A为1、J为11、Q为12、K为13、大小王为任意数。
 *
 * 思路：大小王就以0来进行代替。然后对数组进行排序。先获取前面0的个数，再获取后面连续数字中有多少间隔。如果0个数大于等于间隔数就是顺子。
 * 其中判断间隔的过程中要进行对子的判断，如果有对子就肯定不是顺子。
 */
public class ContinuousCards {

    public static void main(String[] args) {
        int[] cards = {1, 0, 3, 4, 5};
        System.out.println(isContinuous(cards));
    }

    public static boolean isContinuous(int[] cards) {
        // 首先进行排序
        Arrays.sort(cards);
        int zeros = 0;
        int gaps = 0;

        for (int i = 0; i < cards.length && cards[i] == 0; i++) {
            zeros++;
        }

        int small = zeros;
        int big = small + 1;

        while (big < cards.length) {
            if (cards[small] == cards[big]) {
                return false;
            }

            gaps += cards[big] - cards[small] - 1;
            big++;
            small++;
        }

        return zeros >= gaps;
    }
}
